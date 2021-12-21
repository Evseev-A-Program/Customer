<html>
<head>
    <title>Title</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>



<div class="form-style-2">
    <div class="form-style-2-heading">
        Выберите способ оплаты из предложенного списка:
    </div>
    <table>
        <tr>
            <th>Name</th>

        </tr>
        <#if paidTypesFromServer??>
            <#list paidTypesFromServer as paidType>
                <tr>
                    <td>${paidType.name}</td>
                </tr>
            </#list>
        </#if>
    </table>
</div>

<div>
    <form method="post" action="/user/paid-types/add">
        <input class="input-field" type="text" id="name" name="name">
        <button type="submit">Добавить</button>
    </form>
</div>
</body>
</html>