package dto;

import lombok.Data;

@Data
public class GradeVO {
  private String lecture;
  private String studentName;
  private int credit;

  public GradeVO(String lecture, String studentName, int credit) {
    this.lecture = lecture;
    this.studentName = studentName;
    this.credit = credit;
  }
}
