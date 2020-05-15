

function pagingUtils(totals,page,pages) {
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
                    getSingerList(obj.curr, obj.limit);
                }
            }
        });
    })
}