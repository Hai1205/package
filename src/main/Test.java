package main;

import danh_sach.DSChiTietPhieuNhapHang;
import quan_ly.QLChiTietPhieuNhapHang;

public class Test {
    public static void main(String[] args) {
        DSChiTietPhieuNhapHang a1 = new DSChiTietPhieuNhapHang();
        QLChiTietPhieuNhapHang a2 = new QLChiTietPhieuNhapHang(a1);
        a2.menu();
    }
}
