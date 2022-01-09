<html>
<head>
    <title>Title</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>

<body >
<div class="form-style-2" align="center">
    <div class="form-style-2-heading" >
        Выберите способ оплаты из предложенного списка:
    </div>
    <table>
        <tr>
            <th>Name</th>
            <th> </th>

        </tr>
        <#if paidTypesFromServer??>
            <#list paidTypesFromServer as paidType>
                <tr>
                    <td>${paidType.name}</td>
                    <td>
                        <form method="get" action="/user/paid-types/add">
                            <input class="input-field" type="hidden" id="name" name="name" value=${paidType.name}>
                            <button type="submit">Добавить</button>
                        </form>
                    </td>
                </tr>
            </#list>
        </#if>
    </table>
    <a href="/">Назад</a>
</div>

</body>
</html>