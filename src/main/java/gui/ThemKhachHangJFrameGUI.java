package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.DiaChiDao;
import dao.KhachHangDao;
import dao.Ipml.DiaChiImpl;
import dao.Ipml.KhachHangImpl;
import entity.DiaChi;
import entity.KhachHang;

public class ThemKhachHangJFrameGUI extends JDialog implements ActionListener, ItemListener, MouseListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8522197300050082603L;
	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtSDT;
	private JComboBox<String> cbTinh;
	private JComboBox<String> cbHuyen;
	private JComboBox<String> cbXa;
	private JButton btnHuy;
	private JButton btnLamMoi;
	private JButton btnThem;
	private JComboBox<String> cbGioiTinh;
	private JLabel lblMaKH;
	private DiaChiDao diaChiDao = new DiaChiImpl();
	private List<String> listTinhTP = new ArrayList<String>();
	private KhachHangDao khachHangDao = new KhachHangImpl();
	public static KhachHang khachHang;

	
	public ThemKhachHangJFrameGUI(String sdt) {
		setModal(true);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 917, 499);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 908, 65);
		panel.setBackground(new Color(49, 74, 87));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblThmKhchHng = new JLabel("TH\u00CAM KH\u00C1CH H\u00C0NG");
		lblThmKhchHng.setHorizontalAlignment(SwingConstants.CENTER);
		lblThmKhchHng.setBounds(0, 0, 898, 65);
		panel.add(lblThmKhchHng);
		lblThmKhchHng.setForeground(Color.WHITE);
		lblThmKhchHng.setFont(new Font("Arial", Font.BOLD, 20));
		
		JLabel lblNhpSt_1_1 = new JLabel("M\u00E3 kh\u00E1ch h\u00E0ng  :");
		lblNhpSt_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1.setBounds(24, 135, 141, 35);
		contentPane.add(lblNhpSt_1_1);
		
		JLabel lblNhpSt_1_1_1 = new JLabel("T\u00EAn kh\u00E1ch h\u00E0ng:");
		lblNhpSt_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_1.setBounds(24, 202, 141, 35);
		contentPane.add(lblNhpSt_1_1_1);
		
		JLabel lblNhpSt_1_1_2 = new JLabel("S??? ??i???n tho???i     :");
		lblNhpSt_1_1_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_2.setBounds(24, 266, 141, 35);
		contentPane.add(lblNhpSt_1_1_2);
		
		JLabel lblNhpSt_1_1_3 = new JLabel("?????a ch???                 :");
		lblNhpSt_1_1_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_3.setBounds(24, 337, 141, 35);
		contentPane.add(lblNhpSt_1_1_3);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTen.setColumns(10);
		txtTen.setBounds(175, 202, 704, 35);
		contentPane.add(txtTen);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSDT.setColumns(10);
		txtSDT.setBounds(175, 268, 704, 35);
		contentPane.add(txtSDT);
		
		cbGioiTinh = new JComboBox<String>();
		cbGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbGioiTinh.setBackground(Color.WHITE);
		cbGioiTinh.setBounds(729, 137, 150, 35);
		contentPane.add(cbGioiTinh);
		cbGioiTinh.addItem("Nam");
		cbGioiTinh.addItem("N???");
		
		cbTinh = new JComboBox<String>();
		cbTinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbTinh.setBackground(Color.WHITE);
		cbTinh.setBounds(175, 339, 205, 35);
		contentPane.add(cbTinh);
		
		cbXa = new JComboBox<String>();
		cbXa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbXa.setBackground(Color.WHITE);
		cbXa.setBounds(674, 341, 205, 35);
		contentPane.add(cbXa);
		cbXa.setEnabled(false);
		cbHuyen = new JComboBox<String>();
		cbHuyen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbHuyen.setBackground(Color.WHITE);
		cbHuyen.setBounds(425, 341, 205, 35);
		contentPane.add(cbHuyen);
		cbHuyen.setEnabled(false);
		btnHuy = new JButton("H\u1EE7y");
		btnHuy.setIcon(new ImageIcon(ThemKhachHangJFrameGUI.class.getResource("/img/xoa.png")));
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHuy.setBounds(230, 400, 150, 35);
		contentPane.add(btnHuy);
		
		btnLamMoi = new JButton("L\u00E0m m\u1EDBi");
		btnLamMoi.setIcon(new ImageIcon(ThemKhachHangJFrameGUI.class.getResource("/img/lam_moi.png")));
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLamMoi.setBounds(480, 400, 150, 35);
		contentPane.add(btnLamMoi);
		
		btnThem = new JButton("Th\u00EAm");
		btnThem.setIcon(new ImageIcon(ThemKhachHangJFrameGUI.class.getResource("/img/them.png")));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThem.setBounds(729, 400, 150, 35);
		contentPane.add(btnThem);
		
		JLabel lblNhpSt_1_1_4 = new JLabel("Gi\u1EDBi t\u00EDnh  :");
		lblNhpSt_1_1_4.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_4.setBounds(610, 135, 87, 35);
		contentPane.add(lblNhpSt_1_1_4);
		
		lblMaKH = new JLabel();
		lblMaKH.setForeground(Color.RED);
		lblMaKH.setFont(new Font("Arial", Font.ITALIC, 16));
		lblMaKH.setBounds(175, 135, 364, 35);
		contentPane.add(lblMaKH);
		
		
		String khCuoiCung = khachHangDao.getKhachHangCuoiCung().substring(2);
		int soMaKHCuoi = Integer.parseInt(khCuoiCung);
		soMaKHCuoi++;
		String maKH = String.format("KH%06d",soMaKHCuoi);
		lblMaKH.setText(maKH);
		
	
		cbTinh.addItemListener(this);
		cbHuyen.addItemListener(this);
		btnHuy.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnThem.addActionListener(this);
		
		cbHuyen.addItem("Qu???n/Huy???n");
		cbTinh.addItem("T???nh/Th??nh Ph???");
		cbXa.addItem("X??/Ph?????ng");
		
		listTinhTP = diaChiDao.getAllTinhTP();
		for(String a : listTinhTP) {
			cbTinh.addItem(a);
		}
		
		txtSDT.setText(sdt);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (e.getStateChange() == ItemEvent.SELECTED)
			return;
		if(o.equals(cbTinh)) {
			cbHuyen.removeAllItems();
			if(cbTinh.getSelectedIndex() > 0) {
				cbHuyen.setEnabled(true);
				cbHuyen.addItem("Qu???n/Huy???n");
//				cbXa.addItem("X??/Ph?????ng");
				String tinh = cbTinh.getSelectedItem().toString();
				
				List<String> listQuanHuyen = diaChiDao.getAllHuyenTrongTinhTP(tinh);
				for(String b : listQuanHuyen) {
					cbHuyen.addItem(b);
				}
			}
			else {
				cbHuyen.setEnabled(false);
				cbHuyen.addItem("Qu???n/Huy???n");
				cbXa.addItem("X??/Ph?????ng");
			}
		}
		if(o.equals(cbHuyen)) {
			cbXa.removeAllItems();
			if(cbHuyen.getSelectedIndex() > 0) {
				String tinh = cbTinh.getSelectedItem().toString();
				String huyen = cbHuyen.getSelectedItem().toString();
				cbXa.setEnabled(true);
				cbXa.addItem("Ph?????ng/X??");
				List<String> listPhuongXa = diaChiDao.getAllPhuongXa(tinh, huyen);
				for(String c : listPhuongXa) {
					cbXa.addItem(c);
				}
			}
			else{
				cbXa.setEnabled(false);
				cbXa.addItem("Ph?????ng/X??");
			}
		}
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnHuy)) {
			dispose();
		}
		if(o.equals(btnLamMoi)) {
			Clear();
		}
		if(o.equals(btnThem)) {
			if(kiemTra()) {
				
				String maKH = lblMaKH.getText();
				String tenKH = txtTen.getText();
				String sdt = txtSDT.getText();
				String tinh = cbTinh.getSelectedItem().toString();
				String huyen = cbHuyen.getSelectedItem().toString();
				String xa = cbXa.getSelectedItem().toString();
				DiaChi diaChi = diaChiDao.getDiaChi(xa, huyen, tinh);	
				boolean gioiTinh = true;
				if(cbGioiTinh.getSelectedItem().toString().equalsIgnoreCase("N???")) {
					gioiTinh = false;
				}
				KhachHang kh = new KhachHang(diaChi, tenKH, sdt, maKH,gioiTinh );
				boolean rs = khachHangDao.themKhachHang(kh);
				if(rs) {
					JOptionPane.showMessageDialog(this,"Th??m kh??ch h??ng th??nh c??ng !");
					khachHang = kh;
					dispose();
					
				}else {
					JOptionPane.showMessageDialog(this,"Th??m kh??ch h??ng th???t b???i. M???i ki???m tra l???i");
				}
			}
		}
		
	}
	private void Clear() {
		cbGioiTinh.setSelectedIndex(0);
		txtTen.setText("");
		txtSDT.setText("");
		cbTinh.setSelectedIndex(0);
		cbHuyen.addItem("Qu???n/Huy???n");
		cbXa.addItem("X??/Ph????ng");
	}
	
	public boolean kiemTra() {
		String sdt = txtSDT.getText();
		String tenKhachHang =  txtTen.getText().toString().trim();
		
		
		if(tenKhachHang.trim().length() == 0) {
			JOptionPane.showMessageDialog(this, "T??n nh??n kh??ch h??ng kh??ng ???????c r???ng");
			txtTen.selectAll();
			txtTen.requestFocus();
			return false;
		}
		if(!tenKhachHang.matches("[^0-9!@#$%^&*()_+{}:]*")) {
			JOptionPane.showMessageDialog(this, "T??n nh??n kh??ch h??ng ph???i l?? ch??? Kh??ng ???????c ch???a s??? v?? k?? t??? ?????c bi???t");
			txtTen.selectAll();
			txtTen.requestFocus();
			return false;
		}

		if(sdt.equals("")){
			JOptionPane.showMessageDialog(null,"Vui l??ng nh???p s??? ??i???n tho???i");
			txtSDT.selectAll();
			txtSDT.requestFocus();
			return false;
		}
		
		else if(!sdt.matches("(^(03)[2-9]\\d{7})|(^(07)[06-9]\\d{7})|(^(08)[1-5]\\d{7})|(^(056)\\d{7})|(^(058)\\d{7})|(^(059)\\d{7})|(^(09)[0-46-9]\\d{7})")) {
			txtSDT.selectAll();
			txtSDT.requestFocus();
			JOptionPane.showMessageDialog(this,"S??? ??i???n tho???i kh??ng ????ng ?????ng d???ng");
			return false;
		}else if(khachHangDao.getKhachHangByStd(sdt) != null){
			JOptionPane.showMessageDialog(this,"S??? ??i???n tho???i ???? t???n t???i ");
			txtSDT.selectAll();
			txtSDT.requestFocus();
			return false;
		}
		
		if(cbTinh.getSelectedIndex() == 0 || cbHuyen.getSelectedIndex() == 0 || cbXa.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this,"Vui l??ng ki???m tra l???i ?????a ch???");
			return false;
		}
		
		return true;
	}
	
	public void loadCb(JComboBox<String> cb, List<String> list) {
		for (String string : list) {
			cb.addItem(string);
		}
	}
}
