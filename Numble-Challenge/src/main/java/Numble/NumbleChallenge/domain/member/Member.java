package Numble.NumbleChallenge.domain.member;

import lombok.Builder;

@Builder
public class Member {

    private Long id;
    private String userId;
    private String password;
    private String nickname;
    private String username;
    private Long phoneNumber;

    public Member() {
    }

    public Member(String userId, String password, String nickname, String username, Long phoneNumber) {
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
        this.username = username;
        this.phoneNumber = phoneNumber;
    }



    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }
}
