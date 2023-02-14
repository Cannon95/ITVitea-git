import API from "./Api";
import { useState, useEffect } from "react";

function Main(props){
        const[players, setPlayers] = useState([]);

    useEffect(() => {
        getStats(props.url).then(results => {
            
            let flist = [];
            results.forEach(r => {
                

                flist.push({name: r.name, th: r.townHallLevel, king: {lvl: r.heroes.king || 0, col: "red"}, queen: r.heroes.queen || 0, warden: r.heroes.warden || 0, champion: r.heroes.champion || 0, heroes: sumOf(r.heroes), lab: (sumOf(r.troops) + sumOf(r.darktroops) + sumOf(r.sieges) + sumOf(r.spells)), pets: sumOf(r.pets)});
            })
            setPlayers(flist);
        })
    }, [players]);

    return (
        <div className="absolute top-20 left-72 right-8 bottom-8 flex flex-col overflow-y-scroll">
            {players.map(player => 
                 <div className="relative w-full min-h-[80px] border border-blue-900 bg-gradient-to-br from-[#0f0f0f] to-neutral-700 rounded-3xl shadow-lg shadow-blue-900 mt-2">
                 <div className="absolute w-36 inset-y-3 left-5 text-neutral-500 align-middle font-bold text-sm p-2">{player.name}</div>
                 <div className="absolute w-4 inset-y-3 left-36 text-neutral-500 align-middle font-bold text-2xl p-2">TH{player.th}</div>
                 <div className="absolute w-[75%] inset-y-3 left-64 flex justify-between text-neutral-500 align-middle text-center font-bold text-2xl">
                     <div className="relative w-[110px] h-full flex flex-row justify-start">
                     {player.king.lvl == 0 && <div className="absolute w-full h-full bg-[#222222DD] z-20"></div>}
                         <div className="relative border w-12 h-[52px] rounded-[50%] border-blue-900 bg-gradient-to-br from-[#0f0f0f] to-neutral-700 z-10">
                         <img src="/img/king.png" className="absolute top-1"></img>
                         </div>
                         <div className="relative border-t border-b border-r w-16 top-2 h-9  rounded-r-xl border-blue-900 bg-gradient-to-br from-[#0f0f0f] to-neutral-700">{player.king.lvl}</div>
                     </div>
                     <div className="relative w-[110px] h-full flex flex-row justify-start">
                     {player.queen == 0 && <div className="absolute w-full h-full bg-[#222222DD] z-20"></div>}
                         <div className="absolute border w-12 h-[52px] rounded-[50%] border-blue-900 bg-gradient-to-br from-[#0f0f0f] to-neutral-700 z-10">
                         <img src="/img/queen.png" className="absolute top-1"></img>
                         </div>
                         <div className="absolute border-t border-b border-r w-16 inset-y-2 left-[39%] rounded-r-xl border-blue-900 bg-gradient-to-br from-[#0f0f0f] to-neutral-700">{player.queen}</div>
                     </div>
                     <div className="relative w-[110px] h-full flex flex-row justify-start">
                     {player.warden == 0 && <div className="absolute w-full h-full bg-[#222222DD] z-20"></div>}
                         <div className="absolute border w-12 h-[52px] rounded-[50%] border-blue-900 bg-gradient-to-br from-[#0f0f0f] to-neutral-700 z-10">
                         <img src="/img/warden.png" className="absolute top-1"></img>
                         </div>
                         <div className="absolute border-t border-b border-r w-16 inset-y-2 left-[39%] rounded-r-xl border-blue-900 bg-gradient-to-br from-[#0f0f0f] to-neutral-700">{player.warden}</div>
                     </div>
                     <div className="relative w-[110px] h-full flex flex-row justify-start">
                     {player.champion == 0 && <div className="absolute w-full h-full bg-[#222222DD] z-20"></div>}
                         <div className="absolute border w-12 h-[52px] rounded-[50%] border-blue-900 bg-gradient-to-br from-[#0f0f0f] to-neutral-700 z-10">
                         <img src="/img/champion.png" className="absolute top-1"></img>
                         </div>
                         <div className="absolute border-t border-b border-r w-16 inset-y-2 left-[39%] rounded-r-xl border-blue-900 bg-gradient-to-br from-[#0f0f0f] to-neutral-700">{player.champion}</div>
                     </div>
                     <div className="relative w-[110px] h-full flex flex-row justify-start">
                     {player.heroes == 0 && <div className="absolute w-full h-full bg-[#222222DD] z-20"></div>}
                         <div className="absolute border w-12 h-[52px] rounded-[50%] border-blue-900 bg-gradient-to-br from-[#0f0f0f] to-neutral-700 z-10">
                         <img src="/img/heroes.png" className="absolute top-1"></img>
                         </div>
                         <div className="absolute border-t border-b border-r w-16 inset-y-2 left-[39%] rounded-r-xl border-blue-900 bg-gradient-to-br from-[#0f0f0f] to-neutral-700">{player.heroes}</div>
                     </div>
                     <div className="relative w-[110px] h-full flex flex-row justify-start">
                     {player.lab == 0 && <div className="absolute w-full h-full bg-[#222222DD] z-20"></div>}
                         <div className="absolute border w-12 h-[52px] rounded-[50%] border-blue-900 bg-gradient-to-br from-[#0f0f0f] to-neutral-700 z-10">
                         <img src="/img/lab.png" className="absolute top-1"></img>
                         </div>
                         <div className="absolute border-t border-b border-r w-16 inset-y-2 left-[39%] rounded-r-xl border-blue-900 bg-gradient-to-br from-[#0f0f0f] to-neutral-700">{player.lab}</div>
                     </div>
                     <div className="relative w-[110px] h-full flex flex-row justify-start">
                        
                         {player.pets == 0 && <div className="absolute w-full h-full bg-[#222222DD] z-20"></div>}
                         <div className="absolute border w-12 h-[52px] rounded-[50%] border-blue-900 bg-gradient-to-br from-[#0f0f0f] to-neutral-700 z-10">
                         <img src="/img/pet.png" className="absolute top-1"></img>
                         </div>
                         <div className="absolute border-t border-b border-r w-16 inset-y-2 left-[39%] rounded-r-xl border-blue-900 bg-gradient-to-br from-[#0f0f0f] to-neutral-700">{player.pets}</div>
                     </div>
                    
                 </div>
                 
                
             </div>
                
                
                )}
        </div>
    );
}


async function getStats(url){
    const result = await API("GET", url)

   return result;
   
}

function sumOf(arr){
    let count = 0;
    for(const b in arr){
        count += Number(arr[b]);
    }

    count -= arr.id;

    return count;
}


export default Main;