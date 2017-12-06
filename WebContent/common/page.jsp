<%@ page contentType="text/html;charset=UTF-8" %>
<div>
	<a class="gt-image-button" href="javascript:jumpPage(1);" title="首页">
		<div class="gt-first-page" style="padding-top: 5px;"></div> 
	</a>
	<a class="gt-image-button <s:if test="!page.hasPre">gt-button-disable</s:if>" 
		href="javascript:jumpPage(${page.prePage});" title="上一页">
		<div class="gt-prev-page" style="padding-top: 5px;"></div> 
	</a>
	<a class="gt-image-button <s:if test="!page.hasNext">gt-button-disable</s:if>"
		href="javascript:jumpPage(${page.nextPage});" title="下一页">
		<div class="gt-next-page" style="padding-top: 5px;"></div> 
	</a>
	<a class="gt-image-button" href="javascript:jumpPage(${page.totalPages});"
		href="javascript:jumpPage(1);" title="末页">
		<div class="gt-last-page" style="padding-top: 5px;"></div> 
	</a>
	<a class="gt-image-button" href="javascript:jumpAppointed();" title="跳转到指定的页">
		<div class="gt-goto-page" style="padding-top: 5px;"></div> 
	</a>
	<div class="gt-toolbar-text" style="line-height: 25px; display: inline;">
		第
	</div>
	<div style="display: inline;">
		<input id="appionted" class="gt-page-input" type="text" maxlength="5" value="${page.pageNo}" />
	</div>
	<div class="gt-toolbar-text" style="line-height: 25px; display: inline;">
		页
	</div>
	<div class="gt-button-split" style="line-height: 25px; display: inline;"></div>
	<div class="gt-toolbar-text" style="line-height: 25px; display: inline;">
		每页${page.pageSize}条
	</div>
	<div class="count_box">
		共${page.totalPages}页 ${page.totalCount}条数据
	</div>
</div>