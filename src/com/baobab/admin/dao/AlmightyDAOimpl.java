package com.baobab.admin.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.AlMightyVO;
import com.baobab.m.vo.CPInfoVO;

@Repository
public class AlmightyDAOimpl implements AlmightyDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate alm;

	@Override
	public List<CPInfoVO> cpSearch(String searchWord) {
		return alm.selectList("com.baobab.admin.dao.AlmightyMapper.cpSearch", "%" + searchWord + "%");
	}

	@Override
	public int almightyLogin(HttpServletRequest request) {
		AlMightyVO vo = new AlMightyVO();
		vo.setAlmightyID(request.getParameter("id"));
		vo.setAlmightyPW(request.getParameter("pw"));
		List<AlMightyVO> list = alm.selectList("com.baobab.admin.dao.AlmightyMapper.almightyLogin", vo);
		if(list.size()==0){
			return 0;
		}else {
			return 1;
		}
		
	}

}
