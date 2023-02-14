import Header from "./Header";
import Cannonbody from "./CannonBody";
import { Route, Routes } from "react-router-dom";

function App() {
  
  console.log(window.location.pathname)

  return (
    <>
        <div className='fixed bg-neutral-900 w-screen h-screen'></div>
        <div className='absolute w-screen h-screen'>
            <Header />
        <Routes>
          <Route path="/Cannon" element={<Cannonbody url="http://localhost:8080/api/cannon/all"/>}/>
          <Route path="/OJ1" element={<Cannonbody url="http://localhost:8080/api/clans/%2328UC9CQ9V"/>}/>
          <Route path="/OJ2" element={<Cannonbody url="http://localhost:8080/api/clans/%232YPPLQ9QL"/>}/>
        </Routes>
            
        </div>
          

    </>
  )
}

export default App
