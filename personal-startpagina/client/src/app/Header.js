

function Header() {
    return (
        <div className="fixed w-full h-20 bg-gradient-to-b from-[#331111] via-[#4B2211] to-red-800 z-10 text-neutral-400" >
           {/* TIME */} <div className="absolute p-5 font-bold text-2xl left-[calc(100%-100px)] max-sm:p-3">12:00</div>
           {/* DATE */} <div className="absolute p-6 font-bold left-[calc(100%-250px)] max-sm:p-4 max-sm:left-1">11/01/2022</div>
        </div>
    );
}

export default Header;