function getTrueDay(year_month){
			//alert(year_month);
			if(!(year_month==""||year_month==null)){
			
			var arr = year_month.split("-");
			if(arr.length > 2){
				var year = arr[0];
				var month = arr[1];
				var day = arr[2];
			}
			var currDate=new Date();
			 var new_year =  currDate.getFullYear();    //取当前的年份  
			 var new_month =  currDate.getMonth();//取下一个月的第一天，方便计算（最后一天不固定）
			 var new_day=currDate.getDate();
			 
			 new_month=new_month+1;
			 if((year==new_year)&&(month==new_month)){
			 	return true;
			 }else if((month==12)&&(new_month==1)&&(year==(new_year-1))&&(day==31)){
			 	return true;
			 }else if((month==(new_month-1))&&(year==new_year)){
			 	if(((month==1)||(month==3)||(month==5)||(month==7)||(month==8)||(month==10))&&(day==31)){
			 		return true;
			 	}else if(((month==4)||(month==6)||(month==9)||(month==11))&&(day==30)){
			 		return true;
			 	}else if((month==2)&&((year%4==0)||(year%100==0)||(year%400==0))&&(day==28)){
			 		return true;
			 	}else if((month==2)&&(year%4!=0)&&(day==29)){
			 		return true;
			 	}else{
			 		showMessage('只能选择本月日期查询(上月最后一天除外)');
			 		return false;
			 	}
			 } else{
			 	showMessage('只能选择本月日期查询(上月最后一天除外)');
			 	return false;
			 }
			}else{
				showMessage('请填写日期');
				return false;
			}
		}   