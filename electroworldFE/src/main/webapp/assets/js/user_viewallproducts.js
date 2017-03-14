$(function(){
	
	
	
	$('#AllProductsTable').DataTable( {
    ajax: {
        url: '/electroworldFE/all/data',
        dataSrc: ''
    },
   columns: [        
		    	{ data: 'name' },
		        {
		            "mData": null,
		            "bSortable": false,
		           "mRender": function (data, type, row) { return '<a href="/electroworldFE/show/'+row.id+'/product" class="Image" title="Image"><img src="/electroworldFE/resources/images/'+row.code+'.jpg" height="50" width="100"/></a>'; }
		        },
		        { data: 'description' },
		        { data: 'price' ,
		        	"mRender": function (data, type, row) { return "&#8377; "+ data;}
		        },
		        {
		            "mData": 'id',
		            "bSortable": false,
		           "mRender": function (data,type,row) { return '<a href="/electroworldFE/customer/addtocart/'+data+'/product" class="btn btn-primary active" role="button">ADD TO CART</a>'; }
		        },    	
		        
    	] 
} );

	$('[data-toggle="tooltip"]').tooltip();
	
	
});