var upload_Type_enum = { IMG: "IMG", VIDEO: "VIDEO", OTHER: "OTHER" };
var ie = !!window.ActiveXObject || "ActiveXObject" in window;
/*var appName = navigator.appName; //浏览器的正式名称
var appVersion = navigator.appVersion; //浏览器的版本号
var platformVersion=appName+appVersion;*/
var ajaxhttp = {
	//ajax请求数据
	method: function(url, data, type, success, options) {
		options = $.extend({
			//application/json; charset=utf-8
			contentType: "application/x-www-form-urlencoded",
			async: true
		}, options);
		$.ajax({
			type: type,
			data: data,
			cache: false,
			url: url,
			dataType: "json",
			async: options.async,
			contentType: options.contentType,
			/*headers: {
				'Authorization': accessToken,
			},*/
			error: function(xhr, textStatus, errorThrown) {
				if(xhr.status == 401) {
					layui.use(['layer'], function() {
						layui.layer.msg("令牌失效！", { icon: 5 }, function() {
							window.location.href = rootPath + "html/LoginReg/login.html";
						});
					});
				}
			},
			success: function(data) {
				success ? success(data) : function() {};
			}
		});
	},
	/*fileUpload: function(options) {
		/*
			回现预留
			var reader = new FileReader();
			reader.readAsDataURL(img)
			reader.onload = function(e){
			}
		
		options = $.extend({
			uploadType: upload_Type_enum.IMG,
			elementSelector: "#upload",
			success: function() {}
		}, options);
		
		if (ie) {
			var upFileName = $(this);
			upFileName.select();
			var path = document.selection.createRange().text;
			var ImageFileExtend = ".png,.jpg,.ico,.bmp";
			var fileExtend = path.substring(path.lastIndexOf('.')).toLowerCase();
			if(ImageFileExtend.indexOf(fileExtend) > -1) {
				var uploadType = "IMG";
			}
			var ImageFileExtendV = ".mp4";
			var fileExtendV = path.substring(path.lastIndexOf('.')).toLowerCase();
			if(ImageFileExtendV.indexOf(fileExtendV) > -1) {
				var uploadType = "VIDEO";
			}
			$.ajaxFileUpload({
				url: confUrl.upload,
				secureuri: false,
				//dataType:'json',
				data: {"uploadType": uploadType},
				contentType: "text/html",
				fileElementId: options.elementSelector,
				success: function(data) {
					options.success(returndata);
				}
			});
		} else {
			var $elementSelector = $(options.elementSelector);
			var file = $elementSelector[0].files[0];
			if(file == undefined) {
				return;
			}
			if(options.uploadType == upload_Type_enum.IMG) {
				var accept = "image/x-png,image/png,image/jpeg";
				if(accept.indexOf(file.type) < 0) {
					layer.msg('文件类型不符合', {icon: 5});
					$elementSelector.attr("accept", accept);
					return;
				}
				if(file.size > 500 * 1024) {
					layer.msg('单张图片限制500k', { icon: 5 });
					return;
				}
			}
			if(options.uploadType == upload_Type_enum.VIDEO) {
				if(!/^video\/.*$/.test(file.type)) {
					layer.msg('文件类型不符合', { icon: 5 });
					$elementSelector.attr("accept", "video/*");
					return;
				}
				if(file.size > 10 * 1024 * 1024) {
					layer.msg('单个视频限制10M', { icon: 5 });
					return;
				}
			}
			if(options.uploadType == upload_Type_enum.OTHER && file.size > 20 * 1024 * 1024) {
				layer.msg('单个文件限制10M', { icon: 5 });
			}
			var formData = new FormData();
			formData.append("file", file);
			formData.append("uploadType", options.uploadType);
			$.ajax({
				url: confUrl.upload,
				type: 'POST',
				data: formData,
				headers: {
					'Authorization': accessToken
				},
				async: false,
				cache: false,
				contentType: false,
				processData: false,
				success: function(returndata) {
					options.success(returndata);
				},
				error: function(returndata) {}
			});
		}
	}*/
}