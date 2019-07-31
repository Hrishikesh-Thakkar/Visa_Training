package com.visa.prj.client;

import com.visa.prj.dao.MobileDao;
import com.visa.prj.dao.MobileDaoFactory;
import com.visa.prj.dao.impl.MobileDaoDbImpl;
import com.visa.prj.dao.impl.MobileDaoMongoImpl;
import com.visa.prj.entity.Mobile;

public class MobileClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mobile m=new Mobile();
		//MobileDao mobileDao= new MobileDaoMongoImpl();
		//mobileDao.addMobile(m);
		MobileDao mobileDao=MobileDaoFactory.getMobileDao();
		mobileDao.addMobile(m);
	}

}
