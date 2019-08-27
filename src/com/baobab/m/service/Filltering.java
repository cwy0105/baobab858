package com.baobab.m.service;

import java.util.List;

import com.baobab.m.vo.PageSearchVO;

public interface Filltering {
	public List<?> disNoneWord(PageSearchVO vo);
	public List<?> popNoneWord(PageSearchVO vo);
	public String kindFillter(String menu);
}
