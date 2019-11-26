<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="./style/index.css">
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <div class="main-page">
            <div id="logo-l">
                Library Man
            </div>
            <form id="search-form" method="GET">
                <input id="search-input" type="text" name="book_name" placeholder="Search your book by name">
            </form>
        </div>
    </body>
</html>
