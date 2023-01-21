package dto;

import lombok.Data;

@Data
public class LectureVO {
  private String lecture;
  private String professor;
  private String lectime;

  public LectureVO() {

  }

  public LectureVO(String lecture, String professor, String lectime) {
    this.lecture = lecture;
    this.professor = professor;
    this.lectime = lectime;
  }
}
