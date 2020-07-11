package arnab.evol.Entity;

public class CategoryInfo {

	private long cat_Id;
	private long pcat_id;
	private long div_id;
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
}
