package ecombl;

import java.util.List;

import entity.UnitInfo;

public class ServiceMasters {
	public boolean saveUnit(long unit_id, String unit_name, int con_id)
	{
		try {
			UnitInfo obj = new UnitInfo();
			//obj.brand_id = brand_id;
			obj.setUnit_name(unit_name);
			obj.setCon_id(con_id);;
			return new Helper.ExecuteHibernateSave<UnitInfo>().Save(obj);
		}
		catch (Exception e) {
			throw e;
		}
	}

	public List<UnitInfo> GetUnitList()
	{
		return new Helper.ExecuteHibernateSave<UnitInfo>().GetList("select new entity.UnitInfo (B.unit_id, B.con_id, B.unit_name) from entity.UnitInfo B", UnitInfo.class);
	}
	
	public UnitInfo GetUnitDetails(long id)
	{
		return new Helper.ExecuteHibernateSave<UnitInfo>().GetDetails("select new entity.UnitInfo (B.unit_id, B.con_id, B.unit_name) from entity.UnitInfo B where B.unit_id = :id", id, UnitInfo.class);
	}

}
