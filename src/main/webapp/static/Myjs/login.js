$("#login").click(function () {
    $.ajax({
        type:'post',
        url:'../user/login',
        data:{
            account:$("#account").val(),
            password:$("#password").val(),
        },
        success:function(result){
            if(result == "success"){
                window.location.href="../views/motorSearch.html";
            }else {
                alertWindow("用户名或密码错误", "error");
            }
        }
    });
    
})