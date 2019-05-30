package com.hcl.test.repository;
import org.springframework.batch.item.ItemProcessor;

import com.hcl.test.dao.ActivityData;
import com.hcl.test.dao.ActivityDataDto;
public class ActivityDataItemProcessor implements ItemProcessor<ActivityData, ActivityDataDto>{

	@Override
	public ActivityDataDto process(ActivityData activityDat) throws Exception {
		   System.out.println("Transforming Employee(s) to EmployeeDTO(s)..");
	        final ActivityDataDto activityDataDto = new ActivityDataDto(activityDat.getPartyId(), activityDat.getDate(),
	        		activityDat.getProductCode(), activityDat.getActivityCode(),activityDat.getStatus());

	        return activityDataDto;
	}

}
