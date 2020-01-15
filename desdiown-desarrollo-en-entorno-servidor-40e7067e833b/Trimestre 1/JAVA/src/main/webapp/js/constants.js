var /* GLOBAL */
    $parallaxContainer = $('.parallax'),
    $scrollSpyContainer = $('.scrollspy'),
    $modalsContainer = $('.modal'),
    $tableContainer = $('.initdatatable'),
    $dataTable, /* INITIALIZED AFTER PAGE LOAD */
    /* USERS */
    $users_modal = { /* OBJECT FOR USERS MODALS DATA, ATTRIBUTES, INFO... */
        "attributes": {
            "userid": "data-usrid",
            "action": "data-action"
        },
        "delete": {
            "selector": $('#delConfirm')
        },
        "deleteWithnotes": {
            "selector": $('#delConfirmWithNotes')
        },
        "manage": {
            "selector": $('#manageUsr'),
            "labels": {
                "id": "id",
                "name": "name",
                "birthdate": "birthdate",
                "oldage": "oldage",
            },
            label(lab) {
                return this.selector.find("input[name='" + this.labels[lab] + "'],select[name='" + this.labels[lab] + "']");
            }
        }
    }
    $asigs_modal = { /* OBJECT FOR SUBJECTS MODAL DATA, ATTRIBUTES, INFO... */
        "attributes": {
            "asgid": "data-asgid",
            "action": "data-action"
        },
        "delete": {
            "selector": $('#delConfirm')
        },
        "deleteWithnotes": {
            "selector": $('#delConfirmWithNotes')
        },
        "manage": {
            "selector": $('#manageasg'),
            "labels": { /* NOMBRE DE LOS CAMPOS DE LA MODAL */
                "id": "id",
                "name": "name",
                "course": "course",
                "cicle": "cicle",
            },
            label(lab) {
                return this.selector.find("input[name='" + this.labels[lab] + "'],select[name='" + this.labels[lab] + "']");
            }
        }
    }
    $notes_modal = { /* OBJECT FOR SUBJECTS MODAL DATA, ATTRIBUTES, INFO... */
        "attributes": {
            "alumid": "data-asgid",
            "asigid": "data-asigid",
            "grade": "data-grade"
        },
        "manage": {
            "selector": $('#gradeManager'),
            "labels": { /* NOMBRE DE LOS CAMPOS DE LA MODAL */
                "grade": "grade",
            },
            label(lab) {
                return this.selector.find("input[name='" + this.labels[lab] + "'],select[name='" + this.labels[lab] + "']");
            }
        }
    }