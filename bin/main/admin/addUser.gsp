<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add User</title>
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
    form {
        background-color: #fff;
        padding: 20px;
        border: 1px solid #ddd;
        border-radius: 5px;
        width: 300px;
        margin: 0 auto;
    }
    label {
        display: block;
        margin-bottom: 10px;
        color: #555;
    }
    input[type="text"], input[type="email"], input[type="password"] {
        width: calc(100% - 20px);
        padding: 8px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    button[type="submit"] {
        background-color: #007bff;
        color: #fff;
        border: none;
        padding: 10px 20px;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
        display: block;
        margin: 10px auto 0;
    }
    button[type="submit"]:hover {
        background-color: #0056b3;
    }
    </style>
</head>
<body>
<h2>Add User</h2>
<form action="${createLink(controller: 'admin', action: 'addUser')}" method="post">
    <label>First Name:</label>
    <input type="text" name="firstName" id="firstName" required />
    <br/>
    <label>Last Name:</label>
    <input type="text" name="lastName" id="lastName" required />
    <br/>
    <label>Email:</label>
    <input type="email" name="email" id="email" required />
    <br/>
    <label>Password:</label>
    <input type="password" name="password" id="password" required />
    <br/>
    <label>Phone:</label>
    <input type="text" name="phone" id="phone" required />
    <br/>
    <button type="submit">Save User</button>
</form>
</body>
</html>
