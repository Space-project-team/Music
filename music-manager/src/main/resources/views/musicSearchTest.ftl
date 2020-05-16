<!-- 设置项目根路径全局变量 -->
<#assign ctx=request.contextPath/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>轻语搜索</title>

    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/css/index.css">
    <link rel="shortcut icon" type="image/x-icon" href="${ctx}/images/logo1.png">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${ctx}/layui-v2.5.5/layui/css/layui.css" media="all">
</head>
<body style="user-select: none">
<div class="search1">
    <div class="logo1" style="width: 153px; padding: 20.6px 0; display: inline-block;"><a
            href="${ctx}/index" target="_blank"><img src="${ctx}/images/logo2.png" alt=""></a>
    </div>

    <nav class="navmargin navbar navbar-default" role="navigation">
        <div class="shurukuang" style="padding: 20.6px 30px;">
            <form class="bs-example" id="test" role="form" action="${ctx}/musicLink/getSongRearch" method="post">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="input-group">
                            <input type="text" id="songName" name="songName" class="form-control" placeholder="为音乐而生">
                            <span class="input-group-btn">
								 <button onclick="getList2(1,$('#songName').val(),10)" class="btn btn-default"
                                         type="button">                                          <!--点击按钮触发getlist2事件-->
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
        <a style="font-size:14px;float: right;margin: 20px"
           href="${ctx}/mymusic" target="_blank">点击跳转我的音乐...</a>
    </nav>
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

    <div id="page" style="text-align: center;"></div>

</div>
</div>
<script src="${ctx}/layui-v2.5.5/layui/layui.js"></script>
<script src="${ctx}/js/jquery.min.js?v=2.1.4"></script>
<script src="${ctx}/js/bootstrap-paginator.min.js"></script>
<script src="${ctx}/js/jquery.validate.min.js"></script>
<script src="${ctx}/js/tools.js"></script>
<script src="${ctx}/js/jquery.cookie.js"></script>
<script type="text/javascript" src="${ctx}/js/vue.min.js"></script>

<script type="text/javascript">

    /*  $('#test').validate({
          submitHandler: function (form) {
            <!-- #test对应form的id="test" -->
              rearchSong($('#test').attr("action"));
          }
      }); */
    /*getList2("songName=" + $.cookie("song_search"),1,10);//调用getlist2方法*/

    //加载总页数
    var totals;
    var page;
    var pages;
    var songName = $("#songName").val();

    $(function () {
        //进入加载一次
        getList2(1,songName,10);
    });

    function getList2(pageNum,songName,pageSize) {
        $.ajax({
            url: "http://localhost:9091/music-manager/musicLink/getSongRearch",//后台地址
            type: "POST",//post方式请求
            data: {
                songName:songName,
                pageNum:pageNum,
                pageSize:pageSize
            },//将数据通过lll在调用的时候传入
            success: function (data) {
                if (data.code == 200) {
                    //分页参数
                    page = data.pageInfo.pageNum;
                    totals = data.pageInfo.total;
                    pages = data.pageInfo.pages;

                    var search = document.getElementById("songName").value;//获取搜索框内的文本
                    $.cookie("song_search", search, {expires: 7, path: "/"});//将文本存入cookie
                    var str = '';
                    /* data.data.list.length对应respon.map.list.length */
                    for (var i = 0; i < data.pageInfo.list.length; i++) {
                        var a = i + 1;


                        str += '<tr>'
                            + '<td class="number111"  style="padding: 14px;border-bottom: 1px solid #eee; width: 100px;text-align: center;">' + a + '</td>'
                            + '<td  style="padding: 14px;border-bottom: 1px solid #eee;width: 600px;text-align: center;"><a class=sName' + i + ' href="#">' + data.pageInfo.list[i].songname + '</a>' +
                            '<span class="glyphicon glyphicon-heart" id=sFav' + i + ' style="color: #eee;float: right;"></span></td>'
                            + '<td style="padding: 14px;border-bottom: 1px solid #eee;width: 300px;text-align: center;"><a href="#">' + data.pageInfo.list[i].singerName + '</a></td>'
                            + '</tr>';

                        function play(i) {

                            $("table").on('click', '.sName' + i, function () {
                                fn(i);
                            });
                        }

                        play(i);

                        function play1(i) {
                            $("#sFav").unbind();
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
                        $.cookie("song_singer",data.pageInfo.list[j].singerName, {expires: 7, path: "/"});
                        $.cookie("song_photo", data.pageInfo.list[j].photoimage, {expires: 7, path: "/"});
                        window.location.href = "${ctx}/QQmusic";
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
                                    getList2(obj.curr, songName,obj.limit);
                                }
                            }
                        });
                    })
                } else if (data.code == 400) {
                    alert("搜索不到歌曲！");
                }
            },
            error: function (data) {
                alert("搜索不到歌曲！");
            }
        })
    }//已在mymusic中注释


    function fav(j) {
        $.ajax({
            async: false,
            url: "http://localhost:9091/music-manager/musicLink/addMusicCollect",
            type: "post",
            data: {
                "songName": $.cookie("song_name"),
                "song_id": $.cookie("song_id"),
                "user_name": $.cookie("user_name"),
                "user_password": $.cookie("user_password"),
            },
            success: function (data) {//webspond
                if (data.code == 200) {
                    $('#sFav' + j).css('color', '#ff69b4');
                    alert("歌曲收藏成功，请去我的音乐查看！")

                    //location.reload();
                } else {
                    alert("亲！您已经收藏这首歌了哦，快去我的音乐中查看吧");
                }

            },

        })
    }//已在mymusic中注释

    //
    //
    //           数字时钟
    //
    //
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

