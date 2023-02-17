package com.te.employee.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.employee.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{

	Optional<Address> findByCityAndState(String city, String state);

}
