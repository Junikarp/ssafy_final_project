<!-- YouTubeVideoList.vue -->

<template>
    <div>
      <h1>YouTube Video List</h1>
      <ul>
        <li v-for="video in videos" :key="video.id.videoId" @click="selectVideo(video)">
          {{ video.snippet.title }}
        </li>
      </ul>
  
      <div v-if="selectedVideo">
        <h2>Selected Video</h2>
        <iframe
          width="560"
          height="315"
          :src="'https://www.youtube.com/embed/' + selectedVideo.id.videoId"
          frameborder="0"
          allowfullscreen
        ></iframe>
        <p>{{ selectedVideo.snippet.title }}</p>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue';
  import axios from 'axios';
  
  const apiKey = 'YOUR_YOUTUBE_API_KEY';
  const apiUrl = 'https://www.googleapis.com/youtube/v3/search';
  
  const fetchYouTubeVideos = async () => {
    try {
      const response = await axios.get(apiUrl, {
        params: {
          key: apiKey,
          part: 'snippet',
          q: 'soccer',
          type: 'video',
          maxResults: 10,
        },
      });
  
      return response.data.items;
    } catch (error) {
      console.error('Error fetching YouTube videos:', error);
      return [];
    }
  };
  
  const videos = ref([]);
  const selectedVideo = ref(null);
  
  const selectVideo = (video) => {
    selectedVideo.value = video;
  };
  </script>
  
  <style scoped>
  </style>
  