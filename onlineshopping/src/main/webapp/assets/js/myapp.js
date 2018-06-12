
$(function() {
	// solving active menu problem
	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
	default:
		if (menu == "Home")
			break;
		$('listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;

	}

	// code for jquery data tables
	// create a dataset

	var $table = $('#productListTable');

	// execute below code only where we have this table
	if ($table.length) {
		// console.log('inside the table');
		
// to fetch json data
		var jsonUrl = '';
		if (window.categoryId == '') {
			// document.write("All");
			jsonUrl = window.contextRoot + '/json/data/all/products';

		} else {
			// document.write("Category");
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}
		// document.write(jsonUrl);
		$table.DataTable({
			lengthMenu : [ [ 3, 5, 10, -1 ],
					[ '3 Records', '5 Records', '10 records', 'ALL' ] ],
			pageLength : 5,
			// use of ajax to display json form data
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [ 
				{
					data : 'code',
					bSortable : false,
					mRender : function(data, type, row) {

						return '<img src="' + window.contextRoot
								+ '/resources/images/' + data
								+ '.jpg" class="dataTableImg"/>';

					}
				},	{

				data: 'name'
			}, {

				data: 'brand'
			}, {

				data: 'unitPrice',
				mRender:function(data,type,row){
					return '&#8377; ' + data
				}
			},
			{
	    		    data: 'quantity',
	    		    mRender:function(data,type,row){
	    		     	
		    	    	if(data < 1){
		    	    		return '<span style="color:red">Out of Stock!</span>';
		    	    	}
		    	    	return data;
		    	    	}
	    		    
		    	   
	    	},
	    	{
	    		data: 'id',
	    		bSortable: false,
	    		mRender: function(data,type,row){
	    			
	    			var str = '';
	    			str += '<a href="'+window.contextRoot+ '/show/'+data+'/product" class="btn btn-primary">view product</a> &#160;';
	    		
	    			if(row.quantity < 1){
	    				str += '<a href="javascript:void(0)" class="btn btn-success disabled">add to cart</a>';
	    	    			
	    			}
	    			else{

		    			str += '<a href="'+window.contextRoot+ '/cart/add'+data+'/product" class="btn btn-success">add to cart</a>';
		    		     return str;
	    			}
	    			
	    		}
	    	}

			]

		});
	}

});
