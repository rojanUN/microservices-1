package com.memberService.memberService.service;

import com.memberService.memberService.dto.MemberDto;
import com.memberService.memberService.model.Member;
import com.memberService.memberService.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class memberService {
    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    MemberRepository memberRepository;
    public void addMember(MemberDto memberDto) {
        Member member = modelMapper.map(memberDto, Member.class);
        memberRepository.save(member);
    }

    public List<MemberDto> getMembers() {
        List<MemberDto> memberDTO = new ArrayList<>();
        memberRepository.findAll().forEach(member -> memberDTO.add(modelMapper.map(member, MemberDto.class)));
        return memberDTO;
    }
}
