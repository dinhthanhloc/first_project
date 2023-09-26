package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.don_hang;

public class DAOdonhang implements DAOinterface<don_hang> {

	public static DAOdonhang getIntance() {
		return new DAOdonhang();
	}

	@Override
	public int insert(don_hang t) {
		try {
			Connection connection = JDBSUtil.getConnection();

			String sql = "INSERT INTO don_hang (ma_don_hang, ma_khach_hang, ho_ten_nguoi_nhan, sdt_nguoi_nhan, dia_chi_nguoi_nhan, trang_thai_don_hang"
					+ ", hinh_thuc_thanh_toan, trang_thai_thanh_toan, ngay_dat_hang, ngay_giao_hang) VALUE(?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement pps = connection.prepareStatement(sql);

			pps.setString(1, t.getMa_don_hang());
			pps.setString(2, t.getMa_khach_hang());
			pps.setString(3, t.getHo_va_ten());
			pps.setString(4, t.getSdt_nguoi_nhan());
			pps.setString(5, t.getDia_chi_nhan_hang());
			pps.setString(6, t.getTrang_thai_don_hang());
			pps.setString(7, t.getHinh_thuc_thanh_toan());
			pps.setString(8, t.getTrang_thai_thanh_toan());
			pps.setString(9, t.getNgay_dat_hang());
			pps.setString(10, t.getNgay_giao_hang());

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
	public int update(don_hang t) {
		try {
			Connection connection = JDBSUtil.getConnection();

			String sql = "UPDATE don_hang SET (ma_khach_hang=?, ho_ten_nguoi_nhan=?, sdt_nguoi_nhan=?, dia_chi_nguoi_nhan=?, trang_thai_don_hang=?,)"
					+ "hinh_thuc_thanh_toan=?, trang_thai_thanh_toan=?, ngay_dat_hang=?, ngay_giao_hang=? WHERE ma_don_hang=?";

			PreparedStatement pps = connection.prepareStatement(sql);

			pps.setString(1, t.getMa_khach_hang());
			pps.setString(2, t.getHo_va_ten());
			pps.setString(3, t.getSdt_nguoi_nhan());
			pps.setString(4, t.getDia_chi_nhan_hang());
			pps.setString(5, t.getTrang_thai_don_hang());
			pps.setString(6, t.getHinh_thuc_thanh_toan());
			pps.setString(7, t.getTrang_thai_thanh_toan());
			pps.setString(8, t.getNgay_dat_hang());
			pps.setString(9, t.getNgay_giao_hang());
			pps.setString(10, t.getMa_don_hang());

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
	public int delete(don_hang t) {
		try {
			Connection connection = JDBSUtil.getConnection();

			String sql = "DELETE * FROM don_hang WHERE ma_don_hang=?";

			PreparedStatement pps = connection.prepareStatement(sql);

			pps.setString(1, t.getMa_don_hang());

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
	public ArrayList<don_hang> selectAll() {
		ArrayList<don_hang> list = new ArrayList<>();
		try {
			Connection connection = JDBSUtil.getConnection();

			String sql = "SELECT * FORM don_hang";

			PreparedStatement pps = connection.prepareStatement(sql);

			ResultSet rs = pps.executeQuery();

			while (rs.next()) {
				String ma_don_hang = rs.getString("ma_don_hang");
				String ma_khach_hang = rs.getString("ma_khach_hang");
				String ho_ten_nguoi_nhan = rs.getString("ho_ten_nguoi_nhan");
				String sdt_nguoi_nhan = rs.getString("sdt_nguoi_nhan");
				String dia_chi_nhan_hang = rs.getString("dia_chi_nhan_hang");
				String trang_thai_don_hang = rs.getString("trang_thai_don_hang");
				String hinh_thuc_thanh_toan = rs.getString("hinh_thuc_thanh_toan");
				String trang_thai_thanh_toan = rs.getString("trang_thai_thanh_toan");
				String ngay_dat_hang = rs.getString("ngay_dat_hang");
				String ngay_giao_hang = rs.getString("ngay_giao_hang");

				don_hang don_hang = new don_hang(ma_don_hang, ma_khach_hang, ho_ten_nguoi_nhan, sdt_nguoi_nhan,
						dia_chi_nhan_hang, trang_thai_don_hang, hinh_thuc_thanh_toan, trang_thai_thanh_toan,
						ngay_dat_hang, ngay_giao_hang);

				list.add(don_hang);

			}
			JDBSUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public don_hang selectById(don_hang t) {
		don_hang don_hang = null;
		try {
			Connection connection = JDBSUtil.getConnection();

			String sql = "SELECT * FROM don_hang WHERE ma_don_hang = ?";

			PreparedStatement pps = connection.prepareStatement(sql);

			pps.setString(1, t.getMa_don_hang());

			ResultSet rs = pps.executeQuery();

			while (rs.next()) {
				String ma_don_hang = rs.getString("ma_don_hang");
				String ma_khach_hang = rs.getString("ma_khach_hang");
				String ho_ten_nguoi_nhan = rs.getString("ho_ten_nguoi_nhan");
				String sdt_nguoi_nhan = rs.getString("sdt_nguoi_nhan");
				String dia_chi_nhan_hang = rs.getString("dia_chi_nhan_hang");
				String trang_thai_don_hang = rs.getString("trang_thai_don_hang");
				String hinh_thuc_thanh_toan = rs.getString("hinh_thuc_thanh_toan");
				String trang_thai_thanh_toan = rs.getString("trang_thai_thanh_toan");
				String ngay_dat_hang = rs.getString("ngay_dat_hang");
				String ngay_giao_hang = rs.getString("ngay_giao_hang");

				don_hang = new don_hang(ma_don_hang, ma_khach_hang, ho_ten_nguoi_nhan, sdt_nguoi_nhan,
						dia_chi_nhan_hang, trang_thai_don_hang, hinh_thuc_thanh_toan, trang_thai_thanh_toan,
						ngay_dat_hang, ngay_giao_hang);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return don_hang;
	}

	@Override
	public ArrayList<don_hang> selectCondition(String condition) {
		ArrayList<don_hang> list = new ArrayList<>();

		try {
			Connection connection = JDBSUtil.getConnection();

			String sql = "SELECT * FEOM don_hang WHERE " + condition;

			PreparedStatement pps = connection.prepareStatement(sql);

			ResultSet rs = pps.executeQuery();

			while (rs.next()) {
				String ma_don_hang = rs.getString("ma_don_hang");
				String ma_khach_hang = rs.getString("ma_khach_hang");
				String ho_ten_nguoi_nhan = rs.getString("ho_ten_nguoi_nhan");
				String sdt_nguoi_nhan = rs.getString("sdt_nguoi_nhan");
				String dia_chi_nhan_hang = rs.getString("dia_chi_nhan_hang");
				String trang_thai_don_hang = rs.getString("trang_thai_don_hang");
				String hinh_thuc_thanh_toan = rs.getString("hinh_thuc_thanh_toan");
				String trang_thai_thanh_toan = rs.getString("trang_thai_thanh_toan");
				String ngay_dat_hang = rs.getString("ngay_dat_hang");
				String ngay_giao_hang = rs.getString("ngay_giao_hang");

				don_hang don_hang = new don_hang(ma_don_hang, ma_khach_hang, ho_ten_nguoi_nhan, sdt_nguoi_nhan,
						dia_chi_nhan_hang, trang_thai_don_hang, hinh_thuc_thanh_toan, trang_thai_thanh_toan,
						ngay_dat_hang, ngay_giao_hang);

				list.add(don_hang);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
