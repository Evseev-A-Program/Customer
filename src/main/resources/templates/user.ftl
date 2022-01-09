<#ftl encoding='UTF-8'>
<html>
<head>
  <link href="/css/styles.css" rel="stylesheet" type="text/css">
  <link href="/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body align="center">
<div>
<div class="form-style-2-heading">Имя: ${customer.firstName}</div>
<div class="form-style-2-heading">Фамилия: ${customer.lastName}</div>
<div class="form-style-2-heading">Город: ${customer.city}</div>
<div class="form-style-2-heading">Улица: ${customer.street}</div>
<div class="form-style-2-heading">Дом/квартира: ${customer.country}</div>

<#if paidTypesClients??>
<div class="form-style-2-heading">
    Ваши способы оплаты:
  <table>
    <tr>
      <th></th>
    </tr>

      <#list paidTypesClients as paidType>
        <tr>
          <td>${paidType.name}</td>
        </tr>
      </#list>

  </table>
</div>
</#if>

<a href="/store/">Список товаров</a>
<br>
<a href="/user/update">Изменить данные</a>
<br>
<a href="/user/paid-types">Способы оплаты</a>
<br>
<a href="/logout">Выход</a>
</div>
</body>
</html>