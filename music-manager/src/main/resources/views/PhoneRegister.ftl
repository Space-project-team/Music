<!-- 设置项目根路径全局变量 -->
<#assign ctx=request.contextPath/>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>注册</title>

    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${ctx}/css/register.css">

</head>
<script type="text/javascript">
    $(function(){
        $("#sendVerifyCode").click(function () {

            var phone = $("#phone").val();
            if(isEmpty(phone)){
                alert("手机号不能为空！");
                return false;
            }

            $.ajax({
                type:"post",
                url: "http://localhost:9091/music-manager/user/SendSsm",
                data:{
                    phoneNum:phone
                },
                dataType : "json",
                success:function (data) {
                    if(data.code==200){
                        alert("发送成功!");
                    }else{
                        alert(data.message);
                    }
                }

            });
        });



        $("#chkAll").click(function () {
            var code = $("#code").val();
            var phone = $("#phone").val();
            var user_name = $("#user_name").val();
            var user_password = $("#user_password").val();


            if(isEmpty(user_name)){
                alert("用户名不能为空！")
                return false;
            }

            if(isEmpty(phone)){
                alert("手机号不能为空！")
                return false;
            }
            if(isEmpty(code)){
                alert("验证码不能为空！")
                return false;
            }
            if(isEmpty(user_password)){
                alert("密码不能为空！")
                return false;
            }

            $.ajax({
                type: "post",
                url: "http://localhost:9091/music-manager/user/register",
                data: {
                    user_name:user_name,
                    user_password:user_password,
                    phoneNum:phone,
                    code:code
                },
                dataType: "json",
                success: function (data) {
                    console.log("进入回调函数")
                    if (data.code == 200) {
                        console.log("注册成功")
                        alert("注册成功!");
                        window.location.href = ctx+"/index";
                    } else {
                        console.log("注册失败")
                        alert(data.message);
                    }
                }

            });
        });
    });
</script>

<style>
    #sendVerifyCode{
        position: absolute;
        width: 130px;
        height: 30px;
        top: 70px;
        left: 500px;
        font-size: 20px;
        color: #0F769F;
    }
</style>
<script>
    var ctx="${ctx}";
</script>
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
        <h3><span class="glyphicon glyphicon-star">&nbsp用户注册</span></h3><br /><br />
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-sm-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                        </div>
                        <div class="ibox-content">
                            <form <#--id="test" role="form" action="${ctx}/user/register"--> <#--method="post"-->>
                                <div class="form-group">
                                    <!-- 表单 -->
                                    <label for="username" class="col-sm-2 control-label">用户名:</label> <!-- 表单 -->
                                    <div class="col-sm-10" style="margin: 0 0 20px">
                                        <input type="text" class="form-control" id="user_name" name="user_name" placeholder="请输入用户名" size="20">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <!-- 手机号 -->
                                    <label for="phone" class="col-sm-2 control-label">手机号:</label> <!-- 表单 -->
                                    <div class="col-sm-10" style="margin: 0 0 20px">
                                        <input type="text" class="form-control" id="phone" name="phone" placeholder="请输入手机号" size="20">
                                    </div>
                                    <button  type="button"  id="sendVerifyCode" <#--onclick="sendVerifyCode();"-->>获取验证码</button>
                                </div>


                                <div class="form-group">
                                    <!-- 验证码 -->
                                    <label for="yz" class="col-sm-2 control-label">验证码:</label> <!-- 表单 -->
                                    <div class="col-sm-10" style="margin: 0 0 20px">
                                        <input type="text" class="form-control" id="code" name="code" placeholder="请输入验证码" size="20">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="password" class="col-sm-2 control-label">密码:</label>
                                    <div class="col-sm-10" style="margin: 0 0 20px">
                                        <input type="password" class="form-control" id="user_password" name="user_password" placeholder="请输入密码" size="20">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-offset-1 col-sm-10">
                                        <button type="button" class="btn btn-primary btn-lg" id="chkAll">注册</button>
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
<#--<script src="${ctx}/js/tools.js"></script>-->
<script src="${ctx}/js/common.js"></script>
<script type="text/javascript">


    /*$('#test').validate({
        submitHandler: function(form) {
            addToDB($('#test').attr("action"), $('#test').serialize());//tools里的方法
           //pageTools(1, 30);
           // getList(1);
        }
    });*/
</script>
<div class="footer">
    <div class="links">
        <a hidefocus="true" href="#" target="_blank">开发者：</a>
        <a hidefocus="true" href="#" target="_blank">林李权</a>
        <!--&lt;!&ndash;毕业答辩需要，暂时注释&ndash;&gt;-->
        <!--<a hidefocus="true" target="_blank" href="#">黄施邕</a> -->
        <!--<a hidefocus="true" target="_blank" href="#">吴先锋</a> -->
        <!--<a hidefocus="true" href="#" target="_blank">姚源超</a> -->
        <!--<a hidefocus="true" href="#" target="_blank">封南生</a> -->
        <!--<a hidefocus="true" href="#" target="_blank">赵联岸</a> -->
        <!--<a hidefocus="true" href="#" target="_blank">加入我们</a>-->
        <a hidefocus="true" href="#" target="_blank">广告合作</a>
    </div>
    <div class="copyright">
        <p style="-moz-user-select: text;-webkit-user-select: text;-ms-user-select: text; user-select:text">如有侵权，请联系：liquan_101@163.com </p>
        <p>Copyright&nbsp;&nbsp;©&nbsp;&nbsp;2019
    </div>
</div>
</body>

</html>