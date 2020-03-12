package spring.database.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;
import spring.database.model.User;
import spring.database.model.UserRowMapper;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

/**
 * @Created 12 / 03 / 2020 - 10:43 AM
 * @project database
 * @Author Hamdamboy
 */

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getUser(){
        return  jdbcTemplate.query("select id,firstname,lastname,city , country , phoneno,emailid from user", new UserRowMapper());
    }

    public User findById(Integer id){

        String sql = "SELECT * FROM user WHERE ID = ?";
        try{
            return  (User) this.jdbcTemplate.queryForObject(sql, new Object[] { id }, new UserRowMapper());
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }

    }

    public Boolean saveUser(User user){
        String query="insert into user values(?,?,?,?,?,?,?)";
        return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setInt(1,user.getId());
                ps.setString(2,user.getFirstname());
                ps.setString(3,user.getLastname());
                ps.setString(4,user.getCity());
                ps.setString(5,user.getCountry());
                ps.setString(6,user.getPhoneno());
                ps.setString(7,user.getEmailid());

                return ps.execute();

            }
        });
    }

    public Integer updateUser(User user){
        String query="update user set firstname = ? , lastname = ? , city = ? , country = ? , phoneno = ? , emailid = ? where id = ?";
        Object[] params = {user.getFirstname(), user.getLastname(),user.getCity(),user.getCountry(),user.getPhoneno(),user.getEmailid(), user.getId()};
        int[] types = {Types.VARCHAR, Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.INTEGER};

        return jdbcTemplate.update(query, params, types);
    }

    public Integer deleteUserById(Integer id){
        return jdbcTemplate.update("delete from user where id = ?",id);
    }
}
