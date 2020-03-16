package spring.jdbc.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Created 16 / 03 / 2020 - 9:31 AM
 * @project SpringJDBC
 * @Author Hamdamboy
 */
public class FamilyRowMapper implements RowMapper {
    //
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
        FamilyMember familyMember = new FamilyMember();
        familyMember.setId(rs.getInt("id"));
        familyMember.setFirstname(rs.getString("firstname"));
        familyMember.setLastname(rs.getString("lastname"));
        familyMember.setAge(rs.getInt("age"));

        return familyMember;

    }
}
