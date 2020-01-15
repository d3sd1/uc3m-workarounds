function manageGrade_CloseModal()
{
    resetModalFields($notes_modal.manage["selector"]);
    /* Reset modal options to delete */
    $notes_modal.manage["selector"].attr($notes_modal.attributes.alumid,"");
    $notes_modal.manage["selector"].attr($notes_modal.attributes.asigid,"");
    $notes_modal.manage["selector"].attr($notes_modal.attributes.grade,"");
    $notes_modal.manage["selector"].modal('close');
}
function manageGrade_OpenModal(alid,asgid)
{
    /* Open modal a first, so the form is generated */
    $notes_modal.manage["selector"].modal({
        dismissible: false
    });
    $.ajax({
        url: "notas",
        type: "POST",
        data: { 
            "action": AJAX_CHECK_PARAM,
            "alumid": alid,
            "asigid": asgid
        },
        error: function(data)
        {
            var info = JSON.parse(data);
            Materialize.toast('<span>Ha ocurrido un error al actualizar la nota del usuario: ' + info["reason"] + '</span>', 5000, 'rounded');
        },
        success: function(data){
            var info = JSON.parse(data);
            $notes_modal.manage["selector"].attr($notes_modal.attributes.alumid,alid);
            $notes_modal.manage["selector"].attr($notes_modal.attributes.asigid,asgid);
            if(("data" in info) && ("grade" in info["data"]))
            {
                $notes_modal.manage.label("grade").val(info["data"]["grade"]);
            }
            else
            {
                $notes_modal.manage.label("grade").val("0");
            }
            Materialize.updateTextFields();
            $notes_modal.manage["selector"].modal('open');
        }
    });
}
function manageGrade_Update()
{
    $.ajax({
        url: "notas",
        type: "POST",
        data: { 
            "action": AJAX_UPDATE_PARAM,
            "alumid": $notes_modal.manage["selector"].attr($notes_modal.attributes.alumid),
            "asigid": $notes_modal.manage["selector"].attr($notes_modal.attributes.asigid),
            "grade": $notes_modal.manage.label("grade").val()
        },
        error: function(data)
        {
            var info = JSON.parse(data);
            Materialize.toast('<span>Ha ocurrido un error al actualizar la nota del  usuario: ' + info["reason"] + '</span>', 5000, 'rounded');
        },
        success: function(data){
            var info = JSON.parse(data);
            if(info['success'] == true)
            {
                $notes_modal.manage.label("grade").val(info["data"]["grade"]);
                Materialize.toast('<span>Nota actualizada correctamente.</span>', 5000, 'rounded');
            }
            else
            {
                Materialize.toast('<span>Ha ocurrido un error al actualizar la nota del usuario: ' + info["reason"] + '</span>', 5000, 'rounded');
            }
            manageGrade_CloseModal();
        }
    });
}