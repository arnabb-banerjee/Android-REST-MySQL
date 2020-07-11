package arnab.evol.Entity;

import java.util.Date;

public class UserInfo {
	private long user_id;

	private String user_code;

	private String user_type;

	private String email;

	private String mobile;

	private String shop_name;

	private Date registeredon;

	public long getuser_id() {
		return user_id;
	}

	public void setuser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getuser_code() {
		return user_code;
	}

	public void setuser_code(String user_code) {
		this.user_code = user_code;
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

	public UserInfo() {}

	public UserInfo(long user_id, String user_code, String email, String mobile, String shop_name,
					  Date registeredon) {
		this.user_id = user_id;
		this.user_code = user_code;
		this.email = email;
		this.mobile = mobile;
		this.shop_name = shop_name;
		this.registeredon = registeredon;
	}

	public UserInfo(String email, String mobile, String user_code, String shop_name, String user_type) {
		this.user_code = user_code;
		this.email = email;
		this.mobile = mobile;
		this.shop_name = shop_name;
		this.user_type = user_type;
	}

	public UserInfo(String email, String mobile, String user_code, String shop_name) {
		this.user_code = user_code;
		this.email = email;
		this.mobile = mobile;
		this.shop_name = shop_name;
	}
}
