package com.itheima.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.common.utils.Page;
import com.itheima.crm.mapper.CustomerMapper;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

/**
 * �ͻ�����
 * @author lenovo
 *
 */
@Service
public class CustomerServicelmpl implements CustomerService {
	@Autowired
	private CustomerMapper customerMapper;
	
	
	//ͨ���ĸ���������ѯ��ҳ����
	@Override
	public Page<Customer> queryCustomerByQueryVo(QueryVo vo) {
		Page<Customer> page = new Page<Customer>();
		//ÿҳ��
		page.setSize(5);
		vo.setSize(5);
		if(null != vo){
			if(null != vo.getPage()){
				page.setPage(vo.getPage());
				vo.setStart((vo.getPage()-1)*vo.getSize());
			}
			if(null != vo.getCustName() && !"".equals(vo.getCustName().trim())){
				vo.setCustName(vo.getCustName().trim());
			}
			if(null != vo.getCustSource() && !"".equals(vo.getCustSource().trim())){
				vo.setCustSource(vo.getCustSource().trim());
			}
			if(null != vo.getCustIndustry() && !"".equals(vo.getCustIndustry().trim())){
				vo.setCustIndustry(vo.getCustIndustry().trim());
			}
			if(null != vo.getCustLevel() && !"".equals(vo.getCustLevel().trim())){
				vo.setCustLevel(vo.getCustLevel().trim());
			}
			
			//������
			page.setTotal(customerMapper.queryCountByQueryVo(vo));
			page.setRows(customerMapper.queryCustomerByQueryVo(vo));
		}
				
		return page;
	}

	//����id��ѯ�ͻ�
	public Customer queryCustomerById(Integer id) {
		return customerMapper.queryCustomerById(id);		
	}
	
	//�޸Ŀͻ�������
	public void update(Customer customer){
		customerMapper.update(customer);
	}
	
	//����idɾ���ͻ�
	public void delete(Integer id) {
		customerMapper.delete(id);
	}

}
