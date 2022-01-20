<html>
<head>
    <title>Title</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body class="body-profile">
<div class="form-style-2" align="center">
    <div class="form-style-2-heading">
        Paid Types:
    </div>
    <table>
        <tr>
            <th>id</th>
            <th>Name</th>
            <th>State</th>

        </tr>
        <#if paidTypesFromServer??>
        <#list paidTypesFromServer as paidType>
        <tr>
            <td>${paidType.id}</td>
            <td>${paidType.name}</td>
            <td>${paidType.state}</td>
        </tr>
        </#list>
        </#if>
    </table>
    <br>
    <div class="form-style-2-heading">Введите id</div>
    <form method="post" action="/admin/paid-types/delete">
        <input class="input-field" type="text" id="id" name="id">
        <button type="submit">Заблокировать</button>
    </form>

    <form method="post" action="/admin/paid-types/active">
        <input class="input-field" type="text" id="id" name="id">
        <button type="submit">Разблокировать</button>
    </form>
    <a href="/">Назад</a>
</div>

</body>
</html>