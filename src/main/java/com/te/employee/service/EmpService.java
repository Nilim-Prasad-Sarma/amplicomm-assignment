package com.te.employee.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.employee.dto.EmployeeDto;
import com.te.employee.entity.Address;
import com.te.employee.entity.Employee;
import com.te.employee.repo.AddressRepo;
import com.te.employee.repo.EmpRepo;

@Service
public class EmpService {

	@Autowired
	private EmpRepo empRepo;
	@Autowired
	private AddressRepo addressRepo;

	public Employee registerEmp(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeDto, employee);
		employee.setAddress(new ArrayList());
		employeeDto.getAddresses().stream().forEach(a -> {
			Optional<Address> addressOP = addressRepo.findByCityAndState(a.getCity(), a.getState());
			if (addressOP.isPresent()) {
				employee.getAddress().add(addressOP.get());
			} else {
				Address address = new Address();
				BeanUtils.copyProperties(a, address);
				address.getEmployees().add(employee);
				employee.getAddress().add(address);
			}
		});
		return empRepo.save(employee);

	}

}
