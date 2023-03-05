package numble.challenge.member.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import numble.challenge.domain.converter.PasswordConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class MemberSaveDto {
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
    private String email;

    @NotNull
    private String nickname;

    @NotNull
    private String phone;

}
