var FormInputMask=function(){var a=function(){$("#mask_date").inputmask("d/m/y",{autoUnmask:!0}),$("#mask_date1").inputmask("d/m/y",{placeholder:"*"}),$("#mask_date2").inputmask("d/m/y",{placeholder:"dd/mm/yyyy"}),$("#mask_phone").inputmask("mask",{mask:"(999) 999-9999"}),$("#mask_tin").inputmask({mask:"99-9999999",placeholder:""}),$("#mask_number").inputmask({mask:"9",repeat:10,greedy:!1}),$("#mask_decimal").inputmask("decimal",{rightAlignNumerics:!1}),$("#mask_currency").inputmask("€ 999.999.999,99",{numericInput:!0}),$("#mask_currency2").inputmask("€ 999,999,999.99",{numericInput:!0,rightAlignNumerics:!1,greedy:!1}),$("#mask_ssn").inputmask("999-99-9999",{placeholder:" ",clearMaskOnLostFocus:!0})},n=function(){$("#input_ipv4").ipAddress(),$("#input_ipv6").ipAddress({v:6})};return{init:function(){a(),n()}}}();App.isAngularJsApp()===!1&&jQuery(document).ready(function(){FormInputMask.init()});