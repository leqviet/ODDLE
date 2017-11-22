<#macro default>
<!DOCTYPE html>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <title>Weather</title>

    <!-- Bootstrap core CSS -->
    <link href="${app.baseUrl()}/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${app.baseUrl()}/css/navbar-top-fixed.css" rel="stylesheet">
    <link href="${app.baseUrl()}/css/style.css" rel="stylesheet">
    <link href="${app.baseUrl()}/css/bootstrap-table.min.css" rel="stylesheet">
	<script src="${app.baseUrl()}/js/jquery.min.js"></script>
	<script src="${app.baseUrl()}/js/jquery-ui.js"></script>
	<script src="${app.baseUrl()}/js/bootstrap.min.js?v=0.1"></script>
  </head>
  <body>  	
    <div class="container">
    <#include "header.ftl">    
    	<#nested>
    </div>
	<script src="${app.baseUrl()}/js/bootstrap-table.js"></script>	
</body>
</html>
</#macro>