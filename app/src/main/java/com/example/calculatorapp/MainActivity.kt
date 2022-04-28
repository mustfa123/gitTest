package com.example.calculatorapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
	private var input: TextView? = null


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		input = findViewById<TextView>(R.id.inPut)


	}


	var onAddTheDot: Boolean = false
	var listAddDot: Boolean = false

	fun onDigit(view: View) {
		input?.append((view as Button).text)
		onAddTheDot = true

	}


	fun equle(view: View) {
		var privix = ""


		if (onAddTheDot) {

			var finlText = input?.text.toString()
			try {
				if (finlText.startsWith("-")) {
					privix = "-"
					finlText = finlText.substring(1)

				}




				if (finlText.contains("-")) {
					val spldveule = finlText.split("-")
					var one = spldveule[0]
					val tow = spldveule[1]
					if (privix.isNotEmpty()) {
						one = privix + one
					}



					input?.text = removeZero((one.toDouble() - tow.toDouble()).toString())
				} else if (finlText.contains("+")) {
					val spldveule = finlText.split("+")
					var one = spldveule[0]
					val tow = spldveule[1]
					if (privix.isNotEmpty()) {
						one = privix + one
					}
					input?.text = removeZero((one.toDouble() + tow.toDouble()).toString())
				} else if (finlText.contains("/")) {
					val spldveule = finlText.split("/")
					var one = spldveule[0]
					val tow = spldveule[1]
					if (privix.isNotEmpty()) {
						one = privix + one
					}
					input?.text = removeZero((one.toDouble() / tow.toDouble()).toString())
				} else if (finlText.contains("*")) {
					val spldveule = finlText.split("*")
					var one = spldveule[0]
					val tow = spldveule[1]
					if (privix.isNotEmpty()) {
						one = privix + one
					}
					input?.text = removeZero((one.toDouble() * tow.toDouble()).toString())
				}
				listAddDot = false

			} catch (e: java.lang.ArithmeticException) {
				e.printStackTrace()

			}

		}


	}

	fun removeZero(result: String): String {
		var value = result
		if (result.contains(".0")) {
			value = result.substring(0, result.length - 2)

		}
		return value
	}

	fun OnClr(view: View) {
		input?.text = ""

	}

	fun addOprter(view: View) {
		if (onAddTheDot && !onAddOprters(input?.text.toString())) {
			input?.append((view as Button).text)
			onAddTheDot = false
			listAddDot = true
		}

	}

	fun addDont(view: View) {
		if (onAddTheDot && listAddDot || input?.text?.contains(".") == false) {
			input?.append(".")
			onAddTheDot = false
			listAddDot = false

		}

	}

	fun onAddOprters(vule: String): Boolean {
		return if (vule.startsWith("-")) {
			false
		} else {
			vule.contains("+") ||
					vule.contains("-") ||
					vule.contains("/") ||
					vule.contains("*")
		}
	}


}

