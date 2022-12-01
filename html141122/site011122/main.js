const audio = new AudioContext();
let Oscillator;
let tones = [];

for(let x = 0; x < 7; x++){
    tones.push("C" + x);
    tones.push("Db" + x);
    tones.push("D" + x);
    tones.push("Eb" + x);
    tones.push("E" + x);
    tones.push("F" + x);
    tones.push("Fb" + x);
    tones.push("G" + x);
    tones.push("Gb" + x);
    tones.push("A" + x);
    tones.push("Ab" + x);
    tones.push("B" + x);
}

const piano = document.getElementById("pianobox");
const whiteKeytone = [12,14,16,17,19,21,23];
for(let x = 0; x < 52; x++){
    
    const pianoKey = document.createElement("div");
    pianoKey.className = "keyWhite";
    const idName = String.fromCharCode((2+x)%7 + 97) + Math.floor(x/7)
    pianoKey.setAttribute("id", idName); //sets id to piano keytone. e.g. c,d,e,f,g,a,b,c ect
    pianoKey.style.gridColumn = `${x*2 + 1} / span 2`;
    pianoKey.style.gridRow = "1 / span 2" ;
    pianoKey.style.border = "2px solid black";
    pianoKey.setAttribute("data-tone", whiteKeytone[x%whiteKeytone.length] + Math.floor(x/7)*12);
    pianoKey.innerHTML = `<h2 class=wkeyText>${idName}</h2>` ;

    pianoKey.style.textAlign = "center";

    piano.appendChild(pianoKey);
}
const blackKeyList = ["Db" , "Eb" , "Gb", "Ab", "Bb"];
const blackKeyLoc = [2,4,8,10,12];
const blackKeytone = [13,15,18,20,22];
for(let x = 0; x < 36; x++){
    const pianoKey = document.createElement("div");
    pianoKey.className = "keyBlack";
    const idName = blackKeyList[x%blackKeyList.length] + Math.floor(x/5)
    pianoKey.setAttribute("id", idName);
    const calcLoc = Math.floor((x/5))* 14 + blackKeyLoc[x%blackKeyLoc.length];
    pianoKey.style.gridColumn = `${calcLoc} / span 1`;
    pianoKey.style.gridRow = "1 / span 1" ;
    pianoKey.style.backgroundColor = "black";
    pianoKey.setAttribute("data-tone", blackKeytone[x%blackKeytone.length] + Math.floor(x/5)*12);
    pianoKey.innerHTML = `<h3 class=bkeyText>${idName}</h3>` ;
    piano.appendChild(pianoKey);
}

piano.addEventListener("mousedown", (event) => {
    const tone = event.target.getAttribute("data-tone");
    
    if(tone){
        console.log("mouse down: " + tone);
        Oscillator = audio.createOscillator();
        Oscillator.frequency.setTargetAtTime(tone2Hz(tone), audio.currentTime, 0);
        Oscillator.connect(audio.destination);
        Oscillator.start(0);
    }
})
piano.addEventListener("mouseup", (event) => {
    const tone = event.target.getAttribute("data-tone");
    if(tone ){
        console.log("mouse up: " + tone);
        Oscillator.stop(0);
        Oscillator.disconnect(audio.destination);
        Oscillator = null;
    }
})

function tone2Hz(tone){
    return Math.pow(2, (tone-69)/12) * 440
}


