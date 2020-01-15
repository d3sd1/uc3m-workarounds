/* ON DELETING USER MODALS */
function delUsrConfirm_OpenModal(id)
{
    /* Set modal user id to delete */
    $users_modal["delete"]["selector"].attr($users_modal.attributes.userid,id);
    $users_modal["delete"]["selector"].modal({
        dismissible: false
    });
    $users_modal["delete"]["selector"].modal('open');
}
function delUsrConfirm_CloseModal()
{
    /* Reset modal user id to delete */
    $users_modal["delete"]["selector"].attr($users_modal.attributes.userid,"");
    $users_modal["delete"]["selector"].modal('close');
}
function delUsrConfirm_RemoveUser()
{
    $.ajax({
        url: "alumnos",
        error: function(result)
        {
            var status = JSON.parse(result);
            Materialize.toast('<span>Ha ocurrido un error al eliminar el usuario: ' + status["reason"] + '</span>', 5000, 'rounded');
        },
        type: "POST",
        data: { 
            "action": AJAX_DELETE_PARAM,
            "id": $users_modal["delete"]["selector"].attr($users_modal.attributes.userid)
        },
        success: function(result){
            var status = JSON.parse(result);
            if(status['success'] == true)
            {
                /* Remove HTML entry from table with fade out effect */
                $dataTable.row('#usr-' + $users_modal["delete"]["selector"].attr($users_modal.attributes.userid)).remove().draw();
                Materialize.toast('<span>Usuario eliminado correctamente.</span>', 5000, 'rounded');
            }
            else
            {
                if(status["code"] == 1) //INTEGRITY DATA CODE
                {
                    delUsrConfirm_ConfirmDeleteWithNotes($users_modal["delete"]["selector"].attr($users_modal.attributes.userid));
                }
                else
                {
                    Materialize.toast('<span>Ha ocurrido un error al eliminar el usuario: ' + status["reason"] + '</span>', 5000, 'rounded');
                }
            }
            delUsrConfirm_CloseModal();
        }
    });
}
function delUsrConfirm_ConfirmDeleteWithNotes(id)
{
    $users_modal["deleteWithnotes"]["selector"].attr($users_modal.attributes.userid,id);
    $users_modal["deleteWithnotes"]["selector"].modal({
        dismissible: false
    });
    $users_modal["deleteWithnotes"]["selector"].modal('open');
}
function delUsrWithNotesConfirm_CloseModal()
{
    /* Reset modal user id to delete */
    $users_modal["deleteWithnotes"]["selector"].attr($users_modal.attributes.userid,"");
    $users_modal["deleteWithnotes"]["selector"].modal('close');
}
function delUsrWithNotesConfirm_RemoveUser()
{
    $.ajax({
        url: "alumnos",
        error: function(result)
        {
            var status = JSON.parse(result);
            Materialize.toast('<span>Ha ocurrido un error al eliminar el usuario: ' + status["reason"] + '</span>', 5000, 'rounded');
        },
        type: "POST",
        data: { 
            "action": AJAX_FORCE_DELETE_PARAM,
            "id": $users_modal["deleteWithnotes"]["selector"].attr($users_modal.attributes.userid)
        },
        success: function(result){
            var status = JSON.parse(result);
            if(status['success'] == true)
            {
                /* Remove HTML entry from table with fade out effect */
                $dataTable.row('#usr-' + $users_modal["deleteWithnotes"]["selector"].attr($users_modal.attributes.userid)).remove().draw();
                Materialize.toast('<span>Usuario eliminado correctamente.</span>', 5000, 'rounded');
            }
            else
            {
                Materialize.toast('<span>Ha ocurrido un error al eliminar el usuario: ' + status["reason"] + '</span>', 5000, 'rounded');
            }
            delUsrWithNotesConfirm_CloseModal();
        }
    });
}