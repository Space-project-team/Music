<!-- 设置项目根路径全局变量 -->
<#assign ctx=request.contextPath/>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>test</title>

    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${ctx}/css/register.css">

</head>

<body class="gray-bg">
    <div id="nav">
        <div class="nav">
            <ul class="n1" id="ulHeader">
                <li class="home"><img src="${ctx}/images/logo2.png" width="170" height="40" alt="轻语音乐" class="logo2"><a href="#" title="轻语商城">轻语商城</a><span></span></li>
                <li class="" id="downloadLink"><a href="#" title="下载客户端" target="_blank">下载客户端</a><span></span></li>
                <li><a href="#" hidefocus="true" title="音乐直播" target="_blank">音乐直播</a><span></span></li>
                <li><a href="#" title="轻语音乐人" target="_self">轻语音乐人</a><span></span></li>
            </ul>
            <ul class="n2 n2_new">
                <li><a href="#" target="_blank" title="轻语音乐盒2019官方免费下载">产品中心</a><span></span></li>
                <li><a href="#" target="_blank" title="VIP中心">VIP中心</a><span></span></li>
                <li><a href="#" target="_blank" title="客服中心">客服中心</a><span></span></li>
            </ul>
        </div>
    </div>
    <div id="content">
        <div class="boxb">
            <h3><span class="glyphicon glyphicon-star">&nbsp修改密码</span></h3><br /><br />
            <div class="wrapper wrapper-content animated fadeInRight">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                            </div>
                            <div class="ibox-content">
                                <form id="test" role="form" action="/user/resetUserPassword" method="post">
                                    <div class="form-group">
                                        <!-- 表单 -->
                                        <label for="username" class="col-sm-2 control-label">用户名:</label> <!-- 表单 -->
                                        <div class="col-sm-10" style="margin: 0 0 20px">
                                            <input type="text" class="form-control" id="user_name" name="user_name" placeholder="请输入用户名" size="20">
                                        </div>
                                    </div>
                                   <!--  <div class="form-group">
                                        <label for="password" class="col-sm-2 control-label">旧密码:</label>
                                        <div class="col-sm-10" style="margin: 0 0 20px">
                                            <input type="password" class="form-control" id="user_password" name="user_password" placeholder="请输入密码" size="20">
                                        </div>
                                    </div>  --> 
                                    <div class="form-group">
                                        <label for="password" class="col-sm-2 control-label">新密码:</label>
                                        <div class="col-sm-10" style="margin: 0 0 20px">
                                            <input type="password" class="form-control" id="newUser_password" name="newUser_password" placeholder="请输入新密码" size="20">
                                        </div>
                                    </div> 
                                    <div class="form-group">
                                        <div class="col-sm-offset-1 col-sm-10" onClick="zhuXiao()">
                                            <button type="submit" class="btn btn-primary btn-lg" onClick=" chkAll();">确认修改</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="${ctx}/js/jquery.min.js?v=2.1.4"></script>
    <script src="${ctx}/js/bootstrap-paginator.min.js"></script>
    <script src="${ctx}/js/jquery.validate.min.js"></script>
    <script src="${ctx}/js/tools.js"></script>
    <script type="text/javascript">
    $('#test').validate({
        submitHandler: function() {
        	setPassWord($('#test').attr("action"), $('#test').serialize());//调用tools里的setPassWord方法
        }
    });

    </script>
    <div class="footer">
        <div class="links">
        </div>
        <div class="copyright">
        </div>
    </div>
</body>

</html>