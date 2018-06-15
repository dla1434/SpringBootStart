package com.spring.boot.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.dao.CodeDao;
import com.spring.boot.service.CodeService;
import com.spring.boot.vo.CodeVO;

@Service
public class CodeServiceImpl implements CodeService {
	
	@Autowired
	private CodeDao codeDao;
	
	public List<Map<String, Object>> selectCodeList(CodeVO vo){
		return codeDao.selectCodeList(vo);
	}
	
	public int insertCode(CodeVO vo){
		return codeDao.insertCode(vo);
	}
	
	public int updateCode(CodeVO vo){
		return codeDao.updateCode(vo);
	}
	
	public int deleteCode(CodeVO vo){
		return codeDao.deleteCode(vo);
	}
}
