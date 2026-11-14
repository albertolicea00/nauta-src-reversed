package cu.etecsa.enp_oficial.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cu.etecsa.enp_oficial.g.b;

/**
 * Active session state model persisted in enp.db.
 *
 * @obfuscated_class cu.etecsa.enp_oficial.model.Session
 */
public class Session {
    private static Session instance;
    private SQLiteDatabase database;
    private b openHelper;

    private Session(Context context) {
        this.openHelper = new b(context);
    }

    public static Session getInstance(Context context) {
        if (instance == null) {
            instance = new Session(context);
        }
        return instance;
    }

    public boolean check_user_existence(String str) {
        Cursor cursorRawQuery = this.database.rawQuery("SELECT * FROM user WHERE user='" + str + "'", null);
        return (cursorRawQuery == null || cursorRawQuery.getCount() == 0) ? false : true;
    }

    public void close() {
        SQLiteDatabase sQLiteDatabase = this.database;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
    }

    public void delete_session(String str) {
        this.database.execSQL("DELETE FROM session WHERE id='" + str + "'");
    }

    public void delete_sessionfake(String str) {
        this.database.execSQL("DELETE FROM sessionfake WHERE id='" + str + "'");
    }

    public void delete_user(String str) {
        this.database.execSQL("DELETE FROM user WHERE user='" + str + "'");
    }

    public void deletetime(String str) {
        this.database.execSQL("DELETE FROM time WHERE id='" + str + "'");
    }

    public Cursor getSettings() {
        Cursor cursorRawQuery = this.database.rawQuery("SELECT * FROM settings", null);
        if (cursorRawQuery == null || cursorRawQuery.getCount() == 0) {
            return null;
        }
        cursorRawQuery.moveToFirst();
        return cursorRawQuery;
    }

    public String get_session_fake_id() {
        Cursor cursorRawQuery = this.database.rawQuery("SELECT * FROM sessionfake", null);
        if (cursorRawQuery == null || cursorRawQuery.getCount() == 0) {
            return null;
        }
        cursorRawQuery.moveToFirst();
        return cursorRawQuery.getString(0);
    }

    public String get_session_id() {
        Cursor cursorRawQuery = this.database.rawQuery("SELECT * FROM session", null);
        if (cursorRawQuery == null || cursorRawQuery.getCount() == 0) {
            return null;
        }
        cursorRawQuery.moveToFirst();
        return cursorRawQuery.getString(0);
    }

    public Cursor get_sessions() {
        Cursor cursorRawQuery = this.database.rawQuery("SELECT * FROM session", null);
        if (cursorRawQuery != null) {
            cursorRawQuery.moveToFirst();
        }
        return cursorRawQuery;
    }

    public Cursor get_sessionsfake() {
        Cursor cursorRawQuery = this.database.rawQuery("SELECT * FROM sessionfake", null);
        if (cursorRawQuery != null) {
            cursorRawQuery.moveToFirst();
        }
        return cursorRawQuery;
    }

    public String get_user_password(String str) {
        Cursor cursorRawQuery = this.database.rawQuery("SELECT * FROM user WHERE user='" + str + "'", null);
        if (cursorRawQuery == null || cursorRawQuery.getCount() == 0) {
            return null;
        }
        cursorRawQuery.moveToFirst();
        return cursorRawQuery.getString(2);
    }

    public Cursor get_users() {
        Cursor cursorRawQuery = this.database.rawQuery("SELECT * FROM user", null);
        if (cursorRawQuery != null) {
            cursorRawQuery.moveToFirst();
        }
        return cursorRawQuery;
    }

    public Cursor gettime() {
        Cursor cursorRawQuery = this.database.rawQuery("SELECT * FROM time", null);
        if (cursorRawQuery == null || cursorRawQuery.getCount() == 0) {
            return null;
        }
        cursorRawQuery.moveToFirst();
        return cursorRawQuery;
    }

    public void insert_user_credentials(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("user", str);
        contentValues.put("password", str2);
        this.database.insert("user", null, contentValues);
    }

    public void insert_user_session(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("remaining_time_url", str);
        contentValues.put("logout_url", str2);
        this.database.insert("session", null, contentValues);
    }

    public void insert_user_sessionfake(String str, String str2, String str3, String str4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("remaining_time_url", str);
        contentValues.put("logout_url", str2);
        contentValues.put("mac", str3);
        contentValues.put("date", str4);
        this.database.insert("sessionfake", null, contentValues);
    }

    public void insertseen() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("seen", Boolean.TRUE);
        this.database.insert("userterms", null, contentValues);
    }

    public void inserttime(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("time", str);
        this.database.insert("time", null, contentValues);
    }

    public void open() {
        this.database = this.openHelper.getWritableDatabase();
    }

    public boolean seen() {
        Cursor cursorRawQuery = this.database.rawQuery("SELECT * FROM userterms", null);
        return (cursorRawQuery == null || cursorRawQuery.getCount() == 0) ? false : true;
    }

    public void update_user_password(String str, String str2) {
        this.database.execSQL("UPDATE user SET password='" + str2 + "' WHERE user='" + str + "'");
    }

    public void updatesettingsdisconnect(boolean z) {
        this.database.execSQL("UPDATE settings SET disconnect='" + z + "' WHERE id='1'");
    }

    public void updatesettingsdownload(boolean z) {
        this.database.execSQL("UPDATE settings SET showdownload='" + z + "' WHERE id='1'");
    }

    public void updatesettingsremember(boolean z) {
        this.database.execSQL("UPDATE settings SET remember='" + z + "' WHERE id='1'");
    }

    public void updatesettingssignal(boolean z) {
        this.database.execSQL("UPDATE settings SET showsignal='" + z + "' WHERE id='1'");
    }

    public void updatesettingsupload(boolean z) {
        this.database.execSQL("UPDATE settings SET showupload='" + z + "' WHERE id='1'");
    }

    public void updatesettingswidget(boolean z) {
        this.database.execSQL("UPDATE settings SET showwidget='" + z + "' WHERE id='1'");
    }

    public void updatetime(String str, String str2) {
        this.database.execSQL("UPDATE time SET time='" + str + "' WHERE id='" + str2 + "'");
    }
}
