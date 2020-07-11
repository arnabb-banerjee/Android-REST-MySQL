package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.jboss.resteasy.annotations.providers.multipart.PartType;  

@Entity  
@Table(name= "t_productimage")   
public class ProductImage {
	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;    
	
	//@FormParam("fileName")
	@Column(name = "filename")
	private String FileName;

	//@FormParam("selectedFile")
	@Lob
    @PartType("application/octet-stream")
	@Column(name = "filendata", columnDefinition="LONGBLOB")
	private byte[] FileData;
	
	@Column(name = "filentype")
	private String FileType;

	private int sequence;
	
	@Column(name = "isactive")
	private Boolean isActive;
	
	@Column(name = "uploadedon")
	private Date UploadedOn;

	@Column(name = "prod_id")
	private long prod_id;
	
	@Column(name = "seller_id")
	private long seller_id;    

	@Transient
	private String shop_name;    
	@Transient
	private int no_of_sell;
	@Transient
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
	@Transient
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	@Transient
	public int getNo_of_sell() {
		return no_of_sell;
	}
	public void setNo_of_sell(int no_of_sell) {
		this.no_of_sell = no_of_sell;
	}
	@Transient
	public int getSeller_rating() {
		return seller_rating;
	}
	public void setSeller_rating(int seller_rating) {
		this.seller_rating = seller_rating;
	}
	
	public ProductImage() {}

	public ProductImage(int id, String fileName, String fileType, int sequence, Boolean isActive,
			long prod_id, long seller_id) {
		this.id = id;
		FileName = fileName;
		FileType = fileType;
		this.sequence = sequence;
		this.isActive = isActive;
		this.prod_id = prod_id;
		this.seller_id = seller_id;
	}
	
		
}
