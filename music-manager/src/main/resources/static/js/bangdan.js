//加载总页数
var total = null;
var pageNums = null;
var pageEnd= null;


function getModuleMusic(url,pageNum,pageSize) {

    var ul = url;
    $.ajax({
        url: ctx+"/musicLink/"+url,
        type: "POST",
        data: {
            pageNum:pageNum,
            pageSize:pageSize
        },
        success: function (data) {
            if (data.code == 200) {
                pageNums = data.pageInfo.pageNum;
                total = data.pageInfo.total;
                pageEnd = data.pageInfo.pages;
                var str = '';
                for (var i = 0; i < data.pageInfo.list.length; i++) {
                    var a = i + 1;
                    str += '<tr>'
                        + '<td class="number111"  style="padding: 14px;border-bottom: 1px solid #eee; width: 100px;text-align: center;">' + ((data.pageInfo.pageNum- 1) * 10 + a) + '</td>'
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
                    $.cookie("song_id", data.data.list[j].songid, {expires: 7, path: "/"});
                    $.cookie("song_name", data.data.list[j].songname, {expires: 7, path: "/"});
                }
            }
            $("table tbody").html(str);


            layui.use(['laypage','jquery'], function() {

                var laypage = layui.laypage,$ = layui.$;

                laypage.render({
                    elem: $("#page")
                    //注意，这里的 elem 指向存放分页的容器，值可以是容器ID、DOM对象。
                    //例1. elem: 'idName' 注意：如果这么写，这里不能加 # 号
                    //例2. elem: document.getElementById('idName')
                    //例3. elem: $("#idName")
                    ,count: total //数据总数，从服务端得到
                    , limit: 10                      //默认每页显示条数
                    , limits: [10, 20, 30]			//可选每页显示条数
                    , curr: pageNums                        //起始页
                    , groups: 5                      //连续页码个数
                    , prev: '上一页'                 //上一页文本
                    , netx: '下一页'                 //下一页文本
                    , first: 1                      //首页文本
                    , last: pageEnd                    //尾页文本
                    , layout: ['prev', 'page', 'next','limit','refresh','skip']
                    //跳转页码时调用
                    , jump: function (obj, first) { //obj为当前页的属性和方法，第一次加载first为true
                        //非首次加载 do something
                        if (!first) {
                            //清空以前加载的数据
                            $('tbody').empty();
                            //调用加载函数加载数据
                            getModuleMusic(ul,obj.curr,obj.limit);
                        }
                    }
                });
            })
        },
        error: function () {
            alert("该网站正在更新,非常抱歉!");
        }
    })
}

