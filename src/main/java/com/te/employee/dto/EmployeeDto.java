package com.te.employee.dto;

import java.util.List;

import lombok.Data;

@Data
public class EmployeeDto {
	private String empName;
	private List<AddressDto> addresses;
}
