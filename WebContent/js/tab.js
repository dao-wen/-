//table增加一个新行 clone已存在的第一行
$(function() {
	$("#btnAdd").click(
			function() {
				var num = $("#hidNum").val(); //
				num = parseInt(num);
				num++; // 点击自加
				$("#hidNum").val(num); // 重新赋值
				$("#tRow0").clone(true).attr("id", "tRow" + num).appendTo(
						"#tblData"); // clone tr 并重新给定ID,装到table
				// $("#tRow" + num).css('display','block');
				$("#tRow" + num + " td").each(
						function() {// 循环克隆的新行里面的td
							$(this).find("input[type='text']").val(""); // 清空克隆行的数据
							// 修改相关属性
							$(this).find("input[name='num0']").attr("id",
									"num" + num).attr("name", "num" + num);
						});

			});
});

$(function() {
	$("#btnUpload").click(
			function() {
				var objT0 = $(this).closest("tr").find("#image").val();// 找到同行的
				// image元素
				var formData = new FormData($(this).closest("tr").find(
						'#head-img')[0]);
				var loc = $("input[name='basepath']").val();
				$(this).closest("tr").find(".updForm").css('display', 'none');
				$(this).closest("tr").find(".updText").css('display', 'block');
				$(this).closest("tr").find(".btnu").css('display', 'none');
				$(this).closest("tr").find(".btns").css('display', 'block');
				var m1 = $(this).closest("tr").find(".m1");
				var m2 = $(this).closest("tr").find(".m2");
				$.ajax({
					type : "POST",
					url : loc + "upload/save.action",// 后台接口
					data : formData,
					cache : false,// 文件不设置缓存
					processData : false,// 数据不被转换为字符串
					contentType : false,// 上传文件时使用，避免 JQuery 对其操作
					success : function(d) {
						m1.html(d);
						m2.attr("value", d);
					},
					error : function() {
						alert("ajax请求发生错误3");
					}
				});
			});
});

$(function() {
	$("#btnSave").click(function() {
		var loc = $("input[name='basepath']").val();
		var m2 = $(this).closest("tr").find(".m2").val();//图片地址
		var m3 = $(this).closest("tr").find(".m3").val();//主ID
		var m4 = $(this).closest("tr").find(".input-text").val();//标题
		var str = m3 + "," +m4 + "," + m2;
		if (m2 == '') {
			alert("请刷新页面重新上传图片");
		} else {
			$.ajax({
				type : "POST",
				url : loc + "ajax/save.action?str=" + str,
				contentType : "application/json; charset=utf-8",
				dataType : "text",
				success : function() {
					$(this).closest("tr").find(".input-text").css('display', 'none');
					$(this).attr("disabled","disabled")
					$(this).closest("tr").find(".btnu").css('display', 'none');
				},
				error : function() {
					alert("ajax请求发生错误3");
				}
			});
		}
	});
});


