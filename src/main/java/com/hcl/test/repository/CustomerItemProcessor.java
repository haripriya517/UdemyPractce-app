package com.hcl.test.repository;
import org.springframework.batch.item.ItemProcessor;

import com.hcl.test.dao.Customer;
import com.hcl.test.dao.CustomerDto;
public class CustomerItemProcessor implements ItemProcessor<Customer, CustomerDto>{

	@Override
	public CustomerDto process(Customer customer) throws Exception {
		   System.out.println("Transforming Employee(s) to EmployeeDTO(s)..");
	        final CustomerDto empployeeDto = new CustomerDto(customer.getPartyId(), customer.getProduct_code(),
	        		customer.getActivity_code(), customer.getStatusc(),customer.getProvider());

	        return empployeeDto;
	}

}
