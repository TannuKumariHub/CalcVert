package com.example.calcvert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.calcvert.databinding.ActivitySetNoBinding

class ArrangeNumberActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivitySetNoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.sortButton.setOnClickListener {
            val input = binding.inputNumbers.text.toString()

            if (input.isNotBlank()) {
                val numbers = input.split(",").map { it.trim().toInt() }.toSet().toList()
                val ascendingOrder = numbers.sorted().joinToString(", ")
                val descendingOrder = numbers.sortedDescending().joinToString(", ")

                binding.ascendingOrder.text = "Ascending Order: $ascendingOrder"
                binding.descendingOrder.text = "Descending Order: $descendingOrder"
            } else {
                binding.ascendingOrder.text = "Ascending Order: "
                binding.descendingOrder.text = "Descending Order: "
                showError("Please enter numbers.")
            }
        }

        binding.copyButton.setOnClickListener {
            val selectedOrderTextView = when {
                binding.ascendingRadioButton.isChecked -> binding.ascendingOrder
                binding.descendingRadioButton.isChecked -> binding.descendingOrder
                binding.bothRadioButton.isChecked -> {
                    val bothOrder =
                        "${binding.ascendingOrder.text}\n${binding.descendingOrder.text}"
                    val clipboardManager =
                        getSystemService(CLIPBOARD_SERVICE) as android.content.ClipboardManager
                    val clipData = android.content.ClipData.newPlainText("Both Orders", bothOrder)
                    clipboardManager.setPrimaryClip(clipData)
                    showToast("Both orders copied to clipboard")
                    return@setOnClickListener
                }
                else -> {
                    showError("Please select an order.")
                    return@setOnClickListener
                }
            }

            val selectedOrder = selectedOrderTextView.text.toString()

            val clipboardManager =
                getSystemService(CLIPBOARD_SERVICE) as android.content.ClipboardManager
            val clipData = android.content.ClipData.newPlainText("Selected Order", selectedOrder)
            clipboardManager.setPrimaryClip(clipData)

            showToast("Selected order copied to clipboard")
        }
    }

    private fun showError(message: String) {
        showToast("Error: $message")
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
