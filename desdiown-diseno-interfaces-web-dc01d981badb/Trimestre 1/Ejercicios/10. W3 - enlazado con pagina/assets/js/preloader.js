/* Execute after page and DOM loaded */
$(window).on('load', function () {
    /* Remove preloader boxes with animation */
    $('#status').fadeOut();
    $('#preloader').delay(350).fadeOut('slow');
    /* Add scroll to page by removing the class */
    $('body').delay(350).removeClass("hidescroll");
    /* Trigger preloaderFinished event for some needed JQuery functions, but SLEEP BEFORE, SO WE WAIT FOR THE DELAYS TO END */
    setTimeout(function() {
        $("body").trigger("preloaderFinished");
        $('body').removeClass("preloader");
    }, 400);
})