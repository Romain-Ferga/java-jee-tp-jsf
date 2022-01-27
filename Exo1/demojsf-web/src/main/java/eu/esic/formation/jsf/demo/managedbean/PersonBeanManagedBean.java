package eu.esic.formation.jsf.demo.managedbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="personBean")
@SessionScoped
public class PersonBeanManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

	public String getName() {
		return name; 
	}

	public void setName(String name) {
		this.name = name;
	}

}
