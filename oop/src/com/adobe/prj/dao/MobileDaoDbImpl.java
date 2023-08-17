package com.adobe.prj.dao;

import com.adobe.prj.entity.Mobile;

public class MobileDaoDbImpl implements MobileDao {
	// state and behaviour
	
	@Override
	public void addMobile(Mobile m) {
		// insert into employees ...
		System.out.println("Mobile " + m.getName() + " stored in RDBMS!!!");
	}

}
