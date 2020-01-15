package utils;

public class Constants {
    
    /* SESSION AND LOGIN AND REGISTER */
    public static final String SESSION_NAME_LOGIN = "CONNECTED";
    public static final String PARAMETER_NAME_SENDOP = "type";
    public static final String PARAMETER_NAME_SENDNAME = "name";
    public static final String PARAMETER_NAME_SENDEMAIL = "email";
    public static final String PARAMETER_NAME_SENDPASS = "pass";
    public static final String PARAMETER_NAME_SENDCODE = "code";
    
    /* GLOBAL PARAMETERS */
    public static final String PARAMETER_NAME_ACTION = "action";
    public static final String PARAMETER_VALUE_ACTION_DELETE = "del";
    public static final String PARAMETER_VALUE_ACTION_UPDATE = "upd";
    public static final String PARAMETER_VALUE_ACTION_ADD = "add";
    public static final String PARAMETER_VALUE_ACTION_CHECK = "check";
    public static final String PARAMETER_VALUE_ACTION_FORCEDELETE = "fdel";
    public static final String PARAMETER_VALUE_ACTION_DO = "send";
    public static final String PARAMETER_VALUE_ACTION_VERIFY = "verify";
    public static final String PARAMETER_VALUE_ACTION_REGISTER = "register";
    public static final String PARAMETER_VALUE_ACTION_LOGIN = "login";
    
    /* USERS CRUD */
    public static final String USERS_PARAMETER_NAME_ID = "id";
    public static final String USERS_PARAMETER_NAME_NAME = "name";
    public static final String USERS_PARAMETER_NAME_BIRTHDATE = "birthdate";
    public static final String USERS_PARAMETER_NAME_OLDAGE = "oldage";
    
    /* SUBJECTS CRUD */
    public static final String SUBJECT_PARAMETER_NAME_ID = "id";
    public static final String SUBJECT_PARAMETER_NAME_NAME = "name";
    public static final String SUBJECT_PARAMETER_NAME_COURSE = "course";
    public static final String SUBJECT_PARAMETER_NAME_CICLE = "cicle";
    
    /* GRADES CRUD */
    public static final String GRADES_PARAMETER_NAME_ALUMID = "alumid";
    public static final String GRADES_PARAMETER_NAME_ASIGID = "asigid";
    public static final String GRADES_PARAMETER_NAME_GRADE = "grade";
    
    /* SQL INFORMATION */
    public static final String SQL_TABLE_ALUMNOS = "ALUMNOS";
    public static final String SQL_TABLE_ALUMNOS_FIELD_ID = "ID";
    public static final String SQL_TABLE_ALUMNOS_FIELD_NAME = "NOMBRE";
    public static final String SQL_TABLE_ALUMNOS_FIELD_BIRTHDATE = "FECHA_NACIMIENTO";
    public static final String SQL_TABLE_ALUMNOS_FIELD_OLDAGE = "MAYOR_EDAD";
    public static final String SQL_TABLE_ASIGNATURAS = "ASIGNATURAS";
    public static final String SQL_TABLE_ASIGNATURAS_FIELD_ID = "ID";
    public static final String SQL_TABLE_ASIGNATURAS_FIELD_NAME = "NOMBRE";
    public static final String SQL_TABLE_ASIGNATURAS_FIELD_COURSE = "CURSO";
    public static final String SQL_TABLE_ASIGNATURAS_FIELD_CICLE = "CICLO";
    public static final String SQL_TABLE_NOTAS = "NOTAS";
    public static final String SQL_TABLE_NOTAS_FIELD_USERID = "ID_ALUMNO";
    public static final String SQL_TABLE_NOTAS_FIELD_SUBJECTID = "ID_ASIGNATURA";
    public static final String SQL_TABLE_NOTAS_FIELD_GRADE = "NOTA";
    public static final String SQL_TABLE_USERS = "USERS";
    public static final String SQL_TABLE_USERS_FIELD_EMAIL = "EMAIL";
    public static final String SQL_TABLE_USERS_FIELD_ID = "ID";
    public static final String SQL_TABLE_USERS_FIELD_ACTIVE = "activo";
    public static final String SQL_TABLE_USERS_FIELD_PASSWORD = "password";
    public static final String SQL_TABLE_USERS_FIELD_ACTCODE = "CODIGO_ACTIVACION";
    public static final String SQL_TABLE_USERS_FIELD_ACTDATE = "FECHA_ACTIVACION";
    
    
}
