<template>
    <div>
        <div id="map" style="width: 100%; height: 400px;"></div>
        <div>
            <input v-model="searchKeyword" placeholder="장소를 검색하세요" />
            <button @click="searchPlaces">검색</button>
        </div>
        <div v-if="selectedPlace">
            <h3>{{ selectedPlace.place_name }}</h3>

        </div>
    </div>
</template>
  
<script setup>
import { ref, onMounted } from 'vue';

let map = null;
let marker = null;
let ps = null;
let infowindow = null;
let selectedPlace = null;

const searchKeyword = ref('');

const initMap = () => {
    const container = document.getElementById('map');
    const options = {
        center: new kakao.maps.LatLng(37.566826, 126.9786567),
        level: 5,
    };

    map = new kakao.maps.Map(container, options);
    ps = new kakao.maps.services.Places(map);
    infowindow = new kakao.maps.InfoWindow({ zIndex: 1 });

    // 현재 위치에 마커 표시
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition((position) => {
            const latlng = new kakao.maps.LatLng(position.coords.latitude, position.coords.longitude);
            addMarker(latlng);
            map.setCenter(latlng);
        });
    }

    // 지도를 클릭할 때마다 마커 생성
    kakao.maps.event.addListener(map, 'click', function (mouseEvent) {
        if (!searchKeyword.value) {
            // 검색어가 없을 때만 클릭 시 마커 추가
            addMarker(mouseEvent.latLng);
        }
    });

    // 지도 클릭 시 선택된 장소 정보 초기화
    kakao.maps.event.addListener(map, 'click', function () {
        selectedPlace = null;
    });
};

// 마커 생성 함수
const addMarker = (position) => {
    // 기존 마커 제거
    removeMarker();

    marker = new kakao.maps.Marker({
        position: position,
        map: map,
        title: '새로운 마커',
    });

    // 마커에 클릭 이벤트를 추가하여 정보 표시
    kakao.maps.event.addListener(marker, 'click', function () {
        getPlaceDetails(position);
    });
};

// 마커 제거 함수
const removeMarker = () => {
    if (marker) {
        marker.setMap(null);
        marker = null;
    }
};

// 키워드 검색 함수
const searchPlaces = () => {
    if (searchKeyword.value === '') {
        alert('검색어를 입력하세요.');
        return;
    }

    // 기존 마커 제거
    removeMarker();

    // 키워드 검색
    ps.keywordSearch(searchKeyword.value, placesSearchCB);
};

const placesSearchCB = (data, status, pagination) => {
  console.log(data, status, pagination);
  if (status === kakao.maps.services.Status.OK) {
    for (let i = 0; i < data.length; i++) {
      addMarker(new kakao.maps.LatLng(data[i].y, data[i].x));
    }
  }
};

// 마커 클릭 시 장소 정보 불러오기
const getPlaceDetails = (position) => {
    const callback = (result, status) => {
        if (status === kakao.maps.services.Status.OK) {
            selectedPlace = result;
            displayInfowindow(position, result);
        }
    };

    const options = {
        x: position.getLng(),
        y: position.getLat(),
        input_coord: kakao.maps.services.Coords.WGS84,
    };

    ps.coord2Address(options, callback);
};

// 마커 클릭 시 정보 표시 함수
const displayInfowindow = (position, place) => {
    const content = `
        <div style="padding:10px;">
            <h4>${place.place_name}</h4>
            <p>${place.address_name}</p>
            <p>${place.phone || '전화번호 없음'}</p>
        </div>`;
    infowindow.setContent(content);
    infowindow.setPosition(position);
    infowindow.open(map);
};

onMounted(() => {
    if (window.kakao && window.kakao.maps) {
        initMap();
    } else {
        const script = document.createElement('script');
        script.src =
            '//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=9c2e2b61d467effcf3ddff2aba363dd9&libraries=services';
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
  