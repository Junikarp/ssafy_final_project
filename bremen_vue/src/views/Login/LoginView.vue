<template>
    <section class="body">
        <div class="container">
            <div class="login-box">
                <div class="col-sm-6 offset-sm-3"> <!-- 중앙 정렬을 위한 offset-sm-3 추가 -->
                    <div class="logo"><router-link :to="{ name: 'home' }"
                            style="text-decoration: none; color: black;">BREMEN</router-link></div>
                    <h5 class="header-title" style="font-style: normal;">하나가 되는 스포츠</h5>
                    <form class="login-form">

                        <form class="login-submit" @submit.prevent="login">
                            <p>이메일 주소</p>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="예)bremen@bremen.co.kr"
                                    v-model="user.userId">
                            </div>
                            <p>비밀번호</p>
                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="영문, 숫자, 특수문자 조합 8-16자"
                                    v-model="user.userPassword">
                            </div>

                            <div class="form-group">
                                <button class="btn btn-primary btn-block">로그인</button>
                            </div>
                        </form>

                        <div class="social-sign-up">
                            <img src="@/assets/login/google.png">
                            <img src="@/assets/login/naver.png">
                            <button @click="kakaoLogin" class="login-button"><img src="@/assets/login/kakao.png"></button>
                            <img src="@/assets/login/apple.png">
                        </div>
                        <div class="sign-up">
                            <RouterLink :to="{ name: 'signup' }">회원가입</RouterLink>|
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
import { ref } from 'vue';
import { useUserStore } from "@/stores/user";

const store = useUserStore();
const user = ref({
    userId: '',
    userPassword: ''
})

const login = function () {
    store.login(user.value)
}


const kakaoLogin = function () {
    window.Kakao.Auth.login({
        scope: "profile_nickname",
        success: getKakaoAccount, // 수정된 부분
    });
};

const getKakaoAccount = function (res) {
    console.log("check")
    window.Kakao.API.request({
        url: "/v2/user/me",
        success: (res) => {
        const kakao_account = res.kakao_account;

    console.log("check")
            // 로그인처리구현

            alert("로그인 성공!");
        },
        fail: (error) => {
            console.log(error);
        },
    });
};

const kakaoLogout = function () {
    window.Kakao.Auth.logout((res) => {
        console.log(res);
    });
};


</script>

<style scoped>
@import url(https://fonts.googleapis.com/css?family=Roboto:300,400,700&display=swap);

body {
    background: #f5f5f5;

}

p {
    margin: 0;
    font-size: 15px;
    font-weight: 800;
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
    font-size: 60px;
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
    border: 0;
    border-bottom: 1px solid #ebebeb;
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

.sign-up {
    display: flex;
    justify-content: space-around;
    margin: 20px;

}

.social-sign-up {
    display: flex;
    justify-content: space-around;
    padding-top: 30px;
}

.social-sign-up img {
    width: 50px;

}

.login-button{
    background-color: rgb(253, 253, 253);
    border: 0;
}
</style>