create database ecom;
use ecom;

create table mst_Username (
	id int not null auto_increment primary key,
    UserName nvarchar(300),
    EmailID nvarchar(300),
    Mobile nvarchar(150),
    UserType varchar(1) /*A=Admin, S=Seller, Null=Buyer*/
);

create table mst_Password (
	id int not null,
    Password nvarchar(300),
	Status varchar(1), /*L=Locked, I=Invalid, E=Expired*/
    OTP nvarchar(300),
    OTPStatus varchar(1), /*L=Locked, I=Invalid, E=Expired*/
    OTPSentOn datetime,
    CountOfWrongPwd int
);

create table mst_Product (
	id int not null auto_increment primary key,
    Name nvarchar(300),
	Description nvarchar(5000)
);

create table mst_ProductImage (
	id int not null auto_increment primary key,
    Prod_id int not null,
    ImageName nvarchar(300),
	ImageType nvarchar(50),
    ImageData nvarchar(300)
);


create table mst_Category (
	id int not null auto_increment primary key,
    Parentid int,
    Name nvarchar(300),
	IsActive varchar(1) /*Y=Valid, N=Invalid*/
);


create table mst_ProductPrice (
	id int not null auto_increment primary key,
    Prod_id int not null,
    Price numeric(8,2),
	PriceAsOn datetime
);

create table mst_CategoryDiscount (
	id int not null auto_increment primary key,
    Prod_id int not null,
    Discount_Per numeric(2,2),
	Discount_Flat numeric(8,2),
	ValidFrom datetime,
	ValidTill datetime,
    Discount_desc nvarchar(5000),
    Discount_Img blob
);

create table mst_BrandDiscount (
	id int not null auto_increment primary key,
    Prod_id int not null,
    Discount_Per numeric(2,2),
	Discount_Flat numeric(8,2),
	ValidFrom datetime,
	ValidTill datetime,
    Discount_desc nvarchar(5000),
    Discount_Img blob
);

create table mst_ProductDiscount (
	id int not null auto_increment primary key,
    Prod_id int not null,
    Discount_Per numeric(2,2),
	Discount_Flat numeric(8,2),
	ValidFrom datetime,
	ValidTill datetime,
    Discount_desc nvarchar(5000),
    Discount_Img blob
);

DELIMITER //
drop procedure sp_manage_product;
create procedure sp_manage_product (
	in p_mode int,
	in p_id int,
    in p_Name nvarchar(300),
    in p_Description nvarchar(500)
)
begin
	IF (p_mode = 0) THEN
		SELECT `Name`, `Description` FROM mst_Product 
        WHERE id = case when p_id > 0 then p_id else id end;
	ELSEIF (p_mode = 1) THEN
		INSERT INTO mst_Product (`Name`, `Description`) values (p_Name, p_Description);
	ELSEIF (p_mode = 2) THEN
		UPDATE mst_Product SET `Name` = p_Name, `Description` = p_Description WHERE id = p_id;
	ELSEIF (p_mode = 3) THEN
		delete from mst_Product WHERE id = p_id;
	END IF;
end;
