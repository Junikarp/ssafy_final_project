<template>
    <div class="main-container">
        <a class="main-header" href="https://www.naver.com">
            <img src="../assets/logo.png" id="logo">
            𝕭𝖗𝖊𝖒𝖊𝖓
        </a>
        <div class="login-bar">
            <a href="google.com">Login</a>
            <a href="Sign in">Sign up</a>
        </div>
    </div>
</template>

<script setup>

</script>

<style scoped>
.main-container {
    margin-top: 18px;
    display: flex;
    width:100%;
}

.login-bar {
    display: flex;
    margin-top: 10px;
    font-size: 20px;
    margin-left: 60%;
    justify-content: space-around;
}

.login-bar a {
    text-decoration: none;
    margin-right:30px;
    font-weight:bold;
    color:black
}

.login-bar a:hover {
    color:gray;
}

.main-header {
    background-color: white;
    font-size: 40px;
    text-decoration: none;
    color: black;
}   

#logo {
    width: 30px;
}
</style>