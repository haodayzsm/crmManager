package top.haodayzsm.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User implements java.io.Serializable{
	private Long user_id;
	private String username;
	private String password;
	private String name;
	private String number;
	private Date login;
	private Set<Permission> permission=new HashSet<Permission>();
	private Long ldentity_id;
	private String ldentity;
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Date getLogin() {
		return login;
	}
	public void setLogin(Date login) {
		this.login = login;
	}
	public Set<Permission> getPermission() {
		return permission;
	}
	public void setPermission(Set<Permission> permission) {
		this.permission = permission;
	}
	public String getLdentity() {
		return ldentity;
	}
	public void setLdentity(String ldentity) {
		this.ldentity = ldentity;
	}
	public Long getLdentity_id() {
		return ldentity_id;
	}
	public void setLdentity_id(Long ldentity_id) {
		this.ldentity_id = ldentity_id;
	}
	
}
