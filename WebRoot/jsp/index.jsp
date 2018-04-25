<%@ page contentType="text/html;charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<HTML>
<link href="css/css.css" rel="stylesheet" type="text/css">
<LINK rel=stylesheet type=text/css href="css/dtree.css">
<HEAD>
<title>2017年可视化</title>
<STYLE type=text/css>
.navPoint {
	CURSOR: hand;
	FONT-SIZE: 15pt;
	FONT-FAMILY: Webdings;
	COLOR: #ffffff
}
</STYLE>

<SCRIPT language=javascript>
	function tick() {
		var hours, minutes, seconds, ap;
		var intHours, intMinutes, intSeconds;
		var today;
		today = new Date();
		intHours = today.getHours();
		intMinutes = today.getMinutes();
		intSeconds = today.getSeconds();
		if (intHours == 0) {
			hours = "0:";
			ap = "午夜";
		} else if ((intHours > 0) && (intHours < 8)) {
			hours = intHours + ":";
			ap = "清晨";
		} else if ((intHours >= 8) && (intHours < 12)) {
			hours = intHours + ":";
			ap = "上午";
		} else if (intHours == 12) {
			hours = "12:";
			ap = "中午";
		} else if ((intHours > 12) && (intHours < 19)) {
			hours = intHours - 12 + ":";
			ap = "下午";
		} else {
			hours = intHours - 12 + ":";
			ap = "晚上";
		}
		if (intMinutes < 10) {
			minutes = "0" + intMinutes + ":";
		} else {
			minutes = intMinutes + ":";
		}
		if (intSeconds < 10) {
			seconds = "0" + intSeconds + " ";
		} else {
			seconds = intSeconds + " ";
		}
		timeString = "<font size=2 color=#003366>" + "&nbsp;&nbsp;&nbsp;&nbsp;"
				+ hours + minutes + seconds + ap + "</font>";
		Clock.innerHTML = timeString;
		window.setTimeout("tick();", 1000);
	}
	window.onload = tick;
</SCRIPT>

</HEAD>
<body  topmargin="0"  id="body" width="100%" >
	<table border="0" cellpadding="0" width="100%" cellspacing="0" style="margin-left:-8px;" height="100%">
		<tr>
			<td width="100%" height="80" background="images/top_logo.png">&nbsp;</td>
		</tr>
		<tr>
			<td width="100%" height="30" background="images/index_r3_c9.gif">
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="12%" >
							<div align="center"><font color="#003366" size="2px;"><strong>您 好 ！</strong></font></div>
						</td>
						<td width="70%">
							<div align=right>
								<font color=white size=2> 
									<script>
									today = new Date();
									function initArray() {
										this.length = initArray.arguments.length
										for (var i = 0; i < this.length; i++)
											this[i + 1] = initArray.arguments[i]
									}
									var d = new initArray("星期日", "星期一", "星期二",
											"星期三", "星期四", "星期五", "星期六");
									document.write(
											"<font size = 2 color=#003366>",
											today.getFullYear(), " 年 ", today
													.getMonth() + 1, " 月 ",
											today.getDate(), " 日  ", d[today
													.getDay() + 1], "</font>");
								</script> 
								<font color=white size=2><span id=Clock></span></font></font>
							</div>
						</td>
						<td  width="18%" >
							<div align=right>
								| <a class=title href="login/loginOut.do"><font
									color="#003366" size="2px;">重新登录</font></a> |&nbsp;
							</div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td width="100%" valign="top" >
				<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
					<tr>
						<td width="190" valign="top" id="frmMenu">
							<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" class="common_table">
								<tr>
									<td height="1" bgcolor="#ffffff"><img
										src="images/spacer.gif" width="1" ></td>
								</tr>
								<tr>
									<td><Iframe src="menu/listMenu.action"
											style="HEIGHT: 100%; VISIBILITY: inherit; WIDTH: 210px; Z-INDEX: 2"
											scrolling="yes" frameborder="0" name="left"></iframe>
									</td>
								</tr>
							</table>
						</td>
						<td width="1" bgcolor="#006fc3"><img src="images/a-2.gif" width="1" height="1">
						</td>
						<td width="1" valign="top" bgcolor="#E0E0E0"><img
							src="images/index_banner_bg1.gif" width="6" height="3"><img
							src="images/a-2.gif" width="5" height="1">
						</td>
						<td><Iframe id="main" src=""								
								style="HEIGHT: 100%; VISIBILITY: inherit; WIDTH: 100%; Z-INDEX: 2"
								scrolling="auto" frameborder="0" name="main" id="main"></iframe>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td height="20" width="100%" bgcolor="#CCCCCC">
				<div align="center" class="font-bottom" style="font-size:12px;">Copyright 2017
					亿阳信通股份有限公司版权所有 浏览分辨率为1024*768</div>
			</td>
		</tr>
	</table>

</body>
</HTML>
