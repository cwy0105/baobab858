package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.LocalCPInfoVO;
import com.baobab.m.vo.NonPCroomVO;
import com.baobab.m.vo.PokeVO;

@Mapper
public interface PokeMapper {
	void getPoke(PokeVO vo);
	void delPoke(PokeVO vo);
	List<PokeVO> showPoke(String userPhone);
	int pokeConfirm(PokeVO vo);
	LocalCPInfoVO getNonCPone(PokeVO vo);
	List<PokeVO> showMetheFan(String email);
	NonPCroomVO enterNonCp(PokeVO vo);
}
