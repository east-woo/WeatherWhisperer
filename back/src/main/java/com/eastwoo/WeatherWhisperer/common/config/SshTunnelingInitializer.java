package com.eastwoo.WeatherWhisperer.common.config;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import jakarta.annotation.PreDestroy;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;


import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Slf4j
@Profile("dev")
@Component
@ConfigurationProperties(prefix = "ssh")
@Validated
@Setter
public class SshTunnelingInitializer {

    private String host;
    private String user;
    private int sshPort;
    private String privateKey;
    private int databasePort;
    private String databaseEndpoint;

    private Session session;

    @PreDestroy
    public void closeSSH() {
        if (session != null && session.isConnected())
            session.disconnect();
    }
    private static void searchFile(File directory, String fileName, List<String> filePaths) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    searchFile(file, fileName, filePaths);
                } else if (file.getName().equals(fileName)) {
                    filePaths.add(file.getAbsolutePath());
                }
            }
        }
    }

    public Integer buildSshConnection() {

        Integer forwardedPort = null;

        String projectDir = System.getProperty("user.dir");
        String targetDirName = "WeatherWhisperer_private"; // 찾고자 하는 폴더 이름
        String fileName = privateKey;
        String absoluteFilePath = null;
        List<String> filePaths = new ArrayList<>();
        searchFile(new File(projectDir + File.separator + targetDirName), fileName, filePaths);

        if (filePaths.isEmpty()) {
            log.info("프로젝트 내 " + targetDirName + " 폴더 안에서 파일을 찾을 수 없습니다.");
        } else {
            log.info("프로젝트 내 " + targetDirName + " 폴더 안에서 찾은 파일 경로:");
            for (String filePath : filePaths) {
                absoluteFilePath = filePath;
            }
        }

        try {
            log.info("{}@{}:{}:{} with privateKey",user, host, sshPort, databasePort);

            log.info("start ssh tunneling..");
            JSch jSch = new JSch();

            log.info("creating ssh session");

            jSch.addIdentity(absoluteFilePath);  // 개인키
            session = jSch.getSession(user, host, sshPort);  // 세션 설정
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            log.info("complete creating ssh session");

            log.info("start connecting ssh connection");
            session.connect();  // ssh 연결
            log.info("success connecting ssh connection ");

            // 로컬pc의 남는 포트 하나와 원격 접속한 pc의 db포트 연결
            log.info("start forwarding");
            forwardedPort = session.setPortForwardingL(0, databaseEndpoint, databasePort);
            System.out.println(forwardedPort);
            log.info("successfully connected to database");

        } catch (JSchException e){
            this.closeSSH();
            e.printStackTrace();
            System.out.println(e);
            log.error("fail to make ssh tunneling : {}", e.getMessage());
        }

        return forwardedPort;
    }
}