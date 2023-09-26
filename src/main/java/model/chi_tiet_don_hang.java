package model;

public class chi_tiet_don_hang {
	private String ma_don_hang;
	private String ma_giay;
	private int so_luong;
	private float gia_ban;
	private float giam_gia;
	private float thue_vat;
	private float tong_tien;

	public chi_tiet_don_hang(String ma_don_hang, String ma_giay, int so_luong, float gia_ban, float giam_gia,
			float thue_vat, float tong_tien) {
		this.ma_don_hang = ma_don_hang;
		this.ma_giay = ma_giay;
		this.so_luong = so_luong;
		this.gia_ban = gia_ban;
		this.giam_gia = giam_gia;
		this.thue_vat = thue_vat;
		this.tong_tien = tong_tien;
	}

	public chi_tiet_don_hang() {
		super();
	}

	public String getMa_don_hang() {
		return ma_don_hang;
	}

	public void setMa_don_hang(String ma_don_hang) {
		this.ma_don_hang = ma_don_hang;
	}

	public String getMa_giay() {
		return ma_giay;
	}

	public void setMa_giay(String ma_giay) {
		this.ma_giay = ma_giay;
	}

	public int getSo_luong() {
		return so_luong;
	}

	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}

	public float getGia_ban() {
		return gia_ban;
	}

	public void setGia_ban(float gia_ban) {
		this.gia_ban = gia_ban;
	}

	public float getGiam_gia() {
		return giam_gia;
	}

	public void setGiam_gia(float giam_gia) {
		this.giam_gia = giam_gia;
	}

	public float getThue_vat() {
		return thue_vat;
	}

	public void setThue_vat(float thue_vat) {
		this.thue_vat = thue_vat;
	}

	public float getTong_tien() {
		return tong_tien;
	}

	public void setTong_tien(float tong_tien) {
		this.tong_tien = tong_tien;
	}

	@Override
	public String toString() {
		return "chi_tiet_don_hang [ma_don_hang=" + ma_don_hang + ", ma_giay=" + ma_giay + ", so_luong=" + so_luong
				+ ", gia_ban=" + gia_ban + ", giam_gia=" + giam_gia + ", thue_vat=" + thue_vat + ", tong_tien="
				+ tong_tien + "]";
	}

}
