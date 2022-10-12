

$(document).ready(function () {


for(i = 0; i < 10; i++){
        var naam = i;
        if(i === 6){naam = "Brug"}
        $(".spel").append('<div class="veldje" id="veld-' + i + '">' + naam + '</div>');
        $("#veld-" + i).css("left", (10 + i* 65) + "px")
        $("#veld-" + i).css("top", (595) + "px")
        if(i === 6){$("#veld-" + i).css("background-color", "#FF0")}
        if(doesContain(i)){$("#veld-" + i).css("background-color", "#0F0")}
}
for(i = 10; i < 19; i++){
        $(".spel").append('<div class="veldje" id="veld-' + i + '">' + i + '</div>');
        $("#veld-" + i).css("left", (595) + "px")
        $("#veld-" + i).css("top", (595 - (i-9) * 65) + "px")
        if(doesContain(i)){$("#veld-" + i).css("background-color", "#0F0")}
}
for(i = 19; i < 28; i++){
    var naam = i;
    if(i === 19){naam = "Herberg"}
        $(".spel").append('<div class="veldje" id="veld-' + i + '">' + naam + '</div>');
        $("#veld-" + i).css("left", (595 - (i-18) * 65) + "px")
        $("#veld-" + i).css("top", (10) + "px")
        if(i === 19){$("#veld-" + i).css("background-color", "#FF0")}
        if(doesContain(i)){$("#veld-" + i).css("background-color", "#0F0")}
}
for(i = 28; i < 36; i++){
        var naam = i;
        if(i === 31){naam = "Put"}
        $(".spel").append('<div class="veldje" id="veld-' + i + '">' + naam + '</div>');
        $("#veld-" + i).css("left", (10) + "px")
        $("#veld-" + i).css("top", (10 + (i-27) * 65) + "px")
        if(doesContain(i)){$("#veld-" + i).css("background-color", "#0F0")}
        if(i === 31){$("#veld-" + i).css("background-color", "#FF0")}
}
for(i = 36; i < 44; i++){
        var naam = i;
        if(i === 42){naam = "Struik"}
        $(".spel").append('<div class="veldje" id="veld-' + i + '">' + naam + '</div>');
        $("#veld-" + i).css("left", (10 + (i-35) * 65) + "px")
        $("#veld-" + i).css("top", (530) + "px")
        if(doesContain(i)){$("#veld-" + i).css("background-color", "#0F0")}
        if(i === 42){$("#veld-" + i).css("background-color", "#FF0")}
}
for(i = 44; i < 51; i++){
        $(".spel").append('<div class="veldje" id="veld-' + i + '">' + i + '</div>');
        $("#veld-" + i).css("left", (530) + "px")
        $("#veld-" + i).css("top", (530 - (i-43)*65) + "px")
        if(doesContain(i)){$("#veld-" + i).css("background-color", "#0F0")}
}
for(i = 51; i < 58; i++){
        var naam = i;
        if(i === 52){naam = "Jilla"}
        $(".spel").append('<div class="veldje" id="veld-' + i + '">' + naam + '</div>');
        $("#veld-" + i).css("left", (530 - (i-50)*65) + "px")
        $("#veld-" + i).css("top", (75) + "px")
        if(doesContain(i)){$("#veld-" + i).css("background-color", "#0F0")}
        if(i === 52){$("#veld-" + i).css("background-color", "#FF0")}
}
for(i = 58; i < 63; i++){
        var naam = i;
        if(i === 58){naam = "De Dood"}
        $(".spel").append('<div class="veldje" id="veld-' + i + '">' + naam + '</div>');
        $("#veld-" + i).css("left", (75) + "px")
        $("#veld-" + i).css("top", (75 + (i-57)*65) + "px")
        if(doesContain(i)){$("#veld-" + i).css("background-color", "#0F0")}
        if(i === 58){$("#veld-" + i).css("background-color", "#333")}
}
        $(".spel").append('<div class="veldje" id="veld-63">Finish</div>');
        $("#veld-63").css("left", (140) + "px")
        $("#veld-63").css("top", (140) + "px")
        $("#veld-63").css("width", (385) + "px")
        $("#veld-63").css("height", (385) + "px")
        $("#veld-63").css("background-color", "#F00")


        function doesContain(index){
        var gans = JSON.parse('[5,9,14,18,23,27,32,36,41,45,50,54,59]');

            for (k = 0; k < gans.length; k++){
                if(gans[k] === index)return true
            }
            return false;
        }




});

function start(speler){
        var jsonString = JSON.stringify({
                      action: "start",
                      message: ["niks"]
                 });
                 var posting = $.ajax("http://localhost:8080/ganzenbord", {
                      data: jsonString,
                      contentType : 'application/json',
                      type : 'POST',
                 });
                 posting.done(function(data){
                       $("#balkVoegToe").hide();
                       $("#balkNaam").hide();
                       $("#balkKleur").hide();
                       $("#speler").hide();
                       $("#kleur").hide();
                       $(".dice").show();

                      for(i = 0; i < data.message.length; i++){
                        var color = data.message[i];
                        if(i === 0){
                        $("#spelern-" + i).css("color", "yellow")
                        }
                        else
                        {
                        $("#spelern-" + i).css("color", "white")
                        }

                         $("#veld-0").append('<div class="pion" id="speler-' + i + '">')
                         $("#speler-" + i).css('background-color', color)
                      }

                 });
        }
function submit(name, kleur){

         var jsonString = JSON.stringify({
              action: "addPlayer",
              message: [name.value, kleur.value]
         });
         var posting = $.ajax("http://localhost:8080/ganzenbord", {
              data: jsonString,
              contentType : 'application/json',
              type : 'POST',
         });
         posting.done(function(data){
            var ID = data.message[0];
            var name = data.message[1];
              $(".spel").append('<div class="balkje" id="spelern-' + ID +'">' + name +'</div>');
              console.log("location: " + (190 + ID*30) + "px")
              $("speler-" + ID).css("top", (190 + ID*30) + "px")
              $("#veld-49").append('<div class="pion" id="speler-' + ID + '">')
              $("#speler-" + ID).css('background-color', '#00F')
         });
}

function gooi(speler){

 var jsonString = JSON.stringify({
              action: "gooi",
              message: ["niks"]
         });
         var posting = $.ajax("http://localhost:8080/ganzenbord", {
              data: jsonString,
              contentType : 'application/json',
              type : 'POST',
         });
         posting.done(function(data){
            var speler = data.message[0];
            var pos = data.message[1];
            var worp = data.message[2];
            var prevPos = data.message[3];
              $(".spel").append('<div class="balkje" id="spelern-' + ID +'">' + name +'</div>');
              console.log("location: " + (190 + ID*30) + "px")
              $("speler-" + ID).css("top", (190 + ID*30) + "px")
              $("#veld-49").append('<div class="pion" id="speler-' + ID + '">')
              $("#speler-" + ID).css('background-color', '#00F')
              iv = setInterval(loop2task, 500)
              function loop2task(){

              }
         });


}




