package solidprinciple.singleresponsibility;

public class NonSrpUser {
    private String username;
    private String password;

    public NonSrpUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValid() {
        // 유효성 검사
        return true;
    }

    public void save() {
        // 데이터 저장
    }
}
