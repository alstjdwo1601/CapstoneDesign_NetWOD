package com.example.netwod;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;


public class ExcelDbAdapter {

    //유저 개인정보
    public static final String KEY_NAME = "name";
    public static final String KEY_AGE = "age";
    public static final String KEY_WEIGHT = "weight";
    public static final String KEY_HEIGHT= "height";
    public static final String KEY_NUM_OF_WORK = "NumOfWork";

    //primary key
    private static final String KEY_ROWID = "_id";

    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;

    //개인 정보 테이블 생성 쿼리
    private static  final String DATABASE_CREATE = "create table info (_id integer primary key autoincrement,"
            +"name text not null, age text not null, weight text not null, height text not null, NumOfWork text not null );";

    private static final String DATABASE_NAME = "Personal Information";
    private static final String DATABASE_TABLE = "PI_table";
    private static final int DATABASE_VERSION = 2;
    private final Context mCtx;




    private static class DatabaseHelper extends SQLiteOpenHelper{

        DatabaseHelper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            Log.w(TAG, "Upgrading database from version" + oldVersion + " to " + newVersion);
            db.execSQL("DROP TABLE IF EXISTS PI_table");
            onCreate(db);
        }
    }

    public ExcelDbAdapter(Context mCtx) {
        this.mCtx = mCtx;
    }

    public ExcelDbAdapter open() throws SQLException {
        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        mDbHelper.close();
    }

    public long createExcel(String name, String age, String weight, String height, String NumOfWork){
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NAME, name);
        initialValues.put(KEY_AGE, age);
        initialValues.put(KEY_WEIGHT, weight);
        initialValues.put(KEY_HEIGHT, height);
        initialValues.put(KEY_NUM_OF_WORK,NumOfWork);

        return mDb.insert(DATABASE_TABLE, null, initialValues);
    }

}
