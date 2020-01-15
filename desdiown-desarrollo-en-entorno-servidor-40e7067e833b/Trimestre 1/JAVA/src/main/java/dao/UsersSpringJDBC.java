package dao;

import ajax.AjaxMaker;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import utils.Constants;

public class UsersSpringJDBC
{

    private final AjaxMaker ajax = new AjaxMaker();

    /* REGISTER */
    public int findUserByEmail(User usr)
    {
        JdbcTemplate jdbcTemplateObject = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        String sql = "SELECT COUNT(*) FROM " + Constants.SQL_TABLE_USERS + " WHERE " + Constants.SQL_TABLE_USERS_FIELD_EMAIL + " = ?";
        int usersWithMail = jdbcTemplateObject.queryForObject(sql, Integer.class, usr.getEMAIL());
        return usersWithMail;
    }

    public long doRegister(User usr)
    {

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(DBConnection.getInstance().getDataSource()).withTableName(Constants.SQL_TABLE_USERS).usingGeneratedKeyColumns(Constants.SQL_TABLE_USERS_FIELD_ID);
        ObjectMapper m = new ObjectMapper();
        long insertedID = jdbcInsert.executeAndReturnKey(m.convertValue(usr, Map.class)).longValue();
        
        return insertedID;
    }

    /* LOGIN */
    public User getUserByEmail(User usr)
    {
        JdbcTemplate jdbcTemplateObject = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        String sql = "SELECT " + Constants.SQL_TABLE_USERS_FIELD_ACTIVE + "," + Constants.SQL_TABLE_USERS_FIELD_PASSWORD + " FROM " + Constants.SQL_TABLE_USERS + " WHERE " + Constants.SQL_TABLE_USERS_FIELD_EMAIL + " = ?";
        User foundUsr = (User) jdbcTemplateObject.queryForObject(
                sql, new Object[]
                {
                    usr.getEMAIL()
                },
                new BeanPropertyRowMapper(User.class));
        return foundUsr;
    }

    /* ACTIVATION */
    public User findUserByVerificationCode(User usr)
    {
        JdbcTemplate jdbcTemplateObject = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        String sql = "SELECT * FROM " + Constants.SQL_TABLE_USERS + " WHERE " + Constants.SQL_TABLE_USERS_FIELD_ACTCODE + " = ? AND " + Constants.SQL_TABLE_USERS_FIELD_ACTIVE + "=0";
        
        User data = (User) jdbcTemplateObject.queryForObject(sql, new Object[] {  usr.getCODIGO_ACTIVACION() }, new BeanPropertyRowMapper(User.class));
        return data;
    }
    public int findUserCountByVerificationCode(User usr)
    {
        JdbcTemplate jdbcTemplateObject = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        String sql = "SELECT COUNT(*) FROM " + Constants.SQL_TABLE_USERS + " WHERE " + Constants.SQL_TABLE_USERS_FIELD_ACTCODE + " = ? AND " + Constants.SQL_TABLE_USERS_FIELD_ACTIVE + "=0";
        
        int count = jdbcTemplateObject.queryForObject(sql, Integer.class, usr.getCODIGO_ACTIVACION());
        return count;
    }
    public int activateUser(User usr)
    {
        JdbcTemplate jdbcTemplateObject = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        int updatedRows = jdbcTemplateObject.update("UPDATE " + Constants.SQL_TABLE_USERS + " SET " + Constants.SQL_TABLE_USERS_FIELD_ACTIVE + "=1 WHERE " + Constants.SQL_TABLE_USERS_FIELD_ACTCODE + " = ?", usr.getCODIGO_ACTIVACION());
        return updatedRows;
    }
}
