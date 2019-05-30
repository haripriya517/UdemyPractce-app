package com.hcl.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hcl.test.dao.ActivityData;

public interface ActivityDataRepository extends JpaRepository<ActivityData, Long>{
	
	@Query("select distinct partyId from ActivityData")
	public List<Long> findDistinctPartyId();

}
