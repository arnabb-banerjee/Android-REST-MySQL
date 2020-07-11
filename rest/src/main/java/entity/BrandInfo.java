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
@Table(name= "mt_brand")
@Access(value=AccessType.FIELD)
public class BrandInfo {
	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="brand_id")
	private long brand_id;

	@Column(name="brand_name")
	private String brand_name;
	
	public long getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(long brand_id) {
		this.brand_id = brand_id;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	
	public BrandInfo() {}
	public BrandInfo(long brand_id, String brand_name) {
		this.brand_id = brand_id;
		this.brand_name = brand_name;
	}
	
	public boolean save(long Brand_id, String Brand_Name)
	{
		try {
			BrandInfo obj = new BrandInfo();
			//obj.brand_id = brand_id;
			obj.brand_name = Brand_Name;
			return new Helper.ExecuteHibernateSave<BrandInfo>().Save(obj);
		}
		catch (Exception e) {
			throw e;
		}
	}

	public List<BrandInfo> GetList()
	{
		return new Helper.ExecuteHibernateSave<BrandInfo>().GetList("select new entity.BrandInfo (B.brand_id, B.brand_name) from BrandInfo B", BrandInfo.class);
	}
	
	public BrandInfo GetDetails(long id)
	{
		return new Helper.ExecuteHibernateSave<BrandInfo>().GetDetails("select new entity.BrandInfo (B.brand_id, B.brand_name) from BrandInfo B where B.brand_id = :id", id, BrandInfo.class);
	}
	
	@Override
	public String toString() {
		return "BrandInfo [brand_id=" + brand_id + ", brand_name=" + brand_name + "]";
	}

}
