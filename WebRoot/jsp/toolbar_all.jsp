<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>左侧菜单栏</title>
</head>
<SCRIPT type="text/javascript" src="../js/dtree.js"></SCRIPT>
<LINK rel="stylesheet" type="text/css" href="../css/dtree.css">
<BODY
	style="SCROLLBAR-FACE-COLOR: #cccccc; SCROLLBAR-BASE-COLOR: #cccccc; SCROLLBAR-ARROW-COLOR: #000000; SCROLLBAR-SHADOW-COLOR: #e8e8e8; scrollbar-dark-shadow-color: #E8E8E8;width:350px;overflow-x:yes"
	background="../images/left-bg.gif" leftMargin=0 topMargin=10
	bgColor=#f0faff >
	<DIV class=dtree>
		<SCRIPT type=text/javascript>
			d = new dTree('d');
			d.add(0, -1, '');
			d.add(1, 0, '2017年可视化');
			d.add(11, 1, '营销项目报备统计报表');
			d.add(111, 11, '省份与立项相关统计', '../jsp/province_lixiang.jsp', '', 'main');
			d.add(112, 11, '行业与立项相关统计', '../jsp/industry_lixiang.jsp', '', 'main');
			d.add(12, 1, '历年各事业部、部门人员预算和实际人数对比统计报表');
			d.add(121, 12, '事业部人员预算与实际人数对比相关统计', '../jsp/business_person.jsp', '', 'main');
			d.add(122, 12, '部门人员预算与实际人数对比相关统计', '../jsp/department_person.jsp', '', 'main');
			d.add(13, 1, '2017年人员入离职统计报表');
			d.add(131, 13, '2017年各事业部人员数量相关统计', '../jsp/business_person_all.jsp', '', 'main');
			d.add(132, 13, '2017年各事业部入职人员相关统计', '../jsp/business_person_ruzhi.jsp', '', 'main');
			d.add(133, 13, '2017年各事业部离职人员相关统计', '../jsp/business_person_lizhi.jsp', '', 'main');
			d.add(14, 1, '公司员工司龄年龄和学历统计报表');
			d.add(141, 14, '公司员工司龄相关统计', '../jsp/person_siling.jsp', '', 'main');
			d.add(142, 14, '公司员工年龄相关统计', '../jsp/person_nianling.jsp', '', 'main');
			d.add(143, 14, '公司员工学历相关统计', '../jsp/person_xueli.jsp', '', 'main');
			d.add(15, 1, '绩效考核统计报表');
			d.add(151, 15, '绩效考核结果相关统计', '../jsp/person_score.jsp', '', 'main');
			d.add(16, 1, '各事业部、部门人员数量与固定资产数量统计报表');
			d.add(161, 16, '各事业部人员数量与固定资产数量相关统计', '../jsp/business_gdzc_person.jsp', '', 'main');
			d.add(162, 16, '各部门人员数量与固定资产数量相关统计', '../jsp/department_gdzc_person.jsp', '', 'main');
			document.write(d);
		</SCRIPT>
	</DIV>
</BODY>
</html>