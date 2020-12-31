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
        <title>Overview</title>
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
                <div class="blog-title">Overview - My Blog</div>
                <div class="overview-container">
                    <div class="overview-item">
                       NOVEMBER 2015 <!-- This is a fixed overview date, I will upgrade this later, HAPPY NEW YEAR!!!-->
                        <div class="overview-item-date">
                            date
                        </div>
                    </div>
                    <c:forEach var="post" items="${postList}">
                        <div class="overview-item">
                            <a href="post?id=${post.id}">${post.title}</a>
                            <div class="overview-item-date">
                                ${post.createdAt}
                            </div>
                        </div>
                    </c:forEach>
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
        <footer>
            <hr>
            <div class="">Created by Ninhdepzai</div>
        </footer>
    </body>
</html>
