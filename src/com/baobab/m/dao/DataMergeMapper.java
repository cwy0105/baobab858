package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.ClassificationVO;
import com.baobab.m.vo.LocalCPInfoVO;

@Mapper
public interface DataMergeMapper {
	List<LocalCPInfoVO> lacalList();
	List<ClassificationVO> classList();
	void merge(LocalCPInfoVO vo);
}
