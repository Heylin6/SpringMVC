package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.MemberDao;
import com.example.demo.Model.Member;


@Service
public class memberService extends baseService{	
	
	@Autowired
	MemberDao memberDao;
	
	public void addMember(Member member){
		memberDao.addMember(member);
	}

}
