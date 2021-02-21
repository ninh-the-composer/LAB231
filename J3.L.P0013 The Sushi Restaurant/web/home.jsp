<%-- 
    Document   : home
    Created on : Feb 18, 2021, 10:33:58 PM
    Author     : sogor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>The Sushi Restaurant</title>
    </head>
    <body>
        <header>
            <h1>Blogging About My Life</h1>
            <p>Welcome to my blog</p>
            <nav>
                <ul class="navbar__items">
                    <li class="navbar__item">
                        <a class="navbar__link ${currentMenu == 'blog' ? 'navbar__link--active' : ''}" href="${ctx}/home">My Blog</a>
                    </li>
                    <li class="navbar__item">
                        <a class="navbar__link ${currentMenu == 'about' ? 'navbar__link--active' : ''}" href="${ctx}/about">About Me</a>
                    </li>
                </ul>
            </nav>
        </header>
    </body>
</html>
