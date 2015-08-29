package org.veight.logon.action;

import java.util.Map;


import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;
import org.veight.admin.domain.User;
import org.veight.logon.service.LogonService;

//@Controller("logonAction")
public class LogonAction extends ActionSupport {

    private String username;
    private String password;
    private String reMsg;

    @Autowired
    private LogonService logonService;


    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public String execute() throws Exception {
        if (this.getUsername() == null || this.getPassword() == null) {
            this.setReMsg("用户密码或者账号为空!");
            return "logon";
        }
        User user = logonService.logon(this.getUsername(), this.getPassword());
        if (user != null) {
            //session
            Map attributes = ActionContext.getContext().getSession();
            attributes.put("user", user);

            this.setReMsg("用户名称：" + this.getUsername());
            return "logonSuccess";
        }
        this.setReMsg("session失效，重新登录");
        return "logon";
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getReMsg() {
        return reMsg;
    }


    public void setReMsg(String reMsg) {
        this.reMsg = reMsg;
    }


}
