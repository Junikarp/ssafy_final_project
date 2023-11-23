<template>
    <div>
        <h4>검색 결과</h4>
        <ul>
            <YoutubeVideoListItem 
                v-for="video in store.videos"
                :key="video.id.videoId"
                :video="video"
            />
        </ul>
    </div>
</template>

<script setup>
import { onMounted } from 'vue';
import {useYoutubeStore} from '@/stores/youtube'
import YoutubeVideoListItem from './YoutubeVideoListItem.vue';

onMounted(() => {
    store.youtubeSearch("경기 하이라이트")
})
const store = useYoutubeStore()
</script>

<style  scoped>

</style>