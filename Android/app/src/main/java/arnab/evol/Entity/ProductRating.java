package arnab.evol.Entity;

import java.sql.Date;

public class ProductRating {
	private int id;
	private long prod_id;
	private long seller_id;
	private long buyer_id;
	private int seller_rating;
	private Date submittedon;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserRating() {
		return seller_rating;
	}
	public void setUserRating(int userRating) {
		seller_rating = userRating;
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
	public long getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(long buyer_id) {
		this.buyer_id = buyer_id;
	}
	public Date getSubmittedon() {
		return submittedon;
	}
	public void setSubmittedon(Date submittedon) {
		this.submittedon = submittedon;
	}

}
