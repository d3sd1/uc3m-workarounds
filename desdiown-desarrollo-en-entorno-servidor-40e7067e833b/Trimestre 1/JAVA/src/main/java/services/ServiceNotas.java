package services;

import ajax.AjaxMaker;
import ajax.AjaxResponse;
import dao.NotasJBDC;
import java.util.Map;
import model.Nota;
import utils.Constants;
import yml.Language;

public class ServiceNotas {
    private final AjaxMaker ajax = new AjaxMaker();
    
    public String updateNota(Map params)
    {
        AjaxResponse returnme;
        NotasJBDC dao = new NotasJBDC();
        try
        {
            Nota grade = new Nota();
            grade.setID_ALUMNO(Integer.parseInt(((String[]) params.get(Constants.GRADES_PARAMETER_NAME_ALUMID))[0]));
            grade.setID_ASIGNATURA(Integer.parseInt(((String[]) params.get(Constants.GRADES_PARAMETER_NAME_ASIGID))[0]));
            int notapuesta = Integer.parseInt(((String[]) params.get(Constants.GRADES_PARAMETER_NAME_GRADE))[0]);
            boolean status = dao.getNotaJDBC(grade).isSuccess();
            if(notapuesta > 10)
            {
                notapuesta = 10;
            }
            else if(notapuesta < 0)
            {
                notapuesta = 0;
            }
            grade.setNOTA(notapuesta);
            
            if(status) /* IF GRADE ALREADY EXISTS FOR THIS USER AND SUBJECT... UPDATE IT! */
            {
                returnme = dao.updateNotaJDBC(grade);
            }
            else /* EITHER WAY... ADD IT TO DATABASE! */
            {
                returnme = dao.insertNotaJDBC(grade);
            }
        }
        catch(NullPointerException ex)
        {
            returnme = ajax.errorResponse(Language.getInstance().getNullPointerError());
        }
        catch(NumberFormatException ex)
        {
            returnme = ajax.errorResponse(Language.getInstance().getNumberFormatError());
        }
        catch(Exception ex)
        {
            returnme = ajax.errorResponse(Language.getInstance().getGenericError());
        }
        return ajax.parseResponse(returnme);
    }
    public String getNota(Map params)
    {
        AjaxResponse returnme;
        NotasJBDC dao = new NotasJBDC();
        try
        {
            Nota grade = new Nota();
            grade.setID_ALUMNO(Integer.parseInt(((String[]) params.get(Constants.GRADES_PARAMETER_NAME_ALUMID))[0]));
            grade.setID_ASIGNATURA(Integer.parseInt(((String[]) params.get(Constants.GRADES_PARAMETER_NAME_ASIGID))[0]));
            returnme = dao.getNotaJDBC(grade);
        }
        catch(NullPointerException ex)
        {
            returnme = ajax.errorResponse(Language.getInstance().getNullPointerError());
        }
        catch(NumberFormatException ex)
        {
            returnme = ajax.errorResponse(Language.getInstance().getNumberFormatError());
        }
        catch(Exception ex)
        {
            returnme = ajax.errorResponse(Language.getInstance().getGenericError());
        }
        return ajax.parseResponse(returnme);
    }
}
