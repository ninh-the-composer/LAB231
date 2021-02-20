<%-- 
    Document   : home
    Created on : Dec 28, 2020, 10:01:13 PM
    Author     : Ninh
--%>

<%@page import="model.Post"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <c:set var="ctx" value="${pageContext.servletContext.contextPath}" />
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page Error</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/home.css">
    </head>

    <body>
        <header>
            <h1>Blogging About My Life</h1>
            <h2>Welcome to my blog</h2>
            <ul class="nav">
                <li><a href="home" class="active">My Blog</a></li>
                <li><a href="about-me">About Me</a></li>
            </ul>
        </header>
        <div class="page-content">
            <div class="container">
                <div class="error-message">Error... We will fix as soon as we can.</div>
                <div class="navigate-message">Click <a href="home">here</a> to return our homepage.</div>
            </div>
        </div>
        <footer>
            <hr>
            <div class="">Created by Ninhdepzai</div>
        </footer>
    </body>
</html>
