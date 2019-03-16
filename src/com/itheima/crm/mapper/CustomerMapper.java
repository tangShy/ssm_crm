package com.itheima.crm.mapper;

import java.util.List;

import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

public interface CustomerMapper {
	
	//����queryVo��ҳ��ѯ�ͻ��б�
	public List<Customer> queryCustomerByQueryVo(QueryVo queryVo);
	
	//����queryVo��ѯ����������
	public int queryCountByQueryVo(QueryVo queryVo);
	
	//����id��ѯ�ͻ�
	public Customer queryCustomerById(Integer id);
	
	//�޸Ŀͻ�������
	public void update(Customer customer);
	
	//����idɾ���ͻ�
	public void delete(Integer id);
}
