var ComponentsEditors=function(){var t=function(){jQuery().wysihtml5&&$(".wysihtml5").size()>0&&$(".wysihtml5").wysihtml5({stylesheets:["assets/global/plugins/bootstrap-wysihtml5/wysiwyg-color.css"]})},s=function(){$("#summernote_1").summernote({height:300})};return{init:function(){t(),s()}}}();jQuery(document).ready(function(){ComponentsEditors.init()});