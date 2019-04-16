package mplakasana27.gmail.com;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;


public class service extends Service {
MediaPlayer mediaplayer;

    public service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    //TODO : mengambil data dari raw yang telah kita buat.
    public void onCreate() {
        mediaplayer = MediaPlayer.create( this, R.raw.lilly);
        mediaplayer.setLooping(true);
    }

    @Override
    //TODO : untuk memainkam musik yang di simpan.
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaplayer.start();
        return START_STICKY;
    }
    //TODO : Untuk menyetopkan musik yang kita play.
    public void onDestroy(){
        mediaplayer.stop();
    }
}
