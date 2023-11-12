package thanh_phan;

import java.util.Scanner;

public class ChiTietPhieuNhapHang {
    // private PhieuNhapHang pnh;
    // private DSSanPham dssp;
    // private SanPham sp;

    private String maPhieuNhap, maSanPham;
    private int soLuong, donGia, tongTien;

    public ChiTietPhieuNhapHang() {
        maPhieuNhap = "";
        maSanPham = "";
        soLuong = 0;
        donGia = 0;
        tongTien = 0;
    }

    public ChiTietPhieuNhapHang(String maPhieuNhap, String maSanPham, int soLuong, int donGia) {
        setMPN(maPhieuNhap);
        setMSP(maSanPham);
        setSL(soLuong);
        setDG(donGia);
        setTT(soLuong, donGia);
        // setSLSP();
    }

    public ChiTietPhieuNhapHang(ChiTietPhieuNhapHang other) {
        this.maPhieuNhap = other.maPhieuNhap;
        this.maSanPham = other.maSanPham;
        this.soLuong = other.soLuong;
        this.donGia = other.donGia;      
        this.setTT(soLuong, donGia);
    }

    // public void setSLSP(){
    //     int index = dssp.search(maSanPham);
    //     if(index == -1) {
    //         sp.nhap();
    //         dssp.them(sp);
    //         index = dssp.getN() - 1;
    //     }
    //     dssp[index].setSL(sp.getSL() + soLuong);
    // }

    public void setMPN(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
        // pnh.setMPN(maPhieuNhap);
    }

    public void setMSP(String maSanPham) {
        this.maSanPham = maSanPham;
        // sp.setMSP(maSanPham);
    }

    public void setSL(int soLuong) {
        this.soLuong = soLuong;
        setTT1(soLuong);
    }

    public void setDG(int donGia) {
        this.donGia = donGia;
        setTT2(donGia);
    }

    public void setTT(int soLuong, int donGia) {
        this.tongTien = soLuong * donGia;
    }

    public void setTT(int tongTien) {
        this.tongTien = tongTien;
    }

    public void setTT1(int soLuong) {
        this.tongTien = soLuong * donGia;
    }
    
    public void setTT2(int donGia) {
        this.tongTien = soLuong * donGia;
    }

    // public void setDSSP(DSSP dssp) {
    //     this.dssp = dssp;
    // }

    public String getMPNH() {
        return maPhieuNhap;
    }

    public String getMSP() {
        return maSanPham;
    }

    public int getSL() {
        return soLuong;
    }

    public int getDG() {
        return donGia;
    }

    public int getTT() {
        return tongTien;
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ma phieu nhap: ");
        maPhieuNhap = scanner.nextLine();

        System.out.println("Ma san pham: ");
        maSanPham = scanner.nextLine();

        System.out.println("So luong: ");
        soLuong = scanner.nextInt();

        System.out.println("Don gia: ");
        donGia = scanner.nextInt();

        setTT(soLuong, donGia);

        // setSLSP();

    }

    public void xuat() {
        System.out.println("Ma phieu nhap: " + maPhieuNhap);
        System.out.println("Ma san pham: " + maSanPham);
        System.out.println("So luong: " + soLuong);
        System.out.println("don giaD " + donGia);
        System.out.println("Tong tien: " + tongTien);
    }

    @Override
    public String toString() {
        return maPhieuNhap + ", " +  maSanPham + ", " + soLuong + ", " + donGia;
    }
}
