<!-- grails-app/views/admin/listUsers.gsp -->

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User List</title>
    <style>
    /* CSS styles for list */
    ul {
        list-style-type: none;
        padding: 0;
    }
    li {
        margin-bottom: 10px;
        padding: 10px;
        border: 1px solid #ddd;
        background-color: #f9f9f9;
    }
    .user-info {
        font-weight: bold;
    }
    </style>
</head>
<body>
<h2>User List</h2>
<ul>
    <g:each in="${users}" var="user">
        <li>
            <span class="user-info">${user.firstName} ${user.lastName}</span><br>
            <span>Email: ${user.email}</span><br>
            <span>Phone: ${user.phone}</span>
        </li>
    </g:each>
</ul>
</body>
</html>
