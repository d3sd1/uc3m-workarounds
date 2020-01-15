/* SLIDESHOW BACKGROUND WITH OPTIMIZED IMAGES, USING VEGAS FOR JQUERY. */
$(function () {
    $('body').vegas({
        slides: [
            {src: 'assets/images/backgrounds/1.jpg'},
            {src: 'assets/images/backgrounds/2.jpg'},
            {src: 'assets/images/backgrounds/3.jpg'},
            {src: 'assets/images/backgrounds/4.jpg'},
            {src: 'assets/images/backgrounds/5.jpg'},
            {src: 'assets/images/backgrounds/6.jpg'},
            {src: 'assets/images/backgrounds/7.jpg'},
            {src: 'assets/images/backgrounds/8.jpg'},
            {src: 'assets/images/backgrounds/9.jpg'},
            {src: 'assets/images/backgrounds/10.jpg'},
            {src: 'assets/images/backgrounds/11.jpg'},
            {src: 'assets/images/backgrounds/12.jpg'},
            {src: 'assets/images/backgrounds/13.jpg'}
        ],
        timer: false,
        autoplay: true,
        loop: true,
        delay: 10000,
        cover: true,
        transition: 'fade',
        transitionDuration: 5000,
        overlay: true
    });
});