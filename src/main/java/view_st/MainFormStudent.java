package view_st;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logic.MainFormStudentLogic;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

public class MainFormStudent extends JFrame implements ActionListener {

    MainFormStudentLogic mfsl = null;

    JLabel jlb_title = null;
    JLabel jlb_id = null;
    JLabel jlb_pw = null;
    JLabel jlb_id2 = null;
    JLabel jlb_pw2 = null;

    public JButton jbtn_logout = null;
    public JButton jbtn_grade = null;
    public JButton jbtn_leture = null;

    String id = null;
    String pw = null;
    Font f = null;

    public MainFormStudent() {

    }

    public void initDisplay() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        f = new Font("굴림체", Font.BOLD, 18);

        jlb_title = new JLabel("학생용 학사 관리 프로그램");
        jlb_title.setFont(f);

        jlb_id = new JLabel("학번 : ");
        jlb_pw = new JLabel("이름 : ");
        jlb_id2 = new JLabel(id);
        jlb_pw2 = new JLabel(pw);

        jbtn_logout = new JButton("로그아웃");
        jbtn_grade = new JButton("성적확인");
        jbtn_leture = new JButton("강의확인");

        this.add(jlb_title);
        this.add(jlb_id);
        this.add(jlb_pw);
        this.add(jlb_id2);
        this.add(jlb_pw2);
        this.add(jbtn_logout);
        this.add(jbtn_grade);
        this.add(jbtn_leture);

        mfsl = new MainFormStudentLogic(this);
        jbtn_logout.addActionListener(this);
        jbtn_grade.addActionListener(this);
        jbtn_leture.addActionListener(this);

        jlb_title.setBounds(100, 25, 250, 35);
        jlb_id.setBounds(45, 105, 200, 35);
        jlb_pw.setBounds(45, 135, 200, 35);
        jlb_id2.setBounds(90, 105, 200, 35);
        jlb_pw2.setBounds(90, 135, 200, 35);
        jbtn_logout.setBounds(245, 105, 130, 35);
        jbtn_grade.setBounds(45, 235, 130, 35);
        jbtn_leture.setBounds(245, 235, 130, 35);

        this.setTitle("학사관리 프로그램");
        this.setLocation(500, 100);
        this.setSize(450, 350);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        MainFormStudent mainFormStudent = new MainFormStudent();
        mainFormStudent.initDisplay();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object obj = new Object();
        if (obj == jbtn_logout) {
            // 로그아웃 로직
        } else if (obj == jbtn_grade) {
            // 성적확인 로직
        } else if (obj == jbtn_leture) {
            // 강의확인 로직
        }

    }
}
