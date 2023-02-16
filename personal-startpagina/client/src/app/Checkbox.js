import {useState} from 'react';


function Checkbox(props){

    const [isChecked, setChecked] = useState(props.isChecked);


    return(
        <div className="absolute w-6 h-6 left-[calc(100%-30px)] top-[calc(100%-30px)]">
             <div className='absolute w-full h-full rounded-md border-solid border-2 border-neutral-200 bg-neutral-500'></div>
             {isChecked && <img src="/img/checked.png" className='absolute w-full h-full rounded-md'></img>}
             <div onClick={() => setChecked(!isChecked)} className="absolute w-full h-full"></div>
             
        </div>
    )
}

export default Checkbox;
