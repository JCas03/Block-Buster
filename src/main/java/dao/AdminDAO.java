package dao;

import model.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
  public AdminDAO() { }
  public Admin getAdmin(String help) {

    Admin admin = null;
    try (Connection connection = dao.Connection.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("Select * from admin where email = ?");) {

      preparedStatement.setString(1, help);
      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        int id = rs.getInt("id");

        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");

        String email =rs.getString("email");
        String password = rs.getString("password");
        admin = new Admin(id, firstName, lastName, email, password);
        System.out.print(admin);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      return admin;
    }
  }


}
