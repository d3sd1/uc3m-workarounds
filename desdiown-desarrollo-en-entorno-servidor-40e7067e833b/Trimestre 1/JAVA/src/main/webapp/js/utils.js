function resetModalFields(modal)
{
    $(modal).find('input').each(function( index ) {
        $(this).val("");
    });
    $users_modal.manage.label("oldage").prop('selectedIndex',0);
    $users_modal.manage.label("oldage").find('option[value=""]').attr("selected", "selected");
    $users_modal.manage.label("oldage").material_select();
    Materialize.updateTextFields();
}
function drawDataTable()
{
    $dataTable = $tableContainer.DataTable({
        "pageLength": 10,
        "language": {
                "lengthMenu": "Mostrando _MENU_ registros por página",
                "zeroRecords": "¡No se ha encontrado ni una colilla!",
                "info": "Mostrando página _PAGE_ de _PAGES_",
                "infoEmpty": "No se han encontrado registros.",
                "infoFiltered": "(filtrado de _MAX_ registros totales)",
                "decimal":        ",",
                "emptyTable":     "No se han encontrado registros.",
                "infoPostFix":    "",
                "thousands":      ".",
                "loadingRecords": "Cargando...",
                "processing":     "Procesando...",
                "search":         "Buscador:",
                "paginate": {
                    "first":      "Primeros",
                    "last":       "Últimos",
                    "next":       "Siguiente",
                    "previous":   "Anterior"
                },
                "aria": {
                    "sortAscending":  ": pulsa para ordenar ascendentemente",
                    "sortDescending": ": pulsa para ordenar descendentemente"
                }
        },
        "drawCallback": function() {
            $('.dropdown-button').dropdown();
        }
    });
}
function getMaxDataId()
{
    var maxId = -1;
    jQuery.each($dataTable.data(), function(index, item) {
        if(parseInt(item[0]) > parseInt(maxId))
        {
            maxId = item[0];
        }
    });
    return maxId;
}