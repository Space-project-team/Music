<!-- 设置项目根路径全局变量 -->
<#assign ctx=request.contextPath/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"> 																			
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>轻语音乐人</title>

	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/css/musician.css">
	<link rel="shortcut icon" type="image/x-icon" href="${ctx}/images/logo1.png">
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="${ctx}/css/index.css">

</head>
<script>
	var ctx="${ctx}";
</script>
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
				<form id="test" class="form-horizontal" role="form" action="${ctx}/user/loginPage" method="post" style="padding-left: 50px;">
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
						<div id="clock">
							<p class="time">{{ time }}</p>
						</div>
					</div><!-- /.row -->
				</form>
			</div>
			<!-- 图标加上搜索框结束 -->
			<div id="col10" class="dengluzhuce">
				<a class="mymusic" href="/mymusic.html>我的音乐"></a>
				<a class="mymusic" href="/huiyuanzhongxin.html">会员中心</a>
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
			<li><a class=" erjicaidan2" href="${ctx}/index">首页</a></li>
			<li><a class=" erjicaidan2" href="${ctx}/bangdan">榜单</a></li>
			<li><a class="erjicaidan2" href="${ctx}/mv">MV</a></li>
			<li class="dropdown">
				<a class=" erjicaidan2" href="#" class="dropdown-toggle" data-toggle="dropdown">
					更多 <b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li><a class="erjicaidan" href="${ctx}/musicRadio">电台</a></li>
					<li><a class="erjicaidan" href="${ctx}/songlist">歌单</a></li>
					<li><a class="erjicaidan" href="${ctx}/singer ">歌手</a></li>
				</ul>
			</li>
		</ul>
		<ul>
			<li class="youfudong"><a style="padding: 20px 0px" href="playmusic.html"><span class="glyphicon glyphicon-shopping-cart" style="font-size: 14px"> 商城</span></a> </li>
			<li class="youfudong"><a style="padding: 20px 0px;    background-image: linear-gradient(-225deg, #FFE29F 0%, #FFA99F 48%, #FF719A 100%);" href="#"><span class="glyphicon glyphicon-headphones" style="font-size: 14px;"> 音乐人</span></a> </li>
			<li class="youfudong"><a style="padding: 20px 0px" href="#"><span class="glyphicon glyphicon-music" style="font-size: 14px"> 轻语LIVE</span></a> </li>
			<li class="youfudong"><a style="padding: 20px 0px" href="${ctx}/QQmusic"><span class="glyphicon glyphicon-star-empty" style="font-size: 14px"> 在线播放</span></a></li>
		</ul>
	</div>
	</div>
</nav>

<div class="warp">
	<div class="yinyueren-top">
			<a href="#"><img class="picture" src="${ctx}/images/y1.jpg"></a>
	</div>
	<div class="con">
		<h2>了解轻语音乐人</h2>
		<h4>什么是轻语音乐人</h4>
		<p>轻语音乐人是面向所有音乐艺人和唱片公司提供的数字音乐服务，致力于广泛推广并迅速扩大公司旗下艺人或独立音乐人的影响力。</p>
		<h4>如何加入轻语音乐人</h4>
		<p>需要音乐本人申请（经纪人、公司负责人或经音乐人授权使用作品的申请人，请在提交时附注说明）</p>
		<div class="don">
   			<img src="${ctx}/images/1234.png">
		</div>
	</div>
	<div class="eon">
		<h2>轻语音乐为您提供的</h2>
		<ul>	
			<li>
				<img src="${ctx}/images/音乐.png">
				<h4>音乐盛典 万众瞩目</h4>
				<p>一年一度的轻音乐亚洲盛典会产生专属于音乐人的奖项，轻语音乐人有机会参与盛典演出</p>
			</li>
			<li>
				<img src="${ctx}/images/耳机.png">
				<h4>海量用户 大范围曝光</h4>
				<p>您的作品将进入轻语正版曲库，并渗透到全系列产品中，让4亿用户听到您的声音</p>
			</li>
			<li>
				<img src="${ctx}/images/书本.png">
				<h4>精美周刊 专业点评</h4>
				<p>由专业乐评人每周评选出10首音乐人作品，并做成音乐周刊在轻语进行推荐</p>
			</li>
		    <li>
				<img src="${ctx}/images/旗帜.png">
				<h4>权威榜单 众望所归</h4>
				<p>排行榜每周发布一次音乐人专属榜单，好音乐用数据说话</p>
			</li>
			<li>
				<img src="${ctx}/images/拍摄.png">
				<h4>明星专访 MV拍摄</h4>
				<p>音乐人将有机会获得轻语明星专访，量身打造音乐MV的机会</p>
			</li>
			<li>
				<img src="${ctx}/images/录音.png">
				<h4>签约歌手 炫酷直播</h4>
				<p>成为繁星签约歌手，与粉丝零距离互动，开启线上万人演唱会直播</p>
			</li>
		</ul>
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
			<p style="-moz-user-select: text;-webkit-user-select: text;-ms-user-select: text; user-select:text">我们致力于推动网络正版音乐发展，相关版权合作请联系copyrights@qingyu.com</p>
			<p>信息网络传播视听节目许可证 1910666 增值电信业务经营许可证粤B2-20066666 &nbsp;&nbsp;&nbsp;<a hidefocus="true" target="_blank" href="http://www.miitbeian.gov.cn/"></a><span class="footerIcon"><a target="_blank" href="http://sq.ccm.gov.cn:80/ccnt/sczr/service/business/emark/toDetail/E64D2439A71544C7B995FC0A53D8F965">&nbsp;&nbsp;&nbsp;&nbsp;</a></span></p>
			<p>广播电视节目制作经营许可证（粤）字第01270号&nbsp;&nbsp;&nbsp;&nbsp;营业性演出许可证穗天演440106026</p>
			<p>穗公网监备案证第44010650010167&nbsp;&nbsp;&nbsp;&nbsp;互联网药品信息服务资格证编号（粤）-非经营性-2012-0018<a style="" target="_blank" href="#">&nbsp;&nbsp;&nbsp;<span></span></a></p>
			<p style="-moz-user-select: text;-webkit-user-select: text;-ms-user-select: text; user-select:text">不良信息举报邮箱：jubao_music@qingyu.net&nbsp;&nbsp;&nbsp;&nbsp;客服邮箱：kefu@qingyu.net</p>
			<p>Copyright&nbsp;&nbsp;©&nbsp;&nbsp;2004-2018 QingYu-Inc.All Rights Reserved
				<a hidefocus="true" class="office-verification" href="http://netadreg.gzaic.gov.cn/ntmm/WebSear/WebLogoPub.aspx?logo=440106106022006022000209" target="_blank"></a>
			</p>
		</div>
	</div>
<script src="${ctx}/js/jquery.min.js?v=2.1.4"></script>
<script src="${ctx}/js/bootstrap-paginator.min.js"></script>
<script src="${ctx}/js/jquery.validate.min.js"></script>
<script src="${ctx}/js/tools.js"></script>
<script src="${ctx}/js/jquery.cookie.js"></script>
<script type="text/javascript" src="${ctx}/js/vue.min.js"></script>
<script type="text/javascript">


    if ($.cookie("user_name")!=undefined  && $.cookie("user_name")!="1"){
        $("#userName").text("账号："+$.cookie("user_name"));
        $("#zhuXiao").text("注销");


        document.getElementById("touxiang").src=""+$.cookie("user_headImage");
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