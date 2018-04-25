<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公司员工绩效考核相关统计</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/json.js"></script>
<script type="text/javascript" src="js/echarts.min.js"></script>
</head>
<body>
<div id="main" style="width: 92%;height: 550px;float: left;" ></div>
<div id="time" style="width: 5%;float: right ;" >
<font>历年</font>
	<select id="year"  style="margin-top:10px;" onchange="javascript:changeYear(this.value);">
		<option>2010</option>
		<option>2011</option>
		<option>2012</option>
		<option>2013</option>
		<option>2014</option>
		<option>2015</option>
		<option selected="selected">2016</option>
	</select>
</div>
<script type="text/javascript">
	var myCharts=echarts.init(document.getElementById('main'));
	var option={
			title:{
				color: ['#3398DB'],
				text:'公司员工绩效考核相关统计',
				textAlign:'left'
			},
			toolbox:{
				feature:{
					dataView : {
						show: true, 
						readOnly: false
					},
					saveAsImage:{
						show:true,
						title:'保存为图片'
					}
				}
			},
			tooltip:{
				trigger: 'item',
				formatter: "绩效考核 <br/>{b} : {c}人 ({d}%)"
			},
			legend:{
				bottom: 20,
		        left: 'center',
				data:[]
			},
			series:[{
						type:'pie',
						radius : '65%',
			            center: ['50%', '50%'],
			            selectedMode: 'single',
						data:[],
						itemStyle: {
			                emphasis: {
			                    shadowBlur: 10,
			                    shadowOffsetX: 0,
			                    shadowColor: 'rgba(0, 0, 0, 0.5)'
			                }
			            }
					}]
			
	};
	$.ajax({
        type: "post",
        url: "report/personScore.action",
        dataType: "json", //返回数据形式为json
        data: {"year":"2016"},
        success: function(data) {
            if (data) {
                option.legend.data = data.name;
                option.series[0].data = data.data;
            	myCharts.setOption(option); 
            }
        },
        error: function(errorMsg) {
            alert("图表请求数据失败！");
        }
    });
	function changeYear(obj){
         option.series[0].data = "";
		$.ajax({
	        type: "post",
	        url: "report/personScore.action",
	        dataType: "json", //返回数据形式为json
	        data: {"year":obj},
	        success: function(data) {
	            if (data) {
	                option.legend.data = data.name;
	                option.series[0].data = data.data;
	            	myCharts.setOption(option); 
	            }
	        },
	        error: function(errorMsg) {
	            alert("图表请求数据失败！");
	        }
	    });
	}
</script> 
</body>
</html>