import java.awt.BorderLayout;
import java.awt.CheckboxGroup;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class GiaoDien extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;
	private JTextField textField_7;
	private JTextField textField_8;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;

	private ButtonGroup btng;
	ArrayList<NhaHang> ds = new ArrayList<NhaHang>();
	NhaHang nh = null;
	DefaultTableModel dfModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien frame = new GiaoDien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GiaoDien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("QU\u1EA2N L\u00DD M\u00D3N \u0102N");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel.setBounds(109, 11, 530, 60);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("M\u00E3 m\u00F3n");
		lblNewLabel_1.setBounds(24, 87, 48, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblTnMn = new JLabel("T\u00EAn m\u00F3n");
		lblTnMn.setBounds(24, 120, 48, 14);
		contentPane.add(lblTnMn);

		textField = new JTextField();
		textField.setBounds(119, 84, 181, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblLaMn = new JLabel("Lo\u1EA1i m\u00F3n");
		lblLaMn.setBounds(24, 157, 48, 14);
		contentPane.add(lblLaMn);

		JLabel lblSLng = new JLabel("S\u1ED1 l\u01B0\u1EE3ng ");
		lblSLng.setBounds(24, 193, 48, 14);
		contentPane.add(lblSLng);

		JLabel lblnGi = new JLabel("\u0110\u01A1n gi\u00E1");
		lblnGi.setBounds(24, 233, 48, 14);
		contentPane.add(lblnGi);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(119, 117, 181, 20);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(119, 154, 181, 20);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(119, 190, 181, 20);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(119, 230, 181, 20);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setBounds(431, 117, 96, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(639, 117, 96, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u0110\u1ED9 cay");
		lblNewLabel_2.setBounds(367, 120, 58, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Th\u1EDDi gian");
		lblNewLabel_3.setBounds(556, 120, 73, 14);
		contentPane.add(lblNewLabel_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(343, 157, 430, 255);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "M\u00E3 m\u00F3n", "T\u00EAn m\u00F3n",
				"Ch\u00E2u l\u1EE5c", "S\u1ED1 l\u01B0\u1EE3ng", "T\u00EDnh ti\u1EC1n" }));
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("Th\u00EAm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mamon = textField.getText();
				String tenmon = textField_1.getText();
				String loaimon = null;
				float soluong = Float.parseFloat(textField_3.getText());
				float dongia = Float.parseFloat(textField_4.getText());

				if (rdbtnNewRadioButton.isSelected()) {
					loaimon = rdbtnNewRadioButton.getText();
					int docay = Integer.parseInt(textField_5.getText());
					nh = new MonAnChayA(mamon, tenmon, loaimon, soluong, dongia, docay);
				} else if (rdbtnNewRadioButton_1.isSelected()) {
					loaimon = rdbtnNewRadioButton_1.getText();
					float thoigian = Float.parseFloat(textField_6.getText());
					nh = new MonAnChauAu(mamon, tenmon, loaimon, soluong, dongia, thoigian);
				}
				ds.add(nh);

				dfModel = (DefaultTableModel) table.getModel();
				dfModel.setRowCount(0);
				for (NhaHang nhahang : ds) {
					Object[] rows = new Object[] { nhahang.getMamon(), nhahang.getTenmon(), nhahang.getLoaimon(),
							nhahang.getSoluong(), nhahang.Tinhtien() };
					dfModel.addRow(rows);
				}

			}
		});
		btnNewButton.setBounds(41, 294, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnThot = new JButton("Tho\u00E1t");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnThot.setBounds(188, 294, 89, 23);
		contentPane.add(btnThot);

		JButton btnTnhTin = new JButton("T\u00EDnh ti\u1EC1n");
		btnTnhTin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float tongtien = 0;
				int tongmon = 0;
				for (NhaHang nhahang : ds) {
					tongtien += nhahang.Tinhtien();
					tongmon += nhahang.getSoluong();
					if (tongmon >= 30) {
						tongtien = tongtien * 0.9f;
					}
				}
				textField_7.setText(tongtien + "");
				textField_8.setText(tongmon + "");
			}
		});
		btnTnhTin.setBounds(108, 345, 89, 23);
		contentPane.add(btnTnhTin);

		JLabel lblNewLabel_4 = new JLabel("T\u1ED5ng ti\u1EC1n");
		lblNewLabel_4.setBounds(353, 423, 97, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblCnLi = new JLabel("C\u00F2n l\u1EA1i");
		lblCnLi.setBounds(353, 466, 83, 14);
		contentPane.add(lblCnLi);

		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setEnabled(false);
		textField_7.setBounds(470, 420, 249, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setEnabled(false);
		textField_8.setBounds(470, 463, 249, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);

		rdbtnNewRadioButton = new JRadioButton("Ch\u00E2u \u00C1");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton.isSelected()) {
					textField_5.setEditable(true);
					textField_6.setEditable(false);
					textField_6.setText(null);
				}
			}
		});
		rdbtnNewRadioButton.setBounds(401, 78, 109, 23);
		contentPane.add(rdbtnNewRadioButton);

		rdbtnNewRadioButton_1 = new JRadioButton("Ch\u00E2u \u00C2u");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton_1.isSelected()) {
					textField_6.setEditable(true);
					textField_5.setEditable(false);
					textField_5.setText(null);
				}
			}
		});
		rdbtnNewRadioButton_1.setBounds(597, 78, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);

		btng = new ButtonGroup();
		btng.add(rdbtnNewRadioButton);
		btng.add(rdbtnNewRadioButton_1);

	}
}
