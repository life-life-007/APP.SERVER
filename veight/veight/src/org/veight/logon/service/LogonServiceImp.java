package org.veight.logon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.veight.admin.domain.User;
import org.veight.logon.dao.LogonDao;

@Service("logonService")
public class LogonServiceImp implements LogonService {
	
	@Autowired
	private LogonDao logonDao;
	
	@Override
	public User logon(String username,String password) {
		return logonDao.logon(username, password);
	}

}
