package dao;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import configuration.Config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DBConnection_DataSource_Spring
{

    private static DBConnection_DataSource_Spring dbconection = null;


    public static DBConnection_DataSource_Spring getInstance()
    {
        if (dbconection == null)
        {
            dbconection = new DBConnection_DataSource_Spring();
        }

        return dbconection;
    }

    public MysqlDataSource getDataSource()
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

    public void close(Connection connection)
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
            Logger.getLogger(DBConnection_DataSource_Spring.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close(Statement statement)
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
            Logger.getLogger(DBConnection_DataSource_Spring.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close(PreparedStatement statement)
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
            Logger.getLogger(DBConnection_DataSource_Spring.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
