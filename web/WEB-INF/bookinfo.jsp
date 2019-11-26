<%@ page import="club.piclight.LibraryManLite.Model.Book" %>
<%@ page import="club.piclight.LibraryManLite.DAO.BookDAO" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="club.piclight.LibraryManLite.DAO.LMSessionFactory" %>
<%@ page import="club.piclight.LibraryManLite.Model.RealBook" %>
<%@ page import="java.util.List" %>
<%@ page import="club.piclight.LibraryManLite.DAO.RealBookDAO" %><%--
  Created by IntelliJ IDEA.
  User: Adam
  Date: 11/20/2019
  Time: 1:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="./style/books.css">
</head>
<body>
<jsp:include page="header.jsp" />
<div class="main-page">
    <div id="logo-l" onclick="window.location.href='./index'">
        Library Man
    </div>
    <%
        String queryISBN = request.getParameter("isbn");
        Book book = BookDAO.getBookByISBN(queryISBN);
        if (book == null) {
    %>
        <h1 style="margin-top: 20%">No such book</h1>
    <%
        } else {
    %>
    <div class="book-info">
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
            List<RealBook> realBooks = RealBookDAO.getRealBooksByISBN(queryISBN);
    %>
    <div>
        <table>
    <%
            for (RealBook realBook : realBooks) {
    %>
            <tr>
                <td>BookSN:</td>
                <td><%= realBook.getBookSN() %></td>
            </tr>
    <%
            }
    %>
        </table>
    </div>
    <%
        }
    %>
</div>
</body>
</html>
