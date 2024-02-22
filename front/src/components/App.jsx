// App.jsx
import React, { useEffect } from 'react';
import Header from './Header';
import MapMain from './MapMain';
import MapTabArea from './MapTabArea';
import MenuArea from './MenuArea';
import UtilArea from './UtilArea';
import Toolbar from './Toolbar';

const App = () => {
    return (
        <div>
            <Header />
            <MapMain />
            <MapTabArea />
            <MenuArea />
            <UtilArea />
            <Toolbar />
        </div>
    );
};

export default App;