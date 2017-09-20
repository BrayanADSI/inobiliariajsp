<%-- 
    Document   : formularioAuditoria
    Created on : 15/08/2017, 03:02:17 PM
    Author     : melissa
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Auditoria</title>
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

<jsp:useBean id="unaAuditoria" class="modelo.Auditoria" scope="request"/>
<body>

<center><jsp:include page="jspf/menu.jspf"></jsp:include></center>
    <h1><center>Formulario De Auditoria</center></h1>
    <center><table border="1">
            <tr>
                <th>Fecha De La Auditoria</th>
                <th>Descripcion De La Auditoria</th>
                <th>Id Del Usuario De La Auditoria</th>
            </tr>

        <c:forEach items="${unaAuditoria.listar(0)}" var="laAuditoria">
            <tr>
            <form action="ControladorAuditoria" method="post">
                <td><input  type="hidden" name="fidauditoria"           value="${laAuditoria.idauditoria}">
                    <input  type="date"   name="ffechaauditoria"        value="${laAuditoria.fechaauditoria}"></td>
                <td><input  type="text" name="fdescripcionauditoria"  value="${laAuditoria.descripcionauditoria}"></td>
                <td><input  type="number" name="fidusuariosauditorias"  value="${laAuditoria.idusuariosauditorias}"></td>
            </form>
            </tr>
        </c:forEach>

        <tr>
        <form action="ControladorAuditoria" method="post">
            <td> <input type="number" hidden="1" name="fidauditoria"       value="0">
                <input  type="date"   name="ffechaauditoria"></td>
            <td><input  type="number" name="fdescripcionauditoria"></td>
            <td><input  type="number" name="fidusuariosauditorias"         value="0"></td>
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
