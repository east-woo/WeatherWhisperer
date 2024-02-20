$(document).ready(function(){


    //모바일 메뉴버튼
    var mobileMenuFlag = true;
    var mobileSearchFlag = false;  //초기엔 비활성화
    $("#mMenuBtn").click(function () {
        if (mobileMenuFlag) {
            $("body").css({ overflow: 'hidden' }).on('touchmove', function (e) { e.preventDefault() });
            $("#mMenuBox").slideDown(250);
            $("#mMenuBtn").children('img').attr('src', '../../images/btn_m_close.png').attr('alt', '메뉴 닫는 버튼');
            mobileMenuFlag = false;
            $("#m_search_dim").hide();
            mobileSearchFlag = false;
        } else {
            $("body").css({ overflow: 'auto' });
            $("body").off('touchmove');
            $("#mMenuBox").slideUp(250);
            $("#mMenuBtn").children('img').attr('src', '../../images/btn_m_menu.png').attr('alt', '메뉴 버튼');
            mobileMenuFlag = true;
            if (mobileSearchFlag) {
                $("#m_search_dim").show();
            } else {
                $("#m_search_dim").hide();
            }
        }
    });

    //모바일 메뉴

    $(".set > a").on("click", function () {
        if ($(this).hasClass("active")) {
            $(this).removeClass("active");
            $(this)
                .siblings(".contentM")
                .slideUp(200);
            $(".set > a")
                .children('img').attr('src', '../../images/ico_plus.png').attr('alt', '메뉴 펼치기');
        } else {
            $(".set > a")
                .children('img').attr('src', '../../images/ico_plus.png').attr('alt', '메뉴 펼치기');
            $(this)
                .removeClass("fa-plus")
                .children('img').attr('src', '../../images/ico_minus.png').attr('alt', '메뉴 닫기');
            $(".set > a").removeClass("active");
            $(this).addClass("active");
            $(".contentM").slideUp(200);
            $(this)
                .siblings(".contentM")
                .slideDown(200);
        }
    });



    $('.icoBtn.view, .btnTabView, .icoBtn.tg').on({
        "click":function (){
            $(this).toggleClass('active');
        }
    })
    $('.cityList ul li').on({
        "click":function (){
            $(this).addClass('active').attr('title','선택됨').siblings('li').removeClass('active').attr('title','');
        }
    })
    $('.search_input').focus(function(){
        $('.search_input').next().css('background-image','url(../../images/icon_search.png)' );
    });
    $('.search_input').blur(function(){
    $('.search_input').next().css('background-image','url(../../images/icon_search_off.png)' );
    });

    /* 지도탭 */
    $('.mapTab li').on({
        'click': function (){
            var target = $('.tabArea .bgBox');
            if($(this).index() === 0){
                target.removeClass('active');
            }else{
                target.addClass('active');
            }
            $(this).addClass('active').attr('title','선택됨').siblings().removeClass('active').attr('title','');
        }
    });

    $('.btnTab, .btnRef, .menuArea .btnMenu, .menuArea li button').on({
        'click': function (){
            $(this).toggleClass('active').siblings().removeClass('active')
        }
    });
    $('.menuArea .btnToggleMenu').on({
        "click":function (){
            $(this).closest('.menuArea').toggleClass('active')
        }
    })
    $('.btnLayer').on({
        "click":function (){
            $('#toc .left').toggleClass('active');
        }
    })
    $('.nameDesc').on({
        "click":function (){
            if(!$(this).hasClass('active')){
                $(this).addClass('active');
                $(this).closest('tr').find('.editDesc, .editName').addClass('active');
            }else{
                $(this).removeClass('active');
                let val = [$(this).closest('tr').find('.editName').val(),$(this).closest('tr').find('.editDesc').val()]
                $(this).closest('tr').find('.editName + p').html(val[0])
                $(this).closest('tr').find('.editDesc + p').html(val[1])
                $(this).closest('tr').find('.editDesc, .editName').removeClass('active');
            }

        }
    })
    $('.pageCount button').on({
        "click":function (){
            $(this).closest('.pageCount').addClass('active');
        }
    })

    /* 즐겨찾기명 수정 */
    // $('.btnEdit').on({
    //     "click":function (){
    //         $(this).closest('.btnEdit').toggleClass('active').siblings('li').removeClass('active');
    //         if ($(this).hasClass('active')){
    //             $('.favName').hide();
    //             $('.favForm').show();
    //         } else {
    //             $('.favName').show();
    //             $('.favForm').hide();
    //         }
    //     }
    // })

    /* accordion */
    $('.accordion li .flex').on({
        "click":function (){
            $(this).closest('li').toggleClass('active').siblings('li').removeClass('active')
        }
    })
    /* utilArea */
    $('.utilArea .btn').on({
        'click': function (){
            $(this).toggleClass('active').siblings('.innerBtn').toggleClass('active');
            $(this).closest('li').siblings('li').children('.btn').removeClass('active').siblings('.innerBtn').removeClass('active').children('button').removeClass('active');
        }
    });
    $('.utilArea .innerBtn button').on({
        'click': function (){
            if($(this).closest('div').hasClass('dep2')){
                $(this).toggleClass('active').siblings('.dep3').toggleClass('active');
                $(this).closest('.dep2').siblings('button').removeClass('active')
            }else{
                $(this).toggleClass('active').siblings('button').removeClass('active');
                $(this).siblings('.dep2').children('button').removeClass('active').siblings('.dep3').removeClass('active');
            }
        }
    });


    /* 탭 토글 */
    $('.tabList li').on({
        "click":function(){
            var idx = $(this).index();
            $(this).addClass('active').attr('title','선택됨').siblings('li').removeClass('active').attr('title','');
            $(this).closest('.tabNav').siblings('.tabCont').removeClass('active').eq(idx).addClass('active');
        }
    });
    /* toc 우측 */
    $('.tocTabList li').on({
        "click":function(){
            var idx = $(this).index();
            $(this).addClass('active').attr('title','선택됨').siblings('li').removeClass('active').attr('title','');
            $(this).closest('.tocTabList').siblings('.tabWrap').removeClass('active').eq(idx).addClass('active');
        }
    });
    /* toc 레이어 정보 닫기 */
    $('.icoBtn.more, .btnTocClose').on({
        "click":function (){
            if($(this).closest('#toc').hasClass('info')){
                $(this).closest('.wrap').find('.right').toggleClass('active');
                /*
                if(!$(this).closest('.right').siblings('.left').hasClass('active')){
                    $(this).closest('#toc').toggleClass('hide');
                }

                 */
            }
        }
    });
    $('.btnLayerView').on({
        "click":function (){
            $(this).toggleClass('hide')
        }
    })
    $('.btn.btnMenu01').on({
        "click":function (){
            $(this).siblings('.innerNotice').toggleClass('active');
        }
    })

    $('.btnSec.seeMore').on({
        "click":function (){
            $(this).closest('li').addClass('hide').siblings('.hideMenu').addClass('show');

        }
    })

    $('.inputBox .btnSquare').on({
        "click":function (){
            $(this).addClass('active').attr('title','선택됨').siblings('.btnSquare').removeClass('active').attr('title','');
        }
    })

    /* toc 열고닫기 */
    $('.btnTocToggle').on({
        "click":function (){
            if($('#toc').hasClass('info')){
                $('#toc').toggleClass('hide');
                $('#toc .wrap > .right').toggleClass('hide');
            }else{
                $('#toc').toggleClass('hide2');

            }
        }
    })
    if($('#sysIntro').value ==='2017'){
        alert('ss')
    }

    /* 테이블영역 열고 닫기*/
    $('.btnLayerToggle').on({
        "click":function (){
            $(this).closest('.sheetView').toggleClass('hide');
        }
    })
    /* 전체메뉴 열기 */
    $('.btnMenu').on({
        "click":function (){
            $('#header').addClass('active');
            $('#menu').addClass('active');
        }
    })
    /* 전체메뉴 닫기*/
    $('.btnMenuClose').on({
        "click":function (){
            $('#header').removeClass('active');
            $('#menu').removeClass('active');
        }
    })
    /* 검은배경 클릭시 팝업닫기*/
    $('#dimmed').on({
        "click":function (){
            $('.popup, .noticePop, .alert, .layerPopup').remove();
            $(this).remove();
        }
    })

    //화일업로드 : 찾아보기에 outline 생기기 
    var $fileBox = null;
    
    $(function() {
      init();
    })
    
    function init() {
      $fileBox = $('.box_upload');
      fileLoad();
    }
    
    function fileLoad() {
      $.each($fileBox, function(idx){
        var $this = $fileBox.eq(idx),
            $btnUpload = $this.find('[type="file"]'),
            $label = $this.find('.btnLike');

        // $btnUpload.on('change', function() {
        //   var $target = $(this),
        //       fileName = $target.val(),
        //       $fileText = $target.siblings('.file_name');
        //   $fileText.val(fileName);
        // })
       
        $btnUpload.on('focusin focusout', function(e) {
          e.type == 'focusin' ?
            $label.addClass('file_focus') : $label.removeClass('file_focus');
        })
        
      })
    }

    // 익스 엔터키 되게 하기
    //IE는 input:file 입력란에서 Enter 키를 누르면 form submit 되는데 이 동작 막고 file browsing
    if (!!navigator.userAgent.match(/Trident\/7\./) || navigator.userAgent.match(/MSIE/i)) {
        $("input:file").on('keypress', function(e) {
            var keyCode = e.keyCode || e.which;
            if(keyCode == 13) { // Checks for the enter key
                e.preventDefault(); // Stops IE from triggering the button to be clicked
                $(this).trigger("click");            
            }
        });
      }

    //관리자: 기관레이어 팝업 열기 닫기
    $('#layerUp').click(function(){
        $('#dataPop').show();
    })
    $('#btnPop_01').click(function(){
       $('#dataPop').hide();
    })  
        
    /* 레이어검색팝업 lnb메뉴클릭*/
    $('.layerSearch .lnb .dep1 > div > span').on({
        "click":function (){
            $(this).closest('.dep1').toggleClass('active').siblings('.dep1').removeClass('active');
        }
    })
    /* 토글버튼 */
    $('.toggleBtn .toggle').on({
        "click":function (){
            $(this).toggleClass('active');
        }
    })


    $('.btnDescEdit.addr').on({
        "click":function (){
            if($(this).siblings('.editBox').hasClass('active')){
                let val = $(this).siblings('.editBox').find('input').val();
                if(val !== ''){
                    $(this).siblings('.editBox').find('p').html(val);
                    $(this).siblings('.editBox').removeClass('active');
                }else{
                    alert('변경할 즐겨찾기명을 입력하세요');
                }
            }else if($(this).closest('.tool').siblings('.editBox').hasClass('active')){
                let val = $(this).closest('.tool').siblings('.editBox').find('input').val();
                if(val !== ''){
                    $(this).closest('.tool').siblings('.editBox').find('p').html(val);
                    $(this).closest('.tool').siblings('.editBox').removeClass('active');
                }else{
                    alert('변경할 즐겨찾기명을 입력하세요');
                }
            }else{
                $(this).siblings('.editBox').addClass('active');
                $(this).closest('.tool').siblings('.editBox').addClass('active');
            }
        }
    })

    /* 파일첨부 */
    var fileTarget = $('.fileSelect .fileHidden');
    fileTarget.on('change', function(){ // 값이 변경되면
        if(window.FileReader){ // modern browser
            var filename = $(this)[0].files[0].name;
        } else { // old IE
            var filename = $(this).val().split('/').pop().split('\\').pop(); // 파일명만 추출
        } // 추출한 파일명 삽입
        $(this).siblings('.fileLocal').val(filename);
    });
    /* 테이블 안의 내용 토글*/
    $('.btnInTable').on({
        "click":function (){
            $(this).toggleClass('active').closest('.innerTb').toggleClass('active').closest('tr').siblings('tr').find('.innerTb').removeClass('active').find('.btnInTable').removeClass('active');
        }
    })
    $('.filterToggleArea li').on({
        "click":function (){
            let idx = $(this).index();
            if(idx === 0 && $(this).hasClass('active')){
                $(this).removeClass('active').attr('title','').siblings('li').removeClass('active').attr('title','');
            }else if(idx === 0 && !$(this).hasClass('active')){
                $(this).addClass('active').attr('title','선택됨').siblings('li').addClass('active').attr('title','선택됨');
            }else{
                if($(this).hasClass('active')){
                    $(this).removeClass('active').attr('title','')
                }else{
                    $(this).addClass('active').attr('title','선택됨')
                }
            }
        }
    })
    $('.btnPopClose').on({
        "click":function (){
            $(this).closest('.popup').hide();
        }
    })
    $('.btnPopResize').on({
        "click":function (){
            $(this).closest('.popup').toggleClass('resize').find('.popSec').eq(0).toggle();
        }
    })

    $('.alert .btnClose').on({
        "click":function (){
            $(this).closest('.alert').hide();
        }
    })

    $('.btnContentToggle').on({
        "click":function (){
            $(this).closest('.item').toggleClass('active');
            $(this).toggleClass('active');
        }
    })
    const resizeDraggable = () => {
        if($(window).outerWidth() <= 1024){
            $('.popup,.alert').draggable('destroy')
        }else{
            $('.popup,.alert').draggable({
                containment:'window',
                cancel:'.cont',
            })
        }
    }

    $('.popup.result, .popup.geoCoding').draggable('disable')
    /* toc 레이어 수정버튼 클릭이벤트 */
    $('.contentList .item .flex.ac .icoBtn').on({
        "click":function (){
            if($(this).hasClass('edit')){
                $(this).closest('.btnGroup').siblings('.name').addClass('hide').siblings('.editBox').addClass('show');
            }
        }
    })

    /* toc 레이어 제목변경여부 */
    $('.contentList .item .flex.ac .editBox .btn').on({
        "click":function (){
            if($(this).hasClass('blue')){
                let val = $(this).siblings('input[type="text"]').val();
                $(this).closest('.editBox').removeClass('show').siblings('.name').text(val).removeClass('hide');
            }else{
                $(this).closest('.editBox').removeClass('show').siblings('.name').removeClass('hide');
            }
        }
    })
    $('.moreToggle').on({
        "click":function (){
            $(this).toggleClass('active');
        }
    })
    $('.btnAlarm').on({
        "click":function (){
            $(this).siblings('.alarmPop').toggle();
        }
    })
    $('.btnAlarmClose').on({
        "click":function (){
            $(this).closest('.alarmPop').hide();
        }
    })
    $('.favBox .btnEdit').on({
        "click":function (){
            let val = $(this).closest('.tool').siblings('.favForm').children('input[type="text"]').val();
            if($(this).closest('.favBox').hasClass('active')){
                if(val !== ''){
                    $(this).closest('.tool').siblings('.favName').html(val);
                    $(this).closest('.favBox').removeClass('active');
                }else{
                    alert('변경할 즐겨찾기명을 입력하세요');
                }
            }else{
                $(this).closest('.favBox').addClass('active');
            }
        }
    })
    $('.favForm .btn').on({
        "click":function (){
            $(this).closest('.favBox').removeClass('active');
            $(this).siblings('input[type="text"]').val('')
        }
    })
    /*
    function contH(){
        $('.popup .cont').css({height:$(window).outerHeight() - 170})
    }
    $(window).resize(function (){
        contH();
    })*/

    resizeDraggable();
    $(window).resize(function (){
        resizeDraggable();
    })
    $('.btnAddrToggle').on({
        "click":function (){
            $('.menuArea .location').toggleClass('active');
        }
    })
    $('.btnDetailInfo').on({
        "click":function (){
            $(this).closest('.item').toggleClass('active').siblings('.item').removeClass('active');
        }
    })

    $('.btnLeftClose').on({
        "click":function (){
            $('#toc').addClass('hide')
        }
    })
    $('.popup.result .addrArea').on({
        "click":function (){
            $(this).toggleClass('active').siblings('.addrArea').removeClass('active')
        }
    })
    //draggable
    $('.layerPopup,.alert').draggable({
        cancel: '.popCont',
        containment: "window"
    });
    $('.btnGeoToggle').on({
        "click":function (){
            $(this).closest('.popup').toggleClass('small');
        }
    })
    $('.layerAnalysis li').on({
        "click":function (){
            $(this).toggleClass('active').siblings('li').removeClass('active')
        }
    })
    $('.colorPickArea .colorGroup span').on({
        "click":function (){
            let pick = $(this).css('backgroundColor');
            $(this).addClass('active').attr('title','선택됨').siblings('span').removeClass('active').attr('title','');
            $(this).closest('.tabCont').find('.choiceColor').css('backgroundColor',pick)
        }
    })
    /* 로컬서비스 정렬 */
    $('.alignBox span').on({
        "click":function (){
            $(this).addClass('active').attr('title','선택됨').siblings().removeClass('active').attr('title','');
        }
    })

    $('.topInner a').on({
        "click":function (){
            $(this).closest('.topInner').addClass('ac').attr('title','선택됨').siblings('li').removeClass('ac').attr('title','')
        }
    })
    //$('.cal').datetimepicker();


    var customHandle = $('.customHandle')
    $('.slider').slider({
        range: "min",
        create:function(){
            customHandle.text($(this).slider("value"));
            customHandle.css('left','calc(' + $(this).slider("value") + '% )')
        },
        slide:function(event, ui){
            customHandle.text(ui.value);
            customHandle.css('left','calc(' + $(this).slider("value") + '% )')
        },
        change:function(event, ui){
            customHandle.text(ui.value);
            customHandle.css('left','calc(' + $(this).slider("value") + '% )')
        }
    });

    $('.btnSearchCondition').on({
        "click":function (){
            $(this).toggleClass('active').siblings('.inputBox').toggleClass('hide');
        }
    })
    $('.btnHelpClose').on({
        "click":function (){
            $(this).closest('#helpArea').remove();
        }
    })
    //로그인 창
    $('#loginWrap').click(function () {
        $('#loginBox').toggle();
    });
    $('.checkbox label').on({
        "click":function (){
            $(this).siblings('input[type="checkbox"]').prop('checked', function () {
                if($(this).closest('table').parent('div').hasClass('table')){
                    $(this).closest('tr').toggleClass('checking')
                }
            })
        }
    })





    //툴 바
    $('.toolbar select').on({
        "change":function (){
            $(this).closest('.dep1').removeClass('active')
        }
    })
    $('.toolbar .btn').on({
        "click":function (){
            if($(this).parent('div').hasClass('dep1')){ //2뎁스 있는것
                if($(this).parent('div').parent('div').hasClass('btnTool')){
                    $(this).toggleClass('active').closest('.dep1').toggleClass('active').siblings('.dep1').removeClass('active').find('.btn').removeClass('active');
                    $(this).closest('.btnTool').siblings('.btnTool').find('.btn').removeClass('active');
                    $(this).closest('.btnTool').siblings('.dep1').removeClass('active').find('.btn').removeClass('active');
                }else if($(this).parent('div').parent('div').hasClass('toolbar')){
                    $(this).toggleClass('active').closest('.dep1').toggleClass('active').siblings('.dep1').removeClass('active').find('.btn').removeClass('active');
                    $(this).closest('.dep1').siblings('.btnTool').find('.dep1').removeClass('active').find('.btn').removeClass('active');
                }
            }else if($(this).parent('div').hasClass('dep2')){
                if($(this).parent('div').hasClass('sel')){
                    let changeBtn = [$(this).attr('class'),$(this).children('span').text()]
                    $(this).closest('.dep1').children('.btn').removeClass().addClass(changeBtn[0]).addClass('selected').children('span').text(changeBtn[1]);
                    $(this).siblings('.dep3').find('.btn').removeClass('active');
                }else{
                    $(this).closest('.dep1').children('.btn').removeClass('active');
                }
                $(this).closest('.dep1').removeClass('active')
            }else if($(this).parent('div').hasClass('dep3')){
                $(this).toggleClass('active')
                if($(this).parent('div').parent('div').hasClass('sel')){

                    let changeBtn = [$(this).attr('class'),$(this).children('span').text()]
                    $(this).closest('.dep1').children('.btn').removeClass().addClass(changeBtn[0]).addClass('selected').children('span').text(changeBtn[1]);
                }
            }else{ //2뎁스 없는것
                if($(this).parent('div').hasClass('btnTool')){
                    if($(this).hasClass('btnReset')){
                        let btnList = [
                            mapType={name:"btn btnMapType",span:"지도타입"},
                            draw={name:"btn btnDraw",span:"그리기"},
                            ruler={name:"btn btnRuler",span:"측정"},
                        ]
                        for(i = 0; i<$('.dep2.sel').length;i++){
                            $('.dep2.sel').eq(i).siblings('.btn').removeClass().addClass(btnList[i].name).children('span').text(btnList[i].span)
                        }
                        $('.toolbar').find('.dep1').removeClass('active').find('.dep2').removeClass('active');
                    }else{
                        $(this).siblings('.dep1').removeClass('active').find('.btn').removeClass('active');
                        $(this).closest('.btnTool').siblings('.btnTool').find('.dep1').removeClass('active').find('.btn').removeClass('active');
                        $(this).closest('.btnTool').siblings('.dep1').removeClass('active').find('.btn').removeClass('active');
                    }
                }else if($(this).parent('div').hasClass('toolbar')){
                    $(this).siblings('.dep1').removeClass('active').find('.btn').removeClass('active');
                    $(this).siblings('.btnTool').find('.dep1').removeClass('active').find('.btn').removeClass('active');
                }
            }
        }
    })
    $('.contentList .item .name').on({
        "dragstart":function (){
            $(this).closest('.item').addClass('dragging')
        },
        "dragend":function (){
            $(this).closest('.item').removeClass('dragging')
        }
    })

    $('.btnStyle').on({
        "click":function (){
            $(this).addClass('active').attr('title','선택됨').siblings('.btnStyle').removeClass('active').attr('title','');
        }
    })

    $('.tableBox_02 .innerTb tr:first-child td').on({
        "click":function (){
            $(this).closest('tr').toggleClass('ac').next('tr').toggleClass('active').closest('.innerTb').closest('tr').siblings('tr').find('.innerTb').find('tr:first-child').removeClass('ac').next('tr').removeClass('active');
        }
    })

    $('.table.active tbody tr').on({
        "click":function (){
            $(this).toggleClass('active').siblings('tr').removeClass('active')
        }
    })


    $('.certOpen').on({
        "click":function (e){
            e.preventDefault();
            $(this).closest('.loginLink').siblings('.certChk').toggleClass('active');
        }
    })
});