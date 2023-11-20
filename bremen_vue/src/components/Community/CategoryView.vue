<template>
    <div>
        <div class="logo"><router-link :to="{name:'home'}" style="text-decoration: none; color: black;">BREMEN</router-link></div>
    
        <div class="container">
            <button type="button" class="button-color"><img src="../../assets/category/KakaoTalk_Photo_2023-11-20-17-47-31-removebg-preview.png" class="button-img"></button>
            <button type="button" class="button-color"><img src="../../assets/category/KakaoTalk_Photo_2023-11-20-17-47-11-removebg-preview.png" class="button-img"></button>
            <button type="button" class="button-color"><img src="../../assets/category/KakaoTalk_Photo_2023-11-20-17-47-20-removebg-preview.png" class="button-img"></button>
            <button type="button" class="button-color"><img src="../../assets/category/KakaoTalk_Photo_2023-11-20-17-47-23-removebg-preview.png" class="button-img"></button>
            <button type="button" class="button-color"><img src="../../assets/category/KakaoTalk_Photo_2023-11-20-17-47-24-removebg-preview.png" class="button-img"></button>
            <button type="button" class="button-color"><img src="../../assets/category/KakaoTalk_Photo_2023-11-20-17-47-26-removebg-preview.png" class="button-img"></button>
            <button type="button" class="button-color"><img src="../../assets/category/KakaoTalk_Photo_2023-11-20-17-47-11-removebg-preview.png" class="button-img"></button>
            <button type="button" class="button-color"><img src="../../assets/category/KakaoTalk_Photo_2023-11-20-17-47-20-removebg-preview.png" class="button-img"></button>
            <button type="button" class="button-color"><img src="../../assets/category/KakaoTalk_Photo_2023-11-20-17-47-23-removebg-preview.png" class="button-img"></button>
            <button type="button" class="button-color"><img src="../../assets/category/KakaoTalk_Photo_2023-11-20-17-47-24-removebg-preview.png" class="button-img"></button>
            <button type="button" class="button-color"><img src="../../assets/category/KakaoTalk_Photo_2023-11-20-17-47-26-removebg-preview.png" class="button-img"></button>
            <button type="button" class="button-color"><img src="../../assets/category/KakaoTalk_Photo_2023-11-20-17-47-31-removebg-preview.png" class="button-img"></button>
        </div>
    </div>
</template>

<script setup>

</script>

<style scoped>

.logo {
    font-weight: 800;
    font-size: 40px;
    text-align: center;
    margin-bottom: 20px;
}
.container{
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    flex-wrap: wrap;
}
.button-color{
    background-color: rgb(255, 255, 255);
    border-radius: 30%;
    border-color: rgb(174, 177, 180);
    margin: 20px;
}
.button-img{
    width: 80px;
}
</style>