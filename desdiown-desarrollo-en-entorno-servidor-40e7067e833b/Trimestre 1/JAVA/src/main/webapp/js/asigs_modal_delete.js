/* ON DELETING USER MODALS */
function delasgConfirm_OpenModal(id)
{
    /* Set modal user id to delete */
    $asigs_modal["delete"]["selector"].attr($asigs_modal.attributes.asgid,id);
    $asigs_modal["delete"]["selector"].modal({
        dismissible: false
    });
    $asigs_modal["delete"]["selector"].modal('open');
}
function delasgConfirm_CloseModal()
{
    /* Reset modal user id to delete */
    $asigs_modal["delete"]["selector"].attr($asigs_modal.attributes.asgid,"");
    $asigs_modal["delete"]["selector"].modal('close');
}
function delasgConfirm_RemoveUser()
{
    $.ajax({
        url: "asignaturas",
        error: function(result)
        {
            var status = JSON.parse(result);
            Materialize.toast('<span>Ha ocurrido un error al eliminar la asignatura: ' + status["reason"] + '</span>', 5000, 'rounded');
        },
        type: "POST",
        data: { 
            "action": AJAX_DELETE_PARAM,
            "id": $asigs_modal["delete"]["selector"].attr($asigs_modal.attributes.asgid)
        },
        success: function(result){
            var status = JSON.parse(result);
            if(status['success'] == true)
            {
                /* Remove HTML entry from table with fade out effect */
                $dataTable.row('#asg-' + $asigs_modal["delete"]["selector"].attr($asigs_modal.attributes.asgid)).remove().draw();
                Materialize.toast('<span>Asignatura eliminada correctamente.</span>', 5000, 'rounded');
            }
            else
            {
                if(status["code"] == 1) //INTEGRITY DATA CODE
                {
                    delAsgConfirm_ConfirmDeleteWithNotes($asigs_modal["delete"]["selector"].attr($asigs_modal.attributes.asgid));
                }
                else
                {
                    Materialize.toast('<span>Ha ocurrido un error al eliminar la asignatura: ' + status["reason"] + '</span>', 5000, 'rounded');
                }
            }
            delasgConfirm_CloseModal();
        }
    });
}
function delAsgConfirm_ConfirmDeleteWithNotes(id)
{
    $asigs_modal["deleteWithnotes"]["selector"].attr($asigs_modal.attributes.asgid,id);
    $asigs_modal["deleteWithnotes"]["selector"].modal({
        dismissible: false
    });
    $asigs_modal["deleteWithnotes"]["selector"].modal('open');
}
function delAsgWithNotesConfirm_CloseModal()
{
    /* Reset modal user id to delete */
    $asigs_modal["deleteWithnotes"]["selector"].attr($asigs_modal.attributes.asgid,"");
    $asigs_modal["deleteWithnotes"]["selector"].modal('close');
}
function delAsgWithNotesConfirm_RemoveUser()
{
    $.ajax({
        url: "asignaturas",
        error: function(result)
        {
            var status = JSON.parse(result);
            Materialize.toast('<span>Ha ocurrido un error al eliminar la asignatura: ' + status["reason"] + '</span>', 5000, 'rounded');
        },
        type: "POST",
        data: { 
            "action": AJAX_FORCE_DELETE_PARAM,
            "id": $asigs_modal["deleteWithnotes"]["selector"].attr($asigs_modal.attributes.asgid)
        },
        success: function(result){
            var status = JSON.parse(result);
            if(status['success'] == true)
            {
                /* Remove HTML entry from table with fade out effect */
                $dataTable.row('#asg-' + $asigs_modal["deleteWithnotes"]["selector"].attr($asigs_modal.attributes.asgid)).remove().draw();
                Materialize.toast('<span>Asignatura eliminada correctamente.</span>', 5000, 'rounded');
            }
            else
            {
                Materialize.toast('<span>Ha ocurrido un error al eliminar la asignatura: ' + status["reason"] + '</span>', 5000, 'rounded');
            }
            delAsgWithNotesConfirm_CloseModal();
        }
    });
}