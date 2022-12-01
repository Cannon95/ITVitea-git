const list = ["rock", "paper", "scissors"]

document.addEventListener('mousedown', (event) => {
    const yourChoice = event.target.getAttribute("id");
    const opponentChoice = Math.floor(Math.random() * 3);
    const calcY = event.target.getAttribute("data-v");
    const notify = document.getElementById("notify");

    if (opponentChoice - calcY == 2 || calcY - opponentChoice == 1) {
        notify.innerHTML = "You Win!";
        notify.style.color = "#4F5";
    }
    else if (calcY - opponentChoice == 2 || opponentChoice - calcY == 1) {
        notify.innerHTML = "You Lose!";
        notify.style.color = "red";
    }
    else {
        notify.innerHTML = "Draw!";
        notify.style.color = "yellow";
    }


    const opponentChoiceName = list[opponentChoice];
    const opponentElement = document.getElementById("opponent");
    const opponentImage = document.createElement("img");
    opponentElement.replaceChildren();
    opponentImage.setAttribute("src", "img/" + opponentChoiceName + ".png");
    opponentElement.appendChild(opponentImage);
    console.log(`you: ${yourChoice} opponent: ${opponentChoiceName}`);

});

