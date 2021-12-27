<#ftl encoding='UTF-8'>
<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>

<form method="post" action="/admin/offer-update">
    <div class="form-style-2-heading">Id: ${offerFromServer.id}</div>
    <input class="input-field" type="hidden" id="id" name="id" value=${offerFromServer.id}>
    <label for="name">Name:
        <input class="input-field"  id="name" name="name" value=${offerFromServer.name}>
    </label>
    <br>
    <label for="price">Price:
        <input class="input-field"  id="price" name="price" value=${offerFromServer.price}>
    </label>
    <br>

    <input type="submit" value="Update">
    <br>
</form>

<div class="form-style-2">
    <div class="form-style-2-heading">
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
                        <form method="post" action="/admin/offer-update/paid-type">
                            <input class="input-field" type="hidden" id="paidTypeId" name="paidTypeId" value=${paidType.id}>
                            <input class="input-field" type="hidden" id="offerId" name="offerId" value=${offerFromServer.id}>
                            <button type="submit">Добавить</button>
                        </form>
                    </td>
                </tr>
            </#list>
        </#if>
    </table>
</div>

<a href="/admin/offer">Назад</a>
</body>
</html>