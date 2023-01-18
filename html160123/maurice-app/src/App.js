import logo from './logo.svg';
import './App.css';
import { Route, Routes, Link, NavLink } from 'react-router-dom';
import { useState } from 'react';
import Home from './Home';
import Characters from './Characters';

function App() {




  return (
    <>
      <h1>Hello World</h1>
      <nav>
        <ul>
          <li>
            <NavLink to="/">Home</NavLink>
          </li>
          <li>
            <NavLink to="/characters">characters</NavLink>
          </li>
        </ul>
      </nav>

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/characters" element={<Characters />} />
      </Routes>
    </>
  );
}

export default App;
