package dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import model.Channel;
import model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import utils.PasswordHash;

public class UsersDao
{
    private final String SQL_GET_USER_CHANNELS = "SELECT c.id,c.name,c.admin_id FROM users_channels uc JOIN channels c ON c.id=uc.channel_id WHERE uc.user_id=?";
    private final String SQL_GET_USER = "SELECT l.id, l.email, l.online FROM login l";
    private final String SQL_FIND_USER = "SELECT * FROM login WHERE email=?";
    private final String SQL_FIND_USER_BYID = "SELECT * FROM login WHERE id=?";
    private final String SQL_FIND_USER_WITHPASS = "SELECT id FROM login WHERE email=? AND pass=?";
    private final String SQL_UPDATE_USER_STATUS = "UPDATE login SET online=? WHERE id=?";

    public List<User> loadAllUsers()
    {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(DBConnection.getInstance().getDataSource());
	List<User> users  = jdbcTemplate.query(SQL_GET_USER, new RowMapperResultSetExtractor<>((ResultSet rs, int rowNum) ->
        {
            User user = new User();
            user.setId(rs.getInt(1));
            user.setEmail(rs.getString(2));
            user.setOnline(rs.getBoolean(3));
            user.setSubscribedChannels(loadUserChannels(user));
            return user;
        }));
        
        return users;
    }
    public List<Channel> loadUserChannels(User user)
    {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(DBConnection.getInstance().getDataSource());
	List<Channel> channels  = jdbcTemplate.query(SQL_GET_USER_CHANNELS, new Object[] {user.getId()}, new RowMapperResultSetExtractor<>((ResultSet rs, int rowNum) ->
        {
            Channel channel = new Channel();
            channel.setId(rs.getInt(1));
            channel.setName(rs.getString(2));
            channel.setAdmin_id(rs.getInt(3));
            return channel;
        }));
        
        return channels;
    }
    public User findUser(User user)
    {
        User foundUser;
        try
        {
            JdbcTemplate jdbcTemplateObject = new JdbcTemplate(DBConnection.getInstance().getDataSource());
            foundUser = (User) jdbcTemplateObject.queryForObject(
                    SQL_FIND_USER_BYID, new Object[]
                    {
                        user.getId()
                    },
                    new BeanPropertyRowMapper(User.class));
        }
        catch (Exception e)
        {
            foundUser = new User();
        }
        return foundUser;
    }
    public User getUser(User user, boolean hashPass, boolean forceRegister)
    {
        User foundUser = new User();
        try
        {
            JdbcTemplate jdbcTemplateObject = new JdbcTemplate(DBConnection.getInstance().getDataSource());
            foundUser = (User) jdbcTemplateObject.queryForObject(
                    SQL_FIND_USER, new Object[]
                    {
                        user.getEmail()
                    },
                    new BeanPropertyRowMapper(User.class));
        }
        catch (Exception e)
        {
            foundUser = doRegister(user, hashPass);
        }
        return foundUser;
    }

    public User doRegister(User user, boolean hashPass)
    {
        if (hashPass)
        {
            String hash = PasswordHash.getInstance().createHash(user.getPass());
            user.setPass(hash);
        }
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(DBConnection.getInstance().getDataSource()).withTableName("login").usingGeneratedKeyColumns("id");
        ObjectMapper m = new ObjectMapper();
        Number generatedKey = jdbcInsert.executeAndReturnKey(m.convertValue(user, Map.class));
        user.setId(generatedKey.intValue());
        return user;
    }
    public void setUserStatus(User user)
    {
        try
        {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(DBConnection.getInstance().getDataSource());
            jdbcTemplate.update(
                    connection -> {
                  PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_USER_STATUS, new String[]{"ID"});
                  ps.setBoolean(1, user.getOnline());
                  ps.setInt(2, user.getId());
                  return ps;
              });
        }
        catch (Exception e)
        {
            
        }
    }

}
