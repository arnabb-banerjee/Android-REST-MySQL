package arnab.evol.Entity;

import java.sql.Date;

public class BuyerPassword {
	private long id;
	private String password;
	private char status; /*L=Locked, I=Invalid, E=Expired*/
	private String otp;
	private char otpstatus; /*L=Locked, I=Invalid, E=Expired*/
	private Date otp_sent_on;
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
