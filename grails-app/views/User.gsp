<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>User Panel</title>
</head>
<body>
<h1>User Panel</h1>

<h2>Books</h2>
<div>
    <g:each in="${books}" var="book">
        <div class="book-card">
            <h3>${book.bookName}</h3>
            <p>by ${book.bookAuthor}</p>
            <g:if test="${book.bookImage}">
                <img src="${book.bookImage}" alt="${book.bookName}" width="100"/>
            </g:if>
            <g:form action="purchaseBook">
                <g:hiddenField name="bookId" value="${book.id}"/>
                <g:submitButton name="buy" value="Buy"/>
            </g:form>
        </div>
    </g:each>
</div>

<h2>Purchased Books</h2>
<g:link action="viewPurchasedBooks">Check your books</g:link>

<g:if test="${purchasedBooks}">
    <h3>Your Purchased Books</h3>
    <ul>
        <g:each in="${purchasedBooks}" var="book">
            <li>${book.bookName} by ${book.bookAuthor}</li>
        </g:each>
    </ul>
</g:if>
</body>
</html>
