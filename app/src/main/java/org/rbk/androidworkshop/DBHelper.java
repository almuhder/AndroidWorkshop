package org.rbk.androidworkshop;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by majdeddin on 5/8/17.
 */

public class DBHelper extends SQLiteOpenHelper {


    String sql = "";
    SQLiteDatabase bridge;
    Context mContext ;

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name , factory, version);
        mContext  = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        sql = "CREATE TABLE " + Config.TABLE_USERS + "( " +
                Config.COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
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
        try {
            bridge = getWritableDatabase();
            // INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY)
            //VALUES (1, 'Paul', 32, 'California', 20000.00 );
            sql = "INSERT INTO " + Config.TABLE_USERS + " ( "+
                    Config.COL_Name + " , " +
                    Config.COL_PHONE + " , " +
                    Config.COL_EMAIL + " , " +
                    Config.COL_PASSWORD + " , " +
                    Config.COL_CITY + " , " +
                    Config.COL_GENDER + " , " +
                    " ) VALUES (" +
                     " '"+ user.getName()+"' , " +
                    " '"+ user.getPhone()+"' , " +

                    " '"+ user.getEmail()+"', " +
                    " '"+user.getPassword()+"' , " +
                    " '"+user.getCity()+ "' , " +
                     user.isGender() + ")";

//        sql = "INSERT INTO tbl_users (col_name,col_phone, col_email, col_password, col_city, col_gender ) values " +
//                " ('majdeddin', '07922111212', 'almuhder@gmail.com' ,'1234' , 'anmman', 1  )";

            Log.d("Insert Test: ", sql);
            Toast.makeText(mContext , "A new user has been added sucessfully", Toast.LENGTH_SHORT).show();
            bridge.execSQL(sql);

        } catch (SQLException e) {
            e.printStackTrace();
            Toast.makeText(mContext , "Try again please, sth went wrong", Toast.LENGTH_SHORT).show();

        }

    }
}
