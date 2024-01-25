import React from 'react';
import ReactDOM from 'react-dom/client';
import './styles/index.css';
import App from './components/App';
import reportWebVitals from './utils/reportWebVitals';
import MapMain from "./components/MapMain";
import Header from './components/Header';
import MapTabArea from './components/MapTabArea';
import MenuArea from './components/MenuArea';
import UtilArea from './components/UtilArea';
import Toolbar from './components/Toolbar';
//import MapTest from "./MapTest";

import { RecoilRoot } from 'recoil';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <Header />
    <MapMain />
    <MapTabArea />
    <MenuArea />
    <UtilArea />
    <Toolbar />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
