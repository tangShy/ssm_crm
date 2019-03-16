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
 * 客户管理
 * @author lenovo
 *
 */
@Controller
public class CustomerController {
	
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	
	
	//注解在成员变量上
	@Value("${CUSTOMER_FROM_TYPE}")
	private String industryTypeCode;		//所属行业
	
	@Value("${CUSTOMER_INDUSTRY_TYPE}")
	private String fromTypeCode;			//客户来源
	
	@Value("${CUSTOMER_LEVEL_TYPE}")
	private String levelTypeCode;			//客户级别
	
	/**
	 * 显示客户列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/customer/list")
	public String queryCustomerList(QueryVo vo,Model model){
		System.out.println("queryCustomerList start...");
		//所属行业
		List<BaseDict> industryType = baseDictService.queryBaseDictByDictTypeCode(industryTypeCode);
		//客户来源
		List<BaseDict> fromType = baseDictService.queryBaseDictByDictTypeCode(fromTypeCode);
		//客户级别
		List<BaseDict> levelType = baseDictService.queryBaseDictByDictTypeCode(levelTypeCode);
		
		//把前端页面需要显示的数据放到模型中
		model.addAttribute("industryType", industryType);
		model.addAttribute("fromType", fromType);
		model.addAttribute("levelType", levelType);
		
		//通过四个条件，查询分页对象
		Page<Customer> page = customerService.queryCustomerByQueryVo(vo);
		model.addAttribute("page", page);
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		return "customer";
	}
	
	//去修改页面
	@RequestMapping(value="/customer/edit.action")
	public @ResponseBody
	Customer edit(Integer id){
		return customerService.queryCustomerById(id);
	}
	
	//修改保存
	@RequestMapping(value="/customer/update.action")
	public @ResponseBody
	String update(Customer customer){
		customerService.update(customer);
		return "OK";
	}
	
	//删除客户
	@RequestMapping(value="/customer/delete.action")
	public @ResponseBody
	String delete(Integer id){
		customerService.delete(id);
		return "OK";
	}
	
	
}
