<template>
    <div>
        <div class="category-image"></div>
        <div class="logo"><router-link :to="{ name: 'home' }"
                style="text-decoration: none; color: black;">BREMEN</router-link>
        </div>

        <div class="container">
            <RouterLink to="/board/soccer"><button class="button-color"><img src="../../assets/category/soccer.png"
                        class="button-img">
                    <span class="button-text">축구</span></button></RouterLink>
            <RouterLink to="/board/volleyball"><button class="button-color"><img src="../../assets/category/volleyball.png"
                        class="button-img"><span class="button-text">배구</span></button></RouterLink>
            <RouterLink to="/board/running"><button class="button-color"><img src="../../assets/category/running.png"
                        class="button-img"><span class="button-text">런닝</span></button></RouterLink>
            <RouterLink to="/board/swimming"><button class="button-color"><img src="../../assets/category/swimming.png"
                        class="button-img"><span class="button-text">수영</span></button></RouterLink>
            <RouterLink to="/board/cycle"><button class="button-color"><img src="../../assets/ca        ry/cycle.png"
                        class="button-img"><span class="button-text">사이클</span></button></RouterLink>
            <RouterLink to="/board/badminton"><button class="button-color"><img src="../../assets/category/badminton.png"
                        class="button-img"><span class="button-text">배드민턴</span></button></RouterLink>
            <RouterLink to="/board/soccer"><button class="button-color"><img src="../../assets/category/soccer.png"
                        class="button-img">
                    <span class="button-text">축구</span></button></RouterLink>
            <RouterLink to="/board/volleyball"><button class="button-color"><img src="../../assets/category/volleyball.png"
                        class="button-img"><span class="button-text">배구</span></button></RouterLink>
            <RouterLink to="/board/running"><button class="button-color"><img src="../../assets/category/running.png"
                        class="button-img"><span class="button-text">런닝</span></button></RouterLink>
            <RouterLink to="/board/swimming"><button class="button-color"><img src="../../assets/category/swimming.png"
                        class="button-img"><span class="button-text">수영</span></button></RouterLink>
            <RouterLink to="/board/cycle"><button class="button-color"><img src="../../assets/category/cycle.png"
                        class="button-img"><span class="button-text">사이클</span></button></RouterLink>
            <RouterLink to="/board/badminton"><button class="button-color"><img src="../../assets/category/badminton.png"
                        class="button-img"><span class="button-text">배드민턴</span></button></RouterLink>
        </div>
    </div>
</template>

<script setup>

</script>

<style scoped>

.category-image {
    background-image: url("../../assets/main/community.jpeg");
    height: 350px;
    width: 100%;
    background-size: cover;
    background-position: center;
    margin-bottom: 30px;
    
    
}
.logo {
    font-weight: 800;
    font-size: 40px;
    text-align: center;
    margin-bottom: 20px;
}

.container {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    flex-wrap: wrap;
}

.button-color {
    height: 95px;
    width: 95px;
    background-color: rgb(255, 255, 255);
    border-radius: 30%;
    border-color: rgb(185, 192, 198);
    margin: 30px;
}

.button-img {
    width: 80px;
    height: 80px;
}

.button-text {
    display: block;
    margin-top: 30px;
    font-size: 20px;
    font-weight: 700;
}
</style>