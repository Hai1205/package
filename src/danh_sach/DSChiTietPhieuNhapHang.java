package danh_sach;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

import inter_face.DanhSach;
import thanh_phan.ChiTietPhieuNhapHang;

// import InterFace.DanhSach;

public class DSChiTietPhieuNhapHang implements DanhSach<ChiTietPhieuNhapHang> {
    private ChiTietPhieuNhapHang[] dsctpnh;
    private int n;

    public DSChiTietPhieuNhapHang() {
        n = 0;
        dsctpnh = new ChiTietPhieuNhapHang[n];
    }

    public DSChiTietPhieuNhapHang(int n) {
        setN(n);
        dsctpnh = new ChiTietPhieuNhapHang[n];

    }

    public DSChiTietPhieuNhapHang(DSChiTietPhieuNhapHang other) {
        this.n = other.n;
        this.dsctpnh = Arrays.copyOf(other.dsctpnh, n);

    }

    public void setN(int n) {
        this.n = n;
    }

    public void setDSCTSP(int i, ChiTietPhieuNhapHang value) {
        dsctpnh[i] = value;
    }

    public void setDSCTSP(int i) {
        dsctpnh[i].nhap();
    }

    public int getN() {
        return n;
    }

    public ChiTietPhieuNhapHang getDSCTSP(int i) {
        return dsctpnh[i];
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("So luong chi tiet phieu nhap hang: ");
        n = scanner.nextInt();

        dsctpnh = new ChiTietPhieuNhapHang[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Thong tin chi tiet phieu nhap hang thu " + (i + 1) + ": ");
            dsctpnh[i] = new ChiTietPhieuNhapHang();
            dsctpnh[i].nhap();
        }

    }

    public void xuat() {
        for (int i = 0; i < n; i++) {
            System.out.println("--------------------------");
            System.out.println("Thong tin chi tiet phieu nhap hang thu " + (i + 1) + ":");
            dsctpnh[i].xuat();
        }

        // System.out.format("%-20s %-15s %-10s %-15s %-15s\n",
        // "Ma phieu nhap hang",
        // "Ma san pham",
        // "so luong",
        // "Don gia",
        // "Tong tien");

        // for (CTPNH i : dsctpnh) {
        // System.out.format("%-20s %-15s %-10s %-15s %-15s\n",
        // i.getMPNH(),
        // i.getMSP(),
        // i.getSL(),
        // i.getDG(),
        // i.getTT());
        // }

    }

    public void nhapFile(boolean xoaHetDuLieuCu) {
        try {
            // ../data_base/
            FileWriter fw = new FileWriter("../src/data_base/DSChiTietPhieuNhapHang.txt", xoaHetDuLieuCu);
            BufferedWriter bw = new BufferedWriter(fw);
            for (ChiTietPhieuNhapHang i : dsctpnh) {
                bw.write(i.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // public void nhapFile(CTPNH i, boolean xoaHetDuLieuCu) {
    // try {
    // FileWriter fw = new FileWriter("../data_base/DSChiTietPhieuNhapHang.txt", xoaHetDuLieuCu);
    // BufferedWriter bw = new BufferedWriter(fw);
    // bw.write(i.toString());
    // bw.newLine();
    // bw.close();
    // fw.close();
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // }

    public void xuatFile() {
        try {
            // ../data_base/
            FileReader fr = new FileReader("../src/data_base/DSChiTietPhieuNhapHang.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] txt = line.split(",");
                if (txt.length == 4) {
                    String maPhieuNhap = txt[0].trim();
                    String maSanPham = txt[1].trim();
                    int soLuong = Integer.parseInt(txt[2].trim());
                    int donGia = Integer.parseInt(txt[3].trim());
                    them(new ChiTietPhieuNhapHang(maPhieuNhap, maSanPham, soLuong, donGia));
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void them() {
        // System.out.println("Thong tin chi tiet phieu nhap hang: ");
        // CTPNH x = new CTPNH();
        // x.nhap();
        // them(x);

        dsctpnh = Arrays.copyOf(dsctpnh, n + 1);
        System.out.println("Thong tin chi tiet phieu nhap hang: ");
        dsctpnh[n] = new ChiTietPhieuNhapHang();
        dsctpnh[n].nhap();
        n++;
    }

    public void them(ChiTietPhieuNhapHang x) {
        dsctpnh = Arrays.copyOf(dsctpnh, n + 1);
        dsctpnh[n] = new ChiTietPhieuNhapHang(x);
        n++;
    }

    public void timKiem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ma phieu nhap hang: ");
        String maPhieuNhap = scanner.nextLine();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if ((dsctpnh[i].getMPNH()).equals(maPhieuNhap)) {
                dsctpnh[i].xuat();
                cnt++;
                break;
            }
        }
        if (cnt == 0) {
            System.out.println("khong hop le!");
        }
    }

    public int timKiem(String maPhieuNhap) {
        for (int i = 0; i < n; i++) {
            if ((dsctpnh[i].getMPNH()).equals(maPhieuNhap)) {
                return i;
            }
        }
        return -1;
    }

    public ChiTietPhieuNhapHang timKiem1(String maPhieuNhap) {
        for (int i = 0; i < n; i++) {
            if ((dsctpnh[i].getMPNH()).equals(maPhieuNhap)) {
                return dsctpnh[i];
            }
        }
        return null;
    }

    public DSChiTietPhieuNhapHang timKiem2(String maPhieuNhap) {
        int cnt = 0;
        DSChiTietPhieuNhapHang ds = new DSChiTietPhieuNhapHang();
        for (int i = 0; i < n; i++) {
            if (dsctpnh[i].getMPNH().equals(maPhieuNhap)) {
                ds.them(dsctpnh[i]);
                cnt++;
            }
        }
        if (cnt == 0)
            return null;
        return ds;
    }

    public DSChiTietPhieuNhapHang timKiem3(String maSanPham) {
        int cnt = 0;
        DSChiTietPhieuNhapHang ds = new DSChiTietPhieuNhapHang();
        for (int i = 0; i < n; i++) {
            if (dsctpnh[i].getMSP().equals(maSanPham)) {
                ds.them(dsctpnh[i]);
                cnt++;
            }
        }
        if (cnt == 0)
            return null;
        return ds;
    }

    public DSChiTietPhieuNhapHang timKiem4(int soLuong) {
        int cnt = 0;
        DSChiTietPhieuNhapHang ds = new DSChiTietPhieuNhapHang();
        for (int i = 0; i < n; i++) {
            if (dsctpnh[i].getSL() == soLuong) {
                ds.them(dsctpnh[i]);
                cnt++;
            }
        }
        if (cnt == 0)
            return null;
        return ds;
    }

    public DSChiTietPhieuNhapHang timKiem5(int donGia) {
        int cnt = 0;
        DSChiTietPhieuNhapHang ds = new DSChiTietPhieuNhapHang();
        for (int i = 0; i < n; i++) {
            if (dsctpnh[i].getDG() == donGia) {
                ds.them(dsctpnh[i]);
                cnt++;
            }
        }
        if (cnt == 0)
            return null;
        return ds;
    }

    public DSChiTietPhieuNhapHang timKiem6(int tongTien) {
        int cnt = 0;
        DSChiTietPhieuNhapHang ds = new DSChiTietPhieuNhapHang();
        for (int i = 0; i < n; i++) {
            if (dsctpnh[i].getTT() == tongTien) {
                ds.them(dsctpnh[i]);
                cnt++;
            }
        }
        if (cnt == 0)
            return null;
        return ds;
    }

    public void xoa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ma phieu nhap hang: ");
        String maPhieuNhap = scanner.nextLine();

        int index = timKiem(maPhieuNhap);
        if (index == -1) {
            System.out.println("khong hop le!");
        } else {
            xoa(index);
        }

        // nhapFile(false);
    }

    public void xoa(int index) {
        if (index >= 0 && index < n) {
            for (int i = index; i < n - 1; i++) {
                dsctpnh[i] = dsctpnh[i + 1];
            }
            dsctpnh = Arrays.copyOf(dsctpnh, n - 1);
            n--;
            System.out.println("Xoa thanh cong!");
        } else {
            System.out.println("khong hop le!");
        }
    }

    public void xoa(String maPhieuNhap) {
        int index = timKiem(maPhieuNhap);
        if (index == -1) {
            System.out.println("khong hop le!");
        } else {
            xoa(index);
        }
    }

    public void sua(int index) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("---- Chon muc can sua: ----");
            System.out.println("1. Ma phieu nhap hang");
            System.out.println("2. Ma san pham");
            System.out.println("3. So luong");
            System.out.println("4. Don gia");
            System.out.println("5. Tong tien");
            System.out.println("6. Thoat");
            System.out.print("Chon chuc nang (1-6): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Ma phieu nhap hang: ");
                    String maPhieuNhap = scanner.nextLine();
                    dsctpnh[index].setMPN(maPhieuNhap);
                    break;
                case 2:
                    System.out.println("Ma san pham: ");
                    String maSanPham = scanner.nextLine();
                    dsctpnh[index].setMSP(maSanPham);
                    break;
                case 3:
                    System.out.println("So luong: ");
                    int soLuong = scanner.nextInt();
                    dsctpnh[index].setSL(soLuong);
                    break;
                case 4:
                    System.out.println("Don gia: ");
                    int donGia = scanner.nextInt();
                    dsctpnh[index].setDG(donGia);
                    break;
                case 5:
                    System.out.println("Tong tien: ");
                    int tongTien = scanner.nextInt();
                    dsctpnh[index].setTT(tongTien);
                    break;
                case 6:
                    System.out.println("ket thuc!");
                    break;
                default:
                    System.out.println("khong hop le!");
            }
        } while (choice != 6);
    }

    public void sua() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ma phieu nhap hang: ");
        String maPhieuNhap = scanner.nextLine();
        int index = timKiem(maPhieuNhap);
        if (index == -1) {
            System.out.println("khong hop le!");
        } else {
            sua(index);
        }
    }

    public void sua(String maPhieuNhap) {
        int index = timKiem(maPhieuNhap);
        if (index != -1) {
            sua(index);
        } else {
            System.out.println("khong hop le!");
        }
    }

    public void thongKe() {
        System.out.println("danh sach co " + n + " chi tiet phieu nhap hang");
    }
}
