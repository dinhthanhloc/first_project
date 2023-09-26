package model;

public class chi_tiet_san_pham {
		private String ma_giay;
		private String tong_quan;
		private String tong_quan_1;
		private String tong_quan_2;
		private String de_giay;
		
		public chi_tiet_san_pham() {
			super();
		}

		public chi_tiet_san_pham(String ma_giay, String tong_quan, String tong_quan_1, String tong_quan_2,
				String de_giay) {
			this.ma_giay = ma_giay;
			this.tong_quan = tong_quan;
			this.tong_quan_1 = tong_quan_1;
			this.tong_quan_2 = tong_quan_2;
			this.de_giay = de_giay;
		}

		@Override
		public String toString() {
			return "chi_tiet_san_pham [ma_giay=" + ma_giay + ", tong_quan=" + tong_quan + ", tong_quan_1=" + tong_quan_1
					+ ", tong_quan_2=" + tong_quan_2 + ", de_giay=" + de_giay + "]";
		}

		public String getMa_giay() {
			return ma_giay;
		}

		public void setMa_giay(String ma_giay) {
			this.ma_giay = ma_giay;
		}

		public String getTong_quan() {
			return tong_quan;
		}

		public void setTong_quan(String tong_quan) {
			this.tong_quan = tong_quan;
		}

		public String getTong_quan_1() {
			return tong_quan_1;
		}

		public void setTong_quan_1(String tong_quan_1) {
			this.tong_quan_1 = tong_quan_1;
		}

		public String getTong_quan_2() {
			return tong_quan_2;
		}

		public void setTong_quan_2(String tong_quan_2) {
			this.tong_quan_2 = tong_quan_2;
		}

		public String getDe_giay() {
			return de_giay;
		}

		public void setDe_giay(String de_giay) {
			this.de_giay = de_giay;
		}
		
}
