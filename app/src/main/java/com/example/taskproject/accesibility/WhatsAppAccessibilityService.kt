package com.example.taskproject.accesibility

import android.accessibilityservice.AccessibilityService
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.widget.Toast

class WhatsAppAccessibilityService : AccessibilityService() {

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        event?.let {
            if (it.packageName == "com.whatsapp"&& event.eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
                showToast("WhatsApp Launched.")
                Log.d("Pandey", "onAccessibilityEvent: watsaoppne")
            }
        }
    }

    override fun onInterrupt() {
        // Do nothing
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}