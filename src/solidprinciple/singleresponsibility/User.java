package solidprinciple.singleresponsibility;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}

class UserValidator {
    public boolean isValid(User user) {
        // 유효성 검사
        return true;
    }
}

class UserDAO {
    public void save(User user) {
        // 데이터 저장
    }
}