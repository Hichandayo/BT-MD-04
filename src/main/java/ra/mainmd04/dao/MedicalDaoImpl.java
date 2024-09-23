package ra.mainmd04.dao;

import ra.mainmd04.model.Medical;
import ra.mainmd04.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicalDaoImpl implements IMedical{

    @Override
    public List<Medical> getAll() {
        Connection connection = ConnectionDB.getConnection();
        CallableStatement sta = null;
        List<Medical> medicals = new ArrayList<>();
        try{
            sta = connection.prepareCall("select * from Medical");
            ResultSet rs = sta.executeQuery();
            while (rs.next()){
                Medical medical = new Medical(
                        rs.getInt("id"),
                        rs.getString("fullName"),
                        rs.getString("dateOfBirth"),
                        rs.getString("gender"),
                        rs.getString("address"),
                        rs.getString("phoneNumber"),
                        rs.getString("healthIssues")
                );
                medicals.add(medical);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection);
        }
        return medicals;
    }

    @Override
    public Medical findById(Integer id) {
        Connection connection = ConnectionDB.getConnection();
        CallableStatement sta = null;
        ResultSet rs = null;
        try{
            sta = connection.prepareCall("select * from Medical where id =?");
            sta.setInt(1, id);
            rs = sta.executeQuery();
            if(rs.next()){
                Medical medical = new Medical(
                        rs.getInt("id"),
                        rs.getString("fullName"),
                        rs.getString("dateOfBirth"),
                        rs.getString("gender"),
                        rs.getString("address"),
                        rs.getString("phoneNumber"),
                        rs.getString("healthIssues")
                );
                return medical;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection);
        }
        return null;
    }

    @Override
    public void update(Medical medical) {
        Connection connection = ConnectionDB.getConnection();
        CallableStatement sta = null;
        try{
            sta = connection.prepareCall("update Medical set fullName =?, dateOfBirth =?, gender =?, address =?, phoneNumber =?, healthIssues =? where id =?");
            sta.setString(1, medical.getFullName());
            sta.setString(2, medical.getDateOfBirth());
            sta.setString(3, medical.getGender());
            sta.setString(4, medical.getAddress());
            sta.setString(5, medical.getPhoneNumber());
            sta.setString(6, medical.getHealthIssues());
            sta.setInt(7, medical.getId());
            sta.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection);
        }
    }
}
