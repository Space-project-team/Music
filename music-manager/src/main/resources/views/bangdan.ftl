<!-- 设置项目根路径全局变量 -->
<#assign ctx=request.contextPath/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>轻语音乐榜</title>

    <#include "head.ftl">


</head>
<body style="overflow-x: hidden;user-select: none;">
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
     style="overflow: auto;">
    <div class="modal-dialog" style="overflow: auto;">
        <div class="modal-content" style="overflow: auto;">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="false">X</button>
                <h4 class="modal-title" id="myModalLabel">账号密码登录</h4>
            </div>
            <div class="modal-body" style="position: relative;">
                <form id="test" class="form-horizontal" role="form" action="/user/loginPage" method="post"
                      style="padding-left: 50px;">
                    <div class="form-group">
                        <img src="${ctx}/images/logo2.png" style="display: block; padding: 20px 151px">
                        <div class="erweima"><img src="${ctx}/images/二维码2.jpg" style="position: absolute;width: 130px;
						height: 130px;bottom: 136px;right: 31px;">
                            <p style="position: absolute;right: 64px;bottom: 106px;">联系我们</p>s
                        </div>
                        <label class="col-sm-2 control-label">
                            <span class="glyphicon glyphicon-user">账号</span>
                        </label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="user_name" name="user_name"
                                   placeholder="手机号/QQ号/微信" style="width: 250px">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">
                            <span class="glyphicon glyphicon-lock">密码</span>
                        </label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="user_password" name="user_password"
                                   placeholder="password" style="width: 250px">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox"> 记住密码
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="modal-footer">
                            <button class="btn btn-primary" data-dismiss="btn btn-default"
                                    style="background-color: #169af3;padding: 5px 30px">登 &nbsp&nbsp&nbsp&nbsp录
                            </button>
                            <a href="${ctx}/register" style="float: left;padding-top: 12px;">没有账号？点此注册</a>
                        </div>
                    </div>
                </form>
            </div>

        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!---

                                                     首页头部

--><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!---->
<div style="width: 100%;height: 80px; background-color:#fff;position: relative;">
    <div style="position: absolute;bottom: -5px;height: 5px;width: 100%;background-color:#fff;z-index: -1;"></div>
    <div class="search1">
        <div class="logo1" style="width: 153px; padding: 20.6px 0; display: inline-block;"><a
                href="${ctx}/index"><img src="${ctx}/images/logo2.png" alt=""></a>
        </div>
        <nav class="navmargin navbar navbar-default" role="navigation">
            <div class="shurukuang" style="padding: 20.6px 30px;">
                <form class="bs-example" role="form" action="#" method="get">
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="为音乐而生">
                                <span class="input-group-btn">
								<button id="search1" class="btn btn-default" type="button">
									搜索
								</button>
							</span>
                            </div><!-- /input-group -->
                        </div><!-- /.col-lg-6 -->
                        <div id="clock">
                            <p class="time">{{ time }}</p>
                        </div>
                    </div><!-- /.row -->
                </form>
            </div>
            <!-- 图标加上搜索框结束 -->
            <div id="col10" class="dengluzhuce">
                <a class="mymusic" href="${ctx}/mymusic" target="_blank">我的音乐</a>
                <a class="mymusic" href="${ctx}/mymusic" target="_blank">您是第<span
                        id="user_number" style="font-size:20px;color:red;text-align:center;padding:0;"> &nbsp</span>位用户</a>
                <span class="mymusic">|</span>
                <img id="touxiang" src="${ctx}/images/touxiang.png" width="40px" height="40px" style="display: inline-block;
                width: 40px;height: 40px;border:0;border-radius: 40px;margin-bottom: 5px;">
                <a id="userName" style="cursor: pointer;" class="mymusic" href="#">
                    未登录</a>
                <a id="zhuXiao" onclick="zhuXiao();location.reload();" href="#">
                </a>
                <button id="display1" class="btn denglu" data-toggle="modal" data-target="#myModal">登 &nbsp&nbsp录
                </button> <!--触发模态框按钮-->
            </div>
        </nav>
    </div>
</div>
<!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!---

                                                   下方nav标签导航栏开始）

--><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!---->
<nav class="daohanglan">
    <div class="big3">
        <ul>
            <li><a class=" erjicaidan2" href="${ctx}/index">首页</a></li>
            <li><a class="gudingbeij erjicaidan2" href="#">榜单</a></li>
            <li><a class="erjicaidan2" href="${ctx}/mv" target="_blank">MV</a></li>
            <li class="dropdown">
                <a class="erjicaidan2" href="#" class="dropdown-toggle" data-toggle="dropdown">
                    更多 <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a class="erjicaidan" href="${ctx}/musicRadio" target="_blank">电台</a>
                    </li>
                    <li><a class="erjicaidan" href="${ctx}/songlist" target="_blank">歌单</a>
                    </li>
                    <li><a class="erjicaidan" href="${ctx}/singer" target="_blank">歌手</a></li>
                </ul>
            </li>
        </ul>
        <ul>
            <li class="youfudong"><a href="${ctx}/musicSearchTest" target="_blank">
                <span class="glyphicon glyphicon-search" style="font-size: 14px"> 搜索</span></a></li>
            <li class="youfudong"><a href="${ctx}/musician" target="_blank">
                <span class="glyphicon glyphicon-headphones" style="font-size: 14px"> 音乐人</span></a></li>
            <li class="youfudong"><span class="glyphicon glyphicon-music" style="font-size: 14px"> 轻语LIVE</span></li>
            <li class="youfudong"><a href="${ctx}/QQmusic" target="_blank">

                <span class="glyphicon glyphicon-star-empty" style="font-size: 14px"> 在线播放</span></a></li>
        </ul>
    </div>
    </div>
</nav>
</nav>
<div class="big clearfix">
    <div class="panel-group" id="accordion">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
				<span class="nonostyle" data-toggle="collapse" data-parent="#accordion"
                      href="#collapseOne">
					热门榜单
				</span>
                </h4>
            </div>
            <div id="collapseOne" class="panel-collapse collapse in">
                <div class="panel-body">
                    <a href="javascript:void(0);"   onclick="getList(1,30)">轻语音乐榜</a>
                    <a href="javascript:void(0);" onclick="getModuleMusic('getList',1,30)">飙升榜单</a>
                    <a href="javascript:void(0);" onclick="getModuleMusic('TOP-Link',1,50)">TOP50榜单</a>
                    <a href="javascript:void(0);" onclick=>网络音乐榜</a>
                    <a href="javascript:void(0);" onclick=>电影音乐榜</a>
                    <a href="javascript:void(0);" onclick=>DJ热歌榜</a>
                    <a href="javascript:void(0);" onclick=>中国梦之声榜</a>
                    <a href="javascript:void(0);" onclick=>国风美少年榜</a>
                    <a href="javascript:void(0);" onclick=>粤语新歌榜</a>
                </div>
            </div>
        </div>
        <div class="panel panel-success">
            <div class="panel-heading">
                <h4 class="panel-title">
				<span class="nonostyle" data-toggle="collapse" data-parent="#accordion"
                      href="#collapseTwo">
					欧美音乐榜
                    </span>
                </h4>
            </div>
            <div id="collapseTwo" class="panel-collapse collapse">
                <div class="panel-body">
                    <a href="">轻语音乐欧美热歌榜</a>
                </div>
            </div>
        </div>
        <div class="panel panel-info">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <span style="cursor: pointer" class="nonostyle" data-toggle="collapse" data-parent="#accordion"
                          href="#collapseThree">
                        新曲音乐榜
                        </span>
                </h4>
            </div>
            <div id="collapseThree" class="panel-collapse collapse">
                <div class="panel-body">
                    <a href="">轻语音乐新歌榜</a>
                </div>
            </div>
        </div>
        <div class="panel panel-warning">
            <div class="panel-heading">
                <h4 class="panel-title">
				<span class="nonostyle" data-toggle="collapse" data-parent="#accordion"
                      href="#collapseFour">
					歌手排行榜
				</span>
                </h4>
            </div>
            <div id="collapseFour" class="panel-collapse collapse">
                <div class="panel-body">
                    <a href="">轻语音乐歌手榜</a>
                </div>
            </div>
        </div>
    </div>


    <table style="width: 1000px; float: right; overflow: auto;">
        <thead>
        <tr style="border-bottom: 1px solid #919191;line-height: 35px;">
            <th style="text-align: center;">序号</th>
            <th style="text-align: center;">歌名</th>
            <th style="text-align: center;">歌手</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
        </tr>
        </tbody>
    </table>


</div>
<audio id="audio" src=""></audio>

    <!--榜单下面的分页，有bug，点击后会导致收藏音乐重复跳出弹框，暂时不用分页功能！ -->


<script src="js/jquery.min.js?v=2.1.4"></script>
<script src="js/bootstrap-paginator.min.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/tools.js"></script>
<script src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/vue.min.js"></script>
<script src="js/bangdan.js"></script>
<script type="text/javascript">

    $(document).ready(function () {
/*        pageTools(1,30);*/
        getList(1,30);
    });

    function getList(pageNum,pageSize) {
        $.ajax({
            url: "http://localhost:9091/music-manager/musicLink/getMusicLinkList",
            type: "GET",
            data: {
                pageNum:pageNum,
                pageSize:pageSize
            },
            success: function (data) {
                console.log(data);
                if (data.code == 200) {
                    var str = '';
                    for (var i = 0; i < data.pageInfo.list.length; i++) {
                        console.log(data.pageInfo.list[i].mlSongname);
                        var a = i + 1;
                        str += '<tr>'
                            + '<td class="number111"  style="padding: 14px;border-bottom: 1px solid #eee; width: 100px;text-align: center;">' + ((pageNum - 1) * 10 + a) + '</td>'
                            + '<td  style="padding: 14px;border-bottom: 1px solid #eee;width: 600px;text-align: center;"><a class=sName' + i + ' href="#">' + data.pageInfo.list[i].mlSongname + '</a>' +
                            '<span class="glyphicon glyphicon-heart" id=sFav' + i + ' style="color: #eee;float: right;"></span></td>'
                            + '<td style="padding: 14px;border-bottom: 1px solid #eee;width: 300px;text-align: center;"><a href="#">' + data.pageInfo.list[i].mlSinger + '</a></td>'
                            + '</tr>';

                        function dd(i) {
                            $("table").on('click', '.sName' + i, function () {
                                fn(i);
                            });
                        }

                        dd(i);

                        function play1(i) {
                            $("table").on('click', '#sFav' + i, function () {
                                fn1(i);
                                fav(i);
                            });
                        }

                        play1(i);
                    }

                    function fn(j) {
                        console.log(data.pageInfo.list[j].mlId);
                        $.cookie("song_link", data.pageInfo.list[j].mlSonglink, {expires: 7, path: "/"});
                        $.cookie("song_name", data.pageInfo.list[j].mlSongname, {expires: 7, path: "/"});
                        $.cookie("song_singer", data.pageInfo.list[j].mlSinger, {expires: 7, path: "/"});
                        $.cookie("song_photo", data.pageInfo.list[j].mlPhotolink, {expires: 7, path: "/"});
                        window.location.href = "${ctx}/QQmusic";
                    }

                    function fn1(j) {
                        console.log(data.data.list[j].mlId);
                        $.cookie("song_id", data.data.list[j].mlId, {expires: 7, path: "/"});
                        $.cookie("song_name", data.data.list[j].mlSongname, {expires: 7, path: "/"});
                    }
                }
                $("table tbody").html(str);
            },
            error: function (data) {
                alert(JSON.stringify(data));
            }
        })
    }

    $("#user_number").html($.cookie("user_id"));
    //已在mymusic中注释
    if ($.cookie("user_name") != undefined && $.cookie("user_name") != "1") {
        $("#userName").text("账号：" + $.cookie("user_name"));
        $("#zhuXiao").text("注销");
        document.getElementById("touxiang").src = "${ctx}/images/touxiang2.jpg";
        $("#display1").attr("style", "display:none;");
    }//已在mymusic中注释
    $('#test').validate({
        submitHandler: function () {
            denglu($('#test').attr("action"), $('#test').serialize());
        }
    });//已在mymusic中注释
    function fav(j) {
        $.ajax({
            async: false,
            url: "http://localhost:9091/music-manager/musicLink/addMusicCollect",
            type: "GET",
            data: {
                "songName": $.cookie("song_name"),
                "song_id": $.cookie("song_id"),
                "user_name": $.cookie("user_name"),
                "user_password": $.cookie("user_password"),
            },
            success: function (data) {//webspond
                if (data.statusCode == "200") {

                    // $('#sFav'+j).removeClass('glyphicon-heart');
                    $('#sFav' + j).css('color', '#ff69b4');
                    alert("歌曲收藏成功，请去我的音乐查看");


                    //location.reload();
                } else {
                    alert("亲！您已经收藏这首歌了哦，快去我的音乐中查看吧");
                }

            },

        })
    }//已在mymusic中注释


    //下方为时钟
    $("#search1").click(function () {
        window.open("${ctx}/musicSearchTest");//给登录按钮一个超链接
    });
    var clock = new Vue({
        el: '#clock',
        data: {
            time: '',
            date: ''
        }
    });
    var week = ['星期天', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'];
    var timerID = setInterval(updateTime, 1000);
    updateTime();
    function updateTime() {
        var cd = new Date();
        clock.time = zeroPadding(cd.getHours(), 2) + ':' + zeroPadding(cd.getMinutes(), 2) + ':' + zeroPadding(cd.getSeconds(), 2);
        clock.date = zeroPadding(cd.getFullYear(), 4) + '-' + zeroPadding(cd.getMonth() + 1, 2) + '-' + zeroPadding(cd.getDate(), 2) + ' ' + week[cd.getDay()];
    };
    function zeroPadding(num, digit) {
        var zero = '';
        for (var i = 0; i < digit; i++) {
            zero += '0';
        }
        return (zero + num).slice(-digit);
    }
</script>
</body>
</html>
