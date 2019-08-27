package com.baobab.m.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobab.m.dao.GetOurCPDAO;
import com.baobab.m.dao.SearchHistoryDAO;
import com.baobab.m.dao.StoreListDAO;
import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.LocalCPInfoVO;
import com.baobab.m.vo.PageSearchVO;
import com.baobab.m.vo.SearchHistoryVO;

@Service
public class SerchDataFilterimpl implements SerchDataFillter {
	
	@Autowired
	StoreListDAO slDao;
	@Autowired
	GetOurCPDAO getOurs;
	@Autowired
	OurFillteringimpl ourFillter;
	@Autowired
	NonFillteringimpl nonFillter;
	@Autowired
	SearchHistoryDAO sh;

	@Override
	public List<LocalCPInfoVO> dataFilltering(String selectItem, String serchLoc, String location, int count, int listCount,
			String sortBy, String menu, double longitude, double latitude, String t1_1) {
		
		System.out.println("첫번째 필터"+t1_1);
		
		serchLoc = "%" + serchLoc + "%";
		if(location.equals("전체")) {
			location = "%%";
		}else {
			location = "%" + location + "%";
		}
		
		PageSearchVO vo = new PageSearchVO();
		vo.setCount(count);
		vo.setListCount(listCount);
		vo.setLatitude(latitude);
		vo.setLongitude(longitude);
		vo.setLocation(location);
		vo.setKind(menu);
		vo.setDiv(selectItem);
		vo.setSortBy(sortBy);
		vo.setSearchWord(serchLoc);
		vo.setTheme1_1(theme(t1_1));
		System.out.println(vo);
		if(sortBy.equals("거리순")) {
			if(serchLoc.equals("%none%")) {
				return nonFillter.disNoneWord(vo);
			}else {
				if(selectItem.equals("전체")) {
					vo.setKind(nonFillter.kindFillter(vo.getKind()));
					return slDao.getAllinfo(vo);
				}else if(selectItem.equals("지역명")) {
					vo.setKind(nonFillter.kindFillter(vo.getKind()));
					return slDao.getLocalinfo(vo);
				}else if(selectItem.equals("메뉴명")) {
					vo.setKind(nonFillter.kindFillter(vo.getKind()));
					return slDao.getMenuinfo(vo);
				}else if(selectItem.equals("식당명")) {
					vo.setKind(nonFillter.kindFillter(vo.getKind()));
					return slDao.getNameInfo(vo);
				}
			}
		}else if(sortBy.equals("인기순")) {
			if(serchLoc.equals("%none%")) {
				return nonFillter.popNoneWord(vo);
			}else {
				if(selectItem.equals("전체")) {
					vo.setKind(nonFillter.kindFillter(vo.getKind()));
					return slDao.selectPopAllinfo(vo);
				}else if(selectItem.equals("지역명")) {
					vo.setKind(nonFillter.kindFillter(vo.getKind()));
					return slDao.selectPopLocalinfo(vo);
				}else if(selectItem.equals("메뉴명")) {
					vo.setKind(nonFillter.kindFillter(vo.getKind()));
					return slDao.selectPopMenuinfo(vo);
				}else if(selectItem.equals("식당명")) {
					vo.setKind(nonFillter.kindFillter(vo.getKind()));
					return slDao.selectPopNameinfo(vo);
				}
			}
		}
		return null;
	}

	@Override
	public List<CPInfoVO> ourFillter(String selectItem, String serchLoc, String location, String sortBy,
			double longitude, double latitude, String menu, int listCount, String t1_1) {
		SearchHistoryVO shvo = new SearchHistoryVO();
		shvo.setSearchWord(serchLoc);
		shvo.setSearchDiv(selectItem);
		shvo.setSearchLocation(location);
		shvo.setSort(sortBy);
		shvo.setUserLatitude(latitude);
		shvo.setUserLongitude(longitude);
		shvo.setKind(menu);
		shvo.setTheme(t1_1);
		sh.getHistory(shvo);
		
		serchLoc = "%" + serchLoc + "%";
		if(location.equals("전체")) {
			location = "%%";
		}else {
			location = "%" + location + "%";
		}
		
		PageSearchVO vo = new PageSearchVO();
		vo.setLatitude(latitude);
		vo.setLongitude(longitude);
		vo.setLocation(location);
		vo.setKind(menu);
		vo.setDiv(selectItem);
		vo.setSortBy(sortBy);
		vo.setSearchWord(serchLoc);
		vo.setListCount(listCount);
		vo.setTheme1_1(theme(t1_1));
		vo.setWeeks(getWeek());
		vo.setDay("%" + getDateDay() + "%");
		System.out.println(vo);
		if(sortBy.equals("거리순")) {
			if(serchLoc.equals("%none%")) {
				return ourFillter.disNoneWord(vo);
			}else {
				if(vo.getKind().equals("쿠폰")) {
					return getOurs.getOurCouponDistance(vo);
				}else {
					if(selectItem.equals("전체")) {
						vo.setKind(ourFillter.kindFillter(vo.getKind()));
						return getOurs.getOursDistance(vo);
					}else if(selectItem.equals("지역명")) {
						vo.setKind(ourFillter.kindFillter(vo.getKind()));
						return getOurs.getOursDisLocation(vo);
					}else if(selectItem.equals("메뉴명")) {
						vo.setKind(ourFillter.kindFillter(vo.getKind()));
						return getOurs.getOursDisMenu(vo);
					}else if(selectItem.equals("식당명")) {
						vo.setKind(ourFillter.kindFillter(vo.getKind()));
						return getOurs.getOursDisCpName(vo);
					}
				}
			}
		}else if(sortBy.equals("인기순")) {
			if(serchLoc.equals("%none%")) {
				return ourFillter.popNoneWord(vo);
			}else {
				if(selectItem.equals("전체")) {
					vo.setKind(ourFillter.kindFillter(vo.getKind()));
					return getOurs.getOursPopularity(vo);
				}else if(selectItem.equals("지역명")) {
					vo.setKind(ourFillter.kindFillter(vo.getKind()));
					return getOurs.getOursPopLocation(vo);
				}else if(selectItem.equals("메뉴명")) {
					vo.setKind(ourFillter.kindFillter(vo.getKind()));
					return getOurs.getOursPopMenu(vo);
				}else if(selectItem.equals("식당명")) {
					vo.setKind(ourFillter.kindFillter(vo.getKind()));
					return getOurs.getOursPopCpName(vo);
				}
			}
		}
		return null;
	}
	
	public String theme(String theme) {
		String first = theme.replace(", ", "|");
		String second = first.replace("none|", "");
		String third = second.replace("|none", "");
		String fourth = third.replace("none", "");
		System.out.println("테마 메서드 : " + fourth);
		return fourth;
	}
	
	/*public List<CPInfoVO> dayFillter(List<CPInfoVO> list) throws ArrayIndexOutOfBoundsException{
		System.out.println("날짜필터 전 : " + list.size());
		int week = Calendar.getInstance().get(Calendar.WEEK_OF_MONTH);
		for(int i=0;i<list.size();i++) {
			String[] allWeeks = list.get(i).getClose_day().split("~");
			System.out.println(allWeeks.length);
			for(int k=0;k<allWeeks.length;k++) {
				System.out.print(allWeeks[k]);
			}
			String[] allClose = makeArr(allWeeks[0]);
			String[] thisWeek = makeArr(allWeeks[week]);
			for(int j=0;j<allClose.length;j++) {
				if(allClose[j].equals(getDateDay())) {
					list.remove(i);
				}
			}
			for(int j=0;j<thisWeek.length;j++) {
				if(thisWeek[j].equals(getDateDay())) {
					list.remove(i);
				}
			}
		}
		System.out.println("날짜필터 후 : " + list.toString());
		return list;
	}*/
	
	public String[] makeArr(String str) {
		if(str.contains(",")) {
			return str.split(",");
		}else {
			String[] result = {str};
			return result;
		}
	}
	
	public int getWeek() {
		Calendar c = Calendar.getInstance();
 		return c.get(Calendar.WEEK_OF_MONTH) + 1;
	}
	
	public String getDateDay() {
	    String day = "" ;
	    
	    Date nDate = new Date();
	     
	    Calendar cal = Calendar.getInstance() ;
	    cal.setTime(nDate);
	     
	    int dayNum = cal.get(Calendar.DAY_OF_WEEK) ;
	     
	    switch(dayNum){
	        case 1:
	            day = "일";
	            break ;
	        case 2:
	            day = "월";
	            break ;
	        case 3:
	            day = "화";
	            break ;
	        case 4:
	            day = "수";
	            break ;
	        case 5:
	            day = "목";
	            break ;
	        case 6:
	            day = "금";
	            break ;
	        case 7:
	            day = "토";
	            break ;	         
	    }
	    return day ;
	}
}
