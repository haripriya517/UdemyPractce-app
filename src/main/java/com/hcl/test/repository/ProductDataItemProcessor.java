package com.hcl.test.repository;
import org.springframework.batch.item.ItemProcessor;

import com.hcl.test.dao.ProductData;
import com.hcl.test.dao.ProductDataDto;
public class ProductDataItemProcessor implements ItemProcessor<ProductData, ProductDataDto>{

	@Override
	public ProductDataDto process(ProductData productData) throws Exception {
		   System.out.println("Transforming Employee(s) to EmployeeDTO(s)..");
	        final ProductDataDto productDataDto = new ProductDataDto(productData.getId(),
	        		productData.getProductCode(), productData.getActivityCode(),productData.getStartDate(),
	        		productData.getEndDate(),productData.getSubject(),productData.getAmountTobePaid());

	        return productDataDto;
	}

}
