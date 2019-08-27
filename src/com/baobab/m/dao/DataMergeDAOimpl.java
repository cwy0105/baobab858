package com.baobab.m.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.ClassificationVO;
import com.baobab.m.vo.LocalCPInfoVO;

@Repository
public class DataMergeDAOimpl implements DataMergeDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate merge;

	@Override
	public void merge(List<LocalCPInfoVO> local, List<ClassificationVO> classify) {
			for(int i=2403;i<classify.size();i++) {
			String classCPname = classify.get(i).getCp_name();
			System.out.println(classCPname);
			String classRoad = classify.get(i).getRoad_addr();
			System.out.println(classRoad);
			String classLocal = classify.get(i).getLocal_addr();
			System.out.println(classLocal);
			for(int j=0;j<local.size();j++) {
				String localCPname = local.get(j).getCp_name();
				System.out.println(localCPname);
				String localRoad = local.get(j).getRoad_addr();
				System.out.println(localRoad);
				String localLocal = local.get(j).getLocal_addr();
				System.out.println(localLocal);
				System.out.println(i);
				System.out.println(j);
				try {
					if(((localRoad.equals(classRoad) || (localLocal.equals(classLocal))) && localCPname.equals(classCPname))){
						local.get(j).setInfo(classify.get(i).getInfo());
						local.get(j).setKind(classify.get(i).getKind());
						merge.update("com.baobab.m.dao.DataMergeMapper.merge", local.get(j));
						break;
					}
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println(String.valueOf(i) + "번 중" + String.valueOf(j) + "번쨰 NPE 발생");
				}
				
			}
		}			
	}

	@Override
	public List<LocalCPInfoVO> localList() {
		return merge.selectList("com.baobab.m.dao.DataMergeMapper.localList");
	}

	@Override
	public List<ClassificationVO> classList() {
		return merge.selectList("com.baobab.m.dao.DataMergeMapper.classList");
	}

}
