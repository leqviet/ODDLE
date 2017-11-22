<@layout.default>
<form id="search-form" action="${app.baseUrl()}/api/weather/search" method="GET"> 
  <div class="row">
  	<div class="col-xs-6 col-md-3">
  	</div>
    <div class="col-xs-6 col-md-6">
      <div class="input-group" style="width: 650px;">
		   <input type="text" class="form-control" placeholder="Search" name="n" id="txtSearch"/>
		   <div class="input-group-btn">
		        <button class="btn" type="submit">
		        <span style="font-weight: bold;">Search</span>
		        </button>
		   </div>
   		</div>
    </div>
  </div>
</form>

  <div class="weather-forecast-list">
  	<br>
  	<div class="row">
	  	<div class="col-xs-6 col-md-3">
	  	</div>
	  	<div class="col-xs-6 col-md-6">
	  		<p id="message" style="color: red; display: none;"></p>
		  	<div id="search-results"></div>
		</div>  	
	  </div>
  </div>	
<script type="text/javascript">
	$(document).ready(function() {
	
		$("#message").hide();
		$("#search-results").load('${app.baseUrl()}/weather/list');
		
		$("#search-form").submit(function() {
		$("#message").hide();
			var searchText = $("#txtSearch").val();
			var url = "${app.baseUrl()}/api/weather/current?n="+searchText;
			$.ajax({
				type : "GET",
				url : url,
				success : function(results) {	
					$("#search-results").load("${app.baseUrl()}/weather/list",{ n: searchText });
				}
			});
			return false;
		});
		
	});  
</script>	
</@layout.default>