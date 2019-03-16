package com.itheima.crm.service;

import com.itheima.common.utils.Page;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

public interface CustomerService {
	/**
	 * 根据条件分页查询客户
	 * 
	 * @param queryVo
	 * @return
	 */
	public Page<Customer> queryCustomerByQueryVo(QueryVo queryVo);
	
	//根据id查询客户
	public Customer queryCustomerById(Integer id);
	
	//修改客户并保存
	public void update(Customer customer);
	
	//根据id删除客户
	public void delete(Integer id);
}
