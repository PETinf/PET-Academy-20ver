
package com.example.testepet.petacademy_20ver;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {
   // Button btnScan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        //btnScan = (Button) findViewById(R.id.btnScan);
        final Activity activity = this;

       // btnScan.setOnClickListener(new View.OnClickListener() {
        //    @Override
         //   public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Camera Scan");
                integrator.setCameraId(0);
                integrator.initiateScan();
                alert("Bem-vindo ao 20ver, aproxime a sua câmera da etiqueta contendo o QRcode para escutar informações sobre o vestuário");
        //    }
       // });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){
            if(result.getContents() != null){
                alert(result.getContents());
            }/*else{
                alert("Scan cancelado");
            }*/
        }else {

            super.onActivityResult(requestCode, resultCode, data);

        }
    }

    private void alert(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_main);
        final TextView helloTextView = (TextView) findViewById(R.id.Resposta);
        helloTextView.setText(msg);
        //Intent i = new Intent(this,MainActivity.class);

        //startActivity(i);

    }
}
