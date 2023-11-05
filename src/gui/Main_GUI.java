package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;

import commons.GradientPanel;
import commons.MenuEvent;
import commons.MyButton;
import commons.MyMenu;
import commons.PanelButton;
import entities.TaiKhoan;
import form.ChamCongNhanVien_Form;
import form.PhanCongNhanVien_Form;
import form.QuanLyCongTrinh_Form;
import form.QuanLyNhanVien_Form;
import form.TaiKhoan_Form;
import form.ThongKeNhanVienCongTrinh_Form;
//import form.TrangChu_Form;
import form.TrangChu_Form;

import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import java.awt.Component;
import java.awt.FlowLayout;

/**
 * 
 * 
 * @version 1.0
 *
 */

public class Main_GUI extends JFrame implements ActionListener{
	
	private final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private JPanel contentPane;
	private GradientPanel panelWest;
	private MyButton btnTaiKhoan;
	private JLabel lblTenNhanVien;
	private JPanel panelCenter;
	private JPanel panelCNort;
	private MyMenu menu;
	//Form
    private QuanLyNhanVien_Form quanLyNhanVien_Form = null;
    private QuanLyCongTrinh_Form quanLyCongTrinh_Form = null;
	private ChamCongNhanVien_Form chamCongNhanVien_Form = null;
	private ThongKeNhanVienCongTrinh_Form thongKeNhanVienCongTrinh_Form =null;
    private TrangChu_Form trangChu_Form = null;
    private PhanCongNhanVien_Form phanCongNhanVien_Form = null;
    private TaiKhoan_Form taiKhoan_Form = null;
	private JPanel panelContent;
	private MyButton btnAvt;
	private static Main_GUI mainFrame = new Main_GUI();
	private static Login_GUI loginFrame = new Login_GUI();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	
	public static void main(String[] args) {
		mainFrame.setVisible(true);
	}
	
	public void openMain_GUI() {
		mainFrame.setVisible(true);
//		resize();
	}
   
    public void closeMain_Gui()
    {
    	mainFrame.setVisible(false);
    }
	/**
	 * Create the frame.
	 */
	public Main_GUI() {
		int w = WIDTH;
		int h = HEIGHT;
		
		setTitle("Phần mềm quản lý lao động");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1800, 800);
		setExtendedState(Frame.MAXIMIZED_BOTH);
//		setSize(Toolkit.getDefaultToolkit().getScreenSize());
//		setUndecorated(true);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		panelWest = new GradientPanel();
		panelWest.setLayout(new BorderLayout());
		panelWest.setSize(new Dimension((int)(w*0.18), this.getHeight()));
		panelWest.setPreferredSize(new Dimension((int)(w*0.18), h));
		panelWest.setkStartColor(Color.decode("#003973"));
		panelWest.setkGradientFocus(500);
		panelWest.setkEndColor(Color.decode("#E5E5BE"));
		contentPane.add(panelWest, BorderLayout.WEST);
		
		// Khởi tạo menu
		initMenu();
		
		//Đăng ký sự kiện cho menu
		menu.setEvent(new MenuEvent() {
			@Override
			public void selected(int index, int subIndex) {
				moForm(index, subIndex);
			}
		});
		
		Image logo = new ImageIcon(Main_GUI.class.getResource("/icon/logo.png")).getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
		ImageIcon logoIcon = new ImageIcon(logo);
		JPanel panelLogo = new JPanel();
		panelLogo.setBackground(new Color(255, 255, 255));
		panelLogo.setSize(new Dimension((int) (w*0.14), (int) (w*0.14)));
		panelLogo.setPreferredSize(new Dimension((int) (w*0.18), (int) (w*0.1)));
		panelLogo.setOpaque(false);
		panelWest.add(panelLogo, BorderLayout.NORTH);
		panelLogo.setLayout(null);
		
		JLabel lblLogo = new JLabel();
		lblLogo.setBounds(0, 0, 176, 153);
		lblLogo.setIcon(logoIcon);
//		lblLogo.setHorizontalAlignment(h)
		panelLogo.add(lblLogo);
		
		lblNewLabel = new JLabel("HCT WORK");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setBounds(139, 32, 127, 84);
		panelLogo.add(lblNewLabel);
		
		panelCenter = new JPanel();
		panelCenter.setSize(new Dimension((int) (w*0.82), h));
		
		panelCenter.setLayout(new BorderLayout());
		contentPane.add(panelCenter, BorderLayout.CENTER);
		
		panelCNort = new JPanel();
		panelCNort.setBorder(null);
		panelCNort.setBackground(new Color(228, 228, 228));
		panelCNort.setSize(panelCenter.getWidth(), (int)(h*0.06));
		panelCNort.setPreferredSize(new Dimension(panelCenter.getWidth(), (int)(h*0.06)));
		panelCenter.add(panelCNort, BorderLayout.NORTH);
		panelCNort.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Võ Văn Nghĩa Hiệp");
		lblNewLabel_1.setIcon(new ImageIcon(Main_GUI.class.getResource("/icon/user.png")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(1027, 0, 237, 51);
		panelCNort.add(lblNewLabel_1);
		
		// avt nhân viên
//		btnAvt = new MyButton();
//		btnAvt.setPreferredSize(new Dimension(panelCNort.getHeight(), panelCNort.getHeight()));
//		Image avtImage = new ImageIcon(Main_GUI.class.getResource("/images/profile.png")).getImage().getScaledInstance(btnAvt.getWidth(), btnAvt.getHeight(), Image.SCALE_SMOOTH);
//		btnAvt.setIcon(logoIcon);
//		panelCNort.add(btnAvt, BorderLayout.EAST);
		
		// Panel chứa nội dung 
		panelContent = new JPanel();
		panelContent.setBorder(new EmptyBorder(0, 10, 0, 10));
		panelCenter.add(panelContent, BorderLayout.SOUTH);
	
		//Khởi tạo các form

		chamCongNhanVien_Form = new ChamCongNhanVien_Form(panelCenter.getWidth(), panelCenter.getHeight()-panelCNort.getHeight());
		thongKeNhanVienCongTrinh_Form = new ThongKeNhanVienCongTrinh_Form(panelCenter.getWidth(), panelCenter.getHeight()-panelCNort.getHeight());
		trangChu_Form = new TrangChu_Form(panelCenter.getWidth(), panelCenter.getHeight()-panelCNort.getHeight());	
		quanLyCongTrinh_Form = new QuanLyCongTrinh_Form(panelCenter.getWidth(), panelCenter.getHeight()-panelCNort.getHeight());
		quanLyNhanVien_Form = new QuanLyNhanVien_Form(panelCenter.getWidth(), panelCenter.getHeight()-panelCNort.getHeight());
		phanCongNhanVien_Form = new PhanCongNhanVien_Form(panelCenter.getWidth(), panelCenter.getHeight()-panelCNort.getHeight());
		taiKhoan_Form = new TaiKhoan_Form(panelCenter.getWidth(), panelCenter.getHeight()-panelCNort.getHeight());
		panelContent.add(trangChu_Form);
	}

	
	/**
	 * Mở login ui
	 */
	private void openLogin_GUI() {
		Login_GUI.openLogin_GUI();
	}
	
	private void initMenu() {
		String[][] menuAdmin = new String[][]{
			{"Trang chủ"},
			{"Danh mục", "Nhân viên", "Công trình"},
			{"Xử lý", "Chấm công nhân viên", "Phân công công trình"},
			{"Thống kê"},
			{"Tài khoản"},
			{""},
			{""},
			{""},
			{"Đăng xuất"}
		};
		menu = new MyMenu(menuAdmin);
		panelWest.add(menu);
		
	}
	
	/**
	 * Mở form
	 * @param index
	 * @param subIndex
	 */
	private void moForm(int index, int subIndex) {
		if(index == 0 && subIndex == 0) { 
			setForm(trangChu_Form);
		}
		else if (index == 1) {
			if (subIndex == 1) {
				setForm(quanLyNhanVien_Form);
			}
			else if(subIndex == 2){
				setForm(quanLyCongTrinh_Form);
		    }
			else if(subIndex == 4)
			{
				
			}
			else if(subIndex == 5)
			{
			
			}
				
		}
		else if(index == 2) {
			if (subIndex == 1) {
				setForm(chamCongNhanVien_Form);
			}
			else if(subIndex == 2){
				setForm(phanCongNhanVien_Form);
				
			}else if(subIndex == 3){
				
			}
			
		}
		else if(index == 3 && subIndex == 0) {
			setForm(thongKeNhanVienCongTrinh_Form);
		}
		else if(index == 4 && subIndex == 0)
		{
			setForm(taiKhoan_Form);
		}
		else if(index == 8 && subIndex == 0)
		{
			openLogin_GUI();
			closeMain_Gui();
		}
	}
	
	/**
	 * 
	 */
	private void setForm(JComponent component) {
		panelContent.removeAll();
		panelContent.add(component);
		panelContent.repaint();
		panelContent.revalidate();
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}