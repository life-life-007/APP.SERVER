package org.veight.logon.dao;

import org.veight.admin.domain.User;

public interface LogonDao {
	public User logon(String username, String password);
}
