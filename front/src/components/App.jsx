// App.jsx
import React from 'react';
import Header from './Header';
import Map from './Map';
import MapTabArea from './MapTabArea';
import MenuArea from './MenuArea';
import UtilArea from './UtilArea';
import Toolbar from './Toolbar';

const App = () => {
    return (
        <div>
            <Header />
            <Map />
            <MapTabArea />
            <MenuArea />
            <UtilArea />
            <Toolbar />
        </div>
    );
};

export default App;