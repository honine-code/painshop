package com.pain.shop.member.domain;

import com.pain.shop.member.dto.MemberDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "member2")
public class Member {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String memberId;

    @Column(length = 100, nullable = false)
    private String password;

    private String nickName;

    private String address;

    @Column(length = 20, nullable = false)
    private String email;

    @Builder
    public Member(String memberId, String password, String nickName, String email, String address) {
        this.memberId = memberId;
        this.password = password;
        this.nickName = nickName;
        this.email = email;
        this.address = address;
    }
}
