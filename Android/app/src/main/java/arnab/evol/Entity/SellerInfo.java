package arnab.evol.Entity;

import java.sql.Date;

public class SellerInfo {
	private long seller_id;
	private String seller_code;
	private String email;
	private String mobile;
	private String shop_name;
	private Date registeredon;

	public long getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(long seller_id) {
		this.seller_id = seller_id;
	}

	public String getSeller_code() {
		return seller_code;
	}

	public void setSeller_code(String seller_code) {
		this.seller_code = seller_code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getShop_name() {
		return shop_name;
	}

	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}

	public Date getRegisteredon() {
		return registeredon;
	}

	public void setRegisteredon(Date registeredon) {
		this.registeredon = registeredon;
	}

	public SellerInfo(){}
	public SellerInfo(long seller_id, String seller_code, String email, String mobile, String shop_name,
			Date registeredon) {
		super();
		this.seller_id = seller_id;
		this.seller_code = seller_code;
		this.email = email;
		this.mobile = mobile;
		this.shop_name = shop_name;
		this.registeredon = registeredon;
	}

	public static class LoggedUserInfo {
		private String user_type;
		private String user_code;
		private String email;
		private String mobile;
		private String shop_name;
		private String user_password_status;
		private String user_status;

		public String getUser_code() {
			return user_code;
		}
		public String getEmail() {
			return email;
		}
		public String getMobile() {
			return mobile;
		}
		public String getShop_name() {
			return shop_name;
		}
		public String getUser_password_status() {
			return user_password_status;
		}
		public String getuser_status() {
			return user_status;
		}


	}
}
