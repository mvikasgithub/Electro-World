$(function(){
	
	
	
	$('#ProductManagementTable').DataTable( {
    ajax: {
        url: '/electroworldFE/all/data',
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
		            "mData": 'id',
		            "bSortable": false,
		           "mRender": function (data,type,row) { return '<a href="/electroworldFE/admin/delete/'+data+'/product" class="btn btn-primary active" role="button">Delete</a>'; }
		        }    	] 
} );

	$('[data-toggle="tooltip"]').tooltip();
	
	
});