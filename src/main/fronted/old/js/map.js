const initMap = () => {
    return new ol.Map({
        target: 'map',
        layers: [
            new ol.layer.Tile({
                source: new ol.source.OSM() // Base Map (OpenStreetMap)
            })
        ],
        view: new ol.View({
            center: ol.proj.fromLonLat([128.07666015625014, 36.4696612599073]),
            zoom: 9
        })
    });
};


const map = initMap();