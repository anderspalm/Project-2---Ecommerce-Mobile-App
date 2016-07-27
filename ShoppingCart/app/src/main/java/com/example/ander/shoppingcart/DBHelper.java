package com.example.ander.shoppingcart;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class DBHelper extends SQLiteOpenHelper {


    private Cursor mitemCursor;
    private Cursor mEastLondonCursor;
    private Cursor mSearchNumbers;

    // instantiating item type table variables
    public static final Integer DATABASE_VERSION = 1;
            ;
//    public static final String TYPE_TABLE = "type_table_name";
//    public static final String TYPE_ID = "_id";
//    public static final String TYPE_NAME = "name";

    // instantiating item type table variables
    public static final String ITEM_TABLE = "item_table_name";
    public static final String ITEM_ID = "item_id";
    public static final String ITEM_NAME = "item_name";
    public static final String ITEM_DESCRIPTION = "item_description";
    public static final String ITEM_PRICE = "item_price";
    public static final String ITEM_AREA = "item_area";

    // instantiating item type table variables
    public static final String CART_TABLE = "cart_table_name";
    public static final String CART_ID = "cart_id";
    public static final String CART_NAME = "cart_name";
    public static final String CART_DESCRIPTION = "cart_description";
    public static final String CART_PRICE = "cart_price";


    // making this activity a Singleton
    private DBHelper(Context context) {
        super(context, "db", null, DATABASE_VERSION);
    }

    private static DBHelper INSTANCE;
    public static synchronized DBHelper getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = new DBHelper(context.getApplicationContext());
        }
        return INSTANCE;
    }

    // creating the tables
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        sqLiteDatabase.execSQL("CREATE TABLE " + TYPE_TABLE + " ( " +
//                TYPE_ID + " INTEGER PRIMARY KEY NOT NULL, " +
//                TYPE_NAME + " TEXT ) ");
        sqLiteDatabase.execSQL("CREATE TABLE " +
                ITEM_TABLE + " ( " +
                ITEM_ID + " INTEGER PRIMARY KEY NOT NULL, " +
                ITEM_NAME + " TEXT, " +
                ITEM_DESCRIPTION + " TEXT, " +
                ITEM_PRICE + " INTEGER, " +
                ITEM_AREA + " TEXT )");
//                ITEM_AREA + " INTEGER, " +
//                "FOREIGN KEY (" + TYPE_ID + ") REFERENCES " +
//                TYPE_TABLE + " (" + ITEM_TABLE + ")) ");
        sqLiteDatabase.execSQL(" CREATE TABLE " + CART_TABLE + " (" +
                CART_ID + " INTEGER PRIMARY KEY NOT NULL, " +
                CART_NAME + " TEXT, " +
                CART_DESCRIPTION + " TEXT, " +
                CART_PRICE + " INTEGER ) ");

        //adding values into table
//        sqLiteDatabase.execSQL("INSERT INTO " + TYPE_TABLE + "(" + TYPE_NAME + ") VALUES ('Kensington')");
//        sqLiteDatabase.execSQL("INSERT INTO " + TYPE_TABLE + "(" + TYPE_NAME + ") VALUES ('Chelsea')");
//        sqLiteDatabase.execSQL("INSERT INTO " + TYPE_TABLE + "(" + TYPE_NAME + ") VALUES ('Knightsbridge')");

        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('20 St. John Road', '3 bedroom home with garden', '1500', 'Knightsbridge')");
        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('2 Eaton Square', '6 bedroom home with garden', '1750', 'Chelsea')");
        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('90 Warrick Road', '2 bedroom home with garden', '3500', 'Knightsbridge')");
        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('50 trial Park', '1 bedroom home with garden', '1000', 'Battersea')");
        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('20 St. John Road', '3 bedroom home with garden', '5500', 'Knightsbridge')");
        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('2 Joal Court', '6 bedroom home with garden', '1230', 'Fulham')");
        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('10 Warren Road', '2 bedroom home with garden', '1520', 'Fulham')");
        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('5 Something Park', '1 bedroom home with garden','4500', 'Knightsbridge')");
        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('20 St. John Road', '3 bedroom home with garden', '4500', 'Knightsbridge')");
        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('2 Eaton Square', '6 bedroom home with garden', '3550', 'Chelsea')");
        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('90 Warrick Road', '2 bedroom home with garden', '1500', 'Knightsbridge')");
        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('50 loop Park', '1 bedroom home with garden', '2000', 'Battersea')");
        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('20 St. John Road', '3 bedroom home with garden', '1500', 'Knightsbridge')");
        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('2 Joal Court', '6 bedroom home with garden', '1230', 'Fulham')");
        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('10 Warren Road', '2 bedroom home with garden', '1520', 'Fulham')");
        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('5 Something Park', '1 bedroom home with garden','1500', 'Knightsbridge')");

    }

    // removing and recreating the tables
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//        sqLiteDatabase.execSQL(DELETE_TYPE_TABLE);
        sqLiteDatabase.execSQL(DELETE_ITEM_TABLE);
        sqLiteDatabase.execSQL(DELETE_CART_TABLE);
    }

    // creating removal methods for the tables
//    private static final String DELETE_TYPE_TABLE = " DROP TABLE IF EXISTS " + TYPE_TABLE;
    private static final String DELETE_ITEM_TABLE = " DROP TABLE IF EXISTS " + ITEM_TABLE;
    private static final String DELETE_CART_TABLE = " DROP TABLE IF EXISTS " + CART_TABLE;

    public ArrayList<String> getNames(){
        SQLiteDatabase db = getReadableDatabase();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = db.rawQuery("SELECT " + ITEM_NAME + " FROM " + ITEM_TABLE, null);
        if(cursor.moveToFirst()) {
            while(!cursor.isAfterLast()){
                arrayList.add(cursor.getString(cursor.getColumnIndex(ITEM_NAME)));
                cursor.moveToNext();
            }
        }
        cursor.close();
        return arrayList;
    }

    public ArrayList<String> getPrices(){
        SQLiteDatabase db = getReadableDatabase();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = db.rawQuery("SELECT " + ITEM_PRICE + " FROM " + ITEM_TABLE, null);
        if(cursor.moveToFirst()) {
            while(!cursor.isAfterLast()){
                arrayList.add(cursor.getString(cursor.getColumnIndex(ITEM_PRICE)));
                cursor.moveToNext();
            }
        }
        cursor.close();

        return arrayList;
    }

    public ArrayList<String> getDescriptions(){
        SQLiteDatabase db = getReadableDatabase();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = db.rawQuery("SELECT " + ITEM_DESCRIPTION + " FROM " + ITEM_TABLE, null);
        if(cursor.moveToFirst()) {
            while(!cursor.isAfterLast()){
                arrayList.add(cursor.getString(cursor.getColumnIndex(ITEM_DESCRIPTION)));
                cursor.moveToNext();
            }
        }
        cursor.close();

        return arrayList;
    }

    public List<ItemObject> getAllItems() {

        ArrayList<ItemObject> list = new ArrayList<>();
        ItemObject item = null;

        SQLiteDatabase db = getReadableDatabase();

        mitemCursor = db.query(ITEM_TABLE,null,null,null,null,null,null,null);
        if(mitemCursor.moveToFirst()){
            while (!mitemCursor.isAfterLast()){
                // collection of types
                String aName = mitemCursor.getString(mitemCursor.getColumnIndex(ITEM_NAME));
                String aDescription = mitemCursor.getString(mitemCursor.getColumnIndex(ITEM_DESCRIPTION));
                float aPrice = mitemCursor.getFloat(mitemCursor.getColumnIndex(ITEM_PRICE));
                // instantiate object ArrayList
                item = new ItemObject(aName,aDescription,aPrice);
                // add variables to the object ArrayList
                list.add(item);
                mitemCursor.moveToNext();
            }
        }
        return list;
    }

    public List<ItemObject> getBatterseaRentals() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<ItemObject> arrayList = new ArrayList<>();
        ItemObject object = null;

            String[] columns = {ITEM_ID, ITEM_NAME, ITEM_DESCRIPTION ,ITEM_PRICE, ITEM_AREA};
            String[] value = {"Battersea"};
            String whereClause = " = ?";
        mitemCursor = db.query(ITEM_TABLE,columns,ITEM_AREA + whereClause,value, null,null,null,null);

        if(mitemCursor.moveToFirst()){
            while (!mitemCursor.isAfterLast()){
                // collection of types
                String aName = mitemCursor.getString(mitemCursor.getColumnIndex(ITEM_NAME));
                String aDescription = mitemCursor.getString(mitemCursor.getColumnIndex(ITEM_DESCRIPTION));
                float aPrice = mitemCursor.getFloat(mitemCursor.getColumnIndex(ITEM_PRICE));
                // instantiate object ArrayList
                object = new ItemObject(aName,aDescription,aPrice);
                // add variables to the object ArrayList
                arrayList.add(object);
                mitemCursor.moveToNext();
            }
        }
        return arrayList;
    }

    public List<ItemObject> getFulhamRentals() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<ItemObject> arrayList = new ArrayList<>();
        ItemObject object = null;

        String[] columns = {ITEM_ID, ITEM_NAME, ITEM_DESCRIPTION ,ITEM_PRICE, ITEM_AREA};
        String[] value = {"Fulham"};
        String whereClause = " = ?";
        mitemCursor = db.query(ITEM_TABLE,columns,ITEM_AREA + whereClause,value, null,null,null,null);

        if(mitemCursor.moveToFirst()){
            while (!mitemCursor.isAfterLast()){
                // collection of types
                String aName = mitemCursor.getString(mitemCursor.getColumnIndex(ITEM_NAME));
                String aDescription = mitemCursor.getString(mitemCursor.getColumnIndex(ITEM_DESCRIPTION));
                float aPrice = mitemCursor.getFloat(mitemCursor.getColumnIndex(ITEM_PRICE));
                // instantiate object ArrayList
                object = new ItemObject(aName,aDescription,aPrice);
                // add variables to the object ArrayList
                arrayList.add(object);
                mitemCursor.moveToNext();
            }
        }
        return arrayList;
    }

    public List<ItemObject> getKnightsbridgeRentals() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<ItemObject> arrayList = new ArrayList<>();
        ItemObject object = null;

        String[] columns = {ITEM_ID, ITEM_NAME, ITEM_DESCRIPTION ,ITEM_PRICE, ITEM_AREA};
        String[] value = {"Knightsbridge"};
        String whereClause = " = ?";
        mitemCursor = db.query(ITEM_TABLE,columns,ITEM_AREA + whereClause,value, null,null,null,null);

        if(mitemCursor.moveToFirst()){
            while (!mitemCursor.isAfterLast()){
                // collection of types
                String aName = mitemCursor.getString(mitemCursor.getColumnIndex(ITEM_NAME));
                String aDescription = mitemCursor.getString(mitemCursor.getColumnIndex(ITEM_DESCRIPTION));
                float aPrice = mitemCursor.getFloat(mitemCursor.getColumnIndex(ITEM_PRICE));
                // instantiate object ArrayList
                object = new ItemObject(aName,aDescription,aPrice);
                // add variables to the object ArrayList
                arrayList.add(object);
                mitemCursor.moveToNext();
            }
        }
        return arrayList;
    }

    public List<ItemObject> getChelseaRentals() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<ItemObject> arrayList = new ArrayList<>();
        ItemObject object = null;

        String[] columns = {ITEM_ID, ITEM_NAME, ITEM_DESCRIPTION ,ITEM_PRICE, ITEM_AREA};
        String[] value = {"Chelsea"};
        String whereClause = " = ?";
        mitemCursor = db.query(ITEM_TABLE,columns,ITEM_AREA + whereClause,value, null,null,null,null);

        if(mitemCursor.moveToFirst()){
            while (!mitemCursor.isAfterLast()){
                // collection of types
                String aName = mitemCursor.getString(mitemCursor.getColumnIndex(ITEM_NAME));
                String aDescription = mitemCursor.getString(mitemCursor.getColumnIndex(ITEM_DESCRIPTION));
                float aPrice = mitemCursor.getFloat(mitemCursor.getColumnIndex(ITEM_PRICE));
                // instantiate object ArrayList
                object = new ItemObject(aName,aDescription,aPrice);
                // add variables to the object ArrayList
                arrayList.add(object);
                mitemCursor.moveToNext();
            }
        }
        return arrayList;
    }


    public List<ItemObject> searchNumbers(String query){
        SQLiteDatabase db = this.getReadableDatabase();
        ItemObject itemObject = null;
        ArrayList<ItemObject> arrayList = new ArrayList<>();

        mSearchNumbers = db.rawQuery("SELECT " +
                ITEM_ID + "," +
                ITEM_NAME + "," +
                ITEM_DESCRIPTION + "," +
                ITEM_PRICE + "," +
                ITEM_AREA +

                " FROM " +
                ITEM_TABLE +

                " WHERE " +
                ITEM_NAME + " LIKE '%query%' OR " +
                ITEM_DESCRIPTION + "  LIKE '%query%' OR " +
                ITEM_PRICE + " LIKE '%query%'"
                ,null);

        if(mSearchNumbers.moveToFirst()){
            while (!mSearchNumbers.isAfterLast()){
                // collection of types
                String aName = mSearchNumbers.getString(mSearchNumbers.getColumnIndex(ITEM_NAME));
                String aDescription = mSearchNumbers.getString(mSearchNumbers.getColumnIndex(ITEM_DESCRIPTION));
                float aPrice = mSearchNumbers.getFloat(mSearchNumbers.getColumnIndex(ITEM_PRICE));
                // instantiate object ArrayList
                itemObject = new ItemObject(aName,aDescription,aPrice);
                // add variables to the object ArrayList
                arrayList.add(itemObject);
                mSearchNumbers.moveToNext();
            }
        }
        return arrayList;

//        you can add a find the nearest number using the following
//        SELECT * FROM table
//        ORDER BY ABS(? - value)
//        LIMIT 1
    }

    /*
    get the information from the click
    set info items to variables
    add variables to DBhelper method
    method uses variables to find item
    method inserts same data into new table
     */

}
