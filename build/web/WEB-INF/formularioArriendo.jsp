<%-- 
    Document   : formularioArriendo
    Created on : 14/08/2017, 09:22:49 AM
    Author     : melissa
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario De Arriendo</title>
    </head>
    <body>
       
    </body>
</html>
<style>
    *{
        margin: 0px;
        padding:0px;
    }

    #tabla{
        border: 2px;
        border-color: white;  
    }


    tr:nth-child(odd){ 
        background-color: lightseagreen;
        color:black;
    }
    tr:nth-child(even){
        background-color: white;
        color: black;
    } 


    th{
        color: black;
    }

    tr:nth-child(1){ 
        color: gray;
    } 

    tr:nth-child(1){ 
        background-color:lightseagreen;
    } 


    tr:nth-child(4){ 
        background-color:white;
    } 

    tr:nth-child(5){ 
        background-color:lightseagreen;
    } 

    tr:nth-child(6){ 
        background-color:white;
    }


</style>
</head>

<jsp:useBean id="unArriendo" class="modelo.Arriendo" scope="request"/>
<body>

<center><jsp:include page="jspf/menu.jspf"></jsp:include></center>
<h1><center>Formulario De Arriendo</center></h1>
<center><table border="1">
        <tr>

            <th>Fecha Del Arriendo</th>
            <th>Cedula Del Cliente</th>
            <th>Id Del Inmobiliario</th>
            <th>Id Del Tipo De Arriendo</th>
            <th>Opciones</th>
        </tr>
        
         <c:forEach items="${unArriendo.listar(0)}" var="elArriendo">
                <tr>
                <form action="ControladorArriendo" method="post">
                    <td><input  type="hidden" name="fid_Arriendo"                 value="${elArriendo.id_Arriendo}">
                        <input  type="date"   name="fFecha_Arriendo"              value="${elArriendo.fecha_Arriendo}"></td>
                    <td><input  type="number" name="fid_Cedula_Cliente_Arriendo"  value="${elArriendo.id_Cedula_Cliente_Arriendo}"></td>
                    <td><input  type="number" name="fid_inmobiliario_Arriendo"    value="${elArriendo.id_inmobiliario_Arriendo}"></td>
                    <td><input  type="number" name="fid_Tipo_Arriendo"            value="${elArriendo.id_Tipo_Arriendo}"></td>
                    <td><button type="submit" name="fAccion"                      value="Modificar">Modificar</button>
                        <button type="submit" name="fAccion"                      value="Eliminar">Eliminar</button></td>
                </form>
                </tr>
                 </c:forEach>
            <tr>
            <form action="ControladorArriendo" method="post">
                <td> <input     type="number" hidden="1" name="fid_Arriendo"       value="0">
                     <input     type="date"   name="fFecha_Arriendo"></td>
                    <td><input  type="number" name="fid_Cedula_Cliente_Arriendo"   value="0"></td>
                    <td><input  type="number" name="fid_inmobiliario_Arriendo"     value="0"></td>
                    <td><input  type="number" name="fid_Tipo_Arriendo"             value="0"></td>
                <td><button     type="submit" name="fAccion" value="Insertar"> Insertar</button>
                    <button     type="reset"  name="fAccion" value="Limpiar">Limpiar</button></td>        
            </form>  
            </tr>
        </table>
    </center>

    <c:forEach begin="1" end="5" var="1">
        <c:out value="${i}"/>
    </c:forEach>
        </center>
</body>
</html>



