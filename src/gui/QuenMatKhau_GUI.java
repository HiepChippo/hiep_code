package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class QuenMatKhau_GUI extends JFrame implements ActionListener{
	private JTextField txtEmail;
	private JTextField txtMatKhau;
	private JTextField txtConFirm;
	private JButton btnHoanTat;
	private static Login_GUI login_Gui = new Login_GUI();
	private static QuenMatKhau_GUI QMK_frame = new QuenMatKhau_GUI();
       public QuenMatKhau_GUI()
       {
       	getContentPane().setBackground(new Color(255, 255, 255));
    	   setSize(500,400);
    	   setLocationRelativeTo(null);
    	   setDefaultCloseOperation(EXIT_ON_CLOSE);
    	   getContentPane().setLayout(null);
    	   
    	   JLabel lblNewLabel = new JLabel("LẤY LẠI MẬT KHẨU\r\n\r\n");
    	   lblNewLabel.setForeground(new Color(255, 0, 0));
    	   lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 21));
    	   lblNewLabel.setBounds(153, 0, 200, 52);
    	   getContentPane().add(lblNewLabel);
    	   
    	   JLabel lbEmail = new JLabel("Email:\r\n");
    	   lbEmail.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    	   lbEmail.setBounds(24, 70, 90, 25);
    	   getContentPane().add(lbEmail);
    	   
    	   txtEmail = new JTextField();
    	   txtEmail.setBounds(169, 67, 266, 28);
    	   getContentPane().add(txtEmail);
    	   txtEmail.setColumns(10);
    	   
    	   JLabel lbMatKhau = new JLabel("Mật khẩu mới:\r\n");
    	   lbMatKhau.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    	   lbMatKhau.setBounds(22, 132, 110, 25);
    	   getContentPane().add(lbMatKhau);
    	   
    	   JLabel lbConfirm = new JLabel("Nhập lại mật khẩu:\r\n");
    	   lbConfirm.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    	   lbConfirm.setBounds(22, 193, 145, 33);
    	   getContentPane().add(lbConfirm);
    	   
    	   txtMatKhau = new JTextField();
    	   txtMatKhau.setColumns(10);
    	   txtMatKhau.setBounds(169, 132, 266, 28);
    	   getContentPane().add(txtMatKhau);
    	   
    	   txtConFirm = new JTextField();
    	   txtConFirm.setColumns(10);
    	   txtConFirm.setBounds(168, 199, 266, 28);
    	   getContentPane().add(txtConFirm);
    	   
    	    btnHoanTat = new JButton("Hoàn tất");
    	   btnHoanTat.setBackground(new Color(0, 255, 0));
    	   btnHoanTat.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    	   btnHoanTat.setBounds(339, 274, 96, 33);
    	   getContentPane().add(btnHoanTat);
    	   btnHoanTat.addActionListener(this);
       }
       public static void main(String[] args) {
		new QuenMatKhau_GUI().setVisible(true);
	}

   	public void openQMK_GUI() {
   		QMK_frame.setVisible(true);
//   		resize();
   	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnHoanTat))
		{
			login_Gui.openLogin_GUI();
			QMK_frame.dispose();
		}
	}
}
