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
@Table(name= "mt_category") 
@Access(value=AccessType.FIELD)
public class CategoryInfo {

	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cat_id")
	private long cat_Id;
	
	@Column(name="pcat_id")
	private long pcat_id;
	
	@Column(name="div_id")
	private long div_id;
	
	@Column(name="cat_name")
	private String cat_name;

	public long getCat_Id() {
		return cat_Id;
	}

	public void setCat_Id(long cat_Id) {
		this.cat_Id = cat_Id;
	}

	public long getPcat_id() {
		return pcat_id;
	}

	public void setPcat_id(long pcat_id) {
		this.pcat_id = pcat_id;
	}

	public long getDiv_id() {
		return div_id;
	}

	public void setDiv_id(long div_id) {
		this.div_id = div_id;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	
	public CategoryInfo() {}
	public CategoryInfo(long id, String name) {
		this.cat_Id = id;
		this.cat_name = name;
	}
	
	public boolean save(long id, String name)
	{
		try {
			CategoryInfo obj = new CategoryInfo();
			//this.cat_Id = id;
			obj.cat_name = name;
			return new Helper.ExecuteHibernateSave<CategoryInfo>().Save(obj);
		}
		catch (Exception e) {
			throw e;
		}
	}

	public List<CategoryInfo> GetList()
	{
		return new Helper.ExecuteHibernateSave<CategoryInfo>().GetList("select new entity.CategoryInfo (B.cat_Id, B.cat_name) from CategoryInfo B", CategoryInfo.class);
	}
	
	public CategoryInfo GetDetails(long id)
	{
		return new Helper.ExecuteHibernateSave<CategoryInfo>().GetDetails("select new entity.CategoryInfo (B.cat_Id, B.cat_name) from CategoryInfo B where cat_Id = :id", id, CategoryInfo.class);
	}

	@Override
	public String toString() {
		return "CategoryInfo [cat_Id=" + cat_Id + ", pcat_id=" + pcat_id + ", div_id=" + div_id + ", cat_name="
				+ cat_name + "]";
	}

}
