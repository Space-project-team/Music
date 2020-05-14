
//获取验证码
function SendSsm() {
    var phone = $("#phone");
    if(null==phone||""==phone){
        alert("手机号不能为空！")
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
                alert(data.code.message);
            }
        }

    })
}

//注册
function register() {
    var code = $("#code");

    $.ajax({
        type:"post",
        url: "http://localhost:9091/music-manager/user/register",
        data:{
            code:code
        },
        dataType : "json",
        success:function (data) {
            if(data.code==200){
                alert("注册成功!");
                alert("您的账号:"+data.pageInfo.list.userName+"   您的密码:"+data.pageInfo.list.userPassword);
            }else{
                alert(data.message);
            }
        }

    })
}