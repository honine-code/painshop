package com.pain.shop.member.repository;

import com.pain.shop.member.domain.Member;
import com.pain.shop.member.dto.MemberDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<MemberDto> findByMemberId(String memberId);

    /**
     * 회원 중복 조회
     */
    boolean existsByMemberId(String memberId);

    /**
     * 회원 아이디, 패스워드 조회
     */
    @Query(value = "select * from member2 where member_id = :memberId and password = :password", nativeQuery = true)
    MemberDto findMember(@Param("memberId") String memberId, @Param("password")String password);

    @Query(value = "select password from member2 where member_id = :memberId", nativeQuery = true)
    String findByAll(@Param("memberId") String memberId);
}
