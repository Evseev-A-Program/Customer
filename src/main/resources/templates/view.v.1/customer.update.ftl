<#ftl encoding='UTF-8'>
<html>
<head>
    <link href="/static/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/static/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="body-profile">
<div  align="center">
<form method="post" action="/user/update">
    <label for="phone-number">Номер телефона
        <input class="input-field" type="text" id="phone-number" name="phoneNumber" value=${customer.phoneNumber}>
    </label>
    <br>
    <label for="first-name">Имя
        <input class="input-field"  id="first-name" name="firstName" value=${customer.firstName}>
    </label>
    <br>
    <label for="last-name">Фамилия
        <input class="input-field"  id="last-name" name="lastName" value=${customer.lastName}>
    </label>
    <br>
    <label for="city">Город
        <input class="input-field"  id="city" name="city" value=${customer.city}>
    </label>
    <br>
    <label for="street">Улица
        <input class="input-field"  id="street" name="street" value=${customer.street}>
    </label>
    <br>
    <label for="country">Дом/Квартира
        <input class="input-field"  id="country" name="country" value=${customer.country}>
    </label>
    <br>
    <input type="submit" value="Обновить информацию">
    <br>
</form>
<a href="/">Назад</a>
</div>
</body>
</html>