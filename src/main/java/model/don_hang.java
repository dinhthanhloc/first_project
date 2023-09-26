package model;

public class don_hang {
	private String ma_don_hang;
	private String ma_khach_hang;
	private String ho_va_ten;
	private String sdt_nguoi_nhan;
	private String dia_chi_nhan_hang;
	private String trang_thai_don_hang;
	private String hinh_thuc_thanh_toan;
	private String trang_thai_thanh_toan;
	private String ngay_dat_hang;
	private String ngay_giao_hang;

	public don_hang(String ma_don_hang, String ma_khach_hang, String ho_va_ten, String sdt_nguoi_nhan,
			String dia_chi_nhan_hang, String trang_thai_don_hang, String hinh_thuc_thanh_toan,
			String trang_thai_thanh_toan, String ngay_dat_hang, String ngay_giao_hang) {
		this.ma_don_hang = ma_don_hang;
		this.ma_khach_hang = ma_khach_hang;
		this.ho_va_ten = ho_va_ten;
		this.sdt_nguoi_nhan = sdt_nguoi_nhan;
		this.dia_chi_nhan_hang = dia_chi_nhan_hang;
		this.trang_thai_don_hang = trang_thai_don_hang;
		this.hinh_thuc_thanh_toan = hinh_thuc_thanh_toan;
		this.trang_thai_thanh_toan = trang_thai_thanh_toan;
		this.ngay_dat_hang = ngay_dat_hang;
		this.ngay_giao_hang = ngay_giao_hang;
	}

	public don_hang() {
		super();
	}

	public String getMa_don_hang() {
		return ma_don_hang;
	}

	public void setMa_don_hang(String ma_don_hang) {
		this.ma_don_hang = ma_don_hang;
	}

	public String getMa_khach_hang() {
		return ma_khach_hang;
	}

	public void setMa_khach_hang(String ma_khach_hang) {
		this.ma_khach_hang = ma_khach_hang;
	}

	public String getHo_va_ten() {
		return ho_va_ten;
	}

	public void setHo_va_ten(String ho_va_ten) {
		this.ho_va_ten = ho_va_ten;
	}

	public String getSdt_nguoi_nhan() {
		return sdt_nguoi_nhan;
	}

	public void setSdt_nguoi_nhan(String sdt_nguoi_nhan) {
		this.sdt_nguoi_nhan = sdt_nguoi_nhan;
	}

	public String getDia_chi_nhan_hang() {
		return dia_chi_nhan_hang;
	}

	public void setDia_chi_nhan_hang(String dia_chi_nhan_hang) {
		this.dia_chi_nhan_hang = dia_chi_nhan_hang;
	}

	public String getTrang_thai_don_hang() {
		return trang_thai_don_hang;
	}

	public void setTrang_thai_don_hang(String trang_thai_don_hang) {
		this.trang_thai_don_hang = trang_thai_don_hang;
	}

	public String getHinh_thuc_thanh_toan() {
		return hinh_thuc_thanh_toan;
	}

	public void setHinh_thuc_thanh_toan(String hinh_thuc_thanh_toan) {
		this.hinh_thuc_thanh_toan = hinh_thuc_thanh_toan;
	}

	public String getTrang_thai_thanh_toan() {
		return trang_thai_thanh_toan;
	}

	public void setTrang_thai_thanh_toan(String trang_thai_thanh_toan) {
		this.trang_thai_thanh_toan = trang_thai_thanh_toan;
	}

	public String getNgay_dat_hang() {
		return ngay_dat_hang;
	}

	public void setNgay_dat_hang(String ngay_dat_hang) {
		this.ngay_dat_hang = ngay_dat_hang;
	}

	public String getNgay_giao_hang() {
		return ngay_giao_hang;
	}

	public void setNgay_giao_hang(String ngay_giao_hang) {
		this.ngay_giao_hang = ngay_giao_hang;
	}

	@Override
	public String toString() {
		return "don_hang [ma_don_hang=" + ma_don_hang + ", ma_khach_hang=" + ma_khach_hang + ", ho_va_ten=" + ho_va_ten
				+ ", sdt_nguoi_nhan=" + sdt_nguoi_nhan + ", dia_chi_nhan_hang=" + dia_chi_nhan_hang
				+ ", trang_thai_don_hang=" + trang_thai_don_hang + ", hinh_thuc_thanh_toan=" + hinh_thuc_thanh_toan
				+ ", trang_thai_thanh_toan=" + trang_thai_thanh_toan + ", ngay_dat_hang=" + ngay_dat_hang
				+ ", ngay_giao_hang=" + ngay_giao_hang + "]";
	}

}
