package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.san_pham;

public class DAOsanpham implements DAOinterface<san_pham> {

	public static DAOsanpham getInstance() {
		return new DAOsanpham();
	}

	@Override
	public int insert(san_pham t) {
		try {
			Connection connection = JDBSUtil.getConnection();
			String sql = "INSERT INTO san_pham(ma_giay, ten_sach, xuat_xu,mau_giay, gia_goc, gia_ban,so_luong,hang_giay,kieu_dang,link_hinh_anh,gioi_tinh,chat_lieu,mo_ta)"
					+ "VALUE (?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement pps = connection.prepareStatement(sql);

			pps.setString(1, t.getMa_giay());
			pps.setString(2, t.getTen_giay());
			pps.setString(3, t.getXuat_xu());
			pps.setString(4, t.getMau_giay());
			pps.setFloat(5, t.getGia_goc());
			pps.setFloat(6, t.getGia_ban());
			pps.setInt(7, t.getSo_luong());
			pps.setString(8, t.getHang_giay());
			pps.setString(9, t.getKieu_dang());
			pps.setString(10, t.getLink_hinh_anh());
			pps.setString(11, t.getGioi_tinh());
			pps.setString(12, t.getChat_lieu());
			pps.setString(13, t.getMo_ta());

			int check = pps.executeUpdate();

			System.out.println("Bạn vừa thực hiện câu lệnh: " + sql);
			System.out.println("Có " + check + " dòng bị thay đổi");

			JDBSUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(san_pham t) {
		try {
			Connection connection = JDBSUtil.getConnection();

			String sql = "UPDATE san_pham "
					+ " SET ten_giay=?, xuat_xu=?,mau_giay=?, gia_goc=?, gia_ban=?, so_luong=?, hang_giay=?, kieu_dang=?,link_hinh_anh=?,gioi_tinh=?, chat_lieu=?, mo_ta=? "
					+ "WHERE ma_giay = ?";

			PreparedStatement pps = connection.prepareStatement(sql);

			pps.setString(1, t.getTen_giay());
			pps.setString(2, t.getXuat_xu());
			pps.setString(3, t.getMau_giay());
			pps.setFloat(4, t.getGia_goc());
			pps.setFloat(5, t.getGia_ban());
			pps.setInt(6, t.getSo_luong());
			pps.setString(7, t.getHang_giay());
			pps.setString(8, t.getKieu_dang());
			pps.setString(9, t.getLink_hinh_anh());
			pps.setString(10, t.getGioi_tinh());
			pps.setString(11, t.getChat_lieu());
			pps.setString(12, t.getMo_ta());
			pps.setString(13, t.getMa_giay());

			int check = pps.executeUpdate();

			System.out.println("Bạn vừa thực hiện câu lệnh: " + sql);
			System.out.println("Có " + check + " dòng bị thay đổi");

			JDBSUtil.closeConnection(connection);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int delete(san_pham t) {
		try {
			Connection connection = JDBSUtil.getConnection();

			String sql = "DELETE from san_pham " + " WHERE ma_giay = ?";

			PreparedStatement pps = connection.prepareStatement(sql);

			pps.setString(1, t.getMa_giay());

			int check = pps.executeUpdate();

			System.out.println("Bạn đã thực hiện câu lệnh: " + sql);
			System.out.println("Có " + check + " dòng bị thay đổi");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<san_pham> selectAll() {
		ArrayList<san_pham> list = new ArrayList<>();

		try {
			Connection connection = JDBSUtil.getConnection();

			String sql = "SELECT * FROM san_pham";

			PreparedStatement pps = connection.prepareStatement(sql);

			System.out.println(sql);
			ResultSet rs = pps.executeQuery();

			while (rs.next()) {
				String ma_giay = rs.getString("ma_giay");
				String ten_giay = rs.getString("ten_giay");
				String xuat_xu = rs.getString("xuat_xu");
				String mau_giay = rs.getString("mau_giay");
				Float gia_goc = rs.getFloat("gia_goc");
				Float gia_ban = rs.getFloat("gia_ban");
				Integer so_luong = rs.getInt("so_luong");
				String hang_giay = rs.getString("hang_giay");
				String kieu_dang = rs.getString("kieu_dang");
				String link_hinh_anh = rs.getString("link_hinh_anh");
				String gioi_tinh = rs.getString("gioi_tinh");
				String chat_lieu = rs.getString("chat_lieu");
				String mo_ta = rs.getString("mo_ta");

				san_pham san_pham = new san_pham(ma_giay, ten_giay, xuat_xu, mau_giay, gia_goc, gia_ban, so_luong,
						hang_giay, kieu_dang, link_hinh_anh, gioi_tinh, chat_lieu, mo_ta);
				list.add(san_pham);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public san_pham selectById(san_pham t) {

		san_pham san_pham = null;

		try {

			Connection connection = JDBSUtil.getConnection();
			String sql = "SELECT * FROM san_pham WHERE ma_giay = ?";

			PreparedStatement pps = connection.prepareStatement(sql);

			pps.setString(1, t.getMa_giay());

			ResultSet rs = pps.executeQuery();

			while (rs.next()) {
				String ma_giay = rs.getString("ma_giay");
				String ten_giay = rs.getString("ten_giay");
				String xuat_xu = rs.getString("xuat_xu");
				String mau_giay = rs.getString("mau_giay");
				Float gia_goc = rs.getFloat("gia_goc");
				Float gia_ban = rs.getFloat("gia_ban");
				Integer so_luong = rs.getInt("so_luong");
				String hang_giay = rs.getString("hang_giay");
				String kieu_dang = rs.getString("kieu_dang");
				String link_hinh_anh = rs.getString("link_hinh_anh");
				String gioi_tinh = rs.getString("gioi_tinh");
				String chat_lieu = rs.getString("chat_lieu");
				String mo_ta = rs.getString("mo_ta");

				san_pham = new san_pham(ma_giay, ten_giay, xuat_xu, mau_giay, gia_goc, gia_ban, so_luong, hang_giay,
						kieu_dang, link_hinh_anh, gioi_tinh, chat_lieu, mo_ta);
			}
			JDBSUtil.closeConnection(connection);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return san_pham;
	}

	@Override
	public ArrayList<san_pham> selectCondition(String condition) {
		ArrayList<san_pham> lish = new ArrayList<>();
		san_pham san_pham = null;
		try {
			Connection connection = JDBSUtil.getConnection();

			String sql = "SELECT * FROM san_pham WHERE " + condition;

			PreparedStatement pps = connection.prepareStatement(sql);

			ResultSet rs = pps.executeQuery();

			while (rs.next()) {
				String ma_giay = rs.getString("ma_giay");
				String ten_giay = rs.getString("ten_giay");
				String xuat_xu = rs.getString("xuat_xu");
				String mau_giay = rs.getString("mau_giay");
				Float gia_goc = rs.getFloat("gia_goc");
				Float gia_ban = rs.getFloat("gia_ban");
				Integer so_luong = rs.getInt("so_luong");
				String hang_giay = rs.getString("hang_giay");
				String kieu_dang = rs.getString("kieu_dang");
				String link_hinh_anh = rs.getString("link_hinh_anh");
				String gioi_tinh = rs.getString("gioi_tinh");
				String chat_lieu = rs.getString("chat_lieu");
				String mo_ta = rs.getString("mo_ta");

				san_pham = new san_pham(ma_giay, ten_giay, xuat_xu, mau_giay, gia_goc, gia_ban, so_luong, hang_giay,
						kieu_dang, link_hinh_anh, gioi_tinh, chat_lieu, mo_ta);
				lish.add(san_pham);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lish;
	}

	

}
