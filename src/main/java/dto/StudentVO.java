package dto;

import lombok.Data;

@Data
public class StudentVO {
    private int studentid; // 학번
    private String studentname; // 이름
    private String st_id; // 아이디
    private String st_pw; // 패스워드
    private String email; // 이메일
    private String phone; // 전화번호
}
