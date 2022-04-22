import java.sql.*;

public class CountryDAO {
    String continent;

    public void create(String name , int id) {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("insert into countries (id, name, continent) values (?, ?, ?)")) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, continent);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from countries where name like '%" + name + "%'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }
    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select name from countries where id = '" + id + "'")) {
            return rs.next() ? rs.getString(2) : null;
        }
    }
}
