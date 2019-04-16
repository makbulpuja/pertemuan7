package mplakasana27.gmail.com;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editWaktu;
    Button tombolPlay, tombolStop;


    @Override
    //TODO 1: untuk membuat atau menuliskan id yang akan di buat.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO : mengambil data dari id yang telah kita buat di activity_main.xml
        editWaktu = (EditText) findViewById(R.id.et_waktu);
        tombolPlay = (Button) findViewById(R.id.bt_play);
        tombolStop = (Button) findViewById(R.id.bt_stop);
        tombolPlay.setOnClickListener(this);
        tombolStop.setOnClickListener(this);
    }
    //TODO 2 : digunakan untuk membuat click untuk tombol play dan stop dan menentukan waktunya dengan break
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_play:
                callPlay();
                break;
            case R.id.bt_stop:
                stopPlay();
                break;
        }
    }

    public void stopPlay() {
        //TODO 3 : fungsi yang di gunakan untuk menyetop musik yang di mainkan.
        stopService(new Intent(MainActivity.this, service.class));
    }

    public void callPlay() {
        // TODO 4 : mengambil data dari edit waktu dan akan diubah menjadi ke string.
        int detik = Integer.parseInt(editWaktu.getText().toString());

        Intent intent = new Intent(MainActivity.this, service.class);
        //TODO 5 : fungsi untuk menggunakan PendingIntent.
        PendingIntent pendingIntent = PendingIntent.getService(MainActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        // TODO 6 : digunakan untuk menghitung mudur alam yang akan kita masukan.
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        // TODO 7 : Merupakan fungsi dari alrm dengan menggunakan detik yang akan di masukan.
        if (alarmManager != null) {
            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (detik * 1000), pendingIntent);
            Toast.makeText(getApplicationContext(), "Song Play After" + detik + "second !", Toast.LENGTH_LONG).show();
        }
    }
}

