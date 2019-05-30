package com.hcl.test.config;

import java.util.Date;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.hcl.test.dao.ProductData;

public class MyCustomFieldSetMapper<T> implements FieldSetMapper<ProductData> {

	@Override
	public ProductData mapFieldSet(FieldSet fieldSet) throws BindException {
		ProductData productData = new ProductData();

		productData.setId(fieldSet.readLong("id"));
		productData.setProductCode(fieldSet.readLong("productCode"));
		productData.setActivityCode(fieldSet.readLong("activityCode"));
		try {
			productData.setStartDate(fieldSet.readDate("startDate", "dd/MM/yyyy"));
		}
		catch(Exception e)
		{
			productData.setStartDate(fieldSet.readDate("startDate", "dd-MM-yyyy"));
		}
		

		Date date = null;
		if (fieldSet.readString("endDate").equals("")) {

			productData.setEndDate(date);
		} else {
			productData.setEndDate(fieldSet.readDate("endDate", "dd/MM/yyyy"));
		}

		productData.setSubject(fieldSet.readString("subject"));
		productData.setAmountTobePaid(fieldSet.readDouble("amountTobePaid"));
		return productData;
	}

}
