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
<title>2017年各事业部入职人员相关统计</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/json.js"></script>
<script type="text/javascript" src="js/echarts.min.js"></script>
</head>
<body>
<div id="main" style="width: 92%;height: 550px;float: left;" ></div>
<div id="time" style="width: 7%;float: right ;margin-top:10px;" >
<font size="2" >事业部列表</font>
	<select id="syb"  style="margin-top:10px;" onchange="javascript:changesyb(this.value);">
		<option value="all">全部</option>
	</select>
</div>
<script type="text/javascript">
	var myCharts=echarts.init(document.getElementById('main'));
	var option={
			title:{
				color: ['#3398DB'],
				text:'2017年各事业部入职人员相关统计',
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
				data:['入职人员数量']
			},
			xAxis:{
				type: 'category',
				axisTick:{
					interval:0
				},
				axisLabel:{
					interval:0,
					textStyle:{
						color:'#000000',
					}
				},
				data:[],
				axisLabel:{
					formatter:'{value} 月'
				}
			},
			yAxis:[{
				type:'value',
				axisLabel:{
					formatter:'{value} 人'
				}
			}],
			series:[{
						name:'入职人员数量',
						type:'line',
						itemStyle:{
                    		normal:{
                        		color:'#FF3030'
                    		}
                		},
						data:[],
						markPoint:{
							data:[
							      	{type:"max",name:"最大值"},
							      	{type:"min",name:"最小值"}
							      ]
						},
						markLine:{
							data:[{
								type:"average",name:"平均值"
							}]
						}
					}]
			
	};
	$.ajax({
		type:"post",
		url:"report/businessList.action",
		dataType:"json",
		data:{},
		success:function(data){
			var yearSelect=$("#syb");
			for (var i = 0; i < data.length; i++){
				yearSelect.append('<option value="'+data[i].code+'">'+data[i].name+'</option>');
			}
		},
		error: function(errorMsg) {
            alert("事业部数据加载失败！");
        }
	});
	$.ajax({
        type: "post",
        url: "report/businessPersonRuZhi.action",
        dataType: "json", //返回数据形式为json
        data: {},
        success: function(data) {
            if (data) {
                option.xAxis.data = data.month;
                option.series[0].data = data.ruzhi;
                $("#syb option[text='"+data.code+"']").attr("selected", true);
            	myCharts.setOption(option); 
            }
        },
        error: function(errorMsg) {
            alert("图表请求数据失败！");
        }
    });
	
	function changesyb(obj){
		 option.xAxis.data ="";
         option.series[0].data = "";
		$.ajax({
	        type: "post",
	        url: "report/businessPersonRuZhi.action",
	        dataType: "json", //返回数据形式为json
	        data: {"code":obj},
	        success: function(data) {
	            if (data) {
	            	option.xAxis.data = data.month;
	                option.series[0].data = data.ruzhi;
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