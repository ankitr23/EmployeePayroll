package Mapper;

import org.bson.Document;

import Admin.AdminLogin;

public class AdminMapper {

	public static AdminLogin toObject(Document d)
	{
		AdminLogin ad = new AdminLogin();
		ad.setAdminId(d.getString("adminId"));
		ad.setPassword(d.getString("password"));
				
		return ad;
	}
}
