$(function() {

	// solving the active menu problem
	switch (menu) {
	case 'About us':
		$('#about').addClass('active');
		break;

	case 'Contact us':
		$('#contact').addClass('active');
		break;

	case 'Home':
		$('#home').addClass('active');
		break;

	case 'Admin - Product Management':
		$('#ProductMgmt').addClass('active');
		break;

	default:
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;

	}
});