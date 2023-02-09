package com.pain.shop.config.auth;

import com.pain.shop.member.dto.MemberDto;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
public class CustomMemberDetails implements UserDetails {

    private MemberDto memberDto;
    private Collection<GrantedAuthority> authorities;

    /**
     * 회원 권한
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        authorities.add(() -> memberDto.getRoleKey());
        return authorities;
    }

    /**
     * 비밀번호
     */
    @Override
    public String getPassword() {
        return memberDto.getPassword();
    }

    /**
     * PK값
     */
    @Override
    public String getUsername() {
        return memberDto.getMemberId();
    }

    /**
     * 계정 만료 여부
     * true : 만료 안됨
     * false : 만료
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 계정 잠김 여부
     * true : 잠기지 않음
     * false : 잠김
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 비밀번호 만료 여부
     * true : 만료 안됨
     * false : 만료
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 사용자 활성화 여부
     * true : 활성화
     * false : 비활성화
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
