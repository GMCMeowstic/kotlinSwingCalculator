/*
    Coded By GMCMarshy with emotional support from my boyfriend Frost
    -----------------------------------------------------------------
                               MIT License
                       Do whatever the fuck you want
 */

import java.awt.Color
import java.awt.Font
import java.awt.Graphics
import java.awt.Toolkit
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JOptionPane
import javax.swing.SwingUtilities

var currentDisplay = ""
data class Values(
    private var a: Double,
    private var b: Double,
    private var c: Double,
    private var d: Double,
    private var e: Double
) {
    init {
        reset()
    }
    fun getA() = a
    fun getB() = b
    fun getC() = c
    fun getD() = d
    fun getE() = e
    fun setA(i: Double) {a = i}
    fun setB(i: Double) {b = i}
    fun setC(i: Double) {c = i}
    fun setD(i: Double) {d = i}
    fun setE(i: Double) {e = i}
    fun reset() {
        a = 0.0
        b = 0.0
        c = 0.0
        d = 0.0
        e = 0.0
    }
}
var isADecimal = false
var isAnInteger = false
var resulted = false
var numberOfValues = 0
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
val valueLabel = JLabel("Values Entered:")
val valueDisplay1 = JLabel()
val valueDisplay2 = JLabel()
val valueDisplay3 = JLabel()
val valueDisplay4 = JLabel()
val valueDisplay5 = JLabel()
val display = object : JLabel() {
    override fun paintComponent(g: Graphics) {
        g.color = Color.LIGHT_GRAY
        g.fillRect(0, 0, width, height)
        super.paintComponent(g)
    }
}
val inst = JLabel("<html>Press <font color='blue'>ENTER</font> to enter a<br>value<br>Press <font color='lime'>(+,-,x,/)</font> to<br>do calculate values.</html>")
fun main() {
    val value = Values(0.0,0.0,0.0,0.0,0.0)
    fun sideBar() {
        val a = value.getA()
        val b = value.getB()
        val c = value.getC()
        val d = value.getD()
        val e = value.getE()
        if (a != 0.0) valueDisplay1.text = a.toString()
        if (b != 0.0) valueDisplay2.text = b.toString()
        if (c != 0.0) valueDisplay3.text = c.toString()
        if (d != 0.0) valueDisplay4.text = d.toString()
        if (e != 0.0) valueDisplay5.text = e.toString()
    }
    valueLabel.apply {
        setBounds(2, 0, 300, 100)
        font = Font("Arial", Font.PLAIN, 40)
    }
    valueDisplay1.apply {
        setBounds(2, 100, 300, 100)
        font = Font("Arial", Font.PLAIN, 50)
    }
    valueDisplay2.apply {
        setBounds(2, 200, 300, 100)
        font = Font("Arial", Font.PLAIN, 50)
    }
    valueDisplay3.apply {
        setBounds(2, 300, 300, 100)
        font = Font("Arial", Font.PLAIN, 50)
    }
    valueDisplay4.apply {
        setBounds(2, 400, 300, 100)
        font = Font("Arial", Font.PLAIN, 50)
    }
    valueDisplay5.apply {
        setBounds(2, 500, 300, 100)
        font = Font("Arial", Font.PLAIN, 50)
    }
    display.apply {
        background = Color.GRAY
        font = Font("Arial", Font.PLAIN, 50)
        setBounds(300,0,300,100)
    }
    butClear.apply {
        foreground = Color.RED
        font = Font("Arial", Font.BOLD, 50)
        setBounds(600,0,100,100)
    }
    butBack.apply {
        foreground = Color.RED
        font = Font("Arial", Font.BOLD, 50)
        setBounds(500,400,100,100)
    }
    butEnter.apply {
        foreground = Color.BLUE
        font = Font("Arial", Font.BOLD, 19)
        setBounds(300, 400, 100, 100)
    }
    butAdd.apply {
        foreground = Color.GREEN
        font = Font("Arial", Font.BOLD, 50)
        setBounds(600, 100, 100, 100)
    }
    butSub.apply {
        foreground = Color.GREEN
        font = Font("Arial", Font.BOLD, 50)
        setBounds(600, 200, 100, 100)
    }
    butMul.apply {
        foreground = Color.GREEN
        font = Font("Arial", Font.BOLD, 50)
        setBounds(600, 300, 100, 100)
    }
    butDiv.apply {
        foreground = Color.GREEN
        font = Font("Arial", Font.BOLD, 50)
        setBounds(600, 400, 100, 100)
    }
    but1.apply {
        font = Font("Arial", Font.BOLD, 50)
        setBounds(300, 100, 100, 100)
    }
    but2.apply {
        font = Font("Arial", Font.BOLD, 50)
        setBounds(400, 100, 100, 100)
    }
    but3.apply {
        font = Font("Arial", Font.BOLD, 50)
        setBounds(500, 100, 100, 100)
    }
    but4.apply {
        font = Font("Arial", Font.BOLD, 50)
        setBounds(300, 200, 100, 100)
    }
    but5.apply {
        font = Font("Arial", Font.BOLD, 50)
        setBounds(400, 200, 100, 100)
    }
    but6.apply {
        font = Font("Arial", Font.BOLD, 50)
        setBounds(500, 200, 100, 100)
    }
    but7.apply {
        font = Font("Arial", Font.BOLD, 50)
        setBounds(300, 300, 100, 100)
    }
    but8.apply {
        font = Font("Arial", Font.BOLD, 50)
        setBounds(400, 300, 100, 100)
    }
    but9.apply {
        font = Font("Arial", Font.BOLD, 50)
        setBounds(500, 300, 100, 100)
    }
    but0.apply {
        font = Font("Arial", Font.BOLD, 50)
        setBounds(400, 400, 100, 100)
    }
    butInt.apply {
        font = Font("Arial", Font.BOLD, 50)
        setBounds(300, 500, 100, 100)
    }
    butDecimal.apply {
        font = Font("Arial", Font.BOLD, 50)
        setBounds(400, 500, 100, 100)
    }
    inst.setBounds(510,375,150,350)
    but1.addActionListener { checkIfResulted(); currentDisplay += "1"; refresh() }
    but2.addActionListener { checkIfResulted(); currentDisplay += "2"; refresh() }
    but3.addActionListener { checkIfResulted(); currentDisplay += "3"; refresh() }
    but4.addActionListener { checkIfResulted(); currentDisplay += "4"; refresh() }
    but5.addActionListener { checkIfResulted(); currentDisplay += "5"; refresh() }
    but6.addActionListener { checkIfResulted(); currentDisplay += "6"; refresh() }
    but7.addActionListener { checkIfResulted(); currentDisplay += "7"; refresh() }
    but8.addActionListener { checkIfResulted(); currentDisplay += "8"; refresh() }
    but9.addActionListener { checkIfResulted(); currentDisplay += "9"; refresh() }
    but0.addActionListener { checkIfResulted(); currentDisplay += "0"; refresh() }
    butDecimal.addActionListener {
        checkIfResulted()
        if (isADecimal) errorSound()
        else {
            currentDisplay += "."
            refresh()
            isADecimal = true
        }
    }
    butInt.addActionListener {
        checkIfResulted()
        if (isAnInteger) errorSound()
        if (currentDisplay != "") errorSound()
        else {
            currentDisplay += "-"
            refresh()
            isAnInteger
        }
    }
    butClear.addActionListener {
        currentDisplay = ""
        refresh()
        sideBarWipe()
        isADecimal = false
        isAnInteger = false
    }
    butBack.addActionListener {
        if (currentDisplay == "") errorSound()
        else {
            currentDisplay = currentDisplay.dropLast(1)
            refresh()
        }
        if (currentDisplay.isEmpty()) {
            isADecimal = false
            isAnInteger = false
        }
    }
    butEnter.addActionListener {
        if (numberOfValues == 5) {
            errorSound()
            JOptionPane.showMessageDialog(
                null,
                "Maximum of five values only.",
                "Error",
                JOptionPane.ERROR_MESSAGE
            )
        }
        numberOfValues++
        when (numberOfValues) {
            1 -> value.setA(currentDisplay.toDouble())
            2 -> value.setB(currentDisplay.toDouble())
            3 -> value.setC(currentDisplay.toDouble())
            4 -> value.setD(currentDisplay.toDouble())
            5 -> value.setE(currentDisplay.toDouble())
        }
        sideBar()
        currentDisplay = ""
        refresh()
        isADecimal = false
        isAnInteger = false
    }
    butAdd.addActionListener {
        currentDisplay = (value.getA()+value.getB()+value.getC()+value.getD()+value.getE()).toString()
        refresh()
        value.reset()
        numberOfValues = 0
        resulted = true
    }
    butSub.addActionListener {
        currentDisplay = (value.getA()-value.getB()-value.getC()-value.getD()-value.getE()).toString()
        refresh()
        value.reset()
        numberOfValues = 0
        resulted = true
    }
    butMul.addActionListener {
        when (numberOfValues) {
            2 -> currentDisplay = (value.getA()*value.getB()).toString()
            3 -> currentDisplay = (value.getA()*value.getB()*value.getC()).toString()
            4 -> currentDisplay = (value.getA()*value.getB()*value.getC()*value.getD()).toString()
            5 -> currentDisplay = (value.getA()*value.getB()*value.getC()*value.getD()*value.getE()).toString()
        }
        refresh()
        value.reset()
        numberOfValues = 0
        resulted = true
    }
    butDiv.addActionListener {
        when (numberOfValues) {
            2 -> {
                if (listOf(value.getA(),value.getB()).contains(0.0)) divBy0()
                else currentDisplay = (value.getA()/value.getB()).toString()
            }
            3 -> {
                if (listOf(value.getA(),value.getB(),value.getC()).contains(0.0)) divBy0()
                else currentDisplay = (value.getA()/value.getB()/value.getC()).toString()
            }
            4 -> {
                if (listOf(value.getA(),value.getB(),value.getC(),value.getD()).contains(0.0)) divBy0()
                else currentDisplay = (value.getA()/value.getB()/value.getC()/value.getD()).toString()
            }
            5 -> {
                if (listOf(value.getA(),value.getB(),value.getC(),value.getD(),value.getE()).contains(0.0)) divBy0()
                else currentDisplay = (value.getA()/value.getB()/value.getC()/value.getD()/value.getE()).toString()
            }
        }
        refresh()
        value.reset()
        numberOfValues = 0
        resulted = true
    }
    val components = listOf(
        but1, but2, but3, but4, but5, but6, but7, but8, but9, but0,
        butBack, butClear, butAdd, butSub, butMul, butDiv, butEnter,
        butInt, butDecimal, display, inst, valueLabel, valueDisplay1,
        valueDisplay2, valueDisplay3, valueDisplay4, valueDisplay5
    )
    SwingUtilities.invokeLater {
        w.apply {
            components.forEach {add(it)}
            setSize(714,637)
            defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            layout = null
            isResizable = false
            setLocationRelativeTo(null)
            isVisible = true
        }
    }
}
fun checkIfResulted() {
    if (resulted) {
        currentDisplay = ""
        refresh()
        sideBarWipe()
        resulted = false
        isAnInteger = false
        isADecimal = false
    }
}
fun refresh() {
    display.text = currentDisplay
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
fun sideBarWipe() {
    valueDisplay1.text = ""
    valueDisplay2.text = ""
    valueDisplay3.text = ""
    valueDisplay4.text = ""
    valueDisplay5.text = ""
}
