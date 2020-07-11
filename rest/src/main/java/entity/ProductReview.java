package entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name= "t_productreview")   
public class ProductReview {
	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;    
	
	@Column(name = "prod_id")
	private long prod_id;
	
	@Column(name = "seller_id")
	private long seller_id;

	@Column(name = "comment")
	private String comment;    
	
	@Column(name = "submitted_by")
	private long submitted_by;    
	
	private String submitted_by_name;    
	
	@Column(name = "submitted_by_type")
	private String submitted_by_type;  /*B = Buyer, S = Seller*/  
	
	@Column(name = "submittedon")
	private Date submittedon;

	@Column(name = "is_reply")
	private boolean is_reply;
	
	@Column(name = "parent_id")
	private long parent_id;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public long getSubmitted_by() {
		return submitted_by;
	}

	public void setSubmitted_by(long submitted_by) {
		this.submitted_by = submitted_by;
	}

	public String getSubmitted_by_name() {
		return submitted_by_name;
	}

	public void setSubmitted_by_name(String submitted_by_name) {
		this.submitted_by_name = submitted_by_name;
	}

	public String getSubmitted_by_type() {
		return submitted_by_type;
	}

	public void setSubmitted_by_type(String submitted_by_type) {
		this.submitted_by_type = submitted_by_type;
	}

	public Date getSubmittedon() {
		return submittedon;
	}

	public void setSubmittedon(Date submittedon) {
		this.submittedon = submittedon;
	}

	public boolean isIs_reply() {
		return is_reply;
	}

	public void setIs_reply(boolean is_reply) {
		this.is_reply = is_reply;
	}

	public long getParent_id() {
		return parent_id;
	}

	public void setParent_id(long parent_id) {
		this.parent_id = parent_id;
	}
	
	public ProductReview() {}

	public ProductReview(long id, long prod_id, long seller_id, String comment, long submitted_by,
			String submitted_by_name, String submitted_by_type, boolean is_reply, long parent_id) {
		super();
		this.id = id;
		this.prod_id = prod_id;
		this.seller_id = seller_id;
		this.comment = comment;
		this.submitted_by = submitted_by;
		this.submitted_by_name = submitted_by_name;
		this.submitted_by_type = submitted_by_type;
		this.is_reply = is_reply;
		this.parent_id = parent_id;
	}
		
}
