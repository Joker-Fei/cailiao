package com.hlg.util;

public class PageBean {
	private int pageNo;// 当前是第几页
	private int pageCount;// 一共有多少页
	public static int pageSize = 7;// 每页大小

	private int rowCount;

	public static int getPageSize() {
		return pageSize;
	}

	public static void setPageSize(int pageSize) {
		PageBean.pageSize = pageSize;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	// 获取当前页
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	// 获取下一页
	public int getNextPage() {
		if (pageNo < pageCount) {
			return pageNo + 1;
		}
		return pageCount;
	}

	// 获取前一页
	public int getPrePage() {
		if (pageNo > 1) {
			return pageNo - 1;
		}
		return 1;
	}

	public int getPageCount() {
		return pageCount;
	}

	// 页码的大小：表中记录的行数/页码的大小
	// count代表的是表中的记录数
	public void setPageCount(int count) {
		if (count % pageSize == 0) {
			this.pageCount = count / pageSize;
		} else {
			this.pageCount = count / pageSize + 1;
		}
	}

}
