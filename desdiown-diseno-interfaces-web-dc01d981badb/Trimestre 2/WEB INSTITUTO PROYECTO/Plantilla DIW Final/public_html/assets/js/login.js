var formModalsTemplate = `
<!-- BEGIN MODAL WINDOWS -->
<div class="modal-useractions"> <!-- this is the entire modal form, including the background -->
    <div class="modal-container"> <!-- this is the container wrapper -->
        <ul class="modal-changeaction">
            <li><a href="#0">Conexión</a></li>
            <li><a href="#0">Registro</a></li>
        </ul>

        <!-- BEGIN MODAL LOGIN WINDOW -->
        <div id="modal-login">
            <form class="modal-form" id="loginForm">
                <p class="fieldset">
                    <label class="image-replace label-email">Correo electrónico</label>
                    <input class="full-width has-padding has-border" type="email" autocomplete="off" name="login_email" placeholder="Correo electrónico">
                    <span class="label-errormsg"></span>
                </p>

                <p class="fieldset">
                    <label class="image-replace label-password" for="signin-password">Contraseña</label>
                    <input class="full-width has-padding has-border" type="password" name="login_password" placeholder="Contraseña">
                    <span class="label-errormsg"></span>
                </p>

                <p class="fieldset">
                    <input type="checkbox" checked>
                    <label for="remember-me">Recuérdame</label>
                </p>

                <p class="fieldset">
                    <input class="full-width" type="submit" value="Conectar">
                </p>
                <p class="modal-form-bottom-message"><a href="#0">¿Contraseña olvidada?</a></p>
            </form>

        </div>
        <!-- END MODAL LOGIN WINDOW -->

        <!-- BEGIN MODAL REGISTER WINDOW -->
        <div id="openmodal-register">
            <form class="modal-form">
                <p class="fieldset">
                    <label class="image-replace label-user">Nombre y apellidos</label>
                    <input class="full-width has-padding has-border" type="text" autocomplete="off" name="register_name" placeholder="Nombre y apellidos">
                    <span class="label-errormsg"></span>
                </p>

                <p class="fieldset">
                    <label class="image-replace label-email">Correo electrónico</label>
                    <input class="full-width has-padding has-border" type="email" autocomplete="off" name="register_email" placeholder="Correo electrónico">
                    <span class="label-errormsg"></span>
                </p>

                <p class="fieldset">
                    <label class="image-replace label-password">Contraseña</label>
                    <input class="full-width has-padding has-border" type="password" name="register_password" placeholder="Contraseña">
                    <span class="label-errormsg"></span>
                    <a href="#0" class="hide-password">Insegura</a>
                </p>

                <p class="fieldset">
                    <input type="checkbox" checked>
                    <label for="accept-terms">Estoy de acuerdo con los <a href="terms.html">Términos y condiciones</a></label>
                </p>

                <p class="fieldset">
                    <input class="full-width has-padding" type="submit" value="Finalizar registro">
                </p>
            </form>
        </div>
        <!-- END MODAL REGISTER WINDOW -->

        <!-- BEGIN MODAL RESET PASSWORD WINDOW -->
        <div id="openmodal-resetpass">
            <p class="modal-form-message">¿Contraseña olvidada? No hay problema, tan sólo introduce la dirección de correo electrónico de tu cuenta y te enviaremos información sobre cómo restablecerla.</p>

            <form class="modal-form">
                <p class="fieldset">
                    <label class="image-replace label-email">Correo electrónico</label>
                    <input class="full-width has-padding has-border" type="email" autocomplete="off" name="reset_email" placeholder="Correo electrónico">
                    <span class="label-errormsg">Error message here!</span>
                </p>

                <p class="fieldset">
                    <input class="full-width has-padding" type="submit" value="Enviar instrucciones">
                </p>
                <p class="modal-form-bottom-message"><a href="#0">¿Quieres conectarte?</a></p>
            </form>

        </div>
        <!-- END MODAL RESET PASSWORD WINDOW -->
    </div> <!-- modal-container -->
</div>
<!-- END MODAL WINDOWS -->`;

/* AVAILABLE USERS */
var users = [
    {
        "mail": "andrei@gmail.com",
        "name": "Andrei Garcia Cuadra",
        "password": "12345a",
        "rank": "alumn"
    },
    {
        "mail": "santi@gmail.com",
        "name": "Santiago alonso",
        "password": "12345a",
        "rank": "teacher"
    },
    {
        "mail": "admin@gmail.com",
        "name": "root",
        "password": "12345a",
        "rank": "admin"
    }
];
/* USER ACTION FUNCTIONS */
function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+ d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}
function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i <ca.length; i++)
    {
        var c = ca[i];
        while (c.charAt(0) == ' ')
        {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0)
        {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}
function checkCookie(cname) {
    return (getCookie(cname) != "" ? true:false);
}
function deleteCookie(cname) {
    document.cookie = cname +'=; Path=/; Expires=Thu, 01 Jan 1970 00:00:01 GMT;';
}
function userLogin(name,mail,rank)
{
    setCookie("user",name, 7);
    setCookie("mail",mail, 7);
    setCookie("rank",rank, 7);
}
function userLogout()
{
    deleteCookie("user");
    deleteCookie("mail");
    deleteCookie("rank");
}
function userIsLoggedIn()
{
    if(checkCookie("user"))
    {
        return true;
    }
    else
    {
        return false;
    }
}
function updateUserPermissionsMenu()
{
    /* UPDATE MENU FOR THE USER */
    $("*[data-trigger='limitedaccess']").each(function() {
        /* HIDE THINGS THAT ARE FOR NON LOGGED USERS IF IT'S LOGGED IN */
        if($(this).attr("data-requires") == "logged_out" && userIsLoggedIn())
        {
            $(this).attr("style","display:none");
        }

        /* HIDE THINGS THAT ARE FOR LOGGED USERS IF IT'S LOGGED OUT */
        if($(this).attr("data-requires") == "logged_in" && !userIsLoggedIn())
        {
            $(this).attr("style","display:none");
        }
        else /* USER IS LOGGED IN */
        {
            $(this).children("a").text($(this).children("a").text().replace("{{USER_NAME}}",getCookie("user")));
            /* CHECK MINIMUM REQUIRED USER RANK */
            if($(this).attr("data-requires-rank") == "admin" && getCookie("rank") != "admin")
            {
                $(this).attr("style","display:none"); /* HIDE ADMIN PANEL TO NON-ADMINS */
            }
            if($(this).attr("data-requires-rank") == "teacher" && getCookie("rank") != "teacher")
            {
                $(this).attr("style","display:none"); /* HIDE TEACHER PANEL TO NON-TEACHERS */
            }
            if($(this).attr("data-requires-rank") == "alumn" && getCookie("rank") != "alumn")
            {
                $(this).attr("style","display:none"); /* HIDE ALUMN PANEL TO NON-ALUMNS */
            }
        }
    });
}
function validateEmail(email) {
    /* REGEX Substraid of stackoverflow */
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}
$(document).ready(function() {
    updateUserPermissionsMenu();
    if(!userIsLoggedIn())
    {
        /* Append modals html to the body */
        $("body").append(formModalsTemplate);
        /* MODAL VARS */
        var formModal = $('.modal-useractions'),
                formLogin = formModal.find('#modal-login'),
                formSignup = formModal.find('#openmodal-register'),
                formForgotPassword = formModal.find('#openmodal-resetpass'),
                formModalTab = $('.modal-changeaction'),
                tabLogin = formModalTab.children('li').eq(0).children('a'),
                tabSignup = formModalTab.children('li').eq(1).children('a'),
                forgotPasswordLink = formLogin.find('.modal-form-bottom-message a'),
                backToLoginLink = formForgotPassword.find('.modal-form-bottom-message a');

        //open sign-up form
        $(document).on('click', '.openmodal-register', signup_selected);
        //open login-form form
        $(document).on('click', '.openmodal-useractions', login_selected);

        //close modal
        formModal.on('click', function(event){
            if( $(event.target).is(formModal) || $(event.target).is('.cd-close-form') ) {
                formModal.removeClass('is-visible');
            }	
        });
        //switch from a tab to another
        formModalTab.on('click', function(event) {
            event.preventDefault();
            ( $(event.target).is( tabLogin ) ) ? login_selected() : signup_selected();
        });

        //show forgot-password form 
        forgotPasswordLink.on('click', function(event){
            event.preventDefault();
            forgot_password_selected();
        });

        //back to login from the forgot-password form
        backToLoginLink.on('click', function(event){
            event.preventDefault();
            login_selected();
        });

        function login_selected(){
            formModal.addClass('is-visible');
            formLogin.addClass('is-selected');
            formSignup.removeClass('is-selected');
            formForgotPassword.removeClass('is-selected');
            tabLogin.addClass('selected');
            tabSignup.removeClass('selected');
        }

        function signup_selected(){
            formModal.addClass('is-visible');
            formLogin.removeClass('is-selected');
            formSignup.addClass('is-selected');
            formForgotPassword.removeClass('is-selected');
            tabLogin.removeClass('selected');
            tabSignup.addClass('selected');
        }

        function forgot_password_selected(){
            formLogin.removeClass('is-selected');
            formSignup.removeClass('is-selected');
            formForgotPassword.addClass('is-selected');
        }

        function clearInputErrors(container)
        {
            $('input').each(function(index) {
                $(this).removeClass('has-error').next('span').removeClass('is-visible');
            });
        }
        /* LOGIN */
        formLogin.on('submit', function(event){
            event.preventDefault();
            clearInputErrors(formLogin);
            var emailLabel = formLogin.find('input[name="login_email"]'),
            passwordLabel = formLogin.find('input[name="login_password"]');
            /* WEIRD LOGIN. It checks if the user exists on the users object and that stuff. */
            for(var i = 0; i < users.length; i++)
            {
                var user = users[i];
                if(user.mail == emailLabel.val())
                {
                    if(user.password == passwordLabel.val())
                    {
                        userLogin(user.name,user.mail,user.rank);
                        location.reload();
                    }
                    else
                    {
                        passwordLabel.addClass('has-error').next('span').addClass('is-visible').text("La contraseña introducida es inválida.");
                    }
                    break;
                }
                else
                {
                    emailLabel.addClass('has-error').next('span').addClass('is-visible').text("Email no encontrado.");
                }
            }
        });
        /* REGISTER */
        formSignup.on('submit', function(event){
            event.preventDefault();
            clearInputErrors(formSignup);
            var nameLabel = formSignup.find('input[name="register_name"]'),
            emailLabel = formSignup.find('input[name="register_email"]'),
            passwordLabel = formSignup.find('input[name="register_password"]');
            if(nameLabel.val().length != 0)
            {
                if(validateEmail(emailLabel.val()))
                {
                    if(passwordLabel.val().length >= 8)
                    {
                        userLogin(nameLabel.val(),emailLabel.val(),"alumn");
                        location.reload();
                    }
                    else
                    {
                        passwordLabel.addClass('has-error').next('span').addClass('is-visible').text("La contraseña introducida es demasiado insegura.");
                    }
                }
                else
                {
                    emailLabel.addClass('has-error').next('span').addClass('is-visible').text("Email no válido.");
                }
            }
            else
            {
                nameLabel.addClass('has-error').next('span').addClass('is-visible').text("Introduce un usuario.");
            }
        });
        formSignup.find('input[name="register_password"]').keyup(function() {
            if($(this).val().length >= 8)
            {
                formSignup.find(".hide-password").text("Segura");
            }
            else
            {
                formSignup.find(".hide-password").text("Insegura");
            }
        });
        /* REMOVE ERRORS AFTER JOIN AN INPUT */
        formModal.find('input').on('blur', function(event){
            clearInputErrors(formModal);
        });
        formSignup.find('input').on('blur', function(event){
            clearInputErrors(formModal);
        });
    }
});