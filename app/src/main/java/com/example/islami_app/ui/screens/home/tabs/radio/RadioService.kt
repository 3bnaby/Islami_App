package com.example.islami_app.ui.screens.home.tabs.radio

import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.example.islami_app.R
import com.example.islami_app.ui.MyApplication

class RadioService:Service() {
    private val mediaPlayer = MediaPlayer()
    private var isMPPrepared = false
    private var name = ""

    companion object{
        const val NOTIFICATION_ID = 1
        const val ACTION = "action"
        const val PLAY = "play"
        const val PAUSE = "pause"
        const val STOP = "stop"
    }


    override fun onBind(intent: Intent?): IBinder? {
        return MyBinder()

    }

    inner class MyBinder: Binder(){
        fun getService():RadioService{
            return this@RadioService
        }

    }

    fun getPlaying() : Boolean{
        return mediaPlayer.isPlaying
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val urlToPlay = intent?.getStringExtra("url")
        val name = intent?.getStringExtra("name")
        if (urlToPlay != null && name != null){
            initMediaPlayer(urlToPlay, name)
        }
        val action = intent?.getStringExtra(ACTION)
        when(action){
            PLAY, PAUSE -> playPauseMediaPlayer()
            STOP -> stopMediaPlayer()
        }

        return super.onStartCommand(intent, flags, startId)
    }

    private fun stopMediaPlayer() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
            mediaPlayer.release()
        }

        }



     fun playPauseMediaPlayer() {
        if (!mediaPlayer.isPlaying){
            mediaPlayer.start()
        }
        else{
            mediaPlayer.start()
    }
        updateNotification()

    }





    private fun initMediaPlayer(urlToPlay : String, name :String){
        mediaPlayer.apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
            setDataSource(urlToPlay)
            prepareAsync()
            setOnPreparedListener{ mp ->
                isMPPrepared = true
                createNotification(name)

            }
        }
    }

    fun startMediaPlayer(){
        if (isMPPrepared){
            mediaPlayer.start()
        }
    }

    private fun createNotification(name:String){
        val remoteView = RemoteViews(packageName , R.layout.notifications_view)
        remoteView.setTextViewText(R.id.title , getString(R.string.app_name))
        remoteView.setTextViewText(R.id.title , name)
        remoteView.setImageViewResource(R.id.play_imv , if (mediaPlayer.isPlaying) R.drawable.pause_icon else R.drawable.play_icon)
        remoteView.setOnClickPendingIntent(R.id.play_imv , getPlayPendingIntent())


        var notification = NotificationCompat.Builder(this, MyApplication.RADIO_CHANNEL_ID)
            .setSmallIcon(R.drawable.icon_quran)
            .setCustomContentView(remoteView)
            .setStyle(NotificationCompat.DecoratedCustomViewStyle())
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .build()
        startForeground(NOTIFICATION_ID,notification )
    }
    private fun updateNotification() {
        val remoteView = RemoteViews(packageName , R.layout.notifications_view)
        remoteView.setTextViewText(R.id.title , getString(R.string.app_name))
        remoteView.setTextViewText(R.id.title , name)
        remoteView.setImageViewResource(R.id.play_imv , if (mediaPlayer.isPlaying) R.drawable.pause_icon else R.drawable.play_icon)
        remoteView.setOnClickPendingIntent(R.id.play_imv , getPlayPendingIntent())


        var notification = NotificationCompat.Builder(this, MyApplication.RADIO_CHANNEL_ID)
            .setSmallIcon(R.drawable.icon_quran)
            .setCustomContentView(remoteView)
            .setStyle(NotificationCompat.DecoratedCustomViewStyle())
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .build()
        startForeground(NOTIFICATION_ID,notification )

        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.notify(NOTIFICATION_ID , notification)

    }

    private fun getPlayPendingIntent(): PendingIntent? {
        val intent = Intent(this , RadioService::class.java)
        if (mediaPlayer.isPlaying)
            intent.putExtra(ACTION, PAUSE)
        else
            intent.putExtra(ACTION, PLAY)

        return PendingIntent.getService(this , 12 , intent ,PendingIntent.FLAG_IMMUTABLE )

    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        super.onTaskRemoved(rootIntent)
        stopMediaPlayer()
        stopForeground(STOP_FOREGROUND_REMOVE)
        stopSelf()

    }
}