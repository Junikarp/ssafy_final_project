<template>
    <div>
        <div ref="map" style="width: 100%; height: 400px;"></div>
    </div>
</template>
  
<script>
import { ref, watchEffect } from 'vue';

export default {
    props: {
        initialPosition: {
            type: Object,
            required: true,
        },
    },
    setup(props) {
        const map = ref(null);
        const marker = ref(null);

        const loadKakaoMapScript = () => {
            const script = document.createElement("script");
            script.src = "https://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=9c2e2b61d467effcf3ddff2aba363dd9";
            document.head.appendChild(script);

            script.onload = () => {
                window.kakao.maps.load(() => {
                    initializeMap();
                });
            };
        };

        const initializeMap = () => {
            map.value = new window.kakao.maps.Map(document.getElementById("map"), {
                center: new window.kakao.maps.LatLng(
                    props.initialPosition.lat,
                    props.initialPosition.lng
                ),
                level: 3,
            });

            marker.value = new window.kakao.maps.Marker({
                position: new window.kakao.maps.LatLng(
                    props.initialPosition.lat,
                    props.initialPosition.lng
                ),
                map: map.value,
            });
        };

        watchEffect(() => {
            if (props.initialPosition) {
                updateMap();
            }
        });

        const updateMap = () => {
            const newLatLng = new window.kakao.maps.LatLng(
                props.initialPosition.lat,
                props.initialPosition.lng
            );

            map.value.setCenter(newLatLng);
            marker.value.setPosition(newLatLng);
        };

        loadKakaoMapScript();

        return {
            map,
        };
    },
};
</script>
  
<style scoped>
#map {
    width: 100%;
    height: 400px;
}
</style>
  