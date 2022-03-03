package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)


        rollButton.setOnClickListener {

            /**
             * creates a disappearing message that is seen after the button is clicked
             */
            val toast = Toast.makeText(this, "Hooray! - Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()

            // Do a dice roll when the app starts
            rollDice()
        }
    }

    /**
     * Roll the dice and update the screen with results
     */

    private fun rollDice() {

        //creating  dice objects with 6 sides each  and roll the dice
        val dice = Dice(6)
        val diceRoll = dice.roll()

        val dice2 = Dice(6)

        val dice2Roll = dice2.roll()


        // Find the image view in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        val diceImage2: ImageView = findViewById(R.id.imageView2)

        //displays image related to roll number for both dice
        val drawableResource = when (diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val drawableResource2 = when (dice2Roll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // update the image viewer with the correct drawable resource ID (image) for both dices
        diceImage.setImageResource(drawableResource)

        diceImage2.setImageResource(drawableResource2)

        //update the content description
        diceImage.contentDescription = diceRoll.toString()

        diceImage2.contentDescription = dice2Roll.toString()


        /**
         * Updating the screen with the second dice roll
         *
         *  val resultsTextView: TextView = findViewById(R.id.textView2)
            resultsTextView.text = dice2Roll.toString()

          */

    }

    class Dice(private val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}