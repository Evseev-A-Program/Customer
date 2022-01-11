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
                    <th>
                        <#list order.offers as offer>
                            ${offer}
                        </#list>
                    </th>
                    <th> ${order.}</th>
                    <th>Статус оплаты</th>
                    <th>Статус доставки</th>
                    <th> </th>

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