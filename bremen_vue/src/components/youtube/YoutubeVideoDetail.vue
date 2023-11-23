<template>
  <div v-if="store.selectedVideo">
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-xl">
          <div class="modal-content" id="video-view">
            <iframe width="980" height="606" :src="videoURL" title="YouTube video player" frameborder="0"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
            allowfullscreen></iframe>
            <div class="modal-footer">
            </div>  
          </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useYoutubeStore } from '@/stores/youtube';
import { computed } from 'vue'
const store = useYoutubeStore();

const videoURL = computed(() => {
  const videoId = store.selectedVideo.id.videoId
  return `https://www.youtube.com/embed/${videoId}`
})

</script>

<style scoped>
#video-view {
  display: flex;
  justify-content: center;
  align-content: center;
  padding-left: 80px;
  padding-top: 30px;
}

iframe {
  border-radius: 50px;
}
</style>
