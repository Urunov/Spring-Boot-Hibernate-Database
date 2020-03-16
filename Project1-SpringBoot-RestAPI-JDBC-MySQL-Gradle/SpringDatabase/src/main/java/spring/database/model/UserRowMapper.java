package spring.database.model;

<<<<<<< HEAD
import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;
=======
import org.springframework.jdbc.core.RowMapper;
>>>>>>> 384b3fd98fd1c82ac0ed0c83fd266f42d71a1c87
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Created 12 / 03 / 2020 - 10:16 AM
 * @project database
 * @Author Hamdamboy
 */
public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User(); // Obj of User, and mapping DB elements.
        user.setId(rs.getInt("id"));
        user.setFirstname(rs.getString("firstname"));
        user.setLastname(rs.getString("lastname"));
        user.setCity(rs.getString("city"));
        user.setCountry(rs.getString("country"));
        user.setPhoneno(rs.getString("phoneno"));
        user.setEmailid(rs.getString("emailid"));
        return user;
    }
<<<<<<< HEAD


    @Override
    public int[] getRowsForPaths(TreePath[] path) {
        return new int[0];
    }
=======
>>>>>>> 384b3fd98fd1c82ac0ed0c83fd266f42d71a1c87
}
