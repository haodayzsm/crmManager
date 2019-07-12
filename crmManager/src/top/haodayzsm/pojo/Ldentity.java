
package top.haodayzsm.pojo;

import java.util.HashSet;
import java.util.Set;

public class Ldentity implements java.io.Serializable{
	private Long ldentity_id;
	private String name;
	private Set<User> user=new HashSet();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getLdentity_id() {
		return ldentity_id;
	}
	public void setLdentity_id(Long ldentity_id) {
		this.ldentity_id = ldentity_id;
	}
	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}
}
