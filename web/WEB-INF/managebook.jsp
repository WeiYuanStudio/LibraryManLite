<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="./style/managebook.css">
</head>
<body>
<jsp:include page="header.jsp" />
<div class="main-page">
    <div id="logo-l" onclick="window.location.href='./index'">
        Library Man
    </div>
    <form method="POST" class="form-panel">
        <span>图书入库</span>
        <table>
            <tr>
                <td>BookSN</td>
                <td><input type="text" name="book_sn"/></td>
            </tr>
            <tr>
                <td>ISBN</td>
                <td><input type="text" name="isbn"/></td>
            </tr>
        </table>
        <input type="submit" name="action" value="storage">
    </form>
    <form method="POST" class="form-panel">
        <span>图书出借</span>
        <table>
            <tr>
                <td>BookSN</td>
                <td><input type="text" name="book_sn"/></td>
            </tr>
            <tr>
                <td>UID</td>
                <td><input type="text" name="uid"/></td>
            </tr>
        </table>
        <input type="submit" name="action" value="borrow">
    </form>
    <form method="POST" class="form-panel">
        <span>还书</span>
        <table>
            <tr>
                <td>BookSN</td>
                <td><input type="text" name="book_sn"/></td>
            </tr>
        </table>
        <input type="submit" name="action" value="return">
    </form>
</div>
</body>
</html>
