package com.example.demo.Pagination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class basePagination implements java.io.Serializable{
	
	protected int currentPage = 1;
	protected int totalPages = 1;
	protected int pageRows = 20;	
	protected boolean hasPre = false;
	protected boolean hasNext = false;
	
	protected List queryList = new ArrayList(); 
	protected int[] pageRowArray = {20,50,100,500};
	
	protected void settingPagination(List<Map<String, Object>> rtnSqlMap) {
		
		Map<String,String> res = new HashMap();
		Integer rowsCount=0;		
		
		for(Map<String,Object> m: rtnSqlMap){			
			rowsCount++;
		}
		
		if(rowsCount>0){
			
			int _TotalPage = rowsCount % pageRows == 0 ?
									(rowsCount/pageRows) : ((rowsCount/pageRows) +1);
			
			setTotalPage(_TotalPage);
			
		}
		
		

	}
	
	
	
	public int getCurrentPage() {
		return currentPage;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public int getTotalPages() {
		return totalPages;
	}
	
	public void setTotalPage(int totalPages) {
		this.totalPages = totalPages;
	}
	
	public int getPageRows() {
		return pageRows;
	}
	
	public void setPageRows(int pageRows) {
		this.pageRows = pageRows;
	}
	
	public List getQueryList() {
		return queryList;
	}
	
	public void setQueryList(List queryList) {
		this.queryList = queryList;
	}
}
