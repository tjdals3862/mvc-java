package dto;

import lombok.Data;

@Data
public class GradeCheckVO {

  private String lecture;
  private String studentname;

  public GradeCheckVO(String lecture, String studentname) {
    this.lecture = lecture;
    this.studentname = studentname;
  }
}
