<#ftl encoding='UTF-8'>
<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div align="center">
<form method="post" action="/admin/characteristic">
    <label for="name">Бренд
        <input class="input-field" type="text" id="name" name="name" >
    </label>
    <br>
    <label for="description">Описание
        <input class="input-field" type="text" id="description" name="description" >
    </label>
    <br>
    <input type="submit" value="Добавить">
    <br>
</form>
<a href="/">Назад</a>
<div class="form-style-2">
    <table>
        <tr>
            <th>id</th>
            <th>Name</th>
            <th>Description</th>
        </tr>

        <#if characteristicsFromServer??>
            <#list characteristicsFromServer as characteristic>
                <tr>
                    <td>${characteristic.id}</td>
                    <td>${characteristic.name}</td>
                    <td>${characteristic.description}</td>
                </tr>
            </#list>

        </#if>
    </table>

</div>
</div>
</body>
</html>