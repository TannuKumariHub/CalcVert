package com.example.calcvert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

data class ExchangeRateResponse(
    val result: String,
    val documentation: String,
    val terms_of_use: String,
    val time_last_update_unix: Long,
    val time_last_update_utc: String,
    val time_next_update_unix: Long,
    val time_next_update_utc: String,
    val base_code: String,
    val conversion_rates: Map<String, Double>
)

interface ExchangeRateApi {
    @GET("latest/{baseCurrency}")
    suspend fun getExchangeRates(@Path("baseCurrency") baseCurrency: String): retrofit2.Response<ExchangeRateResponse>
}

class CurrencyConverter : AppCompatActivity() {

    private lateinit var baseCurrencySpinner: Spinner
    private lateinit var targetCurrencySpinner: Spinner
    private lateinit var amountEditText: EditText
    private lateinit var resultTextView: TextView
    private lateinit var convertButton: Button

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://v6.exchangerate-api.com/v6/f39abf3a20f4551e2305052e/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val exchangeRateApi = retrofit.create(ExchangeRateApi::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency_converter)
        baseCurrencySpinner = findViewById(R.id.baseCurrencySpinner)
        targetCurrencySpinner = findViewById(R.id.targetCurrencySpinner)
        amountEditText = findViewById(R.id.amountEditText)
        resultTextView = findViewById(R.id.resultTextView)
        convertButton = findViewById(R.id.convertButton)

        // Set up the adapter for spinners
        val currencyAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.currencies,
            android.R.layout.simple_spinner_item
        )
        currencyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        baseCurrencySpinner.adapter = currencyAdapter
        targetCurrencySpinner.adapter = currencyAdapter

        convertButton.setOnClickListener {
            val amount = amountEditText.text.toString().toDoubleOrNull() ?: 0.0
            val baseCurrency = baseCurrencySpinner.selectedItem.toString()
                .split(" ")[0] // Extracting currency code
            val targetCurrency = targetCurrencySpinner.selectedItem.toString()
                .split(" ")[0] // Extracting currency code

            Log.d("Conversion", "Amount: $amount, Base: $baseCurrency, Target: $targetCurrency")

            GlobalScope.launch(Dispatchers.Main) {
                val result = convertCurrency(amount, baseCurrency, targetCurrency)
                resultTextView.text = getString(R.string.converted_result, result, targetCurrency)
            }
        }
    }

    private suspend fun convertCurrency(
        amount: Double,
        baseCurrency: String,
        targetCurrency: String
    ): Double {
        return withContext(Dispatchers.IO) {
            try {
                val response = exchangeRateApi.getExchangeRates(baseCurrency)

                if (response.isSuccessful) {
                    val exchangeRateResponse = response.body()
                    if (exchangeRateResponse != null && exchangeRateResponse.conversion_rates != null && exchangeRateResponse.conversion_rates.isNotEmpty()) {
                        val rates = exchangeRateResponse.conversion_rates

                        val conversionRate = rates[targetCurrency] ?: 1.0
                        return@withContext amount * conversionRate
                    } else {
                        println("Rates map is null or empty.")
                    }
                } else {
                    println("HTTP Error: ${response.code()}")
                    println("Response Body: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                println("Exception: ${e.message}")
            }
            return@withContext 0.0
        }
    }
}