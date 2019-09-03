$(function () {
    alert("Hola");

    $("#button").click(function (){
        $.ajax({
            url: 'http://localhost:3800/add',
            type: 'POST',
            data: 200,
            contentType: 'application/json',
            dataType: 'application/json',
            success: function(response){
                console.log("Se consumio el servicio con exito");
                console.log(response)
            },
            error: function(response){
                console.log("Hubo un error al consumir el servicio");
                console.log(response);
            }
        });
    });
});

