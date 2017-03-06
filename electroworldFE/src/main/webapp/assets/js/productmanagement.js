$(function(){
	
	
	
	$('#ProductManagementTable').DataTable( {
    ajax: {
        url: '/electroworldFE/admin/all/data',
        dataSrc: ''
    },
   columns: [        
		        { data: 'code' },
		        { data: 'categoryid' },
		        { data: 'quantity' },
		        { data: 'suppliercode' },		        
		    	{ data: 'id', 
			    	  mRender: function(data,type,row) {
			    		  return '<a href="/electroworldFE/admin/edit/'+data+'/product" class="btn btn-primary active" role="button">Update</a>';	    		  
			    	  }	
			    	},
		        {
		            "mData": null,
		            "bSortable": false,
		           "mRender": function (o) { return '<a href="index.jsp" class="btn btn-primary active" role="button">Delete</a>'; }
		        }    	] 
} );

	$('[data-toggle="tooltip"]').tooltip();
	
	
});