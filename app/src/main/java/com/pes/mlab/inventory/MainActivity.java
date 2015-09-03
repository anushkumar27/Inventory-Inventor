package com.pes.mlab.inventory;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    static int[] profit;
    static int[] sales;
    static int total = 0;
    public EditText productid;
    String pid;
    SQLiteDatabase inventory;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HandleClick hc = new HandleClick();
        productid = (EditText) findViewById(R.id.editText);
        //findViewById(R.id.butQR).setOnClickListener(hc);
        //findViewById(R.id.butProd).setOnClickListener(hc);
        findViewById(R.id.scan).setOnClickListener(hc);
        inventory = openOrCreateDatabase("inventory", Context.MODE_PRIVATE, null);

        inventory.execSQL("CREATE TABLE IF NOT EXISTS " + "inventory" + "(" +
                "`PID` TEXT," +
                "`barcode` INTEGER," +
                "`CP` INTEGER," +
                "`SP` INTEGER," +
                "`01day` TEXT," +
                "`02day` TEXT," +
                "`03day` TEXT," +
                "`04day` TEXT," +
                "`05day` TEXT," +
                "`06day` TEXT," +
                "`07day` TEXT," +
                "`08day` TEXT," +
                "`09day` TEXT," +
                "`10day` TEXT," +
                "`11day` TEXT," +
                "`12day` TEXT," +
                "`13day` TEXT," +
                "`14day` TEXT," +
                "`15day` TEXT," +
                "`16day` TEXT," +
                "`17day` TEXT," +
                "`18day` TEXT," +
                "`19day` TEXT," +
                "`20day` TEXT," +
                "`21day` TEXT" +
                ");");


        inventory.execSQL("INSERT INTO `inventory` VALUES ('1',1234,15,30,'50','45','44','42','40','39','37','35','33','32','30','28','25','24','23','20','15','13','12','10','9');");
        inventory.execSQL("INSERT INTO `inventory` VALUES ('2',1234567890,20,25,'65','59','55','50','45','43','42','40','35','33','32','30','28','25','24','20','18','15','10','5','4');");
        inventory.execSQL("INSERT INTO `inventory` VALUES ('3',15060123456783,24,50,'58','45','44','42','40','38','37','35','33','32','30','28','25','24','23','20','15','13','12','10','3');");
        inventory.execSQL("INSERT INTO `inventory` VALUES ('4',123456789012,25,50,'57','50','49','45','40','38','35','33','30','28','25','20','18','17','15','13','12','11','10','9','5');");
        inventory.execSQL("INSERT INTO `inventory` VALUES ('5',850006000012,90,100,'70','65','60','55','53','50','45','44','40','37','35','31','30','25','22','20','19','18','15','13','8');");
        inventory.execSQL("INSERT INTO `inventory` VALUES ('6',12345678905,99,120,'76','55','54','50','49','41','38','35','33','30','27','25','20','18','15','13','12','10','9','8','3');");
        inventory.execSQL("INSERT INTO `inventory` VALUES ('7',1234567890128,95,100,'60','49','45','40','39','35','33','30','25','24','23','20','18','15','13','12','10','9','8','5','3');");
        inventory.execSQL("INSERT INTO `inventory` VALUES ('8',16000660601,100,150,'59','50','49','45','42','37','35','33','30','25','25','20','18','17','15','13','12','11','10','9','5');");
        inventory.execSQL("INSERT INTO `inventory` VALUES ('9',36000291452,60,70,'55','39','38','34','33','30','26','25','24','23','21','17','15','13','12','10','9','6','4','3','2');");
        inventory.execSQL("INSERT INTO `inventory` VALUES ('10',850006000012,55,70,'65','59','55','50','45','43','45','42','35','33','32','30','28','25','24','20','18','15','10','5','4');");
        inventory.execSQL("INSERT INTO `inventory` VALUES ('11',22334545453,20,30,'70','65','60','55','53','50','45','44','40','37','35','31','30','25','22','20','19','18','15','13','8');");
        inventory.execSQL("INSERT INTO `inventory` VALUES ('12',5901234123457,15,30,'80','39','38','35','33','30','26','25','24','23','20','17','15','14','12','10','9','7','4','3','2');");
        inventory.execSQL("INSERT INTO `inventory` VALUES ('13',885909512263,15,30,'70','65','60','55','53','50','45','44','40','37','35','31','30','25','22','20','19','18','15','13','8');");
        inventory.execSQL("INSERT INTO `inventory` VALUES ('14',9781234567897,18,30,'57','55','54','50','49','41','38','35','33','30','27','25','20','18','15','13','12','10','9','8','3');");
        inventory.execSQL("INSERT INTO `inventory` VALUES ('15',9771473968012,18,30,'65','59','55','50','45','43','45','42','35','33','32','30','28','25','24','20','18','15','10','5','4');");
        inventory.execSQL("INSERT INTO `inventory` VALUES ('16',9780955716300,19,40,'60','50','49','45','42','37','35','33','30','25','25','20','18','17','15','13','12','11','10','9','5');");
        inventory.execSQL("INSERT INTO `inventory` VALUES ('17',188114771211,100,120,'70','65','60','55','53','50','45','44','40','37','35','31','30','25','22','20','19','18','15','13','8');");
        inventory.execSQL("INSERT INTO `inventory` VALUES ('18',9781556156786,60,100,'57','55','54','50','49','41','38','35','33','30','27','25','20','18','15','13','12','10','9','8','3');");
        inventory.execSQL("INSERT INTO `inventory` VALUES ('19',123456,50,60,'50','39','38','35','33','30','26','25','24','23','20','17','15','14','12','10','9','7','4','3','2');");
        inventory.execSQL("INSERT INTO `inventory` VALUES ('20',811204012344,30,50,'70','65','60','55','53','50','45','44','40','37','35','31','30','25','22','20','19','18','15','13','9');");


    }

    private class HandleClick implements OnClickListener {
        public void onClick(View arg0) {
            Intent intent = new Intent("com.google.zxing.client.android.SCAN");
            switch (arg0.getId()) {
                /*case R.id.butQR:
                    intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
                    break;
                case R.id.butProd:
                    intent.putExtra("SCAN_MODE", "PRODUCT_MODE");
                    break;*/
                case R.id.scan:
                    intent.putExtra("SCAN_FORMATS", "CODE_39,CODE_93,CODE_128,DATA_MATRIX,ITF,CODABAR,EAN_13,EAN_8,UPC_A,QR_CODE");
                    break;
            }
            startActivityForResult(intent, 0);//Barcode Scanner to scan for us
            overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                pid = intent.getStringExtra("SCAN_RESULT");
                System.out.println("************pid:" + pid);
                UPDATEINVENTORY(pid);
                Toast.makeText(getApplicationContext(), pid, Toast.LENGTH_LONG).show();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(getApplicationContext(), "Scan cancelled.", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void UPDATEINVENTORY(String pid) {

        String temp;
        Cursor c = inventory.rawQuery("SELECT * FROM inventory WHERE barcode='" + pid + "'", null);
        if (c.moveToFirst()) {
            //System.out.println("******last:"+c.getString(24));
            temp = c.getString(24);
            int foo = Integer.parseInt(temp);
            System.out.println("*********temp :" + temp + "  foo:" + foo);
            if (foo <= 2) {
                Toast.makeText(getApplicationContext(), "*****Inventory Running out!*****", Toast.LENGTH_LONG).show();
            }
            foo = foo - 1;
            inventory.execSQL("UPDATE inventory SET `21day` ='" + foo + "' WHERE barcode='" + pid + "'");
        } else {
            System.out.println("******error!!");
        }

    }


    public void BUTTONADD(View view) {
        ADD();
    }


    public void ADD() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Inventory");
        // Get the layout inflater
        builder.setCancelable(false);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.add_inventory, null);
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(dialogView);

        final NumberPicker productPicker = (NumberPicker) dialogView.findViewById(R.id.productpicker);
        productPicker.setMinValue(1);
        productPicker.setMaxValue(20);
        final NumberPicker numberPicker = (NumberPicker) dialogView.findViewById(R.id.numberpicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(10);

        // Add action buttons

        builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {


                System.out.println("***Product :" + productPicker.getValue());
                System.out.println("***Number :" + numberPicker.getValue());
                ADDINVENTORY(productPicker.getValue(), numberPicker.getValue());
                Toast.makeText(getApplicationContext(), "Inventory Updated :)", Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                dialog.dismiss();

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void ADDINVENTORY(int pid, int num) {

        String temp;
        Cursor c = inventory.rawQuery("SELECT * FROM inventory WHERE PID ='" + pid + "'", null);
        if (c.moveToFirst()) {
            //System.out.println("******last:"+c.getString(24));
            temp = c.getString(24);
            int foo = Integer.parseInt(temp);
            //System.out.println("*********temp :" + temp + "  foo:" + foo);
            foo = foo + num;
            inventory.execSQL("UPDATE inventory SET `21day` ='" + foo + "' WHERE PID ='" + pid + "'");
        } else {
            System.out.println("******error!!");
        }
    }

    public void VIEWINVENTORY(View view) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("View Inventory");
        builder.setMessage("Click Cancel to exit");
        // Get the layout inflater
        builder.setCancelable(false);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.view_inventory, null);
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(dialogView);

        final NumberPicker productPicker = (NumberPicker) dialogView.findViewById(R.id.productpicker);
        productPicker.setMinValue(1);
        productPicker.setMaxValue(20);

        // Add action buttons


        builder.setPositiveButton("Show", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                int product = productPicker.getValue();
                System.out.println("*****pid" + product);
                Cursor c = inventory.rawQuery("SELECT * FROM inventory WHERE pid='" + product + "'", null);
                if (c.moveToFirst()) {
                    System.out.println("*******update:" + c.getString(24));
                    Toast.makeText(getApplicationContext(), "Current Inventory: " + c.getString(24), Toast.LENGTH_LONG).show();

                }
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                dialog.dismiss();

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public void CALCINVENTORY(View view) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Calculate Inventory");
        builder.setMessage("Enter PID");
        // Get the layout inflater
        builder.setCancelable(false);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.view_inventory, null);
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(dialogView);

        final NumberPicker productPicker = (NumberPicker) dialogView.findViewById(R.id.productpicker);
        productPicker.setMinValue(1);
        productPicker.setMaxValue(20);

        // Add action buttons


        builder.setPositiveButton("Calculate", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                int product = productPicker.getValue();
                System.out.println("*****pid in Calc" + product);
                double sum = 0;
                Cursor c = inventory.rawQuery("SELECT * FROM inventory WHERE pid='" + product + "'", null);
                if (c.moveToFirst()) {
                    for (int j = 11; j < 24; j++) {
                        sum = sum + (Integer.parseInt(c.getString(j)) - Integer.parseInt(c.getString(j + 1)));
                        System.out.println("*******sum in loop:" + sum);
                    }
                    double d;
                    double k = 13;
                    d = Math.sqrt(2 * sum * k);
                    double h = Math.sqrt(0.8);
                    d = (d / h);
                    d = Math.round(d);
                    System.out.println("*******Q*:" + d);
                    Toast.makeText(getApplicationContext(), "Calculated Inventory: " + d, Toast.LENGTH_LONG).show();

                }
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                dialog.dismiss();

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public void VIEWSTATS(View view) {
        int sum = 0;
        int profititem = 0;
        profit = new int[22];


        for (int i = 1; i < 21; i++) {
            Cursor c = inventory.rawQuery("SELECT * FROM inventory WHERE pid='" + i + "'", null);
            if (c.moveToFirst()) {
                profititem = Integer.parseInt(c.getString(3)) - Integer.parseInt(c.getString(2));
                for (int j = 11; j < 24; j++) {
                    sum = sum + (Integer.parseInt(c.getString(j)) - Integer.parseInt(c.getString(j + 1)));
                    System.out.println("*******sum in loop:" + sum);
                }

            }
            profit[i] = profititem * sum;
            total = total + profit[i];
            profititem = 0;
            sum = 0;
        }

        Intent i = new Intent(this, GraphActivity.class);
        startActivity(i);
    }

    public void INTENT(View view) {

        productid.setText("1");
        String product = productid.getText().toString();
        int temp = Integer.parseInt(product);
        if (product.length() != 0 && (temp > 0 && temp < 20)) {

            System.out.println("*****pid" + product);

            sales = new int[100];
            int i = 1;
            Cursor c = inventory.rawQuery("SELECT * FROM inventory WHERE pid='" + temp + "'", null);
            if (c.moveToFirst()) {
                for (int j = 17; j < 24; j++) {
                    sales[i] = (Integer.parseInt(c.getString(j)) - Integer.parseInt(c.getString(j + 1)));
                    System.out.println(c.getString(j) + "" + c.getString(j + 1));
                    System.out.println("****Sales:" + sales[i]);
                    i++;
                }
                System.out.println("****i:" + i);
            }
            changeintent();
        } else {
            Toast.makeText(getApplicationContext(), "Enter PID BETWEEN 1 AND 20", Toast.LENGTH_LONG).show();
        }
    }

    public void changeintent() {
        Intent i = new Intent(this, LineActivity.class);
        startActivity(i);
    }


}