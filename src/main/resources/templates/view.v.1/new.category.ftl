<#ftl encoding='UTF-8'>
<html>
<head>
    <link href="/static/css/style.css" rel="stylesheet" type="text/css">
    <link href="/static/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="body-profile">
<div align="center">
<form method="post" action="/admin/category">
    <label for="name">Наименование категории
        <input class="input-field" type="text" id="name" name="name" >
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
    </tr>

<#if categoriesFromServer??>
    <#list categoriesFromServer as category>
        <tr>
            <td>${category.id}</td>
            <td>${category.name}</td>
        </tr>
    </#list>
</#if>
</table>

</div>
</div>
</body>
</html>