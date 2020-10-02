package vn.poly.edu.myapplication.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import vn.poly.edu.myapplication.model.NguoiDung;

public class NguoiDungDAO {
    // cac cau lenh truy van voi bang User

    private MySqlite mySqlite;

    public NguoiDungDAO(MySqlite mySqlite) {
        this.mySqlite = mySqlite;
    }

    public void xoaNguoiDung(String id) {
        SQLiteDatabase sqLiteDatabase = mySqlite.getWritableDatabase();
        sqLiteDatabase.delete("nguoi_dung", "userName=?", new String[]{id});
    }

    public long themNguoiDung(NguoiDung nguoiDung) {
        SQLiteDatabase sqLiteDatabase = mySqlite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName", nguoiDung.userName);
        contentValues.put("hoTen", nguoiDung.hoTen);
        contentValues.put("Phone", nguoiDung.Phone);
        contentValues.put("Password", nguoiDung.Password);

        return sqLiteDatabase.insert("nguoi_dung", null, contentValues);
    }

    public List<NguoiDung> getAllNguoiDung() {
        List<NguoiDung> nguoiDungList = new ArrayList<>();

        String truyVan = "SELECT * FROM nguoi_dung";
        Cursor cursor = mySqlite.getWritableDatabase().rawQuery(truyVan, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false) {
                String userName = cursor.getString(cursor.getColumnIndex("userName"));
                String Password = cursor.getString(cursor.getColumnIndex("Password"));
                String hoTen = cursor.getString(cursor.getColumnIndex("hoTen"));
                String Phone = cursor.getString(cursor.getColumnIndex("Phone"));

                NguoiDung nguoiDung = new NguoiDung();
                nguoiDung.userName = userName;
                nguoiDung.hoTen = hoTen;
                nguoiDung.Phone = Phone;
                nguoiDung.Password = Password;

                nguoiDungList.add(nguoiDung);

                cursor.moveToNext();
            }
            cursor.close();

        }

        return nguoiDungList;
    }

    public int suaNguoiDung(NguoiDung nguoiDung) {
        SQLiteDatabase sqLiteDatabase = mySqlite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName", nguoiDung.userName);
        contentValues.put("hoTen", nguoiDung.hoTen);
        contentValues.put("Phone", nguoiDung.Phone);
        contentValues.put("Password", nguoiDung.Password);

        return sqLiteDatabase.update("nguoi_dung", contentValues,
                "userName=?", new String[]{nguoiDung.userName});

    }


}
