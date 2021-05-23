$(function() {

$("#usersid").blur(
		function() {
			$("#usersid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#usersid").after("<span id='usersid_msg' style='color: red'>发布人不能为空</span>");
			}
	});

$("#vedioid").blur(
		function() {
			$("#vedioid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#vedioid").after("<span id='vedioid_msg' style='color: red'>MV不能为空</span>");
			}
	});

$("#num").blur(
		function() {
			$("#num_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#num").after("<span id='num_msg' style='color: red'>评分不能为空</span>");
			}
	});

$("#contents").blur(
		function() {
			$("#contents_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#contents").after("<span id='contents_msg' style='color: red'>内容不能为空</span>");
			}
	});

$("#addtime").blur(
		function() {
			$("#addtime_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#addtime").after("<span id='addtime_msg' style='color: red'>发布日期不能为空</span>");
			}
	});







$('#sub').click(function(){
var usersid = $("#usersid").val();
var vedioid = $("#vedioid").val();
var num = $("#num").val();
var contents = $("#contents").val();
var addtime = $("#addtime").val();
$("#usersid_msg").empty();
$("#vedioid_msg").empty();
$("#num_msg").empty();
$("#contents_msg").empty();
$("#addtime_msg").empty();
if (usersid == "" || usersid == null) {
	$("#usersid").after("<span id='usersid_msg' style='color: red'>发布人不能为空</span>");
	return false;
}
if (vedioid == "" || vedioid == null) {
	$("#vedioid").after("<span id='vedioid_msg' style='color: red'>MV不能为空</span>");
	return false;
}
if (num == "" || num == null) {
	$("#num").after("<span id='num_msg' style='color: red'>评分不能为空</span>");
	return false;
}
if (contents == "" || contents == null) {
	$("#contents").after("<span id='contents_msg' style='color: red'>内容不能为空</span>");
	return false;
}
if (addtime == "" || addtime == null) {
	$("#addtime").after("<span id='addtime_msg' style='color: red'>发布日期不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#usersid_msg").empty();
$("#vedioid_msg").empty();
$("#num_msg").empty();
$("#contents_msg").empty();
$("#addtime_msg").empty();
});

});
