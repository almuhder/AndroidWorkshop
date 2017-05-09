package org.rbk.androidworkshop;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by majdeddin on 5/8/17.
 */

public class DBHelper extends SQLiteOpenHelper {


    String sql = "";
    SQLiteDatabase bridge;

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name , factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        sql = "CREATE TABLE " + Config.TABLE_USERS + "( " +
                Config.COL_ID + " INT PRIMARY KEY AUTOINCREMENT , " +
                Config.COL_Name + " TEXT , " +
                Config.COL_PHONE + " TEXT , " +
                Config.COL_EMAIL + " TEXT , " +
                Config.COL_PASSWORD + " TEXT , " +
                Config.COL_CITY + " TEXT , " +
                Config.COL_GENDER + " BOOLEAN  " +
                ");";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void registerNewUser(User user){
        bridge = getWritableDatabase();
        sql = "INSERT INTO " + Config.TABLE_USERS + //" VALUES "
                Config.COL_Name + " '"+ user.getName()+"' , " +
                Config.COL_PHONE + " '"+ user.getPhone()+"' , " +
                Config.COL_EMAIL + " '"+ user.getEmail()+"', " +
                Config.COL_PASSWORD + " '"+user.getPassword()+"' , " +
                Config.COL_CITY + " '"+user.getCity()+"' , " +
                Config.COL_GENDER + user.isGender() ;

        ;
        bridge.execSQL(sql);

    }
}
