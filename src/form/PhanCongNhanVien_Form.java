package form;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PhanCongNhanVien_Form extends JPanel{
	private int width = 1250;
	private int height = 777;
   public PhanCongNhanVien_Form(int width, int height)
   {
	  this.width = width;
	  this.height = height;
	  setPreferredSize(new Dimension(1250,777));
	  setBackground(Color.BLUE);
   }
}
