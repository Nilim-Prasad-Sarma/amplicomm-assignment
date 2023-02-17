package com.te.employee.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "address")
public class Address {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "add_id")
	private Integer addId;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "address")
	private List<Employee> employees = new ArrayList();
}
