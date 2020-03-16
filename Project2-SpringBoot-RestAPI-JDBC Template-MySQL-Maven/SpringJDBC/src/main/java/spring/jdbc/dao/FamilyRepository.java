package spring.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import spring.jdbc.model.FamilyMember;
import spring.jdbc.model.FamilyRowMapper;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

/**
 * @Created 14 / 03 / 2020 - 9:34 PM
 * @project SpringJDBC
 * @Author Hamdamboy
 */
@Repository
public class FamilyRepository implements FamilyDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<FamilyMember> getMembers(){
        return jdbcTemplate.query("select id, firstname, lastname, age from family", new FamilyRowMapper());
    }


    @Override
    public FamilyMember getNameById(int id) {
        //
        String sql = "SELECT * FROM family WHERE ID = ?";
        try {
         return (FamilyMember)this.jdbcTemplate.queryForObject(sql, new Object[] {id}, new FamilyRowMapper());
        }catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public FamilyMember findByName(FamilyMember firstname) {
        String sql = "SELECT * FROM family WHERE firstname = ?";

        return null;
    }

    @Override
    public boolean saveMember(FamilyMember member) {

        String query = "insert into family values(?, ?, ?, ?)";
        return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.setInt(1, member.getId());
                preparedStatement.setString(2, member.getFirstname());
                preparedStatement.setString(3,member.getLastname());
                preparedStatement.setInt(4, member.getAge());

                return preparedStatement.execute();
            }
        });
    }

    @Override
    public int updateMember(FamilyMember member) {
        String query = "update family set " + "firstname = ?, lastname =?, age = ?" + " where id =?";
        Object[] parameters = {member.getFirstname(), member.getLastname(), member.getAge()};
        int[] types = {Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.INTEGER};



       return jdbcTemplate.update(query, parameters, types);
    }



    @Override
    public List<FamilyMember> findAll() {
       // List<FamilyMember> getMembers;
        return jdbcTemplate.query("select id, firstname, lastname, age from family", new FamilyRowMapper());
    }

    @Override
    public void deleteMember(Integer id) {
        jdbcTemplate.update("delete from family where id = ?", id);
    }
}

