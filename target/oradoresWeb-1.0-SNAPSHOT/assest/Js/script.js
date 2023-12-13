$(document).ready(function () {


    $('#dtBasicExample').DataTable({
        "language": {
            url: '//cdn.datatables.net/plug-ins/1.13.7/i18n/es-ES.json'
        },
        "responsive": true,
        "processing": true,
         "ordering": false,
        "lengthChange": false,
        "pageLength": 5,
        "columnDefs": [
            {
                "target": 1,
                "visible": false,
                "searchable": false
            }
        ]

    });

    // Activate tooltip
    $('[data-bs-toggle="tooltip"]').tooltip();

    // delete fila
    $('table .delete').on('click', function () {
        var id = $(this).parent().find('#id').val();
        $('#deleteOradorModal #id').val(id);
    });

//    // delete multiple filas
//    $(document).on('click', '.multBorrar', function () {
//         var idString = "";
//        $('#dtBasicExample tr').filter(':has(:checkbox:checked)').find('td').each(function () {
//            idString = idString  + $(this).find('.nombre') + ', ';
//        });
//        
//    });


    // carga de formulario de update
    $(document).on('click', '.edit', function () {
        $('#editOradorModal #id').val($(this).parent().find('#id').val().trim());
        $('#editOradorModal #nombre').val($(this).closest('tr').find('td.nombre').text().trim());
        $('#editOradorModal #apellido').val($(this).closest('tr').find('td.apellido').text().trim());
        $('#editOradorModal #email').val($(this).closest('tr').find('td.email').text().trim());
        $('#editOradorModal #tema').val($(this).closest('tr').find('td.tema').text().trim());
    });



//    $('table .edit').on('click', function () {
//        var id = $(this).parent().find('#id').val();
//        $('#editOradorModal #nombre').val($(this).parent().find('#nombre').val());
//        $('#editOradorModal #apellido').val($(this).parent().find('#apellido').val());
//        $('#editOradorModal #email').val($(this).parent().find('#email').val());
//        $('#editOradorModal #tema').val($(this).parent().find('#tema').val());
//
//        $.ajax({
//            type: 'GET',
//            url: '/oradoresWeb/orador',
//            data: {action: 'find', id: id},
//            dataType: 'json',
//            contentType: 'application/json',
//            sucess: function (data) {
//                var result = JSON.parse(data);
//                $('#editOradorModal #id').val(result.id);
//                $('#editOradorModal #nombre').val(result.nombre);
//                $('#editOradorModal #apellido').val(result.apellido);
//                $('#editOradorModal #email').val(result.email);
//                $('#editOradorModal #tema').val(result.tema);
//            },
//            failure: function (response) {
//                // there was an error
//                alert(response.responseText);
//            },
//            error: function (response) {
//                // there was an error
//                alert(response.responseText);
//            }
//        });
//    });





// Select/Deselect checkboxes
    var checkbox = $('table tbody input[type="checkbox"]');
    $("#selectAll").click(function () {
        if (this.checked) {
            checkbox.each(function () {
                this.checked = true;
            });
        } else {
            checkbox.each(function () {
                this.checked = false;
            });
        }
    });
    checkbox.click(function () {
        if (!this.checked) {
            $("#selectAll").prop("checked", false);
        }
    }
    );
});


