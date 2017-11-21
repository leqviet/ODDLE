<#macro default>
<!DOCTYPE html>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://v4-alpha.getbootstrap.com/favicon.ico">

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
      <!--<div class="jumbotron">
        <h1>Navbar example</h1>
        <p class="lead">This example is a quick exercise to illustrate how fixed to top navbar works. As you scroll, it will remain fixed to the top of your browser's viewport.</p>
        <a class="btn btn-lg btn-primary" href="https://v4-alpha.getbootstrap.com/components/navbar/" role="button">View navbar docs »</a>
      </div>-->
    </div>
    
    
    

	<script src="${app.baseUrl()}/js/bootstrap-table.js"></script>
	
</body>

</html>
</#macro>