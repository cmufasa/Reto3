
//*************************** A M B I E N T E  D E S A R R O L L O  o  L O C A L **********************************************/

let uriClient="http://localhost:8080/api/Client";
let uriCabin="http://localhost:8080/api/Custome";
let uriCategory="http://localhost:8080/api/Category";
let uriMessage="http://localhost:8080/api/Message";
let uriReservation="http://localhost:8080/api/Reservation";
let uriScore="http://localhost:8080/api/Score";




//******************************* P R O D U C C I O N  E N  M A Q  L I N U X **********************************************/

/* Debe Reemplazar la IP de su maquina Linux */

/*let uriClient="http://Su_IP:8080/api/Client";
let uriCabin="http://Su_IP:8080/api/Custome";
let uriCategory="http://Su_IP:8080/api/Category";
let uriMessage="http://Su_IP:8080/api/Message";
let uriReservation="http://Su_IP:8080/api/Reservation";
let uriScore="http://Su_IP:8080/api/Score";
let uriReport="http://Su_IP:8080/api/Reservation";*/



/* IMPORTANTE: Este front-end contiene tablas para gestionar Cabinros, debe adaptar los campos para su RETO (Custome o Cabin) */
/* Las tablas que contiene este Reto es: Cliente, Cabinros, Categorys, Message, Reservation, Score, Reservation   */


//*************************************************************************************** */
//*******************  D E S P L I E G U E ***** C L I E N T E ****************************/
//*************************************************************************************** */

/* Consultar todos los clientes - GET */

function consultAllClient(){
        $.ajax({
            url:uriClient+"/all",
            type:"GET",
            datatype:"JSON",
            success:function(respuesta){
                $("#resultadoConsulta").empty();
                mostrarTabla(respuesta)
            }
        });
}

/* Cabingar todos los clientes - GET */

function loadClient(){
        $.ajax({
                url:uriClient+"/all",
                type:"GET",
                datatype:"JSON",
                success:function(data){
                        if (data == null) {//Validación de datos nulos
                                alert('Disculpe, No hay clientes para mostrar');
                                return
                            } else {
                                    for(i=0;i<data.length;i++){
                                            $("#selectClient").append("<option type='number' value=" + data[i].idClient + ">" 
                                             + data[i].name + "</option>");
                                        } 
                           }
                }

        });
}

/* Guardar Cliente - POST */

function saveClient() {
        let myData = {
          name: $("#name").val(),
          email: $("#email").val(),
          password: $("#password").val(),
          age: $("#age").val()
        };
        $.ajax({
                url:uriClient+"/save",
                type:"POST",
                data:JSON.stringify(myData),
                datatype:"JSON",
                contentType:"application/JSON; charset=utf-8",
                encode:true,
                success:function(respuesta){
                        clearCampos();
                        consultAllClient();
                        alert("El nuevo CLiente, se ha guardado con exito!")
                }
        });
}

/* Eliminar Cliente - DELETE */

function clearItem(idItem){
        let item={
                id:idItem
        };
        let dataToSend = JSON.stringify(item);
        $.ajax({
                url:uriClient,
                type:"DELETE",
                data:dataToSend,
                contentType:"application/JSON",
                dataType:"JSON",
                success:function(respuesta){
                        clearCampos();
                        $("#resultadoConsulta").empty();
                        consultAll();
                        alert("El registro se ha eliminado con Exito!")
                }
        });
}



/* Consultar por ID Cliente - GET + ID */

function itemByID(idItem){
        $.ajax({
                url:uriClient+"/"+idItem,
                type:"GET",
                dataType:"JSON",
                success:function(respuesta){
                        $("#id").val(respuesta.items[0].id).prop("hidden", true);
                        $("#name").val(respuesta.items[0].name);
                        $("#email").val(respuesta.items[0].email);
                        $("#age").val(respuesta.items[0].age);                        
                }
        });
}

/* Actualizar Cliente - PUT */

function updateInfo(){
        let myData = {
                id: $("#id").val(),
                name: $("#name").val(),
                email: $("#email").val(),
                age: $("#age").val(),
              };
        $.ajax({
                url:uriClient,
                type:"PUT",
                data:JSON.stringify(myData),
                datatype:"JSON",
                contentType:"application/JSON; charset=utf-8",
                encode:true,
                success:function(respuesta){
                        $("#resultadoConsulta").empty();
                        clearCampos();
                        consultAll();
                        $("#id").prop("hidden", false);
                        alert("El registro, se actualizó con exito!")
                }
        });
}

/* Funcion para dibujar o Crear tablar */
 
function mostrarTabla(items){
        let tableClient="<table style='width:90%'>";
        tableClient+="<tr>";
        tableClient+="<th>NAME</th>";
        tableClient+="<th>EMAIL</th>";
        tableClient+="<th>AGE</th>";
        tableClient+="<th colspan='2'>ACTIONS</th>";
        tableClient+="</tr>";
        for(i=0;i<items.length;i++){
                tableClient+="<tr>";
                tableClient+="<td>"+items[i].name+"</td>";
                tableClient+="<td>"+items[i].email+"</td>";
                tableClient+="<td>"+items[i].age+"</td>";
                tableClient+="<td> <button onclick='clearItem("+items[i].id+")'>Borrar</button>";
                tableClient+="<td> <button onclick='itemByID("+items[i].id+")'>Editar</button>";
                tableClient+="</tr>";
        }
        tableClient+="</table>";
        $("#resultadoConsulta").append(tableClient);
}



/* Funcion para borrar o limpiar campos */

function clearCampos() {
        $("#name").val("");
        $("#email").val("");
        $("#age").val("");
        $("#password").val("");
}




//*************************************************************************************** */
//*******************  D E S P L I E G U E ***** C A B A Ñ A S ******************************/
//*************************************************************************************** */

function consultAllCabin(){
        $.ajax({
            url:uriCabin+"/all",
            type:"GET",
            datatype:"JSON",
            success:function(respuesta){
                console.log(respuesta);
                $("#resultadoConsulta").empty();
                mostrarTablaCabinros(respuesta)
            }
        });
}
function loadCabin(){
        $.ajax({
                url:uriCabin+"/all",
                type:"GET",
                datatype:"JSON",
                success:function(data){
                        if (data == null) {//Validación de datos nulos
                                alert('Disculpe, No hay cabañas para mostrar');
                                return
                            } else {
                                    for(i=0;i<data.length;i++){
                                            $("#selectCabin").append("<option type='number' value=" + data[i].idCabin + ">" 
                                             + data[i].name + "</option>");
                                        } 
                           }
                }

        });
}
function saveCabin() {
        let Category={idCategory:$("#selectCategory").val()}
        let myData = {
          name: $("#name").val(),
          brand: $("#brand").val(),
          rooms: $("#rooms").val(),
          description: $("#description").val(),
          Category: Category
        };
        //console.log(myData);
        $.ajax({
                url:uriCabin+"/save",
                type:"POST",
                data:JSON.stringify(myData),
                datatype:"JSON",
                contentType:"application/JSON; charset=utf-8",
                encode:true,
                success:function(respuesta){
                        clearCamposCabin();
                        consultAllCabin();
                        alert("El nuevo Cabinro, se ha guardado con exito!")
                }
        });
}
function clearItemCabin(idItem){
        /*let item={
                id:idItem
        };
        let dataToSend = JSON.stringify(item);*/
        $.ajax({
                url:uriCabin+"/"+idItem,
                type:"DELETE",
                //data:dataToSend,
                contentType:"application/JSON",
                dataType:"JSON",
                success:function(respuesta){
                        clearCamposCabin();
                        $("#resultadoConsulta").empty();
                        consultAllCabin();
                        alert("El registro se ha eliminado con Exito!")
                }
        });
}
function itemByIDCabin(idItem){
        $.ajax({
                url:uriCabin+"/"+idItem,
                type:"GET",
                dataType:"JSON",
                success:function(respuesta){
                        $("#name").val(respuesta.items[0].name);
                        $("#brand").val(respuesta.items[0].brand);
                        $("#rooms").val(respuesta.items[0].rooms);
                        $("#Category").val(respuesta.items[0].Category.name);                        
                }
        });
}
function updateInfoCabin(){
        let Category={idCategory:$("#selectCategory").val()}
        let myData = {
                id: $("#name").val(),
                brand: $("#brand").val(),
                rooms: $("#rooms").val(),
                description: $("#description").val(),
                Category: Category,
              };
        $.ajax({
                url:uriCabin,
                type:"PUT",
                data:JSON.stringify(myData),
                datatype:"JSON",
                contentType:"application/JSON; charset=utf-8",
                encode:true,
                success:function(respuesta){
                        $("#resultadoConsulta").empty();
                        clearCamposCabin();
                        consultAllCabin();
                        $("#id").prop("hidden", false);
                        alert("El registro, se actualizó con exito!")
                }
        });
}
function mostrarTablaCabinros(items){
        let tableCabin="<table style='width:90%'>";
        tableCabin+="<tr>";
        tableCabin+="<th>NAME</th>";
        tableCabin+="<th>BRAND</th>";
        tableCabin+="<th>ROOMS</th>";
        tableCabin+="<th>DESCRIPTION</th>";
        tableCabin+="<th>Category</th>";
        tableCabin+="<th colspan='2'>ACTIONS</th>";
        tableCabin+="</tr>";
        for(i=0;i<items.length;i++){
                tableCabin+="<tr>";
                tableCabin+="<td>"+items[i].name+"</td>";
                tableCabin+="<td>"+items[i].brand+"</td>";
                tableCabin+="<td>"+items[i].rooms+"</td>";
                tableCabin+="<td>"+items[i].description+"</td>";
                tableCabin+="<td>"+items[i].Category.name+"</td>";
                tableCabin+="<td> <button onclick='clearItemCabin("+items[i].idCabin+")'>Borrar</button>";
                tableCabin+="<td> <button onclick='itemByIDCabin("+items[i].idCabin+")'>Editar</button>";
                tableCabin+="</tr>";
        }
        tableCabin+="</table>";
        $("#resultadoConsulta").append(tableCabin);
}
function clearCamposCabin() {
        $("#name").val("");
        $("#brand").val("");
        $("#rooms").val("");
        $("#description").val("");
        $("#selectCategory").val(0);
}
//*************************************************************************************** */
//*******************  D E S P L I E G U E ***** G A M A S  ******************************/
//****************************************************************************************/
function consultAllCategory(){
        $.ajax({
            url:uriCategory+"/all",
            type:"GET",
            datatype:"JSON",
            success:function(respuesta){
                console.log(respuesta);
                $("#resultadoConsulta").empty();
                mostrarTablaCategory(respuesta);
            }
        });
}  
function CategoryLoad(){
        $.ajax({
                url:uriCategory+"/all",
                type:"GET",
                datatype:"JSON",
                success:function(data){
                        if (data == null) {//Validación de datos nulos
                                alert('Disculpe, No hay Categorys para mostrar');
                                return
                            } else {
                                    for(i=0;i<data.length;i++){
                                            $("#selectCategory").append("<option type='number' value=" + data[i].idCategory + ">" 
                                             + data[i].name + "</option>");
                                        } 
                           }
                }

        });
}
function saveCategory() {
        let myData = {
          name: $("#name").val(),
          description: $("#description").val(),
        };
        $.ajax({
                url:uriCategory+"/save",
                type:"POST",
                data:JSON.stringify(myData),
                datatype:"JSON",
                contentType:"application/JSON; charset=utf-8",
                encode:true,
                success:function(respuesta){
                        clearCamposCategory();
                        consultAllCategory();
                        alert("El nuevo Mensaje, se ha guardado con exito!")
                }
        });
}
function clearItemCategory(idItem){
        /*let item={
                id:idItem
        };
        let dataToSend = JSON.stringify(item);*/
        $.ajax({
                url:uriCategory+"/"+idItem,
                type:"DELETE",
                //data:dataToSend,
                contentType:"application/JSON",
                dataType:"JSON",
                success:function(respuesta){
                        clearCamposMessage();
                        $("#resultadoConsulta").empty();
                        consultAllCategory();
                        alert("El registro se ha eliminado con Exito!")
                }
        });
}
let idGma;
function itemByIdCategory(idItem){
        $.ajax({
                url:uriCategory+"/"+idItem,
                type:"GET",
                dataType:"JSON",
                success:function(respuesta){
                        console.log(respuesta)
                        idGma = respuesta.idCategory;
                        $("#name").val(respuesta.name);
                        $("#description").val(respuesta.description);                   
                }
        });
}
function updateCategory(){
        let myData = {
                idCategory: idGma,
                name: $("#name").val(),
                description: $("#description").val(),
              };
        console.log(myData)
        $.ajax({
                url:uriCategory+"/update",
                type:"PUT",
                data:JSON.stringify(myData),
                datatype:"JSON",
                contentType:"application/JSON; charset=utf-8",
                success:function(respuesta){
                        $("#resultadoConsulta").empty();
                        clearCamposCategory();
                        consultAllCategory();
                        alert("El registro, se actualizó con exito!")
                }
        });
}
function mostrarTablaCategory(items){
        let tableCategory="<table style='width:90%'>";
        tableCategory+="<tr>";
        tableCategory+="<th>NOMBRE</th>";
        tableCategory+="<th>DESCRIPTION</th>";
        tableCategory+="<th>CabinROS</th>";
        tableCategory+="<th colspan='2'>ACTIONS</th>";
        tableCategory+="</tr>";
        for(i=0;i<items.length;i++){
                tableCategory+="<tr>";
                //console.log(items[i].Category.length)
                if(items[i].Cabins.length>0){
                        tableCategory+="<td rowspan="+items[i].Cabins.length+">"+items[i].name+"</td>";
                        tableCategory+="<td rowspan="+items[i].Cabins.length+">"+items[i].description+"</td>";
                }else{
                        tableCategory+="<td>"+items[i].name+"</td>";
                        tableCategory+="<td>"+items[i].description+"</td>";
                }
                //                console.log(items[i].Category.length)
                if(items[i].Cabins.length>0){
                        for(j=0;j<items[i].Cabins.length;j++){
                                tableCategory+="<td>"+items[i].Cabins[j].name+"--"+items[i].Cabins[j].brand+"--"+items[i].Cabins[j].rooms+"--"+items[i].Cabins[j].description;
                                tableCategory+="<td> <button onclick='clearItemCategory("+items[i].idCategory+")'>Borrar</button>";
                                tableCategory+="<td> <button onclick='itemByIDCategory("+items[i].idCategory+")'disabled='true'>Editar</button></td>";
                                tableCategory+="</tr>";
                        }
                }else{
                        for(j=0;j<1;j++){
                                let data=" ";
                                tableCategory+="<td>"+data;
                                tableCategory+="<td> <button onclick='clearItemCategory("+items[i].idCategory+")'>Borrar</button>";
                                tableCategory+="<td> <button onclick='itemByIdCategory("+items[i].idCategory+")'disabled='true'>Editar</button></td>";
                                tableCategory+="</tr>";
                        }

                }
                
                  
        }
        tableCategory+="</table>";
        $("#resultadoConsulta").append(tableCategory);
}
function clearCamposCategory() {
        $("#name").val("");
        $("#description").val("");
}
//*****************************************************************************************/
//*******************  D E S P L I E G U E ***** M E N S A J E  ***************************/
//****************************************************************************************/
function consultAllMessage(){
        $.ajax({
            url:uriMessage+"/all",
            type:"GET",
            datatype:"JSON",
            success:function(respuesta){
                console.log(respuesta);
                $("#resultadoConsulta").empty();
                mostrarTablaMessage(respuesta);
            }
        });
}
function saveMessage() {
        let client={idClient:$("#selectClient").val()}
        let Cabin={idCabin:$("#selectCabin").val()}
        let myData = {
          messageText: $("#messageText").val(),
          client: client,
          Cabin: Cabin
        };
        //console.log(myData)
        $.ajax({
                url:uriMessage+"/save",
                type:"POST",
                data:JSON.stringify(myData),
                datatype:"JSON",
                contentType:"application/JSON; charset=utf-8",
                encode:true,
                success:function(respuesta){
                        clearCamposMessage();
                        consultAllMessage();
                        alert("El nuevo Mensaje, se ha guardado con exito!")
                }
        });
}
let idMsg;
function itemByIDMessage(idItem){
        $.ajax({
                url:uriMessage+"/"+idItem,
                type:"GET",
                dataType:"JSON",
                success:function(respuesta){
                        //console.log(respuesta)
                        idMsg = respuesta.idMessage;
                        $("#messageText").val(respuesta.messageText);
                        $("#selectCabin").val(respuesta.client.idClient).prop("disabled", true);
                        $("#selectClient").val(respuesta.Cabin.idCabin).prop("disabled", true);                   
                }
        });
}
function clearItemMessage(idItem){
        $.ajax({
                url:uriMessage+"/"+idItem,
                type:"DELETE",
                //data:dataToSend,
                contentType:"application/JSON",
                dataType:"JSON",
                success:function(respuesta){
                        clearCamposMessage();
                        $("#resultadoConsulta").empty();
                        consultAllMessage();
                        alert("El registro se ha eliminado con Exito!")
                }
        });
}
function updateInfoMsg(){
        let client={idClient:$("#selectClient").val()}
        let Cabin={idCabin:$("#selectCabin").val()}
        let myData = {
          idMessage : idMsg,
          messageText: $("#messageText").val(),
          client: client,
          Cabin: Cabin
        };
        //console.log(myData)
        $.ajax({
                url:uriMessage+"/update",
                type:"PUT",
                data:JSON.stringify(myData),
                datatype:"JSON",
                contentType:"application/JSON; charset=utf-8",
                success:function(respuesta){
                        $("#resultadoConsulta").empty();
                        clearCamposMessage();
                        consultAllMessage();
                        $("#selectClient").prop("disabled", false);
                        $("#selectCabin").prop("disabled", false);
                        alert("El registro, se actualizó con exito!")
                }
        });
}
function mostrarTablaMessage(items){
        let tableMessage="<table style='width:90%'>";
        tableMessage+="<tr>";
        tableMessage+="<th>MESSAGE</th>";
        tableMessage+="<th>Cabin</th>";
        tableMessage+="<th>Category</th>";
        tableMessage+="<th>CLIENT</th>";
        tableMessage+="<th colspan='2'>ACTIONS</th>";
        tableMessage+="</tr>";
        for(i=0;i<items.length;i++){
                tableMessage+="<tr>";
                tableMessage+="<td>"+items[i].messageText+"</td>";
                tableMessage+="<td>"+items[i].Cabin.name+"</td>";
                tableMessage+="<td>"+items[i].Cabin.Category.name+"</td>";
                tableMessage+="<td>"+items[i].client.name+"</td>";
                tableMessage+="<td> <button onclick='clearItemMessage("+items[i].idMessage+")'>Borrar</button>";
                tableMessage+="<td> <button onclick='itemByIDMessage("+items[i].idMessage+")'>Editar</button></td>";  
        }
        tableMessage+="</table>";
        $("#resultadoConsulta").append(tableMessage);
}
function clearCamposMessage() {
        $("#messageText").val("");
        $("#selectClient").val(0);
        $("#selectCabin").val(0);
}  
//*****************************************************************************************/
//*****************  D E S P L I E G U E ***** R E S E R V A T I O N **********************/
//****************************************************************************************/
function consultAllReservation(){
        $.ajax({
            url:uriReservation+"/all",
            type:"GET",
            datatype:"JSON",
            success:function(respuesta){
                console.log(respuesta);
                $("#resultadoConsulta").empty();
                mostrarTablaReservation(respuesta);
            }
        });
}
function loadReservation(){
        $.ajax({
                url:uriReservation+"/all",
                type:"GET",
                datatype:"JSON",
                success:function(data){
                        if (data == null) {//Validación de datos nulos
                                alert('Disculpe, No hay reservas para mostrar');
                                return
                            } else {
                                    console.log(data)
                                    for(i=0;i<data.length;i++){
                                            $("#selectIdRes").append("<option type='number' value=" + data[i].idReservation + ">" 
                                             + data[i].idReservation + "</option>");
                                        } 
                           }
                }

        });
}
function saveReservation() {
        let client={idClient:$("#selectClient").val()}
        let Cabin={idCabin:$("#selectCabin").val()}
        let myData = {
          startDate: $("#startDate").val(),
          devolutionDate: $("#devolutionDate").val(),
          status: $("#selectStatus").val(),
          client: client,
          Cabin: Cabin
        };
        console.log(myData)
        $.ajax({
                url:uriReservation+"/save",
                type:"POST",
                data:JSON.stringify(myData),
                datatype:"JSON",
                contentType:"application/JSON; charset=utf-8",
                encode:true,
                success:function(respuesta){
                        clearCamposReservation();
                        consultAllReservation();
                        alert("La nueva Reservación, se ha guardado con exito!")
                }
        });
}
let idRes;
let start, devolution;
function itemByIDReservation(idItem){
        $.ajax({
                url:uriReservation+"/"+idItem,
                type:"GET",
                dataType:"JSON",
                success:function(respuesta){
                        //console.log(respuesta)
                        idRes = respuesta.idReservation;
                        start = respuesta.startDate.split("T",1);
                        devolution = respuesta.devolutionDate.split("T",1);
                        $("#startDate").val(start.toString('yyyy-MM-dd'));
                        $("#devolutionDate").val(devolution.toString('yyyy-MM-dd'));
                        $("#selectStatus").val(respuesta.status).prop("disabled", false);
                        $("#selectClient").val(respuesta.client.idClient).prop("disabled", true);
                        $("#selectCabin").val(respuesta.Cabin.idCabin).prop("disabled", true);                   
                }
        });
}
function clearItemReservation(idItem){
        $.ajax({
                url:uriReservation+"/"+idItem,
                type:"DELETE",
                //data:dataToSend,
                contentType:"application/JSON",
                dataType:"JSON",
                success:function(respuesta){
                        clearCamposReservation();
                        $("#resultadoConsulta").empty();
                        consultAllReservation();
                        alert("El registro se ha eliminado con Exito!")
                }
        });
}
function updateInfoRes(){
        if(!dateIsOK()){ 
                alert("La fecha de entrega debe ser mayor que la fecha de inicio") 
                return false;
        }
        let client={idClient:$("#selectClient").val()}
        let Cabin={idCabin:$("#selectCabin").val()}
        let myData = {
          idReservation: idRes,
          startDate: $("#startDate").val(),
          devolutionDate : $("#devolutionDate").val(),
          status: $("#selectStatus").val(),
          client: client,
          Cabin: Cabin
        };
        console.log(myData)
        $.ajax({
                url:uriReservation+"/update",
                type:"PUT",
                data:JSON.stringify(myData),
                datatype:"JSON",
                contentType:"application/JSON; charset=utf-8",
                success:function(respuesta){
                        $("#resultadoConsulta").empty();
                        clearCamposReservation();
                        consultAllReservation();
                        $("#selectClient").prop("disabled", false);
                        $("#selectCabin").prop("disabled", false);
                        alert("El registro, se actualizó con exito!")
                }
        });
}
function dateIsOK(){
        start= $("#startDate").val();
        devolution = $("#devolutionDate").val();
        if (start>devolution){
                return false;
        }return true;
}
function mostrarTablaReservation(items){
        let tableReservation="<table style='width:90%'>";
        tableReservation+="<tr>";
        tableReservation+="<th>ID</th>";
        tableReservation+="<th>STARTDATE</th>";
        tableReservation+="<th>DEVOLUTIONDATE</th>";
        tableReservation+="<th>STATUS</th>";
        tableReservation+="<th>Cabin_NAME</th>";
        tableReservation+="<th>BRAND</th>";
        tableReservation+="<th>rooms</th>";
        tableReservation+="<th>ID_CLIENT</th>";
        tableReservation+="<th>NAME_CLIENT</th>";
        tableReservation+="<th>EMAIL</th>";
        tableReservation+="<th>SCORE</th>";
        tableReservation+="<th colspan='2'>ACTIONS</th>";
        tableReservation+="</tr>";
        for(i=0;i<items.length;i++){
                tableReservation+="<tr>";
                tableReservation+="<td>"+items[i].idReservation+"</td>";
                tableReservation+="<td>"+items[i].startDate+"</td>";
                tableReservation+="<td>"+items[i].devolutionDate+"</td>";
                tableReservation+="<td>"+items[i].status+"</td>";
                tableReservation+="<td>"+items[i].Cabin.name+"</td>";
                tableReservation+="<td>"+items[i].Cabin.brand+"</td>";
                tableReservation+="<td>"+items[i].Cabin.rooms+"</td>";
                tableReservation+="<td>"+items[i].client.idClient+"</td>";
                tableReservation+="<td>"+items[i].client.name+"</td>";
                tableReservation+="<td>"+items[i].client.email+"</td>";
                tableReservation+="<td>"+items[i].score+"</td>";
                tableReservation+="<td> <button onclick='clearItemReservation("+items[i].idReservation+")'>Borrar</button>";
                tableReservation+="<td> <button onclick='itemByIDReservation("+items[i].idReservation+")'>Editar</button></td>";  
        }
        tableReservation+="</table>";
        $("#resultadoConsulta").append(tableReservation);
}
function clearCamposReservation() {
        $("#startDate").val("");
        $("#devolutionDate").val("")
        $("#selectClient").val(0);
        $("#selectCabin").val(0);
}
//*****************************************************************************************/
//*****************  D E S P L I E G U E ***** S C O R E **********************************/
//****************************************************************************************/
function consultAllScore(){
        $.ajax({
            url:uriScore+"/all",
            type:"GET",
            datatype:"JSON",
            success:function(respuesta){
                console.log(respuesta);
                $("#resultadoConsulta").empty();
                mostrarTablaScore(respuesta);
            }
        });
}
function saveScore() {
        let resv = $("#selectIdRes").val();
        console.log(typeof resv)
        reservation = {idReservation: parseInt(resv)};
        let myData = {
          score: parseInt($("#score").val()),
          message: $("#message").val(),
          reservation : reservation
        };
        console.log(myData)
        $.ajax({
                url:uriScore+"/save",
                type:"POST",
                data:JSON.stringify(myData),
                datatype:"JSON",
                contentType:"application/JSON; charset=utf-8",
                //encode:true,
                success:function(respuesta){
                        clearCamposScore();
                        consultAllScore();
                        alert("El nuevo Mensaje, se ha guardado con exito!")
                }
        });
}
function mostrarTablaScore(items){
        let tableScore="<table style='width:90%'>";
        tableScore+="<tr>";
        tableScore+="<th>SCORE</th>";
        tableScore+="<th>MESSAGE</th>";
        tableScore+="<th>RESERVATION</th>";
        tableScore+="<th>CLIENT</th>";
        tableScore+="<th>Cabin</th>";
        tableScore+="<th colspan='2'>ACTIONS</th>";
        tableScore+="</tr>";
        for(i=0;i<items.length;i++){
                tableScore+="<tr>";
                tableScore+="<td>"+items[i].score+"</td>";
                tableScore+="<td>"+items[i].message+"</td>";
                tableScore+="<td>"+items[i].reservation.startDate+" <b>//</b> "+items[i].reservation.devolutionDate+"</td>";
                tableScore+="<td>"+items[i].reservation.client.name+"</td>";
                tableScore+="<td>"+items[i].reservation.Cabin.name+"</td>";
                tableScore+="<td> <button onclick='clearItemMessage("+items[i].idScore+")'>Borrar</button>";
                tableScore+="<td> <button onclick='itemByIDMessage("+items[i].idScore+")'>Editar</button></td>";  
        }
        tableScore+="</table>";
        $("#resultadoConsulta").append(tableScore);
}
function clearCamposScore() {
        $("#selectIdRes").val(0);
        $("#score").val(6);
        $("#message").val("")
        
}

//*****************************************************************************************/
//*****************  D E S P L I E G U E ***** R E P O R T S *****************************/
//****************************************************************************************/

function traerReporteStatus(){
        $.ajax({
                url:uriReport+"/report-status",
            type:"GET",
            datatype:"JSON",
            success:function(respuesta){
                console.log(respuesta);
                pintarRespuesta(respuesta);
            }
        });
    }
    function pintarRespuesta(respuesta){
    
        let myTable="<table>";
         myTable+="<tr>";
            myTable+="<th>completadas</th>";
            myTable+="<td>"+respuesta.completed+"</td>";
            myTable+="<th>canceladas</th>";
            myTable+="<td>"+respuesta.cancelled+"</td>";
         myTable+="</tr>";
        myTable+="</table>";
        $("#resultadoStatus").html(myTable);
    }
    function traerReporteDate(){
    
        var fechaInicio = document.getElementById("RstarDate").value;
        var fechaCierre = document.getElementById("RdevolutionDate").value;
        console.log(fechaInicio);
        console.log(fechaCierre);
        
            $.ajax({
                url:uriReport+"/report-dates/"+fechaInicio+"/"+fechaCierre,
                type:"GET",
                datatype:"JSON",
                success:function(respuesta){
                    console.log(respuesta);
                    pintarRespuestaDate(respuesta);
                }
            });
        }
        function pintarRespuestaDate(respuesta){
    
           let myTable="<table>";
            myTable+="<tr>";
              
            for(i=0;i<respuesta.length;i++){
            myTable+="<th>total</th>";
                myTable+="<td>"+respuesta[i].devolutionDate+"</td>";
                myTable+="<td>"+respuesta[i].startDate+"</td>";
                myTable+="<td>"+respuesta[i].status+"</td>";
              
              
                myTable+="</tr>";
            }
            myTable+="</table>";
            $("#resultadoDate").html(myTable);
        }
    
        function traerReporteClientes(){
            $.ajax({
                url:uriReport+"/report-clients",
                type:"GET",
                datatype:"JSON",
                success:function(respuesta){
                    console.log(respuesta);
                    pintarRespuestaClientes(respuesta);
                }
            });
        }
        function pintarRespuestaClientes(respuesta){
    
            let myTable="<table>";
            myTable+="<tr>";
              
            for(i=0;i<respuesta.length;i++){
            myTable+="<th>total</th>";
                myTable+="<td>"+respuesta[i].total+"</td>";
                myTable+="<td>"+respuesta[i].client.name+"</td>";
                myTable+="<td>"+respuesta[i].client.email+"</td>";
                myTable+="<td>"+respuesta[i].client.age+"</td>";
              
                myTable+="</tr>";
            }
            myTable+="</table>";
            $("#resultadoClientes").html(myTable);
        }