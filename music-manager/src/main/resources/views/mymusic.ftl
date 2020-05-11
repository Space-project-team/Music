<!-- 设置项目根路径全局变量 -->
<#assign ctx=request.contextPath/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>我的音乐</title>

    <#include "head.ftl">

</head>
<body style="user-select: none;">
<!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!---

                                                      模态框（Modal）

--><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!---->
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
                            <p style="position: absolute;right: 64px;bottom: 106px;">联系我们</p>
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
                            <a href="/register.ftl" style="float: left;padding-top: 12px;">没有账号？点此注册</a>
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
        <div class="logo1" style="width: 153px; padding: 20.6px 0; display: inline-block;"><img src="${ctx}/images/logo2.png"
                                                                                                alt=""><a href=""></a>
        </div>
        <nav class="navmargin navbar navbar-default" role="navigation">
            <div class="shurukuang" style="padding: 20.6px 30px;">
                <form class="bs-example" role="form" action="#" method="get">
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="input-group">
                                <input id="songName" type="text" class="form-control" placeholder="中国好声音">
                                <span class="input-group-btn">
								<button class="btn btn-default" type="submit">
									Go!
								</button>
							</span>
                            </div><!-- /input-group -->
                        </div><!-- /.col-lg-6 -->
                    </div><!-- /.row -->
                </form>
            </div>
            <!-- 图标加上搜索框结束 -->
            <div id="col10" class="dengluzhuce">
                <a class="mymusic" href="#">我的音乐</a>
                <a class="mymusic" href="/huiyuanzhongxin.html ">会员中心</a>
                <span class="mymusic">|</span>
                <img id="touxiang" src="${ctx}/images/touxiang.png" width="40px" height="40px"
                     style="display: inline-block; width: 40px;height: 40px;border:0;border-radius: 40px;margin-bottom: 5px;">
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
            <li><a class=" erjicaidan2" href="/index.ftl  ">首页</a></li>
            <li><a class=" erjicaidan2" href="/bangdan.ftl">榜单</a></li>
            <li><a class="erjicaidan2" href="/mv.ftl   ">MV</a></li>
            <li class="dropdown">
                <a class="erjicaidan2" href="#" class="dropdown-toggle" data-toggle="dropdown">
                    更多 <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a class="erjicaidan" href="/musicRadio.ftl ">电台</a></li>
                    <li><a class="erjicaidan" href="/songlist.ftl  ">歌单</a></li>
                    <li><a class="erjicaidan" href="/singer.ftl  ">歌手</a></li>
                </ul>
            </li>
        </ul>
        <ul>
            <li class="youfudong"><a style="padding: 20px 0px" href="playmusic.html"><span
                    class="glyphicon glyphicon-shopping-cart" style="font-size: 14px"> 商城</span></a></li>
            <li class="youfudong"><a style="padding: 20px 0px" href="/musician.ftl"><span
                    class="glyphicon glyphicon-headphones" style="font-size: 14px"> 音乐人</span></a></li>
            <li class="youfudong"><a style="padding: 20px 0px" href="#"><span class="glyphicon glyphicon-music"
                                                                              style="font-size: 14px"> 轻语LIVE</span></a>
            </li>
            <li class="youfudong"><a style="padding: 20px 0px" href="/QQmusic.ftl"><span
                    class="glyphicon glyphicon-star-empty" style="font-size: 14px"> 在线播放</span></a></li>
        </ul>
    </div>
    </div>
</nav>

<!--我的音乐-->
<div class="headerbg">
    <div class="geRenZiLiao">
        <div class="touxiang">
            <img src="${ctx}/images/gerentouxianag.jpeg" class="img-circle txborder">
        </div>
        <h3 class="mingzijuzhong"><span><img src="${ctx}/images/huiyuan.png" alt="会员" width="auto" height="30px"></span></h3>
        <ul class="gzfs">
            <li class="guanzhu">
                <strong class="gznumber">66</strong>
                <span class="gztit">关注</span>
            </li>
            <li class="guanzhu fsnumber">
                <strong class="gznumber">8888</strong>
                <span class="gztit">粉丝</span>
            </li>
        </ul>
        <div class="headernav">
            <a href="#" class="hnava">我喜欢</a>
            <a href="#" class="hnava">我创建的歌单</a>
            <a href="#" class="hnava">关注</a>
            <a href="#" class="hnava">粉丝</a>
            <a href="#" class="hnava">我上传的视频</a>
        </div>
    </div>
</div>
<div class="content">
    <div class="contentnav">
        <a href="#" class="Cnava">歌曲&nbsp;651</a>
        <a href="#" class="Cnava">歌单&nbsp;166</a>
        <a href="#" class="Cnava">专辑&nbsp;61</a>
        <a href="#" class="Cnava">视频&nbsp;45</a>
    </div>
    <div class="liebiao">
        <div class="liebiaobar">
            <a href="/QQmusic.ftl" class="lbbar" target="_blank">
                <span class="glyphicon glyphicon-play">播放全部</span>
            </a>
            <a href="#" class="lbbar" data-stat="">
                <span class="glyphicon glyphicon-log-in">&nbsp;添加到</span>
            </a>
            <a href="#" class="lbbar" data-stat="">
                <span class="glyphicon glyphicon-save">下载</span>
            </a>
            <a href="#" class="lbbar" data-stat="">
                <span class="glyphicon glyphicon-list">批量操作</span>
            </a>
        </div>

        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">

                    <div class="ibox-content">
                        <div class="table-responsive">
                            <table style="width: 1200px;margin: auto; overflow: auto;">
                                <thead>
                                <tr style="border-bottom: 1px solid #919191;line-height: 35px;">
                                    <th style="text-align: center;font-size: 20px">序号</th>
                                    <th style="text-align: center;font-size: 20px">歌名</th>
                                    <th style="text-align: center;font-size: 20px">歌手</th>

                                </tr>
                                </thead>
                                <tbody style="font-size: 16px">
                                <tr>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-12">
                <ul id="pagintor"></ul>
            </div>
        </div>
    </div>
</div>
<!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!---

                                                   最后 页脚

--><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!---->
<script src="js/jquery.min.js?v=2.1.4"></script>
<script src="js/bootstrap-paginator.min.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/tools.js"></script>
<script src="js/jquery.cookie.js"></script>
<script type="text/javascript">


    if ($.cookie("user_name") != undefined && $.cookie("user_name") != "1") {//如果用户名不等于1且不等于未定义，则继续执行
        $("#userName").text("账号：" + $.cookie("user_name"));//将未登录3个字替换为用户名
        $("#zhuXiao").text("注销");//将注销加在用户名后方
        $(".mingzijuzhong").text("用户: " + $.cookie("user_name"));//替换大头像下面的用户名
        document.getElementById("touxiang").src = "${ctx}/images/touxiang2.jpg";//替换原始头像
        $("#display1").attr("style", "display:none;");//隐藏登录按钮
    }

    $('#test').validate({
        submitHandler: function (form) {
            denglu($('#test').attr("action"), $('#test').serialize());//调用tools文件里的denglu方法，详情见tools
        }
    });

    getList2();

    function getList2() {
        $.ajax({
            url: "myMusic/getMyMusicList",      //后台获取整个数据库方法的地址
            type: "POST",
            data: {
                "user_name": $.cookie("user_name"),
                "user_password": $.cookie("user_password"),
                "song_id": $.cookie("song_id"),
            },
            success: function (data) {
                if (data.statusCode == "200") {
                    var str = '';                                                   //动态生成表格
                    /* data.data.list.length对应respon.map.list.length */
                    for (var i = 0; i < data.data.list.length; i++) {
                        var a = i + 1;


                        str += '<tr>'
                            + '<td class="number111"  style="padding: 14px;border-bottom: 1px solid #eee; width: 100px;text-align: center;">' + a + '</td>'
                            + '<td  style="padding: 14px;border-bottom: 1px solid #eee;width: 600px;text-align: center;"><a class=sName' + i + ' href="#">' + data.data.list[i].my_songName + '</a>' +
                            '<span class="glyphicon glyphicon-trash" id=sFav' + i + ' style="color: #2c323b;float: right;"></span></td>'
                            + '<td style="padding: 14px;border-bottom: 1px solid #eee;width: 300px;text-align: center;"><a href="#">' + data.data.list[i].my_singer + '</a></td>'
                            + '</tr>';//将动态生成的表格添加到table标签中

                        function play(i) {
                            $("table").on('click', '.sName' + i, function () {//由于该标签是动态添加的，所以一般的选择器没有办法直接选中，因此需要借用事件委托来完成选择并添加click事件
                                fn(i);                                          //调用fn方法，方法的作用见后方备注
                            });
                        }

                        play(i);          //i的值不能由jq直接调用，所以利用play的方法传值进入

                        function play1(i) {
                            $("table").on('click', '#sFav' + i, function () {  //i的值不能由jq直接调用，所以利用play的方法传值进入
                                fn1(i);//调用fn1方法来保存cookie
                                dle(); //调用del方法删除，该方法为ajax，所以此处嵌套ajax，需定义 async: false,异步执行才不会出错
                            });
                        }

                        play1(i);
                    }

                    function fn(j) {//
                        $.cookie("song_link", data.data.list[j].my_songLink, {expires: 7, path: "/"});//
                        $.cookie("song_name", data.data.list[j].my_songName, {expires: 7, path: "/"});//   保存后台传入的相关信息和链接进入cookie，在播放页面直接将cookie的值调用出来，
                        $.cookie("song_singer", data.data.list[j].my_singer, {expires: 7, path: "/"});//    然后替换原有的信息和播放路径，完成点击歌曲播放功能
                        $.cookie("song_photo", data.data.list[j].my_photoLink, {expires: 7, path: "/"});//
                        window.location.href = "/QQmusic.ftl";//跳转页面
                    }

                    function fn1(j) {

                        $.cookie("ml_id", data.data.list[j].my_id, {expires: 7, path: "/"});      //将歌曲id保存下来，点击删除按钮时，将值传入后台，删除数据库
                    }


                    $("table tbody").html(str);
                } else if (data.statusCode == "202") {//如果后台返回202则提示歌曲已收藏
                    alert("您还没有收藏歌曲哦，快去列表收藏吧！");
                }
            },
            error: function (data) {
                alert(JSON.stringify(data));//连接失败弹窗
            }
        })
    }

    function dle() {//删除已收藏歌曲的方法
        $.ajax({
            async: false,//给ajax嵌套执行，所以需设定false
            url: "/myMusic/deleteMyMusic",//后台地址
            type: "post",//post请求方式
            data: {
                "song_id": $.cookie("ml_id"),//传入歌曲id
                "user_id": $.cookie("user_id"),//传入用户id
            },
            success: function (data) {//webspond
                if (data.statusCode == "200") {
                    window.location.reload();//刷新页面
                    alert("已成功从收藏列表移除");//提示删除成功

                    //location.reload();
                } else {
                    alert("add error!" + data.statusMsg);
                }

            },

        })
    }
</script>
</body>
</html>