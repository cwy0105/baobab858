package com.baobab.m.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.LocalCPInfoVO;
import com.baobab.m.vo.NonPCroomVO;
import com.baobab.m.vo.PokeVO;

@Repository
public class PokeDAOimpl implements PokeDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate poke;

	@Override
	public void getPoke(String userPhone, String cpName, String cpAddr, int score, int revNum, String divCode, int cpSeq) {
		if(pokeConfirm(userPhone, cpName, divCode, cpSeq) == 0) {
			PokeVO vo = new PokeVO();
			vo.setUser_phone(userPhone);
			vo.setCp_name(cpName);
			vo.setCp_address(cpAddr);
			vo.setScore(score);
			vo.setRev_num(revNum);
			vo.setDiv_code(divCode);
			vo.setCp_seq(cpSeq);
			poke.update("com.baobab.m.dao.PokeMapper.getPoke", vo);
		}
	}

	@Override
	public void delPoke(String userPhone, String cpName, String divCode, int cpSeq) {
		PokeVO vo = new PokeVO();
		vo.setUser_phone(userPhone);
		vo.setCp_name(cpName);
		vo.setDiv_code(divCode);
		vo.setCp_seq(cpSeq);
		poke.delete("com.baobab.m.dao.PokeMapper.delPoke", vo);
	}

	@Override
	public List<PokeVO> showPoke(String userPhone) {
		return poke.selectList("com.baobab.m.dao.PokeMapper.showPoke", userPhone);
	}

	@Override
	public int pokeConfirm(String userPhone, String cpName, String divCode, int cpSeq) {
		PokeVO vo = new PokeVO();
		vo.setUser_phone(userPhone);
		vo.setCp_name(cpName);
		vo.setCp_seq(cpSeq);
		vo.setDiv_code(divCode);
		int result = poke.selectOne("com.baobab.m.dao.PokeMapper.pokeConfirm", vo);
		System.out.println("Æ÷Å© ÄÁÆß : " + result);
		return result;
	}

	@Override
	public LocalCPInfoVO getNonCPone(String cpName, int cpSeq) {
		PokeVO vo = new PokeVO();
		vo.setCp_name(cpName);
		vo.setCp_seq(cpSeq);
		return poke.selectOne("com.baobab.m.dao.PokeMapper.getNonCPone", vo);
	}

	@Override
	public List<PokeVO> showMetheFan(String email) {
		System.out.println(poke.selectList("com.baobab.m.dao.PokeMapper.showMetheFan", email).toString());
		return poke.selectList("com.baobab.m.dao.PokeMapper.showMetheFan", email);
	}

	@Override
	public NonPCroomVO enterNonCp(String cpName, int cpSeq) {
		PokeVO vo = new PokeVO();
		vo.setCp_name(cpName);
		vo.setCp_seq(cpSeq);
		return poke.selectOne("com.baobab.m.dao.PokeMapper.enterNonCp", vo);
	}

}
