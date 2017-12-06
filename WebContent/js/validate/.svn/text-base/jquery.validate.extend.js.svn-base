function checkidcard(num){  
    var len = num.length, re;  
    if (len == 15)  
        re = new RegExp(/^(\d{6})()?(\d{2})(\d{2})(\d{2})(\d{3})$/);  
    else if (len == 18)  
        re = new RegExp(/^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})(\d)$/);  
    else{  
        //alert("请输入15或18位身份证号,您输入的是 "+len+ "位");   
        return false;  
    }  
    var a = num.match(re);  
    if (a != null){  
        if (len==15){  
            var D = new Date("19"+a[3]+"/"+a[4]+"/"+a[5]);  
            var B = D.getYear()==a[3]&&(D.getMonth()+1)==a[4]&&D.getDate()==a[5];  
        }else{  
            var D = new Date(a[3]+"/"+a[4]+"/"+a[5]);  
            var B = D.getFullYear()==a[3]&&(D.getMonth()+1)==a[4]&&D.getDate()==a[5];  
        }  
        if (!B){  
            //alert("输入的身份证号 "+ a[0] +" 里出生日期不对！");   
            return false;  
        }  
    }  
  
    return true;  
} 

//添加验证方法 (身份证号码验证)  
jQuery.validator.addMethod("cardNo", function(value, element) {     
    return this.optional(element) || checkidcard(value);     
}, "请正确输入您的身份证号码");   