package dao;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestDAO
{
    private final String SQL_QUERY_LOGIN = "SELECT NOMBRE FROM USERS WHERE NOMBRE = ?";
    /* Aquí sólo queries */
    public User getUserByMail(String mail)
    {
        User u;
        try
        {
            JdbcTemplate jtm = new JdbcTemplate(DBConnection_DataSource_Hikari.getInstance().getDataSource());
            u = (User) jtm.queryForObject(SQL_QUERY_LOGIN, new Object[]
            {
                mail
            }, new BeanPropertyRowMapper(User.class));
        }
        catch (DataAccessException ex)
        {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
            u = null;
        }
        return u;
    }
}
