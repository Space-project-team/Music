function getModuleMusic(url,pageNum,pageSize) {

    $.ajax({
        url: "http://localhost:9091/music-manager/musicLink/"+url,
        type: "POST",
        data: {
            pageNum:pageNum,
            pageSize:pageSize
        },
        success: function (data) {
            console.log(data);
            if (data.code == 200) {
                var str = '';
                for (var i = 0; i < data.pageInfo.list.length; i++) {
                    var a = i + 1;
                    str += '<tr>'
                        + '<td class="number111"  style="padding: 14px;border-bottom: 1px solid #eee; width: 100px;text-align: center;">' + ((data.pageInfo.pageNum- 1) * 10 + a) + '</td>'
                        + '<td  style="padding: 14px;border-bottom: 1px solid #eee;width: 600px;text-align: center;"><a class=sName' + i + ' href="#">' + data.pageInfo.list[i].songname + '</a>' +
                        '<span class="glyphicon glyphicon-heart" id=sFav' + i + ' style="color: #eee;float: right;"></span></td>'
                        + '<td style="padding: 14px;border-bottom: 1px solid #eee;width: 300px;text-align: center;"><a href="#">' + data.pageInfo.list[i].singerid + '</a></td>'
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
                    $.cookie("song_link", data.pageInfo.list[j].songfile, {expires: 7, path: "/"});
                    $.cookie("song_name", data.pageInfo.list[j].songname, {expires: 7, path: "/"});
                    $.cookie("song_singer", data.pageInfo.list[j].singerid, {expires: 7, path: "/"});
                    $.cookie("song_photo", data.pageInfo.list[j].photoimage, {expires: 7, path: "/"});
                    window.location.href = "http://localhost:9091/music-manager/QQmusic";
                }

                function fn1(j) {
                    console.log(data.data.list[j].mlId);
                    $.cookie("song_id", data.data.list[j].songid, {expires: 7, path: "/"});
                    $.cookie("song_name", data.data.list[j].songname, {expires: 7, path: "/"});
                }
            }
            $("table tbody").html(str);
        },
        error: function (data) {
            alert(JSON.stringify(data));
        }
    })
}