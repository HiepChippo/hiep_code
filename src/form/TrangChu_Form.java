package form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import commons.RoundPanel;
import commons.Table;
import java.awt.BorderLayout;

public class TrangChu_Form extends JPanel {
	
	private JPanel panelNorth;
	private JPanel panelSouth;
    private  int width = 1250;
    private  int height = 777;
	private DefaultTableModel model;
    private Table tableThongKe;
	private JPanel panelBarChart;
	private JPanel panelLineChart;

	private JComponent panelCenter;
	public TrangChu_Form(int width, int height)
    { 
    	this.width = width;
    	this.height = height;
    	
        initComponents();
           

    }
    public void initComponents()
    {
     setPreferredSize(new Dimension(1250, 777));
  	 setBackground(Color.white);
	setLayout(new BorderLayout(0, 0));
	
	JLabel lblNewLabel = new JLabel("New label");
	lblNewLabel.setIcon(new ImageIcon(TrangChu_Form.class.getResource("/images/trangChu.jpg")));
	add(lblNewLabel);

    }
}
