package arnab.evol.Entity;

import java.util.Date;

public class ProductPrice {
	private long prod_price_id;
	private long prod_id;
	private String prod_name;
	private double price_Buying;
	private double price_Packing;
	private double price_Delivery;
	private double price_Making;
	private double price_Service;
	private double price_Storage;
	private double price_Tax;
	private double price_Total;
	private double discount;
	private double after_discount;
		
	private long seller_id;    
	private String shop_name;    
	private int no_of_sell;
	private int seller_rating;
		
	private Date PriceAsOn;
		
	public long getprod_price_id() {
		return prod_price_id;
	}

	public void setprod_price_id(long id) {
		this.prod_price_id = id;
	}

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

	public double getPrice_Buying() {
		return price_Buying;
	}

	public void setPrice_Buying(double price_Buying) {
		this.price_Buying = price_Buying;
	}

		public double getPrice_Packing() {
		return price_Packing;
	}

	public void setPrice_Packing(double price_Packing) {
		this.price_Packing = price_Packing;
	}

	public double getPrice_Delivery() {
		return price_Delivery;
	}

	public void setPrice_Delivery(double price_Delivery) {
		this.price_Delivery = price_Delivery;
	}

	public double getPrice_Making() {
		return price_Making;
	}

	public void setPrice_Making(double price_Making) {
		this.price_Making = price_Making;
	}

	public double getPrice_Service() {
		return price_Service;
	}

	public void setPrice_Service(double price_Service) {
		this.price_Service = price_Service;
	}

	public double getPrice_Storage() {
		return price_Storage;
	}

	public void setPrice_Storage(double price_Storage) {
		this.price_Storage = price_Storage;
	}

	public double getPrice_Tax() {
		return price_Tax;
	}

	public void setPrice_Tax(double price_Tax) {
		this.price_Tax = price_Tax;
	}

	public double getPrice_Total() {
		return price_Total;
	}

	public void setPrice_Total(double price_Total) {
		this.price_Total = price_Total;
	}

	public Date getPriceAsOn() {
		return PriceAsOn;
	}

	public void setPriceAsOn(Date priceAsOn) {
		PriceAsOn = priceAsOn;
	}
	
	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getAfter_discount() {
		return after_discount;
	}

	public void setAfter_discount(double after_discount) {
		this.after_discount = after_discount;
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
	
	public ProductPrice() {}

	public ProductPrice(long prod_price_id, long prod_id, String prod_name, double price_Buying, double price_Packing,
			double price_Delivery, double price_Making, double price_Service, double price_Storage, double price_Tax,
			double price_Total, long seller_id, String shop_name,
			int seller_rating, Date priceAsOn) {
		this.prod_price_id = prod_price_id;
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.price_Buying = price_Buying;
		this.price_Packing = price_Packing;
		this.price_Delivery = price_Delivery;
		this.price_Making = price_Making;
		this.price_Service = price_Service;
		this.price_Storage = price_Storage;
		this.price_Tax = price_Tax;
		this.price_Total = price_Total;
		this.seller_id = seller_id;
		this.shop_name = shop_name;
		this.seller_rating = seller_rating;
		this.PriceAsOn = priceAsOn;
	}


}
