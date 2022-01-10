<html>
<head>
    <title>Title</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>

<body>
<#function checking paidTypesClients, paidTypesOffer>
    <#list paidTypesOffer as ptOffer>
        <#list paidTypesClients as ptClient>
            <#if ptOffer == ptClient.id>
                <#return true>
            </#if>
        </#list>
    </#list>
    <#return false>
</#function>

<div class="form-style-2" align="center">
    <div class="form-style-2-heading">
        СПИСОК ТОВАРОВ:
    </div>
    <table class="table">
        <tr>
            <th>Название товара</th>
            <th>Цена</th>
            <th>Категория</th>
            <th>Характеристика (Описание)</th>
            <th>Способы оплаты</th>
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
                        <#list offer.paidTypesId as paidType>
                                <#if paidType == 1> Credit </#if>
                                <#if paidType == 2> Cash </#if>
                                <#if paidType == 3> Terminals </#if>
                                <#if paidType == 4> PhoneBalance </#if>
                                <#if paidType == 5> Transfer </#if>
                                <#if paidType == 6> BankCard </#if>
                        </#list>
                    </td>

                    <td>

                        <#if paidTypesClients??>
                            <#if checking(paidTypesClients, offer.paidTypesId) == true>
                            <td>
                                <form method="post" action="/store">
                                    <input class="input-field" type="hidden" id="name" name="name" value=${offer.id}>
                                    <button type="submit">В корзину</button>
                                </form>
                            </td>
                            <#else>
                                <td style="background-color: #ac2925">Не подходящий способ оплаты</td>
                            </#if>

                        <#else>
                            <td style="background-color: #ac2925">Не подходящий способ оплаты</td>
                        </#if>

                    </td>
                </tr>
            </#list>
        </#if>
    </table>
<a href="/">Корзина</a>
<br>
<a href="/">Назад</a>
</div>
</body>
</html>