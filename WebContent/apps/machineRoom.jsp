<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" class="x-viewport">
<title>机房</title>
    <%@ include file="/common/meta.jsp" %>
<style type="text/css">
		.title {	    
		    font-size: 16px;
		    font-weight: bold;
		    font-family:Arial,Helvetica, sans-serif;
		}
     
#Layer1 {
	position:absolute;
	width:200px;
	height:115px;
	z-index:6;
	left: 109px;
	top: 68px;
}
#Layer3 {
	position:absolute;
	width:31px;
	height:25px;
	z-index:6;
	left: 195px;
	top: 718px;
}
</style>
         <script type="text/javascript">
           function toCompressorIndexs(comCode){
        	 //window.open("${ctx}/compressorRealTimeMonitor.do?comCode="+comCode);	 
        	 window.location.href="${ctx}/compressorRealTimeMonitor.do?comCode="+comCode;  
           }
           function toWellIndexs(well){
           var wellNo=well.id;
           	window.location.href="${ctx}/wellreal_excute.do?wellNo="+wellNo;
           }
           function toSingleCamera(cnum){
               	window.location.href="${ctx}/toSingleCamera.do?cnum="+cnum;
           }
           
           function updateChart(){
			$.get("${ctx}/jointOilCompressor_realTime.do", {		
			}, function(data) {
				var array = data.split(";");
				if(array.length>=2){
					//井
					var wellArr=array[0].split(",");
					for(i=0;i<wellArr.length;i++){
						var tmpArr=wellArr[i].split("_");
						var wellNo=tmpArr[0];
						var status=tmpArr[1];
						if(status==1){
							$("#"+wellNo).css("background-image","url('${ctx}/images/bi/wellgreen.png')");
						}else if(status==2){
							$("#"+wellNo).css("background-image","url('${ctx}/images/bi/well_red.png')");
						}
					}
					
					//压缩机
					var compressorArr=array[1].split(",");
					for(j=0;j<compressorArr.length;j++){
						var tmpArr=compressorArr[j].split("_");
						var compressorCode=tmpArr[0];
						var status=tmpArr[1];
						if(status==0){
							$("#"+compressorCode).css("background-color","#FF9900");
						}else if(status==1){
							$("#"+compressorCode).css("background-color","#00CC33");
						}else if(status==2){
							$("#"+compressorCode).css("background-color","#FF0000");
						}
					}
				}
				
			});
			
		}
		$(document).ready(function() {
			setInterval('updateChart()', 5000 );	
		});
        </script>
  </head>
<body style="background: url('../images/bg01ss.jpg'); background-color:#FFFFFF; height: 100%; margin: 0; width: 100%;text-align:center;">
<form id="mainFormaaaa" action="${ctx}/compressor_grapMachineRoom.do" method="post">
  <div id="div1" style=" position:absolute;margin: 5px; height:710; width: 1420; background-color:#FFFFFF">
    <div id="fourthRoom" style="position:absolute;width:234px;height:303px;z-index:1;top: 490px;left: 138px; background-image: url('${ctx}/images/bi/room4.png');">
      <s:iterator value="compressorList" status="s" var="ma">
        <s:if test='#ma.machineRoom.roomNo=="MR4"'>
        	<div class="title"  style="cursor:pointer;position:absolute;width:70px;height:20px;z-index:1;left:4px;top:${comTop+5}px;">${compressorCode}</div>
	          <div id="fourthmachine" style="cursor:pointer;position:absolute;width:80px;height:30px;z-index:1;left:73px;top:${comTop}px;background-image: url('${ctx}/images/bi/machineY.png');" class="title" onMouseOver="this.style.backgroundColor='#FFFF00';"  onMouseOut="this.style.backgroundColor='#666666';" title="${compressorName}" onClick='toCompressorIndexs("${ma.compressorCode}")'></div>
	          
	          <s:if test="#ma.state==0">
	                <div id="${compressorCode}" style="position:absolute;width:12px;height:11px;z-index:1;left:103px;top:${comTop+10}px; background-color:#FF9900"></div>         
	          </s:if>
	          <s:elseif test="#ma.state==2">
	          		<div id="${compressorCode}" style="position:absolute;width:12px;height:11px;z-index:1;left:103px;top:${comTop+10}px; background-color:#FF0000"></div>
	          </s:elseif>
	          <s:elseif test="#ma.state==1">
	          	<div id="${compressorCode}" style="position:absolute;width:12px;height:11px;z-index:1;left:103px;top:${comTop+10}px; background-color:#00CC33"></div>
	          </s:elseif>          
        </s:if>
      </s:iterator>
      <div id="Layer13" style="position:absolute;width:68px;height:21px;z-index:7;top: -21px;left: 53px;" class="title"><a href="indexcom.do?roomId=000132e1625b0d04">4# 机房</a></div>
    </div>
    <div id="firstRoom" style="position:absolute;width:517px;height:181px;z-index:1;left: 467px;top: 402px;background-image: url('${ctx}/images/bi/room1.png')">
      <s:iterator value="compressorList" status="s" var="ma">
        <s:if test='#ma.machineRoom.roomNo=="MR1"'>
        <div class="title"  style="cursor:pointer;position:absolute;width:70px;height:20px;z-index:1;left:${comLeft-20}px;top:25px;">${compressorCode}</div>
          <div id="Layer4" style="cursor:pointer;position:absolute;width:31px;height:80px;z-index:1;left:${comLeft}px;top:40px;background-image: url('${ctx}/images/bi/machineY1.png');" class="title" onMouseOver="this.style.backgroundColor='#FFFF00';"  onMouseOut="this.style.backgroundColor='#666666';" title="${compressorName}" onClick='toCompressorIndexs("${ma.compressorCode}")' ></div>
          <s:if test="#ma.state==2">
          <div id="${compressorCode}" style="position:absolute;width:12px;height:13px;z-index:1;left: ${comLeft+9}px;top:70px; background-color:#FF0000"></div>
          </s:if>
          <s:if test="#ma.state==0">
          <div id="${compressorCode}" style="position:absolute;width:12px;height:13px;z-index:1;left:${comLeft+9}px;top:70px; background-color:#FF9900"></div>
          </s:if>
          <s:if test="#ma.state==1">
          <div id="${compressorCode}" style="position:absolute;width:12px;height:13px;z-index:1;left:${comLeft+9}px;top:70px; background-color:#00CC33"></div>
          </s:if>
        </s:if>
      </s:iterator>
      <div id="Layer14" style="position:absolute;width:55px;height:18px;z-index:3;left:220px;top: -9px;" class="title"><a href="indexcom.do?roomId=000132e161a38101">1#机房</a></div>
    </div>
    <div id="thirdRoom" style="position:absolute;width:265px;height:133px;z-index:1;left: 929px;top: 58px;background-image: url('${ctx}/images/bi/rom3.png');">
      <s:iterator value="compressorList" status="s" var="ma">
        <s:if test='#ma.machineRoom.roomNo=="MR3"'>
        <div class="title"  style="cursor:pointer;position:absolute;width:70px;height:20px;z-index:1;left:${comLeft}px;top:${comTop-15}px;">${compressorCode}</div>
          <div id="Layer2" style="cursor:pointer;position:absolute;width:80px;height:30px;z-index:1;left: ${comLeft}px;top:${comTop}px;background-image: url('${ctx}/images/bi/machineY.png');" class="title" onMouseOver="this.style.backgroundColor='#FFFF00';"  onMouseOut="this.style.backgroundColor='#666666';" title="${compressorName}" onClick='toCompressorIndexs("${ma.compressorCode}")'></div>
          <s:if test="#ma.state==2">
          	<div id="${compressorCode}" style="position:absolute;width:12px;height:11px;z-index:1;left: ${comLeft+30}px;top:${comTop+9}px; background-color:#FF0000"></div>
          </s:if>
          <s:if test="#ma.state==0">
          	<div id="${compressorCode}" style="position:absolute;width:12px;height:11px;z-index:1;left:${comLeft+30}px;top:${comTop+9}px; background-color:#FF9900"></div>
          </s:if>
          <s:if test="#ma.state==1">
          	<div id="${compressorCode}" style="position:absolute;width:12px;height:11px;z-index:1;left:${comLeft+30}px;top:${comTop+9}px; background-color:#00CC33"></div>
          </s:if>
        </s:if>
      </s:iterator>
      <div id="Layer16" style="position:absolute;width:75px;height:16px;z-index:2;top: -23px;left: 57px;" class="title"><a href="indexcom.do?roomId=000132e162243503">3# 机 房</a></div>
    </div>
    <div id="fifthRoom" style="position:absolute;width:292px;height:156px;z-index:1;top: 229px;left: 790px;background-image: url('${ctx}/images/bi/room5.png');">
      <s:iterator value="compressorList" status="s" var="ma">
        <s:if test='#ma.machineRoom.roomNo=="MR5"'>
          <div class="title"  style="cursor:pointer;position:absolute;width:70px;height:20px;z-index:1;left:${comLeft-0}px;top:${comTop-20}px;">${compressorCode}</div>
          <div id="fifthmachine" style="cursor:pointer;position:absolute;width:80px;height:30px;z-index:1;left:${comLeft}px;top:${comTop}px;background-image: url('${ctx}/images/bi/machineY.png');" class="title" onMouseOver="this.style.backgroundColor='#FFFF00';"  onMouseOut="this.style.backgroundColor='#666666';" title="${compressorName}" onClick='toCompressorIndexs("${ma.compressorCode}")'></div>
          <s:if test="#ma.state==2">
          	<div id="${compressorCode}" style="position:absolute;width:12px;height:11px;z-index:1;left:${comLeft+30}px;top:${comTop+10}px; background-color:#FF0000"></div>
          </s:if>
          <s:if test="#ma.state==0">
          	<div id="${compressorCode}" style="position:absolute;width:12px;height:11px;z-index:1;left:${comLeft+30}px;top:${comTop+10}px; background-color:#FF9900"></div>
          </s:if>
          <s:if test="#ma.state==1">
          	<div id="${compressorCode}" style="position:absolute;width:12px;height:11px;z-index:1;left:${comLeft+30}px;top:${comTop+10}px; background-color:#00CC33"></div>
          </s:if>
        </s:if>
      </s:iterator>
      <div id="Layer15" style="position:absolute;width:17px;height:41px;z-index:2;top: 19px;left: 11px;" class="title"><a href="indexcom.do?roomId=000132e162979105">5# 机 房</a></div>
    </div>
    <div id="secondRoom" style="position:absolute;width:357px;height:122px;z-index:1;left: 1356px;top:50px;background-image: url('${ctx}/images/bi/room2.png');">
      <s:iterator value="compressorList" status="s" var="ma">
        <s:if test='#ma.machineRoom.roomNo=="MR2"'>
        <div class="title"  style="cursor:pointer;position:absolute;width:70px;height:20px;z-index:1;left:${comLeft-20}px;top:7px;">${compressorCode}</div>
          <div id="secondmachine" style="cursor:pointer;position:absolute;width:31px;height:80px;z-index:1;left:${comLeft}px;top:23px;background-image: url('${ctx}/images/bi/machineY1.png');" class="title" onMouseOver="this.style.backgroundColor='#FFFF00';"  onMouseOut="this.style.backgroundColor='#666666';" title="${compressorName}" onClick='toCompressorIndexs("${ma.compressorCode}")'></div>
          <s:if test="#ma.state==2">
          	<div id="${compressorCode}" style="position:absolute;width:12px;height:11px;z-index:1;left:${comLeft+10}px;top:55px; background-color:#FF0000"></div>
          </s:if>
          <s:if test="#ma.state==0">
          	<div id="${compressorCode}" style="position:absolute;width:12px;height:11px;z-index:1;left:${comLeft+10}px;top:55px; background-color:#FF9900"></div>
          </s:if>
          <s:if test="#ma.state==1">
          	<div id="${compressorCode}" style="position:absolute;width:12px;height:11px;z-index:1;left:${comLeft+10}px;top:55px; background-color:#00CC33"></div>
          </s:if>
        </s:if>
      </s:iterator>
      <div id="Layer17" style="position:absolute;width:88px;height:15px;z-index:8;left: 176px;top: -20px;" class="title"><a href="indexcom.do?roomId=000132e161ec9402">2#机房</a></div>
    </div>
    <div id="Layer2" style="position:absolute;width:12px;height:11px;z-index:1;left: 1720px;top: 898px; background-color:#FF0000"></div>
    <div id="Layer14" style="position:absolute;width:55px;height:18px;z-index:3;left: 1760px;top: 895px;" class="title">告警</div>
    <div id="Layer2" style="position:absolute;width:12px;height:11px;z-index:1;left: 1720px;top: 929px; background-color:#FF9900"></div>
    <div id="Layer14" style="position:absolute;width:55px;height:18px;z-index:3;left: 1760px;top: 927px;" class="title">停止</div>
    <div id="Layer2" style="position:absolute;width:12px;height:11px;z-index:1;left: 1720px;top: 962px; background-color:#00CC33"></div>
    <div id="Layer14" style="position:absolute;width:86px;height:18px;z-index:3;left: 1760px;top: 960px;" class="title">正在运行中</div>
    <s:iterator value="wellList" status="w" var="we">
    	<s:if test='#we.wellNo=="352154"'>
    		<s:if test="#we.status==2">
    		   	<div id="352154" style="cursor:pointer;position:absolute;width:42px;height:41px;z-index:2;left: 210px;top: 809px;background-image: url('${ctx}/images/bi/well_red.png');" onClick="toWellIndexs(this)"></div>
			<div style="position:absolute;width:42px;height:20px;z-index:2;left: 253px;top: 815px;font-size:18px;" >352154</div>
    		</s:if>
    		<s:elseif test="#we.status==1">
    			<div id="352154" style="cursor:pointer;position:absolute;width:42px;height:41px;z-index:2;left: 210px;top: 809px;background-image: url('${ctx}/images/bi/wellgreen.png');" onClick="toWellIndexs(this)"></div>
			<div style="position:absolute;width:42px;height:20px;z-index:2;left: 253px;top: 815px;font-size:18px;" >352154</div>
    		</s:elseif>
    			
    	</s:if>
    	<s:if test="#we.wellNo=='352164'">
    		<s:if test="#we.status==2">
    			<div id="352164" style="cursor:pointer;position:absolute;width:42px;height:41px;z-index:2;left: 578px;top: 651px;background-image: url('${ctx}/images/bi/well_red.png');" onClick="toWellIndexs(this)"></div>
			<div style="position:absolute;width:42px;height:20px;z-index:2;left: 621px;top: 656px;font-size:18px;" >352164</div>	
    		</s:if>
    		<s:elseif test="#we.status==1">
    			<div id="352164" style="cursor:pointer;position:absolute;width:42px;height:41px;z-index:2;left: 578px;top: 651px;background-image: url('${ctx}/images/bi/wellgreen.png');" onClick="toWellIndexs(this)"></div>
			<div style="position:absolute;width:42px;height:20px;z-index:2;left: 621px;top: 656px;font-size:18px;" >352164</div>	
    		</s:elseif>  
    			
    	</s:if>
    	<s:if test="#we.wellNo=='36163'">
	    	<s:if test="#we.status==2">
	    		<div id="36163" style="cursor:pointer;position:absolute;width:42px;height:41px;z-index:2;left: 401px;top: 894px;background-image: url('${ctx}/images/bi/well_red.png');" onClick="toWellIndexs(this)"></div> 	
<div style="position:absolute;width:42px;height:20px;z-index:2;left: 444px;top: 900px;font-size:18px;" >36163</div>
	    	</s:if>
	    	<s:elseif test="#we.status==1">
	    		<div id="36163" style="cursor:pointer;position:absolute;width:42px;height:41px;z-index:2;left: 401px;top: 894px;background-image: url('${ctx}/images/bi/wellgreen.png');" onClick="toWellIndexs(this)"></div>
<div style="position:absolute;width:42px;height:20px;z-index:2;left: 444px;top: 900px;font-size:18px;" >36163</div>
	    	</s:elseif>  	
	    	
		</s:if>
		<s:if test="#we.wellNo=='361164'">
			<s:if test="#we.status==2">
				<div id="361164" style="cursor:pointer;position:absolute;width:42px;height:41px;z-index:2;left: 578px;top: 579px;background-image: url('${ctx}/images/bi/well_red.png');" onClick="toWellIndexs(this)"></div>
<div style="position:absolute;width:42px;height:20px;z-index:2;left: 621px;top: 585px;font-size:18px;" >361164</div>
			</s:if>
			<s:elseif test="#we.status==1">
				<div id="361164" style="cursor:pointer;position:absolute;width:42px;height:41px;z-index:2;left: 578px;top: 579px;background-image: url('${ctx}/images/bi/wellgreen.png');" onClick="toWellIndexs(this)"></div>
<div style="position:absolute;width:42px;height:20px;z-index:2;left: 621px;top: 585px;font-size:18px;" >361164</div>
			</s:elseif> 
			
    	</s:if>
    	<s:if test="#we.wellNo=='36165'">
	    	<s:if test="#we.status==2">
	    	    <div id="36165" style="cursor:pointer;position:absolute;width:42px;height:41px;z-index:2;left: 881px;top: 885px;background-image: url('${ctx}/images/bi/well_red.png');" onClick="toWellIndexs(this)"></div>  
<div style="position:absolute;width:42px;height:20px;z-index:2;left: 924px;top: 891px;font-size:18px;" >36165</div>	
	    	</s:if>
	    	<s:elseif test="#we.status==1">
				<div id="36165" style="cursor:pointer;position:absolute;width:42px;height:41px;z-index:2;left: 881px;top: 885px;background-image: url('${ctx}/images/bi/wellgreen.png');" onClick="toWellIndexs(this)"></div>  	
<div style="position:absolute;width:42px;height:20px;z-index:2;left: 924px;top: 891px;font-size:18px;" >36165</div>	    	
	    	</s:elseif> 
	    	
    	</s:if>
    	<s:if test="#we.wellNo=='36154'">
	    	<s:if test="#we.status==2">
	    	    <div id="36154" style="cursor:pointer;position:absolute;width:42px;height:41px;z-index:2;left: 601px;top: 973px;background-image: url('${ctx}/images/bi/well_red.png');" onClick="toWellIndexs(this)"></div>
<div style="position:absolute;width:42px;height:20px;z-index:2;left: 644px;top: 979px;font-size:18px;" >36154</div>	    	
	    	</s:if>
	    	<s:elseif test="#we.status==1">
	    		<div id="36154" style="cursor:pointer;position:absolute;width:42px;height:41px;z-index:2;left: 601px;top: 973px;background-image: url('${ctx}/images/bi/wellgreen.png');" onClick="toWellIndexs(this)"></div>
<div style="position:absolute;width:42px;height:20px;z-index:2;left: 644px;top: 979px;font-size:18px;" >36154</div>
			</s:elseif> 
			
    	</s:if>
    	<s:if test="#we.wellNo=='360155C'">
	    	<s:if test="#we.status==2">
				<div id="360155C" style="cursor:pointer;position:absolute;width:42px;height:41px;z-index:2;left: 1170px;top: 755px;background-image: url('${ctx}/images/bi/well_red.png');" onClick="toWellIndexs(this)"></div>
<div style="position:absolute;width:42px;height:20px;z-index:2;left: 1213px;top: 761px;font-size:18px;" >360155C</div>
	    	</s:if>
	    	<s:elseif test="#we.status==1">
	    		<div id="360155C" style="cursor:pointer;position:absolute;width:42px;height:41px;z-index:2;left: 1170px;top: 755px;background-image: url('${ctx}/images/bi/wellgreen.png');" onClick="toWellIndexs(this)"></div>
<div style="position:absolute;width:42px;height:20px;z-index:2;left: 1213px;top: 761px;font-size:18px;" >360155C</div>
    		</s:elseif> 
    		
		</s:if>
		<s:if test="#we.wellNo=='37171C'">
			<s:if test="#we.status==2">
				<div id="37171C" style="cursor:pointer;position:absolute;width:42px;height:41px;z-index:2;left: 1320px;top: 690px;background-image: url('${ctx}/images/bi/well_red.png');" onClick="toWellIndexs(this)"></div>
<div style="position:absolute;width:42px;height:20px;z-index:2;left: 1363px;top: 696px;font-size:18px;" >37171C</div>
			</s:if>
	    	<s:elseif test="#we.status==1">
	    		<div id="37171C" style="cursor:pointer;position:absolute;width:42px;height:41px;z-index:2;left: 1320px;top: 690px;background-image: url('${ctx}/images/bi/wellgreen.png');" onClick="toWellIndexs(this)"></div>
<div style="position:absolute;width:42px;height:20px;z-index:2;left: 1363px;top: 696px;font-size:18px;" >37171C</div>
	    	</s:elseif>    		
	    		
    	</s:if>
    	<s:if test="#we.wellNo=='36172'">
	    	<s:if test="#we.status==2">
	    		<div id="36172" style="cursor:pointer;position:absolute;width:42px;height:41px;z-index:2;left: 1016px;top: 818px;background-image: url('${ctx}/images/bi/well_red.png');" onClick="toWellIndexs(this)"></div>
<div style="position:absolute;width:42px;height:20px;z-index:2;left: 1059px;top: 824px;font-size:18px;" >36172</div>
	    	</s:if>
	    	<s:elseif test="#we.status==1">
	    		<div id="36172" style="cursor:pointer;position:absolute;width:42px;height:41px;z-index:2;left: 1016px;top: 818px;background-image: url('${ctx}/images/bi/wellgreen.png');" onClick="toWellIndexs(this)"></div>
<div style="position:absolute;width:42px;height:20px;z-index:2;left: 1059px;top: 824px;font-size:18px;" >36172</div>
	    	</s:elseif> 
	    		
    		
    	</s:if>
    	<s:if test="#we.wellNo=='36185'">
    		<s:if test="#we.status==2">
    			<div id="36185" style="cursor:pointer;position:absolute;width:42px;height:41px;z-index:2;left: 557px;top: 6px;background-image: url('${ctx}/images/bi/well_red.png');" onclick="toWellIndexs(this)"></div>
<div style="position:absolute;width:42px;height:20px;z-index:2;left: 600px;top: 12px;font-size:18px;" >36185</div>
    		</s:if>
	    	<s:elseif test="#we.status==1">
	    		<div id="36185" style="cursor:pointer;position:absolute;width:42px;height:41px;z-index:2;left: 557px;top: 6px;background-image: url('${ctx}/images/bi/wellgreen.png');" onclick="toWellIndexs(this)"></div>
<div style="position:absolute;width:42px;height:20px;z-index:2;left: 600px;top: 12px;font-size:18px" >36185</div>
	    	</s:elseif> 
	    		
    	</s:if>
		<s:if test="#we.wellNo=='360189'">
			<s:if test="#we.status==2">
				<div id="360189" style="cursor:pointer;position:absolute;width:42px;height:41px;z-index:2;left: 1295px;top: 42px;background-image: url('${ctx}/images/bi/well_red.png');" onclick="toWellIndexs(this)">360189</div>
<div style="position:absolute;width:42px;height:20px;z-index:2;left: 1296px;top: 30px;font-size:18px;" >360189</div>
			</s:if>
	    	<s:elseif test="#we.status==1">
	    		<div id="360189" style="cursor:pointer;position:absolute;width:42px;height:41px;z-index:2;left: 1295px;top: 44px;background-image: url('${ctx}/images/bi/wellgreen.png');" onclick="toWellIndexs(this)"></div>
<div style="position:absolute;width:42px;height:20px;z-index:2;left: 1295px;top: 30px;font-size:18px;" >360189</div>
	    	</s:elseif> 
	    		
		</s:if>
	   	<s:if test="#we.wellNo=='361168'">
		   	<s:if test="#we.status==2">
		   		<div id="361168" style="cursor:pointer;position:absolute;width:42px;height:41px;z-index:2;left: 524px;top: 374px;background-image: url('${ctx}/images/bi/well_red.png');" onclick="toWellIndexs(this)"></div>
<div  style="position:absolute;width:42px;height:20px;z-index:2;left: 567px;top: 380px;font-size:18px;">361168</div>
		   	</s:if>
	    	<s:elseif test="#we.status==1">
	    		<div id="361168" style="cursor:pointer;position:absolute;width:42px;height:41px;z-index:2;left: 524px;top: 374px;background-image: url('${ctx}/images/bi/wellgreen.png');" onclick="toWellIndexs(this)"></div>
<div  style="position:absolute;width:42px;height:20px;z-index:2;left: 567px;top: 380px;font-size:18px;">361168</div>
	    	</s:elseif> 
	    		
	    </s:if>
    </s:iterator>  
  <div id="j4_center" style="cursor:pointer;position:absolute; width:20px; height:22px; z-index:1; left: 329px; top: 626px;background-image: url('${ctx}/images/bi/center.png');" ></div>
    <div id="j4_right_down" style="cursor:pointer;position:absolute; width:20px; height:22px; z-index:1; left: 329px; top: 765px;background-image: url('${ctx}/images/bi/leftdown.png');" ></div>
    <div id="j4_right_up" style="cursor:pointer;position:absolute; width:20px; height:22px; z-index:1; left: 329px; top: 500px;background-image: url('${ctx}/images/bi/leftup.png');" ></div>
	
	 <div id="j1_left_up" style="cursor:pointer;position:absolute; width:20px; height:22px; z-index:1; left: 700px; top: 510px;background-image: url('${ctx}/images/bi/leftdown.png');" ></div>
    <div id="j1_right_up" style="cursor:pointer;position:absolute; width:20px; height:22px; z-index:1; left: 956px; top: 510px;background-image: url('${ctx}/images/bi/leftdown.png');" ></div>
	
	 <div id="j3_left_up" style="cursor:pointer;position:absolute; width:20px; height:22px; z-index:1; left: 940px; top: 146px;background-image: url('${ctx}/images/bi/rightdown.png');" ></div>
    <div id="j3_right_up" style="cursor:pointer;position:absolute; width:20px; height:22px; z-index:1; left: 1170px; top: 65px;background-image: url('${ctx}/images/bi/leftup.png');" ></div>
	
	  <div id="j5_left_down" style="cursor:pointer;position:absolute; width:20px; height:22px; z-index:1; left: 800px; top: 355px;background-image: url('${ctx}/images/bi/rightdown.png');" ></div>
   <div id="j5_right_up" style="cursor:pointer;position:absolute; width:20px; height:22px; z-index:1; left: 1052px; top: 237px;background-image: url('${ctx}/images/bi/leftup.png');" ></div>
	
	 <div id="j2_right_up" style="cursor:pointer;position:absolute; width:20px; height:22px; z-index:1; left: 1688px; top: 56px;background-image: url('${ctx}/images/bi/leftup.png');" ></div>
  </div>
</form>
</body>
</html>
