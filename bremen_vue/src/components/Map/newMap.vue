<template>
    <div>
        <div id="map" style="width: 100%; height: 400px;"></div>
        <div>
            <button @click="getCurrentLocation">현재 위치로 이동</button>
            <input v-model="searchKeyword" placeholder="장소를 검색하세요" />
            <button @click="searchPlaces">검색</button>
        </div>
        <div v-if="selectedPlace">
            <h3>{{ selectedPlace.place_name }}</h3>
            <p>{{ selectedPlace.address_name }}</p>
            <p>{{ selectedPlace.phone || '전화번호 없음' }}</p>
        </div>
    </div>
</template>
  
<script setup>
import { ref, onMounted } from 'vue';

let map = null;
let markers = [];
let ps = null;
let infowindow = null;
let selectedPlace = null;
const searchKeyword = ref('');

const initMap = () => {
    const container = document.getElementById('map');
    const options = {
        level: 5,
    };

    map = new kakao.maps.Map(container, options);
    ps = new kakao.maps.services.Places(map);
    infowindow = new kakao.maps.InfoWindow({ zIndex: 1 });

    getCurrentLocation();
};

const addMarker = (position) => {
    removeMarkers();

    const marker = new kakao.maps.Marker({
        position: position,
        map: map,
        title: '새로운 마커',
    });

    markers.push(marker);

    kakao.maps.event.addListener(marker, 'click', function () {
        getPlaceDetails(position);
    });

    kakao.maps.event.addListener(map, 'click', function (mouseEvent) {
        const clickedLatLng = mouseEvent.latLng;
        console.log(`클릭한 위치의 좌표: ${clickedLatLng.getLat()}, ${clickedLatLng.getLng()}`);
    });
};

const removeMarkers = () => {
    for (let i = 0; i < markers.length; i++) {
        markers[i].setMap(null);
    }

    markers = [];
};

const searchPlaces = () => {
    if (searchKeyword.value === '') {
        alert('검색어를 입력하세요.');
        return;
    }

    removeMarkers();

    navigator.geolocation.getCurrentPosition(
        (position) => {
            const latLng = new kakao.maps.LatLng(
                position.coords.latitude,
                position.coords.longitude
            );

            map.setCenter(latLng);

            ps.keywordSearch(searchKeyword.value, (data, status, pagination) => {
                if (status === kakao.maps.services.Status.OK) {
                    for (let i = 0; i < data.length; i++) {
                        const placeLatLng = new kakao.maps.LatLng(data[i].y, data[i].x);
                        addMarker(placeLatLng);
                    }
                }
            });
        },
        (error) => {
            console.error(error.message);
        }
    );
};

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

    ps.coord2RegionCode(options, callback);
};

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

const getCurrentLocation = () => {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(
            (position) => {
                const latLng = new kakao.maps.LatLng(
                    position.coords.latitude,
                    position.coords.longitude
                );

                map.setCenter(latLng);
                addMarker(latLng);
            },
            (error) => {
                console.error(error.message);
            }
        );
    } else {
        alert('Geolocation이 지원되지 않습니다.');
    }
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
  