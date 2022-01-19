<html>
<head>
    <title>Title</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>

<body>

<div class="form-style-2" align="center">
    <div class="form-style-2-heading">
        СПИСОК ТОВАРОВ:
    </div>
    <table class="table">
        <tr>
            <th>id товара</th>
            <th>Время</th>
            <th>Статус оплаты</th>
            <th>Статус доставки</th>
            <th> </th>

        </tr>

        <#if orders??>
            <#list orders as order>
                <tr>
                    <td>
                        <#list order.offers as offer>
                            ${offer}
                        </#list>
                    </td>

                    <td>
                        <#if order.deliveryTime??>
                            ${order.deliveryTime}
                        </#if>
                    </td>
                    <td>${order.paid}</td>
                    <td>${order.status}</td>
                    <td>
                        <#if order.paid == "false">
                            <form method="post" action="/user/cart/buy">
                                <input class="input-field" type="hidden" id="id" name="id" value=${order.customer}>
                                <button type="submit">Оплатить</button>
                            </form>
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