const veld1 = document.getElementById("veld1");
const veld2 = document.getElementById("veld2");
let SelectedShip;

    for(i=0; i<100; i++){
        let field1 = document.createElement("div");
        let field2 = document.createElement("div");

        field1.classList.add("veld");
        veld1.appendChild(field1)
        field1.setAttribute('id', "veld1-" + i);

        veld2.appendChild(field2)
        field2.classList.add("veld");
        field2.setAttribute('id', "veld2-" + i);
    }
    for(i=0; i<10; i++){
        let ship = document.createElement("div");
        ship.classList.add("ship");
        veld1.appendChild(ship);
        ship.setAttribute('id', "ship-p1-" + (i+1));
        ship.style.top = 5 + 45*i + "px";
        ship.style.left = "6px";
        ship.style.height = "27px";
    }
    document.getElementById("ship-p1-1").style.width = (6*45-18) + "px";
    document.getElementById("ship-p1-2").style.width = (4*45-18) + "px";
    document.getElementById("ship-p1-3").style.width = (4*45-18) + "px";
    document.getElementById("ship-p1-4").style.width = (3*45-18) + "px";
    document.getElementById("ship-p1-5").style.width = (3*45-18) + "px";
    document.getElementById("ship-p1-6").style.width = (3*45-18) + "px";
    document.getElementById("ship-p1-7").style.width = (2*45-18) + "px";
    document.getElementById("ship-p1-8").style.width = (2*45-18) + "px";
    document.getElementById("ship-p1-9").style.width = (2*45-18) + "px";
    document.getElementById("ship-p1-10").style.width = (2*45-18) + "px";

document.addEventListener('keydown', (event) => {
    let name = event.key;
    alert("key p: " + name);
    if (SelectedShip !== null){
        let data = JSON.stringify({
            ship: SelectedShip,
            key: name
        });
        fetch("http://localhost:8080/zeeslag/MoveShip",{
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: data,
        }).then((response) => response.json())
        .then((data) => {
            console.log(data);
        })

    }


    //fetch
});
document.addEventListener('mousedown', (event) => {
    let target = event.target.getAttribute('id');
    let classname = event.target.className;
    document.querySelectorAll(".ship").forEach( (sship, index, Arr) => {
        sship.style.border = "3px solid #000";
    });
    if(classname === "ship"){
        SelectedShip = target;
        event.target.style.border = "3px solid #FF0";
    }

    //alert("key mouse: " + target + " , class: " + classname);
});

