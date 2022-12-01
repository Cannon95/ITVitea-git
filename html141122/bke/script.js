let index = 0;
let boven_rij = 0;
let vert_rij = 0;
let onder_rij = 0;
let links_rij = 0;
let hori_rij = 0;
let rechts_rij = 0;
let schuin1_rij = 0;
let schuin2_rij = 0;

document.addEventListener('mousedown', (event) => {
    let target = event.target.getAttribute('id');
    let classname = event.target.className;

    if (classname === "vakje") {
        let image = document.createElement("img");
        if (index % 2 === 0) {
            image.setAttribute("src", "img/cross.png")
            event.target.className == "kruisje";
        }
        else {
            image.setAttribute("src", "img/cirkel.png")
            event.target.className == "rondje";
        }



        let kruisje = document.querySelectorAll(".kruisje").forEach((elem) => {
            let letter1 = elem.getAttribute("id").substring(6, 7);
            let letter2 = elem.getAttribute("id").substring(7);
            let beideLetters = elem.getAttribute("id").substring(6);
            if (letter1 === "l") {
                links_rij++;

            }
            if (letter1 === "m") {
                vert_rij++;
            }
            if (letter1 === "r") {
                rechts_rij++;
            }
            if (letter2 === "b") {
                boven_rij++;
            }
            if (letter2 === "m") {
                hori_rij++;
            }
            if (letter2 === "o") {
                onder_rij++;
            }
            if (beideLetters === "lb" || beideLetters === "mm" || beideLetters === "ro") {
                schuin1_rij++;
            }
            if (beideLetters === "lo" || beideLetters === "mm" || beideLetters === "rb") {
                schuin1_rij++;
            }

        });

        boven_rij = 0;
        vert_rij = 0;
        onder_rij = 0;
        links_rij = 0;
        hori_rij = 0;
        rechts_rij = 0;
        schuin1_rij = 0;
        schuin2_rij = 0;

        let rondje = document.querySelectorAll(".kruisje").forEach((elem) => {
            let letter1 = elem.getAttribute("id").substring(6, 7);
            let letter2 = elem.getAttribute("id").substring(7);
            let beideLetters = elem.getAttribute("id").substring(6);
            if (letter1 === "l") {
                links_rij++;
            }
            if (letter1 === "m") {
                vert_rij++;
            }
            if (letter1 === "r") {
                rechts_rij++;
            }
            if (letter2 === "b") {
                boven_rij++;
            }
            if (letter2 === "m") {
                hori_rij++;
            }
            if (letter2 === "o") {
                onder_rij++;
            }
            if (beideLetters === "lb" || beideLetters === "mm" || beideLetters === "ro") {
                schuin1_rij++;
            }
            if (beideLetters === "lo" || beideLetters === "mm" || beideLetters === "rb") {
                schuin1_rij++;
            }

        });



        index++;
    }
});

function calcScore(str){
    

}
