<html>
<head>
    <title>Title</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>

<div class="form-style-2">
    <div class="form-style-2-heading">
        Paid Types:
    </div>
    <table>
        <tr>
            <th>id</th>
            <th>Name</th>

        </tr>
        <#if paidTypesFromServer??>
        <#list paidTypesFromServer as paidType>
        <tr>
            <td>${paidType.id}</td>
            <td>${paidType.name}</td>
        </tr>
        </#list>
        </#if>
    </table>
    <form method="get" action="/admin/paid-types/delete">
        <input class="input-field" type="text" id="id" name="id">
        <button type="submit">Удалить</button>
    </form>
    <a href="/">Назад</a>
</div>

</body>
</html>