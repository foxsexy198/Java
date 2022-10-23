package buoi3;

import buoi2.Diem;

public class DoanThang {
	private Diem d1, d2;

	// Thuộc tính là đối tượng phải cấp phát bộ nhớ
	public DoanThang() { // Phương thức xây dựng không đối số
		d1 = new Diem();
		d2 = new Diem();
	}

	public DoanThang(Diem d11, Diem d22) {
		d1 = new Diem(d11); // Gọi phương thức xây dựng sao chép
		d2 = new Diem(d22);
	}

	// Phương thức xây dựng có tham số
	public DoanThang(int x1, int y1, int x2, int y2) {
		d1 = new Diem(x1, y1);
		d2 = new Diem(x2, y2);
	}

	// phương thức xây dựng sao chép của lớp đoạn thẳng
	public DoanThang(DoanThang dt) {
		d1 = new Diem(dt.d1);// gọi phương thức xây dựng của lớp Diem()
		d2 = new Diem(dt.d2);
	}

	public void nhap() { //DoanThang.nhap()
		System.out.println("Nhap toa do diem dau: ");
		d1.nhap(); //Diem.nhap()
		System.out.println("Nhap toa do diem cuoi: ");
		d2.nhap();
	}
	
	public void in() {
		System.out.print("[");
		d1.in();
		System.out.print(",");
		d2.in();
		System.out.print("]");
	}

	public String toString() {
		return "["+ d1 + "," + d2 + "]";
	}
	
	public void tinhTien(int dx, int dy) {
		d1.tinhTien(dx, dy);
		d2.tinhTien(dx, dy);
	}
	
	public float khoangCach() {
		return d1.khoangCach(d2);
	}
	
	public Diem trungDiem() {
		Diem I = new Diem();
		I.ganX((d1.layX() + d2.layX())/2);
		I.ganY((d1.layY() + d2.layY())/2);
		return I;
		//return new Diem((d1.layX() + d2.layX())/2, (d1.layY() + d2.layY())/2);
	}
	
	//Hàm tính góc
	public float tinhGoc() {
		float canhHuyen = (float)Math.abs(d2.layY() - d1.layY());
		float canhGocVuong = (float)khoangCach();
		float kq = (float) Math.asin(canhHuyen/canhGocVuong);
		return kq*(180/(float)Math.PI);
	} 
	
	
}
