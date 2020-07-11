package arnab.evol.Entity;

import java.sql.Date;

public class ProductImage {
	private int id;
	private String FileName;
	private byte[] FileData;
	private String FileType;
	private int sequence;
	private Boolean isActive;
	private Date UploadedOn;
	private long prod_id;
	private long seller_id;
	private String shop_name;
	private int no_of_sell;
	private int seller_rating;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	public byte[] getFileData() {
		return FileData;
	}
	public void setFileData(byte[] fileData) {
		FileData = fileData;
	}
	public String getFileType() {
		return FileType;
	}
	public void setFileType(String fileType) {
		FileType = fileType;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Date getUploadedOn() {
		return UploadedOn;
	}
	public void setUploadedOn(Date uploadedOn) {
		UploadedOn = uploadedOn;
	}
	public long getProd_id() {
		return prod_id;
	}
	public void setProd_id(long prod_id) {
		this.prod_id = prod_id;
	}
	public long getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(long seller_id) {
		this.seller_id = seller_id;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public int getNo_of_sell() {
		return no_of_sell;
	}
	public void setNo_of_sell(int no_of_sell) {
		this.no_of_sell = no_of_sell;
	}
	public int getSeller_rating() {
		return seller_rating;
	}
	public void setSeller_rating(int seller_rating) {
		this.seller_rating = seller_rating;
	}
	
		
}
