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
    private Cursor mSearchNumbers;
    private Cursor mGetAllCartItems;
    private Cursor mGetALLPurchasedItems;

    // instantiating item type table variables
    public static final Integer DATABASE_VERSION = 1;
    ;
    public static final String PURCHASED_TABLE = "purchased_table_name";
    public static final String PURCHASED_ID = "purchased" +
            "_id";
    public static final String PURCHASED_NAME = "purchased_item_name";
    public static final String PURCHASED_DESCRIPTION = "purchased_item_description";
    public static final String PURCHASED_PRICE = "purchased_item_price";

    // instantiating item type table variables
    public static final String ITEM_TABLE = "item_table_name";
    public static final String ITEM_ID = "_id";
    public static final String ITEM_NAME = "item_name";
    public static final String ITEM_DESCRIPTION = "item_description";
    public static final String ITEM_PRICE = "item_price";
    public static final String ITEM_AREA = "item_area";

    // instantiating item type table variables
    public static final String CART_TABLE = "cart_table_name";
    public static final String CART_ID = "_id";
    public static final String CART_NAME = "cart_name";
    public static final String CART_DESCRIPTION = "cart_description";
    public static final String CART_PRICE = "cart_price";


    // making this activity a Singleton
    private DBHelper(Context context) {
        super(context, "db", null, DATABASE_VERSION);
    }

    private static DBHelper INSTANCE;

    public static synchronized DBHelper getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new DBHelper(context.getApplicationContext());
        }
        return INSTANCE;
    }

    // creating the tables
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " +
                ITEM_TABLE + " ( " +
                ITEM_ID + " INTEGER PRIMARY KEY NOT NULL, " +
                ITEM_NAME + " TEXT, " +
                ITEM_DESCRIPTION + " TEXT, " +
                ITEM_PRICE + " REAL, " +
                ITEM_AREA + " TEXT )");

        sqLiteDatabase.execSQL(" CREATE TABLE " +
                CART_TABLE + " (" +
                CART_ID + " INTEGER PRIMARY KEY NOT NULL, " +
                CART_NAME + " TEXT, " +
                CART_DESCRIPTION + " TEXT, " +
                CART_PRICE + " REAL ) ");

        sqLiteDatabase.execSQL("CREATE TABLE " +
                PURCHASED_TABLE + " ( " +
                PURCHASED_ID + " INTEGER PRIMARY KEY NOT NULL, " +
                PURCHASED_NAME + " TEXT, " +
                PURCHASED_DESCRIPTION + " TEXT, " +
                PURCHASED_PRICE + " INTEGER, " +
                CART_ID + " INTEGER, " +
                "FOREIGN KEY (" + CART_ID + ") REFERENCES " +
                CART_TABLE + " (" + PURCHASED_TABLE + ")) ");


        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('Red Apple', 'A red fruit', '2.00', 'Fruit')");
        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('2 Slone Square', '6 bedroom home with garden', '1750', 'Battersea')");
        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('Green Apple', 'A green fruit, very delicious', '2.00', 'Fruit')");
        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('10 Argyll Park', '1 bedroom home with garden', '1000', 'Battersea')");
        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('9 St. Jordan Street', '3 bedroom home with garden', '5500', 'Battersea')");
        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('2 Joal Court', '6 bedroom home with garden', '1230', 'Fulham')");
        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('10 Warren Road', '2 bedroom home with garden', '1520', 'Fulham')");
        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('Pulm', '1 bedroom home with garden','4500', 'Fruit')");
        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('Dragon Fruit', '3 bedroom home with garden', '4500', 'Fruit')");
        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('2 Eaton Square', '6 bedroom home with garden', '3550', 'Chelsea')");
        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('Kiwi', 'An edible berries of several species of woody vines in the genus Actinidia ', '3.00', 'Fruit')");
        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('50 loop Park', '1 bedroom home with garden', '2000', 'Battersea')");
        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('20 St. John Road', '3 bedroom home with garden', '1500', 'Fruit')");
        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('2 Joal Court', '6 bedroom home with garden', '1230', 'Fulham')");
        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('10 Warren Road', '2 bedroom home with garden', '1520', 'Fulham')");
        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ", " + ITEM_AREA + ")" + " VALUES " +
                "('5 Something Park', '1 bedroom home with garden','1500', 'Chelsea')");
    }

    public void addItemstoFirstPagerAdapter(String name, String description, String price, String placer) {
        SQLiteDatabase db = getWritableDatabase();
        String name2 = "'" + name + "'";
        String description2 = "'" + description + "'";
        String price2 = "'" + price + "'";
        String placer2 = "'" + price + "'";

        db.execSQL("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + ", " +
                ITEM_DESCRIPTION + ", " +
                ITEM_PRICE + ", " +
                ITEM_AREA + ")" +
                " VALUES " + "( " + name2 + ", " + description2 + ", " + price2 + ", " + placer2 +" )");
        db.close();
    }

    public void insertRow(ItemObject itemObject) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ITEM_NAME, itemObject.getmName());
        values.put(ITEM_DESCRIPTION, itemObject.getmDescription());
        values.put(ITEM_PRICE, itemObject.getmPrice());
        values.put(ITEM_AREA, itemObject.getmArea());
        db.insertOrThrow(ITEM_TABLE, null, values);
    }

    //    *******************************************

//   removing and recreating the tables

    //    *******************************************

    private static final String DELETE_ITEM_TABLE = " DROP TABLE IF EXISTS " + ITEM_TABLE;
    private static final String DELETE_CART_TABLE = " DROP TABLE IF EXISTS " + CART_TABLE;
    private static final String DELETE_ITEMS_BOUGHT_TABLE = "DROP TABLE IF EXISTS " + PURCHASED_TABLE;

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL(DELETE_ITEM_TABLE);
        sqLiteDatabase.execSQL(DELETE_CART_TABLE);
        sqLiteDatabase.execSQL(DELETE_ITEMS_BOUGHT_TABLE);
    }


//    *******************************************

//    query to get all items is below

//    *******************************************


    public List<ItemObject> getAllItems() {

        ArrayList<ItemObject> list = new ArrayList<>();
        ItemObject item = null;

        SQLiteDatabase db = getReadableDatabase();

        mitemCursor = db.query(ITEM_TABLE, null, null, null, null, null, null, null);
        if (mitemCursor.moveToFirst()) {
            while (!mitemCursor.isAfterLast()) {
                // collection of types
                String aName = mitemCursor.getString(mitemCursor.getColumnIndex(ITEM_NAME));
                String aDescription = mitemCursor.getString(mitemCursor.getColumnIndex(ITEM_DESCRIPTION));
                float aPrice = mitemCursor.getFloat(mitemCursor.getColumnIndex(ITEM_PRICE));
                // instantiate object ArrayList
                item = new ItemObject(aName, aDescription, aPrice);
                // add variables to the object ArrayList
                list.add(item);
                mitemCursor.moveToNext();
            }
        }
        return list;
    }


//   The 4 queries to receive all of one tab type are below

    public List<ItemObject> getBatterseaRentals() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<ItemObject> arrayList = new ArrayList<>();
        ItemObject object = null;

        String[] columns = {ITEM_ID, ITEM_NAME, ITEM_DESCRIPTION, ITEM_PRICE, ITEM_AREA};
        String[] value = {"Battersea"};
        String whereClause = " = ?";
        mitemCursor = db.query(ITEM_TABLE, columns, ITEM_AREA + whereClause, value, null, null, null, null);

        if (mitemCursor.moveToFirst()) {
            while (!mitemCursor.isAfterLast()) {
                // collection of types
                String aName = mitemCursor.getString(mitemCursor.getColumnIndex(ITEM_NAME));
                String aDescription = mitemCursor.getString(mitemCursor.getColumnIndex(ITEM_DESCRIPTION));
                float aPrice = mitemCursor.getFloat(mitemCursor.getColumnIndex(ITEM_PRICE));
                // instantiate object ArrayList
                object = new ItemObject(aName, aDescription, aPrice);
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

        String[] columns = {ITEM_ID, ITEM_NAME, ITEM_DESCRIPTION, ITEM_PRICE, ITEM_AREA};
        String[] value = {"Fulham"};
        String whereClause = " = ?";
        mitemCursor = db.query(ITEM_TABLE, columns, ITEM_AREA + whereClause, value, null, null, null, null);

        if (mitemCursor.moveToFirst()) {
            while (!mitemCursor.isAfterLast()) {
                // collection of types
                String aName = mitemCursor.getString(mitemCursor.getColumnIndex(ITEM_NAME));
                String aDescription = mitemCursor.getString(mitemCursor.getColumnIndex(ITEM_DESCRIPTION));
                float aPrice = mitemCursor.getFloat(mitemCursor.getColumnIndex(ITEM_PRICE));
                // instantiate object ArrayList
                object = new ItemObject(aName, aDescription, aPrice);
                // add variables to the object ArrayList
                arrayList.add(object);
                mitemCursor.moveToNext();
            }
        }
        return arrayList;
    }

    public List<ItemObject> getFruit() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<ItemObject> arrayList = new ArrayList<>();
        ItemObject object = null;

        String[] columns = {ITEM_ID, ITEM_NAME, ITEM_DESCRIPTION, ITEM_PRICE, ITEM_AREA};
        String[] value = {"Fruit"};
        String whereClause = " = ?";
        mitemCursor = db.query(ITEM_TABLE, columns, ITEM_AREA + whereClause, value, null, null, null, null);

        if (mitemCursor.moveToFirst()) {
            while (!mitemCursor.isAfterLast()) {
                // collection of types
                String aName = mitemCursor.getString(mitemCursor.getColumnIndex(ITEM_NAME));
                String aDescription = mitemCursor.getString(mitemCursor.getColumnIndex(ITEM_DESCRIPTION));
                float aPrice = mitemCursor.getFloat(mitemCursor.getColumnIndex(ITEM_PRICE));
                // instantiate object ArrayList
                object = new ItemObject(aName, aDescription, aPrice);
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

        String[] columns = {ITEM_ID, ITEM_NAME, ITEM_DESCRIPTION, ITEM_PRICE, ITEM_AREA};
        String[] value = {"Chelsea"};
        String whereClause = " = ?";
        mitemCursor = db.query(ITEM_TABLE, columns, ITEM_AREA + whereClause, value, null, null, null, null);

        if (mitemCursor.moveToFirst()) {
            while (!mitemCursor.isAfterLast()) {
                // collection of types
                String aName = mitemCursor.getString(mitemCursor.getColumnIndex(ITEM_NAME));
                String aDescription = mitemCursor.getString(mitemCursor.getColumnIndex(ITEM_DESCRIPTION));
                float aPrice = mitemCursor.getFloat(mitemCursor.getColumnIndex(ITEM_PRICE));
                // instantiate object ArrayList
                object = new ItemObject(aName, aDescription, aPrice);
                // add variables to the object ArrayList
                arrayList.add(object);
                mitemCursor.moveToNext();
            }
        }
        return arrayList;
    }


//   *******************************************

//  The 4 Query searches for each type are below

//   *******************************************


    public List<ItemObject> fruitQuerySearch(String query) {
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
                        ITEM_NAME + " LIKE '%"+ query +"%' OR " +
                        ITEM_DESCRIPTION + "  LIKE '%"+ query + "%' OR " +
                        ITEM_PRICE + " LIKE '%"+ query +"%' AND " +
                        ITEM_AREA + " = 'Fruit'"

                , null);

        if (mSearchNumbers.moveToFirst()) {
            while (!mSearchNumbers.isAfterLast()) {
                // collection of types
                String aName = mSearchNumbers.getString(mSearchNumbers.getColumnIndex(ITEM_NAME));
                String aDescription = mSearchNumbers.getString(mSearchNumbers.getColumnIndex(ITEM_DESCRIPTION));
                float aPrice = mSearchNumbers.getFloat(mSearchNumbers.getColumnIndex(ITEM_PRICE));
                // instantiate object ArrayList
                itemObject = new ItemObject(aName, aDescription, aPrice);
                // add variables to the object ArrayList
                arrayList.add(itemObject);
                mSearchNumbers.moveToNext();
            }
        }
        return arrayList;
    }


    public List<ItemObject> batterseaQuerySearch(String query) {
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
                        ITEM_NAME + " LIKE '%" + query + "%' OR " +
                        ITEM_DESCRIPTION + "  LIKE '%" + query + "%' OR " +
                        ITEM_PRICE + " LIKE '%" + query + "%' AND " +
                        ITEM_AREA + " = 'Battersea'"

                , null);

        if (mSearchNumbers.moveToFirst()) {
            while (!mSearchNumbers.isAfterLast()) {
                // collection of types
                String aName = mSearchNumbers.getString(mSearchNumbers.getColumnIndex(ITEM_NAME));
                String aDescription = mSearchNumbers.getString(mSearchNumbers.getColumnIndex(ITEM_DESCRIPTION));
                float aPrice = mSearchNumbers.getFloat(mSearchNumbers.getColumnIndex(ITEM_PRICE));
                // instantiate object ArrayList
                itemObject = new ItemObject(aName, aDescription, aPrice);
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

    public List<ItemObject> fulhamQuerySearch(String query) {
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
                        ITEM_NAME + " LIKE '%"+ query +"%' OR " +
                        ITEM_DESCRIPTION + "  LIKE '%" +query+" %' OR " +
                        ITEM_PRICE + " LIKE '%" + query + "%' AND " +
                        ITEM_AREA + " = 'Fulham'"

                , null);

        if (mSearchNumbers.moveToFirst()) {
            while (!mSearchNumbers.isAfterLast()) {
                // collection of types
                String aName = mSearchNumbers.getString(mSearchNumbers.getColumnIndex(ITEM_NAME));
                String aDescription = mSearchNumbers.getString(mSearchNumbers.getColumnIndex(ITEM_DESCRIPTION));
                float aPrice = mSearchNumbers.getFloat(mSearchNumbers.getColumnIndex(ITEM_PRICE));
                // instantiate object ArrayList
                itemObject = new ItemObject(aName, aDescription, aPrice);
                // add variables to the object ArrayList
                arrayList.add(itemObject);
                mSearchNumbers.moveToNext();
            }
        }
        return arrayList;
    }

    public List<ItemObject> chelseaQuerySearch(String query) {
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
                        ITEM_NAME + " LIKE '%"+ query + "%' OR " +
                        ITEM_DESCRIPTION + "  LIKE '%" + query +"%' OR " +
                        ITEM_PRICE + " LIKE '%"+ query +"%' AND " +
                        ITEM_AREA + " = 'Chelsea'"

                , null);

        if (mSearchNumbers.moveToFirst()) {
            while (!mSearchNumbers.isAfterLast()) {
                // collection of types
                String aName = mSearchNumbers.getString(mSearchNumbers.getColumnIndex(ITEM_NAME));
                String aDescription = mSearchNumbers.getString(mSearchNumbers.getColumnIndex(ITEM_DESCRIPTION));
                float aPrice = mSearchNumbers.getFloat(mSearchNumbers.getColumnIndex(ITEM_PRICE));
                // instantiate object ArrayList
                itemObject = new ItemObject(aName, aDescription, aPrice);
                // add variables to the object ArrayList
                arrayList.add(itemObject);
                mSearchNumbers.moveToNext();
            }
        }
        return arrayList;


    }

//    *******************************************

    //     Queries for the Shopping cart below
    //    Insert Clicked item to cart table

//    *******************************************


    public void addItemsFromClick(String name, String description, String price) {
        SQLiteDatabase db = getWritableDatabase();
        String name1 = "'" + name + "'";
        String description1 = "'" + description + "'";
        String price1 = "'" + price + "'";

        db.execSQL("INSERT INTO " + CART_TABLE + "(" + CART_NAME + ", " +
                CART_DESCRIPTION + ", " +
                CART_PRICE + ")" +
                " VALUES " + "( " + name1 + ", " + description1 + ", " + price1 + " )");
        db.close();
    }

    public Cursor getAllCartItems() {
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {CART_ID, CART_NAME, CART_DESCRIPTION, CART_PRICE};
        mGetAllCartItems = db.query(CART_TABLE, columns, null, null, null, null, null, null);
        return mGetAllCartItems;
    }

    public void removeCartItem(String id) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(
                "DELETE " +
                        " FROM " + CART_TABLE +
                        " WHERE " + CART_ID + " = " + id);
        db.close();
    }


//    Recently purchased items queries below

    public void addPurchasedItemsFromCheckout(String name, String description, String price) {
        SQLiteDatabase db = getWritableDatabase();
        String name1 = "'" + name + "'";
        String description1 = "'" + description + "'";
        String price1 = "'" + price + "'";

        db.execSQL("INSERT INTO " + PURCHASED_TABLE + "(" + PURCHASED_NAME + ", " +
                PURCHASED_DESCRIPTION + ", " +
                PURCHASED_PRICE + ")" +
                " VALUES " + "( " + name1 + ", " + description1 + ", " + price1 + " )");
        db.close();
    }

    public Cursor getPurchasedItems() {
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {PURCHASED_ID, PURCHASED_NAME, PURCHASED_DESCRIPTION, PURCHASED_PRICE};
        mGetALLPurchasedItems = db.query(PURCHASED_TABLE, columns, null, null, null, null, null, null);
        return mGetALLPurchasedItems;
    }


//    public ArrayList<String> getNames() {
//        SQLiteDatabase db = getReadableDatabase();
//        ArrayList arrayList = new ArrayList();
//        Cursor cursor = db.rawQuery("SELECT " + ITEM_NAME + " FROM " + ITEM_TABLE, null);
//        if (cursor.moveToFirst()) {
//            while (!cursor.isAfterLast()) {
//                arrayList.add(cursor.getString(cursor.getColumnIndex(ITEM_NAME)));
//                cursor.moveToNext();
//            }
//        }
//        cursor.close(); return arrayList;
//    }
//
//    public ArrayList<String> getPrices() {
//        SQLiteDatabase db = getReadableDatabase();
//        ArrayList arrayList = new ArrayList();
//        Cursor cursor = db.rawQuery("SELECT " + ITEM_PRICE + " FROM " + ITEM_TABLE, null);
//        if (cursor.moveToFirst()) {
//            while (!cursor.isAfterLast()) {
//                arrayList.add(cursor.getString(cursor.getColumnIndex(ITEM_PRICE)));
//                cursor.moveToNext();
//            }
//        }
//        cursor.close(); return arrayList;
//    }
//
//    public ArrayList<String> getDescriptions() {
//        SQLiteDatabase db = getReadableDatabase();
//        ArrayList arrayList = new ArrayList();
//        Cursor cursor = db.rawQuery("SELECT " + ITEM_DESCRIPTION + " FROM " + ITEM_TABLE, null);
//        if (cursor.moveToFirst()) {
//            while (!cursor.isAfterLast()) {
//                arrayList.add(cursor.getString(cursor.getColumnIndex(ITEM_DESCRIPTION)));
//                cursor.moveToNext();
//            }
//        }
//        cursor.close(); return arrayList;
//    }


}

