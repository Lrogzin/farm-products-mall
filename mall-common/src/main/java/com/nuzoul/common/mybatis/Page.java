package com.nuzoul.common.mybatis;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class Page<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	protected int pageNo = 1;
	protected int pageSize = 10;

	protected List<T> result = Collections.emptyList();
	protected long totalCount = 0;
	protected long totalPages = 0;

	public Page() {
	}

	public Page(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public Page(int pageNo,int pageSize) {
		this.pageSize = pageSize;
		this.pageNo = pageNo;
	}

	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", pageSize=" + pageSize +", result=" + result + ", totalCount=" + totalCount
				+ "]";
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(final int pageNo) {
		this.pageNo = pageNo;

		if (pageNo < 1) {
			this.pageNo = 1;
		}
	}

	public Page<T> pageNo(final int thePageNo) {
		setPageNo(thePageNo);
		return this;
	}

	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(final int pageSize) {
		this.pageSize = pageSize;

		if (pageSize < 1) {
			this.pageSize = 1;
		}
	}

	public Page<T> pageSize(final int thePageSize) {
		setPageSize(thePageSize);
		return this;
	}

	public int getFirstResult() {
		return (pageNo - 1) * pageSize;
	}




	public List<T> getResult() {
		return result;
	}

	
	public void setResult(final List<T> result) {
		this.result = result;
	}
	
	public long getTotalCount() {
		return totalCount;
	}

	
	public void setTotalCount(final long totalCount) {
		this.totalCount = totalCount;
		this.totalPages = getTotalPages();
	}


	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

	public long getTotalPages() {
		if (totalCount <= 0)
			return 0;

		long count = totalCount / pageSize;
		if (totalCount % pageSize > 0) {
			count++;
		}
		return count;
	}

}
