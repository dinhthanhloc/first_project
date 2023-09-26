package model;

public class san_pham {

	private String ma_giay;
	private String ten_giay;
	private String mau_giay;
	private String xuat_xu;
	private float gia_goc;
	private float gia_ban;
	private int so_luong;
	private String hang_giay;
	private String kieu_dang;
	private String link_hinh_anh;
	private String gioi_tinh;
	private String chat_lieu;
	private String mo_ta;

	public san_pham() {
	}

	public san_pham(String ma_giay, String ten_giay, String mau_giay, String xuat_xu, float gia_goc, float gia_ban,
			int so_luong, String hang_giay, String kieu_dang,String link_hinh_anh, String gioi_tinh, String chat_lieu, String mo_ta) {
		this.ma_giay = ma_giay;
		this.ten_giay = ten_giay;
		this.mau_giay = mau_giay;
		this.xuat_xu = xuat_xu;
		this.gia_goc = gia_goc;
		this.gia_ban = gia_ban;
		this.so_luong = so_luong;
		this.hang_giay = hang_giay;
		this.kieu_dang = kieu_dang;
		this.link_hinh_anh = link_hinh_anh;
		this.gioi_tinh = gioi_tinh;
		this.chat_lieu = chat_lieu;
		this.mo_ta = mo_ta;
	}

	public String getLink_hinh_anh() {
		return link_hinh_anh;
	}

	public void setLink_hinh_anh(String link_hinh_anh) {
		this.link_hinh_anh = link_hinh_anh;
	}

	public String getMau_giay() {
		return mau_giay;
	}

	public void setMau_giay(String mau_giay) {
		this.mau_giay = mau_giay;
	}

	public String getMa_giay() {
		return ma_giay;
	}

	public void setMa_giay(String ma_giay) {
		this.ma_giay = ma_giay;
	}

	public String getTen_giay() {
		return ten_giay;
	}

	public void setTen_giay(String ten_giay) {
		this.ten_giay = ten_giay;
	}

	public String getXuat_xu() {
		return xuat_xu;
	}

	public void setXuat_xu(String xuat_xu) {
		this.xuat_xu = xuat_xu;
	}

	public float getGia_goc() {
		return gia_goc;
	}

	public void setGia_goc(float gia_goc) {
		this.gia_goc = gia_goc;
	}

	public float getGia_ban() {
		return gia_ban;
	}

	public void setGia_ban(float gia_ban) {
		this.gia_ban = gia_ban;
	}

	public int getSo_luong() {
		return so_luong;
	}

	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}

	public String getHang_giay() {
		return hang_giay;
	}

	public void setHang_giay(String hang_giay) {
		this.hang_giay = hang_giay;
	}

	public String getKieu_dang() {
		return kieu_dang;
	}

	public void setKieu_dang(String kieu_dang) {
		this.kieu_dang = kieu_dang;
	}

	public String getGioi_tinh() {
		return gioi_tinh;
	}

	public void setGioi_tinh(String gioi_tinh) {
		this.gioi_tinh = gioi_tinh;
	}

	public String getChat_lieu() {
		return chat_lieu;
	}

	public void setChat_lieu(String chat_lieu) {
		this.chat_lieu = chat_lieu;
	}

	public String getMo_ta() {
		return mo_ta;
	}

	public void setMo_ta(String mo_ta) {
		this.mo_ta = mo_ta;
	}

	@Override
	public String toString() {
		return "san_pham [ma_giay=" + ma_giay + ", ten_giay=" + ten_giay + ", mau_giay=" + mau_giay + ", xuat_xu="
				+ xuat_xu + ", gia_goc=" + gia_goc + ", gia_ban=" + gia_ban + ", so_luong=" + so_luong + ", hang_giay="
				+ hang_giay + ", kieu_dang=" + kieu_dang + ", link_hinh_anh=" + link_hinh_anh + ", gioi_tinh="
				+ gioi_tinh + ", chat_lieu=" + chat_lieu + ", mo_ta=" + mo_ta + "]";
	}



}
