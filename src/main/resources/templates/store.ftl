<html>
<head>
    <title>Title</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>

<body>

<div class="form-style-2">
    <div class="form-style-2-heading">
        СПИСОК ТОВАРОВ:
    </div>
    <table class="table">
        <tr>
            <th>Название товара</th>
            <th>Цена</th>
            <th>Категория</th>
            <th>Характеристика (Описание)</th>
            <th> </th>

        </tr>
        <#if offersFromServer??>
            <#list offersFromServer as offer>
                <tr>
                    <td>${offer.name}</td>
                    <td>${offer.price}</td>
                    <td>${offer.category.name}</td>
                    <td>
                        <table>
                            <tr>
<#--                            <th> </th>-->
<#--                            <th> </th>-->
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
                        <form method="post" action="/store">
                            <input class="input-field" type="hidden" id="name" name="name" value=${offer.id}>
                            <button type="submit">В корзину</button>
                        </form>
                    </td>
                </tr>
            </#list>
        </#if>
    </table>
</div>
<a href="/">Корзина</a>
<br>
<a href="/">Назад</a>
</body>
</html>