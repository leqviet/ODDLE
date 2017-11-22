<@layout.default>
<h1>Management City</h1>
  <!-- Trigger the modal with a button -->
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Add City</button>

  <!-- Modal -->
  <div id="overlay"></div>
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Add City</h4>
        </div>
        <div class="modal-body">
        	<form id="city_form" name="cityForm" class="choose-amount" action="${app.baseUrl()}/api/donate/create" method="post">
          		<div class="form-group">
		            <label for="name" class="form-control-label">Name of City</label>
		            <input type="text" name="cityName" class="form-control" id="city-name" data-validation="required">
		          </div>
		          <p id="message" style="color: red; display: none;"></p>
				   <input id="save" type="submit" class="btn btn-default" value="Save">
          	</form>	
        </div>        
      </div>
      
    </div>
  </div>

<br/>
<br/>
<table data-toggle="table" id="data-table"
       data-url="${app.baseUrl()}/api/cities/">
    <thead>
    <tr>
        <th data-field="cityName">Name</th>
        <th data-field="operate" data-formatter="operateFormatter" data-events="operateEvents" data-width="160">Actions</th>
    </tr>
    </thead>
</table> 

<script type="text/javascript">

$(document).ready(function() {	

		$("#city_form").submit(function() {
			var $form = $("#city_form");
			var url = "${app.baseUrl()}/api/city/add";
			var  data = $form.serialize();
			$.ajax({
				type : "POST",
				url : url,
				data : data,
				success : function(results) {			
					$('#myModal').modal('hide');
					$("#data-table").bootstrapTable('refresh');
				}
			});
			return false;
		});
	});

  //Columns actions   
  function operateFormatter(value, row, index) {
        return [
            '<div class="btn-group">', 
	            '<a class="remove btn btn-default btn-danger " href="javascript:void(0)" title="Delete">',
	                '<span style="font-weight: bold;">Delete</span>',
	            '</a>',
            '</div>'
        ].join('');
    }

	operateEvents = {
	    'click .remove': function (e, value, row, index) {
	      if(confirm("Do you want to delete?")){
			$.ajax({
				type: "GET",
				url: "${app.baseUrl()}/api/city/delete?uid="+row.uid,
				success: function(data) {
					if(data == true){					
						$("#data-table").bootstrapTable('refresh');
					}
				}
			});
		}  
	    }
	};

</script>    
</@layout.default>