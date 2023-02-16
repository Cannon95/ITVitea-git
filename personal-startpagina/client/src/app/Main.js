import Checkbox from "./Checkbox";
import DeadlineIcon from "./DeadlineIcon";

function Main() {
    return (
        <div className="absolute grid gap-6 grid-cols-1 sm:grid-cols-2 left-5 sm:left-52 top-52 sm:top-32 right-10 h-[125%] sm:w-[calc(100%-250px)] sm:h-[calc(100%-150px)]">
            <DashBoard/>
       </div>
    );
}

export default Main;


function DashBoard() {
return (
     <>
     {/* Widget 1 */}    <div className="relative rounded-2xl bg-gradient-to-br from-neutral-600 to-neutral-900 row-[1/3] shadow-md shadow-red-900 overflow-hidden">
                                <div className="absolute top-3 text-neutral-400 left-5 text-xl">My tasks</div>
                                <a href="/tasks" className="absolute top-3 text-red-600 left-[calc(100%-70px)] hover:underline">See all</a>
                                <div className="absolute flex flex-col justify-evenly top-[10%] sm:top-[8%] left-5 w-[calc(100%-20px)] h-[calc(100%-100px)]">
                                    <div className="relative w-[95%] h-[30%] border-solid border-2 border-neutral-500 rounded-lg overflow-hidden">
                                        <img className="relative top-2 w-6 left-[calc(100%-30px)]" src="/img/points.png"></img>{/* Points */}
                                        
                                        <Checkbox isChecked={false} />{/* checkbox */}
                                        <div className="absolute top-2 sm:top-6 left-5 text-neutral-400 text-xs">school</div>
                                        <div className="absolute inline-block whitespace-nowrap top-6 sm:top-12 left-5 text-neutral-400 text-lg font-bold ">Do this do that and do this</div>
                                        
                                        <div className="absolute flex flex-wrap justify-between top-14 sm:top-20 left-5 w-[calc(100%-60px)] sm:w-[calc(100%-35px)]">
                                            <div className="relative flex flex-row gap-2">
                                                <DeadlineIcon color={"red"} />{/* notify color */}
                                                <div className="relative text-neutral-400 text-xs min-w-fit">deadline today</div>
                                            </div>
                                            
                                            <div className="relative text-neutral-400 text-xs">11-01-2022  12:30</div>
                                        </div>
                                    </div>
                                    <div className="relative w-[95%] h-[30%] border-solid border-2 border-neutral-500 rounded-lg overflow-hidden">
                                    <img className="relative top-2 w-6 left-[calc(100%-30px)]" src="/img/points.png"></img>{/* Points */}
                                        
                                        <Checkbox isChecked={false} />{/* checkbox */}
                                        <div className="absolute top-2 sm:top-6 left-5 text-neutral-400 text-xs">school</div>
                                        <div className="absolute inline-block whitespace-nowrap top-6 sm:top-12 left-5 text-neutral-400 text-lg font-bold ">Do this do that and do this</div>
                                        
                                        <div className="absolute flex flex-wrap justify-between top-14 sm:top-20 left-5 w-[calc(100%-60px)] sm:w-[calc(100%-35px)]">
                                            <div className="relative flex flex-row gap-2">
                                                <DeadlineIcon color={"yellow"} />{/* notify color */}
                                                <div className="relative text-neutral-400 text-xs min-w-fit">deadline this week</div>
                                            </div>
                                            
                                            <div className="relative text-neutral-400 text-xs">13-01-2022  12:30</div>
                                        </div>
                                    </div>
                                    <div className="relative w-[95%] h-[30%] border-solid border-2 border-neutral-500 rounded-lg overflow-hidden">
                                    <img className="relative top-2 w-6 left-[calc(100%-30px)]" src="/img/points.png"></img>{/* Points */}
                                        
                                        <Checkbox isChecked={false} />{/* checkbox */}
                                        <div className="absolute top-2 sm:top-6 left-5 text-neutral-400 text-xs">school</div>
                                        <div className="absolute inline-block whitespace-nowrap top-6 sm:top-12 left-5 text-neutral-400 text-lg font-bold ">Do this do that and do this</div>
                                        
                                        <div className="absolute flex flex-wrap justify-between top-14 sm:top-20 left-5 w-[calc(100%-60px)] sm:w-[calc(100%-35px)]">
                                            <div className="relative flex flex-row gap-2">
                                                <DeadlineIcon color={"green"} />{/* notify color */}
                                                <div className="relative text-neutral-400 text-xs min-w-fit">deadline in 12 days</div>
                                            </div>
                                            
                                            <div className="relative text-neutral-400 text-xs">23-01-2022  12:30</div>
                                        </div>
                                    </div>
                                </div>
                                <img src="/img/add.png" className="absolute left-5 top-[calc(100%-50px)] w-10 rounded-[50%]"></img>
     </div>
     {/* Widget 2 */}    <div className="relative rounded-2xl bg-gradient-to-br from-neutral-600 to-neutral-900 bg-neutral-700 shadow-md shadow-red-900">
                                <div className="absolute top-3 text-neutral-400 left-5 text-lg">My favourite websites</div>
                                <a href="/tasks" className="absolute top-3 text-red-600 left-[calc(100%-70px)] hover:underline">See all</a>
                          </div>
     {/* Widget 3 */}    <div className="relative rounded-2xl bg-gradient-to-br from-neutral-600 to-neutral-900 bg-neutral-700 shadow-md shadow-red-900">
                                <div className="absolute top-3 text-neutral-400 left-5 text-lg">Weather</div>
                                <a href="/tasks" className="absolute top-3 text-red-600 left-[calc(100%-70px)] hover:underline">See all</a>
                         </div>
     
     </>
);

}