<!-- 设置项目根路径全局变量 -->
<#assign ctx=request.contextPath/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <title>轻语音乐</title>

    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/css/jquery.mCustomScrollbar.css">
    <link rel="stylesheet" href="${ctx}/css/index1.css">
    <link rel="shortcut icon" type="image/x-icon" href="${ctx}/images/logo1.png">
    <script src="${ctx}/js/jquery.min.js"></script>
    <script src="${ctx}/js/jquery.cookie.js"></script>
    <script src="${ctx}/js/jquery.mCustomScrollbar.js"></script>
    <script src="${ctx}/js/player.js"></script>

</head>
<script>
    var ctx="${ctx}";
</script>

<body style="user-select: none;">
<div class="header">
    <h1 class="logo"><a href="${ctx}/index"></a></h1>
    <ul class="register">
        <li></li>
        <li>设置</li>
    </ul>
</div>
<div class="content">
    <div class="content_in">
        <div class="content_left">
            <div class="content_toolbar">
                <span class="glyphicon glyphicon-heart-empty"> 收 藏</span>
                <span class="glyphicon glyphicon-plus-sign"> 添加到</span>
                <span class="glyphicon glyphicon-download-alt"> 下 载</span>
                <span class="glyphicon glyphicon-trash"> 删 除</span>
                <span class="glyphicon glyphicon-fire"> 清空列表</span>
            </div>
            <div class="content_list" data-mcs-theme="minimal-dark">
                <ul id="sNamee">
                    <li class="list_title">
                        <div class="list_check"><i></i></div>
                        <div class="list_number"></div>
                        <div class="list_name">歌曲</div>
                        <div class="list_singer">歌手</div>
                        <div class="list_time">时长</div>
                    </li>

                </ul>
            </div>
        </div>
        <div class="content_right">
            <div class="song_info" style="margin: 100px">
                <a href="javascript:;" class="song_info_pic">
                    <img class="song_img" src="${ctx}/images/2.jpg" alt="" width="200px" height="200px">
                </a>
                <div class="song_info_name ">歌曲名称：
                    <a class="songName" href="javascript:;">
                    </a>
                </div>
                <div class="song_info_singer">歌 手 名 ：
                    <a class="songSinger" href="javascript:;">
                    </a>
                </div>
                <div class="song_info_ablum">专辑名称：
                    <a href="javascript:;">未知专辑

                    </a>
                </div>
            </div>
            <ul class="song_lyric">
            </ul>
        </div>
    </div>
</div>
<div class="footer">
    <div class="footer_in">
        <a href="javascript:;" class="music_pre"></a>
        <a href="javascript:;" class="music_play music_play2"></a>
        <a href="javascript:;" class="music_next"></a>
        <div class="music_progress_info">
            <div class="music_progress_top">
                <span class="music_progress_name">一吻天荒 / 胡歌</span>
                <span class="music_progress_time">00:00 / 00:00</span></div>
            <div class="music_progress_bar">
                <div class="music_progress_line">
                    <div class="music_progress_dot"></div>
                </div>
            </div>
        </div>
        <a href="javascript:;" class="music_mode "></a>
        <a href="javascript:;" class="music_fav "></a>
        <a href="javascript:;" class="music_down"></a>
        <a href="javascript:;" class="music_comment"></a>
        <a href="javascript:;" class="music_only "></a>
        <div class="music_voice_info">
            <a href="javascript:;" class="music_voice_icon"></a>
            <div class="music_voice_bar">
                <div class="music_voice_line">
                    <div class="music_voice_dot"></div>
                </div>
            </div>
        </div>

    </div>
</div>
<div class="mask_bg">
    <img class="song_img" id="userheadImage" src="" alt="" width="100%" height="100%">
</div>
<div class="mask"></div>
<audio id="audio" src=""></audio>
<script src="${ctx}/js/index.js"></script>
<script>

    $("#userheadImage").attr("src",""+$.cookie("user_headImage"));

    var userName = getCookie("user_name");
    //工作原理代码见index.js
    getList2();


    function getList2() {
        $.ajax({
            url: "http://localhost:9091/music-manager/myMusic/getMyMusicList",
            type: "POST",
            data: {
               userName: $.cookie("user_name"),
               pageNum:1,
               pageSize:10
            },
            success: function (data) {
                console.log(data);
                if (data.code==200) {
                    var str = '';
                    /* data.data.list.length对应respon.map.list.length */
                    for (var i = 0; i < data.pageInfo.list.length; i++) {
                        //console.log(i);
                        var a = i + 1;
                        str += '<li class="list_music">\n' +
                            '                        <div class="list_number">' + a + '</div>\n' +
                            '                        <div id= sName' + i + ' class="list_name" style="cursor: pointer;">' + data.pageInfo.list[i].mySongname +
                            '<span class="glyphicon glyphicon-trash" id=sFav' + i + ' style="color: rgba(255,255,255,0.5);float: right;margin-right: 20px;cursor: pointer;"></span>' +
                            '                        </div>\n' +
                            '                        <div class="list_singer">' + data.pageInfo.list[i].mySinger + '</div>\n' +
                            '                        <div class="list_time"><span class="time1">4:36</span>\n' +
                            '                    </li>';
                        //console.log(1111);
                        function play(i) {
                            $("#sNamee").on('click', '#sName' + i, function () {
                                fn(i);
                            });
                        }

                        play(i);

                        function play1(i) {
                            $("#sNamee").on('click', '#sFav' + i, function () {
                                fn1(i);
                                dle();
                            });
                        }

                        play1(i);
                    }

                    function fn(j) {

                        $.cookie("song_link", data.pageInfo.list[j].mySonglink, {expires: 7, path: "/"});
                        $.cookie("song_name", data.pageInfo.list[j].mySongname, {expires: 7, path: "/"});
                        $.cookie("song_singer", data.pageInfo.list[j].mySinger, {expires: 7, path: "/"});
                        $.cookie("song_photo", data.pageInfo.list[j].myPhotolink, {expires: 7, path: "/"});
                        window.location.href = "http://localhost:9091/music-manager/QQmusic";
                    }

                    function fn1(j) {
                        $.cookie("my_id", data.pageInfo.list[j].myId, {expires: 7, path: "/"});
                    }
                    //console.log(str);
                    $("#sNamee").html(str);

                } else{
                    alert("您还没有收藏歌曲哦，快去列表收藏吧！");
                }
            },
            error: function (data) {
                alert(JSON.stringify(data));
            }
        })
    }//已在mymusic中注释

    function dle() {
        $.ajax({
            async: false,
            url: "http://localhost:9091/music-manager/myMusic/deleteMyMusic",
            type: "post",
            data: {
                mid: $.cookie("my_id"),
                userName:$.cookie("user_name")
            },
            success: function (data) {//webspond
                if (data.code== 200) {
                    window.location.reload();
                    alert("已成功从收藏列表移除");

                    //location.reload();
                } else {
                    alert("add error!" + data.message);
                }

            },

        })
    }//已在mymusic中注释
</script>
</body>