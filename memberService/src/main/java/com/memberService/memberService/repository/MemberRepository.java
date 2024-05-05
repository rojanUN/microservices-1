package com.memberService.memberService.repository;

import com.memberService.memberService.model.Member;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Id> {
}
