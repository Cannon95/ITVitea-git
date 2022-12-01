var mouseX = 0;
var mouseY = 0;
var button = document.getElementById("button");
buttonFlee()

document.addEventListener('mousemove', (event) => {
    const rect = button.getBoundingClientRect();
    mouseX = event.clientX;
    mouseY = event.clientY;
	console.log(`Mouse X: ${event.clientX}, Mouse Y: ${event.clientY}, Button X: ${button.offsetLeft}, Button Y: ${button.offsetTop} , Button w: ${button.offsetWidth} , Button h: ${button.offsetHeight}`);
});

function buttonFlee(){
    
   
    setInterval((button) => {
        const distance = getDistance(button.offsetLeft,button.offsetTop);
        const move = calcFleeMove(distance);
        button.offsetLeft += move.x;
        button.offsetTop += move.y;
    }, 1000)
     
}

function getDistance(buttonX, buttonY){
    const rect = button.getBoundingClientRect();

    let disX = screen.width/2;
    let disY = screen.height/2;
    if(mouseX - buttonX > screen.width/2){
        disX =  screen.width-(mouseX - buttonX) + 18;
    }
    else if(mouseX - buttonX < -screen.width/2){
        disX =  -screen.width+(mouseX - buttonX) + 18;
    }
    else{
        disX = mouseX - buttonX + 18;
    }

    if(mouseY - buttonY > screen.height/2){
        disY =  screen.height-(mouseY - buttonY) + 10;
    }
    else if(mouseY - buttonY < -screen.height/2){
        disY =  -screen.height+(mouseY - buttonY) + 10;
    }
    else{
        disY = mouseY - buttonY + 10;
    }
    
    return {x: disX, y: disY};
}
function calcFleeMove(distance){
    let moveX = 0;
    let moveY = 0;
    if(distance.x < 300){
        moveX = (300 - distance.x)/100;
    }
    if(distance.y < 300){
        moveY = (300 - distance.y)/100;
    }
    return {x: moveX, y: moveY};
}