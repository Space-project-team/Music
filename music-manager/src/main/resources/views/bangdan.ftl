<!-- 设置项目根路径全局变量 -->
<#assign ctx=request.contextPath/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>轻语音乐榜</title>

    <link href="${ctx}/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/css/index.css">
    <link rel="shortcut icon" type="image/x-icon" href="${ctx}/images/logo1.png">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="${ctx}/js/bangdan.js"></script>
    <link rel="stylesheet" href="${ctx}/layui-v2.5.5/layui/css/layui.css" media="all">
</head>
<script>
    var ctx="${ctx}";
</script>
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
                <form id="test" class="form-horizontal" role="form" action="${ctx}/user/loginPage" method="post"
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
                    <a href="javascript:void(0)" onclick="showRecord(1,10)">轻语音乐榜</a>
                    <a href="javascript:void(0)" onclick="showRecord(1,10)">飙升榜单</a>
                    <a href="javascript:void(0)" onclick="getTop('TOPLink',1,50)">TOP50榜单</a>
                    <a href="javascript:void(0)" onclick="getModuleMusic('NetworkMusic',1,10)">网络音乐榜</a>
                    <a href="javascript:void(0)" onclick="getModuleMusic('MovieSong',1,10)">电影音乐榜</a>
                    <a href="javascript:void(0)" onclick="getModuleMusic('DjSong',1,10)">DJ热歌榜</a>
                    <a href="javascript:void(0)" onclick="getModuleMusic('EuropeMusic',1,10)">欧美新歌榜</a>
                    <a href="javascript:void(0)" onclick="getModuleMusic('SongHuai',1,10)">中国梦之声榜</a>
                    <a href="javascript:void(0)" onclick="getModuleMusic('TOPLink',1,10)">国风美少年榜</a>
                    <a href="javascript:void(0)" onclick="getModuleMusic('YueYuMusic',1,10)">粤语新歌榜</a>
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
                    <a href="javascript:void(0)" onclick="getModuleMusic('EuropeMusic',1,10)">欧美新歌榜</a>
                    <a href="javascript:void(0)" onclick="getModuleMusic('EuropeSutraMusic',1,10)">欧美经典榜</a>
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
                    <a href="javascript:void(0)" onclick="getModuleMusic('NewMusic',1,10)">新曲榜</a>
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
                    <a href="">歌手榜</a>
                </div>
            </div>
        </div>
    </div>


    <table style="width: 1000px; float: right; overflow: auto;">
        <thead>
        <tr style="border-bottom: 1px solid #919191;line-height: 35px;">
            <th style="text-align: center;">序号</th>
            <th style="text-align: center;" >歌名</th>
            <th style="text-align: center;">歌手</th>
        </tr>
        </thead>

        <tbody>
        </tbody>

    </table>
    <div id="page" style="text-align: center;"></div>


</div>
<audio id="audio" src=""></audio>




<script src="${ctx}/layui-v2.5.5/layui/layui.js"></script>
<script src="${ctx}/js/jquery.min.js?v=2.1.4"></script>
<script src="${ctx}/js/bootstrap-paginator.min.js"></script>
<script src="${ctx}/js/jquery.validate.min.js"></script>
<script src="${ctx}/js/tools.js"></script>
<script src="${ctx}/js/jquery.cookie.js"></script>
<script type="text/javascript" src="${ctx}/js/vue.min.js"></script>
<script type="text/javascript">

    
    
    var userId;
    //默认打开首页加载一次
    $(function () {
        showRecord(1,10);
        //获取用户的id值
        $.ajax({
            type: "post",
            url: ctx+"/user/getUser",
            success: function (data) {
                if(data!=null){
                    userId = data.userId;
                }
            }
        })
    });

    //加载总页数
    var totals;
    var page;
    var pages;
    function showRecord(pageNum,pageSize) {
        $.ajax({
            type: "get",
            url: ctx + "/musicLink/getMusicLinkList",
            data: {
                pageNum: pageNum,
                pageSize: pageSize
            },
            success: function (data) {
                if (data.code == 200) {

                    page = data.pageInfo.pageNum;
                    totals = data.pageInfo.total;
                    pages = data.pageInfo.pages;
                    //加载后台返回的List集合数据
                    var str = '';
                    for (var i = 0; i < data.pageInfo.list.length; i++) {
                        var a = i + 1;
                        str += '<tr>'
                            + '<td class="number111"  style="padding: 14px;border-bottom: 1px solid #eee; width: 100px;text-align: center;">' + ((data.pageInfo.pageNum - 1) * 10 + a) + '</td>'
                            + '<td  style="padding: 14px;border-bottom: 1px solid #eee;width: 600px;text-align: center;"><a class=sName' + i + ' href="#">' + data.pageInfo.list[i].songname + '</a>' +
                            '<span class="glyphicon glyphicon-heart" id=sFav' + i + ' style="color: #eee;float: right;"></span></td>'
                            + '<td style="padding: 14px;border-bottom: 1px solid #eee;width: 300px;text-align: center;"><a href="#">' + data.pageInfo.list[i].singerName + '</a></td>'
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
                        $.cookie("song_link", data.pageInfo.list[j].songfile, {expires: 7, path: "/"});
                        $.cookie("song_name", data.pageInfo.list[j].songname, {expires: 7, path: "/"});
                        $.cookie("song_singer", data.pageInfo.list[j].singerName, {expires: 7, path: "/"});
                        $.cookie("song_photo", data.pageInfo.list[j].photoimage, {expires: 7, path: "/"});
                        window.location.href = "http://localhost:9091/music-manager/QQmusic";
                    }

                    function fn1(j) {
                        $.cookie("song_id", data.pageInfo.list[j].songid, {expires: 7, path: "/"});
                        $.cookie("song_name", data.pageInfo.list[j].songname, {expires: 7, path: "/"});
                    }

                    $("table tbody").html(str);

                    layui.use(['laypage', 'jquery'], function () {

                        var laypage = layui.laypage, $ = layui.$;

                        laypage.render({
                            elem: 'page'
                            //注意，这里的 elem 指向存放分页的容器，值可以是容器ID、DOM对象。
                            //例1. elem: 'idName' 注意：如果这么写，这里不能加 # 号
                            //例2. elem: document.getElementById('idName')
                            //例3. elem: $("#idName")
                            , count: totals //数据总数，从服务端得到
                            , limit: 10                      //默认每页显示条数
                            , limits: [10, 20, 30]			//可选每页显示条数
                            , curr: page                        //起始页
                            , groups: 5                      //连续页码个数
                            , prev: '上一页'                 //上一页文本
                            , netx: '下一页'                 //下一页文本
                            , first: 1                      //首页文本
                            , last: pages                     //尾页文本
                            , layout: ['prev', 'page', 'next', 'limit', 'refresh', 'skip']
                            //跳转页码时调用
                            , jump: function (obj, first) { //obj为当前页的属性和方法，第一次加载first为true
                                //非首次加载 do something
                                if (!first) {
                                    //清空以前加载的数据
                                    $('tbody').empty();
                                    //调用加载函数加载数据
                                    showRecord(obj.curr, obj.limit);
                                }
                            }
                        });
                    })
                }
            },
            error: function (data) {
                alert("该网站正在更新,非常抱歉!");
            }

        })
    }



    //已在mymusic中注释
    if ($.cookie("user_name") != undefined && $.cookie("user_name") != "1") {
        $("#userName").text("账号：" + $.cookie("user_name"));
        $("#zhuXiao").text("注销");
        document.getElementById("touxiang").src = "images/touxiang2.jpg";
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
            url: ctx+"/musicLink/addMusicCollect",
            type: "post",
            data: {
                "songName": $.cookie("song_name"),
                "song_id": $.cookie("song_id"),
                "user_id": userId
            },
            success: function (data) {//webspond
                if (data.code ==200) {

                    // $('#sFav'+j).removeClass('glyphicon-heart');
                    $('#sFav' + j).css('color', '#ff69b4');
                    alert("歌曲收藏成功，请去我的音乐查看");


                    //location.reload();
                }else if(data.code==205){
                    alert(data.message);
                }else{
                    alert(data.message);
                }
                    
            },
            error: function (data) {
                alert(data.message);
            }

        })
    }//已在mymusic中注释

    //下方为时钟
    $("#search1").click(function () {
        window.open("http://localhost:9091/music-manager/musicSearchTest");//给登录按钮一个超链接
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

