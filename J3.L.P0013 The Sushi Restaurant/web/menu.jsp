<%-- 
    Document   : menu
    Created on : Feb 18, 2021, 10:33:58 PM
    Author     : sogor
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>The Sushi Restaurant</title>
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
                        <a class="navbar-link active" href="menu">Menu and Price list</a>
                    </li>
                    <li>
                        <a class="navbar-link" href="find-us">Find us</a>
                    </li>
                </ul>
            </div>
        </header>
        <div class="container">
            <div class="page-content">
            <h2 class="post-heading">Menu and Price list</h2>
            <c:forEach var="menu" items="${menuList}">
            <div class="row item">
                <div class="menu-title post-container">
                    <span class="align-left small-padding">Menu 1</span>
                    <span class="align-right small-padding">Price</span>
                </div>
                <div class="post-container">
                    <span class="align-left small-padding">${menu.name}</span>
                    <span class="align-right small-padding">€${menu.price}</span> 
                </div>
                <p class="menu-content">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
            </div>
            </c:forEach>
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
