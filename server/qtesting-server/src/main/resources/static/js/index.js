$(function () {

    // https://codeseven.github.io/toastr/

    $("#register-boton").click(function () {
        var name = document.getElementById("name-txt").value;
        console.log(name);
        if(name !== ""){
            registerUser(name);
        }else{
            alert("Dege ingresar un nombre");
        }
    });

    $("#login-boton").click(function () {
        var name = document.getElementById("name-txt").value;
        if(name !== ""){
            login(name);
        }else{
            alert("Dege ingresar un nombre");
        }
    });

    $("#income-button").click(function () {
        var amount = document.getElementById("amount-txt").value;
        if(amount !== ""){
            registerIncome(localStorage.getItem("name"), amount);
        }else{
            alert("Dege ingresar un monto");
        }
    });

    $("#withdrawal-button").click(function () {
        var amount = document.getElementById("amount-txt").value;
        if(amount !== ""){
            registerWithdrawal(localStorage.getItem("name"), amount);
        }else{
            alert("Dege ingresar un monto");
        }
    });

    /*-------------------------------------------------------------------------*/

    function registerUser(name){
        $.ajax({
            url: 'http://localhost:4860/register-client',
            type: 'POST',
            contentType : 'application/json; charset=utf-8',
            dataType: 'json',
            data: JSON.stringify({
                name: name
            }),
            success: function(response){
                console.log("Se consumio el servicio con exito");
                console.log(response);
                localStorage.setItem("name", name);
                $("#registration-block").css("display", "none");
                $("#transaction-block").css("display", "block");
            },
            error: function(response){
                console.log("Hubo un error al consumir el servicio");
                console.log(response);
            }
        });
    }

    function login(name){
        $.ajax({
            url: 'http://localhost:4860/login-client',
            type: 'POST',
            contentType : 'application/json; charset=utf-8',
            dataType: 'json',
            data: JSON.stringify({
                name: name
            }),
            success: function(response){
                console.log("Se consumio el servicio con exito");
                console.log(response);
                localStorage.setItem("name", name);
                $("#registration-block").css("display", "none");
                $("#transaction-block").css("display", "block");
            },
            error: function(response){
                console.log("Hubo un error al consumir el servicio");
                console.log(response);
            }
        });
    }

    function registerIncome(name, amount){
        $.ajax({
            url: 'http://localhost:4860/register-income',
            type: 'POST',
            contentType : 'application/json; charset=utf-8',
            dataType: 'json',
            data: JSON.stringify({
                clientName: name,
                transactionAmount: amount
            }),
            success: function(response){
                console.log("Se consumio el servicio con exito");
                console.log(response);
                $("#balance-detail").css("display", "block");
                updateView(response.client);
            },
            error: function(response){
                console.log("Hubo un error al consumir el servicio");
                console.log(response);
            }
        });
    }

    function registerWithdrawal(name, amount){
        $.ajax({
            url: 'http://localhost:4860/register-withdrawal',
            type: 'POST',
            contentType : 'application/json; charset=utf-8',
            dataType: 'json',
            data: JSON.stringify({
                clientName: name,
                transactionAmount: amount
            }),
            success: function(response){
                console.log("Se consumio el servicio con exito");
                console.log(response);
                $("#balance-detail").css("display", "block");
                updateView(response.client);
            },
            error: function(response){
                console.log("Hubo un error al consumir el servicio");
                console.log(response);
            }
        });
    }

    function updateView(client){
        $("#balance-amount").text(client.balance);
        $(".item").remove();
        client.balanceDetail.forEach(showTransaction);
    }

    function showTransaction(item, index){
        var current_datetime = new Date(item.transactionDate);
        var formatted_date = current_datetime.getFullYear() + "-" + (current_datetime.getMonth() + 1) + "-" + current_datetime.getDate() + " " + current_datetime.getHours() + ":" + current_datetime.getMinutes() + ":" + current_datetime.getSeconds()

        var newItem =   "<tr class='item'>" +
                            "<td>" + item.transactionType + "</td>" +
                            "<td>" + formatted_date + "</td>" +
                            //"<td>" + item.transactionDate + "</td>" +
                            "<td>" + item.amount + "</td>" +
                        "</tr>";
        $("#balance-table").append(newItem);
    }

});

