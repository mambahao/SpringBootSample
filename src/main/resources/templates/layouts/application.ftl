<#macro layout title="Java Web Project Template">
<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
  <link href="http://apps.bdimg.com/libs/typo.css/2.0/typo.css" rel="stylesheet">
  <link href="/css/application.css" rel="stylesheet">
  <title>${title}</title>
</head>
<body>
<div class="container-fluid">
  <#nested>
</div>
<script type="application/javascript" src=" http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="application/javascript" src=" http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>
</#macro>
