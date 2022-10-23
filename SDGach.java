package buoi3;

import java.util.Scanner;

public class SDGach {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("Nhap so loai gach: ");
		n = sc.nextInt();
		Gach P[] = new Gach[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Nhap thong tin loai gach so " + (i + 1));
			P[i] = new Gach();
			P[i].nhap();

		}

		for (int i = 0; i < n; i++) {
			System.out.println("Thong tin gach ma so - " + P[i].getMaSo());
			P[i].in();
			System.out.println("\n");
		}
		System.out.println("\nGach co chi phi lot thap nhat");
		int k = 0;
		float tmp;
		float min = P[0].giaTheoDienTich();
		for (int i = 1; i < P.length; i++) {
			if (P[i].giaTheoDienTich() < min) {
				min = P[i].giaTheoDienTich();
				k = i;
			}
		}
		System.out.println("\n");
		P[k].in();
		int sh;
		System.out.println("Chi phi mua gach void dien tich 5m x 20m: ");
		for(int i =0 ;i< n; i++) {
			sh = P[i].soLuongHop(500, 2000) * (int)P[i].getGia();
			System.out.println("chi phi gach thu " +(i+1)+ " la: " + sh + "VND");
			
		}
		
	}
}
