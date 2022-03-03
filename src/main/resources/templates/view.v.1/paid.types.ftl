<html>
<head>
    <title>Title</title>
    <link href="/static/css/styles.css" rel="stylesheet" type="text/css">
</head>

<body class="body-profile">
<div class="form-style-2" align="center">
    <div class="form-style-2-heading" >
        Ваши сопособы оплаты:
    </div>

            <table>
                <tr>
                    <th></th>
                </tr>
                <#if paidTypesClients??>
                <#list paidTypesClients as paidType>
                    <tr>
                        <td>${paidType.name}</td>
                    </tr>
                </#list>
                </#if>
            </table>


    <div class="form-style-2-heading" >
        Выберите способ оплаты из предложенного списка:
    </div>
    <table>
        <tr>
            <th>Name</th>
            <th> </th>
            <th> </th>
        </tr>
        <#if paidTypesFromServer??>
            <#list paidTypesFromServer as paidType>
                <tr>
                    <td>${paidType.name}</td>
                    <td>
                        <form method="post" action="/user/paid-types/add">
                            <input class="input-field" type="hidden" id="name" name="name" value=${paidType.name}>
                            <button type="submit">Добавить</button>
                        </form>
                    </td>
                    <td>
                        <form method="post" action="/user/paid-types/del">
                            <input class="input-field" type="hidden" id="name" name="name" value=${paidType.name}>
                            <button type="submit">Удалить</button>
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