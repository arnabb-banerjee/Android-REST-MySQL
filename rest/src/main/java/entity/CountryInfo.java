package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "mt_country") 
public class CountryInfo {
	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="con_id")
	private long con_id;

	@Column(name="con_code")
	private long con_code;
	
	@Column(name="con_name")
	private long con_name;
	
	@Column(name="isd_code")
	private long isd_code;

	
	public long getCon_id() {
		return con_id;
	}

	public void setCon_id(long con_id) {
		this.con_id = con_id;
	}

	public long getCon_code() {
		return con_code;
	}

	public void setCon_code(long con_code) {
		this.con_code = con_code;
	}

	public long getCon_name() {
		return con_name;
	}

	public void setCon_name(long con_name) {
		this.con_name = con_name;
	}

	public long getIsd_code() {
		return isd_code;
	}

	public void setIsd_code(long isd_code) {
		this.isd_code = isd_code;
	}
}
