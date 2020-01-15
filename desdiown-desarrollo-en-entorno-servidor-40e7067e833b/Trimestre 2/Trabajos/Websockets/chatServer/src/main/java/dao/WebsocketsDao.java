package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import model.Channel;
import model.DateFilter;
import model.Message;
import model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;

public class WebsocketsDao
{

    private final String SQL_INSERT_MSG = "INSERT INTO messages (sender_id,message,date_sent,channel_id) VALUES (?,?,?,?)";
    private final String SQL_MSG_BETWEEN_DATES = "SELECT m.message,m.date_sent,l.id,l.email, m.id FROM messages m JOIN login l ON m.sender_id=l.id WHERE channel_id=? AND date_sent BETWEEN ? AND ?";
    private final String SQL_GET_CHANNEL = "SELECT c.id, c.name, c.admin_id, c.password FROM channels c";
    private final String SQL_INSERT_CHANNEL = "INSERT INTO channels (name,admin_id,password) VALUES (?,?,?)";
    private final String SQL_INSERT_CHANNEL_USER = "INSERT INTO users_channels (user_id,channel_id) VALUES (?,?)";
    private final String SQL_FIND_CHANNEL_OWNER = "SELECT l.id,l.email,l.online FROM channels c JOIN login l ON l.id=c.admin_id WHERE c.id=?";
    private final String SQL_INSERT_PERMISSION = "INSERT INTO users_channels (user_id,channel_id) VALUES (?,?)";

    public int saveMessage(Message msg)
    {
        int generatedKey = 0;
        try
        {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(DBConnection.getInstance().getDataSource());
            GeneratedKeyHolder holder = new GeneratedKeyHolder();
            jdbcTemplate.update(
                    connection -> {
                  PreparedStatement ps = connection.prepareStatement(SQL_INSERT_MSG, new String[]{"ID"});
                  ps.setInt(1, msg.getSender().getId());
                  ps.setString(2, msg.getMensaje());
                  ps.setTimestamp(3, msg.getDate());
                  ps.setInt(4, msg.getChannel_id());
                  return ps;
              }, holder);
            generatedKey = holder.getKey().intValue();
        }
        catch (Exception e)
        {
            generatedKey = 0;
        }
        return generatedKey;
    }
    public Channel addChannel(Channel channel)
    {
        try
        {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(DBConnection.getInstance().getDataSource());
            GeneratedKeyHolder holder = new GeneratedKeyHolder();
            jdbcTemplate.update(
                    connection -> {
                  PreparedStatement ps = connection.prepareStatement(SQL_INSERT_CHANNEL, new String[]{"ID"});
                  ps.setString(1, channel.getName());
                  ps.setInt(2, channel.getAdmin_id());
                  ps.setString(3, channel.getPassword());
                  return ps;
              }, holder);
            int generatedKey = holder.getKey().intValue();
            channel.setId(generatedKey);
            jdbcTemplate.update(
                    connection -> {
                  PreparedStatement ps = connection.prepareStatement(SQL_INSERT_CHANNEL_USER, new String[]{"ID"});
                  ps.setInt(1, channel.getAdmin_id());
                  ps.setInt(2, channel.getId());
                  return ps;
              });
        }
        catch (Exception e)
        {
            channel.setId(0);
        }
        return channel;
    }
    public List<Message> getMessagesBetweenDates(DateFilter df)
    {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DBConnection.getInstance().getDataSource());
	List<Message> messages  = jdbcTemplate.query(SQL_MSG_BETWEEN_DATES, new RowMapperResultSetExtractor<>((ResultSet rs, int rowNum) ->
        {
            Message msg = new Message ();
            User sender = new User();
            msg.setMensaje(rs.getString(1));
            msg.setSave(false);
            msg.setDate(rs.getTimestamp(2));
            sender.setId(rs.getInt(3));
            sender.setEmail(rs.getString(4));
            msg.setSender(sender);
            msg.setId(rs.getInt(5));
            return msg;
        }),new Object[]{df.getChannel().getId(), df.getBeginDateFormatted(), df.getEndDateFormatted()});
        
        return messages;
    }
    public List<Channel> loadAllChannels(User user)
    {
        UsersDao uDao = new UsersDao();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        List<Channel> userChannels = uDao.loadUserChannels(user);
	List<Channel> channels  = jdbcTemplate.query(SQL_GET_CHANNEL, new RowMapperResultSetExtractor<>((ResultSet rs, int rowNum) ->
        {
            Channel channel = new Channel();
            channel.setId(rs.getInt(1));
            channel.setName(rs.getString(2));
            channel.setAdmin_id(rs.getInt(3));
            boolean hasPermissionsForChannel = false;
            for (Channel userActualChannel : userChannels) {
                if(userActualChannel.getId() == channel.getId())
                {
                    hasPermissionsForChannel = true;
                }
            }
            channel.setActualUserHasPermissions(hasPermissionsForChannel);
            if(channel.getActualUserHasPermissions())
            {
                channel.setPassword(rs.getString(4));
            }
            return channel;
        }));
        
        return channels;
    }
    public User findChannelOwner(Channel channel)
    {
        User foundUser = new User();
        try
        {
            JdbcTemplate jdbcTemplateObject = new JdbcTemplate(DBConnection.getInstance().getDataSource());
            foundUser = (User) jdbcTemplateObject.queryForObject(
                    SQL_FIND_CHANNEL_OWNER, new Object[]
                    {
                        channel.getId()
                    },
                    new BeanPropertyRowMapper(User.class));
        }
        catch (Exception e)
        {
            foundUser = new User();
        }
        return foundUser;
    }
    public void addPermissionsToUserOnChannel(int userId, int channelId)
    {
        try
        {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(DBConnection.getInstance().getDataSource());
            jdbcTemplate.update(
                    connection -> {
                  PreparedStatement ps = connection.prepareStatement(SQL_INSERT_PERMISSION);
                  ps.setInt(1, userId);
                  ps.setInt(2, channelId);
                  return ps;
              });
        }
        catch (Exception e)
        {
            
        }
    }

}
