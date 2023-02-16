import {useState} from 'react';

function DeadlineIcon(props){
    
    let cl123 = props.color;

    const [colour123, setColor] = useState(cl123);

    return (
        <div className="relative w-5 rounded-[50%]">
            {colour123 === "red" && <img src="/img/reddl.png" className="w-full h-full rounded-[50%]"/>}
            {colour123 === "green" && <img src="/img/noworrydl.png" className="w-full h-full rounded-[50%]"/>}
            {colour123 === "yellow" && <img src="/img/yellowdl.png" className="w-full h-full rounded-[50%]"/>}
        </div>
    );
}

export default DeadlineIcon;