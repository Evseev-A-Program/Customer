<html>
<head>
    <title>Title</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>

<div class="form-style-2">
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
</div>
<div>
    <form method="post" action="/banned">
        <label for="id">Введите id пользователя, которого хотите забанить
            <br>
            <input class="input-field" type="text" id="id" name="id">
        </label>
        <input type="submit" value="Забанить">
    </form>
</div>

<div>
    <form method="post" action="/unbanned">
        <label for="id">Введите id пользователя, которого хотите разбанить
            <br>
            <input class="input-field" type="text" id="id" name="id">
        </label>
        <input type="submit" value="Разбанить">
    </form>
</div>
</body>
</html>