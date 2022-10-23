package buoi3;

import java.util.Scanner;

public class Gach {
	private String maSo, mau;
	private int soLuong, chieuDai, chieuNgang;
	private long gia;

	public Gach(String maSo1, String mau1, int soLuong1, int chieuDai1, int chieuNgang1, long gia1) {
		maSo = maSo1;
		mau = mau1;
		soLuong = soLuong1;
		chieuDai = chieuDai1;
		chieuNgang = chieuNgang1;
		gia = gia1;
	}

	public Gach() {
		maSo = new String();
		mau = new String();
		soLuong = 0;
		chieuDai = 0;
		chieuNgang = 0;
		gia = 0;
	}

	public Gach(Gach a) {
		maSo = new String(a.maSo);
		mau = new String(a.mau);
		soLuong = a.soLuong;
		chieuDai = a.chieuDai;
		chieuNgang = a.chieuNgang;
		gia = a.gia;
	}

	public String getMaSo() {
		return maSo;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma so gach: ");
		maSo = sc.nextLine();
		System.out.println("Nhap mau: ");
		mau = sc.nextLine();
		System.out.println("Nhap so luong vien gach/hop : ");
		soLuong = sc.nextInt();
		System.out.println("Nhap chieu dai");
		chieuDai = sc.nextInt();
		System.out.println("Nhap chieu ngang: ");
		chieuNgang = sc.nextInt();
		System.out.println("Nhap don gia: ");
		gia = sc.nextLong();
	}

	public void in() {
		System.out.println(">>>" + "Ma So: " + maSo + " ," + "Mau: " + mau);
		System.out.println(">>>" + "So Luong: " + soLuong + "/hop" + " ," + "Chieu Dai: " + chieuDai + " cm" + " ,"+ "Chieu Ngang " + chieuNgang + " cm");
		System.out.println(">>>" + "Don Gia: " + gia + "VND/hop");
	}

	public float giaTheoDienTich() {
		return (float) soLuong / ((float) chieuDai * chieuNgang);
	}

	public float giaBanLe() {
		return ((float) gia / soLuong) * ((float) 120 / 100);
	}

	public float dienTichToiDa() {
		return ((float) chieuDai * chieuNgang * soLuong);
	}

	public int soLuongHop(int D, int N) {
		double soVienDai= Math.ceil((double)D/chieuDai);
		double soVienNgang = Math.ceil((double)N / chieuNgang);
		return (int)Math.ceil((soVienDai * soVienNgang)/soLuong);
	}
}
