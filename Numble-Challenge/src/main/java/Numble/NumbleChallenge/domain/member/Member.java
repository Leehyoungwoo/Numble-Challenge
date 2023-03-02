package Numble.NumbleChallenge.domain.member;

public class Member {

    private Long id;
    private String userId;
    private String password;
    private String nickName;
    private String userName;
    private Long phoneNumber;

    public Member() {
    }

    public Member(String userId, String password, String nickName, String userName, Long phoneNumber) {
        this.userId = userId;
        this.password = password;
        this.nickName = nickName;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPhoneNumber(Long phoneNumber) {
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
