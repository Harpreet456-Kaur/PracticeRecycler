package com.example.practicerecycler.VolumeBotton

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.practicerecycler.R


class Volume : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_view_screen)
        if (!checkAccessibilityPermission()) {
            Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
        }
    }
    fun checkAccessibilityPermission(): Boolean {
        var accessEnabled = 0
        try {
            accessEnabled =
                Settings.Secure.getInt(this.contentResolver, Settings.Secure.ACCESSIBILITY_ENABLED)
        } catch (e: Settings.SettingNotFoundException) {
            e.printStackTrace()
        }
        return if (accessEnabled == 0) {
            // if not construct intent to request permission
            val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            // request permission via start activity for result
            startActivity(intent)
            false
        } else {
            true
        }
    }

}