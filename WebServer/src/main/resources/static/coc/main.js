

function submitdata(){
    const field = document.getElementById("testbox");
    console.log(field.value)
    const data = {playertag: field.value};
    sendData("http://localhost:8080/coc/submitWhite", data);
}

async function sendData(url = '', data = {}){

    const response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
          },
        body: JSON.stringify(data)
    });
    return response.json();
}