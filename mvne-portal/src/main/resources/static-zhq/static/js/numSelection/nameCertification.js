$(function() {
	// 验证姓名是否正确
	$("#biddinger").blur(function() {
		var username = /^[\u4E00-\u9FA5A-Za-z]+$/;
		console.log($("#biddinger").val())
		if (!username.test($("#biddinger").val())) {
			console.log("只能输入中文和英文");
		} else {
			console.log("格式正确");
		}
	});
	// 验证身份证号码格式是否正确
	$("#IDnumberIn").blur(function() {
		var IDNumber = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
		if (!IDNumber.test($("#IDnumberIn").val())) {
			console.log("请输入正确的身份证号码或者格式");
		} else {
			console.log("格式正确");
		}
	});

	function getFileUrl(sourceId) {
		var url;
		if (navigator.userAgent.indexOf("MSIE") >= 1) { // IE
			url = document.getElementById(sourceId).value;
		} else if (navigator.userAgent.indexOf("Firefox") > 0) { // Firefox
			url = window.URL
					.createObjectURL(document.getElementById(sourceId).files
							.item(0));
		} else if (navigator.userAgent.indexOf("Chrome") > 0) { // Chrome
			url = window.URL
					.createObjectURL(document.getElementById(sourceId).files
							.item(0));
		}
		return url;
	}
	/**
	 * 将本地图片 显示到浏览器上
	 */
	function preImg(sourceId, targetId) {
		var url = getFileUrl(sourceId);

		// var imgPre = document.getElementById("imgOne");
		var imgPre = document.getElementById(targetId);
		imgPre.src = url;
	}

	var formData = new FormData();
	var formDataa = new FormData();
	var formDatab = new FormData();
	$("#imgOne").change(function() {
		preImg(this.id, 'imgPre');
		// 转换二进制
		var file = document.getElementById("imgOne");
		formData.append('imgOne', file.files[0]);
		console.log(formData);
	});
	$("#imgOnea").change(function() {
		preImg(this.id, 'imgPrea');
		// 转换二进制
		var filea = document.getElementById("imgOne");
		formDataa.append('imgOne', filea.files[0]);
		console.log(formDataa);
	});
	$("#imgOneb").change(function() {
		preImg(this.id, 'imgPreb');
		// 转换二进制
		var file = document.getElementById("imgOne");
		formDatab.append('imgOne', file.files[0]);
		console.log(formDatab);
	});

	// 点击提交第一个上传图片按钮
	$("#subImgFirst").click(
			function() {
				// jquery 表单提交
				console.log("1111");
				var formDataOne = new FormData(document
						.getElementById("saveFacePhoto"));
				// var formDataTwo = new FormData($( "#saveFacePhoto" )[0]);
				console.log(formDataOne);
				// jquery 表单提交
				// $("#saveConPhoto").click();
				$.ajax({
					// 对于表单提交成功后处理，message为提交页面saveReport.htm的返回内容
					url : "/portal/uploadPic",
					type : "post",
					data : formDataOne,
					// data:$( '#saveFacePhoto').serialize(),
					async : false,
					cache : false,
					contentType : false,
					processData : false,
					success : function(data) {
						console.log("1111:success");
						console.log(data);
						localStorage.FacePhoto = data.returnObject;
					}
				});
				return false; // 必须返回false，否则表单会自己再做一次提交操作，并且页面跳转
			});

	// 点击提交第二个上传图片按钮
	$("#subImgSeccond").click(
			function() {
				console.log("2222");
				var formDataTwo = new FormData(document
						.getElementById("saveConPhoto"));
				// var formDataTwo = new FormData($( "#saveConPhoto" )[0]);
				console.log(formDataTwo);
				// jquery 表单提交
				// $("#saveConPhoto").click();
				$.ajax({
					// 对于表单提交成功后处理，message为提交页面saveReport.htm的返回内容
					url : "/portal/uploadPic",
					type : "post",
					data : formDataTwo,
					// data:$( '#saveConPhoto').serialize(),
					async : false,
					cache : false,
					contentType : false,
					processData : false,
					success : function(data) {
						console.log("2222:success");
						console.log(data);
						localStorage.ConPhoto = data.returnObject;
					}
				});

				return false; // 必须返回false，否则表单会自己再做一次提交操作，并且页面跳转
			});
	// 点击提交第三个上传图片按钮
	$("#subImgThree").click(
			function() {
				console.log("3333");
				var formDataTwo = new FormData(document
						.getElementById("saveHandlePhoto"));
				// var formDataTwo = new FormData($( "#imgUpdateFram" )[0]);
				console.log(formDataTwo);
				// jquery 表单提交
				// $("#saveConPhoto").click();
				$.ajax({
					// 对于表单提交成功后处理，message为提交页面saveReport.htm的返回内容
					url : "/portal/uploadPic",
					type : "post",
					data : formDataTwo,
					// data:$( '#imgUpdateFram').serialize(),
					async : false,
					cache : false,
					contentType : false,
					processData : false,
					success : function(data) {
						console.log("3333:success");
						console.log(data);
						localStorage.HandlePhoto = data.returnObject;
					}
				});
				return false; // 必须返回false，否则表单会自己再做一次提交操作，并且页面跳转
			});
	// 点击下一步
	$(".nextstep").click(function() {
		// 储存姓名和身份证号码到本地
		localStorage.idName = $("#biddinger").val();
		localStorage.idNumber = $("#IDnumberIn").val();

		$.ajax({
			url : "/myTest/testA",
			contentType : "application/json",
			type : "POST",
			data : JSON.stringify({
				"realName" : $("#biddinger").val(),				// 姓名
				"idCard" : $("#IDnumberIn").val(), 				// 身份证号码
				"facePhoto" : localStorage.FacePhoto,			// 正面照
				"conPhoto" : localStorage.ConPhoto, 			// 反面照
				"handlePhoto" : localStorage.HandlePhoto		// 手持照
			}),
			success : function(data) {
				console.log(data);
				window.location.href = "delivery_information.html"
			}
		});

		//window.location.href = "delivery_information.html"
	});

})