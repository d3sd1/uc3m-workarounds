package dao;

import java.time.LocalDateTime;
import model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class LoginDAO
{

    /* Aquí sólo queries */
    private final String SQL_QUERY_LOGIN = "SELECT COUNT(*) FROM USERS WHERE NOMBRE = ?";
    private final String SQL_QUERY_ISACTIVE = "SELECT COUNT(*) FROM USERS WHERE NOMBRE = ? AND ACTIVO=1";
    private final String SQL_QUERY_ISEXPIRED = "SELECT FECHA_ACTIVACION FROM USERS WHERE NOMBRE = ?";
    private final String SQL_QUERY_SETINACTIVE = "UPDATE USERS SET ACTIVO=0 WHERE NOMBRE = ?";
    private final String SQL_QUERY_LOGINPHP = "SELECT COUNT(*) FROM login_php WHERE NOMBRE = ? AND PASSWORD = ?";
    private final String SQL_QUERY_FINDUSERPHP = "SELECT COUNT(*) FROM login_php WHERE NOMBRE = ?";

    public boolean findUserByName(String userName)
    {
        JdbcTemplate jdbcTemplateObject = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        int usersWithMail = jdbcTemplateObject.queryForObject(SQL_QUERY_LOGIN, Integer.class, userName);
        return (usersWithMail > 0);
    }
    
    public boolean findPhpUserByLogin(String userName, String password)
    {
        JdbcTemplate jdbcTemplateObject = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        int usersWithMail = jdbcTemplateObject.queryForObject(SQL_QUERY_LOGINPHP, Integer.class, userName, password);
        return (usersWithMail > 0);
    }
    
    public boolean findPhpUserByName(String userName)
    {
        JdbcTemplate jdbcTemplateObject = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        int usersWithMail = jdbcTemplateObject.queryForObject(SQL_QUERY_FINDUSERPHP, Integer.class, userName);
        return (usersWithMail > 0);
    }
    public boolean isUserActive(String userName)
    {
        JdbcTemplate jdbcTemplateObject = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        int usersWithMail = jdbcTemplateObject.queryForObject(SQL_QUERY_ISACTIVE, Integer.class, userName);
        return (usersWithMail > 0);
    }
    public LocalDateTime getUserActivationDate(String userName) throws NullPointerException
    {
        JdbcTemplate jdbcTemplateObject = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        User foundUsr = (User) jdbcTemplateObject.queryForObject(
                SQL_QUERY_ISEXPIRED, new Object[]
                {
                    userName
                },
                new BeanPropertyRowMapper(User.class));
        return foundUsr.getFECHA_ACTIVACION();
    }
    public boolean setUserInactive(String userName)
    {
        JdbcTemplate jdbcTemplateObject = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        int updatedRows = jdbcTemplateObject.update(SQL_QUERY_SETINACTIVE, userName);
        return (updatedRows > 0);
    }
}
