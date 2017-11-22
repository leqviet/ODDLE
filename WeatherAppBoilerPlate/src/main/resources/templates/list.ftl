<#if weatherReports??>
	<#if weatherReports?size != 0>  		
		<#list weatherReports as w>
			<#list w.weathers as wt>
					<#if wt?index == 0>
						<table class="weather-forecast-list__table">
							<tbody>
								<tr class="weather-forecast-list__items">
									<td style="width:10%" class="weather-forecast-list">
										<img src="//openweathermap.org/img/w/${wt.icon}.png" alt="forecast">
									</td>
									<td class="weather-forecast-list__item">
										<div class="weather-forecast-list__today-label"><b>${w.cityName}</b></div>
										<p>${wt.date?string["MMMM dd, yyyy"]}</p>																
									</td>
									<td style="width:50%" class="weather-forecast-list__item">
											<p class="weather-forecast-list__card">
												<span class="weather-forecast-list__night">
													${(wt.minimumTemperature -32)*(5/9)}°C
												</span>
												&nbsp;&nbsp;
												<i class="weather-forecast-list__naturalPhenomenon">${wt.description}</i></p>
												<p class="weather-forecast-list__card">
													${wt.speed} m/s &nbsp;clouds: ${wt.percentCloud}%,&nbsp;&nbsp;${wt.pressure} hpa</p>
									</td>
									<td class="weather-forecast-list__item">
										<div class="btn-group">
								            <a class="remove btn btn-default btn-danger " href="" onclick="deleteLog('${wt.uid}');" title="Delete">
								                <span style="font-weight: bold;">Delete</span>
								            </a>
							            </div>
									</td>
								</tr>				
							</tbody>
						</table>
					<#else>	
						<#if wt?index == 1>
							<div  id="demo${w?index}" class="collapse">
						</#if>
							<table class="weather-forecast-list__table">
								<tbody>
									<tr class="weather-forecast-list__items">
										<td style="width:10%" class="weather-forecast-list">
											<img src="//openweathermap.org/img/w/${wt.icon}.png" alt="forecast">
										</td>
										<td class="weather-forecast-list__item">
											<div class="weather-forecast-list__today-label"><b>${w.cityName}</b></div>
											<p>${wt.date?string["MMMM dd, yyyy"]}</p>																
										</td>
										<td style="width:50%" class="weather-forecast-list__item">
											<p class="weather-forecast-list__card">
												<span class="weather-forecast-list__night">
													${(wt.minimumTemperature -32)*(5/9)}°C
												</span>
												&nbsp;&nbsp;
												<i class="weather-forecast-list__naturalPhenomenon">${wt.description}</i></p>
												<p class="weather-forecast-list__card">
													${wt.speed} m/s &nbsp;clouds: ${wt.percentCloud}%,&nbsp;&nbsp;${wt.pressure} hpa</p>
										</td>
										<td class="weather-forecast-list__item">
											<div class="btn-group">
									            <a class="remove btn btn-default btn-danger" onclick="deleteLog('${wt.uid}');" title="Delete">
									                <span style="font-weight: bold;">Delete</span>
									            </a>
								            </div>
										</td>
									</tr>				
								</tbody>
							</table>
						
						<#if wt?index == (w.weathers?size -1)>								
							  </div>  
						</#if>						
					</#if>		
			</#list>
			<#if (w.weathers?size > 1)>
				<a href="#demo${w?index}" class="btn btn-info show-more" data-toggle="collapse" style="color:#333;width: 650px;font-weight: bold;background-color: #999;border-color: #999;">Show More</a>
			</#if>
			<br/>
			<br/>
		</#list>
	<#else>
		<div class="alert alert-warning" style="width: 650px;">
		  	Not found		  	
		</div>
	</#if>  	
</#if>
<script type="text/javascript">
	function deleteLog(uid){
		if(confirm("Do you want to delete?")){
			$.ajax({
				type: "GET",
				url: "${app.baseUrl()}/api/weather/delete?uid="+uid,
				success: function(data) {
					location.reload();
				}
			});
		}  
	}
	
	$(document).ready(function() {
		$(".show-more").on("click", function() {
		    var $this = $(this); 
		    var linkText = $this.text().toUpperCase();    
		    
		    if(linkText === "SHOW MORE"){
		        linkText = "Show Less";
		    } else {
		        linkText = "Show More";
		    };
		
		    $this.text(linkText);
		});
	});
</script>