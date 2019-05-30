package com.hcl.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.test.repository.ActivityDataRepository;
@Service
public class ActivityDataServiceImpl implements ActivityDataService{
	
	@Autowired
	ActivityDataRepository activityDataRepository;;;

	@Override
	public List<Long> getProductIdLists() {
		List<Long> partyIdLists=activityDataRepository.findDistinctPartyId();
		
		return partyIdLists;
	}

}
