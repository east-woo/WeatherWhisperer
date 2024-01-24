import React, { useState, useEffect } from 'react';
import 'ol/ol.css';
import { XYZ } from 'ol/source';
import { Map as AllMap, View } from 'ol';
import { fromLonLat, get as getProjection } from 'ol/proj';
import { Tile as TileLayer } from 'ol/layer';
import { OSM } from 'ol/source';
import { PopupMessage } from './PopupMessage';


const Map = () => {
    const [mapObject, setMapObject] = useState({});
    const [message, setMessage] = useState("");


    useEffect(() => {
        const map = new AllMap({
            layers: [
                new TileLayer({
                    source: new XYZ({ url: "http://xdworld.vworld.kr:8080/2d/Base/202002/{z}/{x}/{y}.png" }),
                })
            ],
            target: 'map',
            view: new View({
                projection: getProjection('EPSG:3857'),
                center: fromLonLat([126.752, 37.4713], 'EPSG:3857'),
                zoom: 13
            })
        });

        setMapObject({ map });

        // Clean up function
        return () => {
            if (map) {
                map.setTarget(null);
            }
        };
    }, []);


    const handlePopupMessage = () => {
        setMessage("아직은 안되지롱!");
    };



    return <div id="map" style={{ height: '100rem' }}>
    </div>;
}

export default Map;