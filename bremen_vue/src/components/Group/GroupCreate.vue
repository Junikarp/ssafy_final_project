<template>
    <NavHeader></NavHeader>
    <div class="group-create">
        <!-- 맵을 표시할 컨테이너 -->
        <div id="map" style="width: 100%; height: 400px;"></div>

        <!-- 입력 폼 -->
        <form @submit.prevent="handleSubmit" class="create-form">
            <div>
                <div class="group-text">제목</div>
                <input v-model="formData.groupTitle" type="text" required class="create-text">
            </div>
            <div>
                <div class="group-text">내용</div>
                <textarea v-model="formData.groupContent" :rows="calculateTextareaRows(formData.groupContent)" required class="create-text"></textarea>
            </div>

            <div>
                <div class="group-text">모집 인원</div>
                <input v-model="formData.groupMaxPeople" type="number" required class="create-text">
            </div>

            <div>
                <div class="group-text">날짜</div>
                <input v-model="formData.groupDate" type="date" required class="create-text">
            </div>

            <div>
                <div class="group-text">시간</div>
                <input v-model="formData.groupTime" type="time" required class="create-text">
            </div>

            <button type="submit" class="create-button">등록</button>
        </form>
    </div>
</template>
  
<script setup>
import { ref, onMounted } from 'vue';
import { useGroupStore } from '../../stores/group';
import { useUserStore } from '../../stores/user';
import { useRoute } from 'vue-router'
import NavHeader from '../NavHeader.vue';

const store = useGroupStore();
// 맵, 마커, 위치, 폼 데이터 등을 담을 변수들
let map = null;
const route = useRoute();
const userStore = useUserStore();


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
    positionX: '',
    positionY: ''
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

const calculateTextareaRows = (content) => {
    const rowCount = Math.max(content.split('\n').length, 3); // 최소 1행
    return rowCount;
};
</script>
  
<style scoped>
.group-create {
    margin-left: 300px;
    margin-right: 300px;
}

#map {
    width: 100%;
    height: 400px;
    margin-bottom: 40px;
}

.create-form {
    display: flex;
    flex-direction: column;
}
.group-text{
    font-size: 22px;
    font-weight: 600;
    margin-top: 15px;
    margin-bottom: 15px;
}
.create-text{
    width: 100%;
    border-radius: 0;
    border: 0;
    justify-content: center;
    align-items: centers;
    border-bottom: 1px solid #b9b7b7;
    margin-bottom: 10px;

    font-size: 20px;
    font-weight: 400;
    color: #212529BF;
}
.create-button{
    margin-top: 20px;
    height: 50px;
    border-radius: 10px;
    background-color: rgb(0, 0, 0);
    color: white;
    font-size: 25px;
    font-weight: 600;
}

</style>
  