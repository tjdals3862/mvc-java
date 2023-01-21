package dto;

import lombok.Data;

@Data
public class GradeProVO {
  private String lecture;
  private String professor;
  private String studentName;
  private String lectime;
  private int credit;
}
