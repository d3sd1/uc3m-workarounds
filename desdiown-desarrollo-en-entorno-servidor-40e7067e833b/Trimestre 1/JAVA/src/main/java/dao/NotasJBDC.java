package dao;

import ajax.AjaxMaker;
import ajax.AjaxResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import model.Nota;
import utils.Constants;
import yml.Language;

public class NotasJBDC
{

    private final AjaxMaker ajax = new AjaxMaker();
    public AjaxResponse getNotaJDBC(Nota grade)
    {
        DBConnection db = new DBConnection();
        Connection con = null;
        ResultSet rs;
        PreparedStatement stmt = null;
        AjaxResponse response;
        try
        {
            con = db.getConnection();
            stmt = con.prepareStatement("SELECT " + Constants.SQL_TABLE_NOTAS_FIELD_GRADE
                    + " FROM " + Constants.SQL_TABLE_NOTAS + " WHERE " + Constants.SQL_TABLE_NOTAS_FIELD_USERID + "=? AND "
                    + Constants.SQL_TABLE_NOTAS_FIELD_SUBJECTID + "=?");
            stmt.setInt(1, grade.getID_ALUMNO());
            stmt.setInt(2, grade.getID_ASIGNATURA());
            rs = stmt.executeQuery();

            if (rs.next())
            {
                HashMap<String, String> nota = new HashMap<>();
                nota.put(Constants.GRADES_PARAMETER_NAME_GRADE, rs.getString(1));
                response = ajax.successResponse(nota);
            } else
            {
                response = ajax.errorResponse(Language.getInstance().getDbResultSetError());
            }
        } catch (Exception ex)
        {
            response = ajax.errorResponse(Language.getInstance().getGenericError());
        } finally
        {
            db.closeStmt(stmt);
            db.closeCon(con);
        }
        return response;
    }

    public AjaxResponse updateNotaJDBC(Nota grade)
    {
        DBConnection db = new DBConnection();
        Connection con = null;
        PreparedStatement stmt = null;
        AjaxResponse response;
        try
        {
            con = db.getConnection();
            stmt = con.prepareStatement("UPDATE " + Constants.SQL_TABLE_NOTAS
                    + " SET " + Constants.SQL_TABLE_NOTAS_FIELD_GRADE + "=? WHERE " + Constants.SQL_TABLE_NOTAS_FIELD_USERID
                    + "=? AND " + Constants.SQL_TABLE_NOTAS_FIELD_SUBJECTID + "=?", Statement.RETURN_GENERATED_KEYS);

            stmt.setInt(1, grade.getNOTA());
            stmt.setInt(2, grade.getID_ALUMNO());
            stmt.setInt(3, grade.getID_ASIGNATURA());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0)
            {
                HashMap<String, String> gradeInfoParams = new HashMap<>();
                gradeInfoParams.put(Constants.GRADES_PARAMETER_NAME_GRADE, Integer.toString(grade.getNOTA()));
                gradeInfoParams.put(Constants.GRADES_PARAMETER_NAME_ASIGID, Integer.toString(grade.getID_ASIGNATURA()));
                gradeInfoParams.put(Constants.GRADES_PARAMETER_NAME_ALUMID, Integer.toString(grade.getID_ALUMNO()));
                response = ajax.successResponse(gradeInfoParams);
            } else
            {
                response = ajax.errorResponse(Language.getInstance().getDbNoChangesError());
            }
        } catch (Exception ex)
        {
            response = ajax.errorResponse(Language.getInstance().getGenericError());
        } finally
        {
            db.closeStmt(stmt);
            db.closeCon(con);
        }
        return response;
    }

    public AjaxResponse insertNotaJDBC(Nota grade)
    {
        DBConnection db = new DBConnection();
        Connection con = null;
        PreparedStatement stmt = null;
        AjaxResponse response;
        try
        {
            con = db.getConnection();
            stmt = con.prepareStatement("INSERT INTO " + Constants.SQL_TABLE_NOTAS
                    + " (" + Constants.SQL_TABLE_NOTAS_FIELD_GRADE + "," + Constants.SQL_TABLE_NOTAS_FIELD_USERID
                    + "," + Constants.SQL_TABLE_NOTAS_FIELD_SUBJECTID + ") VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);

            stmt.setInt(1, grade.getNOTA());
            stmt.setInt(2, grade.getID_ALUMNO());
            stmt.setInt(3, grade.getID_ASIGNATURA());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0)
            {
                HashMap<String, String> gradeInfoParams = new HashMap<>();
                gradeInfoParams.put(Constants.GRADES_PARAMETER_NAME_GRADE, Integer.toString(grade.getNOTA()));
                gradeInfoParams.put(Constants.GRADES_PARAMETER_NAME_ASIGID, Integer.toString(grade.getID_ASIGNATURA()));
                gradeInfoParams.put(Constants.GRADES_PARAMETER_NAME_ALUMID, Integer.toString(grade.getID_ALUMNO()));
                response = ajax.successResponse(gradeInfoParams);
            } else
            {
                response = ajax.errorResponse(Language.getInstance().getDbNoChangesError());
            }
        } catch (SQLException ex)
        {
            response = ajax.errorResponse(Language.getInstance().getDbSqlQueryError());
        } catch (Exception ex)
        {
            response = ajax.errorResponse(Language.getInstance().getGenericError());
        } finally
        {
            db.closeStmt(stmt);
            db.closeCon(con);
        }
        return response;
    }
}
