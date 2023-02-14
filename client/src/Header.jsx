import { useState } from "react";
import Navigate from "./Nav";

function Header() {
    const [showNav, setNav] = useState(false);




    return (
        <>
            <div className="fixed h-16 w-full bg-gradient-to-b from-blue-900 via-[#09008b] to-[#060057]">
                <img src="/img/nav.png" className="absolute h-[95%] left-2" onClick={() => setNav(!showNav)}></img>
                
            </div>
            {showNav && <Navigate />}
        </>
    );


}

export default Header;