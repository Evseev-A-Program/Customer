<#ftl encoding='UTF-8'>
<html>
<head>
    <link href="/static/css/styles.css" rel="stylesheet">
    <link href="/static/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="body-log-reg">
<#if error??>
    <div class="alert alert-danger" role="alert">Почта или пароль введены неверно</div>
</#if>
<div class="form-style-2" align="center">
    <div class="form-style-2-heading">
        Please Login!
    </div>
    <form method="post" action="/login">

        <label for="email">Почта
            <input class="input-field" type="text" id="email" name="email">
        </label>
        <br>
        <label for="password">Пароль
            <input class="input-field" type="password" id="password" name="password">
        </label>
        <br>
        <label for="remember-me">
            <input type="checkbox" id="rememberMe" name="rememberMe" value="true">Запомнить меня
        </label>
        <input type="submit" value="Логин">
    </form>
    <a href="/store/">Список товаров</a>
    <br>
    <br>
    <a href="/registration">Регистрация</a>
</div>
</body>
</html>