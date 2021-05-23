$(function() {

$("#flinkname").blur(
		function() {
			$("#flinkname_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#flinkname").after("<span id='flinkname_msg' style='color: red'>名称不能为空</span>");
			}
	});

$("#url").blur(
		function() {
			$("#url_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#url").after("<span id='url_msg' style='color: red'>地址不能为空</span>");
			}
	});

$("#memo").blur(
		function() {
			$("#memo_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
			}
	});







$('#sub').click(function(){
var flinkname = $("#flinkname").val();
var url = $("#url").val();
var memo = $("#memo").val();
$("#flinkname_msg").empty();
$("#url_msg").empty();
$("#memo_msg").empty();
if (flinkname == "" || flinkname == null) {
	$("#flinkname").after("<span id='flinkname_msg' style='color: red'>名称不能为空</span>");
	return false;
}
if (url == "" || url == null) {
	$("#url").after("<span id='url_msg' style='color: red'>地址不能为空</span>");
	return false;
}
if (memo == "" || memo == null) {
	$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#flinkname_msg").empty();
$("#url_msg").empty();
$("#memo_msg").empty();
});

});
