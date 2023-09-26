package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.chi_tiet_san_pham;

public class DAOchitietsanpham {

	public static DAOchitietsanpham getIntance() {
		return new DAOchitietsanpham();
	}
	
	public chi_tiet_san_pham selectById(chi_tiet_san_pham t) {
		chi_tiet_san_pham chi_tiet_san_pham = new chi_tiet_san_pham();
		
		try {
			Connection connection = JDBSUtil.getConnection();
			
			String sql = "SELECT * FROM chi_tiet_san_pham WHERE ma_giay = ?";

			PreparedStatement pps = connection.prepareStatement(sql);

			pps.setString(1, t.getMa_giay());

			ResultSet rs = pps.executeQuery();

			while (rs.next()) {
				String ma_giay = rs.getString("ma_giay");
				String tong_quan = rs.getString("tong_quan");
				String tong_quan_1 = rs.getString("tong_quan_1");
				String tong_quan_2 = rs.getString("tong_quan_2");
				String de_giay = rs.getString("de_giay");
				
				chi_tiet_san_pham = new chi_tiet_san_pham(ma_giay, tong_quan, tong_quan_1, tong_quan_2, de_giay);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chi_tiet_san_pham;
	}

	
}
