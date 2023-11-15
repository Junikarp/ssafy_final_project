<template>
    <div class="main-container">
        <RouterLink :to="{name:'home'}" class="main-header">
            <img src="../assets/logo.png" id="logo">
            𝕭𝖗𝖊𝖒𝖊𝖓
        </RouterLink>
        <div class="login-bar">
            <RouterLink :to="{name:'community'}">커뮤니티</RouterLink>
            <RouterLink :to="{name:'login'}">로그인</RouterLink>
            <a href="Sign in">Sign up</a>
        </div>
    </div>
        <RouterView></RouterView>
</template>

<script setup>

</script>

<style scoped>
.main-container {
    padding-left:120px; 
    padding-top: 10px;
    padding-bottom: 10px;
    display: flex;
    width:100%;
    position: fixed;
    background-color: white;
}

.login-bar {
    display: flex;
    margin-top: 10px;
    font-size: 20px;
    padding-left: 60%;
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