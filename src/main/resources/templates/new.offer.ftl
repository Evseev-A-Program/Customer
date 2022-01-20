<#ftl encoding='UTF-8'>
<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="body-profile">
<div align="center">
<form method="post" action="/admin/offer">
    <label for="name">Наименование товара
        <br>
        <input class="input-field" type="text" id="name" name="name" >
    </label>
    <br>
    <label for="price">Стоимость
        <br>
        <input class="input-field" type="text" id="price" name="price" >
    </label>
    <br>
    <input type="submit" value="Добавить">
    <br>
</form>
<a href="/">Назад</a>
<div class="form-style-2">
    <table class = "table">
        <tr>
            <th>id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Category</th>
            <th>PaidType</th>
            <th>Characteristic</th>
            <th> </th>
        </tr>

        <#if offersFromServer??>
            <#list offersFromServer as offer>
                <tr>
                    <td>${offer.id}</td>
                    <td>${offer.name}</td>
                    <td>${offer.price}</td>
                    <td>
                        <#if offer.category?has_content>
                            ${offer.category.name}
                        </#if>
                     </td>
                    <td>
                        <#if offer.paidTypesId??>
                        <#list offer.paidTypesId as paidType>
                                ${paidType}
                        </#list>
                        </#if>
                    </td>
                    <td>
                        <table>
                            <tr>

                            </tr>
                            <#if offer.characteristics??>
                                <#list offer.characteristics as characteristic>
                                    <tr>
                                        <td>${characteristic.name}</td>
                                        <td>${characteristic.description}</td>
                                    </tr>
                                </#list>
                            </#if>
                        </table>
                    </td>
                    <td>
                        <form method="get" action="/admin/offer-update">
                            <input class="input-field" type="hidden" id="id" name="id" value=${offer.id}>
                            <button type="submit">Обновить</button>
                        </form>
                    </td>
                </tr>
            </#list>

        </#if>
    </table>

</div>
</div>
</body>
</html>