package com.Recordum.start.service;

import com.Recordum.start.domain.Member;
import com.Recordum.start.repository.MemberRepository;
import com.Recordum.start.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member){

        validateDuplicateMember(member);//중복회원검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(memeber -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }

    /**
     *
     * 회원조회
     */
    public List<Member> findAllMember(){

        return memberRepository.findAll();

    }
    public Optional<Member> findOne(Long memberId){

        return memberRepository.findById(memberId);
    }
}

