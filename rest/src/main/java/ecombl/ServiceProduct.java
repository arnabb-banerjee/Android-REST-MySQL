package ecombl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.query.Query;

import Helper.ExecuteHibernateSave;
import entity.ProductImage;
import entity.ProductInfo;
import entity.ProductPrice;
import entity.ProductReview;

public class ServiceProduct {

	boolean flag = false;
	Session session = null;  
	SessionFactory factory = null;
	
	public ServiceProduct() {
		Metadata meta = new MetadataSources(common.ssr).getMetadataBuilder().build();  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		session = factory.openSession();  
	}
	
	public List<ProductInfo> GetProductList(long prod_id)
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT NEW entity.ProductInfo(p.prod_id, p.div_id, p.cat_id, p.brand_id, p.prod_name, p.prod_desc, "); 
		sb.append("			d.div_name, c.cat_name, b.brand_name) ");
		sb.append(" FROM ProductInfo p "
				+ " join DivisionInfo d on p.div_id = d.div_id "
				+ " join CategoryInfo c on p.cat_id = c.cat_Id "
				+ " join BrandInfo b on p.brand_id = b.brand_id ");

		return session.createQuery(sb.toString(), ProductInfo.class).getResultList();
	}
	
	public ProductInfo GetProductDetails(long prod_id)
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT NEW entity.ProductInfo(p.prod_id, p.div_id, p.cat_id, p.brand_id, p.prod_name, p.prod_desc, "); 
		sb.append("			d.div_name, c.cat_name, b.brand_name) ");
		sb.append(" FROM ProductInfo p "
				+ " join DivisionInfo d on p.div_id = d.div_id "
				+ " join CategoryInfo c on p.cat_id = c.cat_Id "
				+ " join BrandInfo b on p.brand_id = b.brand_id ");

		sb.append(" WHERE p.prod_id = :p.prod_id			 ");
		
		@SuppressWarnings("unchecked")
		Query<ProductInfo> query = session.createQuery(sb.toString());
		query.setParameter("prod_id", prod_id);
		
		return  query.getResultList().get(0);
	}

	
	public List<ProductPrice> GetProductPriceList(long prod_id, long seller_id)
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT NEW entity.ProductPrice(pp.prod_price_id, pp.Qty, pp.Unit, pp.prod_id, pp.price_Buying, pp.price_Packing, "); 
		sb.append(" 			pp.price_Delivery, pp.price_Making, pp.price_Service, pp.price_Storage, pp.tax, "); 
		sb.append(" 			pp.price_Total, seller_code, priceAsOn, p.prod_name, s.shop_name)  ");
		sb.append(" FROM ProductPrice pp, ProductInfo p, SellerInfo s ");
		sb.append(" where pp.prod_id = p.prod_id ");
		sb.append(" and pp.seller_id = s.seller_id ");
		sb.append(" and pp.seller_id = :seller_id ");
		sb.append(" and pp.prod_id = :prod_id ");
		
		@SuppressWarnings("unchecked")
		Query<ProductPrice> query = session.createQuery(sb.toString());
		query.setParameter("seller_id", seller_id);
		query.setParameter("prod_id", prod_id);
		
		return  query.getResultList();
	}
	
	public List<ProductReview> GetProductReviewList(long prod_id, long seller_id)
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT NEW entity.ProductReview(pr.id, pr.prod_id, pr.seller_id, pr.comment, pr.submitted_by, ");
		sb.append("	pr.submitted_by_name, pr.submitted_by_type, pr.is_reply, pr.parent_id,  ");
		sb.append("	p.prod_name, s.shop_name)  ");
		sb.append(" FROM ProductReview pr, ProductInfo p, SellerInfo s  ");
		sb.append(" where pp.prod_id = p.prod_id ");
		sb.append(" and pp.seller_id = s.seller_id ");
		sb.append(" and pp.seller_id = :seller_id ");
		sb.append(" and pp.prod_id = :prod_id ");
		
		@SuppressWarnings("unchecked")
		Query<ProductReview> query = session.createQuery(sb.toString());
		query.setParameter("seller_id", seller_id);
		query.setParameter("prod_id", prod_id);
		
		return  query.getResultList();
	}
	
	
	public boolean SaveProductMaster(long prod_id, String prod_name, String prod_desc, long cat_Id, long div_id, long brand_id)
	{
		ProductInfo obj = new ProductInfo();    
	    //obj.setProd_id(prod_id);
		obj.setProd_name(prod_name);
	    obj.setProd_desc(prod_desc);
	    obj.setCat_id(cat_Id);
	    obj.setDiv_id(div_id);
	    obj.setBrand_id(brand_id);

	    return new ExecuteHibernateSave<ProductInfo>().Save(obj);
	}

	public boolean SaveProductPrice(long prod_price_id, double Qty, String Unit, long prod_id, double price_Buying, double price_Packing,
			double price_Delivery, double price_Making, double price_Service, double price_Storage, double tax,
			double price_Total, String seller_code) {
		try {
			
			ProductPrice obj = new ProductPrice();
			
			//obj.setProd_price_id(prod_price_id);
			obj.setProd_id(prod_id);
			obj.setQty(Qty);
			obj.setUnit(Unit);
			obj.setPrice_Buying(price_Buying);
			obj.setPrice_Packing(price_Packing);
			obj.setPrice_Delivery(price_Delivery);
			obj.setPrice_Making(price_Making);			
			obj.setPrice_Service(price_Service);
			obj.setPrice_Storage(price_Storage);
			obj.setTax(tax);
			obj.setPrice_Total(price_Total);
			obj.setseller_code(seller_code);
			obj.setPriceAsOn(common.Today());
			obj.setPriceAsOn(new Date());
			
			return new Helper.ExecuteHibernateSave<ProductPrice>().Save(obj);
		}
		catch (Exception e) {
			throw e;
		}

	}

	
	public boolean SaveProductImage(long prod_img_id, long prod_id, long seller_id, byte[] fileData, String fileName, 
			String fileType, int sequence, Boolean isActive) {
		try {
			
			ProductImage obj = new ProductImage();
			
			//obj.setProd_price_id(prod_price_id);
			obj.setProd_id(prod_id);
			obj.setFileData(fileData);
			obj.setFileName(fileName);
			obj.setFileType(fileType);
			obj.setSeller_id(seller_id);
			obj.setSequence(sequence);
			obj.setIsActive(isActive);
			obj.setUploadedOn(common.Today());
			
			return new Helper.ExecuteHibernateSave<ProductImage>().Save(obj);
		}
		catch (Exception e) {
			throw e;
		}

	}

}
