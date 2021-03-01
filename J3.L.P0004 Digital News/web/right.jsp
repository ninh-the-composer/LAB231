<%-- 
    
    Copyright(C) 2021,  FPT University.
    J3.L.P0004 Digital News
    Document   : right
    Record of change:
    DATE              Version             AUTHOR                 DESCRIPTION
    2021-02-25        1.0              NinhTBMHE141325           Initial commit
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/right.css" />
    </head>
    <body>
        <div class="right">
          <div class="right_container">
            <div class="new_title">Digital News</div>

            <div class="new_content">${mostRecentArticle.summary}</div>
          </div>

          <div class="right_container">
            <div class="new_title">Search</div>

            <form action="search" method="GET">
                <input id="search" type="text" class="search" name="keyword" value="${param.keyword}" required />
                <input type="submit" class="go" value="GO" onclick="validSearch()" />
                <script>
                    function validSearch(){
                        var str = document.getElementById('search').value + "";
                        if(str.trim() === ''){
                            document.getElementById('search').value = "";
                        }
                    }
                </script>
            </form>
          </div>

          <div class="right_container">
            <div class="new_title"><span>Last Articles</span><br /></div>

            <div class="top5">
                <c:forEach var="article" items="${top5Articles}">
                    <a href="article?id=${article.id}" class="top5-article-link">${article.title}</a>
                </c:forEach>       
            </div>
          </div>
        </div>
        
    </body>
</html>
