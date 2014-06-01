package ma.ael.message.bean;

import java.util.ArrayList;
import java.util.List;

import ma.ael.message.entities.Role;

public class RoleBean {
	
	private Long id;
	private String role;
	
	
	
	/**
	 * @param id
	 * @param role
	 */
	public RoleBean(Long id, String role) {
		super();
		this.id = id;
		this.role = role;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	public static List<RoleBean> fromList(List<Role> roles) {
		if(roles == null)
		return null;
		List<RoleBean> ret = new ArrayList<RoleBean>();
		
		for (Role role : roles) {
			ret.add(new RoleBean(Long.valueOf(role.getIdRole()), role.getRole()));
		}
		return ret;
	}
	

}
