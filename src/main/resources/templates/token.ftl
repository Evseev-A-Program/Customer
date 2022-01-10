<#ftl encoding='UTF-8'>
<html>
<head>
    <link href="/css/styles.css" rel="stylesheet">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="form-style-2" align="center">
    <#if token??>
        <div class="alert alert-danger" role="alert">${token}</div>
    </#if>
</div>
</body>
</html>