package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import bus.TaiKhoan_BUS;
import commons.GradientPanel;
import commons.RoundPanel;
import connectDB.ConnectDB;
import entities.TaiKhoan;
import java.awt.BorderLayout;

public class Login_GUI extends JFrame implements ActionListener{

	private RoundPanel contentPane;
	private RoundPanel panel_1;
	private JButton btnDangNhap;
	private GradientPanel panel;
	private JTextField textTenDangNhap;
	private JPasswordField passwordField;
	private JButton btnQuenMatKhau;
	private JLabel lblThongBao;
	private TaiKhoan_BUS taiKhoan_BUS = new TaiKhoan_BUS();
	protected static Login_GUI frame;
    protected static QuenMatKhau_GUI QMK_gui;
    private JLabel lbXemMK;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		openLogin_GUI();
	}
	
	public static void openLogin_GUI() {
		frame = new Login_GUI();
		frame.setVisible(true);
	}
	
	/**
	 * Create the frame.
	 */
	public Login_GUI() {
		setFont(new Font("Dialog", Font.BOLD, 20));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 700);
		setLocationRelativeTo(null);
//		setUndecorated(true);
		setTitle("Phầm mềm quản lý lao động");
		setResizable(false);
		contentPane = new RoundPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));		
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new GradientPanel();
		panel.setBorder(null);
		panel.setLayout(null);
		panel.setBorder(new LineBorder(Color.WHITE));
		panel.setkStartColor(Color.decode("#FC466B"));
		panel.setkGradientFocus(50);
		panel.setkEndColor(Color.decode("#3F5EFB"));
		contentPane.add(panel);
		
		panel_1 = new RoundPanel();
		panel_1.setBackground(new Color(241, 241, 241));
		panel_1.setBorder(new EmptyBorder(5, 15, 10, 10));
		panel_1.setBounds(604, 100, 508, 363);
		panel_1.setOpaque(true);
		panel_1.setRound(20);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đăng nhập");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel.setBounds(191, 27, 156, 44);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên đăng nhập:");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(30, 137, 108, 21);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu:");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(30, 183, 94, 21);
		panel_1.add(lblNewLabel_1_1);
		
		textTenDangNhap = new JTextField();
		textTenDangNhap.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textTenDangNhap.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textTenDangNhap.setBounds(152, 128, 279, 30);
		
		panel_1.add(textTenDangNhap);
		textTenDangNhap.setColumns(10);
		
		btnDangNhap = new JButton();
		btnDangNhap.setText("Đăng nhập");
		btnDangNhap.setIcon(new ImageIcon(Login_GUI.class.getResource("/icon/icons8_enter_25px.png")));
		btnDangNhap.setOpaque(true);
		btnDangNhap.setBackground(new Color(23, 191, 86));
		btnDangNhap.setBorder(null);
		btnDangNhap.setForeground(Color.WHITE);
		btnDangNhap.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnDangNhap.setBounds(152, 245, 279, 36);
		btnDangNhap.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.add(btnDangNhap);
		
		btnQuenMatKhau = new JButton("Quên mật khẩu?");
		btnQuenMatKhau.setForeground(new Color(255, 255, 255));
		btnQuenMatKhau.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnQuenMatKhau.setBorder(null);
		btnQuenMatKhau.setBackground(new Color(255, 0, 0));
		btnQuenMatKhau.setBounds(316, 302, 115, 30);
		btnQuenMatKhau.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuenMatKhau.setOpaque(true);
		
		panel_1.add(btnQuenMatKhau);
		
		RoundPanel panel_2 = new RoundPanel();
		panel_2.setRound(20);
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(22, 23, 465, 314);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(132, 148, 279, 30);
		panel_2.add(passwordField);
		passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		passwordField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		
		lblThongBao = new JLabel("");
		lblThongBao.setBounds(132, 189, 279, 21);
		panel_2.add(lblThongBao);
		lblThongBao.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		lblThongBao.setForeground(new Color(0, 0, 0));
		
		lbXemMK = new JLabel("");
		lbXemMK.setIcon(new ImageIcon(Login_GUI.class.getResource("/icon/icons8_eye_25px.png")));
		lbXemMK.setBounds(420, 157, 45, 21);
		panel_2.add(lbXemMK);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login_GUI.class.getResource("/images/login.png")));
		lblNewLabel_2.setBounds(176, 149, 418, 312);
		panel.add(lblNewLabel_2);
		
		//
		try {
			ConnectDB.getInstance().connect();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Đăng ký sự kiện
		btnDangNhap.addActionListener(this);
		btnQuenMatKhau.addActionListener(this);
	}

	private boolean kiemTraDangNhap() {
		String tenTaiKhoan = textTenDangNhap.getText();
		@SuppressWarnings("deprecation")
		String matKhau = passwordField.getText();
		if(tenTaiKhoan.trim().length() == 0) {
			lblThongBao.setText("Vui lòng điền tên đăng nhập!");
			return false;
		}
		else if (matKhau.trim().length() == 0) {
			lblThongBao.setText("Vui lòng điền mật khẩu!");
			return false;
		}
		TaiKhoan tk = taiKhoan_BUS.getTaiKhoan(tenTaiKhoan);
		if(tk == null || matKhau.compareTo(tk.getMatKhau()) != 0) {
			lblThongBao.setText("Thông tin tài khoản hoặc mật khẩu không chính xác!");
			return false;
		}
		return true;
	}
	
	private void moTrangChu() {
		Main_GUI main_GUI = new Main_GUI();
		main_GUI.openMain_GUI();;
		frame.dispose();
	}
	private void open_QMK()
	{
		QMK_gui = new QuenMatKhau_GUI();
		QMK_gui.openQMK_GUI();
		frame.dispose();
	}
	private void moTrangQMK()
	{
		QuenMatKhau_GUI QMK_Gui = new QuenMatKhau_GUI();
		QMK_Gui.setVisible(true);
		frame.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnDangNhap)) {
			if(kiemTraDangNhap()) {
				moTrangChu();
			}
		
		}
		if(o.equals(btnQuenMatKhau))
		{
			moTrangQMK();
		}
	}
}
