<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Purchased Books</title>
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
        box-shadow: 0 2px 4px rgba(0,0,0,0.1);
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
    .purchase-date {
        color: #888;
    }
    </style>
</head>
<body>
<h2>Purchased Books</h2>
<div class="cards-container">
    <g:each in="${purchases}" var="purchase">
        <div class="card">
            <div class="book-name">${purchase.book.bookName}</div>
            <div class="book-author">Author: ${purchase.book.bookAuthor}</div>
            <div class="purchase-date">Purchased on: ${purchase.purchaseDate}</div>
        </div>
    </g:each>
</div>
</body>
</html>
