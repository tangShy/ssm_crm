package com.itheima.crm.service;

import com.itheima.common.utils.Page;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

public interface CustomerService {
	/**
	 * ����������ҳ��ѯ�ͻ�
	 * 
	 * @param queryVo
	 * @return
	 */
	public Page<Customer> queryCustomerByQueryVo(QueryVo queryVo);
	
	//����id��ѯ�ͻ�
	public Customer queryCustomerById(Integer id);
	
	//�޸Ŀͻ�������
	public void update(Customer customer);
	
	//����idɾ���ͻ�
	public void delete(Integer id);
}
