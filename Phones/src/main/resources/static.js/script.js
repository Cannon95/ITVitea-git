

window.addEventListener("message", function(event){
    ev = JSON.parse(event);

    $(".mark").html(event);


});



