<template>
    <div>
      <div id="map" style="width: 100%; height: 400px;"></div>
    </div>
  </template>
  
  <script setup>
  import { onMounted } from 'vue';
  
  let map = null;
  
  const initMap = () => {
    const container = document.getElementById('map');
    const options = {
      center: new kakao.maps.LatLng(37.566826, 126.9786567),
      level: 5,
    };
  
    map = new kakao.maps.Map(container, options);
  
    // 마커를 생성하고 지도에 표시
    const marker = new kakao.maps.Marker({
      position: new kakao.maps.LatLng(37.566826, 126.9786567),
      map: map,
      title: '마커 제목',
    });
  
    // 마커에 클릭 이벤트를 추가
    kakao.maps.event.addListener(marker, 'click', function () {
      alert('마커를 클릭했습니다!');
    });
  };
  
  onMounted(() => {
    if (window.kakao && window.kakao.maps) {
      initMap();
    } else {
      const script = document.createElement('script');
      script.src = '//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=9c2e2b61d467effcf3ddff2aba363dd9&libraries=services';
      document.head.appendChild(script);
      script.onload = () => {
        kakao.maps.load(initMap);
      };
    }
  });
  </script>
  
  <style scoped>
  #map {
    width: 100%;
    height: 400px;
  }
  </style>
  