package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;

import dao.DiaChiDao;
import dao.NhanVienDao;
import dao.Ipml.DiaChiImpl;
import dao.Ipml.NhanVienImpl;
import entity.DiaChi;
import entity.NhanVien;

public class ThemNhanVienPnGUI extends JPanel implements ActionListener, ItemListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5289327994044979194L;
	private JTextField txtTen;
	private JTextField txtSDT;
	private JTextField txtCMND;
	private JTextField txtMatKhau;
	private JButton btnLamMoi;
	private JButton btnThem;
	private JComboBox<String> cbTinh;
	private JComboBox<String> cbHuyen;
	private JComboBox<String> cbXa;
	private JDateChooser dateChooserNgaySinh;
	private JComboBox<String> cbGioiTinh;
	
	private DiaChiDao diaChiDao;
	private List<String> listTinhTP;
	private List<String> listQuanHuyen;
	private List<String> listPhuongXa;
	private NhanVienDao nhanVienDao;
	private JButton btnChonFile;
	private File file;
	private JLabel lblNewLabel;
	private JLabel lblHinhAnh;
	private JLabel lblMa;
	private int soMaNVCuoi;

	/**
	 * Create the panel.
	 */
	public ThemNhanVienPnGUI() {
		diaChiDao = new DiaChiImpl();
		nhanVienDao = new NhanVienImpl();
		
		setBackground(Color.WHITE);
		setBorder(new LineBorder(Color.BLUE));
		setBounds(0,0, 1364, 621);
		setLayout(null);
		
		lblNewLabel = new JLabel("TH??M NH??N VI??N");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 36, 1344, 35);
		add(lblNewLabel);
		
		lblHinhAnh = new JLabel();
		lblHinhAnh.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblHinhAnh.setBounds(39, 100, 326, 407);
		add(lblHinhAnh);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin Nh\u00E2n Vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(394, 100, 926, 407);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNhpSt_1_1 = new JLabel("M?? nh??n vi??n  :");
		lblNhpSt_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1.setBounds(44, 19, 141, 35);
		panel_1.add(lblNhpSt_1_1);
		
		JLabel lblNhpSt_1_1_1 = new JLabel("T??n nh??n vi??n :");
		lblNhpSt_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_1.setBounds(44, 84, 141, 35);
		panel_1.add(lblNhpSt_1_1_1);
		
		JLabel lblNhpSt_1_1_2 = new JLabel("S??? ??i???n tho???i   :");
		lblNhpSt_1_1_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_2.setBounds(44, 142, 123, 35);
		panel_1.add(lblNhpSt_1_1_2);
		
		JLabel lblNhpSt_1_1_3 = new JLabel("?????a ch???               :");
		lblNhpSt_1_1_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_3.setBounds(44, 274, 123, 35);
		panel_1.add(lblNhpSt_1_1_3);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTen.setColumns(10);
		txtTen.setBounds(195, 86, 704, 35);
		panel_1.add(txtTen);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Arial", Font.PLAIN, 16));
		txtSDT.setColumns(10);
		txtSDT.setBounds(195, 144, 364, 35);
		panel_1.add(txtSDT);
		
		cbGioiTinh = new JComboBox<String>();
		cbGioiTinh.setFont(new Font("Arial", Font.PLAIN, 16));
		cbGioiTinh.setBackground(Color.WHITE);
		cbGioiTinh.setBounds(714, 19, 185, 35);
		panel_1.add(cbGioiTinh);
		cbGioiTinh.addItem("Nam");
		cbGioiTinh.addItem("N???");
		
		cbTinh = new JComboBox<String>();
		cbTinh.setFont(new Font("Arial", Font.PLAIN, 16));
		cbTinh.setBackground(Color.WHITE);
		cbTinh.setBounds(195, 276, 205, 35);
		panel_1.add(cbTinh);
		cbTinh.addItem("T???nh/Th??nh ph???");
		listTinhTP = diaChiDao.getAllTinhTP();
		for(String a : listTinhTP) {
			cbTinh.addItem(a);
		}
		
		cbXa = new JComboBox<String>();
		cbXa.setFont(new Font("Arial", Font.PLAIN, 16));
		cbXa.setBackground(Color.WHITE);
		cbXa.setBounds(692, 276, 205, 35);
		panel_1.add(cbXa);
		cbXa.addItem("Ph?????ng/X??");
		
		
		cbHuyen = new JComboBox<String>();
		cbHuyen.setFont(new Font("Arial", Font.PLAIN, 16));
		cbHuyen.setBackground(Color.WHITE);
		cbHuyen.setBounds(442, 276, 205, 35);
		panel_1.add(cbHuyen);
		cbHuyen.addItem("Qu???n/Huy???n");
		
		JLabel lblNhpSt_1_1_4 = new JLabel("Gi???i t??nh    :");
		lblNhpSt_1_1_4.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_4.setBounds(617, 19, 87, 35);
		panel_1.add(lblNhpSt_1_1_4);
		
		
		String nvCuoiCung = nhanVienDao.getNhanVienCuoiCung().substring(2);;
		soMaNVCuoi = Integer.parseInt(nvCuoiCung);
		soMaNVCuoi++;
		String maNV = String.format("NV%06d",soMaNVCuoi);
		lblMa = new JLabel(maNV);
		lblMa.setForeground(Color.RED);
		lblMa.setFont(new Font("Arial", Font.ITALIC, 16));
		lblMa.setBounds(195, 19, 364, 35);
		panel_1.add(lblMa);
		
		JLabel lblNhpSt_1_1_2_1 = new JLabel("CMND                :");
		lblNhpSt_1_1_2_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_2_1.setBounds(44, 211, 123, 35);
		panel_1.add(lblNhpSt_1_1_2_1);
		
		txtCMND = new JTextField();
		txtCMND.setFont(new Font("Arial", Font.PLAIN, 16));
		txtCMND.setColumns(10);
		txtCMND.setBounds(195, 213, 704, 35);
		panel_1.add(txtCMND);
		
		JLabel lblNhpSt_1_1_2_1_1 = new JLabel("M???t kh???u           :");
		lblNhpSt_1_1_2_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_2_1_1.setBounds(44, 342, 123, 35);
		panel_1.add(lblNhpSt_1_1_2_1_1);
		
		txtMatKhau = new JTextField();
		txtMatKhau.setFont(new Font("Arial", Font.PLAIN, 16));
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(195, 344, 704, 35);
		panel_1.add(txtMatKhau);
		
		JLabel lblNhpSt_1_1_4_1 = new JLabel("Ng??y sinh  :");
		lblNhpSt_1_1_4_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_4_1.setBounds(617, 142, 99, 35);
		panel_1.add(lblNhpSt_1_1_4_1);
		
		dateChooserNgaySinh = new JDateChooser();
		dateChooserNgaySinh.setBounds(718, 142, 181, 35);
		dateChooserNgaySinh.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_1.add(dateChooserNgaySinh);
		dateChooserNgaySinh.setDateFormatString("dd/MM/yyyy");
		dateChooserNgaySinh.setFont(new Font("Arial", Font.PLAIN, 16));
		dateChooserNgaySinh.setDate(Calendar.getInstance().getTime());
		
		btnThem = new JButton("Th??m");
		btnThem.setIcon(new ImageIcon(ThemNhanVienPnGUI.class.getResource("/img/them.png")));
		btnThem.setBounds(1143, 547, 150, 35);
		add(btnThem);
		btnThem.setFont(new Font("Arial", Font.PLAIN, 16));
		
		btnLamMoi = new JButton("L??m m???i");
		btnLamMoi.setIcon(new ImageIcon(ThemNhanVienPnGUI.class.getResource("/img/lam_moi.png")));
		btnLamMoi.setBounds(891, 547, 150, 35);
		add(btnLamMoi);
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnChonFile = new JButton("Ch???n ???nh");
		btnChonFile.setIcon(new ImageIcon(ThemNhanVienPnGUI.class.getResource("/img/file.png")));
		btnChonFile.setFont(new Font("Arial", Font.PLAIN, 16));
		btnChonFile.setBounds(128, 518, 128, 35);
		add(btnChonFile);
		
		cbHuyen.setEnabled(false);
		cbXa.setEnabled(false);
		
		cbTinh.addItemListener(this);
		cbHuyen.addItemListener(this);
		btnLamMoi.addActionListener(this);
		btnThem.addActionListener(this);
		btnChonFile.addActionListener(this);
	}

///////////////////////////////////////////////////////////////////////////////////////////	
	
	

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object o = e.getSource();
		if (e.getStateChange() == ItemEvent.SELECTED)
			return;
		if(o.equals(cbTinh)) {
			cbHuyen.removeAllItems();
			if(cbTinh.getSelectedIndex() > 0) {
				cbHuyen.addItem("Qu???n/Huy???n");
				String tinh = cbTinh.getSelectedItem().toString();
				cbHuyen.setEnabled(true);
				listQuanHuyen = diaChiDao.getAllHuyenTrongTinhTP(tinh);
				for(String b : listQuanHuyen) {
					cbHuyen.addItem(b);
				}
			}
			else {
				cbHuyen.setEnabled(false);
			}
		}
		if(o.equals(cbHuyen)) {
			cbXa.removeAllItems();
			if(cbHuyen.getSelectedIndex() > 0) {
				String tinh = cbTinh.getSelectedItem().toString();
				String huyen = cbHuyen.getSelectedItem().toString();
				cbXa.setEnabled(true);
				cbXa.addItem("Ph?????ng/X??");
				listPhuongXa = diaChiDao.getAllPhuongXa(tinh, huyen);
				for(String c : listPhuongXa) {
					cbXa.addItem(c);
				}
			}
			else{
				cbXa.setEnabled(false);
			}
		}
		
	}

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if (o == btnChonFile) {
			JFileChooser fileChooser = new JFileChooser();
			FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Hinh anh","jpg","png");
			fileChooser.setFileFilter(extensionFilter);
			fileChooser.setMultiSelectionEnabled(false);
			int x = fileChooser.showDialog(this, "Ch???n file");
			if(x == fileChooser.APPROVE_OPTION) {
				file = fileChooser.getSelectedFile();
				BufferedImage bImage = scaleImage(lblHinhAnh.getWidth(),lblHinhAnh.getHeight(), file.getAbsolutePath());
				ImageIcon icon = new ImageIcon(bImage);
				lblHinhAnh.setIcon(icon);
			}
		}
		
		if (o == btnLamMoi) {
			lamMoi();
		}
		
		if (o == btnThem) {
			if (kiemTraDuLieu()) {
				String ma = lblMa.getText().trim();
				String ten = txtTen.getText().trim();
				String sdt = txtSDT.getText().trim();
				String cmnd = txtCMND.getText().trim();
				String matKhau = txtMatKhau.getText().trim();
				Date ngaySinh = dateChooserNgaySinh.getDate();
				String tinh = cbTinh.getSelectedItem().toString();
				String huyen = cbHuyen.getSelectedItem().toString();
				String xa = cbXa.getSelectedItem().toString();
				DiaChi diaChi = diaChiDao.getDiaChi(xa, huyen, tinh);
				String picName = getNameByPath(file.getAbsolutePath());
				boolean gioiTinh = true;
				if (cbGioiTinh.getSelectedIndex() == 1)
					gioiTinh = false;
				NhanVien nhanVien = new NhanVien(ma,ten,matKhau,true,sdt,gioiTinh,ngaySinh,false,cmnd,picName,diaChi);
				boolean rs = nhanVienDao.themNhanVien(nhanVien);
				if (rs) {
					coppyImg(picName, file);
					JOptionPane.showMessageDialog(this,"Th??m nh??n vi??n th??nh c??ng!");
					soMaNVCuoi++;
					lamMoi();
				}
			}
		}
		
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private void lamMoi() {
		String maNV = String.format("NV%06d",soMaNVCuoi);
		lblMa.setText(maNV);
		txtTen.setText("");
		txtCMND.setText("");
		txtSDT.setText("");
		txtMatKhau.setText("");
		dateChooserNgaySinh.setDate(Calendar.getInstance().getTime());
		cbGioiTinh.setSelectedItem(0);
		cbTinh.setSelectedIndex(0);
		cbHuyen.removeAllItems();
		cbHuyen.addItem("Qu???n/Huy???n");
		cbHuyen.setEnabled(false);
		cbXa.removeAllItems();
		cbXa.addItem("Ph?????ng/X??");
		cbXa.setEnabled(false);
		lblHinhAnh.setIcon(null);
		cbGioiTinh.setSelectedIndex(0);
	}

	public BufferedImage scaleImage(int WIDTH, int HEIGHT, String filename) {
	    BufferedImage bi = null;
	    try {
	        ImageIcon ii = new ImageIcon(filename);//path to image
	        bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	        Graphics2D g2d = (Graphics2D) bi.createGraphics();
	        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
	        g2d.drawImage(ii.getImage(), 0, 0, WIDTH, HEIGHT, null);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	    return bi;
	}
	
	@SuppressWarnings("resource")
	public boolean coppyImg(String name, File img) {
		try {			
			FileInputStream in = new FileInputStream(img);
			FileOutputStream out = new FileOutputStream(new File("imgNhanVien//"+name));
			  int length;
	            byte[] buffer = new byte[1024];
	 
	            // copy the file content in bytes
	            while ((length = in.read(buffer)) > 0) {
	                out.write(buffer, 0, length);
	            }
			
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public String getNameByPath(String path) {
		int index = path.lastIndexOf("\\");
		String name = path.substring(index+1);	
		return name;
		
	}
	
	@SuppressWarnings("deprecation")
	private boolean kiemTraDuLieu() {
		if (txtTen.getText().trim().equals("")) {
			focus(txtTen, "Vui l??ng nh???p t??n nh??n vi??n!");
			return false;
		}
		if (!txtTen.getText().trim().matches("" + "[aA????????????????????????????????????????????????????????????????????????????????????????????bBcCdD????eE????????????????????????????????????????????????????????????"
				+ "fFgGhHiI????????????????????????jJkKlLmMnNoO????????????????????????????????????????????????????????????????????????????????????????????pPqQrRsStTu"
				+ "U??????????????????????????????????????????????????????????vVwWxXyY????????????????????????????zZ ]+")) {
			focus(txtTen, "Vui l??ng nh???p t??n nh??n vi??n kh??ng ch???a k?? t??? s??? v?? k?? t??? ?????c bi???t!");
			return false;
		}
		if (txtSDT.getText().trim().equals("")) {
			focus(txtSDT, "Vui l??ng nh???p s??? ??i???n tho???i!");
			return false;
		}
		if (!txtSDT.getText().trim().matches("^0[1-9][0-9]{8,9}")) {
			focus(txtSDT, "Vui l??ng nh???p s??? ??i???n tho???i t??? 10 ?????n 11 s???!");
			return false;
		}
		if (!nhanVienDao.kiemTraSoDienThoai(txtSDT.getText().trim())) {
			focus(txtSDT, "S??? ??i???n tho???i n??y ???? t???n t???i!");
			return false;
		}
		if (dateChooserNgaySinh.getDate() == null) {
			JOptionPane.showMessageDialog(this, "Vui l??ng ch???n ng??y sinh!");
			dateChooserNgaySinh.requestFocus();
			return false;
		}
		
		LocalDate ngaySinh  = LocalDate.of(dateChooserNgaySinh.getDate().getYear()+1900,dateChooserNgaySinh.getDate().getMonth()+1,dateChooserNgaySinh.getDate().getDate());
		System.out.println(dateChooserNgaySinh.getDate().getYear());
		if (Period.between(ngaySinh,LocalDate.now()).getYears()<18) {
			JOptionPane.showMessageDialog(this, "Lao ?????ng ph???i t??? 18 tu???i tr??? l??n!");
			dateChooserNgaySinh.requestFocus();
			return false;
		}
		if (txtCMND.getText().trim().equals("")) {
			focus(txtCMND, "Vui l??ng nh???p ch???ng minh nh??n d??n!");
			return false;
		}
		if (!txtCMND.getText().trim().matches("^[0-9]{9,}")) {
			focus(txtCMND, "Vui l??ng nh???p ch???ng minh nh??n d??n t??? 9 s??? tr??? l??n!");
			return false;
		}
		if (!nhanVienDao.kiemTraChungMinhNhanDan(txtCMND.getText().trim())) {
			focus(txtCMND, "Ch???ng minh nh??n d??n n??y ???? t???n t???i!");
			return false;
		}
		if (cbTinh.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Vui l??ng ch???n T???nh/Th??nh ph???");
			return false;
		}
		if (cbHuyen.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Vui l??ng ch???n Qu???n/huy???n");
			return false;
		}
		if (cbXa.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Vui l??ng ch???n Ph?????ng/x??");
			return false;
		}
		if (txtMatKhau.getText().trim().equals("")){
			focus(txtMatKhau, "Vui l??ng nh???p m???t kh???u!");
			return false;
		}
		if (txtMatKhau.getText().trim().length()<6){
			focus(txtMatKhau, "Vui l??ng nh???p m???t kh???u t??? 6 k?? t??? tr??? l??n!");
			return false;
		}
		if (file == null) {
			JOptionPane.showMessageDialog(this, "Vui l??ng ch???n ???nh nh??n vi??n!");
			return false;
		}
		return true;
	}
	
	private void focus(JTextField txt,String mess) {
		txt.selectAll();
		txt.requestFocus();
		JOptionPane.showMessageDialog(this,mess);
	}
}
