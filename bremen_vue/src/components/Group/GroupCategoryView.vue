<template>
    <div>
        <div class="category-image"></div>
        <div class="logo" data-aos="fade-up" data-aos-duration="5000"><router-link :to="{ name: 'home' }"
                style="text-decoration: none; color: black;">BREMEN</router-link>
        </div>
        <div class="category-text" data-aos="fade-up">가까운 이웃과 강력한 팀을 이뤄 함께하세요</div>

        <div class="container" data-aos="fade-right">
            <RouterLink to="/group/soccer"><button class="button-color"><img src="../../assets/category/soccer.png"
                        class="button-img">
                    <span class="button-text">축구</span></button></RouterLink>
            <RouterLink to="/group/badminton"><button class="button-color"><img src="../../assets/category/baseball.png"
                        class="button-img"><span class="button-text">야구</span></button></RouterLink>

            <RouterLink to="/group/footVolleyBall"><button class="button-color"><img
                        src="../../assets/category/basketball.png" class="button-img"><span
                        class="button-text">농구</span></button></RouterLink>

            <RouterLink to="/group/volleyball"><button class="button-color"><img src="../../assets/category/volleyball.png"
                        class="button-img"><span class="button-text">배구</span></button></RouterLink>

            <RouterLink to="/group/running"><button class="button-color"><img src="../../assets/category/running.png"
                        class="button-img"><span class="button-text">런닝</span></button></RouterLink>

            <RouterLink to="/group/swimming"><button class="button-color"><img src="../../assets/category/swimming.png"
                        class="button-img"><span class="button-text">수영</span></button></RouterLink>

            <RouterLink to="/group/cycle"><button class="button-color"><img src="../../assets/category/cycle.png"
                        class="button-img"><span class="button-text">사이클</span></button></RouterLink>

            <RouterLink to="/group/badminton"><button class="button-color"><img src="../../assets/category/badminton.png"
                        class="button-img"><span class="button-text">배드민턴</span></button></RouterLink>

            <RouterLink to="/group/bowling"><button class="button-color"><img src="../../assets/category/bowling.png"
                        class="button-img">
                    <span class="button-text">볼링</span></button></RouterLink>

            <RouterLink to="/group/boxing"><button class="button-color"><img src="../../assets/category/boxing.png"
                        class="button-img"><span class="button-text">복싱</span></button></RouterLink>

            <RouterLink to="/group/football"><button class="button-color"><img src="../../assets/category/football.png"
                        class="button-img"><span class="button-text">럭비</span></button></RouterLink>

            <RouterLink to="/group/golf"><button class="button-color"><img src="../../assets/category/golf.png"
                        class="button-img"><span class="button-text">골프</span></button></RouterLink>

            <RouterLink to="/group/health"><button class="button-color"><img src="../../assets/category/health.png"
                        class="button-img"><span class="button-text">헬스</span></button></RouterLink>

            <RouterLink to="/group/tabbleTennis"><button class="button-color"><img
                        src="../../assets/category/tableTennis.png" class="button-img"><span
                        class="button-text">탁구</span></button></RouterLink>

            <RouterLink to="/group/tennis"><button class="button-color"><img src="../../assets/category/tennis.png"
                        class="button-img"><span class="button-text">테니스</span></button></RouterLink>


            <RouterLink to="/group/badminton"><button class="button-color"><img src="../../assets/category/billiard.png"
                        class="button-img"><span class="button-text">당구</span></button></RouterLink>


        </div>
    </div>
</template>

<script setup>

</script>

<style scoped>
.category-image {
    background-image: url("../../assets/group/groupcategorymain.jpg");
    height: 700px;
    width: 100%;
    background-size: cover;
    
    background-repeat: no-repeat;
    background-position: center;
    margin-bottom: 30px;


}

.logo {
    font-weight: 800;
    font-size: 50px;
    text-align: center;
    margin: 50px;
}
.category-text{
    margin: 50px;
    text-align: center;
    font-size: 25px;
    font-weight: 600;
    color: #212529BF;
}

.container {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    flex-wrap: wrap;
    margin-bottom: 100px;
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