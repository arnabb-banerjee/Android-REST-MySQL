package entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.sql.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.xml.bind.annotation.XmlRootElement;  

@Entity
@XmlRootElement
@Access(value=AccessType.FIELD)
@Table(name= "mt_user")   
public class SellerInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long user_id;

	@Column(name = "user_code")
	private String user_code;

	@Column(name = "user_type")
	private String user_type;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "shop_name")
	private String shop_name;

	@Column(name = "registeredon")
	private Date registeredon;

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
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

	public SellerInfo() {}

	public SellerInfo(String email, String mobile, String user_code, String shop_name, String user_type) {
		this.user_code = user_code;
		this.email = email;
		this.mobile = mobile;
		this.shop_name = shop_name;
		this.user_type = user_type;
	}

}
