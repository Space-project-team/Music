<!-- 设置项目根路径全局变量 -->
<#assign ctx=request.contextPath/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>轻语电台</title>

    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/css/musicRadio.css">
    <link rel="shortcut icon" type="image/x-icon" href="${ctx}/images/logo1.png">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${ctx}/css/index.css">

</head>
<body>
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
                                <input type="text" class="form-control" placeholder="中国好声音">
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
                <a class="mymusic" href="${ctx}/mymusic">我的音乐</a>
                <a class="mymusic" href="/huiyuanzhongxin.html">会员中心</a>
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
            <li><a class=" erjicaidan2" href="${ctx}/index">首页</a></li>
            <li><a class=" erjicaidan2" href="${ctx}/bangdan">榜单</a></li>
            <li><a class="erjicaidan2" href="${ctx}/mv">MV</a></li>
            <li class="gudingbeij dropdown">
                <a style="padding-right: 10px;" class="erjicaidan2" href="#" class="dropdown-toggle"
                   data-toggle="dropdown">
                    更多 <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a class=" erjicaidan" href="#">电台</a></li>
                    <li><a class="erjicaidan" href="${ctx}/songlist">歌单</a></li>
                    <li><a class="erjicaidan" href="${ctx}/singer">歌手</a></li>
                </ul>
            </li>
        </ul>
        <ul>
            <li class="youfudong"><a style="padding: 20px 0px" href="playmusic.html"><span
                    class="glyphicon glyphicon-shopping-cart" style="font-size: 14px"> 商城</span></a></li>
            <li class="youfudong"><a style="padding: 20px 0px" href="${ctx}/musician"><span
                    class="glyphicon glyphicon-headphones" style="font-size: 14px"> 音乐人</span></a></li>
            <li class="youfudong"><a style="padding: 20px 0px" href="playmusic.html"><span
                    class="glyphicon glyphicon-music" style="font-size: 14px"> 轻语LIVE</span></a></li>
            <li class="youfudong"><a style="padding: 20px 0px" href="${ctx}/QQmusic"><span
                    class="glyphicon glyphicon-star-empty" style="font-size: 14px"> 在线播放</span></a></li>
        </ul>
    </div>
    </div>
</nav>
<!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!---
 
                                                   电台

--><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!---->
<div class="bigbox">
    <div class="header">
        <div class="header_left">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>最近听过的电台</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>粤语电台</td>
                </tr>
                <tr>
                    <td>轻语热歌</td>
                </tr>
                <tr>
                    <td>寂寞电台</td>
                </tr>
                <tr>
                    <td>咖啡厅</td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="header_right">
            <img src="${ctx}/images/古巨基.png" alt="古巨基" class="player_picture">
        </div>
    </div>
    <div class="content">
        <div class="fenleititle">
            <div class="fenlei_left">电台分类</div>
            <div class="fenlei_right">全部电台（666个）</div>
        </div>
        <div class="content_left">
            <span class="content_left_fenlei"><a href="#quanbu" data-toggle="tab">全部电台</a></span>
            <span class="content_left_fenlei"><a href="#zhuti" data-toggle="tab">主题电台</a></span>
            <span class="content_left_fenlei"><a href="#fengge" data-toggle="tab">风格电台</a></span>
            <span class="content_left_fenlei"><a href="#yuyan" data-toggle="tab">语言电台</a></span>
            <span class="content_left_fenlei"><a href="#renqun" data-toggle="tab">人群电台</a></span>
            <span class="content_left_fenlei"><a href="#didian" data-toggle="tab">地点电台</a></span>
            <span class="content_left_fenlei"><a href="#xinqing" data-toggle="tab">心情电台</a></span>
        </div>
        <div class="content_right tab-content">

            <!--全部标签页-->

            <div class="tab-pane fade in active" id="quanbu">
                <div class="xiaodongxi">
                    <div class="xiaodongxi_img">
                        <img src="${ctx}/images/图片/f1.jpg" width="32" height="32">
                    </div>
                    <div class="xiaodongxi_p">
                        <p><a href="#">最爱成名曲</a></p>
                        <p class="xiaodongxipp">王杰-谁明浪子心</p>
                    </div>
                </div>
                <div class="xiaodongxi">
                    <div class="xiaodongxi_img">
                        <img src="${ctx}/images/图片/f2.jpg" width="32" height="32">
                    </div>
                    <div class="xiaodongxi_p">
                        <p><a href="#">轻语热歌&nbsp;</a></p>
                        <p class="xiaodongxipp">韩红-小屁孩儿</p>
                    </div>
                </div>
                <div class="xiaodongxi">
                    <div class="xiaodongxi_img">
                        <img src="${ctx}/images/图片/f3.jpg" width="32" height="32">
                    </div>
                    <div class="xiaodongxi_p">
                        <p><a href="#">蒙面歌王&nbsp;</a></p>
                        <p class="xiaodongxipp">许茹芸-爱情三十六计</p>
                    </div>
                </div>
                <div class="xiaodongxi">
                    <div class="xiaodongxi_img">
                        <img src="${ctx}/images/图片/f4.jpg" width="32" height="32">
                    </div>
                    <div class="xiaodongxi_p">
                        <p><a href="#">盖世英雄&nbsp;</a></p>
                        <p class="xiaodongxipp">韦礼安-吻别</p>
                    </div>
                </div>
                <div class="xiaodongxi">
                    <div class="xiaodongxi_img">
                        <img src="${ctx}/images/图片/f5.jpg" width="32" height="32">
                    </div>
                    <div class="xiaodongxi_p">
                        <p><a href="#">一个人&nbsp;</a></p>
                        <p class="xiaodongxipp">萧敬腾-会痛的石头</p>
                    </div>
                </div>
                <div class="xiaodongxi">
                    <div class="xiaodongxi_img">
                        <img src="${ctx}/images/图片/f6.jpg" width="32" height="32">
                    </div>
                    <div class="xiaodongxi_p">
                        <p><a href="#">学习&nbsp;</a></p>
                        <p class="xiaodongxipp">苏打绿-背着你</p>
                    </div>
                </div>
                <div class="xiaodongxi">
                    <div class="xiaodongxi_img">
                        <img src="${ctx}/images/图片/f7.jpg" width="32" height="32">
                    </div>
                    <div class="xiaodongxi_p">
                        <p><a href="#">聚会暖场&nbsp;</a></p>
                        <p class="xiaodongxipp">韩庚-飞蛾扑火</p>
                    </div>
                </div>
                <div class="xiaodongxi">
                    <div class="xiaodongxi_img">
                        <img src="${ctx}/images/图片/f9.jpg" width="32" height="32">
                    </div>
                    <div class="xiaodongxi_p">
                        <p><a href="#">伤感&nbsp;</a></p>
                        <p class="xiaodongxipp">阿桑-叶子</p>
                    </div>
                </div>
                <div class="xiaodongxi">
                    <div class="xiaodongxi_img">
                        <img src="${ctx}/images/图片/f10.jpg" width="32" height="32">
                    </div>
                    <div class="xiaodongxi_p">
                        <p><a href="#">甜蜜&nbsp;</a></p>
                        <p class="xiaodongxipp">魏晨-爱，有你才完整</p>
                    </div>
                </div>
                <div class="xiaodongxi">
                    <div class="xiaodongxi_img">
                        <img src="${ctx}/images/图片/f11.jpg" width="32" height="32">
                    </div>
                    <div class="xiaodongxi_p">
                        <p><a href="#">80后&nbsp;</a></p>
                        <p class="xiaodongxipp">任贤齐-还有我</p>
                    </div>
                </div>
                <div class="xiaodongxi">
                    <div class="xiaodongxi_img">
                        <img src="${ctx}/images/图片/f12.jpg" width="32" height="32">
                    </div>
                    <div class="xiaodongxi_p">
                        <p><a href="#">90后&nbsp;</a></p>
                        <p class="xiaodongxipp">罗志祥-有我在</p>
                    </div>
                </div>
                <div class="xiaodongxi">
                    <div class="xiaodongxi_img">
                        <img src="${ctx}/images/图片/f13.jpg" width="32" height="32">
                    </div>
                    <div class="xiaodongxi_p">
                        <p><a href="#">流行&nbsp;</a></p>
                        <p class="xiaodongxipp">南拳妈妈-下雨天</p>
                    </div>
                </div>
                <div class="xiaodongxi">
                    <div class="xiaodongxi_img">
                        <img src="${ctx}/images/图片/f14.jpg" width="32" height="32">
                    </div>
                    <div class="xiaodongxi_p">
                        <p><a href="#">爵士&nbsp;</a></p>
                        <p class="xiaodongxipp">童安格-女人</p>
                    </div>
                </div>
                <div class="xiaodongxi">
                    <div class="xiaodongxi_img">
                        <img src="${ctx}/images/图片/z13.jpg" width="32" height="32">
                    </div>
                    <div class="xiaodongxi_p">
                        <p><a href="#">思念&nbsp;</a></p>
                        <p class="xiaodongxipp">张学友-遥远的她</p>
                    </div>
                </div>
                <div class="xiaodongxi">
                    <div class="xiaodongxi_img">
                        <img src="${ctx}/images/图片/z14.jpg" width="32" height="32">
                    </div>
                    <div class="xiaodongxi_p">
                        <p><a href="#">古风&nbsp;</a></p>
                        <p class="xiaodongxipp">清菀-月出</p>
                    </div>
                </div>
                <div class="xiaodongxi">
                    <div class="xiaodongxi_img">
                        <img src="${ctx}/images/图片/z15.jpg" width="32" height="32">
                    </div>
                    <div class="xiaodongxi_p">
                        <p><a href="#">国语&nbsp;</a></p>
                        <p class="xiaodongxipp">曹轩宾-如果你爱我</p>
                    </div>
                </div>
                <div class="xiaodongxi">
                    <div class="xiaodongxi_img">
                        <img src="${ctx}/images/图片/z16.jpg" width="32" height="32">
                    </div>
                    <div class="xiaodongxi_p">
                        <p><a href="#">2018跨界歌王&nbsp;</a></p>
                        <p class="xiaodongxipp">陈学冬-像我这样的人</p>
                    </div>
                </div>
                <div class="xiaodongxi">
                    <div class="xiaodongxi_img">
                        <img src="${ctx}/images/图片/z17.jpg" width="32" height="32">
                    </div>
                    <div class="xiaodongxi_p">
                        <p><a href="#">中文经典&nbsp;</a></p>
                        <p class="xiaodongxipp">阿杜-离别</p>
                    </div>
                </div>
                <div class="xiaodongxi">
                    <div class="xiaodongxi_img">
                        <img src="${ctx}/images/图片/z18.jpg" width="32" height="32">
                    </div>
                    <div class="xiaodongxi_p">
                        <p><a href="#">网络红歌&nbsp;</a></p>
                        <p class="xiaodongxipp">庄心妍-我以为</p>
                    </div>
                </div>
                <div class="xiaodongxi">
                    <div class="xiaodongxi_img">
                        <img src="${ctx}/images/图片/z19.jpg" width="32" height="32">
                    </div>
                    <div class="xiaodongxi_p">
                        <p><a href="#">中国好声音&nbsp;</a></p>
                        <p class="xiaodongxipp">齐雯-不管有多痛</p>
                    </div>
                </div>
                <div class="xiaodongxi">
                    <div class="xiaodongxi_img">
                        <img src="${ctx}/images/图片/z21.jpg" width="32" height="32">
                    </div>
                    <div class="xiaodongxi_p">
                        <p><a href="#">歌手&nbsp;</a></p>
                        <p class="xiaodongxipp">张韶涵-漫步云端</p>
                    </div>
                </div>
                <div class="xiaodongxi">
                    <div class="xiaodongxi_img">
                        <img src="${ctx}/images/图片/z22.jpg" width="32" height="32">
                    </div>
                    <div class="xiaodongxi_p">
                        <p><a href="#">梦想的声音&nbsp;</a></p>
                        <p class="xiaodongxipp">林忆莲-那些花儿</p>
                    </div>
                </div>
                <div class="xiaodongxi">
                    <div class="xiaodongxi_img">
                        <img src="${ctx}/images/z24.jpg" width="32" height="32">
                    </div>
                    <div class="xiaodongxi_p">
                        <p><a href="#">我是歌手&nbsp;</a></p>
                        <p class="xiaodongxipp">李克勤-丑八怪</p>
                    </div>
                </div>
                <div class="xiaodongxi">
                    <div class="xiaodongxi_img">
                        <img src="${ctx}/images/图片/z25.jpg" width="32" height="32">
                    </div>
                    <div class="xiaodongxi_p">
                        <p><a href="#">最爱成名曲&nbsp;</a></p>
                        <p class="xiaodongxipp">温岚-忍不住原谅</p>
                    </div>
                </div>
                <div class="xiaodongxi">
                    <div class="xiaodongxi_img">
                        <img src="${ctx}/images/图片/z26.jpg" width="32" height="32">
                    </div>
                    <div class="xiaodongxi_p">
                        <p><a href="#">KTV必点曲&nbsp;</a></p>
                        <p class="xiaodongxipp">张惠妹-听海</p>
                    </div>
                </div>
                <div class="xiaodongxi">
                    <div class="xiaodongxi_img">
                        <img src="${ctx}/images/1.jpg" width="32" height="32">
                    </div>
                    <div class="xiaodongxi_p">
                        <p><a href="#">幻月之城&nbsp;</a></p>
                        <p class="xiaodongxipp">袁姗姗-心跳</p>
                    </div>
                </div>
                <div class="xiaodongxi">
                    <div class="xiaodongxi_img">
                        <img src="${ctx}/images/2.jpg" width="32" height="32">
                    </div>
                    <div class="xiaodongxi_p">
                        <p><a href="#">天籁之战&nbsp;</a></p>
                        <p class="xiaodongxipp">华晨宇-一人饮酒醉</p>
                    </div>
                </div>
                <div class="xiaodongxi">
                    <div class="xiaodongxi_img">
                        <img src="${ctx}/images/15.jpg" width="32" height="32">
                    </div>
                    <div class="xiaodongxi_p">
                        <p><a href="#">中国新歌曲&nbsp;</a></p>
                        <p class="xiaodongxipp">叶炫清-想自由</p>
                    </div>
                </div>
                <div class="xiaodongxi">
                    <div class="xiaodongxi_img">
                        <img src="${ctx}/images/26.jpg" width="32" height="32">
                    </div>
                    <div class="xiaodongxi_p">
                        <p><a href="#">蒙面唱将猜猜猜&nbsp;</a></p>
                        <p class="xiaodongxipp">萱萱-我以为</p>
                    </div>
                </div>
                <div class="xiaodongxi">
                    <div class="xiaodongxi_img">
                        <img src="${ctx}/images/27.jpg" width="32" height="32">
                    </div>
                    <div class="xiaodongxi_p">
                        <p><a href="#">轻音乐&nbsp;</a></p>
                        <p class="xiaodongxipp">Bandri-秋天的落叶</p>
                    </div>
                </div>
            </div>
        </div>

        <!--主题标签页-->

        <div class="tab-pane fade" id="zhuti">
            <div class="xiaodongxi">
                <div class="xiaodongxi_img">
                    <img src="${ctx}/images/list16.jpg" width="32" height="32">
                </div>
                <div class="xiaodongxi_p">
                    <p><a href="#">轻音乐</a></p>
                    <p class="xiaodongxipp">Bandri-秋天的落叶</p>
                </div>
            </div>
            <div class="xiaodongxi">
                <div class="xiaodongxi_img">
                    <img src="${ctx}/images/list7.jpg" width="32" height="32">
                </div>
                <div class="xiaodongxi_p">
                    <p><a href="#">轻音乐&nbsp;</a></p>
                    <p class="xiaodongxipp">Bandri-秋天的落叶</p>
                </div>
            </div>
            <div class="xiaodongxi">
                <div class="xiaodongxi_img">
                    <img src="${ctx}/images/list8.jpg" width="32" height="32">
                </div>
                <div class="xiaodongxi_p">
                    <p><a href="#">轻音乐&nbsp;</a></p>
                    <p class="xiaodongxipp">Bandri-秋天的落叶</p>
                </div>
            </div>
        </div>

        <!--风格标签页-->

        <div class="tab-pane fade" id="fengge">
            <div class="xiaodongxi">
                <div class="xiaodongxi_img">
                    <img src="${ctx}/images/list38.jpg" width="32" height="32">
                </div>
                <div class="xiaodongxi_p">
                    <p><a href="#">老情歌</a></p>
                    <p class="xiaodongxipp">王杰-忘了你，忘了我</p>
                </div>
            </div>
            <div class="xiaodongxi">
                <div class="xiaodongxi_img">
                    <img src="${ctx}/images/list33.jpg" width="32" height="32">
                </div>
                <div class="xiaodongxi_p">
                    <p><a href="#">发烧女声&nbsp;</a></p>
                    <p class="xiaodongxipp">孙露-死而无憾</p>
                </div>
            </div>
            <div class="xiaodongxi">
                <div class="xiaodongxi_img">
                    <img src="${ctx}/images/list40.jpg" width="32" height="32">
                </div>
                <div class="xiaodongxi_p">
                    <p><a href="#">驾驶&nbsp;</a></p>
                    <p class="xiaodongxipp">至上励合-在路上</p>
                </div>
            </div>
        </div>

        <!--语言标签页-->

        <div class="tab-pane fade" id="yuyan">
            <div class="xiaodongxi">
                <div class="xiaodongxi_img">
                    <img src="${ctx}/images/list1.jpg" width="32" height="32">
                </div>
                <div class="xiaodongxi_p">
                    <p><a href="#">散步</a></p>
                    <p class="xiaodongxipp">苏打绿-简单生活</p>
                </div>
            </div>
            <div class="xiaodongxi">
                <div class="xiaodongxi_img">
                    <img src="${ctx}/images/list35.jpg" width="32" height="32">
                </div>
                <div class="xiaodongxi_p">
                    <p><a href="#">由你音乐榜&nbsp;</a></p>
                    <p class="xiaodongxipp">简弘亦-不染</p>
                </div>
            </div>
            <div class="xiaodongxi">
                <div class="xiaodongxi_img">
                    <img src="${ctx}/images/list26.jpg" width="32" height="32">
                </div>
                <div class="xiaodongxi_p">
                    <p><a href="#">工作&nbsp;</a></p>
                    <p class="xiaodongxipp">罗志祥-独一无二</p>
                </div>
            </div>
        </div>
    </div>
</div>

<!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!---
 
                                                   最后 页脚 

--><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!---->
<div class="footer">
    <div class="links">

    </div>
    <div class="copyright">
    </div>
</div>
<script src="${ctx}/js/jquery.min.js?v=2.1.4"></script>
<script src="${ctx}/js/bootstrap-paginator.min.js"></script>
<script src="${ctx}/js/jquery.validate.min.js"></script>
<script src="${ctx}/js/tools.js"></script>
<script src="${ctx}/js/jquery.cookie.js"></script>
<script type="text/javascript">
    if ($.cookie("user_name") != undefined && $.cookie("user_name") != "1") {
        $("#userName").text("账号：" + $.cookie("user_name"));
        $("#zhuXiao").text("注销");
        document.getElementById("touxiang").src = "${ctx}/images/touxiang2.jpg";
        $("#display1").attr("style", "display:none;");
    }

    $('#test').validate({
        submitHandler: function (form) {
            denglu($('#test').attr("action"), $('#test').serialize());
        }
    });
</script>
</body>
</html>