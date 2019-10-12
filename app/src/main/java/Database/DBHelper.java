package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.it18067316.UserProfile;

import java.sql.Date;

public class DBHelper extends SQLiteOpenHelper {


    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + UserProfile.Users.TABLE_NAME + " (" +
                    UserProfile.Users.COLUMN_1 + " INTEGER PRIMARY KEY," +
                    UserProfile.Users.COLUMN_2 + " TEXT," +
                    UserProfile.Users.COLUMN_3 + " TEXT," +
                    UserProfile.Users.COLUMN_4 + " TEXT)";

    //@Override
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + UserProfile.Users.TABLE_NAME;

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);

    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }


    public Boolean addInfo(int ID, String username, String dob, String gender) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(UserProfile.Users.COLUMN_1, ID);
        values.put(UserProfile.Users.COLUMN_2, username);
        values.put(UserProfile.Users.COLUMN_3, dob);
        values.put(UserProfile.Users.COLUMN_4, gender);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(UserProfile.Users.TABLE_NAME, null, values);

        if(newRowId == 1)
            return true;
        else
            return false;
    }

    public Boolean updateInfor(int ID, String username, String dob, String gender){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(UserProfile.Users.COLUMN_1, ID);
        values.put(UserProfile.Users.COLUMN_2, username);
        values.put(UserProfile.Users.COLUMN_3, dob);
        values.put(UserProfile.Users.COLUMN_4, gender);

        int count = db.update(UserProfile.Users.TABLE_NAME, values, "_ID=?", new String[]{Integer.toString(ID)});

        if (count == 1)
            return true;
        else
            return false;
    }
}
