package services;

import ajax.AjaxMaker;
import ajax.AjaxResponse;
import dao.AlumnosJDBC;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import model.Alumno;
import utils.Constants;
import yml.ConfigGeneral;
import yml.Language;

public class ServiceAlumnos
{

    private final AjaxMaker ajax = new AjaxMaker();

    public List<Alumno> listAlumnos()
    {
        AlumnosJDBC dao = new AlumnosJDBC();
        return dao.listAlumnosJDBC();
    }

    public String updateAlumno(Map params)
    {
        AlumnosJDBC dao = new AlumnosJDBC();
        AjaxResponse returnme;
        try
        {
            Alumno alum = new Alumno();
            alum.setId(Integer.parseInt(((String[]) params.get(Constants.USERS_PARAMETER_NAME_ID))[0]));
            alum.setNombre(((String[]) params.get(Constants.USERS_PARAMETER_NAME_NAME))[0]);
            alum.setMayor_edad(Boolean.parseBoolean(((String[]) params.get(Constants.USERS_PARAMETER_NAME_OLDAGE))[0]));
            System.out.println("FORMATO: " + ConfigGeneral.getInstance().getSimpleDateFormat());
            alum.setFecha_nacimiento(new SimpleDateFormat(ConfigGeneral.getInstance().getSimpleDateFormat(), Locale.ENGLISH).parse(((String[]) params.get(Constants.USERS_PARAMETER_NAME_BIRTHDATE))[0]));
            returnme = dao.updateAlumnoJDBC(alum);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
            returnme = ajax.errorResponse(Language.getInstance().getParseDateError());
        }
        catch (NullPointerException ex)
        {
            returnme = ajax.errorResponse(Language.getInstance().getNullPointerError());
        }
        catch (NumberFormatException ex)
        {
            returnme = ajax.errorResponse(Language.getInstance().getNumberFormatError());
        }
        catch (Exception ex)
        {
            returnme = ajax.errorResponse(Language.getInstance().getGenericError());
        }
        return ajax.parseResponse(returnme);
    }

    public String addAlumno(Map params)
    {
        AlumnosJDBC dao = new AlumnosJDBC();
        AjaxResponse returnme;
        try
        {
            Alumno alum = new Alumno();
            alum.setNombre(((String[]) params.get(Constants.USERS_PARAMETER_NAME_NAME))[0]);
            alum.setFecha_nacimiento(new SimpleDateFormat(ConfigGeneral.getInstance().getSimpleDateFormat(), Locale.ENGLISH).parse(((String[]) params.get(Constants.USERS_PARAMETER_NAME_BIRTHDATE))[0]));
            alum.setMayor_edad(Boolean.parseBoolean(((String[]) params.get(Constants.USERS_PARAMETER_NAME_OLDAGE))[0]));
            returnme = dao.addAlumnoJDBC(alum);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
            returnme = ajax.errorResponse(Language.getInstance().getParseDateError());
        }
        catch (NullPointerException ex)
        {
            returnme = ajax.errorResponse(Language.getInstance().getNullPointerError());
        }
        catch (NumberFormatException ex)
        {
            returnme = ajax.errorResponse(Language.getInstance().getNumberFormatError());
        }
        catch (Exception ex)
        {
            returnme = ajax.errorResponse(Language.getInstance().getGenericError());
        }
        return ajax.parseResponse(returnme);
    }

    public String removeAlumno(Map params)
    {
        AlumnosJDBC dao = new AlumnosJDBC();
        AjaxResponse returnme;
        try
        {
            int alumnoId = Integer.parseInt(((String[]) params.get(Constants.USERS_PARAMETER_NAME_ID))[0]);
            Alumno alum = new Alumno();
            alum.setId(alumnoId);
            returnme = dao.deleteAlumnoJDBC(alum);
        }
        catch (NullPointerException ex)
        {
            returnme = ajax.errorResponse(Language.getInstance().getNullPointerError());
        }
        catch (NumberFormatException ex)
        {
            returnme = ajax.errorResponse(Language.getInstance().getNumberFormatError());
        }
        catch (Exception ex)
        {
            returnme = ajax.errorResponse(Language.getInstance().getGenericError());
        }
        return ajax.parseResponse(returnme);
    }

    public String removeAlumnoWithGrades(Map params)
    {
        AlumnosJDBC dao = new AlumnosJDBC();
        AjaxResponse returnme;
        try
        {
            int alumnoId = Integer.parseInt(((String[]) params.get(Constants.USERS_PARAMETER_NAME_ID))[0]);
            Alumno alum = new Alumno();
            alum.setId(alumnoId);
            returnme = dao.deleteAlumnoGradesJDBC(alum);
        }
        catch (NullPointerException ex)
        {
            returnme = ajax.errorResponse(Language.getInstance().getNullPointerError());
        }
        catch (NumberFormatException ex)
        {
            returnme = ajax.errorResponse(Language.getInstance().getNumberFormatError());
        }
        catch (Exception ex)
        {
            returnme = ajax.errorResponse(Language.getInstance().getGenericError());
        }
        return ajax.parseResponse(returnme);
    }
}
