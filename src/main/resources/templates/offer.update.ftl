<#ftl encoding='UTF-8'>
<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div align="center">
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
########################################################################################################
<div class="form-style-2">
    <div class="form-style-2-heading">
        Уже имеющиеся способы оплаты:
    </div>
    <table>
        <tr>
            <th>Id: </th>
        </tr>
        <#if offerFromServer.paidTypesId??>
            <#list offerFromServer.paidTypesId as paidType>
                <tr>
                    <td>${paidType}</td>
                </tr>
            </#list>
        </#if>
    </table>
</div>


<div class="form-style-2">
    <div class="form-style-2-heading">
        Выберите способ оплаты из предложенного списка (добавить/удалить):
    </div>
    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th> </th>
            <th> </th>
        </tr>
        <#if paidTypesFromServer??>
            <#list paidTypesFromServer as paidType>
                <tr>
                    <td>${paidType.id}</td>
                    <td>${paidType.name}</td>
                    <td>
                        <form method="post" action="/admin/offer-update/paid-type/add">
                            <input class="input-field" type="hidden" id="paidTypeId" name="paidTypeId" value=${paidType.id}>
                            <input class="input-field" type="hidden" id="offerId" name="offerId" value=${offerFromServer.id}>
                            <button type="submit">Добавить</button>
                        </form>
                    </td>

                    <td>
                        <form method="post" action="/admin/offer-update/paid-type/del">
                            <input class="input-field" type="hidden" id="paidTypeId" name="paidTypeId" value=${paidType.id}>
                            <input class="input-field" type="hidden" id="offerId" name="offerId" value=${offerFromServer.id}>
                            <button type="submit">Удалить</button>
                        </form>
                    </td>
                </tr>
            </#list>
        </#if>
    </table>
</div>
########################################################################################################
    <form method="post" action="/admin/offer-update/category">
        <label for="categoryId">Id категории:
            <input class="input-field"  id="categoryId" name="categoryId">
            <input class="input-field" type="hidden" id="offerId" name="offerId" value=${offerFromServer.id}>
        </label>
        <br>
        <input type="submit" value="Добавить">
        <br>
    </form>

<#if categoriesFromServer??>
    <#list categoriesFromServer as category>
        <tr>
            <td>id "${category.id}" </td>
            <td>Name:${category.name}</td>
            <br>
        </tr>
    </#list>
</#if>
<br>
########################################################################################################
<form method="post" action="/admin/offer-update/characteristic">
    <label for="characteristicId">Id характеристики:
        <input class="input-field"  id="characteristicId" name="characteristicId">
        <input class="input-field" type="hidden" id="offerId" name="offerId" value=${offerFromServer.id}>
    </label>
    <br>
    <input type="submit" value="Добавить">
    <br>
</form>

<#if characteristicsFromServer??>
    <#list characteristicsFromServer as characteristic>
        <tr>
            <td>id "${characteristic.id}" </td>
            <td>Name:${characteristic.name} </td>
            <td>Description:${characteristic.description}</td>
            <br>
        </tr>
    </#list>

</#if>
<br>
<a href="/admin/offer">Назад</a>
</div>
</body>
</html>