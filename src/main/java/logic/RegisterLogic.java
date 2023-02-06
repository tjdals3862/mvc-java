package logic;

import javax.swing.JOptionPane;

import dao.SignUpDao;
import dto.SignUpVO;
import dto.SignUpproVO;
import view.RegisterForm;

public class RegisterLogic {
    
    RegisterForm rf = null;

    SignUpDao sdao = null;

    public RegisterLogic(RegisterForm rf) {
        this.rf = rf;
    }

    public int studentjoin(SignUpVO suvo) {
        sdao = new SignUpDao();
        int result = sdao.signUpStudent(suvo);
        System.out.println(result);
        return result;

    }

    public int professorjoin(SignUpproVO supvo) {
        sdao = new SignUpDao();
        int result =  sdao.signUpProfessor(supvo);
        System.out.println(result);
        return result;        
    }
}
