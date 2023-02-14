import { useNavigate } from "react-router-dom";

function nav(){

    const navigate = useNavigate()

return (
    <div className="absolute w-64 h-[calc(100%-128px)] top-16 bg-gradient-to-br from-[#0f0f0f] to-neutral-700 rounded-br-3xl shadow-lg shadow-blue-900">
        <div className="absolute inset-5  flex flex-col justify-start">
            <div onClick={() => navigate("/OJ1")} className="relative text-neutral-500 border w-full h-8 align-middle text-center font-bold text-xl">Orange Juice</div>
            <div onClick={() => navigate("/OJ2")} className="relative text-neutral-500 border w-full h-8 align-middle text-center font-bold text-xl mt-3">Orange Juice II</div>
            <div onClick={() => navigate("/OJ3")} className="relative text-neutral-500 border w-full h-8 align-middle text-center font-bold text-xl mt-3">Orange Juice 3</div>
            <div onClick={() => navigate("/CWL")} className="relative text-neutral-500 border w-full h-8 align-middle text-center font-bold text-xl mt-3">CWL</div>
            <div onClick={() => navigate("/cannon")} className="relative text-neutral-500 border w-full h-8 align-middle text-center font-bold text-xl mt-3">Cannon</div>
            <div onClick={() => navigate("/other")} className="relative text-neutral-500 border w-full h-8 align-middle text-center font-bold text-xl mt-3">Other</div>
        </div>
    </div>
);

}




export default nav;