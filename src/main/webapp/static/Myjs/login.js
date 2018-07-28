$("#login").click(function () {
    $.ajax({
        type:'post',
        url:'../user/login',
        async:false,
        data:{
            account:$("#account").val(),
            password:$("#password").val(),
        },
        success:function(result){
            if(result == "success"){
                setTimeout(function(){
                    window.location.href="../views/motorSearch.html";
                },1);

            }else {
                alertWindow("用户名或密码错误", "error");
            }
        },
        error:function () {
            alertWindow("出错了", "error");
        }
    });
    
})
$("#registering").click(function () {
    $.ajax({
        type:'post',
        url:'../user/register',
        async:false,
        data:{
            account:$("#account").val(),
            name:$("#name").val(),
            email:$("#email").val(),
            password:$("#password").val(),
        },
        success:function(result){
            if(result == "success"){
                alertWindow("注册成功", "success");
                setTimeout(function(){
                    window.location.href="index.html";
                },1);
            }else {
                alert("注册失败");
                alertWindow("用户名/账号/邮箱冲突", "error");
            }
        }
    });

})


