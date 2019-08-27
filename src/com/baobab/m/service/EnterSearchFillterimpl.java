package com.baobab.m.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobab.m.dao.BilliardSearchDAO;
import com.baobab.m.dao.EnterOursDAO;
import com.baobab.m.dao.KaraokeSearchDAO;
import com.baobab.m.dao.PCroomSearchDAO;
import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.PageSearchVO;
import com.baobab.m.vo.SearchVO;

@Service
public class EnterSearchFillterimpl implements EnterSearchFillter {

	@Autowired
	PCroomSearchDAO pc;
	@Autowired
	KaraokeSearchDAO ka;
	@Autowired
	BilliardSearchDAO bi;
	@Autowired
	EnterOursDAO eo;
	
	@Override
	public List<CPInfoVO> ourFillter(HttpServletRequest request) {
		PageSearchVO vo = new PageSearchVO();
		vo.setSearchWord("%" + request.getParameter("word") + "%");
		vo.setSortBy(request.getParameter("sortBy"));
		vo.setLongitude(Double.parseDouble(request.getParameter("longitude")));
		vo.setLatitude(Double.parseDouble(request.getParameter("latitude")));
		vo.setListCount(Integer.parseInt(request.getParameter("listCount")));
		vo.setDiv(request.getParameter("cpDiv"));
		
		if(request.getParameter("location").equals("전체")) {
			vo.setLocation("%%");
		}else {
			vo.setLocation("%" + request.getParameter("location") + "%");
		}
		
		if(vo.getSortBy().equals("거리순")) {
			if(request.getParameter("item").equals("전체")) {
				return eo.getOursDistance(vo);
			}else if(request.getParameter("item").equals("지역명")) {
				return eo.getOursDisLocation(vo);
			}else if(request.getParameter("item").equals("업체명")) {
				return eo.getOursDisCpName(vo);
			}else {
				return eo.getSurroundingsOur(vo);
			}
		}else if(vo.getSortBy().equals("인기순")) {
			if(request.getParameter("item").equals("전체")) {
				return eo.getOursPopularity(vo);
			}else if(request.getParameter("item").equals("지역명")) {
				return eo.getOursPopLocation(vo);
			}else if(request.getParameter("item").equals("업체명")) {
				return eo.getOursPopCpName(vo);
			}else {
				return eo.getSurroundingsOur(vo);
			}
		}else {
			return eo.getSurroundingsOur(vo);
		}
	}

	@Override
	public List<?> nonFillter(HttpServletRequest request) {
		SearchVO vo = new SearchVO();
		vo.setWord("%" + request.getParameter("word") + "%");
		vo.setSortBy(request.getParameter("sortBy"));
		vo.setLongitude(Double.parseDouble(request.getParameter("longitude")));
		vo.setLatitude(Double.parseDouble(request.getParameter("latitude")));
		vo.setListCount(Integer.parseInt(request.getParameter("listCount")));
		vo.setCount(Integer.parseInt(request.getParameter("count")));
		
		System.out.println("cpDiv :: " + request.getParameter("cpDiv"));
		
		if(request.getParameter("location").equals("전체")) {
			vo.setLocation("%%");
		}else {
			vo.setLocation("%" + request.getParameter("location") + "%");
		}
		
		if(request.getParameter("cpDiv").equals("PC방")) {
			if(vo.getSortBy().equals("거리순")) {
				if(request.getParameter("item").equals("전체")) {
					return pc.disAll(vo);
				}else if(request.getParameter("item").equals("지역명")) {
					return pc.disLocal(vo);
				}else if(request.getParameter("item").equals("업체명")) {
					return pc.disName(vo);
				}else {
					return pc.surrounding(vo);
				}
			}else {
				if(request.getParameter("item").equals("전체")) {
					return pc.popAll(vo);
				}else if(request.getParameter("item").equals("지역명")) {
					return pc.popLocal(vo);
				}else if(request.getParameter("item").equals("업체명")) {
					return pc.popName(vo);
				}else {
					return pc.surrounding(vo);
				}
			}
		}else if(request.getParameter("cpDiv").equals("노래방")) {
			if(vo.getSortBy().equals("거리순")) {
				if(request.getParameter("item").equals("전체")) {
					return ka.disAll(vo);
				}else if(request.getParameter("item").equals("지역명")) {
					return ka.disLocal(vo);
				}else if(request.getParameter("item").equals("업체명")) {
					return ka.disName(vo);
				}else {
					return pc.surrounding(vo);
				}
			}else {
				if(request.getParameter("item").equals("전체")) {
					return ka.popAll(vo);
				}else if(request.getParameter("item").equals("지역명")) {
					return ka.popLocal(vo);
				}else if(request.getParameter("item").equals("업체명")) {
					return ka.popName(vo);
				}else {
					return pc.surrounding(vo);
				}
			}
		}else if(request.getParameter("cpDiv").equals("당구장")) {
			if(vo.getSortBy().equals("거리순")) {
				if(request.getParameter("item").equals("전체")) {
					return bi.disAll(vo);
				}else if(request.getParameter("item").equals("지역명")) {
					return bi.disLocal(vo);
				}else if(request.getParameter("item").equals("업체명")) {
					return bi.disName(vo);
				}else {
					return pc.surrounding(vo);
				}
			}else {
				if(request.getParameter("item").equals("전체")) {
					return bi.popAll(vo);
				}else if(request.getParameter("item").equals("지역명")) {
					return bi.popLocal(vo);
				}else if(request.getParameter("item").equals("업체명")) {
					return bi.popName(vo);
				}else {
					return pc.surrounding(vo);
				}
			}
		}else {
			return null;
		}
	}

}
