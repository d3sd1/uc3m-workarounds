/*
 * 
 * This javascript is common for adding and editing users. But they both have their own ajax send method's.
 * 
 */
function manageasg_CloseModal()
{
    resetModalFields($asigs_modal.manage["selector"]);
    /* Reset modal options to delete */
    $asigs_modal.manage["selector"].attr($asigs_modal.attributes.asgid,"");
    $asigs_modal.manage["selector"].attr($asigs_modal.attributes.action,"");
    $asigs_modal.manage["selector"].modal('close');
}
function manageasg_OpenModal(id)
{
    /* Open modal a first, so the form is generated */
    $asigs_modal.manage["selector"].modal({
        dismissible: false
    });
    $asigs_modal.manage["selector"].modal('open');
    if(id != -1) /* IF IT'S BEING EDITED, RENDER CONTENT. ID -1 means THERE IS NO PREVIOUS SUBJECT */
    {
        $asigs_modal.manage["selector"].attr($asigs_modal.attributes.action,"edit");
        var $asgBoxSelector = $('#asg-' + id),
            oldAgeStatus = ($asgBoxSelector.children("td:nth-child(4)").text().toLowerCase().includes("mayor") ? "true":"false");
        $asigs_modal.manage.label("id").val(id);
        $asigs_modal.manage.label("name").val($asgBoxSelector.children("td:nth-child(2)").text());
        $asigs_modal.manage.label("course").val($asgBoxSelector.children("td:nth-child(3)").text());
        $asigs_modal.manage.label("cicle").val($asgBoxSelector.children("td:nth-child(3)").text());
    }
    else /* We are adding users... let's put a fake id and clear for if there is any data on form */
    {
        resetModalFields($asigs_modal.manage["selector"]);
        $asigs_modal.manage.label("id").val(parseInt(getMaxDataId())+1);
        $asigs_modal.manage["selector"].attr($asigs_modal.attributes.action,"add");
    }
    /* Render materialize fields, so we tell it that we updated fields */
    $asigs_modal.manage.label("name").characterCounter();
    $asigs_modal.manage.label("course").characterCounter();
    $asigs_modal.manage.label("cicle").characterCounter();
    Materialize.updateTextFields();
}
/* This function checks the action that is needed on this case: add or edit */
function manageasg_CheckAction()
{
    /* CHECK IF FORM IS FULLY COMPLETED */
    var error_nodatainput = false;
    if($asigs_modal.manage.label("id").val() == "")
    {
        error_nodatainput = true;
    }
    if($asigs_modal.manage.label("name").val() == "")
    {
        error_nodatainput = true;
    }
    if($asigs_modal.manage.label("course").val() == "")
    {
        error_nodatainput = true;
    }
    if($asigs_modal.manage.label("cicle").val() == "")
    {
        error_nodatainput = true;
    }
    
    if(!error_nodatainput)
    {
        /* Check the action that has been set on x_OpenModal function */
        var act = $asigs_modal.manage["selector"].attr($asigs_modal.attributes.action);
        if(act == "add")
        {
            ajax_Addasg();
        }
        else if(act == "edit")
        {
            ajax_UpdateUser();
        }
        else
        {
            Materialize.toast('<span>Ha ocurrido un error interno en las modales.</span>', 5000, 'rounded');
            manageasg_CloseModal();
        }
    }
    else
    {
        Materialize.toast('<span>Por favor, completa todos los campos.</span>', 5000, 'rounded');
    }
}
function ajax_Addasg()
{
    $.ajax({
        url: "asignaturas",
        type: "POST",
        data: { 
            "action": AJAX_ADD_PARAM,
            "name": $asigs_modal.manage.label("name").val(),
            "course":$asigs_modal.manage.label("course").val(),
            "cicle": $asigs_modal.manage.label("cicle").val()
        },
        error: function(data)
        {
            var info = JSON.parse(data);
            Materialize.toast('<span>Ha ocurrido un error al agregar la asignatura: ' + info["reason"] + '</span>', 5000, 'rounded');
        },
        success: function(data){
            var info = JSON.parse(data);
            if(info['success'] == true)
            {
                var uinfo = info["data"];
                /* Update HTML entry and fade effect for the field  */
                var newCell = $dataTable.row.add( [
                    uinfo["id"],
                    uinfo["name"],
                    uinfo["course"],
                    uinfo["cicle"],
                    "<a class=\"dropdown-button btn\" href=\"#\" data-activates=\"dropdown-asg-" + uinfo["id"] + "\">Acciones</a><ul id=\"dropdown-asg-" + uinfo["id"] + "\" class=\"dropdown-content\"><li><a href=\"#\" onclick=\"delasgConfirm_OpenModal(" + uinfo["id"] + ")\">Eliminar</a></li><li><a href=\"#\" onclick=\"manageasg_OpenModal(" + uinfo["id"] + ")\">Editar</a></li></ul>"
                ] ).draw().node();
                $(newCell).attr("id","asg-" + info["id"]);
                Materialize.toast('<span>Asignatura agregada correctamente (ID ' + uinfo["id"] + ').</span>', 5000, 'rounded');
            }
            else
            {
                Materialize.toast('<span>Ha ocurrido un error al agregar la asignatura: ' + info["reason"] + '</span>', 5000, 'rounded');
            }
            manageasg_CloseModal();
        }
    });
}
function ajax_UpdateUser()
{
    $.ajax({
        url: "asignaturas",
        error: function(data)
        {
            var info = JSON.parse(data);
            Materialize.toast('<span>Ha ocurrido un error al modificar la asignatura: ' + info["reason"] + '</span>', 5000, 'rounded');
        },
        type: "POST",
        data: { 
            "action": AJAX_UPDATE_PARAM,
            "id": $asigs_modal.manage.label("id").val(),
            "name": $asigs_modal.manage.label("name").val(),
            "course": $asigs_modal.manage.label("course").val(),
            "cicle": $asigs_modal.manage.label("cicle").val()
        },
        success: function(data){
            var info = JSON.parse(data);
            if(info['success'] == true)
            {
                var uinfo = info["data"];
                /* Update HTML entry and fade effect for the field  */
                
                $dataTable.row('#asg-' + $asigs_modal.manage.label("id").val()).data([
                    uinfo["id"],
                    uinfo["name"],
                    uinfo["course"],
                    uinfo["cicle"],
                    "<a class=\"dropdown-button btn\" href=\"#\" data-activates=\"dropdown-asg-" + uinfo["id"] + "\">Acciones</a><ul id=\"dropdown-asg-" + uinfo["id"] + "\" class=\"dropdown-content\"><li><a href=\"#\" onclick=\"delasgConfirm_OpenModal(" + uinfo["id"] + ")\">Eliminar</a></li><li><a href=\"#\" onclick=\"manageasg_OpenModal(" + uinfo["id"] + ")\">Editar</a></li></ul>"
                ]).draw();
                Materialize.toast('<span>Asignatura modificado correctamente.</span>', 5000, 'rounded');
            }
            else
            {
                Materialize.toast('<span>Ha ocurrido un error al modificar la asignatura: ' + info["reason"] + '</span>', 5000, 'rounded');
            }
            manageasg_CloseModal();
        }
    });
}