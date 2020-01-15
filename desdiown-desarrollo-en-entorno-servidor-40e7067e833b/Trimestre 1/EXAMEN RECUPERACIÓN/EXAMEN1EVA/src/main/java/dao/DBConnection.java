package dao;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import config.Config;

public class DBConnection
{

    public DBConnection()
    {

    }
    private static DBConnection dbconection = null;

    public Connection getConnection() throws Exception
    {
        Class.forName(Config.getInstance().getDriverDB());
        Connection connection = null;

        connection = DriverManager.getConnection(Config.getInstance().getUrlDB(),
                Config.getInstance().getUserDB(),
                Config.getInstance().getPassDB());

        return connection;
    }

    public static DBConnection getInstance()
    {
        if (dbconection == null)
        {
            dbconection = new DBConnection();
        }

        return dbconection;
    }

    public DataSource getDataSourceFromServer() throws NamingException
    {
        Context ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("jdbc/db4free");
        return ds;

    }

    public DataSource getDataSource()
    {
        MysqlDataSource mysql = new MysqlConnectionPoolDataSource();
        mysql.setUrl(Config.getInstance().getUrlDB());
        mysql.setUser(Config.getInstance().getUserDB());
        mysql.setPassword(Config.getInstance().getPassDB());

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(Config.getInstance().getDriverDB());
        dataSource.setUrl(Config.getInstance().getUrlDB());
        dataSource.setUsername(Config.getInstance().getUserDB());
        dataSource.setPassword(Config.getInstance().getPassDB());

        return mysql;
    }

    public void closeCon(Connection connection)
    {
        try
        {
            if (connection != null)
            {
                connection.close();
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void closeStmt(Statement statement)
    {
        try
        {
            if (statement != null)
            {
                statement.close();
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void closeStmt(PreparedStatement statement)
    {
        try
        {
            if (statement != null)
            {
                statement.close();
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
