package com.ait.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl.BeanSupplierContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ait.bo.UserBO;
import com.ait.dao.LoginDAO;
import com.ait.dto.UserDTO;

@Service("loginService")
public class LoginMgmtServiceImpl implements LoginMgmtService {
	@Autowired
	private LoginDAO dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED,transactionManager = "transactionManager")
	public String authentiction(UserDTO dto) {
		UserBO bo = null;
		int count = 0;
		// convert bo to dto
		bo = new UserBO();
		BeanUtils.copyProperties(dto, bo);
		// use dao
		count = dao.Validate(bo);
		if (count == 0)
			return "invalid password";
		else
			return "valid password";
	}

}
