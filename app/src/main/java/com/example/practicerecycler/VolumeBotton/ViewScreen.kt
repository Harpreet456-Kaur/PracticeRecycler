package com.example.practicerecycler.VolumeBotton

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.practicerecycler.databinding.FragmentViewScreenBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ViewScreen : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentViewScreenBinding
    var receiver = Volume()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

            when (keyCode) {
                KeyEvent.KEYCODE_VOLUME_DOWN -> Toast.makeText(requireActivity(), "Volume Down Key Pressed", Toast.LENGTH_SHORT).show()
                KeyEvent.KEYCODE_VOLUME_UP -> Toast.makeText(requireActivity(), "Volume Up Key Pressed", Toast.LENGTH_SHORT).show()
                KeyEvent.KEYCODE_BACK -> Toast.makeText(requireActivity(), "Back Key Pressed", Toast.LENGTH_SHORT).show()
            }
            return true
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentViewScreenBinding.inflate(layoutInflater)

        IntentFilter(Intent.EXTRA_KEY_EVENT).also {
        }

//        val intentFilter = IntentFilter(AudioManager.ACTION_AUDIO_BECOMING_NOISY)


        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ViewScreen().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}