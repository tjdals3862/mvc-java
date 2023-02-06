package dto;

import lombok.Data;

@Data
public class SignUpproVO {
    
    private String pro_name;
    private String pr_id;
    private String pr_pw;

    public SignUpproVO(String pro_name, String pr_id, String pr_pw) {
        this.pro_name = pro_name;
        this.pr_id = pr_id;
        this.pr_pw = pr_pw;
    }
}
