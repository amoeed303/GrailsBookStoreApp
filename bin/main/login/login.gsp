<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        margin: 20px;
        padding: 20px;
    }
    h1 {
        color: #333;
    }
    form {
        max-width: 400px;
        background-color: #fff;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }
    label {
        display: block;
        margin-bottom: 10px;
        font-weight: bold;
    }
    input[type=text], input[type=password] {
        width: calc(100% - 12px);
        padding: 8px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    input[type=checkbox] {
        margin-right: 5px;
    }
    button[type=submit] {
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
    }
    button[type=submit]:hover {
        background-color: #45a049;
    }
    </style>
</head>
<body>
<h1>Login</h1>
<form action="${createLink(controller: 'login', action: 'authenticate')}" method="post">
    <label>Email:</label>
    <input type="text" name="email" required><br>
    <label>Password:</label>
    <input type="password" name="password" required><br>
    <label>Admin:</label>
    <input type="checkbox" name="isAdmin" value="true"><br>
    <button type="submit">Login</button>
</form>
</body>
</html>
