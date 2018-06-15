package com.spring.boot.service;

import java.util.List;
import java.util.Map;

import com.spring.boot.vo.CodeVO;

public interface CodeService {
	List<Map<String, Object>> selectCodeList(CodeVO vo);

	int insertCode(CodeVO vo);
	
	int updateCode(CodeVO vo);

	int deleteCode(CodeVO vo);
}
