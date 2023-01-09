
const API_KEY = "582e30854418a5f667d268e70d1099c5";
const LAT = "52.03186490329375";
const LON = "5.569567066598651";


fetch(`https://api.openweathermap.org/data/2.5/weather?lat=${LAT}&lon=${LON}&appid=${API_KEY}&units=metric`)
.then((response) =>{
   return response.json();
})
.then(data => {
    console.log(data);
    console.log(" ");
    console.log(" ");
    //console.log(data.main);
    const CurTemp = data.main.temp;
    const minTemp = data.main.temp_min;
    const maxTemp = data.main.temp_max;
    const humidity = data.main.humidity;
    const pressure = data.main.pressure;
    const feeltemp = data.main.feels_like;

    console.log(CurTemp);
    console.log(minTemp);
    console.log(maxTemp);
    console.log(`hum: ${humidity}%`);
    console.log(`pressure: ${pressure} hPa`);
    console.log(feeltemp);



});

