package dto;

import lombok.Data;

@Data
public class SignUpVO {
    private String name; // 이름
    private String id; // 아이디
    private String pw; // 패스워드
    private String email; // 이메일
    private String phone; // 전화번호

    public SignUpVO(String name, String id, String pw, String email, String phone) {
        this.name = name;
        this.id = id;
        this.pw = pw;
        this.email = email;
        this.phone = phone;
    }
}
