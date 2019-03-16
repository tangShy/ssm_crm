package com.itheima.crm.pojo;

public class QueryVo {

	private String custName;
	private String custSource;
	private String custIndustry;
	private String custLevel;

	// 当前页码数
	private Integer page = 1;
	// 数据库从哪一条数据开始查
	private Integer start = 0;
	// 每页显示数据条数
	private Integer size = 10;
	
	
	/**
	 * @return the size
	 */
	public Integer getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(Integer size) {
		this.size = size;
	}
	/**
	 * @return the custName
	 */
	public String getCustName() {
		return custName;
	}
	/**
	 * @param custName the custName to set
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}
	/**
	 * @return the custSource
	 */
	public String getCustSource() {
		return custSource;
	}
	/**
	 * @param custSource the custSource to set
	 */
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	/**
	 * @return the custIndustry
	 */
	public String getCustIndustry() {
		return custIndustry;
	}
	/**
	 * @param custIndustry the custIndustry to set
	 */
	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry;
	}
	/**
	 * @return the custLevel
	 */
	public String getCustLevel() {
		return custLevel;
	}
	/**
	 * @param custLevel the custLevel to set
	 */
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	/**
	 * @return the page
	 */
	public Integer getPage() {
		return page;
	}
	/**
	 * @param page the page to set
	 */
	public void setPage(Integer page) {
		this.page = page;
	}
	/**
	 * @return the start
	 */
	public Integer getStart() {
		return start;
	}
	/**
	 * @param start the start to set
	 */
	public void setStart(Integer start) {
		this.start = start;
	}
	
	
}
