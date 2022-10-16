
//// TODOS LOS BOTONES DE CLIENTE  ////


function traerInformacion(){
    $.ajax({
        url: "http://localhost:80/api/Client/all",
        type: "GET",
        dataType: "JSON",
        crossDomain: true,
        contentType: "application/json",
        complete:function(respuesta){
            if(respuesta.status == 200){
                alert("Se ha consultado la base de clientes correctamente");
                console.log(respuesta.responseJSON.items);
                pintarRespuesta(respuesta.responseJSON.items);
            }else{
                alert("No se ha podido consultar la base de datos");
            }
           
            }

    })
}
    
function pintarRespuesta(items) {
    $("#resultado").empty();
    let myTable = "<table>";
    myTable += "<tr><th>Codigo</th><th>Nombre</th><th>Correo</th><th>Password</th><th>Edad</th></tr>";
   
    for (i = 0; i < items.length; i++){
        
        myTable+="<tr>";
        myTable+="<td>"+items[i].id+"</td>";
        myTable+="<td>"+items[i].name+"</td>";
        myTable+="<td>"+items[i].email+"</td>";
        myTable+="<td>"+items[i].password+"</td>";
        myTable+="<td>"+items[i].age+"</td>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    console.log(myTable);
    $("#resultado").append(myTable);
}


function guardarInformacion(){
    
    let myData = {
        id: $("#idcliente").val(),
        name: $("#namecliente").val(),
        email: $("#emailcliente").val(),
        password: $("#passwordcliente").val(),
        age: $("#agecliente").val(),
    };

    let dataToSend = JSON.stringify(myData);


    $.ajax({
        url: "http://localhost:80/api/Client/save",
        type: "POST",
        dataType: "JSON",
        crossDomain: true,
        data: dataToSend,
        contentType: "application/json",
        complete:function(respuesta){
            if(respuesta.status == 201){
                alert("Se ha registrado con exito");
                traerInformacion();

            }else{
                alert("Registro existente o faltan campos");
            }
           
            }

    })

}


function editarInformacion(){

    
    let myData = {
        id: $("#idcliente").val(),
        name: $("#namecliente").val(),
        email: $("#emailcliente").val(),
        age: $("#agecliente").val(),
    };

    let dataToSend = JSON.stringify(myData);


    $.ajax({
        url: "https://g3f2ee52b080f71-skate.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/client/client",
        type: "PUT",
        dataType: "JSON",
        crossDomain: true,
        data: dataToSend,
        contentType: "application/json",
        complete:function(respuesta){
            if(respuesta.status == 201){
                console.log(respuesta.status);
                alert("Registro actualizado con exito");
                traerInformacion();
            }else{
                alert("No se pudo actualizar: Error en Id Cliente o Id Cliente no existe");
            }
           
            }

    })

}


function eliminarInformacion(){

 
    let myData = {
        id: $("#idcliente").val(),
    };

    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: "https://g3f2ee52b080f71-skate.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/client/client",
        type: "DELETE",
        dataType: "JSON",
        crossDomain: true,
        data: dataToSend,
        contentType: "application/json",
        complete:function(respuesta){
            if(respuesta.status == 204){
                alert("Registro eliminado con exito");
                traerInformacion();
            }else{
                alert("No se pudo eliminar: ID Cliente No Existe");
            }
           
            }

    })


}
         


//// BOTONES MESSAGE ////


function traerInformacionmessage(){
    $.ajax({
        url: "https://g3f2ee52b080f71-skate.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/message/message",
        type: "GET",
        dataType: "JSON",
        crossDomain: true,
        contentType: "application/json",
        complete:function(respuesta){
            console.log(respuesta.responseJSON.items);
            if(respuesta.status == 200){
                alert("Se han consultado los mensajes correctamente");
                pintarRespuestamessage(respuesta.responseJSON.items);
            }else{
                alert("No se ha podido consultar mensajes");
            }
           
            }

    })
}
    
function pintarRespuestamessage(items) {
    $("#resultadoM").empty();
    let myTablemessage = "<table>";
    myTablemessage += "<tr><th>Id Mensaje</th><th>Texto Mensaje</th></tr>";
   
    for (i = 0; i < items.length; i++){
        
        myTablemessage+="<tr>";
        myTablemessage+="<td>"+items[i].id+"</td>";
        myTablemessage+="<td>"+items[i].messagetext+"</td>";
        myTablemessage+="</tr>";
    }
    myTablemessage+="</table>";
    console.log(myTablemessage);
    $("#resultadoM").append(myTablemessage);
}



function guardarInformacionmessage(){
    
    let myData = {
        id: $("#idmessage").val(),
        messagetext: $("#namemessage").val(),      
    };

    let dataToSend = JSON.stringify(myData);


    $.ajax({
        url: "https://g3f2ee52b080f71-skate.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/message/message",
        type: "POST",
        dataType: "JSON",
        crossDomain: true,
        data: dataToSend,
        contentType: "application/json",
        complete:function(respuesta){
            if(respuesta.status == 201){
                alert("Se ha registrado mensaje con exito");
                traerInformacionmessage();
            }else{
                alert("Registro existente o faltan campos");
            }
           
            }

    })

}


function editarInformacionmessage(){

    
    let myDatamessage = {
        id: $("#idmessage").val(),
        messagetext: $("#namemessage").val(),      
    };

    console.log(myDatamessage)

    let dataToSend = JSON.stringify(myDatamessage);



    $.ajax({
        url: "https://g3f2ee52b080f71-skate.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/message/message",
        type: "PUT",
        dataType: "JSON",
        crossDomain: true,
        data: dataToSend,
        contentType: "application/json",
        complete:function(respuesta){
            if(respuesta.status == 201){
                
                alert("Mensaje actualizado con exito");
                traerInformacionmessage();
            }else{
                alert("No se pudo actualizar: Error en Mensaje o Mensaje no existe");
            }
           
            }

    })

}


function eliminarInformacionmessage(){

 
    let myDatamessagee = {
        id: $("#idmessage").val(),
    };

    let dataToSend = JSON.stringify(myDatamessagee);

    $.ajax({
        url: "https://g3f2ee52b080f71-skate.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/message/message",
        type: "DELETE",
        dataType: "JSON",
        crossDomain: true,
        data: dataToSend,
        contentType: "application/json",
        complete:function(respuesta){
            if(respuesta.status == 204){
                alert("Mensaje eliminado con exito");
                traerInformacionmessage();
            }else{
                alert("No se pudo eliminar: ID Mensaje No Existe");
            }
           
            }

    })


}
      

//// BOTONES SKATE ////


function traerInformacionskate(){
    $.ajax({
        url: "http://localhost:80/api/Skate/all",
        type: "GET",
        dataType: "JSON",
        crossDomain: true,
        contentType: "application/json",
        complete:function(respuesta){
            if(respuesta.status == 200){
                console.log(respuesta.responseJSON.items);
                alert("Se han consultado las patinetas correctamente");
                //pintarRespuestaskate(respuesta.responseJSON.items);
            }else{
                alert("No se ha podido consultar las patinetas");
            }
           
            }

    })
}*/
    
/*function pintarRespuestaskate(items) {
    $("#resultadoP").empty();
    let myTableskate = "<table>";
    myTableskate += "<tr><th>Id patineta</th><th>Marca</th><th>Modelo</th><th>Categoria</th><th>Nombre</th></tr>";
   
    for (i = 0; i < items.length; i++){
        
        myTableskate+="<tr>";
        myTableskate+="<td>"+items[i].id+"</td>";
        myTableskate+="<td>"+items[i].brand+"</td>";
        myTableskate+="<td>"+items[i].model+"</td>";
        myTableskate+="<td>"+items[i].category_id+"</td>";
        myTableskate+="<td>"+items[i].name+"</td>";
        myTableskate+="</tr>";
    }
    myTableskate+="</table>";
   
    $("#resultadoP").append(myTableskate);
}*/


function guardarInformacionskate(){
    
    let myDataskate = {
        
        brand: $("#brandskate1").val(),
        year: $("#yearskate1").val(),
        name: $("#nameskate1").val(),
        description: $("#descriptionskate1").val(),
    };

    let dataToSend = JSON.stringify(myDataskate);


    $.ajax({
        url: "http://localhost:80/api/Skate/save",
        type: "POST",
        dataType: "JSON",
        crossDomain: true,
        data: dataToSend,
        contentType: "application/json",
        complete:function(respuesta){
            if(respuesta.status == 201){
                alert("Se ha seleccionado patineta con exito, diligencia tu información personal");
                //traerInformacionskate();
            }else{
                alert("No se ha seleccionado correctamente una patineta");
            }
           
            }

    })

}


/*function editarInformacionskate(){

    
    let myDataskate = {
        id: $("#idskate").val(),
        brand: $("#brandskate").val(),
        model: $("#modelskate").val(),
        category_id: $("#categoryskate").val(),
        name: $("#nameskate").val(),
    };

    let dataToSend = JSON.stringify(myDataskate);



    $.ajax({
        url: "https://g3f2ee52b080f71-skate.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/skate/skate",
        type: "PUT",
        dataType: "JSON",
        crossDomain: true,
        data: dataToSend,
        contentType: "application/json",
        complete:function(respuesta){
            if(respuesta.status == 201){
                console.log(respuesta.status);
                alert("Patineta actualizada con exito");
                traerInformacionskate();
            }else{
                alert("No se pudo actualizar patineta: Error en Id o Id no existe");
            }
           
            }

    })

}


function eliminarInformacionskate(){

 
    let myDataskate = {
        id: $("#idskate").val(),
    };

    let dataToSend = JSON.stringify(myDataskate);

    $.ajax({
        url: "https://g3f2ee52b080f71-skate.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/skate/skate",
        type: "DELETE",
        dataType: "JSON",
        crossDomain: true,
        data: dataToSend,
        contentType: "application/json",
        complete:function(respuesta){
            if(respuesta.status == 204){
                alert("Patineta eliminada con exito");
                traerInformacionskate();
            }else{
                alert("No se pudo eliminar patineta: ID No Existe");
            }
           
            }

    })


}
      