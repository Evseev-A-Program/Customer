<#ftl encoding='UTF-8'>
<html>
<head>
    <title>Title</title>
    <link href="/static/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/static/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="body-profile">
<#if userNotFound??>
    <div class="alert alert-danger" role="alert">Пользователь не найден</div>
</#if>
<div class="form-style-2"  align="center">
    <div class="form-style-2-heading">
        Clients:
    </div>
    <table>
        <tr>
            <th>id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>City</th>
            <th>Street</th>
            <th>Country</th>
            <th>State</th>
            <th>Role</th>
        </tr>
        <#if customersFromServer??>
        <#list customersFromServer as customer>
        <tr>
            <td>${customer.id}</td>
            <td>${customer.firstName}</td>
            <td>${customer.lastName}</td>
            <td>${customer.address.city}</td>
            <td>${customer.address.street}</td>
            <td>${customer.address.country}</td>
            <td>${customer.state}</td>
            <td>${customer.role}</td>
        </tr>
        </#list>
        </#if>
    </table>
    <br>
    <form method="post" action="/admin/banned">
        <label for="id">Введите id пользователя, которого хотите забанить
            <br>
            <input class="input-field" type="text" id="id" name="id">
        </label>
        <input type="submit" value="Забанить">
    </form>
    <form method="post" action="/admin/unbanned">
        <label for="id">Введите id пользователя, которого хотите разбанить
            <br>
            <input class="input-field" type="text" id="id" name="id">
        </label>
        <input type="submit" value="Разбанить">
    </form>
    <a href="/">Назад</a>
</div>


</body>
</html>