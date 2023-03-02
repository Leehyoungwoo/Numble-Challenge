package Numble.NumbleChallenge.domain.member;

public class Member {

    private Long id;
    private String userId;
    private String passWord;
    private String nickName;
    private String userName;
    private Long phoneNumber;

    public Member() {
    }

    public Member(String userId, String passWord, String nickName, String userName, Long phoneNumber) {
        this.userId = userId;
        this.passWord = passWord;
        this.nickName = nickName;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
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

    public String getUserId() {
        return userId;
    }

    public String getPassWord() {
        return passWord;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }
}
