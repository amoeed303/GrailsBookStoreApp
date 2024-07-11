<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book List</title>
    <style>
    /* Container styles */
    body {
        font-family: Arial, sans-serif;
        padding: 10px;
    }

    .cards-container {
        display: flex;
        flex-wrap: wrap;
        gap: 20px; /* Space between cards */
        padding: 20px;
        margin: 10px;
    }

    /* Card styles */
    .card {
        border: 1px solid #ddd;
        border-radius: 8px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        padding: 20px;
        width: calc(33.333% - 60px); /* Three cards per row, accounting for gap */
        background-color: #fff;
        margin-bottom: 10px;
    }

    .book-name {
        font-weight: bold;
        font-size: 18px;
        margin-bottom: 10px;
    }

    .book-author {
        color: #666;
    }

    .buy-button {
        background-color: #4CAF50;
        border: none;
        color: white;
        padding: 10px 20px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        margin: 4px 2px;
        cursor: pointer;
        border-radius: 8px;
    }

    .logout-button {
        background-color: #f44336;
        border: none;
        color: white;
        padding: 10px 20px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        margin: 25px 10px;
        cursor: pointer;
        border-radius: 8px;
        position: absolute;
        top:0;
        right:0;
    }
    .purchase-button{
        background-color: #117a8b;
        border: none;
        color: white;
        padding: 10px 20px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        margin: 25px 10px;
        cursor: pointer;
        border-radius: 8px;
        position: absolute;
        top:0;
        right:96px;
    }
    </style>
    <script>
        document.addEventListener("DOMContentLoaded", function() {
            var message = "${flash.message}";
            var type = "${flash.type}";
            if (message) {
                alert(message);
            }
        });
    </script>
</head>

<body>
<h2>Available Books</h2>
<div>
    <a  class="purchase-button" href="${createLink(controller: 'login', action: 'logout')}">Purchased Books</a>
</div>
<div>
    <a  class="logout-button" href="${createLink(controller: 'login', action: 'logout')}">Logout</a>
</div>
<div class="cards-container">
    <g:each in="${books}" var="book">
        <div class="card">
            <div class="book-name">${book.bookName}</div>

            <div class="book-author">Author: ${book.bookAuthor}</div>

            <div>
                <form action="${createLink(controller: 'user', action: 'buyBook')}" method="get">
                    <g:hiddenField name="bookId" value="${book.id}"/>
                    <g:hiddenField name="email" value="${session.userEmail}"/>
                    <button class="buy-button" type="submit">Buy</button>
                </form>
            </div>

        </div>
    </g:each>

</div>
</body>
</html>