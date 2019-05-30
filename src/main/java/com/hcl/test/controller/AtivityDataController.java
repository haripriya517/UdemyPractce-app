package com.hcl.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.test.service.ActivityDataService;

@RestController
public class AtivityDataController {

	@Autowired
	ActivityDataService activityDataService;
	
	@GetMapping("/partyIds")
	public List<Long> getPartyIdList(){
		List<Long> partyIdsList=activityDataService.getProductIdLists();
		return partyIdsList;
	}
}
