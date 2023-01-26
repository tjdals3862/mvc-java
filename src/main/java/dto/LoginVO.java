package dto;

import lombok.Data;

@Data
public class LoginVO {

  private String select;
  private String id;
  private String password;

  public LoginVO(String select, String id, String password) {
    this.select = select;
    this.id = id;
    this.password = password;
  }
}
