package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.JDBCUtil;

public class TestJDBCUtil {
	public static void main(String[] args) {
		
		try {
			//B1: Tạo kết nối
			Connection connection = JDBCUtil.getConnection();
			
			//B2: Tạo ra đối tượng Statement
			Statement st = connection.createStatement();
			
			//B3: Thực thi câu lệnh sql
			String sql = "INSERT INTO `persons` (`person_id`, `first_name`, `last_name`, `gender`, `dob`, `income`)"
					+ " VALUES (NULL, 'Ting', 'Sì', 'M', NULL, NULL)\r\n";
			
			//B4: Xử lý kết quả
			int check = st.executeUpdate(sql);
			
			System.out.println("Số dòng thay đổi: " + check);
			if(check > 0) {
				System.out.println("Thêm dữ liệu thành công");
			} else {
				System.out.println("Thêm dữ liệu thất bại");
			}
			
			//B5: Ngắt kết nối
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
