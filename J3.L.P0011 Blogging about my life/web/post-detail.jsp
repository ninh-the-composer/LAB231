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
        <title>${post.title}</title>
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
                <div class="blog-title">My Blog</div>
                    <div class="row">
                        <img src="images/${post.type}.png" alt="type">
                        <div class="post" >
                            <div class="post-title">
                                <a href="#" >${post.title}</a>
                                <div class="post-date">${post.createdAt}</div>
                            </div>
                            <div class="post-content" >
                                <c:choose>
                                    <c:when test="${post.type eq "photo"}">
                                        <a href="" style="width: 100%"><img src="images/${post.imagePath}" alt="post image"></a>
                                    </c:when>
                                    <c:when test="${post.type eq "quote"}">
                                        <a href="" style="display: none"><img src="images/${post.imagePath}" alt="post image"></a>

                                        <div class="quote">
                                            <q class="quote-content">
                                                <c:set var="quote" value="${post.content}" scope="request"/>
                                                <%
                                                    String quote = (String) request.getAttribute("quote");
                                                    String[] quotePart = quote.split("-");
                                                    String author = quotePart[1];
                                                    String[] phase = quotePart[0].split(",");
                                                    for (int i = 0; i < phase.length; i++) {
                                                        if (i == phase.length - 1) {
                                                %>
                                                <%=phase[i]%>
                                                <%
                                                } else {
                                                %>
                                                <%=phase[i] + ","%><br>
                                                <%
                                                        }
                                                    }
                                                %>
                                            </q>
                                            <p class="quote-author"><%="-" + author%></p>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <a href=""><img src="images/${post.imagePath}" alt="post image"></a>
                                        <c:set var="quote" value="${post.content}" scope="request"/>
                                        <%
                                            String quote = (String) request.getAttribute("quote");
                                            quote = quote.replaceAll("\n", "<br/>");
                                            System.out.println(quote);
                                        %>
                                        <p><%=quote %></p>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
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
            <div>
                <a class="overview" href="overview">Overview</a>
            </div>
        </div>
        <jsp:include page="common/footer.jsp"/>
    </body>
</html>
