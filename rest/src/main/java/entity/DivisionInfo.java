package entity;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "mt_division") 
@Access(value=AccessType.FIELD)
public class DivisionInfo {
	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="div_id")
	private long div_id;
	
	@Column(name="div_name")
	private String div_name;

	public DivisionInfo(long div_id, String div_name) {
		super();
		this.div_id = div_id;
		this.div_name = div_name;
	}

	public long getDiv_id() {
		return div_id;
	}

	public void setDiv_id(long div_id) {
		this.div_id = div_id;
	}

	public String getDiv_name() {
		return div_name;
	}

	public void setDiv_name(String div_name) {
		this.div_name = div_name;
	}

	public DivisionInfo() {}
	
	public boolean save(long id, String name)
	{
		try {
			DivisionInfo obj = new DivisionInfo();
			//this.div_id = id;
			obj.div_name = name;
			return new Helper.ExecuteHibernateSave<DivisionInfo>().Save(obj);
		}
		catch (Exception e) {
			throw e;
		}
	}

	public List<DivisionInfo> GetList()
	{
		return new Helper.ExecuteHibernateSave<DivisionInfo>().GetList("select new entity.DivisionInfo (B.div_id, B.div_name) from DivisionInfo B", DivisionInfo.class);
	}
	
	public DivisionInfo GetDetails(long id)
	{
		return new Helper.ExecuteHibernateSave<DivisionInfo>().GetDetails("select new entity.DivisionInfo (B.div_id, B.div_name) from DivisionInfo B where B.div_id = :id", id, DivisionInfo.class);
	}

	@Override
	public String toString() {
		return "DivisionInfo [div_id=" + div_id + ", div_name=" + div_name + "]";
	}
}
