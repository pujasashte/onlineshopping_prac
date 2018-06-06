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
	default:
		if(menu == "Home") break;
		$('listProducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;

	}
	
	//code for jquery data tables
	//create a dataset
	var products=[
		['1','ABC'],
		['2','CYX'],
		['3','SER'],
		['4','SDD'],
		['5','VGT'],
		['6','DDD'],
		['7','SDD'],
		['8','SSS']
		
	];
var $table =$('#productListTable');

//execute below code only where we have this table
if($table.length){
	//console.log('inside the table');
	
	$table.DataTable({
		lengthMenu:[[3,5,10,-1] ,['3 Records','5 Records','10 records','ALL']], 
		pageLength: 5,                                                                                                                                                                                                                                                                      
		data:products
	});
}
	

});
