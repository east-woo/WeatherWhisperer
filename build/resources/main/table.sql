-- Table to store user information
CREATE TABLE users (
                       user_id SERIAL PRIMARY KEY,
                       username VARCHAR(50) NOT NULL,
                       chat_id INT NOT NULL,
                       CONSTRAINT unique_username UNIQUE (username),
                       CONSTRAINT unique_chat_id UNIQUE (chat_id)
);

-- Table to store user locations
CREATE TABLE user_locations (
                                location_id SERIAL PRIMARY KEY,
                                user_id INT REFERENCES users(user_id) ON DELETE CASCADE,
                                location_name VARCHAR(100) NOT NULL,
                                latitude DECIMAL(9,6) NOT NULL,
                                longitude DECIMAL(9,6) NOT NULL
);

-- Table to store scheduled notifications
CREATE TABLE notifications (
                               notification_id SERIAL PRIMARY KEY,
                               user_id INT REFERENCES users(user_id) ON DELETE CASCADE,
                               location_id INT REFERENCES user_locations(location_id) ON DELETE CASCADE,
                               notification_time TIME NOT NULL
);

-- Table to store weather information
CREATE TABLE weather_data (
                              weather_id SERIAL PRIMARY KEY,
                              location_id INT REFERENCES user_locations(location_id) ON DELETE CASCADE,
                              temperature DECIMAL(5,2) NOT NULL,
                              condition VARCHAR(50) NOT NULL,
                              observation_time TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE public.telegram_bot_info (
                                          bot_token varchar NOT NULL,
                                          chat_id int8 NOT NULL
);

CREATE TABLE tb_weather_area (
                                 ADMDST_CD VARCHAR(50) NOT NULL,
                                 STDG_CTPV VARCHAR(50) NOT NULL,
                                 STDG_SGG VARCHAR(50) NULL DEFAULT NULL,
                                 STDG_EMD VARCHAR(50) NULL DEFAULT NULL,
                                 GRID_X VARCHAR(50) NOT NULL,
                                 GRID_Y VARCHAR(50) NOT NULL,
                                 LOT_HR VARCHAR(50) NOT NULL,
                                 LOT_MINT VARCHAR(50) NOT NULL,
                                 LOT_SCND VARCHAR(50) NOT NULL,
                                 LAT_HR VARCHAR(50) NOT NULL,
                                 LAT_MINT VARCHAR(50) NOT NULL,
                                 LAT_SCND VARCHAR(50) NOT NULL,
                                 LOT_MLLS VARCHAR(50) NOT NULL,
                                 LAT_MLLS VARCHAR(50) NOT NULL
);

COMMENT ON TABLE tb_weather_area IS '엑셀 파일 값의 데이터베이스를 포함하는 테이블';
COMMENT ON COLUMN tb_weather_area.ADMDST_CD IS '행정 지역 코드';
COMMENT ON COLUMN tb_weather_area.STDG_CTPV IS '시도';
COMMENT ON COLUMN tb_weather_area.STDG_SGG IS '시, 군, 구';
COMMENT ON COLUMN tb_weather_area.STDG_EMD IS '읍, 면, 동';
COMMENT ON COLUMN tb_weather_area.GRID_X IS '그리드 X';
COMMENT ON COLUMN tb_weather_area.GRID_Y IS '그리드 Y';
COMMENT ON COLUMN tb_weather_area.LOT_HR IS '경도 (시)';
COMMENT ON COLUMN tb_weather_area.LOT_MINT IS '경도 (분)';
COMMENT ON COLUMN tb_weather_area.LOT_SCND IS '경도 (초)';
COMMENT ON COLUMN tb_weather_area.LAT_HR IS '위도 (시)';
COMMENT ON COLUMN tb_weather_area.LAT_MINT IS '위도 (분)';
COMMENT ON COLUMN tb_weather_area.LAT_SCND IS '위도 (초)';
COMMENT ON COLUMN tb_weather_area.LOT_MLLS IS '경도 (초/100)';
COMMENT ON COLUMN tb_weather_area.LAT_MLLS IS '위도 (초/100)';
