package arnab.evol.Entity;

import java.sql.Date;

public class BuyerInfo {

	private long buyer_id;
	private long buyer_code;
	private String email;
	private String mobile;
	private Date registeredon;

	public long getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(long buyer_id) {
		this.buyer_id = buyer_id;
	}

	public long getBuyer_code() {
		return buyer_code;
	}

	public void setBuyer_code(long buyer_code) {
		this.buyer_code = buyer_code;
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

	public Date getRegisteredon() {
		return registeredon;
	}

	public void setRegisteredon(Date registeredon) {
		this.registeredon = registeredon;
	}

}
