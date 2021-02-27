<%-- 
    Document   : footer
    Created on : Feb 20, 2021, 1:39:21 PM
    Author     : sogor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<footer>
    <hr>
    <div class="">
        <div class="footer-page-counter" style="display: block;">
            <c:forEach var="item" items="${sessionScope.count}" >
                <span class="footer-page-counter-item">${item}</span>
            </c:forEach>
        </div>
    </div>
</footer>
