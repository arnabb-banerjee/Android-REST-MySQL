package arnab.evol.Entity;

//import javax.xml.bind.annotation.XmlRootElement;

public class ProductInfo {

	private long prod_id;
	private String prod_name;
	private String prod_desc;
	private long cat_id;
	private String cat_name;
	private long brand_id;
	private String brand_name;
	
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

	public long getCat_Id() {
		return cat_id;
	}

	public void setCat_Id(long cat_Id) {
		this.cat_id = cat_Id;
	}

	public String getCategory() {
		return cat_name;
	}

	public void setCategory(String category) {
		cat_name = category;
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

	public ProductInfo() {}

	public ProductInfo(long prod_id, String prod_name, String prod_desc, long cat_id, String cat_name, long brand_id,
			String brand_name) {
		super();
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.prod_desc = prod_desc;
		this.cat_id = cat_id;
		this.cat_name = cat_name;
		this.brand_id = brand_id;
		this.brand_name = brand_name;
	}

	public void setDescription(String prod_desc) {
	}
}
