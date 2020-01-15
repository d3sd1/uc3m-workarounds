/*
 * 
 * This javascript is common for adding and editing users. But they both have their own ajax send method's.
 * 
 */
function manageUsr_CloseModal()
{
    resetModalFields($users_modal.manage["selector"]);
    /* Reset modal options to delete */
    $users_modal.manage["selector"].attr($users_modal.attributes.userid,"");
    $users_modal.manage["selector"].attr($users_modal.attributes.action,"");
    $users_modal.manage["selector"].modal('close');
}
function manageUsr_OpenModal(id)
{
    /* Open modal a first, so the form is generated */
    $users_modal.manage["selector"].modal({
        dismissible: false
    });
    $users_modal.manage["selector"].modal('open');
    /* Render calendar */
    $users_modal.manage.label("birthdate").pickadate({
        selectMonths: true,
        selectYears: 15,
        today: 'Hoy',
        clear: 'Limpiar',
        close: 'Aceptar',
        closeOnSelect: true,
        format: 'yyyy-mm-dd'
    });
    if(id != -1) /* IF IT'S BEING EDITED, RENDER CONTENT. ID -1 means THERE IS NO PREVIOUS USER */
    {
        $users_modal.manage["selector"].attr($users_modal.attributes.action,"edit");
        var $usrBoxSelector = $('#usr-' + id),
            oldAgeStatus = ($usrBoxSelector.children("td:nth-child(4)").text().toLowerCase().includes("mayor") ? "true":"false");
        $users_modal.manage.label("id").val(id);
        $users_modal.manage.label("name").val($usrBoxSelector.children("td:nth-child(2)").text());
        $users_modal.manage.label("birthdate").val($usrBoxSelector.children("td:nth-child(3)").text());
        
        $users_modal.manage.label("oldage").children('option[value="' + oldAgeStatus + '"]').attr("selected", "selected");
    }
    else /* We are adding users... let's put a fake id and clear for if there is any data on form */
    {
        resetModalFields($users_modal.manage["selector"]);
        $users_modal.manage.label("id").val(parseInt(getMaxDataId())+1);
        $users_modal.manage["selector"].attr($users_modal.attributes.action,"add");
    }
    /* Render materialize fields, so we tell it that we updated fields */
    $users_modal.manage.label("name").characterCounter();
    $users_modal.manage.label("oldage").material_select();
    Materialize.updateTextFields();
}
/* This function checks the action that is needed on this case: add or edit */
function manageUsr_CheckAction()
{
    /* CHECK IF FORM IS FULLY COMPLETED */
    var error_nodatainput = false;
    if($users_modal.manage.label("id").val() == "")
    {
        error_nodatainput = true;
    }
    if($users_modal.manage.label("name").val() == "")
    {
        error_nodatainput = true;
    }
    if($users_modal.manage.label("birthdate").val() == "")
    {
        error_nodatainput = true;
    }
    if($users_modal.manage.label("oldage").val() == "")
    {
        error_nodatainput = true;
    }
    
    if(!error_nodatainput)
    {
        /* Check the action that has been set on x_OpenModal function */
        var act = $users_modal.manage["selector"].attr($users_modal.attributes.action);
        if(act == "add")
        {
            ajax_AddUsr();
        }
        else if(act == "edit")
        {
            ajax_UpdateUser();
        }
        else
        {
            Materialize.toast('<span>Ha ocurrido un error interno en las modales.</span>', 5000, 'rounded');
            manageUsr_CloseModal();
        }
    }
    else
    {
        Materialize.toast('<span>Por favor, completa todos los campos.</span>', 5000, 'rounded');
    }
}
function ajax_AddUsr()
{
    $.ajax({
        url: "alumnos",
        type: "POST",
        data: { 
            "action": AJAX_ADD_PARAM,
            "name": $users_modal.manage.label("name").val(),
            "birthdate":$users_modal.manage.label("birthdate").val(),
            "oldage": $users_modal.manage.label("oldage").val()
        },
        error: function(data)
        {
            var info = JSON.parse(data);
            Materialize.toast('<span>Ha ocurrido un error al agregar el usuario: ' + info["reason"] + '</span>', 5000, 'rounded');
        },
        success: function(data){
            var info = JSON.parse(data);
            console.log(data);
            console.log(info);
            if(info['success'] == true)
            {
                var uinfo = info["data"];
                /* Update HTML entry and fade effect for the field  */
                var newCell = $dataTable.row.add( [
                    uinfo["id"],
                    uinfo["name"],
                    uinfo["birthdate"],
                    (uinfo["oldage"] == "true" ? "Mayor de edad.":"Menor de edad."),
                    "<a class=\"dropdown-button btn\" href=\"#\" data-activates=\"dropdown-user-" + uinfo["id"] + "\">Acciones</a><ul id=\"dropdown-user-" + uinfo["id"] + "\" class=\"dropdown-content\"><li><a href=\"#\" onclick=\"delUsrConfirm_OpenModal(" + uinfo["id"] + ")\">Eliminar</a></li><li><a href=\"#\" onclick=\"manageUsr_OpenModal(" + uinfo["id"] + ")\">Editar</a></li></ul>"
                ] ).draw().node();
                $(newCell).attr("id","usr-" + info["id"]);
                Materialize.toast('<span>Usuario agregado correctamente (ID ' + uinfo["id"] + ').</span>', 5000, 'rounded');
            }
            else
            {
                Materialize.toast('<span>Ha ocurrido un error al agregar el usuario: ' + info["reason"] + '</span>', 5000, 'rounded');
            }
            manageUsr_CloseModal();
        }
    });
}
function ajax_UpdateUser()
{
    $.ajax({
        url: "alumnos",
        error: function(data)
        {
            var info = JSON.parse(data);
            Materialize.toast('<span>Ha ocurrido un error al modificar el usuario: ' + info["reason"] + '</span>', 5000, 'rounded');
        },
        type: "POST",
        data: { 
            "action": AJAX_UPDATE_PARAM,
            "id": $users_modal.manage.label("id").val(),
            "name": $users_modal.manage.label("name").val(),
            "birthdate": $users_modal.manage.label("birthdate").val(),
            "oldage": $users_modal.manage.label("oldage").val()
        },
        success: function(data){
            var info = JSON.parse(data);
            if(info['success'] == true)
            {
                var uinfo = info["data"];
                /* Update HTML entry and fade effect for the field  */
                $dataTable.row('#usr-' + $users_modal.manage.label("id").val()).data([
                    uinfo["id"],
                    uinfo["name"],
                    uinfo["birthdate"],
                    (uinfo["oldage"] == "true" ? "Mayor de edad.":"Menor de edad."),
                    "<a class=\"dropdown-button btn\" href=\"#\" data-activates=\"dropdown-user-" + uinfo["id"] + "\">Acciones</a><ul id=\"dropdown-user-" + uinfo["id"] + "\" class=\"dropdown-content\"><li><a href=\"#\" onclick=\"delUsrConfirm_OpenModal(" + uinfo["id"] + ")\">Eliminar</a></li><li><a href=\"#\" onclick=\"manageUsr_OpenModal(" + uinfo["id"] + ")\">Editar</a></li></ul>"
                ]).draw();
                Materialize.toast('<span>Usuario modificado correctamente.</span>', 5000, 'rounded');
            }
            else
            {
                Materialize.toast('<span>Ha ocurrido un error al modificar el usuario: ' + info["reason"] + '</span>', 5000, 'rounded');
            }
            manageUsr_CloseModal();
        }
    });
}