package com.ankit.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="person")
	private Person personBean;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="department")
	private Department departmentBean;

	public Employee() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Person getPersonBean() {
		return this.personBean;
	}

	public void setPersonBean(Person personBean) {
		this.personBean = personBean;
	}

	public Department getDepartmentBean() {
		return this.departmentBean;
	}

	public void setDepartmentBean(Department departmentBean) {
		this.departmentBean = departmentBean;
	}

}