
$(document).ready(function () {

//init body
 var jsonString = JSON.stringify({
          action: "init",
          message: ["undefined"]

 });
 var initPost = $.ajax("http://localhost:8080/phones", {
          data: jsonString,
          contentType : 'application/json',
          type : 'POST',
 });
 initPost.done(function(data){
 if(data.action === "init"){
   init(data.message)
 }

 });


 $("body").on("keydown", function (key) {
      if(key.which == 13){
            var jsonString = JSON.stringify({
                         action: "search",
                         message: [$("#zoeken").val()]
            });
            var posting = $.ajax("http://localhost:8080/phones", {
                  data: jsonString,
                  contentType : 'application/json',
                  type : 'POST',

            });
            posting.done(function(data){
                init(data.message);
            });
      }
 });

     $("body").click(function(event){
        var number = event.target.id.substring(6)
        if(number !== "null"){
                       var jsonString = JSON.stringify({
                               action: "getPhone",
                               message: [number]

                       });
                       var posting = $.ajax("http://localhost:8080/phones", {
                              data: jsonString,
                             contentType : 'application/json',
                             type : 'POST',

                       });
                          posting.done(function(data){

                        if(data.action === "getPhone"){

                            $(".phones").html(data.message);
                            $(".phones").html("");
                            $(".phones").append('<div class="phone" id="phone-null">'+ data.message + '</div');
                            $(".phones").append('<div class="phone" id="phone-back">Back</div');
                          }
                          else if(data.action === "init"){
                              init(data.message)
                          }
                       });
        }


     });
});

function init(message){
    $(".phones").html("");
    $.each(message,function(i, phone){
        if(phone){
         $(".phones").append('<div class="phone" id="phone-' + (i + 1) + '">' + phone + '</div')
        }
    });

}



