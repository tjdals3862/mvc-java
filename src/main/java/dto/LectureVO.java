package dto;

import lombok.Data;

@Data
public class LectureVO {
  private String lecture;
  private String professor;
  private String lectime;
  private int credit;


  public LectureVO() {

  }

  public LectureVO(String lecture, String professor, String lectime) {
    this.lecture = lecture;
    this.professor = professor;
    this.lectime = lectime;
  }

  public LectureVO(String lecture, String professor, String lectime, int credit) {
    this.lecture = lecture;
    this.professor = professor;
    this.lectime = lectime;
    this.credit = credit;
  }

}
