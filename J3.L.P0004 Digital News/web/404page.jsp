<%-- 
    Document   : error
    Created on : Feb 19, 2021, 5:55:58 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <title>Error</title>
      
    </head>
    <body>
        <div class="container">
            
            <jsp:include page="header.jsp" />
            
            <div class="content">

                <div class="left">
                    
                    <h1>Page Not Found</h1>
                    
                </div>
              
              <jsp:include page="right.jsp" />
            </div>
            
            <jsp:include page="footer.jsp" />
        </div>
    </body>
</html>
