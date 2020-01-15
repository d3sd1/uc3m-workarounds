/* It uses a custom event, that is set after preloader finished, so it does not conflict with another menu stuff */
$("body").on("preloaderFinished", function () {
    "use strict";
    /* ADD ICON TO MOBILE MENU FOR EXPAND SUBMENUS */
    $('.menu > ul > li:has( > ul)').addClass('menu-dropdown-icon');

    /* CHECK IF IT'S MEGA MENU OR JUST DROPDOWN MENU */
    $('.menu > ul > li > ul:not(:has(ul))').addClass('normal-sub');

    /* CHECK IF IT'S MOBILE DEVICE. IF IT'S A PC, SHOW MENU ON HOVER. ++ */
    $(".menu > ul").before("<a href=\"#\" class=\"menu-mobile\">Menu</a>");
    $(".menu > ul > li").hover(
            function (e) {
                if ($(window).width() > 943) {
                    $(this).children("ul").fadeIn(150);
                    e.preventDefault();
                }
            }, function (e) {
        if ($(window).width() > 943) {
            $(this).children("ul").fadeOut(150);
            e.preventDefault();
        }
    }
    );
    /*  CHECK IF IT'S MOBILE DEVICE. IF IT'S A MOBILE, SHOW MENU ON CLICK/TOUCH. */
    $(".menu > ul > li").click(function () {
        if ($(window).width() < 943) {
            $(this).children("ul").fadeToggle(150);
        }
    });
    $(".menu-mobile").click(function (e) {
        $(".menu > ul").toggleClass('show-on-mobile');
        e.preventDefault();
    });
    /* IF IT'S NOT A MOBILE DEVICE, STICK MENU TO TOP */
    function checkStickMenu()
    {
        if($(window).width() > 943) {
            /* Sticky menu since it's gonna be so good on non-mobile devices */
            $(".menu-container").sticky({
                topSpacing: 0,
                zIndex: 10
            });
        }
        else
        {
            $(".menu-container").unstick(); /* DON'T Sticky menu to top since it would feel so weird on mobile devices. */
        }
    }
    /* Check if it has to be sticked after resize and after load */
    checkStickMenu();
    $(window).resize(function () {
        checkStickMenu();
    });
});