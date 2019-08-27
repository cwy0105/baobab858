package com.baobab.m.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobab.m.dao.AddrConversionDAO;
import com.baobab.m.vo.NaverGeocodingVO;
import com.baobab.m.vo.NonBilliardVO;

@Service
public class AddrConversion {
	
	@Autowired
	AddrConversionDAO dao;
	
	public void workingSave() {
		List<NonBilliardVO> list = dao.getList();
		int listSize = list.size();
		for(int i=0;i<listSize;i++) {
			NonBilliardVO vo = conversion(list.get(i));
			System.out.println(vo.toString());
			if(vo != null) {
				dao.updateGeo(vo);
				System.out.println(i + "번째까지 완료");
			}
		}
	}
	
	public NonBilliardVO conversion(NonBilliardVO vo) {
		return transForNaver(vo, vo.getRoad_addr(), vo.getLocal_addr());
	}
	
	public NonBilliardVO transForNaver(NonBilliardVO vo, String addr, String addr2) {
		NaverGeoCoding geo = new NaverGeoCoding();
		NaverGeocodingVO nvo = geo.trans(addr);
		
		try {
			if(nvo.getErrorMessage().length() <= 0) {
				if(nvo.getAddresses().get(0).getX().equals("0") | nvo.getAddresses().get(0).getX().equals("0.0")) {
					vo.setLatitude(Double.parseDouble(nvo.getAddresses().get(0).getY()));
					vo.setLongitude(Double.parseDouble(nvo.getAddresses().get(0).getX()));
				}else {
					nvo = geo.trans(addr2);
					if(nvo.getErrorMessage().length() <= 0) {
						vo.setLatitude(Double.parseDouble(nvo.getAddresses().get(0).getY()));
						vo.setLongitude(Double.parseDouble(nvo.getAddresses().get(0).getX()));
					}else {
						vo.setLatitude(0);
						vo.setLongitude(0);
					}
				}
			}else {
				vo.setLatitude(0);
				vo.setLongitude(0);
			}
			return vo;
		}catch(Exception e) {
			e.printStackTrace();
			vo.setLatitude(0);
			vo.setLongitude(0);
			return vo;
		}
	}
}
