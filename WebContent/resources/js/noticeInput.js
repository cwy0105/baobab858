$(function() {
	$('.content').keyup(function(e) {
		var content = $(this).val();
		$('#counter').html(content.length + '/800');
	});
	$('.content').keyup();
});

function insert() {
	var form = document.getElementById('insert');
	form.submit();
}