package entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.Table;
import javax.persistence.Transient;
//import javax.xml.bind.annotation.XmlRootElement;  

@Entity
//@XmlRootElement
@Table(name= "mt_product") 
public class ProductInfo {
	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="prod_id")
	private long prod_id;
	
	@Column(name="prod_name")
	private String prod_name;
	
	@Column(name="prod_desc")
	private String prod_desc;
	
	@Column(name="div_id")
	private long div_id;
	
	@Column(name="cat_id")
	private long cat_id;
	
	@Column(name="brand_id")
	private long brand_id;
	
	@Transient
	private String brand_name;
	
	@Transient
	private String div_name;
	
	@Transient
	private String cat_name;

	public long getProd_id() {
		return prod_id;
	}

	public void setProd_id(long prod_id) {
		this.prod_id = prod_id;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public String getProd_desc() {
		return prod_desc;
	}

	public void setProd_desc(String prod_desc) {
		this.prod_desc = prod_desc;
	}

	public long getDiv_id() {
		return div_id;
	}

	public void setDiv_id(long div_id) {
		this.div_id = div_id;
	}

	public long getCat_id() {
		return cat_id;
	}

	public void setCat_id(long cat_id) {
		this.cat_id = cat_id;
	}

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

	public String getDiv_name() {
		return div_name;
	}

	public void setDiv_name(String div_name) {
		this.div_name = div_name;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	public ProductInfo() {}
	public ProductInfo(
			long prod_id, 
			long div_id, 
			long cat_id, 
			long brand_id,
			String prod_name, 
			String prod_desc, 
			String div_name, 
			String cat_name,
			String brand_name) {
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.prod_desc = prod_desc;
		this.div_id = div_id;
		this.cat_id = cat_id;
		this.brand_id = brand_id;
		this.brand_name = brand_name;
		this.div_name = div_name;
		this.cat_name = cat_name;
	}
	
}
