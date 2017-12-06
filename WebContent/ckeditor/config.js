/*
Copyright (c) 2003-2011, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function(config) {
	// Define changes to default configuration here. For example:
	// config.language = 'en';
	// config.skin = 'Kama';
	// config.uiColor = '#AADC6E';
	config.extraPlugins = 'autogrow';
	config.autoGrow_maxHeight = 400;
	
	config.toolbar = 
		[  
           ['Print','Preview'],  
           ['Cut','Copy','Paste','PasteText','PasteFromWord','-','Undo','Redo'],  
           ['Find','Replace','-','SelectAll','-','SpellChecker', 'Scayt'],  
           ['Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 'HiddenField'],  
           //'/',  
           ['Bold','Italic','Underline','Strike','-','Subscript','Superscript','-','RemoveFormat'],  
            ['NumberedList','BulletedList','-','Outdent','Indent','Blockquote'],  
            ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],  
            ['Link','Unlink','Anchor'],  
           ['Table','HorizontalRule','SpecialChar','PageBreak'],  
           //'/',  
            ['Styles','Format','Font','FontSize'],  
            ['TextColor','BGColor'],  
            ['Maximize']
        ]; 
	config.font_names =
		'Arial/Arial, Helvetica, sans-serif;' +
		'Comic Sans MS/Comic Sans MS, cursive;' +
		'Courier New/Courier New, Courier, monospace;' +
		'Georgia/Georgia, serif;' +
		'Lucida Sans Unicode/Lucida Sans Unicode, Lucida Grande, sans-serif;' +
		'Tahoma/Tahoma, Geneva, sans-serif;' +
		'Times New Roman/Times New Roman, Times, serif;' +
		'Trebuchet MS/Trebuchet MS, Helvetica, sans-serif;' +
		'Verdana/Verdana, Geneva, sans-serif;' +
		'宋体/宋体;黑体/黑体;仿宋/仿宋_GB2312;楷体/楷体_GB2312;隶书/隶书;幼圆/幼圆;微软雅黑/微软雅黑';
};
