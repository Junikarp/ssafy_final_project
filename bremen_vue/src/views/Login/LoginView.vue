<template>
    <section class="body">
        <div class="container">
            <div class="login-box">
                <div class="col-sm-6 offset-sm-3"> <!-- 중앙 정렬을 위한 offset-sm-3 추가 -->
                    <div class="logo">BREMEN</div>
                    <br>
                    <h3 class="header-title">LOGIN</h3>
                    <form class="login-form">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Email or UserName">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="Password">
                        </div>
                        <div class="form-group">
                            <button class="btn btn-primary btn-block">로그인</button>
                           
                        </div>
                        <div class="sign-up">
                            <div class="text-center"> <a href="#!">회원가입</a></div>| 
                            <div class="text-center"> <a href="#!">아이디 찾기</a></div> |
                            <div class="text-center"> <a href="#!">비밀번호 찾기</a></div> 
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
</template>

<script setup>

</script>

<style scoped>
@import url(https://fonts.googleapis.com/css?family=Roboto:300,400,700&display=swap);

body {
    background: #f5f5f5;

}



.login-box {
    background-size: cover;
    background-position: center;
    padding: 50px;
    margin: 50px auto;
    min-height: 700px;
    -webkit-box-shadow: 0 2px 60px -5px rgba(0, 0, 0, 0.1);
    box-shadow: 0 2px 60px -5px rgba(0, 0, 0, 0.1);
}

.logo {
    font-weight: 800;
    font-size: 40px;
    text-align: center;
    margin-bottom: 20px;
}

.header-title {
    text-align: center;
    margin-bottom: 50px;
}

.login-form {
    max-width: 300px;
    margin: 0 auto;
}

.login-form .form-control {
    border-radius: 0;
    margin-bottom: 30px;
}

.login-form .form-group {
    position: relative;

}

.form-group {
    display: flex;
    
}

.login-form .form-group .forgot-password {
    position: absolute;
    top: 6px;
    right: 15px;
}

.login-form .btn {
    border-radius: 0;
    -webkit-box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.login-form .btn.btn-primary {
    width: 100%;
    background: #3BC3FF;
    border-color: #31c0ff;
}
.sign-up{
    display: flex;
    justify-content: space-between;
    margin-top: 10px;
    
}
</style>