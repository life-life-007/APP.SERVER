package org.veight.logon.service;


import org.veight.admin.domain.User;

public interface LogonService {
	public User logon(String username, String password);
}
