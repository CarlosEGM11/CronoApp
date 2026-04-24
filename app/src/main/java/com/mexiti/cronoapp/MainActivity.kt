package com.mexiti.cronoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.mexiti.cronoapp.EstudianteViewModel

class MainActivity : ComponentActivity() {

    private val estudianteVM: EstudianteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PantallaPrincipal(estudianteVM)
        }
    }
}

