package com.baobab.m.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.baobab.m.service.FtpClient;
import com.baobab.m.vo.SetMenuInfoVO;
import com.baobab.m.vo.SetMenuVO;

@Repository
public class SetMenuUploadDAOimpl implements SetMenuUploadDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate setUpload;
	private String saveFolder = "/baobabSetMenus/";

	@Override
	public String setMenus(String menuName, String cpName, String menuPrice, String menuDisPrice, MultipartFile menuImg,
			String menuDetail, String menu, String option, String ea, int cpSeq) throws Exception {
		String duprt = dubConfirm(cpName, menuName, cpSeq);
		if(duprt == null) {
			SetMenuVO smvo = new SetMenuVO();
			smvo.setMenu_name(menuName);
			smvo.setCp_name(cpName);
			smvo.setMenu_price(menuPrice);
			smvo.setMenu_dis_price(menuDisPrice);
			smvo.setMenu_img(imgUpload(menuImg, cpName+"-"+menuName));
			smvo.setMenu_detail(menuDetail);
			smvo.setCp_seq(cpSeq);
			setUpload.update("com.baobab.m.dao.SetMenuUploadMapper.setMenuSave", smvo);
			setMenuInfo(cpName, menuName, menu, option, ea);
			System.out.println("세트메뉴 저장 완료");
			return "ok";
		}else {
			System.out.println("세트메뉴 중복");
			return "dup";
		}
	}

	public void setMenuInfo(String cpName, String setMenuName, String menu, String option, String ea) throws Exception{
		String[] menuArr = menu.split(", ");
		String[] optionArr = option.split(", ");
		String[] eaArr = ea.split(", ");
		for(int i=0;i<menuArr.length;i++) {
			SetMenuInfoVO smivo = new SetMenuInfoVO();
			smivo.setCp_name(cpName);
			smivo.setSet_menu_name(setMenuName);
			smivo.setMenu(menuArr[i]);
			smivo.setOption(optionArr[i]);
			smivo.setEa(eaArr[i]);
			
			System.out.println(menuArr[i]);
			System.out.println(optionArr[i]);
			System.out.println(eaArr[i]);
			
			setUpload.update("com.baobab.m.dao.SetMenuUploadMapper.setMenuInfoSave", smivo);
		}
	}
	
	public String imgUpload(MultipartFile menuImg, String menuName) throws FileNotFoundException, IOException{
		FtpClient ftp = new FtpClient();
		if(menuImg != null) {
			if(!menuImg.isEmpty()) {
				String saveName = menuName+".png";
				if(saveName.contains(" ")) {
					return ftp.ftp(ftp.convert(menuImg), saveName.replace(" ", "+"), saveFolder);
				}else {
					return ftp.ftp(ftp.convert(menuImg), saveName, saveFolder);
				}
			}
			return null;
		}else {
			return "이미지없음";
		}
	}

	public String dubConfirm(String cpName, String menuName, int cpSeq) {
		SetMenuVO smvo = new SetMenuVO();
		smvo.setCp_name(cpName);
		smvo.setMenu_name(menuName);
		smvo.setCp_seq(cpSeq);
		String result = setUpload.selectOne("com.baobab.m.dao.SetMenuUploadMapper.dubConfirm", smvo);
		return result;
	}

	@Override
	public List<SetMenuVO> showMetheSetMenu(int cpSeq) {
		return setUpload.selectList("com.baobab.m.dao.SetMenuUploadMapper.showMetheSetMenu", cpSeq);
	}

	@Override
	public void delSetMenu(String cpName, String menuName, int cpSeq) throws Exception {
		SetMenuVO smvo = new SetMenuVO();
		smvo.setCp_name(cpName);
		smvo.setCp_seq(cpSeq);
		smvo.setMenu_name(menuName);
		delSetMenuInfo(cpName, menuName, cpSeq);
		setUpload.update("com.baobab.m.dao.SetMenuUploadMapper.delSetMenu", smvo);
		FtpClient ftp = new FtpClient();
		if(ftp.deleteFile(saveFolder, cpName + "-" + menuName + ".png") != 1) {
			ftp.deleteFile(saveFolder, cpName + "-" + menuName + ".jpg");
		}
	}

	@Override
	public void delSetMenuInfo(String cpName, String menuName, int cpSeq) {
		SetMenuInfoVO vo = new SetMenuInfoVO();
		vo.setCp_name(cpName);
		vo.setSet_menu_name(menuName);
		vo.setCp_seq(cpSeq);
		setUpload.update("com.baobab.m.dao.SetMenuUploadMapper.delSetMenuInfo", vo);
	}

}
