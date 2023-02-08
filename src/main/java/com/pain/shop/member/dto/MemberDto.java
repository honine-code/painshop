package com.pain.shop.member.dto;

import com.pain.shop.member.domain.Member;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDto {

    private Long id;
    private String memberId;
    private String password;
    private String nickName;
    private String email;
    private String address;
    private Role role;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Member toEntity(){
        return Member.builder()
                .memberId(memberId)
                .password(password)
                .nickName(nickName)
                .email(email)
                .address(address)
                .role(Role.USER)
                .createDate(LocalDateTime.now())
                .build();
    }

    @Builder
    public MemberDto(String memberId, String password, String nickName, String email, String address) {
        this.memberId = memberId;
        this.password = password;
        this.nickName = nickName;
        this.email = email;
        this.address = address;
    }
}
