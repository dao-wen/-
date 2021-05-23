$(function() {

$("#boardname").blur(
		function() {
			$("#boardname_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#boardname").after("<span id='boardname_msg' style='color: red'>板块名称不能为空</span>");
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
var boardname = $("#boardname").val();
var memo = $("#memo").val();
$("#boardname_msg").empty();
$("#memo_msg").empty();
if (boardname == "" || boardname == null) {
	$("#boardname").after("<span id='boardname_msg' style='color: red'>板块名称不能为空</span>");
	return false;
}
if (memo == "" || memo == null) {
	$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#boardname_msg").empty();
$("#memo_msg").empty();
});

});
