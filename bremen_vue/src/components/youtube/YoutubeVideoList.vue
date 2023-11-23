<template>
    <NavHeader></NavHeader>

    <div class="highlight-image"></div>
        <div class="logo" data-aos="fade-up" data-aos-duration="1000"><router-link :to="{ name: 'home' }"
                style="text-decoration: none; color: black;">BREMEN</router-link>
        </div>
        <div class="highlight-text" data-aos="fade-up">다양한 최고의 순간들을 함께 즐겨보세요</div>
    <div>
        
        <YoutubeVideoDetail></YoutubeVideoDetail>
        <div class="video-list">
            <YoutubeVideoListItem v-for="video in store.videos" :key="video.id.videoId" :video="video" />
        </div>
    </div>
</template>

<script setup>
import { onMounted } from 'vue';
import {useYoutubeStore} from '@/stores/youtube'
import YoutubeVideoListItem from './YoutubeVideoListItem.vue';
import NavHeader from '../NavHeader.vue';
import YoutubeVideoDetail from './YoutubeVideoDetail.vue';

onMounted(() => {
    store.youtubeSearch("경기 하이라이트")
})
const store = useYoutubeStore()
</script>

<style  scoped>
.highlight-image {
    background-image: url("../../assets/highlight/1.jpeg");
    height: 500px;
    width: 100%;
    background-size: cover;
    background-position: center;
    margin-bottom: 30px;


}

.logo {
    font-weight: 800;
    font-size: 50px;
    text-align: center;
    margin: 50px;
}
.highlight-text{
    margin: 50px;
    text-align: center;
    font-size: 25px;
    font-weight: 600;
    color: #212529BF;
}
.video-list{
    width: 100%;
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    gap: 20px;
    
}

</style>