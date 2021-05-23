$(function() {

$("#picname").blur(
		function() {
			$("#picname_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#picname").after("<span id='picname_msg' style='color: red'>标题不能为空</span>");
			}
	});

$("#image").blur(
		function() {
			$("#image_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#image").after("<span id='image_msg' style='color: red'>图片不能为空</span>");
			}
	});

$("#graphsid").blur(
		function() {
			$("#graphsid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#graphsid").after("<span id='graphsid_msg' style='color: red'>相册不能为空</span>");
			}
	});







$('#sub').click(function(){
var picname = $("#picname").val();
var image = $("#image").val();
var graphsid = $("#graphsid").val();
$("#picname_msg").empty();
$("#image_msg").empty();
$("#graphsid_msg").empty();
if (picname == "" || picname == null) {
	$("#picname").after("<span id='picname_msg' style='color: red'>标题不能为空</span>");
	return false;
}
if (image == "" || image == null) {
	$("#image").after("<span id='image_msg' style='color: red'>图片不能为空</span>");
	return false;
}
if (graphsid == "" || graphsid == null) {
	$("#graphsid").after("<span id='graphsid_msg' style='color: red'>相册不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#picname_msg").empty();
$("#image_msg").empty();
$("#graphsid_msg").empty();
});

});
