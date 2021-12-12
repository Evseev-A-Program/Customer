<#ftl encoding='UTF-8'>
<html>
<head>
    <link href="/css/styles.css" rel="stylesheet">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Регистрация
    </div>
    <form method="post" action="/registration">
        <label for="email">Почта
            <input class="input-field" type="text" id="email" name="email">
        </label>
        <br>
        <label for="phone-number">Номер телефона
            <input class="input-field" type="text" id="phoneNumber" name="phoneNumber">
        </label>
        <br>
        <label for="password">Пароль
            <input class="input-field" type="password" id="password" name="password">
        </label>
        <br>
        <label for="first-name">Имя
            <input class="input-field"  id="first-name" name="firstName">
        </label>
        <br>
        <label for="last-name">Фамилия
            <input class="input-field"  id="last-name" name="lastName">
        </label>
        <br>
        <label for="city">Город
            <input class="input-field"  id="city" name="city">
        </label>
        <br>
        <label for="street">Улица
            <input class="input-field"  id="street" name="street">
        </label>
        <br>
        <label for="country">Дом/Квартира
            <input class="input-field"  id="country" name="country">
        </label>
        <br>
        <label for="remember-me">
            <input type="checkbox" id="remember-me" name="remember-me">Запомнить меня</label>
        <input type="submit" value="SignUp">
        <br>
    </form>
</div>
</body>
</html>