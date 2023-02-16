

function Navigate() {
    return (
       <nav className="fixed w-[calc(100%-40px)] sm:w-40 h-24 sm:h-[calc(100%-40px)] m-5 max-sm:my-14 bg-gradient-to-br from-neutral-600 to-neutral-900 text-neutral-400 rounded-2xl shadow-md shadow-red-800 z-10">
           {/* logo */}         <div className="absolute h-24 w-40 left-10 top-2 sm:top-4"><img className="sm:w-20 sm:h-14" src="/img/logo.png"/></div>
           {/* user */}         <div className="absolute flex sm:flex-col top-2 left-[calc(100%-120px)] sm:left-8 sm:top-32">
            {/* avatar */}            <img className="rounded-[50%] h-[6.25rem] w-[6.25rem] max-sm:w-9 max-sm:h-9" src="/img/avatar.png"/>
            {/* name */}              <div className="p-[0.375rem] sm:p-3 font-bold">Cannon</div>
                                </div>
          {/* random lijn mobiel */} <div className="absolute top-12 left-5 w-[calc(100%-40px)] h-1 bg-neutral-400 sm:hidden"></div>
           {/* content list */} <div  className="absolute top-16 sm:top-72 left-2 sm:left-6 flex sm:flex-col justify-between sm:justify-start max-sm:w-[calc(100%-15px)]">
                                      <div className="flex">
                                        <img className="m-1 max-sm:m-[0.1rem] w-5 h-5 sm:w-7 sm:h-7 rounded-[50%]" src="/img/dashboard.png"/>
                                        <div className="m-1 max-sm:m-[0.1rem] max-sm:text-sm">Dashboard</div>
                                      </div>
                                      <div className="flex">
                                        <img className="m-1 max-sm:m-[0.1rem] w-5 h-5 sm:w-7 sm:h-7 rounded-[50%]" src="/img/tasks.png"/>
                                        <div className="m-1 max-sm:m-[0.1rem] max-sm:text-sm">Tasks</div>
                                      </div>
                                      <div className="flex">
                                        <img className="m-1 max-sm:m-[0.1rem] w-5 h-5 sm:w-7 sm:h-7 rounded-[50%]" src="/img/sites.png"/>
                                        <div className="m-1 max-sm:m-[0.1rem] max-sm:text-sm">Websites</div>
                                      </div>
                                      <div className="flex">
                                        <img className="m-1 max-sm:m-[0.1rem] w-5 h-5 sm:w-7 sm:h-7 rounded-[50%]" src="/img/unknown.png"/>
                                        <div className="m-1 max-sm:m-[0.1rem] max-sm:text-sm">Overig</div>
                                      </div>
                                </div>
       </nav> 
    );

}

export default Navigate;