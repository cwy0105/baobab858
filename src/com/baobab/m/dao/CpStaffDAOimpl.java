package com.baobab.m.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.service.SendNoticeFCM;
import com.baobab.m.vo.CouponHistoryVO;
import com.baobab.m.vo.CouponUserVO;
import com.baobab.m.vo.CpStaffVO;
import com.baobab.m.vo.SearchVO;
import com.baobab.m.vo.UserAllVO;
import com.baobab.m.vo.UserHistoryVO;
import com.baobab.m.vo.UserLocationVO;

@Repository
public class CpStaffDAOimpl implements CpStaffDAO {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate staff;

	@Override
	public List<UserAllVO> staffSearch(HttpServletRequest request) {
		SearchVO vo = new SearchVO();
		vo.setCount(Integer.parseInt(request.getParameter("cpSeq")));
		vo.setWord("%" + request.getParameter("searchWord") + "%");
		return staff.selectList("com.baobab.m.dao.CpStaffMapper.staffSearch", vo);
	}

	@Override
	public List<CpStaffVO> getStaffs(HttpServletRequest request) {

		return staff.selectList("com.baobab.m.dao.CpStaffMapper.getStaffs",
				Integer.parseInt(request.getParameter("cpSeq")));
	}

	@Override
	public int updateStaff(HttpServletRequest request) {
		CpStaffVO vo = new CpStaffVO();
		vo.setSeqNum(Integer.parseInt(request.getParameter("seqNum")));
		vo.setStaffName(request.getParameter("staffName"));
		vo.setStaffGender(request.getParameter("staffGender"));
		vo.setDivCode(request.getParameter("divCode"));
		vo.setEmail(request.getParameter("email"));
		return staff.update("com.baobab.m.dao.CpStaffMapper.updateStaff", vo) + staffHistoryJoin(request);

	}

	@Override
	public int staffInfoInsert(HttpServletRequest request) {
		CpStaffVO vo = new CpStaffVO();
		vo.setEmail(request.getParameter("email"));
		vo.setStaffPhone(request.getParameter("staffPhone"));
		vo.setStaffName(request.getParameter("staffName"));
		vo.setStaffGender(request.getParameter("staffGender"));
		vo.setCpSeq(Integer.parseInt(request.getParameter("cpSeq")));
		vo.setDivCode(request.getParameter("divCode"));

		return staff.insert("com.baobab.m.dao.CpStaffMapper.staffInfoInsert", vo) + staffHistoryJoin(request)
				+ userChangeToStaff(request.getParameter("email"), request.getParameter("divCode"));
	}

	// Deg
	@Override
	public int staffHistoryJoin(HttpServletRequest request) {
		UserHistoryVO vo = new UserHistoryVO();
		vo.setEmail(request.getParameter("email"));
		vo.setDiv_code(request.getParameter("divCode"));
		return staff.insert("com.baobab.m.dao.CpStaffMapper.staffHistoryJoin", vo);
	}

	@Override
	public int userChangeToStaff(String email, String divCode) {
		UserAllVO vo = new UserAllVO();
		vo.setEmail(email);
		vo.setDiv_code(divCode);
		
		return staff.update("com.baobab.m.dao.CpStaffMapper.userChangeToStaff", vo);
	}

	@Override
	public int scanCoupon(HttpServletRequest request) {
		String serialNum = request.getParameter("serialNum");
		String userEmail = request.getParameter("userEmail");
		String staffEmail = request.getParameter("staffEmail");

		CouponHistoryVO hisVO = new CouponHistoryVO();
		hisVO.setSerial_num(serialNum);
		hisVO.setDl_user_email(userEmail);

		CpStaffVO sVO = new CpStaffVO();

		List<CouponUserVO> hisList = staff.selectList("com.baobab.m.dao.CpStaffMapper.scanCouponHistory", hisVO);
		List<CpStaffVO> scanCoupon = new ArrayList<CpStaffVO>();

		try {
			sVO.setEmail(staffEmail);
			sVO.setCpSeq(hisList.get(0).getCp_seq());
			scanCoupon = staff.selectList("com.baobab.m.dao.CpStaffMapper.scanCoupon", sVO);

			if (hisList.isEmpty()) {
				return 2;
			} else if (scanCoupon.isEmpty()) {
				return 1;
			} else {
				couHistoryStatusChange(request);
				cpCouponScan(request);
				userCouponScan(request);
//				UserLocationVO vo = new UserLocationVO();
//				vo.setPush_token(request.getParameter("push"));
				SendNoticeFCM fcm = new SendNoticeFCM();
				String title = "[쿠폰] 쿠폰사용 완료";
				String content = hisList.get(0).getCou_title() + " 사용을 완료했습니다";
				List<UserLocationVO> list = staff.selectList("com.baobab.m.dao.CpStaffMapper.userLocationEmail",
						userEmail);
				String cpTitle = "[쿠폰스캔] 쿠폰스캔 완료";
				String cpContent = hisList.get(0).getCou_title() + " 사용을 완료했습니다";
				fcm.send(cpTitle, cpContent, scanCouponPush(hisList.get(0).getCp_seq()))
				
				;
				System.out.println("=========푸시 결과값============ : " + fcm.send(title, content, list));
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 3;
		}

//		couHistoryStatusChange();
//		cpCouponScan(request);
	}

	@Override
	public void couHistoryStatusChange(HttpServletRequest request) {
		String serialNum = request.getParameter("serialNum");
		staff.update("com.baobab.m.dao.CpStaffMapper.couHistoryStatusChange", serialNum);
	}

	@Override
	public void cpCouponScan(HttpServletRequest request) {
		String serialNum = request.getParameter("serialNum");
		staff.update("com.baobab.m.dao.CpStaffMapper.cpCouponScan", serialNum);
	}

	@Override
	public void userCouponScan(HttpServletRequest request) {
		String serialNum = request.getParameter("serialNum");
		staff.delete("com.baobab.m.dao.CpStaffMapper.userCouponScan", serialNum);
	}

	@Override
	public List<CouponHistoryVO> scanCouponHistory(HttpServletRequest request) {
		CouponHistoryVO hisVO = new CouponHistoryVO();

		return staff.selectList("com.baobab.m.dao.CpStaffMapper.scanCouponHistory", hisVO);
	}

	@Override
	public int staffCancel(HttpServletRequest request) {
		String email = request.getParameter("email");
		CpStaffVO vo = new CpStaffVO();
		vo.setCpSeq(Integer.parseInt(request.getParameter("cpSeq")));
		vo.setEmail(request.getParameter("email"));
		return staffCancelHistory(request)
				+ staff.delete("com.baobab.m.dao.CpStaffMapper.staffCancel", vo)
				+ staff.update("com.baobab.m.dao.CpStaffMapper.staffCancelUser", email);
	}

	@Override
	public int staffCancelHistory(HttpServletRequest request) {
		UserAllVO hvo = new UserAllVO();
		hvo.setEmail(request.getParameter("email"));
		hvo.setDiv_code(request.getParameter("divCode"));
		return staff.insert("com.baobab.m.dao.CpStaffMapper.staffCancelHistory", hvo);
	}
	
	@Override
	public List<CouponHistoryVO> usedCoupon(HttpServletRequest request) {		
		
		return staff.selectList("com.baobab.m.dao.CpStaffMapper.usedCoupon", request.getParameter("email"));
	}

	@Override
	public List<UserLocationVO> scanCouponPush(int cpSeq) {
		return staff.selectList("com.baobab.m.dao.CpStaffMapper.scanCouponPush", cpSeq);
	}
}
