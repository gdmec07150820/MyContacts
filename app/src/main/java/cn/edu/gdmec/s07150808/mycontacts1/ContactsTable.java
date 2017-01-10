package cn.edu.gdmec.s07150808.mycontacts1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.Vector;


/**
 * Created by chen on 2016/10/21.
 */
public class ContactsTable {
    private final static String TABLENAME = "contactsTable";
    private MyDB db;

    public ContactsTable(Context context) {
        db = new MyDB(context);
        if (!db.isTableExits(TABLENAME)) {
            String tableSql = "CREATE TABLE IF NOT EXISTS " + TABLENAME + " (id_DB integer " + " primary key AUTOINCREMENT," +
                    User.NAME + " VARCHAR," + User.PHONE + " VARCHAR," + User.QQ + " VARCHAR," + User.ADDRESS + " VARCHAR," + User.WORKPLACE + " VARCHAR)";
            db.createTable(tableSql);
        }
    }

    public boolean addData(User user) {
        ContentValues values = new ContentValues();
        values.put(User.NAME, user.getName());
        values.put(User.PHONE, user.getPhone());
        values.put(User.QQ, user.getQq());
        values.put(User.ADDRESS, user.getAddress());
        values.put(User.WORKPLACE, user.getWorkplace());

        return db.save(TABLENAME, values);
    }
    /*public User[] findUserByKey(String key) {
        Vector<User> v = new Vector<User>();

        Cursor cursor = null;

        try {

            cursor = db.find("select * from " + TABLENAME + " where " + User.NAME + " like '%" + key + "%' " + " or " + User.PHONE + " like '%" + key + "'% " + " or " + User.QQ + " like '%" + key + "'% ", null);

            while (cursor.moveToNext()) {
                User temp = new User();

                temp.setId_DB(cursor.getInt(cursor.getColumnIndex("id_DB")));
                temp.setName(cursor.getString(cursor.getColumnIndex(User.NAME)));
                temp.setPhone(cursor.getString(cursor.getColumnIndex(User.PHONE)));
                temp.setQq(cursor.getString(cursor.getColumnIndex(User.QQ)));
                temp.setWorkplace(cursor.getString(cursor.getColumnIndex(User.WORKPLACE)));
                temp.setAddress(cursor.getString(cursor.getColumnIndex(User.ADDRESS)));

                v.add(temp);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.closeConnection();
        }
        if (v.size() > 0) {
            v.toArray(new User[]{});

        } else
        {
            User[] users = new User[1];
            User user = new User();
            user.setName("没有结果");
            users[0] = user;
            return users;
        }
    }*/
    public User getUserId(int id) {
        Cursor cursor = null;

        User temp = new User();

        try {
            cursor = db.find("select * from " + TABLENAME + " where " + " id_DB=? ", new String[]{id + ""});
            cursor.moveToNext();

            temp.setId_DB(cursor.getInt(cursor.getColumnIndex("id_DB")));
            temp.setName(cursor.getString(cursor.getColumnIndex(User.NAME)));
            temp.setPhone(cursor.getString(cursor.getColumnIndex(User.PHONE)));
            temp.setQq(cursor.getString(cursor.getColumnIndex(User.QQ)));
            temp.setWorkplace(cursor.getString(cursor.getColumnIndex(User.WORKPLACE)));
            temp.setAddress(cursor.getString(cursor.getColumnIndex(User.ADDRESS)));

            return temp;
        } catch (Exception e) {
          e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.closeConnection();
        }
        return null;
    }

    public boolean UpdateUser(User user) {
        ContentValues values = new ContentValues();

        values.put(user.NAME, user.getName());
        values.put(user.PHONE, user.getPhone());
        values.put(user.QQ, user.getQq());
        values.put(user.WORKPLACE, user.getWorkplace());
        values.put(user.ADDRESS, user.getAddress());

        return db.Update(TABLENAME, values, " id_DB=?", new String[]{user.getId_DB() + ""});
    }

    public User[] getAllUser() {
        Vector<User> v = new Vector<User>();

        Cursor cursor = null;
        try {
            User temp = new User();

            while (cursor.moveToNext()) {
                temp.setId_DB(cursor.getInt(cursor.getColumnIndex("id_DB")));
                temp.setName(cursor.getString(cursor.getColumnIndex(User.NAME)));
                temp.setPhone(cursor.getString(cursor.getColumnIndex(User.PHONE)));
                temp.setQq(cursor.getString(cursor.getColumnIndex(User.QQ)));
                temp.setWorkplace(cursor.getString(cursor.getColumnIndex(User.WORKPLACE)));
                temp.setAddress(cursor.getString(cursor.getColumnIndex(User.ADDRESS)));

                v.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }

            db.closeConnection();
        }
        if (v.size() > 0) {
            return v.toArray(new User[]{});
        } else {
            User[] users = new User[1];
            User user = new User();
            user.setName("没有结果");
            users[0] = user;
            return users;
        }
    }
    public User[] findUserByKey(String key) {
        Vector<User> v = new Vector<User>();

        Cursor cursor = null;
        try {
            cursor = db.find("select * from " + TABLENAME + " where " + User.NAME + " like '%" + key + "%' " + " or " + User.PHONE + " like '%" + key + "'% " + " or " + User.QQ + " like '%" + key + "'% ", null);

            while (cursor.moveToNext()) {
                User temp = new User();
                temp.setId_DB(cursor.getInt(cursor.getColumnIndex("id_DB")));
                temp.setName(cursor.getString(cursor.getColumnIndex(User.NAME)));
                temp.setPhone(cursor.getString(cursor.getColumnIndex(User.PHONE)));
                temp.setQq(cursor.getString(cursor.getColumnIndex(User.QQ)));
                temp.setWorkplace(cursor.getString(cursor.getColumnIndex(User.WORKPLACE)));
                temp.setAddress(cursor.getString(cursor.getColumnIndex(User.ADDRESS)));

                v.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }

            db.closeConnection();
        }
        if (v.size() > 0) {
            return v.toArray(new User[]{});
        } else {
            User[] users = new User[1];
            User user = new User();
            user.setName("没有结果");
            users[0] = user;
            return users;
        }
    }
    public boolean deleteByUser(User user){
        return  db.delete(TABLENAME," id_DB=?",new String[]{user.getId_DB()+""});
    }
}

