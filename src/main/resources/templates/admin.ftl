<!DOCTYPE html>
<html lang="en">
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
    <title>Admin Page</title>
</head>
<body>
<body>
<h1 class="form-style-1-heading">АДМИН</h1>
<br>
<div class="form-style-2-heading">${customer.firstName}</div>
<div class="form-style-2-heading">${customer.lastName}</div>
<div>Адрес</div>
<div class="form-style-2-heading">${customer.city}</div>
<div class="form-style-2-heading">${customer.street}</div>
<div class="form-style-2-heading">${customer.country}</div>
<a href="/admin/customers">Показать всех клиентов</a>
<br>
<a href="/admin/paid-types">Показать все способы оплаты</a>
<br>
<a href="/logout">Выход</a>
</body>
</body>
</html>