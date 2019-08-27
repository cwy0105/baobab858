package com.baobab.m.dao;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.DecoderException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.CallHistoryVO;
import com.baobab.m.vo.LocalCPInfoVO;
import com.baobab.m.vo.LocationLogVO;
import com.baobab.m.vo.PokeVO;
import com.baobab.m.vo.ReviewVO;
import com.baobab.m.vo.UserLocationVO;

@Repository
public class UserLocationDAOimpl implements UserLocationDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate loc;

	@Override
	public void firstLocation(UserLocationVO vo) {
		loc.update("com.baobab.m.dao.UserLocationMapper.firstLocation", vo);
	}

	@Override
	public UserLocationVO selectLocation(UserLocationVO vo) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException,
	IllegalBlockSizeException, UnsupportedEncodingException, DecoderException {
		vo.setUser(remakeNum(vo.getUser()));
		UserLocationVO result = loc.selectOne("com.baobab.m.dao.UserLocationMapper.selectLocation", vo);
		/*AESUtil aes = new AESUtil();
		if(result != null) {
			result.setAddr(aes.decrypt(result.getAddr()));
			result.setLatitude(aes.decrypt(result.getLatitude()));
			result.setLongitude(aes.decrypt(result.getLongitude()));
		}*/
		return result;
	}

	@Override
	public void updateLocation(UserLocationVO vo) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, 
	IllegalBlockSizeException, UnsupportedEncodingException, DecoderException {
		String phone = vo.getUser();
		vo.setUser(remakeNum(phone));
		if(selectLocation(vo) == null) {
			firstLocation(vo);
		}else {
			loc.update("com.baobab.m.dao.UserLocationMapper.updateLocation", vo);
		}
	}

	@Override
	public CPInfoVO pokeSelect(String cpName, String addr) {
		PokeVO vo = new PokeVO();
		vo.setCp_address(addr);
		vo.setCp_name(cpName);
		return loc.selectOne("com.baobab.m.dao.UserLocationMapper.pokeSelect", vo);
	}

	@Override
	public CPInfoVO reviewSelect(int cpSeq) {
		ReviewVO vo = new ReviewVO();
		vo.setCp_seq(cpSeq);
		return loc.selectOne("com.baobab.m.dao.UserLocationMapper.reviewSelect", vo);
	}

	@Override
	public LocalCPInfoVO callNonSelect(String cpName, String addr, String cpPhone) {
		CallHistoryVO vo = new CallHistoryVO();
		vo.setCp_address(addr);
		vo.setCp_name(cpName);
		vo.setCp_phone(cpPhone);
		return loc.selectOne("com.baobab.m.dao.UserLocationMapper.callNonSelect", vo);
	}

	@Override
	public LocalCPInfoVO reviewNonSelect(int cpSeq) {
		ReviewVO vo = new ReviewVO();
		vo.setCp_seq(cpSeq);
		return loc.selectOne("com.baobab.m.dao.UserLocationMapper.reviewNonSelect", vo);
	}
	
	public String remakeNum(String userPhone) {
		if(!userPhone.equals("")) {
			return "010" + userPhone.substring(userPhone.length()-8, userPhone.length());
		}else {
			return userPhone;
		}
	}

	@Override
	public int locationLog(HttpServletRequest request) {
		LocationLogVO vo = new LocationLogVO();
		vo.setUser(request.getParameter("user"));
		vo.setRoot(request.getParameter("root"));
		vo.setService(request.getParameter("service"));
		vo.setThird_person(request.getParameter("thirdPerson"));
		return loc.insert("com.baobab.m.dao.UserLocationMapper.locationLog", vo);
	}

}
