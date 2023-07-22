package com.example.taskproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Adapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskproject.adapter.PostAdapter
import com.example.taskproject.databinding.ActivityMainBinding
import com.example.taskproject.viewmodel.MainViewModel
import com.example.taskproject.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding :ActivityMainBinding
    private lateinit var adapter: PostAdapter
    private val REQUEST_ACCESSIBILITY = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        if (!isAccessibilityServiceEnabled()) {
            requestAccessibilityPermission()
        }

        if (supportFragmentManager.findFragmentById(R.id.container_fragment) == null) {
            val fragment = ContainerFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.container_fragment, fragment)
                .commit()
        }
        }

    private fun isAccessibilityServiceEnabled(): Boolean {
        val accessibilitySettings =
            Settings.Secure.getString(contentResolver, Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES)
        return accessibilitySettings?.contains(packageName) == true
    }

    private fun requestAccessibilityPermission() {
        val accessibilityIntent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
        startActivityForResult(accessibilityIntent, REQUEST_ACCESSIBILITY)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_ACCESSIBILITY) {
            // Check if the user granted the permission or not.
            // You can add further checks here if needed.
        }
    }
}
