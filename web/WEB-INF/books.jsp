<%@ page import="club.piclight.LibraryManLite.DAO.BookDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="club.piclight.LibraryManLite.Model.Book" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="./style/books.css">
</head>
<body>
<%@include file="header.jsp" %>
<div class="main-page">
    <div id="logo-l" onclick="window.location.href='./index'">
        Library Man
    </div>
    <form id="search-form" method="GET">
        <input id="search-input" type="text" name="book_name" placeholder="Search your book by name">
    </form>

    <!--Books-->
    <div class="books-panel">
        <%
            String queryBookName = request.getParameter("book_name");
            ArrayList<Book> books = BookDAO.getBooksByName(queryBookName);
            if (books == null) {
        %>
                <h1 style="margin-top: 20%">No such book</h1>
        <%
            } else {
                for (Book book : books) {
        %>
        <div class="book-info" onclick="window.open('./bookinfo?isbn=<%= book.getIsbn() %>')">
            <img class="book-cover" src="<%= book.getCoverImg() %>">
            <div class="book-misc">
                <div class="book-title"><%= book.getTitle() %></div>
                <div class="book-publisher"><%= book.getPublisher() %></div>
                <div class="book-author"><%= book.getAuthor() %></div>
                <div class="publish-date"><%= book.getPublishDate() %></div>
            </div>
            <div class="book-intro">
                <%= book.getIntro() %>
            </div>
        </div>
        <%
                }
            }
        %>
    </div>
</div>
</body>
</html>
