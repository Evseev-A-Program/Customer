<!DOCTYPE html>
<html lang="en">
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
    <title>Admin Page</title>
</head>
<body align="center" class="body-profile">
<h1 class="form-style-1-heading">АДМИН</h1>
<br>
<div class="form-style-2-heading">${customer.firstName} ${customer.lastName}</div>
<a href="/admin/customers">Показать всех клиентов</a>
<br>
<a href="/admin/paid-types">Показать все способы оплаты</a>
<br>
<br>
<div class = "form-style-2-heading">Товары</div>
<a href="/admin/category">Добавить категорию</a>
<br>
<a href="/admin/characteristic">Добавить характеристику</a>
<br>
<a href="/admin/offer">Добавить/Изменить товар</a>
<br>
<br>
<br>
<a href="/exit">Выход</a>
</body>
</html>