

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
                 var jsonString = JSON.stringify({});
                 var posting = $.ajax("http://localhost:8080/ganzenbord/startGame", {
                      data: jsonString,
                      contentType : 'application/json',
                      type : 'POST',
                 });
                 posting.done(function(data){
                    if(data.action !== "start"){
                        $("#notify").html(data);
                    }
                    else{
                       $("#balkVoegToe").hide();
                       $("#balkNaam").hide();
                       $("#balkKleur").hide();
                       $("#speler").hide();
                       $("#kleur").hide();
                       $(".submit").hide();
                       $(".start").hide();
                       $(".dice").css("visibility","visible");


                        var color = "#FFF";
                        if(i === 0){
                        $("#spelern-0").css("color", "yellow")
                        }


                         $("#veld-0").append('<div class="pion" id="speler-' + i + '">')
                         $("#speler-0").css('background-color', "#00F")

                    }

                 });
        }
function submit(name, kleur){

         var jsonString = JSON.stringify({
              player: name.value,
              color: kleur.value
         });
         var posting = $.ajax("http://localhost:8080/ganzenbord/addPlayer", {
              data: jsonString,
              contentType : 'application/json',
              type : 'POST',
         });
         posting.done(function(data){
            var ID = data.ID;
            var name = data.name;
            console.log("ID: " + ID + " , name: " + name)
              $(".spel").append('<div class="balkje" id="spelern-' + ID +'">' + name +'</div>');
              console.log("location: " + (190 + ID*30) + "px")
              $("#veld-0").append('<div class="pion" id="speler-' + ID + '">')
              $("#speler-" + ID).css("top", (190 + ID*30) + "px")
              $("#speler-" + ID).css('background-color', '#00F')
              document.getElementById("speler").value = ""
              document.getElementById("kleur").value = ""
         });
}

function gooi(speler){

 var jsonString = JSON.stringify({});
         var posting = $.ajax("http://localhost:8080/ganzenbord/gooien", {
              data: jsonString,
              contentType : 'application/json',
              type : 'POST',
         });
         posting.done(function(data){
            var ID = data.turn;
            var speler = data.name;
            var pos = data.newPos;
            var worp1 = data.thr1;
            var worp2 = data.thr2;
            var prevPos = data.oldPos;
            var nextID = data.nextPlayer;
            var not0 = data.not0;
            var color = data.color;

               console.log(ID + " " + speler + " " + pos + " " + worp1 + " " + worp2 + " " + prevPos + " " + nextID + " " + not0 + " " + color);


              $("#veld-" + pos).append('<div class="pion" id="speler-' + pos + '">')
              $("#speler-" + pos).css('background-color', color)
              if(prevPos == 0 && not0 === "true"){
                $("#veld-0").html("0");
              }
              else if(prevPos == 0){
                 $("#veld-0").append('<div class="pion" id="speler-' + 1000 + '">')
                 $("#speler-" + 1000).css("top", (190 + ID*30) + "px")
                 $("#speler-" + 1000).css('background-color', not0)
              }
              else{
                   $("#veld-" + prevPos).html(prevPos + "");
              }

              $("#notify").html("speler " + speler + " gooide " + worp1 + " en " + worp2 + "!")
               if(trap(prevPos, pos) !== -1){
                    var jsonString = JSON.stringify({
                             pos: trap(prevPos, pos)
                    });
                    var posting = $.ajax("http://localhost:8080/ganzenbord/check", {
                             data: jsonString,
                             contentType : 'application/json',
                             type : 'POST',
                    });

               }

         });


}

function trap(prevPos, pos){
    if(prevPos < 52 && pos > 52){
        return 52
    }
    else if(prevPos < 31 && pos > 31){
        return 31
    }
    return -1;
}




