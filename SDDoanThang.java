package buoi3;

import buoi2.Diem;

public class SDDoanThang {
	public static void main(String[] args) {

		Diem A = new Diem(2, 5);
		Diem B = new Diem(20, 35);

		DoanThang AB = new DoanThang(A, B);
		System.out.println("Doan thang AB co tao do" + AB.toString());
		AB.tinhTien(5, 3);
		System.out.println("Doan thang AB khi tinh tien co toa do" + AB);
		
		System.out.println("Tao doan thang CD");
		DoanThang CD = new DoanThang();
		CD.nhap();
		System.out.println("Doan thang CD co tao do : " + CD);
		float kq = 0;
		kq = CD.khoangCach();
		System.out.format("do dai CD la %.2f", kq);
		kq = CD.tinhGoc();
		System.out.format("\nGoc giua CD vs truc hoanh la %.2f do", kq);
	}
}
