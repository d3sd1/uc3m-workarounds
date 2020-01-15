package services;

import ajax.AjaxMaker;
import ajax.AjaxResponse;
import dao.AsignaturasDBUtils;
import java.util.List;
import java.util.Map;
import model.Asignatura;
import utils.Constants;
import yml.Language;

public class ServiceAsignaturas
{

    private final AjaxMaker ajax = new AjaxMaker();

    public List<Asignatura> listAsignaturas()
    {
        AsignaturasDBUtils dao = new AsignaturasDBUtils();
        return dao.listAsignaturasDBUtils();
    }

    public String updateAsignatura(Map params)
    {
        AjaxResponse returnme;
        AsignaturasDBUtils dao = new AsignaturasDBUtils();
        try
        {
            Asignatura asig = new Asignatura();
            asig.setId(Integer.parseInt(((String[]) params.get(Constants.SUBJECT_PARAMETER_NAME_ID))[0]));
            asig.setNombre(((String[]) params.get(Constants.SUBJECT_PARAMETER_NAME_NAME))[0]);
            asig.setCurso(((String[]) params.get(Constants.SUBJECT_PARAMETER_NAME_COURSE))[0]);
            asig.setCiclo(((String[]) params.get(Constants.SUBJECT_PARAMETER_NAME_CICLE))[0]);

            returnme = dao.updateAsignaturaDBUtils(asig);
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

    public String addAsignatura(Map params)
    {
        AjaxResponse returnme;
        AsignaturasDBUtils dao = new AsignaturasDBUtils();
        try
        {
            Asignatura asig = new Asignatura();
            asig.setNombre(((String[]) params.get(Constants.SUBJECT_PARAMETER_NAME_NAME))[0]);
            asig.setCurso(((String[]) params.get(Constants.SUBJECT_PARAMETER_NAME_COURSE))[0]);
            asig.setCiclo(((String[]) params.get(Constants.SUBJECT_PARAMETER_NAME_CICLE))[0]);
            returnme = dao.addAsignaturaDBUtils(asig);
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

    public String removeAsignatura(Map params)
    {
        AjaxResponse returnme;
        AsignaturasDBUtils dao = new AsignaturasDBUtils();
        try
        {
            int asignaturaId = Integer.parseInt(((String[]) params.get(Constants.SUBJECT_PARAMETER_NAME_ID))[0]);
            Asignatura asig = new Asignatura();
            asig.setId(asignaturaId);
            returnme = dao.deleteAsignaturaDBUtils(asig);
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

    public String removeAsignaturaWithGrades(Map params)
    {
        AjaxResponse returnme;
        AsignaturasDBUtils dao = new AsignaturasDBUtils();
        try
        {
            int asigId = Integer.parseInt(((String[]) params.get(Constants.USERS_PARAMETER_NAME_ID))[0]);
            Asignatura asig = new Asignatura();
            asig.setId(asigId);
            returnme = dao.deleteAsignaturaGradesDBUtils(asig);
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
