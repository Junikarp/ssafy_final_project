<template>
  <div @click="clickVideo">
    <div class="videos" data-aos="fade-up" data-aos-duration="1000">
      <img :src="getHighQualityThumbnailUrl(video)" class="highlight-video">
      <span class="video-title">{{video.snippet.title}}</span>
    </div>
  </div>
</template>

<script setup>
import { useYoutubeStore } from '@/stores/youtube';
const store = useYoutubeStore();

const props = defineProps({
  video: {
    type: Object,
    required: true,
  },
});



const clickVideo = function() {
    store.clickVideo(props.video)
}

const getHighQualityThumbnailUrl = function(video) {
  if (video.snippet.thumbnails.maxres) {
    return video.snippet.thumbnails.maxres.url;
  }

  const highQualityThumbnails = [
    'standard',
    'high',
    'medium',
    'default'
  ];

  for (const quality of highQualityThumbnails) {
    if (video.snippet.thumbnails[quality]) {
      return video.snippet.thumbnails[quality].url;
    }
  }

  return video.snippet.thumbnails.default.url;
};
</script>

<style scoped>
.videos{
  display: flex;
  flex-direction: column;
  width: 500px;
}
.highlight-video{
  border-radius: 50px;
  width: auto;
  height: 400px;
}
.video-title{
  margin-top: 10px;
  font-size: 25px;
  font-weight: 500;
  text-align: center;
}
</style>
