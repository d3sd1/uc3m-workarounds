package dao;

import ajax.AjaxMaker;
import ajax.AjaxResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Asignatura;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.Constants;
import yml.Language;

public class AsignaturasDBUtils
{

    private final AjaxMaker ajax = new AjaxMaker();

    public List<Asignatura> listAsignaturasDBUtils()
    {
        List<Asignatura> lista = null;
        DBConnection db = new DBConnection();
        Connection con = null;

        try
        {
            QueryRunner queryRunner = new QueryRunner();
            con = db.getConnection();
            lista = queryRunner.query(con, "SELECT " + Constants.SQL_TABLE_ASIGNATURAS_FIELD_ID + "," + Constants.SQL_TABLE_ASIGNATURAS_FIELD_NAME + "," + Constants.SQL_TABLE_ASIGNATURAS_FIELD_COURSE + "," + Constants.SQL_TABLE_ASIGNATURAS_FIELD_CICLE + " FROM " + Constants.SQL_TABLE_ASIGNATURAS, new BeanListHandler<>(Asignatura.class));
        }
        catch (Exception ex)
        {
            Logger.getLogger(AsignaturasDBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            db.closeCon(con);
        }
        return lista;
    }

    public AjaxResponse updateAsignaturaDBUtils(Asignatura asig)
    {
        DBConnection db = new DBConnection();
        Connection con = null;
        AjaxResponse response;
        try
        {
            con = db.getConnection();
            QueryRunner qr = new QueryRunner();

            int updatedRows = qr.update(con,
                    "UPDATE " + Constants.SQL_TABLE_ASIGNATURAS + " SET " + Constants.SQL_TABLE_ASIGNATURAS_FIELD_NAME + "=?," + Constants.SQL_TABLE_ASIGNATURAS_FIELD_COURSE + "=?," + Constants.SQL_TABLE_ASIGNATURAS_FIELD_CICLE + "=? WHERE " + Constants.SQL_TABLE_ASIGNATURAS_FIELD_ID + "=?",
                    asig.getNombre(),
                    asig.getCurso(),
                    asig.getCiclo(),
                    asig.getId()
            );
            if (updatedRows != 0)
            {
                HashMap<String, String> addedAsigParams = new HashMap<>();
                addedAsigParams.put(Constants.USERS_PARAMETER_NAME_ID, Long.toString(asig.getId()));
                addedAsigParams.put(Constants.SUBJECT_PARAMETER_NAME_NAME, asig.getNombre());
                addedAsigParams.put(Constants.SUBJECT_PARAMETER_NAME_COURSE, asig.getCurso());
                addedAsigParams.put(Constants.SUBJECT_PARAMETER_NAME_CICLE, asig.getCiclo());
                response = ajax.successResponse(addedAsigParams);
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
            db.closeCon(con);
        }
        return response;
    }

    public AjaxResponse addAsignaturaDBUtils(Asignatura asig)
    {
        DBConnection db = new DBConnection();
        Connection con = null;
        AjaxResponse response;
        try
        {
            con = db.getConnection();

            QueryRunner qr = new QueryRunner();

            Long insertedRow = qr.insert(con,
                    "INSERT INTO " + Constants.SQL_TABLE_ASIGNATURAS + " (" + Constants.SQL_TABLE_ASIGNATURAS_FIELD_NAME + ","
                    + Constants.SQL_TABLE_ASIGNATURAS_FIELD_COURSE + ","
                    + Constants.SQL_TABLE_ASIGNATURAS_FIELD_CICLE + ") VALUES (?,?,?)",
                    new ScalarHandler<Long>(),
                    asig.getNombre(), asig.getCurso(), asig.getCiclo());

            if (insertedRow > 0)
            {
                HashMap<String, String> addedAsigParams = new HashMap<>();
                addedAsigParams.put(Constants.USERS_PARAMETER_NAME_ID, Long.toString(insertedRow));
                addedAsigParams.put(Constants.SUBJECT_PARAMETER_NAME_NAME, asig.getNombre());
                addedAsigParams.put(Constants.SUBJECT_PARAMETER_NAME_COURSE, asig.getCurso());
                addedAsigParams.put(Constants.SUBJECT_PARAMETER_NAME_CICLE, asig.getCiclo());
                response = ajax.successResponse(addedAsigParams);
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
            db.closeCon(con);
        }
        return response;
    }

    public AjaxResponse deleteAsignaturaDBUtils(Asignatura asig, Connection con)
    {
        DBConnection db = new DBConnection();
        AjaxResponse response;
        try
        {

            QueryRunner qr = new QueryRunner();

            int affectedRows = qr.update(con, "DELETE FROM " + Constants.SQL_TABLE_ASIGNATURAS + " WHERE " + Constants.SQL_TABLE_ASIGNATURAS_FIELD_ID + "=?", asig.getId());

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
        return response;
    }
    
    public AjaxResponse deleteAsignaturaDBUtils(Asignatura asig)
    {
        DBConnection db = new DBConnection();
        Connection con = null;
        AjaxResponse response;
        try
        {
            con = db.getConnection();

            response = deleteAsignaturaDBUtils(asig,con);
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

    public AjaxResponse deleteAsignaturaGradesDBUtils(Asignatura asig)
    {
        DBConnection db = new DBConnection();
        Connection con = null;
        AjaxResponse response;
        try
        {
            con = db.getConnection();
            con.setAutoCommit(false);

            QueryRunner qr = new QueryRunner();

            int affectedRows = qr.update(con, "DELETE FROM " + Constants.SQL_TABLE_NOTAS + " WHERE " + Constants.SQL_TABLE_NOTAS_FIELD_SUBJECTID + "=?", asig.getId());
            if (affectedRows > 0)
            {
                response = this.deleteAsignaturaDBUtils(asig,con);
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
            db.closeCon(con);
        }
        return response;
    }
}
