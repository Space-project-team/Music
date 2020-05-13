<!-- 设置项目根路径全局变量 -->
<#assign ctx=request.contextPath/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"> 																			
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>歌手</title>

	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/css/singer.css">
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
					<li><a class="erjicaidan" href="${ctx}/songlist  ">歌单</a></li>
					<li><a class="erjicaidan" href="#">歌手</a></li>
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
	
<div class="big">
	<div class="l">
		<ul class="sng1">
			<li class="all">
				<a title="全部歌手" class="hover" href="#" >全部歌手</a>
			</li>
			<li class="all">
				<a title="华语男歌手" class="hover" href="#">华语男歌手</a>
			</li>
			<li class="all">
				<a title="华语女歌手" class="hover" href="#">华语女歌手</a>
			</li>
			<li class="all">
				<a title="华语组合" class="hover" href="#">华语组合</a>
			</li>
		</ul>
		<ul class="sng2">
			<li class="all">
				<a title="日韩男歌手" class="hover" href="#" >日韩男歌手</a>
			</li>
			<li class="all">
				<a title="日韩女歌手" class="hover" href="#" >日韩女歌手</a>
			</li>
			<li class="all">
				<a title="日韩组合" class="hover" href="#" >日韩组合</a>
			</li>
		</ul>
		<ul class="sng3">
			<li class="all">
				<a title="欧美男歌手" class="hover" href="#" >欧美男歌手</a>
			</li>
			<li class="all">
				<a title="欧美女歌手" class="hover" href="#" >欧美女歌手</a>
			</li>
			<li class="all">
				<a title="欧美组合" class="hover" href="#" >欧美组合</a>
			</li>
			<li class="oth">
				<a title="其他歌手" class="hover" href="#">其他</a>
			</li>
		</ul>
	</div>
	<div class="r">
		<div class="zimu">
			<div class="num">
				<a title="热门歌手" href="#">热门</a>
				<a href="#">A</a>
				<a href="#">B</a>
				<a href="#">C</a>
				<a href="#">D</a>
				<a href="#">E</a>
				<a href="#">F</a>
				<a href="#">G</a>
				<a href="#">H</a>
				<a href="#">I</a>
				<a href="#">J</a>
				<a href="#">K</a>
				<a href="#">L</a>
				<a href="#">M</a>
				<a href="#">N</a>
				<a href="#">O</a>
				<a href="#">P</a>
				<a href="#">Q</a>
				<a href="#">R</a>
				<a href="#">S</a>
				<a href="#">T</a>
				<a href="#">U</a>
				<a href="#">V</a>
				<a href="#">W</a>
				<a href="#">X</a>
				<a href="#">Y</a>
				<a href="#">Z</a>
				<a title="其他歌手" href="#">其他</a>
			</div>
		</div>
		<div class="zhong">
			<div class="singerpn">
				<a href="#"><img src="${ctx}/images/s1.jpg" alt="刘德华" class="singerpicture"></a>
				<span class="st"><strong>1st</strong></span>
				<span class="singername">刘德华</span>
			</div>
			<div class="singerpn">
				<a href="#"><img src="${ctx}/images/s2.jpg" alt="薛之谦" class="singerpicture"></a>
				<span class="st"><strong>2nd</strong></span>
				<span class="singername">薛之谦</span>
			</div>
			<div class="singerpn">
				<a href="#"><img src="${ctx}/images/s3.jpg" alt="林俊杰" class="singerpicture"></a>
				<span class="st"><strong>3rd</strong></span>
				<span class="singername">林俊杰</span>
			</div>
			<div class="singerpn">
				<a href="#"><img src="${ctx}/images/s4.jpg" alt="周杰伦" class="singerpicture"></a>
				<span class="st"><strong>4th</strong></span>
				<span class="singername">周杰伦</span>
			</div>
			<div class="singerpn">
				<a href="#"><img src="${ctx}/images/s5.jpg" alt="邓紫棋" class="singerpicture"></a>
				<span class="st"><strong>5th</strong></span>
				<span class="singername">邓紫棋</span>
			</div>
			<div class="singerpn">
				<a href="#"><img src="${ctx}/images/s6.jpg" alt="TFBOYS" class="singerpicture"></a>
				<span class="st"><strong>6th</strong></span>
				<span class="singername">TFBOYS</span>
			</div>
			<div class="singerpn">
				<a href="#"><img src="${ctx}/images/s7.jpg" alt="毛不易" class="singerpicture"></a>
				<span class="st"><strong>7th</strong></span>
				<span class="singername">毛不易</span>
			</div>
			<div class="singerpn">
				<a href="#"><img src="${ctx}/images/s8.jpg" alt="张杰" class="singerpicture"></a>
				<span class="st"><strong>8th</strong></span>
				<span class="singername">张杰</span>
			</div>
			<div class="singerpn">
				<a href="#"><img src="${ctx}/images/s9.jpg" alt="张学友" class="singerpicture"></a>
				<span class="st"><strong>9th</strong></span>
				<span class="singername">张学友</span>
			</div>
			<div class="singerpn">
				<a href="#"><img src="${ctx}/images/s10.jpg" alt="易烊千玺" class="singerpicture"></a>
				<span class="st"><strong>10th</strong></span>
				<span class="singername">易烊千玺</span>
			</div>
			<div class="singerpn">
				<a href="#"><img src="${ctx}/images/s11.jpg" alt="刀郎" class="singerpicture">
				</a>				<span class="st"><strong>11th</strong></span>
				<span class="singername">刀郎</span>
			</div>
			<div class="singerpn">
				<a href="#"><img src="${ctx}/images/s12.jpg" alt="李荣浩" class="singerpicture"></a>
				<span class="st"><strong>12th</strong></span>
				<span class="singername">李荣浩</span>
			</div>
			<div class="singerpn">
				<a href="#"><img src="${ctx}/images/s13.jpg" alt="王俊凯" class="singerpicture"></a>
				<span class="st"><strong>13th</strong></span>
				<span class="singername">王俊凯</span>
			</div>
			<div class="singerpn">
				<a href="#"><img src="${ctx}/images/s14.jpg" alt="半阳" class="singerpicture"></a>
				<span class="st"><strong>14th</strong></span>
				<span class="singername">半阳</span>
			</div>
			<div class="singerpn">
				<a href="#"><img src="${ctx}/images/s15.jpg" alt="陈奕迅" class="singerpicture"></a>
				<span class="st"><strong>15th</strong></span>
				<span class="singername">陈奕迅</span>
			</div>
			<div class="singerpn">
				<a href="#"><img src="${ctx}/images/s16.jpg" alt="蔡徐坤" class="singerpicture"></a>
				<span class="st"><strong>16th</strong></span>
				<span class="singername">蔡徐坤</span>
			</div>
			<div class="singerpn">
				<a href="#"><img src="${ctx}/images/s17.jpg" alt="华晨宇" class="singerpicture"></a>
				<span class="st"><strong>17th</strong></span>
				<span class="singername">华晨宇</span>
			</div>
			<div class="singerpn">
				<a href="#"><img src="${ctx}/images/s18.jpg" alt="陈立农" class="singerpicture"></a>
				<span class="st"><strong>18th</strong></span>
				<span class="singername">陈立农</span>
			</div>
		</div>
		<div class="boxbox">
			<table class="table">
				<tbody>
					<tr class="active">
						<td>19 <img src="${ctx}/images/下降.png"> <a href="#">庄心妍</a></td>
						<td>27 <img src="${ctx}/images/下降.png"> <a href="#">白小白</a></td>
						<td>35 <img src="${ctx}/images/下降.png"> <a href="#">冷漠</a></td>
					</tr>
					<tr class="success">
						<td>20 <img src="${ctx}/images/上升.png"> <a href="#">凤凰传奇</a></td>
						<td>28 <img src="${ctx}/images/上升.png"> <a href="#">周华健</a></td>
						<td>36 <img src="${ctx}/images/下降.png"> <a href="#">Alan Walker</a></td>
					</tr>
					<tr  class="warning">
						<td>21 <img src="${ctx}/images/下降.png"> <a href="#">黄家驹</a></td>
						<td>29 <img src="${ctx}/images/下降.png"> <a href="#">汪苏泷</a></td>
						<td>37 <img src="${ctx}/images/上升.png"> <a href="#">张艺兴</a></td>
					</tr>
					<tr  class="danger">
						<td>22 <img src="${ctx}/images/下降.png"> <a href="#">花姐</a></td>
						<td>30 <img src="${ctx}/images/上升.png"> <a href="#">火箭少女101</a></td>
						<td>38 <img src="${ctx}/images/上升.png"> <a href="#">张靓颖</a></td>
					</tr>
					<tr class="active">
						<td>23 <img src="${ctx}/images/上升.png"> <a href="#">许嵩</a></td>
						<td>31 <img src="${ctx}/images/上升.png"> <a href="#">王杰</a></td>
						<td>39 <img src="${ctx}/images/上升.png"> <a href="#">艾辰</a></td>
					</tr>
					<tr class="success">
						<td>24 <img src="${ctx}/images/上升.png"> <a href="#">王源</a></td>
						<td>32 <img src="${ctx}/images/上升.png"> <a href="#">卓依婷</a></td>
						<td>40 <img src="${ctx}/images/下降.png"> <a href="#">虎二</a></td>
					</tr>
					<tr  class="warning">
						<td>25 <img src="${ctx}/images/下降.png"> <a href="#">郑源</a></td>
						<td>33 <img src="${ctx}/images/上升.png"> <a href="#">鹿晗</a></td>
						<td>41 <img src="${ctx}/images/下降.png"> <a href="#">邓丽君</a></td>
					</tr>
					<tr  class="danger">
						<td>26 <img src="${ctx}/images/上升.png"> <a href="#">张宇</a></td>
						<td>34 <img src="${ctx}/images/上升.png"> <a href="#">孙露</a></td>
						<td>42 <img src="${ctx}/images/下降.png"> <a href="#">张韶涵</a></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="nvg">
			<ul class="pagination pagination-sm">
				<li><a href="#">&laquo;</a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#">&raquo;</a></li>
			</ul>
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


	/**
	 * 查询与更新歌手排行榜
	 * */
	function getSingerList(page) {
		$.ajax({
			url: "${ctx}/singer/getSingerList",      //后台获取整个数据库方法的地址
			type: "POST",
			data: {
				pageNum: page,
				pageSize:42,
			},
			success: function (data) {
				if (data.code==200) {
					var str = '';                                                   //动态生成表格
					/* data.data.list.length对应respon.map.list.length */
					for (var i = 0; i < data.pageInfo.list.length; i++) {
						var a = i + 1;
						/*1-18为有图片的显示*/
						if(a<=18){
							str += '<div class="singerpn">'
									+ '<a href="#"><img src='+data.pageInfo.list[i].headImage+'${ctx}/images/s1.jpg" alt="刘德华" class="singerpicture"></a>'
									+'<span class="st"><strong>1st</strong></span>'
									+'<span class="singername">刘德华</span>'
									+ '</div>'
						}





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

					//获取分页模板
					var pageTemp = doT.template($("#pageTemplate").text());
					//填充数据
					$("#pageContent").html(pageTemp(data.pageInfo));

				} else {   //如果后台返回202则提示歌曲已收藏
					alert("您还没有收藏歌曲哦，快去列表收藏吧！");
				}
			},
			error: function (data) {
				alert(JSON.stringify(data));//连接失败弹窗
			}
		})
	}

</script>
	</body>
	</html>