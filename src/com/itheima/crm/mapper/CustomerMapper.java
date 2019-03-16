package com.itheima.crm.mapper;

import java.util.List;

import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

public interface CustomerMapper {
	
	//根据queryVo分页查询客户列表
	public List<Customer> queryCustomerByQueryVo(QueryVo queryVo);
	
	//根据queryVo查询数据总条数
	public int queryCountByQueryVo(QueryVo queryVo);
	
	//根据id查询客户
	public Customer queryCustomerById(Integer id);
	
	//修改客户并保存
	public void update(Customer customer);
	
	//根据id删除客户
	public void delete(Integer id);
}
