$(document).ready(function(e) {
	// 扔三个下拉列表到主页面建的div中
	$("#sanji").html("<select id='sheng'  name='provinceName'></select><select id='shi' name='cityName'></select>");
	// 加载省的数据
	LoadSheng();
	// 加载市的数据
	LoadShi();
	// 加载区的数据
	// LoadQu();
	// 给省的下拉列表添加点击事件，当省变化时，对应的市和区会发生变化
	$("#sheng").click(function() {
		LoadShi();
		// LoadQu();
	})
	// 给市的下拉列表添加点击事件，当市变化时，对应的区发生变化
	/*
	 * $("#shi").click(function(){ LoadQu(); })
	 */
	//console.log($("#sheng").find("option:selected").val());
	$("#sheng").change(function() {
		console.log($("#sheng").val());
		localStorage.provinces = $("#sheng").val();
		LoadShi();
		console.log($("#shi").val());
		localStorage.city = $("#shi").val();
//		console.log("1234");
	});
	$("#shi").change(function(){
		console.log($("#shi").val());
		localStorage.provinces = $("#sheng").val();
		localStorage.city = $("#shi").val();
	});
});


// 加载省的下拉列表
function LoadSheng() {
	var pcode = "100";
	$.ajax({
		async : false,
		url : "/queryProv/queryProv",
		data : {
			code : pcode
		},
		type : "POST",
		dataType : "json",
		success : function(data) {
			console.log(data);
			var str = "";
			for (var i = 0; i < data.length; i++) {
				var lie = data[i];
				str = str + "<option value='" + lie.prov_cd + "'>"
						+ lie.prov_nm + "</option>";
			}
			$("#sheng").html(str);
		}
	});
}

// 加载市的下拉列表
function LoadShi() {
	var pcode = $("#sheng").val();

	$.ajax({
		async : false,
		url : "/queryProv/queryCity",
		data : {
			code : pcode
		},
		type : "POST",
		dataType : "json",
		success : function(data) {
			console.log(data);
			var str = "";
			for (var i = 0; i < data.length; i++) {
				var lie = data[i];
				str = str + "<option value = '" + lie.ld_area_cd + "'>"
						+ lie.ld_area_nm + "</option>";
			}
			$("#shi").html(str);
		}
	});
}



//console.log($("#sheng").find("option:selected").val());

// 加载区的下拉列表
// function LoadQu() {
// var pcode = $("#shi").val();
// $.ajax({
// url: "",
// data: { code: pcode },
// type: "POST",
// dataType: "TEXT",
// success: function(data) {
// var hang = data.trim().split("|");
// var str = "";
// for(var i = 0; i < hang.length; i++) {
// var lie = hang[i].split("^");
// str = str + "<option value = '" + lie[0] + "'>" + lie[1] + "</option>";
// }
// $("#qu").html(str);
// }
// });
// }
