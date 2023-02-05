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



//   // 강의 추가
//   public int add(String lecture, String professor, String lectime) {
//     cd = new ClassDao();

//     // 가져온 데이터를 dto를 통해 생성후 파라미터로 전달
//     lvo = new LectureVO(lecture, professor, lectime);
//     int result = cd.getinsertlecture(lvo);

//     return result;
//   }
