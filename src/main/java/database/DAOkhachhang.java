package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.khach_hang;

public class DAOkhachhang implements DAOinterface<khach_hang> {

	public static DAOkhachhang getInstance() {
		return new DAOkhachhang();
	}

	@Override
	public int insert(khach_hang t) {
		try {
			Connection connection = JDBSUtil.getConnection();

			String sql = "INSERT INTO khach_hang (ma_khach_hang, ho_ten, email, password, gioi_tinh, dia_chi, dob, so_dien_thoai, dang_ki_nhan_tin_nhan_email)"
					+ "VALUE (?,?,?,?,?,?,?,?,?)";

			PreparedStatement pps = connection.prepareStatement(sql);

			pps.setString(1, t.getMa_khach_hang());
			pps.setString(2, t.getHo_ten());
			pps.setString(3, t.getEmail());
			pps.setString(4, t.getPassword());
			pps.setString(5, t.getGioi_tinh());
			pps.setString(6, t.getDia_chi());
			pps.setDate(7, t.getDob());
			pps.setString(8, t.getSo_dien_thoai());
			pps.setBoolean(9, t.getDang_ki());

			int check = pps.executeUpdate();

			System.out.println("Bạn đã thực hiện câu lệnh: " + sql);
			System.out.println("Có " + check + " dòng bị thay đổi");

			JDBSUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public int insert_login(khach_hang t) {
		try {
			Connection connection = JDBSUtil.getConnection();

			String sql = "INSERT INTO khach_hang (ma_khach_hang, ho_ten, email, password)" + " VALUE (?,?,?,?)";

			PreparedStatement pps = connection.prepareStatement(sql);

			pps.setString(1, t.getMa_khach_hang());
			pps.setString(2, t.getHo_ten());
			pps.setString(3, t.getEmail());
			pps.setString(4, t.getPassword());

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
	public int update(khach_hang t) {
		try {
			Connection connection = JDBSUtil.getConnection();

			String sql = "UPDATE khach_hang  SET ho_ten = ?, email = ?,password=?, gioi_tinh =?, dia_chi=?, dob=?,"
					+ "so_dien_thoai=?, dang_ki_nhan_tin_nhan_email=? WHERE ma_khach_hang =?";

			PreparedStatement pps = connection.prepareStatement(sql);

			pps.setString(1, t.getHo_ten());
			pps.setString(2, t.getEmail());
			pps.setString(3, t.getPassword());
			pps.setString(4, t.getGioi_tinh());
			pps.setString(5, t.getDia_chi());
			pps.setDate(6, t.getDob());
			pps.setString(7, t.getSo_dien_thoai());
			pps.setBoolean(8, t.getDang_ki());
			pps.setString(9, t.getMa_khach_hang());

			int check = pps.executeUpdate();

			System.out.println("Bạn đã thực hiện câu lệnh: " + sql);
			System.out.println("Có " + check + " dòng bị thay đổi");

			JDBSUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public int update_profile(khach_hang t) {
		try {
			Connection connection = JDBSUtil.getConnection();

			String sql = "UPDATE khach_hang  SET ho_ten = ?, gioi_tinh =?, dia_chi=?, dob=?,"
					+ "so_dien_thoai=?, dang_ki_nhan_tin_nhan_email=? WHERE ma_khach_hang =?";

			PreparedStatement pps = connection.prepareStatement(sql);

			pps.setString(1, t.getHo_ten());
			pps.setString(2, t.getGioi_tinh());
			pps.setString(3, t.getDia_chi());
			pps.setDate(4, t.getDob());
			pps.setString(5, t.getSo_dien_thoai());
			pps.setBoolean(6, t.getDang_ki());
			pps.setString(7, t.getMa_khach_hang());

			int check = pps.executeUpdate();

			System.out.println("Bạn đã thực hiện câu lệnh: " + sql);
			System.out.println("Có " + check + " dòng bị thay đổi");

			JDBSUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public int update_password(khach_hang t) {
		try {
			Connection connection = JDBSUtil.getConnection();

			String sql = "UPDATE khach_hang  SET password=? WHERE ma_khach_hang =?";

			PreparedStatement pps = connection.prepareStatement(sql);

			pps.setString(1, t.getPassword());
			pps.setString(2, t.getMa_khach_hang());

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
	public int delete(khach_hang t) {
		try {
			Connection connection = JDBSUtil.getConnection();

			String sql = "DELETE from khach_hang  WHERE ma_khach_hang = ?";

			PreparedStatement pps = connection.prepareStatement(sql);

			pps.setString(1, t.getMa_khach_hang());

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
	public ArrayList<khach_hang> selectAll() {
		ArrayList<khach_hang> list = new ArrayList<>();
		try {
			Connection connection = JDBSUtil.getConnection();

			String sql = "SELECT * FROM khach_hang";

			PreparedStatement pps = connection.prepareStatement(sql);

			ResultSet rs = pps.executeQuery();

			while (rs.next()) {
				String ma_khach_hang = rs.getString("ma_khach_hang");
				String ho_ten = rs.getString("ho_ten");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String gioi_tinh = rs.getString("gioi_tinh");
				String dia_chi = rs.getString("dia_chi");
				Date dob = rs.getDate("dob");
				String so_dien_thoai = rs.getString("so_dien_thoai");
				Boolean dang_ki = rs.getBoolean("dang_ki_nhan_tin_nhan_email");

				khach_hang khach_hang = new khach_hang(ma_khach_hang, ho_ten, email, password, gioi_tinh, dia_chi, dob,
						so_dien_thoai, dang_ki);

				list.add(khach_hang);
			}
			JDBSUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public khach_hang selectById(khach_hang t) {
		khach_hang khach_hang = new khach_hang();
		try {
			Connection connection = JDBSUtil.getConnection();

			String sql = "SELECT * FROM khach_hang WHERE ma_khach_hang = ?";

			PreparedStatement pps = connection.prepareStatement(sql);

			pps.setString(1, t.getMa_khach_hang());

			ResultSet rs = pps.executeQuery();

			while (rs.next()) {
				String ma_khach_hang = rs.getString("ma_khach_hang");
				String ho_ten = rs.getString("ho_ten");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String gioi_tinh = rs.getString("gioi_tinh");
				String dia_chi = rs.getString("dia_chi");
				Date dob = rs.getDate("dob");
				String so_dien_thoai = rs.getString("so_dien_thoai");
				Boolean dang_ki = rs.getBoolean("dang_ki_nhan_tin_nhan_email");

				khach_hang = new khach_hang(ma_khach_hang, ho_ten, email, password, gioi_tinh, dia_chi, dob,
						so_dien_thoai, dang_ki);
			}
			JDBSUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return khach_hang;
	}

	@Override
	public ArrayList<khach_hang> selectCondition(String condition) {
		ArrayList<khach_hang> list = new ArrayList<>();

		try {

			Connection connection = JDBSUtil.getConnection();

			String sql = "SELECT * FROM khach_hang WHERE " + condition;

			PreparedStatement pps = connection.prepareStatement(sql);

			ResultSet rs = pps.executeQuery();

			while (rs.next()) {
				String ma_khach_hang = rs.getString("ma_khach_hang");
				String ho_ten = rs.getString("ho_ten");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String gioi_tinh = rs.getString("gioi_tinh");
				String dia_chi = rs.getString("dia_chi");
				Date dob = rs.getDate("dob");
				String so_dien_thoai = rs.getString("so_dien_thoai");
				Boolean dang_ki = rs.getBoolean("dang_ki_nhan_tin_nhan_email");

				khach_hang khach_hang = new khach_hang(ma_khach_hang, ho_ten, email, password, gioi_tinh, dia_chi, dob,
						so_dien_thoai, dang_ki);
				list.add(khach_hang);
				JDBSUtil.closeConnection(connection);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public khach_hang selectbyEmailAndPassword(khach_hang t) {
		khach_hang khach_hang = null;

		try {
			Connection connection = JDBSUtil.getConnection();

			String sql = "SELECT * FROM khach_hang WHERE email=? and password=?";

			PreparedStatement pps = connection.prepareStatement(sql);

			pps.setString(1, t.getEmail());
			pps.setString(2, t.getPassword());

			ResultSet rs = pps.executeQuery();

			while (rs.next()) {
				String ma_khach_hang = rs.getString("ma_khach_hang");
				String ho_ten = rs.getString("ho_ten");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String gioi_tinh = rs.getString("gioi_tinh");
				String dia_chi = rs.getString("dia_chi");
				Date dob = rs.getDate("dob");
				String so_dien_thoai = rs.getString("so_dien_thoai");
				Boolean dang_ki = rs.getBoolean("dang_ki_nhan_tin_nhan_email");

				khach_hang = new khach_hang(ma_khach_hang, ho_ten, email, password, gioi_tinh, dia_chi, dob,
						so_dien_thoai, dang_ki);

			}
			JDBSUtil.closeConnection(connection);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return khach_hang;
	}

	public khach_hang selectbyEmail(khach_hang t) {
		khach_hang khach_hang = null;

		try {
			Connection connection = JDBSUtil.getConnection();

			String sql = "SELECT * FROM khach_hang WHERE email =?";

			PreparedStatement pps = connection.prepareStatement(sql);

			pps.setString(1, t.getEmail());

			ResultSet rs = pps.executeQuery();

			while (rs.next()) {
				String ma_khach_hang = rs.getString("ma_khach_hang");
				String ho_ten = rs.getString("ho_ten");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String gioi_tinh = rs.getString("gioi_tinh");
				String dia_chi = rs.getString("dia_chi");
				Date dob = rs.getDate("dob");
				String so_dien_thoai = rs.getString("so_dien_thoai");
				Boolean dang_ki = rs.getBoolean("dang_ki_nhan_tin_nhan_email");

				khach_hang = new khach_hang(ma_khach_hang, ho_ten, email, password, gioi_tinh, dia_chi, dob,
						so_dien_thoai, dang_ki);

			}
			JDBSUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return khach_hang;
	}
}
