package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.MemberDao;
import com.example.demo.Dao.MemberRepository;
import com.example.demo.Model.Member;


@Service
public class memberService extends baseService {	
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	MemberDao memberDao;
	
	public void addMember(Member member){
		memberDao.addMember(member);
	}
	
	public memberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Optional<Member> findById(long mid) {
        return memberRepository.findById(mid);
    }

    public void save(Member member){
    	memberRepository.save(member);
    }


}
