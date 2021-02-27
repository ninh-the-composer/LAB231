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
                        <a class="navbar-link" href="menu">Menu and Price list</a>
                    </li>
                    <li>
                        <a class="navbar-link active" href="#">Find us</a>
                    </li>

                </ul>
            </div>
        </header>
        <div class="container">
            <div class="page-content">
                <h2 class="post-heading">Find us</h2>

                <div class="row item">
                    <div class="post-container">
                        <div class="align-left" >
                            <h2>Address and contact:</h2>
                            <p class="address-detail">The Sushi Restaurant<br>New York, NY, USA</p>
                            <p class="address-detail">Tel &#9;: <span>1234</span></p>
                            <p class="address-detail">Email &#9;: <span>ngu@gmail.com</span></p>
                        </div>
                        <div class="align-left">
                            <h2>Opening hours:</h2>
                            <p class="address-detail">Monday Closed<br/>
                                Tuesday 12 - 22<br/>
                                Wednesday 12 - 22<br/>
                                Thursday 12 - 22<br/>
                                Friday 11 - 23<br/>
                                Saturday 11 - 23<br/>
                                Sunday 11 - 22<br/>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="row item">
                    <img src="image/gmap.png"  style="width: 100%">
                </div>
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
