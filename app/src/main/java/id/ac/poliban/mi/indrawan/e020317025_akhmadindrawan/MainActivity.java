package id.ac.poliban.mi.indrawan.e020317025_akhmadindrawan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private final int REQUEST_CODE = 100;
    MhsActivity activity_mhs;
    String nim;
    String nama;
    String alamat;
    String telp;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1){
            if (resultCode == Activity.RESULT_OK) {
                if (data.getExtras() != null){

                    this.nim = data.getStringExtra("datanim");
                    this.nama = data.getStringExtra("datanama");
                    this.alamat = data.getStringExtra("dataalamat");
                    this.telp = data.getStringExtra("datatelp");
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btInput = findViewById(R.id.btInput);
        Button btData = findViewById(R.id.btData);

        btInput.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MhsActivity.class);
            startActivityForResult(intent, 1);
        });

        btData.setOnClickListener(v -> {
            new AlertDialog.Builder(this)
                    .setTitle("Info")
                    .setMessage("NIM : " + nim + "\n" +
                                "Nama : " + nama + "\n" +
                                "Alamat : " + alamat + "\n" +
                                "Telp : " + telp + "\n")
                    .setPositiveButton("Ok", null).show();
        });

    }
}
