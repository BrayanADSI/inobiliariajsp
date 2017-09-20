<%-- 
    Document   : formularioAbonos
    Created on : 10/08/2017, 07:22:26 AM
    Author     : melissa
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <center>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="tablas.css">
        <title>Formulario Abonos</title>

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

    <jsp:useBean id="unAbono" class="modelo.Abonos" scope="request"/>
    <body>

    <center><jsp:include page="jspf/menu.jspf"></jsp:include></center>
        <h1><center>Formulario De Abonos</center></h1>
        <center><table border="1">
                <tr>

                    <th>Valor Del Abono</th>
                    <th>Fecha Del Abono</th>
                    <th>Id De La Deuda Del Abono</th>
                    <th>Opciones</th>

                </tr>
            <c:forEach items="${unAbono.listar(0)}" var="elAbono">
                <tr>
                <form action="ControladorAbonos" method="post">
                    <td><input type="hidden" name="fidabonos"       value="${elAbono.idabonos}">
                        <input type="number" name="fvalorabono"     value="${elAbono.valorabono}"></td>
                    <td><input type="date"   name="ffechaabono"     value="${elAbono.fechaabono}"></td>
                    <td><input type="number" name="fiddeudasabonos" value="${elAbono.iddeudasabonos}"></td>
                    <td><button type="submit" name="fAccion" value="Modificar">Modificar</button>
                        <button type="submit" name="fAccion" value="Eliminar">Eliminar</button></td>
                </form>
                </tr>
            </c:forEach>
            <tr>
            <form action="ControladorAbonos" method="post">
                <td> <input type="number" hidden="1" name="fidabonos" value="0">
                    <input type="number"  name="fvalorabono"></td>
                <td><input type="date"   name="ffechaabono"></td>
                <td><input type="number" name="fiddeudasabonos" value="0"></td>
                <td><button type="submit" name="fAccion" value="Insertar"> Insertar</button>
                    <button type="reset" name="fAccion" value="Limpiar">Limpiar</button></td>        
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
