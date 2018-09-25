package com.example.bilalakbar.android;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_close = (Button) findViewById(R.id.Close);

        final AlertDialog.Builder dialog_Box = new AlertDialog.Builder(MainActivity.this);
        dialog_Box.setTitle("Dialog Alert");
        dialog_Box.setMessage("Are you sure you want to quit");
        dialog_Box.setCancelable(false);

        dialog_Box.setPositiveButton("YES", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "You selected YES option", Toast.LENGTH_LONG).show();
                MainActivity.this.finish();
            }
        });


        dialog_Box.setNegativeButton("NO", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "You selected NO option", Toast.LENGTH_LONG).show();
                dialogInterface.cancel();
            }
        });

        btn_close.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                AlertDialog dialog_showable= dialog_Box.create();
                dialog_showable.show();
            }
        });


}


    public void btnClick(View view)
    {
        Intent i= new Intent(MainActivity.this,MainActivity2.class);
        startActivity(i);
    }



}
