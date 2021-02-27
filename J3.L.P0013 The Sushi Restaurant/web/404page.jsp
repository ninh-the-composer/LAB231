<%-- 
    Document   : menu
    Created on : Feb 18, 2021, 10:33:58 PM
    Author     : sogor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page Not Found - The Sushi Restaurant</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <header>
            <div class="title-wrapper">
                <h1>The Sushi Restaurant</h1>
                <p>Welcome to this website</p>
            </div>
            <div class="nav">
                <ul class="navbar-items">
                    <li>
                        <a class="navbar-link" href="home">Home</a>
                    </li>
                    <li>
                        <a class="navbar-link" href="menu">Menu and Price list</a>
                    </li>
                    <li>
                        <a class="navbar-link" href="find-us">Find us</a>
                    </li>

                </ul>
            </div>
        </header>
        <div class="container">
            <div class="page-content">
                <h2 class="post-heading error">Page Not Found</h2>
                <p>Click <a href="home"> here</a> to back to Homepage</p>
            </div>
            <div class="side-banner">
                <div class="side-container">
                    <div class="banner-title">Share this page</div>
                    <ul>
                        <c:forEach var="social" items="${socialList}" >
                            <li><a href="#"> <img src="image/${social.icon}" alt=""> <span>Share on ${social.name}</span></a></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
        <jsp:include page="common/footer.jsp"/>

    </body>
</html>
