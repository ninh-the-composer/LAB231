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
        <title>About Me</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/home.css">
        <style>
            .thanks{
                margin-top: 2.5rem;
            }
            .signature{
                font-size: 36px;
                font-family: cursive;
                margin: 0;
            }
        </style>
    </head>
    <body>
        <header>
            <h1>Blogging About My Life</h1>
            <h2>Welcome to my blog</h2>
            <ul class="nav">
                <li><a href="home">My Blog</a></li>
                <li><a href="#" class="active">About Me</a></li>
            </ul>
        </header>
        <div class="page-content">
            <div class="container">
                <div class="blog-title">About Me</div>
                <div class="row">
                    <c:set var="quote" value="${postscript.content}" scope="request"/>
                    <%
                        String quote = (String) request.getAttribute("quote");
                        quote = quote.replaceAll("\n", "<br/>");
                        System.out.println(quote);
                    %>
                    <%=quote%>
                </div>
                <div class="thanks">
                    <p>Kind regards</p><br>
                    <p class="signature">${postscript.author}</p>
                </div>
            </div>
            <div class="side-banner">
                <div class="side-container">
                    <div class="banner-title">Share this page</div>
                    <ul>
                        <c:forEach var="social" items="${socialList}" >
                            <li><a href="#"> <img src="images/${social.icon}" alt=""> <span>Share on ${social.name}</span></a></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
        <jsp:include page="common/footer.jsp"/>
    </body>
</html>
