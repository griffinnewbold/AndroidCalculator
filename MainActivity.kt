package griffin.appdev.calculatorForAppStore

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.*
import java.io.*

class MainActivity : AppCompatActivity() {
    //global variables
    var stringOfText = "";
    var isEquated = false;
    var resultingValue = "";
    var isDegreeMode = true;
    var isSwapped = false;
    var isFactorial = false;
    var numberArray = arrayOf("", "", "");

    //default function for app launch
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //------------scoped variables--------------------\\
        val viewBackground = findViewById<View>(R.id.viewBackground);
        val txtResult = findViewById<TextView>(R.id.txtResult);
        val btnOne = findViewById<Button>(R.id.btnOne);
        val btnZero = findViewById<Button>(R.id.btnZero);
        val btnTwo = findViewById<Button>(R.id.btnTwo);
        val btnThree = findViewById<Button>(R.id.btnThree);
        val btnFour = findViewById<Button>(R.id.btnFour);
        val btnFive = findViewById<Button>(R.id.btnFive);
        val btnSix = findViewById<Button>(R.id.btnSix);
        val btnSeven = findViewById<Button>(R.id.btnSeven);
        val btnEight = findViewById<Button>(R.id.btnEight);
        val btnNine = findViewById<Button>(R.id.btnNine);
        val btnDecimal = findViewById<Button>(R.id.btnDecimal);
        val txtAnswerType = findViewById<TextView>(R.id.txtAnswerType);
        val btnClear = findViewById<Button>(R.id.btnClear);
        val btnAdd = findViewById<Button>(R.id.btnAdd);
        val btnSubtract = findViewById<Button>(R.id.btnSubtract);
        val btnMultiply = findViewById<Button>(R.id.btnMultiply);
        val btnDivision = findViewById<Button>(R.id.btnDivision);
        val btnEqual = findViewById<Button>(R.id.btnEqual);
        val btnFactorial = findViewById<Button>(R.id.btnFactorial);
        val btnExponent = findViewById<Button>(R.id.btnExponent);
        val btnSquareRoot = findViewById<Button>(R.id.btnSquareRoot);
        val btnLog = findViewById<Button>(R.id.btnLog);
        val btnNaturalLog = findViewById<Button>(R.id.btnNaturalLog);
        val btnSwap = findViewById<Button>(R.id.btnSwap);
        val btnSine = findViewById<Button>(R.id.btnSine);
        val btnCosine = findViewById<Button>(R.id.btnCosine);
        val btnTangent = findViewById<Button>(R.id.btnTangent);
        val btnEuler = findViewById<Button>(R.id.btnEuler);
        val btnDegree = findViewById<Button>(R.id.btnDegree);
        val btnNegate = findViewById<Button>(R.id.btnNegate);
        val btnPi = findViewById<Button>(R.id.btnPi);
        val btnPercent = findViewById<Button>(R.id.btnPercent);
        val btnSettings = findViewById<Button>(R.id.btnSettings);
        //--------------------------------------------------\\
        val intent = intent;
        var string: String? = ""
        var backgroundChange = intent.getBooleanExtra("STRING_NAME", false);
        //implementation of the settings button
        btnSettings.setOnClickListener {
            val intent = Intent(this, Settings::class.java);
            startActivity(intent);
        }
        //end of implementation of settings button
        //implementation of basic numbers and the decimal
        btnZero.setOnClickListener {
            checkForString()
            if (stringOfText.length != 10) {
                stringOfText += "0";
                txtResult.text = stringOfText;
            }
            if(backgroundChange){
                btnOne.setBackgroundColor(Color.RED);
            }
        }
        btnOne.setOnClickListener {
            checkForString()
            if (stringOfText.length != 10) {
                stringOfText += "1";
                txtResult.text = stringOfText;
            }
        }
        btnTwo.setOnClickListener {
            checkForString()
            if (stringOfText.length != 10) {
                stringOfText += "2";
                txtResult.text = stringOfText;
            }
        }
        btnThree.setOnClickListener {
            checkForString()
            if (stringOfText.length != 10) {
                stringOfText += "3";
                txtResult.text = stringOfText;
            }
        }
        btnFour.setOnClickListener {
            checkForString()
            if (stringOfText.length != 10) {
                stringOfText += "4";
                txtResult.text = stringOfText;
            }
        }
        btnFive.setOnClickListener {
            checkForString()
            if (stringOfText.length != 10) {
                stringOfText += "5";
                txtResult.text = stringOfText;
            }
        }
        btnSix.setOnClickListener {
            checkForString()
            if (stringOfText.length != 10) {
                stringOfText += "6";
                txtResult.text = stringOfText;
            }
        }
        btnSeven.setOnClickListener {
            checkForString()
            if (stringOfText.length != 10) {
                stringOfText += "7";
                txtResult.text = stringOfText;
            }
        }
        btnEight.setOnClickListener {
            checkForString()
            if (stringOfText.length != 10) {
                stringOfText += "8";
                txtResult.text = stringOfText;
            }
        }
        btnNine.setOnClickListener {
            checkForString()
            if (stringOfText.length != 10) {
                stringOfText += "9";
                txtResult.text = stringOfText;
            }
        }
        btnDecimal.setOnClickListener {
            if (stringOfText.length != 10 || stringOfText.isNotEmpty()) {
                stringOfText += ".";
                txtResult.text = stringOfText;
            }
        }

        //implementation of clear button and operators
        btnClear.setOnClickListener {
            txtResult.text = "";
            stringOfText = "";
            fileTester();
        }

        btnAdd.setOnClickListener {
            numberArray[0] = stringOfText;
            numberArray[1] = "+";
            stringOfText = "";
            txtResult.text = "+";
        }

        btnSubtract.setOnClickListener {
            numberArray[0] = stringOfText;
            numberArray[1] = "-";
            stringOfText = "";
            txtResult.text = "-";
        }

        btnMultiply.setOnClickListener {
            numberArray[0] = stringOfText;
            numberArray[1] = "*";
            stringOfText = "";
            txtResult.text = "x";
        }

        btnDivision.setOnClickListener {
            numberArray[0] = stringOfText;
            numberArray[1] = "/";
            stringOfText = "";
            txtResult.text = "÷";
        }

        btnFactorial.setOnClickListener {
            numberArray[0] = stringOfText;
            numberArray[1] = "!";
            numberArray[2] = "1";
            stringOfText = "";
            txtResult.text = "!";
        }

        btnExponent.setOnClickListener {
            numberArray[0] = stringOfText;
            numberArray[1] = "^";
            stringOfText = "";
            txtResult.text = "^";
        }
        //End of Implementation of Clear and operators

        //Beginning of Implementation of Secondary buttons and constants
        btnPi.setOnClickListener {
            if (stringOfText.length != 10) {
                if (stringOfText.length == 0) {
                    stringOfText += "3.14159265";
                    txtResult.text = stringOfText;
                } else {
                    numberArray[0] = stringOfText;
                    numberArray[1] = "*";
                    numberArray[2] = "3.141592653589"
                    resultingValue =
                        (numberArray[0].toDouble() * numberArray[2].toDouble()).toString();
                    txtResult.text = resultingValue.substring(0, 11);
                    stringOfText = txtResult.text.toString();
                    numberArray[0] = stringOfText;
                }
            }
        }

        btnEuler.setOnClickListener {
            if (stringOfText.length != 10) {
                if (stringOfText.length == 0) {
                    stringOfText += "2.71828";
                    txtResult.text = stringOfText;
                } else {
                    numberArray[0] = stringOfText;
                    numberArray[1] = "*";
                    numberArray[2] = "2.718281828"
                    resultingValue =
                        (numberArray[0].toDouble() * numberArray[2].toDouble()).toString();
                    txtResult.text = resultingValue.substring(0, 11);
                    stringOfText = txtResult.text.toString();
                    numberArray[0] = stringOfText;
                }
            }
        }

        btnDegree.setOnClickListener {
            isDegreeMode = !isDegreeMode;
            if (isDegreeMode) {
                btnDegree.text = "RAD";
                txtAnswerType.text = "DEG"
            } else {
                btnDegree.text = "DEG";
                txtAnswerType.text = "RAD";
            }
        }
        btnSwap.setOnClickListener {
            if (isSwapped) {
                btnSine.text = "sin";
                btnCosine.text = "cos";
                btnTangent.text = "tan";
                isSwapped = false;
            } else {
                btnSine.text = "csc";
                btnCosine.text = "sec";
                btnTangent.text = "cot";
                isSwapped = true;
            }

        }

        btnSquareRoot.setOnClickListener {
            if(stringOfText == ""){
                numberArray[0] = "1";
            }else{
                numberArray[0] = stringOfText;
            }
            numberArray[1] = "√"
            stringOfText = "";
            txtResult.text = "√"
        }

        btnLog.setOnClickListener {
            if(stringOfText == ""){
                numberArray[0] = "1";
            }else{
                numberArray[0] = stringOfText;
            }
            numberArray[1] = "log";
            stringOfText = "";
            txtResult.text = "log";
        }

        btnNaturalLog.setOnClickListener {
            if(stringOfText == ""){
                numberArray[0] = "1";
            }else{
                numberArray[0] = stringOfText;
            }
            numberArray[1] = "ln";
            stringOfText = "";
            txtResult.text = "ln";
        }

        btnSine.setOnClickListener {
            if(stringOfText == ""){
                numberArray[0] = "1";
            }else{
                numberArray[0] = stringOfText;
            }
            if (isSwapped) {
                numberArray[1] = "csc";
                txtResult.text = "csc";
            } else {
                numberArray[1] = "sin";
                txtResult.text = "sin";
            }
            stringOfText = "";
        }

        btnCosine.setOnClickListener {
            if(stringOfText == ""){
                numberArray[0] = "1";
            }else{
                numberArray[0] = stringOfText;
            }
            if (isSwapped) {
                numberArray[1] = "sec";
                txtResult.text = "sec";
            } else {
                numberArray[1] = "cos";
                txtResult.text = "cos";
            }
            stringOfText = "";
        }

        btnTangent.setOnClickListener {
            if(stringOfText == ""){
                numberArray[0] = "1";
            }else{
                numberArray[0] = stringOfText;
            }
            if (isSwapped) {
                numberArray[1] = "cot";
                txtResult.text = "cot";
            } else {
                numberArray[1] = "tan";
                txtResult.text = "tan";
            }
            stringOfText = "";
        }

        btnPercent.setOnClickListener {
            txtResult.text = (stringOfText.toDouble() / 100.00).toString();
            stringOfText = txtResult.text.toString();
            numberArray[0] = stringOfText;
            isEquated = true;
        }

        btnNegate.setOnClickListener {
            resultingValue = (stringOfText.toDouble() * -1).toString();
            formatNumberForDisplay();
            txtResult.text = resultingValue;
            stringOfText = txtResult.text.toString();
        }

        //end of implementation of secondary buttons and constants

        //Beginning of Implementation of Equals button
        btnEqual.setOnClickListener {
            if (numberArray[0] != "" || numberArray[2] != "") {
                isEquated = true;
                numberArray[2] = stringOfText;
                if (numberArray[1].equals("+")) {
                    resultingValue =
                        (numberArray[0].toDouble() + numberArray[2].toDouble()).toString();

                }
                if (numberArray[1].equals("-")) {
                    resultingValue =
                        (numberArray[0].toDouble() - numberArray[2].toDouble()).toString();
                }
                if (numberArray[1].equals("*")) {
                    resultingValue =
                        (numberArray[0].toDouble() * numberArray[2].toDouble()).toString();
                }
                if (numberArray[1].equals("/")) {
                    resultingValue =
                        (numberArray[0].toDouble() / numberArray[2].toDouble()).toString();
                }
                if (numberArray[1].equals("!")) {
                    var startVal = numberArray[0].toInt();
                    var factorial = 1;
                    while (startVal != 1) {
                        factorial *= startVal;
                        startVal--;
                    }
                    resultingValue = factorial.toString();
                    isFactorial = true;
                }

                if (numberArray[1].equals("^")) {
                    resultingValue =
                        numberArray[0].toDouble().pow(numberArray[2].toDouble()).toString();
                }
                if (numberArray[1].equals("√")) {
                    if (numberArray[0] == "") {
                        resultingValue = sqrt(numberArray[2].toDouble()).toString();
                    } else {
                        resultingValue =
                            (numberArray[0].toDouble() * sqrt(numberArray[2].toDouble())).toString();
                    }
                }
                if (numberArray[1].equals("log")) {
                    if (numberArray[0] == "") {
                        resultingValue = log10(numberArray[2].toDouble()).toString();
                    } else {
                        resultingValue =
                            (numberArray[0].toDouble() * log10(numberArray[2].toDouble())).toString();
                    }
                }
                if (numberArray[1].equals("ln")) {
                    if (numberArray[0] == "") {
                        resultingValue = ln(numberArray[2].toDouble()).toString();
                    } else {
                        resultingValue =
                            (numberArray[0].toDouble() * ln(numberArray[2].toDouble())).toString();
                    }
                }
                if (numberArray[1].equals("sin")) {
                    if (isDegreeMode) {
                        numberArray[2] = Math.toRadians(numberArray[2].toDouble()).toString()
                    }
                    resultingValue = if (numberArray[0].equals("")) {
                        (sin(numberArray[2].toDouble())).toString();
                    } else {
                        (numberArray[0].toDouble() * (sin(numberArray[2].toDouble()))).toString();
                    }
                }
                if (numberArray[1].equals("cos")) {
                    if (isDegreeMode) {
                        numberArray[2] = Math.toRadians(numberArray[2].toDouble()).toString()
                    }
                    resultingValue = if (numberArray[0].equals("")) {
                        (cos(numberArray[2].toDouble())).toString();
                    } else {
                        (numberArray[0].toDouble() * (cos(numberArray[2].toDouble()))).toString();
                    }
                }
                if (numberArray[1].equals("tan")) {
                    if (isDegreeMode) {
                        numberArray[2] = Math.toRadians(numberArray[2].toDouble()).toString()
                    }
                    resultingValue = if (numberArray[0].equals("")) {
                        (tan(numberArray[2].toDouble())).toString();
                    } else {
                        (numberArray[0].toDouble() * (tan(numberArray[2].toDouble()))).toString();
                    }
                }

                if (numberArray[1].equals("csc")) {
                    if (isDegreeMode) {
                        numberArray[2] = Math.toRadians(numberArray[2].toDouble()).toString()
                    }
                    resultingValue = if (numberArray[0].equals("")) {
                        (1 / (sin(numberArray[2].toDouble()))).toString();
                    } else {
                        (numberArray[0].toDouble() * (1 / (sin(numberArray[2].toDouble())))).toString();
                    }
                }
                if (numberArray[1].equals("sec")) {
                    if (isDegreeMode) {
                        numberArray[2] = Math.toRadians(numberArray[2].toDouble()).toString()
                    }
                    resultingValue = if (numberArray[0].equals("")) {
                        (1 / (cos(numberArray[2].toDouble()))).toString();
                    } else {
                        (numberArray[0].toDouble() * (1 / (cos(numberArray[2].toDouble())))).toString();
                    }
                }
                if (numberArray[1].equals("cot")) {
                    if (isDegreeMode) {
                        numberArray[2] = Math.toRadians(numberArray[2].toDouble()).toString()
                    }
                    resultingValue = if (numberArray[0].equals("")) {
                        (1 / (tan(numberArray[2].toDouble()))).toString();
                    } else {
                        (numberArray[0].toDouble() * (1 / (tan(numberArray[2].toDouble())))).toString();
                    }
                }
                if(!isFactorial){
                    formatNumberForDisplay();
                }else{
                    isFactorial = false;
                }
                if (resultingValue.length > 9) {
                    txtResult.text = resultingValue.substring(0, 10);
                } else {
                    txtResult.text = resultingValue;
                }
                stringOfText = txtResult.text.toString();
                numberArray[0] = stringOfText;
            }else{
                txtResult.text = "Error";
            }
        }

    }

    //function to format strings for the display
    fun formatNumberForDisplay() {
        var valueAsDoubleHigh = ceil((resultingValue.toDouble()));
        var valueAsDoubleLow = floor((resultingValue.toDouble()));
        if(valueAsDoubleHigh - valueAsDoubleLow == 0.0){
            var counter = 0;
            var tempString = "";
            while(resultingValue.get(counter) != '.'){
                tempString += resultingValue.get(counter);
                counter++;
            }
            resultingValue = tempString;
        }
    }

    //checks for strings present after clicking equal
    fun checkForString() {
        if (isEquated) {
            if (stringOfText.length > 0) {
                stringOfText = "";
            }
        }
        isEquated = false;
    }

    fun fileTester(){
        try{
            val fileReader = FileReader("C:\\Users\\18643\\Desktop\\Calculator\\app\\src\\main\\res\\values\\colors.xml");
            val fileWriter = FileWriter("C:\\Users\\18643\\Desktop\\Calculator\\app\\src\\main\\res\\values\\test.xml")
            val bufferedReader = BufferedReader(fileReader);
            var s:String;
            while(bufferedReader.readLine() != null){
                s = bufferedReader.readLine();
                fileWriter.write(s+"\n");
                fileWriter.flush();
            }
            bufferedReader.close();
            fileWriter.close();
        }catch(e:IOException){
            e.printStackTrace();
        }
    }



}

