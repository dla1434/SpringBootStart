package com.spring.boot.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spring.boot.vo.CodeVO;

@Repository
public interface CodeDao {
	public List<Map<String, Object>> selectCodeList(CodeVO vo);
	
	public int insertCode(CodeVO vo);
	
	public int updateCode(CodeVO vo);
	
	public int deleteCode(CodeVO vo);
}
