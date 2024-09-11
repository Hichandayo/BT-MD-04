package ra.mainmd04;

import ra.mainmd04.model.Customer;
import ra.mainmd04.utils.ConnectionDB;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        //them du lieu
//        String sql = "INSERT INTO customer(name, address, email) value('Nguyen Van A','hcm','a@gmail.com')";
//        String sql = "INSERT INTO customer(name, address, email) value(?,?,?)";
//        String sql = "select * from customer";
        // mo ket noi
        Connection conn = null;
        conn = ConnectionDB.getConnection();
        try {
            Statement statement = conn.createStatement();
            //them du lieu
//            statement.execute(sql);
            // sua du lieu
//            ResultSet rs =  statement.executeQuery(sql);
//            PreparedStatement prepare = conn.prepareStatement(sql);
//            prepare.setString(1,"Nguyen The Hien");
//            prepare.setString(2,"LA");
//            prepare.setString(3,"hien@gmail.com");

//            prepare.executeUpdate();
//            while(rs.next()){
//                Customer c = new Customer();
//                c.setId(rs.getInt("id"));
//                c.setName(rs.getString("Name"));
//                c.setAddress(rs.getString("Address"));
//                c.setEmail(rs.getString("Email"));
//                System.out.println(c);
//            }
            CallableStatement callSt = conn.prepareCall("{call createCustomer(?,?,?,?)}");
            // truyen tham so
            callSt.setString(1,"Hien");
            callSt.setString(2,"KG");
            callSt.setString(3,"thehien@gmail.com");
            // dang ky tham so out
            callSt.registerOutParameter(4,Types.INTEGER);
            callSt.executeUpdate();
            int total = callSt.getInt(4);
            System.out.println("total" + total);
        }catch(SQLException e){
            System.err.println("khong co sql");
        }finally {
            ConnectionDB.closeConnection(conn);
        }
        System.out.println("Ket Thuc");
    }
}
