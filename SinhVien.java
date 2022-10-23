package buoi3;

import java.util.Scanner;

import buoi2.Date;

public class SinhVien {
	private String mssv, hten;
	private Date ngaySinh;

	private int soLuong, max;
	private String tenHocPhan[];
	private String diemHocPhan[];

	public SinhVien() {
		// Hàm xây dựng mặc nhiên
		mssv = new String();
		hten = new String();
		ngaySinh = new Date();
		soLuong = 0;
		max = 60;
		tenHocPhan = new String[max];
		diemHocPhan = new String[max];
	}

	public SinhVien(int max1) {
		// hàm xây dựng có đối số
		mssv = new String();
		hten = new String();
		ngaySinh = new Date();
		soLuong = 0;
		max = max1;
		tenHocPhan = new String[max];
		diemHocPhan = new String[max];
	}

	public SinhVien(String mssv1, String hten1, Date ngaySinh1) {
		// hàm xây dựng có đối số
		mssv = new String(mssv1);
		hten = new String(hten1);
		ngaySinh = new Date(ngaySinh1);
		soLuong = 0;
		max = 60;
		tenHocPhan = new String[max];
		diemHocPhan = new String[max];
	}

	public SinhVien(SinhVien sv) {// Hàm xây dựng sao chép
		mssv = new String(sv.mssv);
		hten = new String(sv.hten);
		ngaySinh = new Date(sv.ngaySinh);
		soLuong = sv.soLuong;
		max = sv.max;
		tenHocPhan = new String[max];
		diemHocPhan = new String[max];

		// sao chép những môn học đã đăng ký
		for (int i = 0; i < soLuong; i++) {
			tenHocPhan[i] = new String(sv.tenHocPhan[i]);
			diemHocPhan[i] = new String(sv.diemHocPhan[i]);
		}
	}

	public String getMssv() {
		return mssv;
	}

	public String getHten() {
		return hten;
	}

	public void nhap() {// Nhập thông tin cơ bản của sinh viên
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma so sinh vien: ");
		mssv = sc.nextLine();

		System.out.println("Nhap ho ten sinh vien: ");
		hten = sc.nextLine();

		System.out.println("Nhap ngay sinh sinh vien");
		ngaySinh.nhap();

	}

	public void in() {
		// [mssv, hten, nsinh, tenhp:diemhp]
		System.out.print("[" + mssv + "," + hten + "," + ngaySinh);
		for (int i = 0; i < soLuong; i++) {
			System.out.print(", " + tenHocPhan[i] + ":" + diemHocPhan[i]);
		}
		System.out.print("]");
	}

	public String toString() {
		String s = ("[" + mssv + "," + hten + "," + ngaySinh);
		for (int i = 0; i < soLuong; i++) {
			s += (", " + tenHocPhan[i] + ":" + diemHocPhan[i]);
		}
		s += ("]");
		return s;
	}

	public void them(String tenHP, String diemHP) {// thêm vào cuối danh sách
		if (soLuong < max - 1) {
			tenHocPhan[soLuong] = new String(tenHP);
			diemHocPhan[soLuong] = new String(diemHP);

			soLuong++;// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

		} else {
			System.out.println("Ban khong the them vi mang da day");
		}
	}

	public void xoaHP(String tenHP) {// xóa môn với tên
		// tìm vị trí i của môn với tên
		int i = 0;
		for (i = 0; i < soLuong; i++) {
			if (tenHocPhan[i].equals(tenHP))
			break;
		}
		// tìm thấy vị trí i
		if (i < soLuong) {// tim thay vi tri i
			// xoa mon hoc i
			for (int k = i; k < soLuong - 1; k++) {
				tenHocPhan[k] = tenHocPhan[k + 1];
				diemHocPhan[k] = diemHocPhan[k + 1];
			}
		}
		soLuong--;
	}

	public void dangKy() {
		Scanner sc = new Scanner(System.in);
		String tenHP = "";// new String
		System.out.println("Nhap cac mon hoc can dang ky, ket thuc boi 'stop' ");
		do {
			System.out.println("Nhap ten mon");
			tenHP = sc.nextLine();
			if (tenHP.equals("stop"))
				break;
			them(tenHP, "");
		} while (true);
	}

	public void gvNhapDiem() {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < soLuong; i++) {
			System.out.println("Nhap diem mon " + tenHocPhan[i] + ":");
			diemHocPhan[i] = sc.nextLine();
		}
	}

	// chuyển đổi điểm số sang diem chữ
	public void chuyenDiemSoSangDiemChu() {
		float n = 0.0f;
		for (int i = 0; i < soLuong; i++) {
			n = Float.parseFloat(diemHocPhan[i]);
			if (n >= 9)
				diemHocPhan[i] = "A";
			else if (n >= 8 && n < 9)
				diemHocPhan[i] = "B+";
			else if (n >= 7 && n < 8)
				diemHocPhan[i] = "B";
			else if (n >= 6.5 && n < 7)
				diemHocPhan[i] = "C+";
			else if (n >= 5.5 && n < 6.5)
				diemHocPhan[i] = "C";
			else if (n >= 5 && n < 5.5)
				diemHocPhan[i] = "D+";
			else if (n >= 4 && n < 5)
				diemHocPhan[i] = "D";
			else
				diemHocPhan[i] = "F";
		}
	}

	public float trungBinh() {
		float kq = 0.0f;
		for (int i = 0; i < soLuong; i++) {
			if (diemHocPhan[i].equals("A"))
				kq += 4.0f;
			else if (diemHocPhan[i].equals("B+"))
				kq += 3.5f;
			else if (diemHocPhan[i].equals("B"))
				kq += 3.0f;
			else if (diemHocPhan[i].equals("C+"))
				kq += 2.5f;
			else if (diemHocPhan[i].equals("C"))
				kq += 2.0f;
			else if (diemHocPhan[i].equals("D+"))
				kq += 1.5f;
			else if (diemHocPhan[i].equals("D"))
				kq += 1.0f;
			else
				kq += 0.0f;
		}
		return (kq / (float) soLuong);
	}

	public String layTen() {
		String ten = null;
		ten = hten.substring(hten.lastIndexOf(" ")+1);
		return ten;
	}
	
	// Sắp xếp sinh viên theo Alphabet
//	public void sapXepDanhSach(SinhVien ds[]) {
//		SinhVien t = new SinhVien();
//		for (int i = 0; i < ds.length - 1; i++) {
//			for (int j = i + 1; j < ds.length; j++) {
//				if (ds[i].layTen(hten).compareTo(ds[j].layTen(hten)) > 0) {
//					t = ds[i];
//					ds[i] = ds[j];
//					ds[j] = t;
//				}
//			}
//		}
//	}
}