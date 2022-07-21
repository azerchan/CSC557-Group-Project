package com.example.cgpaapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "cgpa.db";
    public DBHelper(Context context) {
        super(context, "cgpa.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)");
        MyDB.execSQL("create Table Course(courseCode TEXT primary key, courseName TEXT, creditHour INTEGER)");


        // SEM 1
        MyDB.execSQL("INSERT INTO Course VALUES ('HBU111', 'CO-CURRICULUM I', 1)");
        MyDB.execSQL("INSERT INTO Course VALUES ('CTU552', 'FALSAFAH DAN ISU SEMASA', 2)");
        MyDB.execSQL("INSERT INTO Course VALUES ('CSC402', 'PROGRAMMING I', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('CSC413', 'COMPUTER ARCHITECTURE AND ORGANIZATION', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('CSC429', 'FALSAFAH DAN ISU SEMASA', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('ICT450', 'DATABASE DESIGN AND DEVELOPMENT', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('MAT406', 'FOUNDATION MATHEMATICS', 3)");

        // SEM 2
        MyDB.execSQL("INSERT INTO Course VALUES ('HBU121', 'CO-CURRICULUM II', 1)");
        MyDB.execSQL("INSERT INTO Course VALUES ('CTU554', 'PENGHAYATAN ETIKA DAN PERADABAN II', 2)");
        MyDB.execSQL("INSERT INTO Course VALUES ('CSC404', 'PROGRAMMING II', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('ICT502', 'DATABASE ENGINEERING', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('STA416', 'APPLIED PROBABILITY AND STATISTICS', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('ITT400', 'INTRODUCTION TO DATA COMMUNICATION AND NETWORKING', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('MAT421', 'CALCULUS I', 3)");

        // SEM 3
        MyDB.execSQL("INSERT INTO Course VALUES ('HBU131', 'CO-CURRICULUM III', 1)");
        MyDB.execSQL("INSERT INTO Course VALUES ('ELC501', 'ENGLISH FOR CRITICAL ACADEMIC READING', 2)");
        MyDB.execSQL("INSERT INTO Course VALUES ('TAC401', 'THIRD LANGUAGE I', 2)");
        MyDB.execSQL("INSERT INTO Course VALUES ('CSC435', 'OBJECT ORIENTED PROGRAMMING', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('CSC520', 'PRINCIPLES OF OPERATING SYSTEMS', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('CSC583', 'ARTIFICIAL INTELLIGENCE ALGORITHMS', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('CSC510', 'DISCRETE STRUCTURE', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('MAT423', 'LINEAR ALGEBRA I', 3)");

        // SEM 4
        MyDB.execSQL("INSERT INTO Course VALUES ('TAC451', 'THIRD LANGUAGE II', 2)");
        MyDB.execSQL("INSERT INTO Course VALUES ('ELC650', 'ENGLISH FOR PROFESSIONAL INTERACTION', 2)");
        MyDB.execSQL("INSERT INTO Course VALUES ('CSC508', 'DATA STRUCTURE', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('CSC577', 'SOFTWARE ENGINEERING THEORY AND PRINCIPLES', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('CSC569', 'PRINCIPLES OF COMPILERS', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('CSC584', 'ENTERPRISE PROGRAMMING', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('STA404', 'STATISTICS FOR BUSINESS AND SOCIAL SCIENCES', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('CSC557', 'MOBILE PROGRAMMING', 3)");

        // SEM 5
        MyDB.execSQL("INSERT INTO Course VALUES ('TAC501', 'THIRD LANGUAGE III', 2)");
        MyDB.execSQL("INSERT INTO Course VALUES ('ENT600', 'TECHNOLOGY ENTREPRENEURSHIP', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('CSC580', 'PARALLEL PROCESSING', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('CSC649', 'SPECIAL TOPICS IN COMPUTER SCIENCE', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('CSP600', 'PROJECT FORMULATION', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('CSC645', 'ALGORITHM ANALYSIS AND DESIGN', 3)");

        // SEM 6
        MyDB.execSQL("INSERT INTO Course VALUES ('ICT652', 'SOCIAL, ETHICAL AND PROFESSIONAL ISSUES IN ICT', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('CSC662', 'COMPUTER SECURITY', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('CSP650', 'PROJECT', 6)");

        // SEM 7
        MyDB.execSQL("INSERT INTO Course VALUES ('CST688', 'COMPUTER SCIENCE INDUSTRIAL TRAINING', 7)");


        // electives: soft computing
        MyDB.execSQL("INSERT INTO Course VALUES ('CSC575', 'SOFTWARE PROJECT MANAGEMENT', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('CSC562', 'INFORMATION RETRIEVAL AND SEARCHING ALGORITHMS', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('CSC574', 'DYNAMIC WEB APPLICATION DEVELOPMENT', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('CSC566', 'IMAGE PROCESSING', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('CSC658', 'COMPUTER GRAPHICS', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('CSC683', ' GAME DESIGN AND DEVELOPMENT', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('CSC585', 'HYBRID PROGRAMMING', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('CSC669', 'CRYPTOGRAPHIC ALGORITHMS', 3)");

        // electives: big data
        MyDB.execSQL("INSERT INTO Course VALUES ('STA404', 'STATISTICS FOR BUSINESS AND SOCIAL SCIENCES', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('ISP610', 'BUSINESS DATA ANALYTICS', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('DSC651', 'DATA REPRESENTATION AND REPORTING TECHNIQUES', 3)");
        MyDB.execSQL("INSERT INTO Course VALUES ('ISP565', 'DATA MINING', 3)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
        MyDB.execSQL("drop Table if exists Course");
    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    /* use this method in View Grade Table page */
    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Course", null);
        return cursor;
    }
}
