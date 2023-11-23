<template>
    <div>
        <!-- 맵을 표시할 컨테이너 -->
        <div id="map" style="width: 100%; height: 400px;"></div>

        <!-- 입력 폼 -->
        <form @submit.prevent="handleSubmit">
            <label for="groupTitle">제목:</label>
            <input v-model="formData.groupTitle" type="text" id="groupTitle" required>

            <label for="groupContent">글 내용:</label>
            <textarea v-model="formData.groupContent" id="groupContent" required></textarea>

            <label for="groupMaxPeople">모집 인원:</label>
            <input v-model="formData.groupMaxPeople" type="number" id="groupMaxPeople" required>

            <label for="groupDate">날짜:</label>    
            <input v-model="formData.groupDate" type="date" id="groupDate" required>

            <label for="groupTime">시간:</label>
            <input v-model="formData.groupTime" type="time" id="groupTime" required>

            <button type="submit">글 작성</button>
        </form>
    </div>
</template>
  
<script setup>
import { ref, onMounted } from 'vue';
import { useGroupStore } from '../../stores/group';
import { useRoute } from 'vue-router'
import {useUserStore} from '../../stores/user'

const store = useGroupStore();
const userStore = useUserStore();
// 맵, 마커, 위치, 폼 데이터 등을 담을 변수들
let map = null;
const route = useRoute();
let marker = null;
let currentPosition = null;
const formData = ref({
    groupTitle: '',
    groupWriter: userStore.loginUserId,
    groupContent: '',
    groupMaxPeople: 0,
    groupCategory: route.params.category,
    groupDate: '',
    groupTime: '',
    positionX:'',
    positionY:''
});

// 카카오 맵 스크립트 로딩 함수
const loadKakaoScript = () => {
    return new Promise((resolve, reject) => {
        const script = document.createElement('script');
        script.src = 'https://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=9c2e2b61d467effcf3ddff2aba363dd9&libraries=services';
        document.head.appendChild(script);
        script.onload = resolve;
        script.onerror = reject;
    });
};

// 맵 초기화 함수
const initMap = () => {
    // 현재 위치로 맵 초기화
    map = new kakao.maps.Map(document.getElementById('map'), {
        center: new kakao.maps.LatLng(currentPosition.lat, currentPosition.lng),
        level: 3,
    });

    // 클릭 이벤트 등록
    kakao.maps.event.addListener(map, 'click', function (mouseEvent) {
        handleMapClick(mouseEvent.latLng);
    });

    // 현재 위치에 마커 생성
    marker = new kakao.maps.Marker({
        position: new kakao.maps.LatLng(currentPosition.lat, currentPosition.lng),
        map: map,
    });
};

// 맵 클릭 시 호출되는 함수
const handleMapClick = (position) => {
    // 클릭한 위치로 마커 이동
    marker.setPosition(position);

    // 현재 위치 갱신
    currentPosition = {
        lat: position.getLat(),
        lng: position.getLng(),
    };
};

// 폼 제출 시 호출되는 함수
onMounted(async () => {
    try {
        // 현재 위치 가져오기
        if ('geolocation' in navigator) {
            navigator.geolocation.getCurrentPosition((position) => {
                currentPosition = {
                    lat: position.coords.latitude,
                    lng: position.coords.longitude,
                };

                // 카카오 스크립트 로드 후에 초기화
                loadKakaoScript().then(() => {
                    kakao.maps.load(() => {
                        // kakao 객체가 초기화된 후에 지도 초기화 등의 작업 수행
                        initMap();
                    });
                });
            }, (error) => {
                console.error('Failed to get current position', error);
            });
        } else {
            console.error('Geolocation is not supported');
        }
    } catch (error) {
        console.error('Failed to load Kakao Maps script', error);
    }
});

// 폼 제출 시 호출되는 함수
const handleSubmit = () => {
    // 마커의 현재 위치 정보를 폼 데이터에 추가
    formData.value.positionX = currentPosition.lat,
    formData.value.positionY = currentPosition.lng,

    store.createGroup(formData.value);
    // TODO: 입력된 데이터를 서버로 전송하는 로직 추가
    console.log('Form submitted:', formData.value);
};
</script>
  
<style scoped>
#map {
    width: 100%;
    height: 400px;
}
</style>
  