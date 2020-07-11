package entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.Table;
import javax.persistence.Transient;

import java.sql.Date;

import javax.persistence.Column;

@Entity  
@Table(name= "mt_buyer")   
public class BuyerInfo {
	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "buyer_id")
	private long buyer_id;    
	
	@Column(name = "buyer_code")
	private String buyer_code;
	
	@Transient
	private String user_type;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "registeredon")
	private Date registeredon;

	public long getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(long buyer_id) {
		this.buyer_id = buyer_id;
	}

	public String getBuyer_code() {
		return buyer_code;
	}

	public void setBuyer_code(String buyer_code) {
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
	
	
	public BuyerInfo(String email, String mobile, String buyer_code, String user_type) {
		this.buyer_code = buyer_code;
		this.email = email;
		this.mobile = mobile;
		this.user_type = user_type;
	}

}
