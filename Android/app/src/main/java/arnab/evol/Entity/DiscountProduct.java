package arnab.evol.Entity;

import java.sql.Blob;
import java.sql.Date;

public class DiscountProduct {
	private long id;
	private long prod_id;
	private double discount_per;
	private double discount_flat;
	private Date validfrom;
	private Date validtill;
	private String discount_desc;
	private Blob discount_imgdata;
	private String discount_imgname;
	private String discount_imgtype;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getBrand_id() {
		return prod_id;
	}
	public void setBrand_id(long brand_id) {
		this.prod_id = brand_id;
	}
	public double getDiscount_Per() {
		return discount_per;
	}
	public void setDiscount_Per(double discount_Per) {
		discount_per = discount_Per;
	}
	public double getDiscount_Flat() {
		return discount_flat;
	}
	public void setDiscount_Flat(double discount_Flat) {
		discount_flat = discount_Flat;
	}
	public Date getValidFrom() {
		return validfrom;
	}
	public void setValidFrom(Date validFrom) {
		validfrom = validFrom;
	}
	public Date getValidTill() {
		return validtill;
	}
	public void setValidTill(Date validTill) {
		validtill = validTill;
	}
	public String getDiscount_desc() {
		return discount_desc;
	}
	public void setDiscount_desc(String discount_desc) {
		this.discount_desc = discount_desc;
	}
	public Blob getDiscount_Img() {
		return discount_imgdata;
	}
	public void setDiscount_Img(Blob discount_Img) {
		discount_imgdata = discount_Img;
	}
	public Blob getDiscount_imgdata() {
		return discount_imgdata;
	}
	public void setDiscount_imgdata(Blob discount_imgdata) {
		this.discount_imgdata = discount_imgdata;
	}
	public String getDiscount_imgname() {
		return discount_imgname;
	}
	public void setDiscount_imgname(String discount_imgname) {
		this.discount_imgname = discount_imgname;
	}
	public String getDiscount_imgtype() {
		return discount_imgtype;
	}
	public void setDiscount_imgtype(String discount_imgtype) {
		this.discount_imgtype = discount_imgtype;
	}
}
