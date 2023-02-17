package com.te.employee.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "employee")
public class Employee {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	@Id
	private Integer empId;
	@Column(name = "emp_name")
	private String empName;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "map_employee_address")
	private List<Address> address;
}
