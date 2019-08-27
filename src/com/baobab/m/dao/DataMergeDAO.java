package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.ClassificationVO;
import com.baobab.m.vo.LocalCPInfoVO;

public interface DataMergeDAO {
	void merge(List<LocalCPInfoVO> local, List<ClassificationVO> classify);
	List<LocalCPInfoVO> localList();
	List<ClassificationVO> classList();
}
