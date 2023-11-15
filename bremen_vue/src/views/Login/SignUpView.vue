<template>
    <section class="body">
        <div class="container">
            <div class="login-box">
                <div class="col-sm-6 offset-sm-3"> <!-- 중앙 정렬을 위한 offset-sm-3 추가 -->
                    <div class="logo">BREMEN</div>
                    <br>

                    <form class="login-form">
                        <p>아이디</p>
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Email">
                        </div>
                        <p>비밀번호</p>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="Password">
                        </div>
                        <p>비밀번호 확인</p>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="Password check">
                        </div>
                        <p>이름</p>
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Name">
                        </div>
                        <div class="form-group">
                            <button class="btn btn-primary btn-block">회원가입</button>
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

.col-sm-6 {
    margin-top: 70px;
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

p{
    font-weight: 500;
    margin-bottom: 10px;
}
</style>