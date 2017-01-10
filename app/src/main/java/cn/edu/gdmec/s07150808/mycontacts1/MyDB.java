package cn.edu.gdmec.s07150808.mycontacts1;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by chen on 2016/10/21.
 */
public class MyDB  extends SQLiteOpenHelper {
    private static String DB_NAME = "My_DB.db";
    private static int DB_VERSION = 2;
    private SQLiteDatabase db;

    public MyDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db = getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public SQLiteDatabase openConnection() {
        if (!db.isOpen()) {
            db = getWritableDatabase();
        }
        return db;
    }

    public void closeConnection() {
        //数据打开状态下，将其关闭.函数ISOPEN是判断数据库的状态
        if (db!= null && db.isOpen()) {
            db.close();
        }
    }

    //创建表的函数。首先，调用数据库色打开函数，通过返回值判断数据库状态，SQL语句创建表结构。
  /*  public boolean setTable(String tablesql) {
        try {
            openConnection();
            db.execSQL(tablesql);
        } catch (Exception e) {
            e.printStackTrace();
            //创建表失败后，将其关闭.
            return false;
        } finally {
            closeConnection();
        }
        return true;
    }
*/
    //插入数据 参数为将插入的表对象,插入的属性
    public boolean save(String tableName, ContentValues values) {
        try {
            openConnection();
            db.insert(tableName, null, values);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            closeConnection();
        }
        return true;
    }

    //更新数据
    public boolean Update(String tableName, ContentValues values, String whereClause, String[] whereArgs) {
        try {
            openConnection();
            db.update(tableName, values, whereClause, whereArgs);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            closeConnection();
        }
        return true;
    }

    //删除数据，参数为 表对象 ，SQL删除语句
    public boolean delete(String tableName, String deleteSql, String obj[]) {
        try {
            openConnection();
            db.delete(tableName, deleteSql, obj);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            closeConnection();
        }
        return true;
    }
    public Cursor find(String findSql, String obj[] ) {
        try{
            openConnection();
            Cursor cursor=db.rawQuery(findSql,obj);
            return cursor;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public boolean isTableExits(String tableName){
         try{
             openConnection();
             String str="select count(*)xcount from "+tableName;
             db.rawQuery(str,null).close();
         }catch (Exception e){
             e.printStackTrace();
             return false;
         }finally {
             closeConnection();
         }
        return true;
    }

    public boolean createTable(String tablesql) {
        try {
            openConnection();
            db.execSQL(tablesql);
        } catch (Exception e) {
            e.printStackTrace();
            //创建表失败后，将其关闭.
            return false;
        } finally {
            closeConnection();
        }
        return true;
    }
}
