
export default async (url = "", data = {}) => {

    const response = await fetch(url);
    const body = await response.json();

    if (response.status < 200 && response.status > 400){
        throw Error(body.message)
    }

    return body;

}