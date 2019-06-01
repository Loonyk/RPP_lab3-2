package com.example.rpp_32.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.migration.Migration;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

@Database(entities = {Student.class}, version = 2)
@TypeConverters({TypeConverterDate.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract StudentDao getStudentDao();
    public abstract StudentTransaction getStudTransaction();
    private static AppDatabase database;

    public static final Migration MIGRATION_12 = new Migration(1,2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {

            database.execSQL("CREATE TABLE IF NOT EXISTS Students2" +
                    "(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "Surname TEXT," +
                    "FirstName TEXT," +
                    "LastName TEXT," +
                    "time_add INTEGER )"
            );
            Cursor cursor = database.query("SELECT id, FIO, time_add FROM Student", null);
            ContentValues cv = new ContentValues();
            if (cursor.moveToFirst()){
                do {
                    cv.clear();
                    cv.put("id", cursor.getInt(0));
                    String FIO = cursor.getString(1);
                    cv.put("Surname", FIO.substring(0, FIO.indexOf(' ')));
                    cv.put("FirstName", FIO.substring(FIO.indexOf(' ') + 1,
                            FIO.substring(FIO.indexOf(' ') +1 ).indexOf(' ')
                                    + FIO.indexOf(' ')+1));
                    cv.put("LastName",
                            FIO.substring(FIO.substring(FIO.indexOf(' ') + 1).indexOf(' ')
                            + FIO.indexOf(' ')+2));
                    cv.put("time_add", cursor.getLong(2));
                    database.insert("Students2", SQLiteDatabase.CONFLICT_ROLLBACK, cv);
                }while (cursor.moveToNext());
            }

            database.execSQL("DROP TABLE IF EXISTS Student");
            database.execSQL("ALTER TABLE Students2 RENAME TO Student");
            cursor.close();

        }
    };

    public static AppDatabase getDatabace(Context context) {
        if (database == null) {
            database = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "databace")
                    .addMigrations(MIGRATION_12)
                    .build();
        }

        return database;
    }
}
