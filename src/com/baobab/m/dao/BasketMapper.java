package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.BasketVO;
import com.baobab.m.vo.CPInfoVO;

@Mapper
public interface BasketMapper {
	int confRepetition(BasketVO vo);
	void inBasket(BasketVO vo);
	void upBasket(BasketVO vo);
	void delBasket(BasketVO vo);
	List<BasketVO> basketList(BasketVO vo);
	CPInfoVO basCpInfo(BasketVO vo);
	List<BasketVO> basDetailInfo(BasketVO vo);
}
