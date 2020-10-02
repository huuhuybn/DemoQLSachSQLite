package vn.poly.edu.myapplication.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;

public class MySqlite extends SQLiteOpenHelper {

    public MySqlite(Context context) {
        super(context, "mydata.sql", null, 1);
    }
// The loi
//    MaTheLoai CHAR(5) PK, NOT NULL Mã thể thoại
//    Tên thể
//    loại
//    NVARCHAR(50) NOT NULL Tên thể loại
//    Mô tả NVARCHAR(255) Mô tẻ chi tiết Vị trí INT Vị trí của loại sách đó trong
//    cửa hàng, các kệ được đánh
//    số kệ 1, kệ
    // noi khai bao cau lenh create table

    //    MaSach NCHAR(5) PK, NOT NULL Mã Sách
//
//    MaTheLoai NCHAR(50) FK, NOT NULL Mã thể loại mà sách thuộc về
//    TacGia NVARCHAR(50) Tác giá sách
//    NXB NVARCHAR(50) Nhà xuất bản sách
//    giaBia FLOAT NOT NULL Giá bán sách
//    soLuong INT NOT NULL Số lượng tồn kho
//
//    MaHoaDon NCHAR(7) PK, NOT NULL Mã hoá đơn
//    NgayMua DATE NOT NULL Ngày mua hàng

    //    MaHDCT INT PK, Tự tăng Mã hoá đơn chi tiết
//    MaHoaDon NCHAR(7) FK, NOT NULL Mã hoá đơn
//    MaSach NCHAR(5) FK, NOT NULL Mã sách được mua
//    SoLuongMua INT NOT NULL Số lượng mua

    //    userName NVARCHAR(50) PK Tên đăng nhập
//    Password NVARCHAR(50) NOT NULL Mật khẩu đăng nhập
//    Phone NCHAR(10) NOT NULL Số điện thoại
//    hoTen NVARCHAR(50) Họ tên người dù
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String the_loai = "CREATE TABLE theLoai (MaTheLoai char primary key not null," +
                " tenTheLoai nvarchar(50), moTa nvarchar(255), viTri integer)";
        String sach = "CREATE TABLE sach (MaSach char(5) primary key not null," +
                "MaTheLoai char(50)," +
                "NXB nvarchar(50), giaBia FLOAT not null, soLuong int not null) ";
        String hoa_don = "CREATE TABLE hoa_don (MaHoaDon char(7) primary key not null, " +
                "NgayMua Date not null)";
        String hoa_don_chi_tiet = "CREATE TABLE chi_tiet(MaHDCT INT primary key," +
                "MaHoaDon NCHAR(7) ,MaSach NCHAR(5), SoLuongMua INT NOT NULL)";
        String nguoi_dung = "CREATE TABLE nguoi_dung(userName NVARCHAR(50) primary key ," +
                "    Password NVARCHAR(50) NOT NULL," +
                "    Phone NCHAR(10) NOT NULL ," +
                "    hoTen NVARCHAR(50))";

        sqLiteDatabase.execSQL(the_loai);
        sqLiteDatabase.execSQL(sach);
        sqLiteDatabase.execSQL(hoa_don);
        sqLiteDatabase.execSQL(hoa_don_chi_tiet);
        sqLiteDatabase.execSQL(nguoi_dung);

    }

    // chi su dung khi update phien ban (cau truc) csdl
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
