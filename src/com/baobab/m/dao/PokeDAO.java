package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.LocalCPInfoVO;
import com.baobab.m.vo.NonPCroomVO;
import com.baobab.m.vo.PokeVO;

public interface PokeDAO {
	void getPoke(String userPhone, String cpName, String cpAddr, int score, int revNum, String divCode, int cpSeq);
	void delPoke(String userPhone, String cpName, String divCode, int cpSeq);
	List<PokeVO> showPoke(String userPhone);
	int pokeConfirm(String userPhone, String cpName, String divCode, int cpSeq);
	LocalCPInfoVO getNonCPone(String cpName, int cpSeq);
	List<PokeVO> showMetheFan(String email);
	NonPCroomVO enterNonCp(String cpName, int cpSeq);
}
