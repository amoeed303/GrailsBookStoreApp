<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Panel</title>
    <style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        margin: 20px;
        padding: 0;
    }
    h2 {
        text-align: center;
        color: #333;
    }
    ul {
        list-style-type: none;
        padding: 0;
    }
    li {
        margin-bottom: 10px;
        background-color: #fff;
        padding: 10px;
        border: 1px solid #ddd;
        border-radius: 5px;
    }
    li a {
        text-decoration: none;
        color: #007bff;
        font-weight: bold;
    }
    li a:hover {
        color: #0056b3;
        text-decoration: underline;
    }
    </style>
</head>
<body>
<h2>Welcome to User Panel</h2>
<ul>
    <li><g:link controller="user" action="viewBooks">View Books</g:link></li>

</ul>
</body>
</html>