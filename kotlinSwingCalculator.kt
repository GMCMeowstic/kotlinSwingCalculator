/*
    Coded By GMCMarshy with emotional support from my boyfriend Frost
    -----------------------------------------------------------------
                               MIT License
                       Do whatever the fuck you want
 */

import java.awt.Color
import java.awt.Font
import java.awt.Toolkit
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JOptionPane
import javax.swing.SwingUtilities

var currentDisp = ""
var value1 = 0
var value2 = 0
var value3 = 0
var value4 = 0
var value5 = 0
var isADecimal = false
var isAnInteger = false
var numberOfVals = 0
val w = JFrame("calcGUI.kt")
val but1 = JButton("1")
val but2 = JButton("2")
val but3 = JButton("3")
val but4 = JButton("4")
val but5 = JButton("5")
val but6 = JButton("6")
val but7 = JButton("7")
val but8 = JButton("8")
val but9 = JButton("9")
val but0 = JButton("0")
val butClear = JButton("C")
val butBack = JButton("<X")
val butAdd = JButton("+")
val butSub = JButton("-")
val butMul = JButton("x")
val butDiv = JButton("/")
val butEnter = JButton("ENTER")
val butInt = JButton("+/-")
val butDecimal = JButton(".")
val disp = JLabel()
val inst = JLabel("<html>Press <font color='blue'>ENTER</font> to enter a<br>value<br>Press <font color='lime'>(+,-,x,/)</font> to<br>do calculate values.</html>")
fun main() {
    fun refresh() {
        disp.text = currentDisp
    }
    disp.apply {
        font = Font("Arial", Font.PLAIN, 50)
        setBounds(2,0,400,100)
    }
    butClear.apply {
        foreground = Color.RED
        font = Font("Arial", Font.BOLD, 50)
        setBounds(300,0,100,100)
    }
    butBack.apply {
        foreground = Color.RED
        font = Font("Arial", Font.BOLD, 50)
        setBounds(200,400,100,100)
    }
    butEnter.apply {
        foreground = Color.BLUE
        font = Font("Arial", Font.BOLD, 19)
        setBounds(0, 400, 100, 100)
    }

    butAdd.apply {
        foreground = Color.GREEN
        font = Font("Arial", Font.BOLD, 50)
        setBounds(300, 100, 100, 100)
    }

    butSub.apply {
        foreground = Color.GREEN
        font = Font("Arial", Font.BOLD, 50)
        setBounds(300, 200, 100, 100)
    }

    butMul.apply {
        foreground = Color.GREEN
        font = Font("Arial", Font.BOLD, 50)
        setBounds(300, 300, 100, 100)
    }

    butDiv.apply {
        foreground = Color.GREEN
        font = Font("Arial", Font.BOLD, 50)
        setBounds(300, 400, 100, 100)
    }

    but1.apply {
        font = Font("Arial", Font.BOLD, 50)
        setBounds(0, 100, 100, 100)
    }

    but2.apply {
        font = Font("Arial", Font.BOLD, 50)
        setBounds(100, 100, 100, 100)
    }

    but3.apply {
        font = Font("Arial", Font.BOLD, 50)
        setBounds(200, 100, 100, 100)
    }

    but4.apply {
        font = Font("Arial", Font.BOLD, 50)
        setBounds(0, 200, 100, 100)
    }

    but5.apply {
        font = Font("Arial", Font.BOLD, 50)
        setBounds(100, 200, 100, 100)
    }

    but6.apply {
        font = Font("Arial", Font.BOLD, 50)
        setBounds(200, 200, 100, 100)
    }

    but7.apply {
        font = Font("Arial", Font.BOLD, 50)
        setBounds(0, 300, 100, 100)
    }

    but8.apply {
        font = Font("Arial", Font.BOLD, 50)
        setBounds(100, 300, 100, 100)
    }

    but9.apply {
        font = Font("Arial", Font.BOLD, 50)
        setBounds(200, 300, 100, 100)
    }

    but0.apply {
        font = Font("Arial", Font.BOLD, 50)
        setBounds(100, 400, 100, 100)
    }

    butInt.apply {
        font = Font("Arial", Font.BOLD, 50)
        setBounds(0, 500, 100, 100)
    }

    butDecimal.apply {
        font = Font("Arial", Font.BOLD, 50)
        setBounds(100, 500, 100, 100)
    }
    inst.setBounds(210,375,150,350)
    but1.addActionListener { currentDisp += "1"; refresh() }
    but2.addActionListener { currentDisp += "2"; refresh() }
    but3.addActionListener { currentDisp += "3"; refresh() }
    but4.addActionListener { currentDisp += "4"; refresh() }
    but5.addActionListener { currentDisp += "5"; refresh() }
    but6.addActionListener { currentDisp += "6"; refresh() }
    but7.addActionListener { currentDisp += "7"; refresh() }
    but8.addActionListener { currentDisp += "8"; refresh() }
    but9.addActionListener { currentDisp += "9"; refresh() }
    but0.addActionListener { currentDisp += "0"; refresh() }
    butDecimal.addActionListener {
        if (isADecimal) errorSound()
        else {
            currentDisp += "."
            refresh()
            isADecimal = true
        }
    }
    butInt.addActionListener {
        if (isAnInteger) errorSound()
        if (currentDisp != "") errorSound()
        else {
            currentDisp += "-"
            refresh()
            isAnInteger
        }
    }
    butClear.addActionListener {
        currentDisp = ""
        refresh()
        isADecimal = false
        isAnInteger = false
    }
    butBack.addActionListener {
        if (currentDisp == "") errorSound()
        else {
            currentDisp = currentDisp.dropLast(1)
            refresh()
        }
        if (currentDisp.isEmpty()) {
            isADecimal = false
            isAnInteger = false
        }
    }
    butEnter.addActionListener {
        if (numberOfVals == 5) {
            errorSound()
            JOptionPane.showMessageDialog(
                null,
                "Maximum of five values only.",
                "Error",
                JOptionPane.ERROR_MESSAGE
            )
        }
        numberOfVals++
        when (numberOfVals) {
            1 -> value1 = currentDisp.toInt()
            2 -> value2 = currentDisp.toInt()
            3 -> value3 = currentDisp.toInt()
            4 -> value4 = currentDisp.toInt()
            5 -> value5 = currentDisp.toInt()
        }
        currentDisp = ""
        refresh()
        isADecimal = false
        isAnInteger = false
    }
    butAdd.addActionListener {
        currentDisp = (value1+value2+value3+value4+value5).toString()
        refresh()
        reset()
    }
    butSub.addActionListener {
        currentDisp = (value1-value2-value3-value4-value5).toString()
        refresh()
        reset()
    }
    butMul.addActionListener {
        when (numberOfVals) {
            2 -> currentDisp = (value1*value2).toString()
            3 -> currentDisp = (value1*value2*value3).toString()
            4 -> currentDisp = (value1*value2*value3*value4).toString()
            5 -> currentDisp = (value1*value2*value3*value4*value5).toString()
        }
        refresh()
        reset()
    }
    butDiv.addActionListener {
        when (numberOfVals) {
            2 -> {
                if (listOf(value1,value2).contains(0)) divBy0()
                else currentDisp = (value1/value2).toString()
            }
            3 -> {
                if (listOf(value1,value2,value3).contains(0)) divBy0()
                else currentDisp = (value1/value2/value3).toString()
            }
            4 -> {
                if (listOf(value1,value2,value3,value4).contains(0)) divBy0()
                else currentDisp = (value1/value2/value3/value4).toString()
            }
            5 -> {
                if (listOf(value1,value2,value3,value4,value5).contains(0)) divBy0()
                else currentDisp = (value1/value2/value3/value4/value5).toString()
            }
        }
        refresh()
        reset()
    }
    val components = listOf(
        but1, but2, but3, but4, but5, but6, but7, but8, but9, but0,
        butBack, butClear, butAdd, butSub, butMul, butDiv, butEnter,
        butInt, butDecimal, disp, inst
    )
    SwingUtilities.invokeLater {
        w.apply {
            components.forEach {add(it)}
            setSize(414,637)
            defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            layout = null
            isResizable = false
            setLocationRelativeTo(null)
            isVisible = true
        }
    }
}
fun errorSound() {
    val toolkit = Toolkit.getDefaultToolkit()
    toolkit.beep()
}
fun divBy0() {
    errorSound()
    JOptionPane.showMessageDialog(
        null,
        "You cant divide by 0, you fucking retard.",
        "Error",
        JOptionPane.ERROR_MESSAGE
    )
}
fun reset() {
    value1 = 0
    value2 = 0
    value3 = 0
    value4 = 0
    value5 = 0
}
