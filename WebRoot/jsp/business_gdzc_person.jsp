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
<title>各事业部人员数量与固定资产数量相关统计</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/json.js"></script>
<script type="text/javascript" src="js/echarts.min.js"></script>
</head>
<body>
<div id="main" style="width: 92%;height: 550px;float: left;" ></div>
<div id="time" style="width: 5%;float: right ;" >
<font>历年</font>
	<select id="year"  style="margin-top:10px;" onchange="javascript:changeYear(this.value);">
		<option>2015</option>
		<option>2016</option>
		<option selected="selected">2017</option>
	</select>
</div>
<script type="text/javascript">
	var myCharts=echarts.init(document.getElementById('main'));
	var option={
			title:{
				color: ['#3398DB'],
				text:'各事业部人员数量与固定资产数量相关统计',
				textAlign:'left'
			},
			toolbox:{
				feature:{
					dataView : {
						show: true, 
						readOnly: false
					},
					magicType:{
						type:['line','bar']
					},
					restore:{
						show:true,
						title:'还原'
					},
					saveAsImage:{
						show:true,
						title:'保存为图片'
					}
				}
			},
			dataZoom:{
				show:true
			},
			tooltip:{trigger: 'axis'},
			legend:{
				data:['人员数量','固定资产数量']
			},
			xAxis:{
				type: 'category',
				axisTick:{
					interval:0
				},
				axisLabel:{
					interval:0,
					rotate:-45,
					textStyle:{
						color:'#000000',
					}
				},
				data:[]
			},
			yAxis:[{
				type:'value',
				axisLabel:{
					formatter:'{value} 个'
				}
			}],
			series:[
			        {
						name:'人员数量',
						type:'bar',
						legendHoverLink:true,
						itemStyle:{
                    		normal:{
                        		color:'#F08080'
                    		}
                		},
						data:[]
					},
					{
						name:'固定资产数量',
						type:'bar',
						legendHoverLink:true,
						itemStyle:{
                    		normal:{
                        		color:'#FF3030'
                    		}
                		},
						data:[]
					}
			        ]
			
	};
	$.ajax({
        type: "post",
        url: "report/businessPersonAssets.action",
        dataType: "json", //返回数据形式为json
        data: {"year":"2017"},
        success: function(data) {
            if (data) {
                option.xAxis.data = data.name;
                option.series[0].data = data.num;
                option.series[1].data = data.asset;
            	myCharts.setOption(option); 
            }
        },
        error: function(errorMsg) {
            alert("图表请求数据失败！");
        }
    });
	function changeYear(obj){
		 option.xAxis.data ="";
        option.series[0].data = "";
        option.series[1].data = "";
		$.ajax({
	        type: "post",
	        url: "report/businessPersonAssets.action",
	        dataType: "json", //返回数据形式为json
	        data: {"year":obj},
	        success: function(data) {
	            if (data) {
	            	option.xAxis.data = data.name;
	                option.series[0].data = data.num;
	                option.series[1].data = data.asset;
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