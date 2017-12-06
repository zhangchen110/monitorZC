<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title></title>
		<%@ include file="/common/meta.jsp"%>
  	</head>
  
  	<body>
	    <form action="ckeditor.do" method="post">
			<p>
				<label for="editor1">CKEditor</label>
				<textarea class="ckeditor" cols="80" id="editor" name="editor" rows="10">
				&lt;p&gt;This is some &lt;strong&gt;sample text&lt;/strong&gt;. You are using &lt;a href="http://ckeditor.com/"&gt;CKEditor&lt;/a&gt;.&lt;/p&gt;
				</textarea>
			</p>
			<p>
				<input type="submit" value="Submit" />
			</p>
		</form>
  	</body>
</html>
