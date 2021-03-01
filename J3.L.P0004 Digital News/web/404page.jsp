<%-- 
    
    Copyright(C) 2021,  FPT University.
    J3.L.P0004 Digital News
    Document   : 404page
    Record of change:
    DATE              Version             AUTHOR                 DESCRIPTION
    2021-02-25        1.0              NinhTBMHE141325           Initial commit
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
