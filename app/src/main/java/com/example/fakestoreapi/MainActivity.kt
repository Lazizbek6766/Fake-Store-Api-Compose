package com.example.fakestoreapi

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.fakestoreapi.presentation.component.FirebaseMessagingNotificationPermissionDialog
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.ktx.messaging
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterial3Api
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: SplashViewModel by viewModels()
    @OptIn(ExperimentalPermissionsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)


        splashScreen.setKeepOnScreenCondition{viewModel.isLoading.value}

        setContent {
            val showNotificationDialog = remember { mutableStateOf(false) }

            // Android 13 Api 33 - runtime notification permission has been added
            val notificationPermissionState = rememberPermissionState(
                permission = Manifest.permission.POST_NOTIFICATIONS
            )
            if (showNotificationDialog.value) FirebaseMessagingNotificationPermissionDialog(
                showNotificationDialog = showNotificationDialog,
                notificationPermissionState = notificationPermissionState
            )

            LaunchedEffect(key1=Unit){
                if (notificationPermissionState.status.isGranted ||
                    Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU
                ) {
                    Firebase.messaging.subscribeToTopic("Tipiu")
                } else showNotificationDialog.value = true
            }
            MainScreen()
        }
    }
}