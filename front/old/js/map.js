const initMap = () => {
    return new ol.Map({
        target: 'map',
        layers: [
            // new ol.layer.Tile({
            //     source: new ol.source.OSM() // Base Map (OpenStreetMap)
            // })
            new ol.layer.Tile({
    source: new ol.source.XYZ({ //vworld api 사용
        url : 'https://xdworld.vworld.kr/2d/Base/service/{z}/{x}/{y}.png'
    })
})
        ],
        view: new ol.View({
            center: ol.proj.fromLonLat([128.07666015625014, 36.4696612599073]),
            zoom: 9
        })
    });
};


const map = initMap();