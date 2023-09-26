package model;

import java.sql.Date;

public class khach_hang {

	private String ma_khach_hang;
	private String ho_ten;
	private String email;
	private String password;
	private String gioi_tinh;
	private String dia_chi;
	private Date dob;
	private String so_dien_thoai;
	private Boolean dang_ki;

	public khach_hang() {
	}

	public khach_hang(String ma_khach_hang, String ho_ten, String email, String password, String gioi_tinh,
			String dia_chi, Date dob, String so_dien_thoai, Boolean dang_ki) {
		this.ma_khach_hang = ma_khach_hang;
		this.ho_ten = ho_ten;
		this.email = email;
		this.password = password;
		this.gioi_tinh = gioi_tinh;
		this.dia_chi = dia_chi;
		this.dob = dob;
		this.so_dien_thoai = so_dien_thoai;
		this.dang_ki = dang_ki;
	}

	public khach_hang(String ma_khach_hang, String ho_ten, String gioi_tinh, String dia_chi, Date dob,
			String so_dien_thoai, Boolean dang_ki) {
		this.ma_khach_hang = ma_khach_hang;
		this.ho_ten = ho_ten;
		this.gioi_tinh = gioi_tinh;
		this.dia_chi = dia_chi;
		this.dob = dob;
		this.so_dien_thoai = so_dien_thoai;
		this.dang_ki = dang_ki;
	}

	public khach_hang(String ma_khach_hang, String ho_ten, String email, String password) {
		this.ma_khach_hang = ma_khach_hang;
		this.ho_ten = ho_ten;
		this.email = email;
		this.password = password;
	}

	public String getMa_khach_hang() {
		return ma_khach_hang;
	}

	public void setMa_khach_hang(String ma_khach_hang) {
		this.ma_khach_hang = ma_khach_hang;
	}

	public String getHo_ten() {
		return ho_ten;
	}

	public void setHo_ten(String ho_ten) {
		this.ho_ten = ho_ten;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGioi_tinh() {
		return gioi_tinh;
	}

	public void setGioi_tinh(String gioi_tinh) {
		this.gioi_tinh = gioi_tinh;
	}

	public String getDia_chi() {
		return dia_chi;
	}

	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getSo_dien_thoai() {
		return so_dien_thoai;
	}

	public void setSo_dien_thoai(String so_dien_thoai) {
		this.so_dien_thoai = so_dien_thoai;
	}

	public Boolean getDang_ki() {
		return dang_ki;
	}

	public void setDang_ki(Boolean dang_ki) {
		this.dang_ki = dang_ki;
	}

	@Override
	public String toString() {
		return "khach_hang [ma_khach_hang=" + ma_khach_hang + ", ho_ten=" + ho_ten + ", email=" + email + ", password="
				+ password + ", gioi_tinh=" + gioi_tinh + ", dia_chi=" + dia_chi + ", dob=" + dob + ", so_dien_thoai="
				+ so_dien_thoai + ", dang_ki=" + dang_ki + "]";
	}

}
