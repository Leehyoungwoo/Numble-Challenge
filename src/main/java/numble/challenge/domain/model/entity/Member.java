package numble.challenge.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import numble.challenge.domain.converter.PasswordConverter;
import numble.challenge.member.controller.dto.MemberSaveDto;
import numble.challenge.member.controller.dto.MemberUpdateDto;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "member")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @Size(min = 6, max = 12)
    @Column(unique = true)
    private String userId;

    @NotNull
    @NotEmpty
    @Size(min = 8)
    @Convert(converter = PasswordConverter.class)
    private String password;

    @NotNull
    private String name;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    private String nickname;

    @NotNull
    @Column(unique = true)
    private String phone;

    public void setId(Long id) {
        this.id = id;
    }

    @PrePersist
    public void validatePhone() {
        this.phone = this.phone.replace('-', '\0');

        if (this.phone.length() != 11) {
            throw new IllegalArgumentException("전화번호가 올바른 형식이 아닙니다.");
        }
    }

    public void update(MemberUpdateDto memberUpdateDto) {
        this.name = memberUpdateDto.getName();
        this.email = memberUpdateDto.getEmail();
        this.nickname = memberUpdateDto.getNickname();
        this.phone = memberUpdateDto.getPhone();
    }

    public static Member toEntity(MemberSaveDto memberSaveDto) {
        return Member.builder()
                .userId(memberSaveDto.getUserId())
                .password(memberSaveDto.getPassword())
                .name(memberSaveDto.getName())
                .email(memberSaveDto.getEmail())
                .nickname(memberSaveDto.getNickname())
                .phone(memberSaveDto.getPhone())
                .build();
    }
}
