$(function(){
	
	
	
	$('#AllProductsTable').DataTable( {
    ajax: {
        url: '/electroworldFE/admin/all/data',
        dataSrc: ''
    },
   columns: [        
		    	{ data: 'id' },
		        { data: 'code' },
		        { data: 'categoryid' },
		        { data: 'quantity' },
		        { data: 'suppliercode' },		        
		        { data: 'active' },
		        { data: 'inStock' }
    	] 
} );

	$('[data-toggle="tooltip"]').tooltip();
	
	
});