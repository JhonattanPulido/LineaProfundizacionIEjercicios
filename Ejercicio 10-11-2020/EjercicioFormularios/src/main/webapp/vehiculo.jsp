<%-- 
    Document   : vehiculo
    Created on : 10/11/2020, 8:53:09 a. m.
    Author     : jhona
--%>

<%@page import="com.mycompany.ejercicioformularios.models.Vehiculo"%>
<%
    Vehiculo vehiculo = (Vehiculo)request.getSession().getAttribute("vehiculo");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./assets/css/global.css" type="text/css" />        
        <link rel="stylesheet" href="./assets/font/font.css" type="text/css" />
    </head>
    <body>
        <div class="menu-cntr">
            <a class="link" href="index.xhtml">Estudiantes</a>
            <a class="link" href="vehiculo.xhtml">Vehículos</a>
            <a class="link" href="animales.xhtml">Animales</a>
        </div>
        <section class="todo-cntr">
            <div class="title-cntr">
                <span class="form-title">Vehículos</span>
                <span class="form-title">| Submit</span>                
            </div>
            <div class="info-cntr">
                <h2>Bienvenido <%= vehiculo.getNombrePropietario() %></h2>                   
                <span>Placa: <%= vehiculo.getPlaca()%></span>                
                <span>Marca: <%= vehiculo.getMarca()%></span>                
            </div>
        </section>        
    </body>
</html>
