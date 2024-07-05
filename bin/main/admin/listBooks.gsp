<!-- grails-app/views/admin/listBooks.gsp -->

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book List</title>
    <style>
    /* CSS styles for table */
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }
    th, td {
        padding: 10px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    th {
        background-color: #f2f2f2;
        color: #333;
    }
    td {
        background-color: #fff;
        color: #333;
    }
    .book-name {
        font-weight: bold;
    }
    </style>
</head>
<body>
<h2>Book List</h2>
<table>
    <thead>
    <tr>
        <th>Book Name</th>
        <th>Author</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${books}" var="book">
        <tr>
            <td class="book-name">${book.bookName}</td>
            <td>${book.bookAuthor}</td>
        </tr>
    </g:each>
    </tbody>
</table>
</body>
</html>
