package buoi3;

import java.util.Scanner;

public class SDSinhVien {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SinhVien a = new SinhVien();
		a.nhapTT();
		a.nhapDiem();
		a.dangkyHp();
		a.hienThiTT();
	//  System.out.print("Sinh vien a: " + a);
		a.hienThiDiem();
		
		System.out.println("Nhap so luong sinh vien: ");
		int n = sc.nextInt();
		SinhVien ds[] = new SinhVien[n];
		for(int i = 0; i < n; i++)
			ds[i] = new SinhVien();
		for(int i = 0; i < n; i++){
			ds[i].nhapTT();
			ds[i].nhapDiem();
		}
		for(SinhVien s:ds){
			s.hienThiTT();
			s.hienThiDiem();
		}
		System.out.print("\nSinh vien bi canh cao hoc vu la: ");
		for(SinhVien s:ds){
			if(s.diemTB() < 2.0)
				s.hienThiTT();
			else
				System.out.print("\nKhong co sinh vien bi canh cao hoc vu");
		}
		SinhVien tmp = new SinhVien(ds[0]);
		for(int i = 0; i < n; i++){
			if(ds[i].diemTB() > tmp.diemTB())
				tmp = ds[i];	
		}
		System.out.print("\nSinh vien co diem trung binh cao nhat lop la: " + tmp);
		
		for(int i = 0; i <n; i++){
			for(int j = i+1; j < n; j++){
				if(ds[i].layhoTen().compareTo(ds[j].layhoTen()) > 0){
					SinhVien s = ds[i];
							ds[i] = ds[j];
							ds[j] = s;
				}
			}
		}
		System.out.println("\nDanh sach sinh vien theo thu tu Alphabet la: ");
		for(SinhVien s:ds)
			s.hienThiTT();
	}

}
