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

</head>
<script>
    var ctx="${ctx}";
</script>
<body style="user-select: none">
<div class="search1">
    <div class="logo1" style="width: 153px; padding: 20.6px 0; display: inline-block;"><a
            href="${ctx}/index" target="_blank"><img src="${ctx}/images/logo2.png" alt=""></a>
    </div>

    <nav class="navmargin navbar navbar-default" role="navigation">
        <div class="shurukuang" style="padding: 20.6px 30px;">
            <form class="bs-example" id="test" role="form" action=${ctx}"/musicLink/getSongRearch" method="post">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="input-group">
                            <input type="text" id="songName" name="songName" class="form-control" placeholder="为音乐而生">
                            <span class="input-group-btn">
								 <button onclick="getList2($('#songName').serialize())" class="btn btn-default"
                                         type="button">                                          <!--点击按钮触发getlist2事件-->
									搜索
								</button>
							</span>
                        </div><!-- /input-group -->
                    </div><!-- /.col-lg-6 -->
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
    <div class="col-sm-12">
        <ul id="pagintor"></ul>
    </div>
</div>
</div>
<script src="${ctx}/js/jquery.min.js?v=2.1.4"></script>
<script src="${ctx}/js/bootstrap-paginator.min.js"></script>
<script src="${ctx}/js/jquery.validate.min.js"></script>
<script src="${ctx}/js/tools.js"></script>
<script src="${ctx}/js/jquery.cookie.js"></script>


<script type="text/javascript">

    /*  $('#test').validate({
          submitHandler: function (form) {
            <!-- #test对应form的id="test" -->
              rearchSong($('#test').attr("action"));
          }
      }); */
    getList2("songName=" + $.cookie("song_search"));//调用getlist2方法

    function getList2(lll) {
        $.ajax({
            url: "http://localhost:9091/music-manager/musicLink/getSongRearch",//后台地址
            type: "POST",//post方式请求
            data: lll,//将数据通过lll在调用的时候传入
            success: function (data) {
                if (data.code == 200) {
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
                            + '<td style="padding: 14px;border-bottom: 1px solid #eee;width: 300px;text-align: center;"><a href="#">' + data.pageInfo.list[i].singerid + '</a></td>'
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
                        $.cookie("song_singer",data.pageInfo.list[j].singerid, {expires: 7, path: "/"});
                        $.cookie("song_photo", data.pageInfo.list[j].photoimage, {expires: 7, path: "/"});
                        window.location.href = "http://localhost:9091/music-manager/QQmusic";
                    }

                    function fn1(j) {

                        $.cookie("song_id", data.pageInfo.list[j].songid, {expires: 7, path: "/"});
                        $.cookie("song_name", data.pageInfo.list[j].songname, {expires: 7, path: "/"});
                    }


                    $("table tbody").html(str);
                } else if (data.code == 400) {
                    alert("搜索不到歌曲！");
                }
            },
            error: function (data) {
                alert(JSON.stringify(data));
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


</script>

</body>
</html>

