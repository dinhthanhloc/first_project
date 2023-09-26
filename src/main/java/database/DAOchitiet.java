package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.chi_tiet_don_hang;

public class DAOchitiet implements DAOinterface<chi_tiet_don_hang> {

	public static DAOchitiet getIntance() {
		return new DAOchitiet();
	}

	@Override
	public int insert(chi_tiet_don_hang t) {
		try {
			Connection connection = JDBSUtil.getConnection();

			String sql = "INSERT INTO chi_tiet_don_hang (ma_don_hang=?, ma_giay=?,so_luong=?,gia_ban=?,giam_gia=?,thue_vat=?,tong_tien=?)"
					+ "VALUE (?,?,?,?,?,?,?)";

			PreparedStatement pps = connection.prepareStatement(sql);

			pps.setString(1, t.getMa_don_hang());
			pps.setString(2, t.getMa_giay());
			pps.setInt(3, t.getSo_luong());
			pps.setFloat(4, t.getGia_ban());
			pps.setFloat(5, t.getGiam_gia());
			pps.setFloat(6, t.getThue_vat());
			pps.setFloat(7, t.getTong_tien());

			int check = pps.executeUpdate();

			System.out.println("Bạn đã thực hiện câu lệnh: " + sql);
			System.out.println("Có " + check + " dòng bị thay đổi");

			JDBSUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int update(chi_tiet_don_hang t) {
		try {
			Connection connection = JDBSUtil.getConnection();

			String sql = "UPDATE chi_tiet_don_hang SET (ma_giay=?, so_luong=?,gia_ban=?,giam_gia=?,thue_vat=?,tong_tien=?) "
					+ "WHERE ma_don_hang=?";

			PreparedStatement pps = connection.prepareStatement(sql);

			pps.setString(1, t.getMa_giay());
			pps.setInt(2, t.getSo_luong());
			pps.setFloat(3, t.getGia_ban());
			pps.setFloat(4, t.getGiam_gia());
			pps.setFloat(5, t.getThue_vat());
			pps.setFloat(6, t.getTong_tien());
			pps.setString(7, t.getMa_don_hang());

			int check = pps.executeUpdate();

			System.out.println("Bạn đã thực hiện câu lệnh: " + sql);
			System.out.println("Có " + check + " dòng bị thay đổi");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int delete(chi_tiet_don_hang t) {
		try {
			Connection connection = JDBSUtil.getConnection();

			String sql = "DELETE from chi_tiet_don_hang  WHERE ma_don_hang = ?";

			PreparedStatement pps = connection.prepareStatement(sql);

			pps.setString(1, t.getMa_don_hang());

			int check = pps.executeUpdate();

			System.out.println("Bạn đã thực hiện câu lệnh: " + sql);
			System.out.println("Có " + check + " dòng bị thay đổi");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<chi_tiet_don_hang> selectAll() {
		ArrayList<chi_tiet_don_hang> list = new ArrayList<>();
		try {
			Connection connection = JDBSUtil.getConnection();

			String sql = "SELECT * FROM chi_tiet_don_hang";

			PreparedStatement pps = connection.prepareStatement(sql);

			ResultSet rs = pps.executeQuery();

			while (rs.next()) {
				String ma_don_hang = rs.getString("ma_don_hang");
				String ma_giay = rs.getString("ma_giay");
				Integer so_luong = rs.getInt("so_luong");
				Float gia_ban = rs.getFloat("gia_ban");
				Float giam_gia = rs.getFloat("giam_gia");
				Float thue_vat = rs.getFloat("thue_vat");
				Float tong_tien = rs.getFloat("tong_tien");

				chi_tiet_don_hang chi_tiet_don_hang = new chi_tiet_don_hang(ma_don_hang, ma_giay, so_luong, gia_ban,
						giam_gia, thue_vat, tong_tien);

				list.add(chi_tiet_don_hang);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public chi_tiet_don_hang selectById(chi_tiet_don_hang t) {
		chi_tiet_don_hang chi_tiet_don_hang = new chi_tiet_don_hang();
		try {
			Connection connection = JDBSUtil.getConnection();

			String sql = "SELECT * FROM chi_tiet_don_hang WHERE ma_don_hang = ?";

			PreparedStatement pps = connection.prepareStatement(sql);

			pps.setString(1, t.getMa_don_hang());

			ResultSet rs = pps.executeQuery();

			while (rs.next()) {
				String ma_don_hang = rs.getString("ma_don_hang");
				String ma_giay = rs.getString("ma_giay");
				Integer so_luong = rs.getInt("so_luong");
				Float gia_ban = rs.getFloat("gia_ban");
				Float giam_gia = rs.getFloat("giam_gia");
				Float thue_vat = rs.getFloat("thue_vat");
				Float tong_tien = rs.getFloat("tong_tien");

				chi_tiet_don_hang = new chi_tiet_don_hang(ma_don_hang, ma_giay, so_luong, gia_ban, giam_gia, thue_vat,
						tong_tien);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return chi_tiet_don_hang;
	}

	@Override
	public ArrayList<chi_tiet_don_hang> selectCondition(String condition) {
		ArrayList<chi_tiet_don_hang> list = new ArrayList<>();

		try {

			Connection connection = JDBSUtil.getConnection();

			String sql = "SELECT * FROM chi_tiet_don_han WHERE " + condition;

			PreparedStatement pps = connection.prepareStatement(sql);

			ResultSet rs = pps.executeQuery();

			while (rs.next()) {
				String ma_don_hang = rs.getString("ma_don_hang");
				String ma_giay = rs.getString("ma_giay");
				Integer so_luong = rs.getInt("so_luong");
				Float gia_ban = rs.getFloat("gia_ban");
				Float giam_gia = rs.getFloat("giam_gia");
				Float thue_vat = rs.getFloat("thue_vat");
				Float tong_tien = rs.getFloat("tong_tien");

				chi_tiet_don_hang chi_tiet_don_hang = new chi_tiet_don_hang(ma_don_hang, ma_giay, so_luong, gia_ban,
						giam_gia, thue_vat, tong_tien);
				list.add(chi_tiet_don_hang);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
