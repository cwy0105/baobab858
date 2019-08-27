package com.baobab.m.vo;

import java.util.Date;

public class ReviewVO {
	private int review_num;
	private int score;
	private String text;
	private String CP_name;
	private String menu;
	private String email;
	private String nickName;
	private String profile;
	private Date post_date;
	private String re_text;
	private Date re_date;
	private String img1;
	private String img2;
	private String img3;
	private String img4;
	private String userPhoneNum;
	private String review_pwd;
	private int seq_num;
	private int revCount;
	private String div_code;
	private int cp_seq;
	public ReviewVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewVO(int review_num, int score, String text, String cP_name, String menu, String email, String nickName,
			String profile, Date post_date, String re_text, Date re_date, String img1, String img2, String img3,
			String img4, String userPhoneNum, String review_pwd, int seq_num, int revCount, String div_code,
			int cp_seq) {
		super();
		this.review_num = review_num;
		this.score = score;
		this.text = text;
		CP_name = cP_name;
		this.menu = menu;
		this.email = email;
		this.nickName = nickName;
		this.profile = profile;
		this.post_date = post_date;
		this.re_text = re_text;
		this.re_date = re_date;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
		this.userPhoneNum = userPhoneNum;
		this.review_pwd = review_pwd;
		this.seq_num = seq_num;
		this.revCount = revCount;
		this.div_code = div_code;
		this.cp_seq = cp_seq;
	}
	public int getReview_num() {
		return review_num;
	}
	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCP_name() {
		return CP_name;
	}
	public void setCP_name(String cP_name) {
		CP_name = cP_name;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	public String getRe_text() {
		return re_text;
	}
	public void setRe_text(String re_text) {
		this.re_text = re_text;
	}
	public Date getRe_date() {
		return re_date;
	}
	public void setRe_date(Date re_date) {
		this.re_date = re_date;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	public String getImg4() {
		return img4;
	}
	public void setImg4(String img4) {
		this.img4 = img4;
	}
	public String getUserPhoneNum() {
		return userPhoneNum;
	}
	public void setUserPhoneNum(String userPhoneNum) {
		this.userPhoneNum = userPhoneNum;
	}
	public String getReview_pwd() {
		return review_pwd;
	}
	public void setReview_pwd(String review_pwd) {
		this.review_pwd = review_pwd;
	}
	public int getSeq_num() {
		return seq_num;
	}
	public void setSeq_num(int seq_num) {
		this.seq_num = seq_num;
	}
	public int getRevCount() {
		return revCount;
	}
	public void setRevCount(int revCount) {
		this.revCount = revCount;
	}
	public String getDiv_code() {
		return div_code;
	}
	public void setDiv_code(String div_code) {
		this.div_code = div_code;
	}
	public int getCp_seq() {
		return cp_seq;
	}
	public void setCp_seq(int cp_seq) {
		this.cp_seq = cp_seq;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CP_name == null) ? 0 : CP_name.hashCode());
		result = prime * result + cp_seq;
		result = prime * result + ((div_code == null) ? 0 : div_code.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((img1 == null) ? 0 : img1.hashCode());
		result = prime * result + ((img2 == null) ? 0 : img2.hashCode());
		result = prime * result + ((img3 == null) ? 0 : img3.hashCode());
		result = prime * result + ((img4 == null) ? 0 : img4.hashCode());
		result = prime * result + ((menu == null) ? 0 : menu.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result + ((post_date == null) ? 0 : post_date.hashCode());
		result = prime * result + ((profile == null) ? 0 : profile.hashCode());
		result = prime * result + ((re_date == null) ? 0 : re_date.hashCode());
		result = prime * result + ((re_text == null) ? 0 : re_text.hashCode());
		result = prime * result + revCount;
		result = prime * result + review_num;
		result = prime * result + ((review_pwd == null) ? 0 : review_pwd.hashCode());
		result = prime * result + score;
		result = prime * result + seq_num;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((userPhoneNum == null) ? 0 : userPhoneNum.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReviewVO other = (ReviewVO) obj;
		if (CP_name == null) {
			if (other.CP_name != null)
				return false;
		} else if (!CP_name.equals(other.CP_name))
			return false;
		if (cp_seq != other.cp_seq)
			return false;
		if (div_code == null) {
			if (other.div_code != null)
				return false;
		} else if (!div_code.equals(other.div_code))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (img1 == null) {
			if (other.img1 != null)
				return false;
		} else if (!img1.equals(other.img1))
			return false;
		if (img2 == null) {
			if (other.img2 != null)
				return false;
		} else if (!img2.equals(other.img2))
			return false;
		if (img3 == null) {
			if (other.img3 != null)
				return false;
		} else if (!img3.equals(other.img3))
			return false;
		if (img4 == null) {
			if (other.img4 != null)
				return false;
		} else if (!img4.equals(other.img4))
			return false;
		if (menu == null) {
			if (other.menu != null)
				return false;
		} else if (!menu.equals(other.menu))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		if (post_date == null) {
			if (other.post_date != null)
				return false;
		} else if (!post_date.equals(other.post_date))
			return false;
		if (profile == null) {
			if (other.profile != null)
				return false;
		} else if (!profile.equals(other.profile))
			return false;
		if (re_date == null) {
			if (other.re_date != null)
				return false;
		} else if (!re_date.equals(other.re_date))
			return false;
		if (re_text == null) {
			if (other.re_text != null)
				return false;
		} else if (!re_text.equals(other.re_text))
			return false;
		if (revCount != other.revCount)
			return false;
		if (review_num != other.review_num)
			return false;
		if (review_pwd == null) {
			if (other.review_pwd != null)
				return false;
		} else if (!review_pwd.equals(other.review_pwd))
			return false;
		if (score != other.score)
			return false;
		if (seq_num != other.seq_num)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (userPhoneNum == null) {
			if (other.userPhoneNum != null)
				return false;
		} else if (!userPhoneNum.equals(other.userPhoneNum))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ReviewVO [review_num=" + review_num + ", score=" + score + ", text=" + text + ", CP_name=" + CP_name
				+ ", menu=" + menu + ", email=" + email + ", nickName=" + nickName + ", profile=" + profile
				+ ", post_date=" + post_date + ", re_text=" + re_text + ", re_date=" + re_date + ", img1=" + img1
				+ ", img2=" + img2 + ", img3=" + img3 + ", img4=" + img4 + ", userPhoneNum=" + userPhoneNum
				+ ", review_pwd=" + review_pwd + ", seq_num=" + seq_num + ", revCount=" + revCount + ", div_code="
				+ div_code + ", cp_seq=" + cp_seq + "]";
	}
	
}
