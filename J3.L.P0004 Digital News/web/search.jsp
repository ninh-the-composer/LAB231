<%-- 
    Document   : search
    Created on : Feb 22, 2021, 10:14:02 PM
    Author     : MADE-IN-HEAVEN
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <link rel="stylesheet" type="text/css" href="css/search-page.css" />
        <title>Search</title>
    </head>
    <body>
        <div>
            <div class="font-sans text-blue">
                <%@include file="/components/header.jsp" %>
                <!--Content-->
                <div class="wrap-content">
                    <div class="flex container">
                        <div class="left pa-5">
                            <c:if test="${empty searchResult}">
                                <p class="not-found">Not found</p>
                            </c:if>
                            <c:forEach var="article" items="${searchResult}">
                                <div>
                                    <p class="text-4 text-blue mt-0 font-bold">
                                        <a class="text-blue" href="article?id=${article.id}">${article.title}</a>
                                    </p>
                                    <img alt="title" src="image/${article.imagePath}" class="image-article"/>
                                    <p>${article.summary}</p>
                                    <p class="text-gray mt-5 items-end text-right clock">
                                        By ${article.author} | <fmt:formatDate pattern = "MMM dd yyyy hh:mm a" value = "${article.date}" />
                                    </p>
                                </div>
                            </c:forEach>
                            <div class="flex text-center pagging-bar">
                                <c:forEach var="page" begin="1" end="${maxPage}">

                                    <a href="search?keyword=${param.keyword}&page=${page}" class="mx-2 pagging-item ${param.page == page || (page == 1 && empty param.page)? "current-page":""}" >${page}</a>

                                </c:forEach>
                            </div>
                        </div>
                        <%@include file="/components/right.jsp" %>
                    </div>
                </div>
                <!--Footer-->
                <footer class="footer">
                </footer>
            </div>
        </div>
    </body>
</html>
