package Numble.NumbleChallenge.domain.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Member {

    private Long id;
    private String userId;
    private String password;
    private String nickname;
    private String username;
    private Long phoneNumber;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
