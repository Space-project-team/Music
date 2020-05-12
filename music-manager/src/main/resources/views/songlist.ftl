<!-- 设置项目根路径全局变量 -->
<#assign ctx=request.contextPath/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"> 																			
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>歌单</title>

	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/css/songlist.css">
	<link rel="shortcut icon" type="image/x-icon" href="${ctx}/images/logo1.png">
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="${ctx}/css/index.css">

</head>
<body >
<!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!---

                                                      模态框（Modal）

--><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!----><!---->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="overflow: auto;">
	<div class="modal-dialog" style="overflow: auto;">
		<div class="modal-content"style="overflow: auto;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="false">X</button>
				<h4 class="modal-title" id="myModalLabel">账号密码登录</h4>
			</div>
			<div class="modal-body" style="position: relative;">
				<form id="test" class="form-horizontal" role="form" action="/user/loginPage" method="post" style="padding-left: 50px;">
					<div class="form-group">
						<img src="${ctx}/images/logo2.png" style="display: block; padding: 20px 151px">
						<div class="erweima"><img src="${ctx}/images/二维码2.jpg" style="position: absolute;width: 130px;
						height: 130px;bottom: 136px;right: 31px;">
							<p style="position: absolute;right: 64px;bottom: 106px;">联系我们</p>
						</div>
						<label class="col-sm-2 control-label">
							<span class="glyphicon glyphicon-user">账号</span>
						</label>
						<div  class="col-sm-10">
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
							<button  class="btn btn-primary" data-dismiss="btn btn-default" style="background-color: #169af3;padding: 5px 30px">登 &nbsp&nbsp&nbsp&nbsp录</button>
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
		<div class="logo1" style="width: 153px; padding: 20.6px 0; display: inline-block;"><img src="${ctx}/images/logo2.png" alt=""><a href=""></a></div>
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
				<a class="mymusic" href="${ctx}/mymusic  ">我的音乐</a>
				<a class="mymusic" href="/huiyuanzhongxin.html ">会员中心</a>
				<span class="mymusic">|</span>
				<img id="touxiang" src="${ctx}/images/touxiang.png" width="40px" height="40px" style="display: inline-block; width: 40px;height: 40px;border:0;border-radius: 40px;margin-bottom: 5px;">
				<a id="userName" style="cursor: pointer;" class="mymusic" href="#">
					未登录</a>
				<a id="zhuXiao" onclick="zhuXiao();location.reload();" href="#">
				</a>
				<button id="display1" class="btn denglu" data-toggle="modal" data-target="#myModal">登 &nbsp&nbsp录</button> <!--触发模态框按钮-->
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
			<li><a class="erjicaidan2" href="${ctx}/mv   ">MV</a></li>
			<li class="dropdown">
				<a class="gudingbeij erjicaidan2" href="#" class="dropdown-toggle" data-toggle="dropdown">
					更多 <b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li><a class="erjicaidan" href="${ctx}/musicRadio  ">电台</a></li>
					<li><a class="erjicaidan" href="#">歌单</a></li>
					<li><a class="erjicaidan" href="${ctx}/singer">歌手</a></li>
				</ul>
			</li>
		</ul>
		<ul>
			<li class="youfudong"><a style="padding: 20px 0px" href="playmusic.html"><span class="glyphicon glyphicon-shopping-cart" style="font-size: 14px"> 商城</span></a> </li>
			<li class="youfudong"><a style="padding: 20px 0px" href="${ctx}/musician"><span class="glyphicon glyphicon-headphones" style="font-size: 14px"> 音乐人</span></a> </li>
			<li class="youfudong"><a style="padding: 20px 0px" href="playmusic.html"><span class="glyphicon glyphicon-music" style="font-size: 14px"> 轻语LIVE</span></a> </li>
			<li class="youfudong"><a style="padding: 20px 0px" href="${ctx}/QQmusic"><span class="glyphicon glyphicon-star-empty" style="font-size: 14px"> 在线播放</span></a></li>
		</ul>
	</div>
	</div>
</nav>

	
	
<!--歌单-->
	<div class="content">
		<div class="content_left">
			<div class="menu"><a href="#tuijian" data-toggle="tab">推荐</a></div>
			<div class="menu"><a href="#zuire" data-toggle="tab">最热</a></div>
			<div class="menu"><a href="#recang" data-toggle="tab">热藏</a></div>
			<div class="menu"><a href="#biaosheng" data-toggle="tab">飙升</a></div>
		</div>
		<div class="content_right tab-content">
			
				<!--推荐标签页-->
			
			<div class="tab-pane fade in active" id="tuijian">
				<div class="gedan_tuijian">
					<img src="${ctx}/images/gedan_1.jpg" class="gedanpicture">
					<div class="gedanfont">
						<span class="gedanfonthover"><a href="#">新年愿望：来一场甜蜜的暴击吧！</a><span class="spanright">制作人：OPPO</span></span>
						<div class="gedanjieshao">
							<p>
								听说把糖放进枕头底下会做一个甜甜的梦，梦里会有漫天星光，还有你的笑脸 。梦醒了，天亮了，是该谈一场甜甜的恋爱啦。于是我向月老许愿：在钟声敲响的那一刻，你会乘着OPPO R17 Pro的电波，向我道一声：“新年好啊！”
							</p>
						</div>
						<div class="gedanbtn">
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-play"></i>播放全部</span></a>
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-share"></i>分享</span></a>
						</div>
					</div>
				</div>
				<div class="gedan_tuijian">
					<img src="${ctx}/images/15.jpg" class="gedanpicture">
					<div class="gedanfont">
						<span class="gedanfonthover"><a href="#">烦躁的世界里做个清静的人</a><span class="spanright">制作人：烦了</span></span>
						<div class="gedanjieshao">
							<p>
								抛开世间的杂音，与音乐为伴，清新每一天
							</p>
						</div>
						<div class="gedanbtn">
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-play"></i>播放全部</span></a>
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-share"></i>分享</span></a>
						</div>
					</div>
				</div>
				<div class="gedan_tuijian">
					<img src="${ctx}/images/26.jpg" class="gedanpicture">
					<div class="gedanfont">
						<span class="gedanfonthover"><a href="#">每周推荐歌曲</a><span class="spanright">制作人：轻语号歌单君</span></span>
						<div class="gedanjieshao">
							<p>
								每周推荐歌曲
							</p>
						</div>
						<div class="gedanbtn">
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-play"></i>播放全部</span></a>
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-share"></i>分享</span></a>
						</div>
					</div>
				</div>
				<div class="gedan_tuijian">
					<img src="${ctx}/images/29.jpg" class="gedanpicture">
					<div class="gedanfont">
						<span class="gedanfonthover"><a href="#">怀旧花园：记忆中的那台欧美留声机</a><span class="spanright">制作人：正小守</span></span>
						<div class="gedanjieshao">
							<p>
								在黄昏的静谧雨夜，你听到过在满溢浓香的咖啡馆，你听到过在你用力拥抱幸福的时候，你听到过的都是一些熟悉的调子这些异国的旋律，在你父辈年轻的时候......
							</p>
						</div>
						<div class="gedanbtn">
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-play"></i>播放全部</span></a>
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-share"></i>分享</span></a>
						</div>
					</div>
				</div>
				<div class="gedan_tuijian">
					<img src="${ctx}/images/34.jpg" class="gedanpicture">
					<div class="gedanfont">
						<span class="gedanfonthover"><a href="#">慕寒：远山长慕，寒鸦声渡</a><span class="spanright">制作人：千金大小姐M</span></span>
						<div class="gedanjieshao">
							<p>
								岁岁念朝暮，为你收集慕寒那些惊艳了时光的单曲....
							</p>
						</div>
						<div class="gedanbtn">
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-play"></i>播放全部</span></a>
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-share"></i>分享</span></a>
						</div>
					</div>
				</div>
			</div>
			
			
			<!--最热标签页-->
			<div class="tab-pane fade" id="zuire">
				<div class="gedan_tuijian">
					<img src="${ctx}/images/39.jpg" class="gedanpicture">
					<div class="gedanfont">
						<span class="gedanfonthover"><a href="#">我愿用十年，换你一句好久不见</a><span class="spanright">制作人：念安娜</span></span>
						<div class="gedanjieshao">
							<p>
								昔日的恋人，固定的节日，街角的咖啡馆，这些好像都是重逢不可或缺的元素。倘若你坐在路边喝着咖啡，不经意看见自己昔日的恋人，你会上前寒暄问候，还是悄然离开任凭往事挤满心上？

								重逢，是一种恩赐。虽然并不是每一次的重逢都是幸福或喜悦的，但是世间万千变化，城市人海涨落，能够重新遇见就是莫大的幸运。不知你可曾拥有过这份幸运？即使最后只能擦肩而过。

								有时候，会突然失去自我的开始寻找下一个出口，只是为了能看清迷宫一样的未来。

								如今仿佛我对重逢这个词有了新的理解，释怀，放开自己的心。或许就能邂逅下一段美好，此刻仿佛让我想起了八十年代的重逢，如果你生活在那个年代，你在哪里最容易想起往事，又会想在哪里重逢你的昔日恋人......
							</p>
						</div>
						<div class="gedanbtn">
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-play"></i>播放全部</span></a>
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-share"></i>分享</span></a>
						</div>
					</div>
				</div>
				<div class="gedan_tuijian">
					<img src="${ctx}/images/29.jpg" class="gedanpicture">
					<div class="gedanfont">
						<span class="gedanfonthover"><a href="#">元旦心愿屋：2019，请对我好一点</a><span class="spanright">制作人：歌单小编</span></span>
						<div class="gedanjieshao">
							<p>
								元旦心愿屋：2019，请对我好一点
							</p>
						</div>
						<div class="gedanbtn">
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-play"></i>播放全部</span></a>
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-share"></i>分享</span></a>
						</div>
					</div>
				</div>
				<div class="gedan_tuijian">
					<img src="${ctx}/images/30.jpg" class="gedanpicture">
					<div class="gedanfont">
						<span class="gedanfonthover"><a href="#">小编每日精选：原创古风</a><span class="spanright">制作人：小龙</span></span>
						<div class="gedanjieshao">
							<p>
								为您推荐时下最新的优质原创古风歌曲，一个歌单了解近期古风圈的优质原创
							</p>
						</div>
						<div class="gedanbtn">
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-play"></i>播放全部</span></a>
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-share"></i>分享</span></a>
						</div>
					</div>
				</div>
				<div class="gedan_tuijian">
					<img src="${ctx}/images/32.jpg" class="gedanpicture">
					<div class="gedanfont">
						<span class="gedanfonthover"><a href="#">清晨时分:适合早读时听的纯音乐</a><span class="spanright">制作人：安</span></span>
						<div class="gedanjieshao">
							<p>
								悠悠旋律配上清晨的那第一缕阳光是你享受阅读的最佳搭配...
							</p>
						</div>
						<div class="gedanbtn">
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-play"></i>播放全部</span></a>
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-share"></i>分享</span></a>
						</div>
					</div>
				</div>
				<div class="gedan_tuijian">
					<img src="${ctx}/images/38.jpg" class="gedanpicture">
					<div class="gedanfont">
						<span class="gedanfonthover"><a href="#">粤语经典：岁月留情，回味浪漫</a><span class="spanright">制作人：Sea-En</span></span>
						<div class="gedanjieshao">
							<p>
								曾几何时，听粤语歌是一种情怀，是一代人的情愫。粤语的独特魅力不仅仅是在语言上，而是在
								那个时代背景下，人们渴望接触到西方的潮流，应运而生的就是对粤语歌的追捧，久而久之粤语
								就成为生活中的一部分、字里行间的味道也不是其他歌曲可比拟的。三
							</p>
						</div>
						<div class="gedanbtn">
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-play"></i>播放全部</span></a>
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-share"></i>分享</span></a>
						</div>
					</div>
				</div>
			</div>
			
			<!--热藏标签页-->
			
			<div class="tab-pane fade" id="recang">
				<div class="gedan_tuijian">
					<img src="${ctx}/images/gedan_3.jpg" class="gedanpicture">
					<div class="gedanfont">
						<span class="gedanfonthover"><a href="#">古风现场：穿越千年的直播盛宴</a><span class="spanright">制作人：元萧</span></span>
						<div class="gedanjieshao">
							<p>
								世间千年,如我一瞬。
								虚幻大千两茫茫,一邂逅,终难忘。
								历经千年，仿佛就在当世，我苦守千年，心意始终如一。
								吾独自穿越千年时光，能否在今天，将一切画上句点?
								穿越千年风尘，只为与你邂逅在这一场古风歌曲的直播盛宴上。
							</p>
						</div>
						<div class="gedanbtn">
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-play"></i>播放全部</span></a>
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-share"></i>分享</span></a>
						</div>
					</div>
				</div>
				<div class="gedan_tuijian">
					<img src="${ctx}/images/gedan_3.jpg" class="gedanpicture">
					<div class="gedanfont">
						<span class="gedanfonthover"><a href="#">古风现场：穿越千年的直播盛宴</a><span class="spanright">制作人：元萧</span></span>
						<div class="gedanjieshao">
							<p>
								世间千年,如我一瞬。
								虚幻大千两茫茫,一邂逅,终难忘。
								历经千年，仿佛就在当世，我苦守千年，心意始终如一。
								吾独自穿越千年时光，能否在今天，将一切画上句点?
								穿越千年风尘，只为与你邂逅在这一场古风歌曲的直播盛宴上。
							</p>
						</div>
						<div class="gedanbtn">
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-play"></i>播放全部</span></a>
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-share"></i>分享</span></a>
						</div>
					</div>
				</div>
				<div class="gedan_tuijian">
					<img src="${ctx}/images/gedan_3.jpg" class="gedanpicture">
					<div class="gedanfont">
						<span class="gedanfonthover"><a href="#">古风现场：穿越千年的直播盛宴</a><span class="spanright">制作人：元萧</span></span>
						<div class="gedanjieshao">
							<p>
								世间千年,如我一瞬。
								虚幻大千两茫茫,一邂逅,终难忘。
								历经千年，仿佛就在当世，我苦守千年，心意始终如一。
								吾独自穿越千年时光，能否在今天，将一切画上句点?
								穿越千年风尘，只为与你邂逅在这一场古风歌曲的直播盛宴上。
							</p>
						</div>
						<div class="gedanbtn">
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-play"></i>播放全部</span></a>
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-share"></i>分享</span></a>
						</div>
					</div>
				</div>
				<div class="gedan_tuijian">
					<img src="${ctx}/images/gedan_3.jpg" class="gedanpicture">
					<div class="gedanfont">
						<span class="gedanfonthover"><a href="#">古风现场：穿越千年的直播盛宴</a><span class="spanright">制作人：元萧</span></span>
						<div class="gedanjieshao">
							<p>
								世间千年,如我一瞬。
								虚幻大千两茫茫,一邂逅,终难忘。
								历经千年，仿佛就在当世，我苦守千年，心意始终如一。
								吾独自穿越千年时光，能否在今天，将一切画上句点?
								穿越千年风尘，只为与你邂逅在这一场古风歌曲的直播盛宴上。
							</p>
						</div>
						<div class="gedanbtn">
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-play"></i>播放全部</span></a>
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-share"></i>分享</span></a>
						</div>
					</div>
				</div>
				<div class="gedan_tuijian">
					<img src="${ctx}/images/gedan_3.jpg" class="gedanpicture">
					<div class="gedanfont">
						<span class="gedanfonthover"><a href="#">古风现场：穿越千年的直播盛宴</a><span class="spanright">制作人：元萧</span></span>
						<div class="gedanjieshao">
							<p>
								世间千年,如我一瞬。
								虚幻大千两茫茫,一邂逅,终难忘。
								历经千年，仿佛就在当世，我苦守千年，心意始终如一。
								吾独自穿越千年时光，能否在今天，将一切画上句点?
								穿越千年风尘，只为与你邂逅在这一场古风歌曲的直播盛宴上。
							</p>
						</div>
						<div class="gedanbtn">
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-play"></i>播放全部</span></a>
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-share"></i>分享</span></a>
						</div>
					</div>
				</div>
			</div>
			
			<!--飙升标签页-->
			
			<div class="tab-pane fade" id="biaosheng">
				<div class="gedan_tuijian">
					<img src="${ctx}/images/gedan_4.jpg" class="gedanpicture">
					<div class="gedanfont">
						<span class="gedanfonthover"><a href="#">烦躁的世界里做个清静的人</a><span class="spanright">制作人：烦了</span></span>
						<div class="gedanjieshao">
							<p>
								抛开世间的杂音，与音乐为伴，清新每一天
							</p>
						</div>
						<div class="gedanbtn">
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-play"></i>播放全部</span></a>
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-share"></i>分享</span></a>
						</div>
					</div>
				</div>
				<div class="gedan_tuijian">
					<img src="${ctx}/images/gedan_4.jpg" class="gedanpicture">
					<div class="gedanfont">
						<span class="gedanfonthover"><a href="#">烦躁的世界里做个清静的人</a><span class="spanright">制作人：烦了</span></span>
						<div class="gedanjieshao">
							<p>
								抛开世间的杂音，与音乐为伴，清新每一天
							</p>
						</div>
						<div class="gedanbtn">
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-play"></i>播放全部</span></a>
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-share"></i>分享</span></a>
						</div>
					</div>
				</div>
				<div class="gedan_tuijian">
					<img src="${ctx}/images/gedan_4.jpg" class="gedanpicture">
					<div class="gedanfont">
						<span class="gedanfonthover"><a href="#">烦躁的世界里做个清静的人</a><span class="spanright">制作人：烦了</span></span>
						<div class="gedanjieshao">
							<p>
								抛开世间的杂音，与音乐为伴，清新每一天
							</p>
						</div>
						<div class="gedanbtn">
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-play"></i>播放全部</span></a>
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-share"></i>分享</span></a>
						</div>
					</div>
				</div>
				<div class="gedan_tuijian">
					<img src="${ctx}/images/gedan_4.jpg" class="gedanpicture">
					<div class="gedanfont">
						<span class="gedanfonthover"><a href="#">烦躁的世界里做个清静的人</a><span class="spanright">制作人：烦了</span></span>
						<div class="gedanjieshao">
							<p>
								抛开世间的杂音，与音乐为伴，清新每一天
							</p>
						</div>
						<div class="gedanbtn">
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-play"></i>播放全部</span></a>
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-share"></i>分享</span></a>
						</div>
					</div>
				</div>
				<div class="gedan_tuijian">
					<img src="${ctx}/images/gedan_4.jpg" class="gedanpicture">
					<div class="gedanfont">
						<span class="gedanfonthover"><a href="#">烦躁的世界里做个清静的人</a><span class="spanright">制作人：烦了</span></span>
						<div class="gedanjieshao">
							<p>
								抛开世间的杂音，与音乐为伴，清新每一天
							</p>
						</div>
						<div class="gedanbtn">
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-play"></i>播放全部</span></a>
							<a href="#" class="sss"><span><i class="glyphicon glyphicon-share"></i>分享</span></a>
						</div>
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
			<a hidefocus="true" href="#" target="_blank">关于轻语</a>|
			<a hidefocus="true" href="#" id="report">监督举报</a> | 
			<a hidefocus="true" href="#" target="_blank">广告服务</a> | 
			<a hidefocus="true" target="_blank" href="#">版权指引</a>|
			<a target="_blank" href="#">隐私政策</a>| 
			<a hidefocus="true" target="_blank" href="#">用户服务协议</a> | 
			<a hidefocus="true" target="_blank" href="#">推广合作</a> | 
			<a hidefocus="true" target="_blank" href="#">轻语音乐人</a> |
			<a hidefocus="true" target="_blank" href="#">轻语音乐推</a> |
			<a hidefocus="true" href="#" target="_blank">招聘信息</a> | 
			<a hidefocus="true" href="#" target="_blank">客服中心</a> | 
			<a hidefocus="true" href="#" target="_blank">用户体验提升计划</a>
		</div>
		<div class="copyright">
				<a hidefocus="true" class="office-verification" href="http://netadreg.gzaic.gov.cn/ntmm/WebSear/WebLogoPub.aspx?logo=440106106022006022000209" target="_blank"></a>
			</p>
		</div>
	</div>
<script src="${ctx}/js/jquery.min.js?v=2.1.4"></script>
<script src="${ctx}/js/bootstrap-paginator.min.js"></script>
<script src="${ctx}/js/jquery.validate.min.js"></script>
<script src="${ctx}/js/tools.js"></script>
<script src="${ctx}/js/jquery.cookie.js"></script>
<script type="text/javascript">


    if ($.cookie("user_name")!=undefined  && $.cookie("user_name")!="1"){
        $("#userName").text("账号："+$.cookie("user_name"));
        $("#zhuXiao").text("注销");


        document.getElementById("touxiang").src="${ctx}/images/touxiang2.jpg";
        $("#display1").attr("style","display:none;");
    }

    $('#test').validate({
        errorPlacement: function(error, element) {
            error.appendTo(element.parent());
        },
        onfocusout:function(element){
            $(element).valid();
        },
        submitHandler: function (form) {
            denglu($('#test').attr("action"), $('#test').serialize());


        }
    });


</script>
	</body>
	</html>