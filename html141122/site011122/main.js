const audio = new AudioContext();
let Oscillator;
let tones = [];
let KBkeys = [];

for (let x = 0; x < 7; x++) {
    tones.push("c" + x);
    tones.push("Db" + x);
    tones.push("d" + x);
    tones.push("Eb" + x);
    tones.push("e" + x);
    tones.push("f" + x);
    tones.push("Gb" + x);
    tones.push("g" + x);
    tones.push("Ab" + x);
    tones.push("a" + x);
    tones.push("Bb" + x);
    tones.push("b" + x);
}
KBkeys["a"] = "c0";
KBkeys["w"] = "Dd0";
KBkeys["s"] = "d0";
KBkeys["e"] = "Eb0";
KBkeys["d"] = "e0";
KBkeys["r"] = undefined;
KBkeys["f"] = "f0";
KBkeys["t"] = "Gb0";
KBkeys["g"] = "g0";
KBkeys["y"] = "Ab0";
KBkeys["h"] = "a0";
KBkeys["u"] = "Bb0";
KBkeys["j"] = "b0";
KBkeys["i"] = undefined;
KBkeys["k"] = "c1";
KBkeys["o"] = "Dd1";
KBkeys["l"] = "d1";




const piano = document.getElementById("pianobox");
const whiteKeytone = [12, 14, 16, 17, 19, 21, 23];
for (let x = 0; x < 52; x++) {

    const pianoKey = document.createElement("div");
    pianoKey.className = "keyWhite";
    const idName = String.fromCharCode((2 + x) % 7 + 97) + Math.floor(x / 7)
    pianoKey.setAttribute("id", idName); //sets id to piano keytone. e.g. c,d,e,f,g,a,b,c ect
    pianoKey.style.gridColumn = `${x * 2 + 1} / span 2`;
    pianoKey.style.gridRow = "1 / span 2";
    pianoKey.style.border = "2px solid black";
    pianoKey.setAttribute("data-tone", whiteKeytone[x % whiteKeytone.length] + Math.floor(x / 7) * 12);
    pianoKey.innerHTML = `<h2 class=wkeyText>${idName}</h2><span class="KBSelect" id="KBSelect${idName}"></span>`;

    pianoKey.style.textAlign = "center";

    piano.appendChild(pianoKey);
}
const blackKeyList = ["Db", "Eb", "Gb", "Ab", "Bb"];
const blackKeyLoc = [2, 4, 8, 10, 12];
const blackKeytone = [13, 15, 18, 20, 22];
for (let x = 0; x < 36; x++) {
    const pianoKey = document.createElement("div");
    pianoKey.className = "keyBlack";
    const idName = blackKeyList[x % blackKeyList.length] + Math.floor(x / 5)
    pianoKey.setAttribute("id", idName);
    const calcLoc = Math.floor((x / 5)) * 14 + blackKeyLoc[x % blackKeyLoc.length];
    pianoKey.style.gridColumn = `${calcLoc} / span 1`;
    pianoKey.style.gridRow = "1 / span 1";
    pianoKey.setAttribute("data-tone", blackKeytone[x % blackKeytone.length] + Math.floor(x / 5) * 12);
    pianoKey.innerHTML = `<h3 class=bkeyText>${idName}</h3><span class="KBSelect" id="KBSelect${idName}"></span>`;
    piano.appendChild(pianoKey);
}

piano.addEventListener("mousedown", (event) => {
    const tone = event.target.getAttribute("data-tone");

    if (tone) {
        console.log("mouse down: " + tone);
        Oscillator = audio.createOscillator();
        Oscillator.frequency.setTargetAtTime(tone2Hz(tone), audio.currentTime, 0);
        Oscillator.connect(audio.destination);
        Oscillator.start(0);
    }
})
piano.addEventListener("mouseup", (event) => {
    const tone = event.target.getAttribute("data-tone");
    if (tone) {
        console.log("mouse up: " + tone);
        Oscillator.stop(0);
        Oscillator.disconnect(audio.destination);
        Oscillator = null;
    }
});
let mapPressedKeys = [];
const arrKeys = ["a", "w", "s", "e", "d", "r", "f", "t", "g", "y", "h", "u", "j", "i", "k", "o", "l"];
window.addEventListener("keyup", (event) => {
    let tone;
    arrKeys.forEach(v => {
        if (event.key == v) {
            const filtered = mapPressedKeys.filter(k => {return k != v});
            mapPressedKeys = filtered;
            console.log(event.key + " " + KBkeys[v]);
           tone = document.getElementById(KBkeys[v]).getAttribute("data-tone");
        }
    }) 
    if (tone) {
        console.log("key up: " + tone);
        Oscillator.stop(0);
        Oscillator.disconnect(audio.destination);
        Oscillator = null;
    }
});

window.addEventListener("keydown", (event) => {

    for (let i = 0; i < 8; i++) {
        if (event.key == i) {
            KBkeys = [];
            KBkeys["a"] = `c${i}`;
            KBkeys["w"] = `Dd${i}`;
            KBkeys["s"] = `d${i}`;
            KBkeys["e"] = `Eb${i}`;
            KBkeys["d"] = `e${i}`;
            KBkeys["r"] = undefined;
            KBkeys["f"] = `f${i}`;
            KBkeys["t"] = `Gb${i}`;
            KBkeys["g"] = `g${i}`;
            KBkeys["y"] = `Ab${i}`;
            KBkeys["h"] = `a${i}`;
            KBkeys["u"] = `Bb${i}`;
            KBkeys["j"] = `b${i}`;
            KBkeys["i"] = undefined;
            KBkeys["k"] = `c${i+1}`;
            KBkeys["o"] = `Db${i}`;
            KBkeys["l"] = `d${i+1}`;
        }
    }
    let tone;
    arrKeys.forEach(v => {
        if (event.key == v) {
            if (mapPressedKeys.filter((k) => {return event.key == k}) == v){
                
            }
            else {
                mapPressedKeys.push(event.key);
                console.log(event.key + " " + KBkeys[v]);
                document.getElementById(KBkeys[v]);
                tone = document.getElementById(KBkeys[v]).getAttribute("data-tone");
                if (tone) {
                    console.log("mouse down: " + tone);
                    Oscillator = audio.createOscillator();
                    Oscillator.frequency.setTargetAtTime(tone2Hz(tone), audio.currentTime, 0);
                    Oscillator.connect(audio.destination);
                    Oscillator.start(0);
                }
            }         
        }
    })

});

function tone2Hz(tone) {
    return Math.pow(2, (tone - 69) / 12) * 440;
}

function setStartKey() {
    const value = document.getElementById("startKey").value;
    tones.forEach((v, i) => {

        if (v != value) {
            const keytone = document.getElementById(`KBSelect${v}`);

            keytone.innerHTML = "";
        }
        else {
            console.log(`KBSelect: ${v}  ${value}`);
            const keytone = document.getElementById(`KBSelect${v}`);
            if (keytone.parentElement.className === "keyWhite") {
                keytone.innerHTML = "A";
            }
            else if (keytone.parentElement.className === "keyBlack") {
                keytone.innerHTML = "W";
            }
            //
        }
    });


}


