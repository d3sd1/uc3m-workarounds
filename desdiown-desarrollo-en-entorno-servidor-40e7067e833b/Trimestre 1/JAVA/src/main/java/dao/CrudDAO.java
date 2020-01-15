package dao;

import configuration.Config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Car;

public class CrudDAO
{

    private final String SQL_QUERY_GETCOCHES = "SELECT * FROM EXAMEN e JOIN EXAMEN1 ee ON e.ID=ee.ID_EXAMEN";

    public List<Car> getAllCars()
    {
        List<Car> lista = new ArrayList<>();
        Car nuevo = null;
        DBConnection db = DBConnection.getInstance();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try
        {
            con = db.getConnection();
            stmt = con.createStatement();

            rs = stmt.executeQuery(SQL_QUERY_GETCOCHES);

            //STEP 5: Extract data from result set
            while (rs.next())
            {
                Car newCar = new Car();
                newCar.setId(rs.getInt("id"));
                newCar.setCoche(rs.getString("coche"));
                newCar.setComprado(rs.getBoolean("comprado"));
                newCar.setFecha_compra(rs.getDate("fecha_compra"));
                newCar.setKm(rs.getInt("km"));
                newCar.setDescuento(rs.getInt("descuento"));

                lista.add(newCar);
            }

        }
        catch (Exception ex)
        {
            Logger.getLogger(CrudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try
            {
                if (rs != null)
                {
                    rs.close();
                }
                if (stmt != null)
                {
                    stmt.close();
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(CrudDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            db.cerrarConexion(con);
        }
        return lista;

    }

    public boolean insertCar(Car a)
    {
        boolean success = false;
        Connection con = null;
        try
        {
            con = DBConnection.getInstance().getConnection();
            con.setAutoCommit(false);
            PreparedStatement stmt = con.prepareStatement("INSERT INTO EXAMEN (COCHE,COMPRADO) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);

           
            stmt.setString(1, a.getCoche());
            stmt.setDate(2, new java.sql.Date(a.getFecha_compra().getTime()));

            int filas = stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next())
            {
                int id = rs.getInt(1);
                PreparedStatement stmt2 = con.prepareStatement("INSERT INTO EXAMEN1 (FECHA_COMPRA,KM,DESCUENTO) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);


                stmt.setDate(1, new java.sql.Date(a.getFecha_compra().getTime()));
                stmt.setLong(2, a.getKm());
                stmt.setInt(3, Config.getInstance().getDescuento());

                int filas2 = stmt.executeUpdate();

                if(filas2 > 0)
                {
                    success = true;
                    con.commit();
                }
                else
                {
                    success = false;
                    con.rollback();
                }
            }

        }
        catch (Exception ex)
        {
            
            try
            {
                con.rollback();
            }
            catch (SQLException ex1)
            {
                Logger.getLogger(CrudDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(CrudDAO.class.getName()).log(Level.SEVERE, null, ex);
            a = null;
        }
        finally
        {
            DBConnection.getInstance().cerrarConexion(con);
        }

        return success;
    }

    public boolean updateCar(Car a)
    {
        Connection con = null;
        boolean success = false;
        try
        {
            con = DBConnection.getInstance().getConnection();
            con.setAutoCommit(false);
            PreparedStatement stmt = con.prepareStatement("UPDATE EXAMEN SET COCHE=?,COMPRADO=? VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);

           

            int filas = stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next())
            {
                int id = rs.getInt(1);
                 PreparedStatement stmt2 = con.prepareStatement("INSERT INTO EXAMEN1 (FECHA_COMPRA,KM,DESCUENTO) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);



                int filas2 = stmt.executeUpdate();

                if(filas2 > 0)
                {
                    success = true;
                    con.commit();
                }
                else
                {
                    success = false;
                    con.rollback();
                }
            }
        }
        catch (Exception ex)
        {
            Logger.getLogger(CrudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return success;
    }

    public boolean deleteCar(Car a)
    {
        Connection con = null;
        boolean retur = false;
        int filas = 0;
        try
        {
            con = DBConnection.getInstance().getConnection();
            String sql = "DELETE FROM ALUMNOS WHERE ID = ?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setLong(1, a.getId());

            filas = stmt.executeUpdate();

        }
        catch (SQLIntegrityConstraintViolationException ex)
        {
            Logger.getLogger(CrudDAO.class.getName()).log(Level.SEVERE, null, ex);
            filas = -1;
        }
        catch (Exception ex)
        {
            Logger.getLogger(CrudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            DBConnection.getInstance().cerrarConexion(con);
        }
        if(filas > 0)
        {
            retur = true;
        }
        return retur;
    }

    public int delUser2(Car a)
    {
        Connection con = null;
        int filas = 0;
        try
        {

            con = DBConnection.getInstance().getConnection();
            con.setAutoCommit(false);
            String sql = "DELETE FROM NOTAS WHERE ID_ALUMNO = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, a.getId());

            filas += stmt.executeUpdate();

            sql = "DELETE FROM ALUMNOS WHERE ID = ?";
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, a.getId());

            filas += stmt.executeUpdate();
            con.commit();

        }
        catch (Exception ex)
        {
            Logger.getLogger(CrudDAO.class.getName()).log(Level.SEVERE, null, ex);
            try
            {
                if (con != null)
                {
                    con.rollback();
                }
            }
            catch (SQLException ex1)
            {
                Logger.getLogger(CrudDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        finally
        {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return filas;
    }
}
