document.writeln("<script type=\'text/javascript\' src=\'../../js/common/jquery-2.0.3.min.js\' ></script>");
document.writeln("<script type=\'text/javascript\' src=\'../../js/common/bootstrap.js\'></script>");
document.writeln("<script type=\'text/javascript\' src=\'../../js/common/ajax.js\' ></script>");
document.writeln("<script type=\'text/javascript\' src=\'../../js/common/urlConfig.js\' ></script>");
document.writeln("<script type=\'text/javascript\' src=\'../../js/common/template.js\' ></script>");
document.writeln("<script type=\'text/javascript\' src=\'../../js/distpicker/distpicker.data.js\' ></script>");
document.writeln("<script type=\'text/javascript\' src=\'../../js/distpicker/distpicker.js\' ></script>");
document.writeln("<script type=\'text/javascript\' src=\'../../js/common/jquery.validate.js\' ></script>");
document.writeln("<script type=\'text/javascript\' src=\'../../js/common/jquery.validate.extend.js\' ></script>");
//禁用浏览器后退 解决后退之后造成的无法上传，按钮失效问题
window.history.forward(1); 
/**获取html页面之间跳转的参数**/
function get_url_vars() {
	var vars = [],
		hash;
	var idx = window.location.href.indexOf('?');
	if (idx < 0) {
		return vars;
	}
	var hashes = window.location.href.slice(idx + 1).split('&');
	for(var i = 0; i < hashes.length; i++) {
		hash = hashes[i].split('=');
		vars[hash[0]] = hash[1];
	}
	return vars;
}