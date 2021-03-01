<%-- 
    
    Copyright(C) 2021,  FPT University.
    J3.L.P0004 Digital News
    Document   : search
    Record of change:
    DATE              Version             AUTHOR                 DESCRIPTION
    2021-02-25        1.0              NinhTBMHE141325           Initial commit
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <title>Search</title>       
    </head>
    <body>

        <div class="container">

            <jsp:include page="header.jsp" />

            <div class="content">

                <div class="left"> 
                    <!-- SEARCH RESULTS-->
                    <c:if test="${empty searchResult}">
                        <p class="not-found">Not found</p>
                    </c:if>
                    <c:forEach var="article" items="${searchResult}">
                        <div class="search-item">
                            <div class="image image_search">
                                <a class="title" href="article?id=${article.id}">${article.title}</a> 
                                <img src="images/${article.imagePath}" />                            
                            </div>
                            <div class="text text_search">${article.summary}</div>
                            <br>
                        </div>
                    </c:forEach>
                    <!-- SEARCH RESULTS-->


                    <!--PAGING-->
                    <ul class="paging">
                        <c:forEach var="page" begin="1" end="${maxPage}" >
                            <li class="${param.page == page || (page == 1 && empty param.page) ? "active" : ""}">
                                <a href="search?keyword=${param.keyword}&page=${page}">${page}</a>
                            </li>
                        </c:forEach>
                    </ul>    
                    <!--PAGING-->

                </div>

                <jsp:include page="right.jsp" />
            </div>

            <jsp:include page="footer.jsp" />
        </div>

    </body>
</html>
