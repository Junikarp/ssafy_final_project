<template>
    <l-map style="height: 400px; width: 100%;" :center="center" :zoom="zoom" @click="handleMapClick">
        <!-- 마커 표시 -->
        <l-marker :lat-lng="markerCoordinates" v-if="markerCoordinates">
            <l-popup>
                <p>클릭된 위치</p>
                <p>Latitude: {{ markerCoordinates.lat.toFixed(6) }}</p>
                <p>Longitude: {{ markerCoordinates.lng.toFixed(6) }}</p>
            </l-popup>
        </l-marker>
    </l-map>
</template>
  
<script>
// 필요한 컴포넌트를 가져옵니다.
import {
    LMap,
    LTileLayer,
    LMarker,
    LPolyline,
    LPopup,
} from '@vue-leaflet/vue-leaflet';
import 'leaflet/dist/leaflet.css';

export default {
    components: {
        LMap,
        LTileLayer,
        LMarker,
        LPolyline,
        LPopup,
    },
    props: {
        // 외부에서 좌표를 받아오기 위한 prop
        externalCoordinates: {
            type: Object,
            default: null,
        },
    },
    data() {
        return {
            // 지도 중심 위치와 줌 레벨
            center: [37.5665, 126.9780],
            zoom: 13,
            // 마커 좌표
            markerCoordinates: null,
        };
    },
    methods: {
        handleMapClick(event) {
            // 마우스 클릭 이벤트 발생 시, 마커 좌표 업데이트
            this.markerCoordinates = {
                lat: event.latlng.lat,
                lng: event.latlng.lng,
            };

            // 부모 컴포넌트에 마커 좌표 전달
            this.$emit('markerClick', this.markerCoordinates);
        },
    },
    watch: {
        // 외부에서 좌표를 업데이트하면 지도의 마커도 업데이트
        externalCoordinates: {
            immediate: true,
            handler(newVal) {
                this.markerCoordinates = newVal;
            },
        },
    },
};
</script>
  
<style scoped>
/* 스타일링을 위한 CSS */
</style>
  