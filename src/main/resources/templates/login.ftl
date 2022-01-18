<#ftl encoding='UTF-8'>
<html>
<head>
    <link href="/css/styles.css" rel="stylesheet">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<#if error??>
    <div class="alert alert-danger" role="alert">Почта или пароль введены неверно</div>
</#if>
<div class="form-style-2" align="center">
    <div class="form-style-2-heading">
        Please Login!
    </div>
    <form method="post" action="/auth">

        <label for="email">Почта
            <input class="input-field" type="text" id="email" name="email">
        </label>
        <br>
        <label for="password">Пароль
            <input class="input-field" type="password" id="password" name="password">
        </label>
        <br>
        <label for="remember-me">
            <input type="checkbox" id="remember-me" name="remember-me">Запомнить меня
        </label>
        <input type="submit" value="Логин">
    </form>
    <a href="/registration">Регистрация</a>
</div>
</body>
</html>