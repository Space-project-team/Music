<!-- 设置项目根路径全局变量 -->
<#assign ctx=request.contextPath/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>我的音乐</title>

    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/css/index.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/css/mymusic.css">
    <link rel="shortcut icon" type="image/x-icon" href="${ctx}/images/logo1.png">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript"
            src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>

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
                <form id="test" class="form-horizontal" role="form" action="${ctx}/user/loginPage" method="post"
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
            <li><a class=" erjicaidan2" href="${ctx}/index  ">首页</a></li>
            <li><a class=" erjicaidan2" href="${ctx}/bangdan">榜单</a></li>
            <li><a class="erjicaidan2" href="${ctx}/mv  ">MV</a></li>
            <li class="dropdown">
                <a class="erjicaidan2" href="#" class="dropdown-toggle" data-toggle="dropdown">
                    更多 <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a class="erjicaidan" href="${ctx}/musicRadio ">电台</a></li>
                    <li><a class="erjicaidan" href="${ctx}/songlist  ">歌单</a></li>
                    <li><a class="erjicaidan" href="${ctx}/singer  ">歌手</a></li>
                </ul>
            </li>
        </ul>
        <ul>
            <li class="youfudong"><a style="padding: 20px 0px" href="playmusic.html"><span
                    class="glyphicon glyphicon-shopping-cart" style="font-size: 14px"> 商城</span></a></li>
            <li class="youfudong"><a style="padding: 20px 0px" href="${ctx}/musician"><span
                    class="glyphicon glyphicon-headphones" style="font-size: 14px"> 音乐人</span></a></li>
            <li class="youfudong"><a style="padding: 20px 0px" href="#"><span class="glyphicon glyphicon-music"
                                                                              style="font-size: 14px"> 轻语LIVE</span></a>
            </li>
            <li class="youfudong"><a style="padding: 20px 0px" href="${ctx}/QQmusic"><span
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
            <a href="${ctx}/QQmusic" class="lbbar" target="_blank">
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
        <div class="pagination">

        </div>

    </div>
</div>
<!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!---

                                                   最后 页脚

--><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!---->
<script src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/js/bootstrap-paginator.min.js"></script>
<script src="${ctx}/js/jquery.validate.min.js"></script>
<script src="${ctx}/js/tools.js"></script>
<script src="${ctx}/js/jquery.cookie.js"></script>
<script src="${ctx}/js/doT.min.js"></script>

<#--
<!-- 编写分页模板 &ndash;&gt;
<script type="template" id="pageTemplate">
    {{ if(it.hasPreviousPage){ }}
    <li class="paginate_button prev">
        <a href="javascript:getList2('{{=it.prePage}}');">上一页</a>
    </li>
    {{ } }}

    {{ for(var i = 1; i <= it.pages; i++){ }}
    <li class="paginate_button
        {{ if(i == it.pageNum){ }}
        active
        {{ } }}
        ">
        <a href="javascript:getList2('{{=i}}');">{{=i}}</a>
    </li>
    {{ } }}

    {{ if(it.hasNextPage){ }}
    <li class="paginate_button next">
        <a href="javascript:getList2('{{=it.nextPage}}');">下一页</a>
    </li>
    {{ } }}
</script>
-->

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
    $(document).ready(function () {
        getList2(1);
    });
    /*
    * 获取歌曲信息 -分页
    * */
    function getList2(page) {
        $.ajax({
            url: "${ctx}/myMusic/getMyMusicList",      //后台获取整个数据库方法的地址
            type: "POST",
            data: {
                userName: $.cookie("user_name"),
                pageNum: page,
                pageSize:5
            },
            success: function (data) {
                if (data.code==200) {
                    var str = '';                                                   //动态生成表格
                    /* data.data.list.length对应respon.map.list.length */
                    for (var i = 0; i < data.pageInfo.list.length; i++) {
                        var a = i + 1;


                        str += '<tr>'
                            + '<td class="number111"  style="padding: 14px;border-bottom: 1px solid #eee; width: 100px;text-align: center;">' + a + '</td>'
                            + '<td  style="padding: 14px;border-bottom: 1px solid #eee;width: 600px;text-align: center;"><a class=sName' + i + ' href="#">' + data.pageInfo.list[i].mySongname + '</a>' +
                            '<span class="glyphicon glyphicon-trash" id=sFav' + i + ' style="color: #2c323b;float: right;"></span></td>'
                            + '<td style="padding: 14px;border-bottom: 1px solid #eee;width: 300px;text-align: center;"><a href="#">' + data.pageInfo.list[i].mySinger + '</a></td>'
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
                        $.cookie("ml_id", data.pageInfo.list[j].mySonglink, {expires: 7, path: "/"});
                        $.cookie("song_link", data.pageInfo.list[j].mySonglink, {expires: 7, path: "/"});//
                        $.cookie("song_name", data.pageInfo.list[j].mySongname, {expires: 7, path: "/"});//   保存后台传入的相关信息和链接进入cookie，在播放页面直接将cookie的值调用出来，
                        $.cookie("song_singer", data.pageInfo.list[j].mySinger, {expires: 7, path: "/"});//    然后替换原有的信息和播放路径，完成点击歌曲播放功能
                        $.cookie("song_photo", data.pageInfo.list[j].myPhotolink, {expires: 7, path: "/"});//
                        window.location.href = "${ctx}/QQmusic";//跳转页面
                    }

                    function fn1(j) {

                        $.cookie("ml_id", data.pageInfo.list[j].myId, {expires: 7, path: "/"});      //将歌曲id保存下来，点击删除按钮时，将值传入后台，删除数据库
                    }


                    $("table tbody").html(str);

                    pageTools(data.pageInfo.currentPage,3);
                    //分页
                    pageInfoMyMusic(data.pageInfo,"pagination");

                } else {   //如果后台返回202则提示歌曲已收藏
                    alert("您还没有收藏歌曲哦，快去列表收藏吧！");
                }
            },
            error: function (data) {
                alert(JSON.stringify(data));//连接失败弹窗
            }
        })
    }

    /**
     * 分页
     */
    function pageInfoMyMusic(pageInfo,pagination) {
        var barDiv = $("."+pagination);
        /*var context = "<span>当前页：" + pageInfo.pageNum + "&nbsp;总页数："
            + pageInfo.pages + "&nbsp;&nbsp;总记录数："+pageInfo.total+"</span>";*/
        var context = "<div class='query-content-page-btn'><ul>";
        if (pageInfo.pageNum > 1) {
            context += "<li class='prev-next' onclick=prePage('"
                + pageInfo.prePage + "')><</li>";
        }
        for (var i = 0; i < pageInfo.navigatepageNums.length; i++) {
            if (pageInfo.pageNum == pageInfo.navigatepageNums[i]) {
                context += "<li class='current_page' onclick=numPage('"
                    + pageInfo.navigatepageNums[i]
                    + "')>"
                    + pageInfo.navigatepageNums[i] + "</li>"
            } else {
                context += "<li onclick=numPage('"
                    + pageInfo.navigatepageNums[i] + "')>"
                    + pageInfo.navigatepageNums[i] + "</li>"
            }

        }

        if (pageInfo.pageNum < pageInfo.pages) {
            context += "<li class='bus-border-right prev-next' onclick=nextPage('"
                + pageInfo.nextPage + "')>></li>";
        }
        context += "</ul></div>";
        barDiv.html(context);
    }

    // 下一页
    function nextPage() {
        // 获取当前页的值 加一 然后重新赋值给当前页
        var page = parseInt($("#pageNum").val()) + 1;
        $("#pageNum").val(page);
        // 调用搜索函数
        getList2(page);
    }

    //上一页
    function prePage() {
        // 获取当前页的值 减一 然后重新赋值给当前页
        var page = parseInt($("#pageNum").val()) - 1;
        $("#pageNum").val(page);
        // 调用搜索函数
        getList2(page);
    }


    // 第几页
    function numPage(num) {
        // 获取点击的按钮值 然后重新赋值给当前页
        $("#pageNum").val(num);

        // 调用搜索函数
       getList2(num);
    }

    function dle() {//删除已收藏歌曲的方法
        $.ajax({
            async: false,//给ajax嵌套执行，所以需设定false
            url: "${ctx}/myMusic/deleteMyMusic",//后台地址
            type: "post",//post请求方式
            data: {
                mid: $.cookie("ml_id"),//传入歌曲id
                userName: $.cookie("user_name"),//传入用户名
            },
            success: function (data) {//webspond
                console.log(data);
                if (data.code==200) {
                    window.location.reload();//刷新页面
                    alert("已成功从收藏列表移除");//提示删除成功

                    //location.reload();
                } else {
                    alert("add error!" + data.message);
                }

            },

        })
    }
</script>

</body>
</html>