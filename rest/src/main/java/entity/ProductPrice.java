package entity;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.Table;
import javax.persistence.Transient;  

@Entity  
@Table(name= "t_productprice")
@Access(AccessType.FIELD)
public class ProductPrice {
	
	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="prod_price_id")
	private long prod_price_id;    
	
	@Column(name="qty")
	double Qty;
	
	@Column(name="unit")
	String Unit; 
	
	@Column(name="prod_id")
	private long prod_id;    
	
	@Column(name="price_Buying")
	private double price_Buying;
	
	@Column(name="price_Packing")
	private double price_Packing;
	
	@Column(name="price_Delivery")
	private double price_Delivery;
	
	@Column(name="price_Making")
	private double price_Making;
	
	@Column(name="price_Service")
	private double price_Service;
	
	@Column(name="price_Storage")
	private double price_Storage;
	
	@Column(name="Tax")
	private double Tax;
	
	@Column(name="price_Total")
	private double price_Total;
	
	@Column(name="seller_code")
	private String seller_code;    
	
	@Column(name="priceason")
	private Date PriceAsOn;
	
	@Transient
	private double discount;
	
	@Transient
	private double after_discount;
		
	@Transient
	private int no_of_sell;
	
	@Transient
	private String prod_name;    
	
	@Transient
	private String shop_name;    
	
	@Transient
	private int seller_rating;

	
	public ProductPrice(long prod_price_id, double Qty, String Unit, long prod_id, double price_Buying, double price_Packing,
			double price_Delivery, double price_Making, double price_Service, double price_Storage, double tax,
			double price_Total, String seller_code, Date priceAsOn) {
		this.prod_price_id = prod_price_id;
		this.prod_id = prod_id;
		this.Qty = Qty;
		this.Unit = Unit;
		this.price_Buying = price_Buying;
		this.price_Packing = price_Packing;
		this.price_Delivery = price_Delivery;
		this.price_Making = price_Making;
		this.price_Service = price_Service;
		this.price_Storage = price_Storage;
		this.Tax = tax;
		this.price_Total = price_Total;
		this.seller_code = seller_code;
		this.PriceAsOn = priceAsOn;
	}
	
	public ProductPrice() {}

	public long getProd_price_id() {
		return prod_price_id;
	}

	public double getQty() {
		return Qty;
	}

	public String getUnit() {
		return Unit;
	}

	public long getProd_id() {
		return prod_id;
	}

	public double getPrice_Buying() {
		return price_Buying;
	}

	public double getPrice_Packing() {
		return price_Packing;
	}

	public double getPrice_Delivery() {
		return price_Delivery;
	}

	public double getPrice_Making() {
		return price_Making;
	}

	public double getPrice_Service() {
		return price_Service;
	}

	public double getPrice_Storage() {
		return price_Storage;
	}

	public double getTax() {
		return Tax;
	}

	public double getPrice_Total() {
		return price_Total;
	}

	public String getseller_code() {
		return seller_code;
	}

	public Date getPriceAsOn() {
		return PriceAsOn;
	}

	public double getDiscount() {
		return discount;
	}

	public double getAfter_discount() {
		return after_discount;
	}

	public int getNo_of_sell() {
		return no_of_sell;
	}

	public String getProd_name() {
		return prod_name;
	}

	public String getShop_name() {
		return shop_name;
	}

	public int getSeller_rating() {
		return seller_rating;
	}

	public void setProd_price_id(long prod_price_id) {
		this.prod_price_id = prod_price_id;
	}

	public void setQty(double qty) {
		Qty = qty;
	}

	public void setUnit(String unit) {
		Unit = unit;
	}

	public void setProd_id(long prod_id) {
		this.prod_id = prod_id;
	}

	public void setPrice_Buying(double price_Buying) {
		this.price_Buying = price_Buying;
	}

	public void setPrice_Packing(double price_Packing) {
		this.price_Packing = price_Packing;
	}

	public void setPrice_Delivery(double price_Delivery) {
		this.price_Delivery = price_Delivery;
	}

	public void setPrice_Making(double price_Making) {
		this.price_Making = price_Making;
	}

	public void setPrice_Service(double price_Service) {
		this.price_Service = price_Service;
	}

	public void setPrice_Storage(double price_Storage) {
		this.price_Storage = price_Storage;
	}

	public void setTax(double tax) {
		Tax = tax;
	}

	public void setPrice_Total(double price_Total) {
		this.price_Total = price_Total;
	}

	public void setseller_code(String seller_code) {
		this.seller_code = seller_code;
	}

	public void setPriceAsOn(Date priceAsOn) {
		PriceAsOn = priceAsOn;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public void setAfter_discount(double after_discount) {
		this.after_discount = after_discount;
	}

	public void setNo_of_sell(int no_of_sell) {
		this.no_of_sell = no_of_sell;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}

	public void setSeller_rating(int seller_rating) {
		this.seller_rating = seller_rating;
	}

	
}
