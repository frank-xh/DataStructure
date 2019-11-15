//
//
//import org.junit.Test;
//
//import java.sql.*;
//
//public class DBCTest {
//    @Test
//    public void test(){
//        Connection connection=null;
//        PreparedStatement preparedStatement=null;
//        ResultSet resultSet=null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            connection= DriverManager.getConnection("jdbc:mysql://192.168.164.128:3306/test","root","190255");
//            preparedStatement=connection.prepareStatement("select*from user where id=?");
//            preparedStatement.setString(1,"2");
//            resultSet=preparedStatement.executeQuery();
//            while (resultSet.next()){
//                System.out.println(resultSet.getInt("id"));
//                System.out.println(resultSet.getString("username"));
//
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }finally {
//            if(resultSet!=null)
//            try {
//                resultSet.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            if(preparedStatement!=null) {
//                try {
//                    preparedStatement.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            if(connection!=null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            }
//        }
//    }
//}
