package com.itheima.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.common.utils.Page;
import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.service.BaseDictService;
import com.itheima.crm.service.CustomerService;

/**
 * �ͻ�����
 * @author lenovo
 *
 */
@Controller
public class CustomerController {
	
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	
	
	//ע���ڳ�Ա������
	@Value("${CUSTOMER_FROM_TYPE}")
	private String industryTypeCode;		//������ҵ
	
	@Value("${CUSTOMER_INDUSTRY_TYPE}")
	private String fromTypeCode;			//�ͻ���Դ
	
	@Value("${CUSTOMER_LEVEL_TYPE}")
	private String levelTypeCode;			//�ͻ�����
	
	/**
	 * ��ʾ�ͻ��б�
	 * 
	 * @return
	 */
	@RequestMapping(value = "/customer/list")
	public String queryCustomerList(QueryVo vo,Model model){
		System.out.println("queryCustomerList start...");
		//������ҵ
		List<BaseDict> industryType = baseDictService.queryBaseDictByDictTypeCode(industryTypeCode);
		//�ͻ���Դ
		List<BaseDict> fromType = baseDictService.queryBaseDictByDictTypeCode(fromTypeCode);
		//�ͻ�����
		List<BaseDict> levelType = baseDictService.queryBaseDictByDictTypeCode(levelTypeCode);
		
		//��ǰ��ҳ����Ҫ��ʾ�����ݷŵ�ģ����
		model.addAttribute("industryType", industryType);
		model.addAttribute("fromType", fromType);
		model.addAttribute("levelType", levelType);
		
		//ͨ���ĸ���������ѯ��ҳ����
		Page<Customer> page = customerService.queryCustomerByQueryVo(vo);
		model.addAttribute("page", page);
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		return "customer";
	}
	
	//ȥ�޸�ҳ��
	@RequestMapping(value="/customer/edit.action")
	public @ResponseBody
	Customer edit(Integer id){
		return customerService.queryCustomerById(id);
	}
	
	//�޸ı���
	@RequestMapping(value="/customer/update.action")
	public @ResponseBody
	String update(Customer customer){
		customerService.update(customer);
		return "OK";
	}
	
	//ɾ���ͻ�
	@RequestMapping(value="/customer/delete.action")
	public @ResponseBody
	String delete(Integer id){
		customerService.delete(id);
		return "OK";
	}
	
	
}
