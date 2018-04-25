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
<title>行业立项个数</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/json.js"></script>
<script type="text/javascript" src="js/echarts.min.js"></script>
</head>
<body>
<div id="main" style="width: 100%;height: 550px;" ></div>

<script type="text/javascript">
	var myCharts=echarts.init(document.getElementById('main'));
	var option={
			title:{
				color: ['#3398DB'],
				text:'行业与立项数量相关统计',
				textAlign:'left'
			},
			toolbox:{
				feature:{
					restore:{
						show:true,
						title:'还原'
					},
					dataView : {
						show: true, 
						readOnly: false
					},
					magicType:{
						type:['line','bar']
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
			tooltip:{},
			legend:{
				data:['立项数量']
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
						color:'#000000'
					}
				},
				data:[]
			},
			yAxis:{
				axisLabel:{
					formatter:'{value} 个'
				}
			},
			series:[{
				name:'立项数量',
				type:'bar',
				legendHoverLink:true,
				itemStyle:{
                    normal:{
                        color:'#FF3030'
                    }
                },
				data:[]
			}]
			
	};
	$.ajax({
        type: "post",
        url: "report/industry.action",
        dataType: "json", //返回数据形式为json
        data: {},
        success: function(data) {
            if (data) {
                option.xAxis.data = data.nameJSON;
                option.series[0].data = data.numJSON;
            	myCharts.setOption(option); 
            }
        },
        error: function(errorMsg) {
            alert("图表请求数据失败啦!");
        }
    });
</script> 
</body>
</html>