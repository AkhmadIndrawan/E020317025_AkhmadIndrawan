package id.ac.poliban.mi.indrawan.e020317025_akhmadindrawan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MhsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mhs);

        EditText etNim = findViewById(R.id.etNim);
        EditText etNama = findViewById(R.id.etNama);
        EditText etAlamat = findViewById(R.id.etAlamat);
        EditText etTelp = findViewById(R.id.etTelp);
        Button btSend = findViewById(R.id.btSend);

        btSend.setOnClickListener(v -> {
            Intent intent = new Intent();
            String dataNim = etNim.getText().toString();
            String dataNama = etNama.getText().toString();
            String dataAlamat = etAlamat.getText().toString();
            String dataTelp = etTelp.getText().toString();

            intent.putExtra("datanim", dataNim);
            intent.putExtra("datanama", dataNama);
            intent.putExtra("dataalamat", dataAlamat);
            intent.putExtra("datatelp", dataTelp);

            setResult(Activity.RESULT_OK, intent);
            finish();
        });
    }
}
