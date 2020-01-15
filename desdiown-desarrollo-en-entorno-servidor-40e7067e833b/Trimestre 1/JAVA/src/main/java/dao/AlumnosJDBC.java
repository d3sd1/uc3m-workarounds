package dao;

import ajax.AjaxMaker;
import ajax.AjaxResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Alumno;
import utils.Constants;
import yml.ConfigGeneral;
import yml.Language;

public class AlumnosJDBC
{

    private final AjaxMaker ajax = new AjaxMaker();

    public List<Alumno> listAlumnosJDBC()
    {
        List<Alumno> allAlumnos = new ArrayList<>();
        DBConnection db = new DBConnection();
        Alumno lastAlum;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs;
        try
        {
            con = db.getConnection();
            stmt = con.createStatement();
            String sql;
            sql = "SELECT * FROM " + Constants.SQL_TABLE_ALUMNOS;
            rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                lastAlum = new Alumno();
                lastAlum.setId(rs.getInt(Constants.USERS_PARAMETER_NAME_ID));
                lastAlum.setNombre(rs.getString(Constants.SQL_TABLE_ALUMNOS_FIELD_NAME));
                lastAlum.setFecha_nacimiento(rs.getDate(Constants.SQL_TABLE_ALUMNOS_FIELD_BIRTHDATE));
                lastAlum.setMayor_edad(rs.getBoolean(Constants.SQL_TABLE_ALUMNOS_FIELD_OLDAGE));
                allAlumnos.add(lastAlum);
            }

        }
        catch (Exception ex)
        {
            Logger.getLogger(AlumnosJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            db.closeStmt(stmt);
            db.closeCon(con);
        }
        return allAlumnos;
    }

    public AjaxResponse deleteAlumnoJDBC(Alumno alum)
    {
        DBConnection db = new DBConnection();
        Connection con = null;
        AjaxResponse response;
        try
        {
            con = db.getConnection();
            return deleteAlumnoJDBC(alum, db, con);
        }
        catch (SQLException ex)
        {
            if (ex.getSQLState().startsWith("23"))
            {
                response = ajax.errorResponse(Language.getInstance().getDbSqlIntegrityError(), 1);
            }
            else
            {
                response = ajax.errorResponse(Language.getInstance().getDbSqlQueryError());
            }
        }
        catch (Exception ex)
        {
            response = ajax.errorResponse(Language.getInstance().getGenericError());
        }
        finally
        {
            db.closeCon(con);
        }
        return response;
    }

    public AjaxResponse deleteAlumnoJDBC(Alumno alum, DBConnection db, Connection con)
    {
        PreparedStatement stmt = null;
        AjaxResponse response;
        try
        {
            stmt = con.prepareStatement("DELETE FROM " + Constants.SQL_TABLE_ALUMNOS + " WHERE " + Constants.SQL_TABLE_ALUMNOS_FIELD_ID + "=?");
            stmt.setLong(1, alum.getId());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0)
            {
                response = ajax.successResponse();
            }
            else
            {
                response = ajax.errorResponse(Language.getInstance().getDbNoChangesError());
            }
        }
        catch (SQLException ex)
        {
            if (ex.getSQLState().startsWith("23"))
            {
                response = ajax.errorResponse(Language.getInstance().getDbSqlIntegrityError(), 1);
            }
            else
            {
                response = ajax.errorResponse(Language.getInstance().getDbSqlQueryError());
            }
        }
        catch (Exception ex)
        {
            response = ajax.errorResponse(Language.getInstance().getGenericError());
        }
        finally
        {
            db.closeStmt(stmt);
        }
        return response;
    }
    
    public AjaxResponse deleteAlumnoGradesJDBC(Alumno alum)
    {
        DBConnection db = new DBConnection();
        Connection con = null;
        PreparedStatement stmt = null;
        AjaxResponse response = null;
        try
        {
            con = db.getConnection();
            con.setAutoCommit(false);
            stmt = con.prepareStatement("DELETE FROM " + Constants.SQL_TABLE_NOTAS + " WHERE " + Constants.SQL_TABLE_NOTAS_FIELD_USERID + "=?");
            stmt.setLong(1, alum.getId());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0)
            {
                response = deleteAlumnoJDBC(alum, db, con);
            }
            else
            {
                response = ajax.errorResponse(Language.getInstance().getDbNoChangesError());
            }
            con.commit();
        }
        catch (SQLException ex)
        {
            try
            {
                con.rollback();
            }
            catch (SQLException ex2)
            {
                
            }

            response = ajax.errorResponse(Language.getInstance().getDbSqlQueryError());
        }
        catch (Exception ex)
        {
            try
            {
                con.rollback();
            }
            catch (SQLException ex2)
            {
                
            }
            response = ajax.errorResponse(Language.getInstance().getGenericError());
        }
        finally
        {
            db.closeStmt(stmt);
            db.closeCon(con);
        }
        return response;
    }

    public AjaxResponse addAlumnoJDBC(Alumno alum)
    {
        DBConnection db = new DBConnection();
        Connection con = null;
        PreparedStatement stmt = null;
        AjaxResponse response;
        try
        {
            con = db.getConnection();
            stmt = con.prepareStatement("INSERT INTO " + Constants.SQL_TABLE_ALUMNOS
                    + " (" + Constants.SQL_TABLE_ALUMNOS_FIELD_NAME + "," + Constants.SQL_TABLE_ALUMNOS_FIELD_BIRTHDATE
                    + "," + Constants.SQL_TABLE_ALUMNOS_FIELD_OLDAGE + ") VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, alum.getNombre());
            stmt.setDate(2, new java.sql.Date(alum.getFecha_nacimiento().getTime()));
            stmt.setBoolean(3, alum.getMayor_edad());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0)
            {
                try
                {
                    ResultSet generatedKeys = stmt.getGeneratedKeys();
                    if (generatedKeys.next())
                    {
                        HashMap<String, String> userInfoParams = new HashMap<>();
                        userInfoParams.put(Constants.USERS_PARAMETER_NAME_ID, Integer.toString(generatedKeys.getInt(1)));
                        userInfoParams.put(Constants.USERS_PARAMETER_NAME_NAME, alum.getNombre());
                        DateFormat dateformat = new SimpleDateFormat(ConfigGeneral.getInstance().getSimpleDateFormat(), Locale.ENGLISH);
                        try
                        {
                            userInfoParams.put(Constants.USERS_PARAMETER_NAME_BIRTHDATE, dateformat.format(alum.getFecha_nacimiento()));
                            userInfoParams.put(Constants.USERS_PARAMETER_NAME_OLDAGE, Boolean.toString(alum.getMayor_edad()));
                            response = ajax.successResponse(userInfoParams);
                        }
                        catch (Exception e)
                        {
                            response = ajax.errorResponse(Language.getInstance().getDateFormatError());
                        }
                    }
                    else
                    {
                        response = ajax.errorResponse(Language.getInstance().getDbNoChangesError());
                    }
                }
                catch (SQLException e)
                {
                    response = ajax.errorResponse(Language.getInstance().getDbResultSetError());
                }
            }
            else
            {
                response = ajax.errorResponse(Language.getInstance().getDbNoChangesError());
            }
        }
        catch (SQLException ex)
        {
            response = ajax.errorResponse(Language.getInstance().getDbSqlQueryError());
        }
        catch (Exception ex)
        {
            response = ajax.errorResponse(Language.getInstance().getGenericError());
        }
        finally
        {
            db.closeStmt(stmt);
            db.closeCon(con);
        }
        return response;
    }

    public AjaxResponse updateAlumnoJDBC(Alumno alum)
    {
        DBConnection db = new DBConnection();
        Connection con = null;
        PreparedStatement stmt = null;
        AjaxResponse response;
        try
        {
            con = db.getConnection();
            stmt = con.prepareStatement("UPDATE " + Constants.SQL_TABLE_ALUMNOS
                    + " SET " + Constants.SQL_TABLE_ALUMNOS_FIELD_NAME + "=?,"
                    + Constants.SQL_TABLE_ALUMNOS_FIELD_BIRTHDATE + "=?," + Constants.SQL_TABLE_ALUMNOS_FIELD_OLDAGE
                    + "=? WHERE " + Constants.SQL_TABLE_ALUMNOS_FIELD_ID + "=?", Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, alum.getNombre());
            stmt.setDate(2, new java.sql.Date(alum.getFecha_nacimiento().getTime()));
            stmt.setBoolean(3, alum.getMayor_edad());
            stmt.setLong(4, alum.getId());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0)
            {
                HashMap<String, String> userInfoParams = new HashMap<>();
                userInfoParams.put(Constants.USERS_PARAMETER_NAME_ID, Integer.toString(alum.getId()));
                userInfoParams.put(Constants.USERS_PARAMETER_NAME_NAME, alum.getNombre());
                DateFormat dateformat = new SimpleDateFormat(ConfigGeneral.getInstance().getSimpleDateFormat(), Locale.ENGLISH);
                try
                {
                    userInfoParams.put(Constants.USERS_PARAMETER_NAME_BIRTHDATE, dateformat.format(alum.getFecha_nacimiento()));
                    userInfoParams.put(Constants.USERS_PARAMETER_NAME_OLDAGE, Boolean.toString(alum.getMayor_edad()));
                    response = ajax.successResponse(userInfoParams);
                }
                catch (Exception e)
                {
                    response = ajax.errorResponse(Language.getInstance().getDateFormatError());
                }
            }
            else
            {
                response = ajax.errorResponse(Language.getInstance().getDbNoChangesError());
            }
        }
        catch (Exception ex)
        {
            response = ajax.errorResponse(Language.getInstance().getGenericError());
        }
        finally
        {
            db.closeStmt(stmt);
            db.closeCon(con);
        }
        return response;
    }
}
