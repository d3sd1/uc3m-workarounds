package dao;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import utils.ConfigDatabase;

public class DBConnection
{

    public DBConnection()
    {

    }
    private static DBConnection dbconection = null;

    public Connection getConnection() throws Exception
    {
        Class.forName(ConfigDatabase.getInstance().getDriverDB());
        Connection connection = null;

        connection = DriverManager.getConnection(ConfigDatabase.getInstance().getUrlDB(),
                ConfigDatabase.getInstance().getUserDB(),
                ConfigDatabase.getInstance().getPassDB());

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
        mysql.setUrl(ConfigDatabase.getInstance().getUrlDB());
        mysql.setUser(ConfigDatabase.getInstance().getUserDB());
        mysql.setPassword(ConfigDatabase.getInstance().getPassDB());

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(ConfigDatabase.getInstance().getDriverDB());
        dataSource.setUrl(ConfigDatabase.getInstance().getUrlDB());
        dataSource.setUsername(ConfigDatabase.getInstance().getUserDB());
        dataSource.setPassword(ConfigDatabase.getInstance().getPassDB());

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
            
        }
    }
}
