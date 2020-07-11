package entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mt_unit")
@Access(AccessType.FIELD)
public class UnitInfo {

	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="brand_id")
	private long unit_id;
	
	@Column(name="con_id")
	private int con_id;
	
	@Column(name="unit_name")
	private String unit_name;
	
	public long getUnit_id() {
		return unit_id;
	}
	public void setUnit_id(long unit_id) {
		this.unit_id = unit_id;
	}
	public int getCon_id() {
		return con_id;
	}
	public void setCon_id(int con_id) {
		this.con_id = con_id;
	}
	public String getUnit_name() {
		return unit_name;
	}
	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}
	
	@Override
	public String toString() {
		return "UnitInfo [unit_id=" + unit_id + ", con_id=" + con_id + ", unit_name=" + unit_name + "]";
	}
	
	public UnitInfo() {}
	
	public UnitInfo(long unit_id, int con_id, String unit_name) {
		this.unit_id = unit_id;
		this.con_id = con_id;
		this.unit_name = unit_name;
	}
}
