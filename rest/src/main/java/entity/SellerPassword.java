package entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.Table;  

@Entity  
@Table(name= "t_sellerpassword")   
public class SellerPassword {
	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;    
	
	@Column(name = "seller_id")
	private long seller_id;    
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "status")
	private char status; /*L=Locked, I=Invalid, E=Expired*/
	
	@Column(name = "otp")
	private String otp;
	
	@Column(name = "otpstatus")
	private char otpstatus; /*L=Locked, I=Invalid, E=Expired*/
	
	@Column(name = "otp_sent_on")
	private Date otp_sent_on;
	
	@Column(name = "count_of_wrong_pwd")
	private String count_of_wrong_pwd;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public char getOtpstatus() {
		return otpstatus;
	}
	public void setOtpstatus(char otpstatus) {
		this.otpstatus = otpstatus;
	}
	public Date getOtp_sent_on() {
		return otp_sent_on;
	}
	public void setOtp_sent_on(Date otp_sent_on) {
		this.otp_sent_on = otp_sent_on;
	}
	public String getCount_of_wrong_pwd() {
		return count_of_wrong_pwd;
	}
	public void setCount_of_wrong_pwd(String count_of_wrong_pwd) {
		this.count_of_wrong_pwd = count_of_wrong_pwd;
	}
}
