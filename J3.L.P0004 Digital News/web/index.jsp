<%-- 
    
    Copyright(C) 2021,  FPT University.
    J3.L.P0004 Digital News
    Document   : index
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
        <title>Home</title>       
    </head>
    <body>
        <div class="container">
            
            <jsp:include page="header.jsp" />
            
            <div class="content">

                <div class="left">
                    <!--MOST RECENT ARTICLE-->
                    <div class="title">${currentArticle.title}</div>
                    <div class="image">
                      <img src="images/${currentArticle.imagePath}" />
                    </div>
                    <div class="text">${currentArticle.content}</div>
                    <div class="signature">
                      <div class="icon icon1"></div>
                      <div class="icon icon2"></div>
                      By ${currentArticle.author} | <fmt:formatDate pattern = "MMM dd yyyy hh:mm a" value = "${currentArticle.date}" />
                    </div> 
                    <!--MOST RECENT ARTICLE-->
                </div>
              
              <jsp:include page="right.jsp" />
            </div>
            
            <jsp:include page="footer.jsp" />
        </div>
    </body>
</html>
