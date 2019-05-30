package com.hcl.test.dao;

@FunctionalInterface
public interface TestInteface {
	default String getList() {
		return null;
	}
	static String getTest()
	{
		return null;
		
	}
	public  void getLoan();

}
