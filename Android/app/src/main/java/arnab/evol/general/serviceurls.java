package arnab.evol.general;

public class serviceurls {
    public static final String ServiceUrl = "http://10.0.2.2:8080/rest/";

    public static final String Registration_User = ServiceUrl + "saap/userlogin/save";
    public static final String Login_User = ServiceUrl + "saap/userlogin";

    public static final String master_unit_select = ServiceUrl + "saap/master/unit";
    public static final String master_unit_save = ServiceUrl + "saap/master/unit-save";
    public static final String master_brand_select = ServiceUrl + "saap/master/brand";
    public static final String master_brand_save = ServiceUrl + "saap/master/brand-save";
    public static final String master_category_select = ServiceUrl + "saap/master/cat";
    public static final String master_category_save = ServiceUrl + "saap/master/cat-save";
    public static final String master_division_select = ServiceUrl + "saap/master/div";
    public static final String master_division_save = ServiceUrl + "saap/master/div-save";

    public static final String Product_Select = ServiceUrl + "saap/product";
    public static final String Product_Entry = ServiceUrl + "saap/product/save";
    public static final String Product_Price_Select = ServiceUrl + "saap/productprice";
    public static final String Product_Price_Entry = ServiceUrl + "saap/productprice/save";
    public static final String Product_Image_Select = ServiceUrl + "saap/product/image";
    public static final String Product_Image_Entry = ServiceUrl + "saap/prodimg/upload";

}
