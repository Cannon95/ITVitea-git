

const API = async (method, url = "", data = {}) => {
    let settings = "";
    let response = null;
    if(method === "POST"){
        settings = {method: 'POST', headers: {'content-Type': 'application/json'}, body: JSON.stringify(data)}
        response = await fetch(url, settings);
    }
    else if(method === "GET"){
        response = await fetch(url);
    }
    const body = await response.json();

    if(response.status !== 200){
      throw Error(body.message)
    }
    return body;
    
}

export default API;