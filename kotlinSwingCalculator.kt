/*
    Coded by GMCMarshy with emotional support from my boyfriend Frost
    -----------------------------------------------------------------
                               MIT License
          Do whatever the fuck you want BUT KEEP THE LICENSE FILE
 */

// This shit was coded by a 14-year-old Filipino Furry Femboy so don't expect much.

import java.awt.*
import java.net.URI
import javax.swing.*
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.system.exitProcess

var currentDisplay = ""
data class Values(
    private var a: Double,
    private var b: Double,
    private var c: Double,
    private var d: Double,
    private var e: Double,
    private var aExponent: Double,
    private var bExponent: Double,
    private var cExponent: Double,
    private var dExponent: Double,
    private var eExponent: Double
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
        a = 0.0; aExponent = 0.0
        b = 0.0; bExponent = 0.0
        c = 0.0; cExponent = 0.0
        d = 0.0; dExponent = 0.0
        e = 0.0; eExponent = 0.0
    }
}
var isADecimal = false
var isAnInteger = false
var resulted = false
var numberOfValues = 0
val w = JFrame("calcGUI.kt")
val menu = JMenuBar()
val fileMenu = JMenu("File")
val helpMenu = JMenu("Help")
val aboutMenu = JMenu("About this shit")
val exit = JMenuItem("Exit                      Alt+F4")
val settings = JMenuItem("Preferences")
val instructions = JMenuItem("Instructions")
val credits = JMenuItem("Credits")
val github = JMenuItem("Github")
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
val butSqrt = JButton("√")
val butExponent = JButton("^")
val butClear = JButton("C")
val butBack = JButton("←")
val butAdd = JButton("+")
val butSub = JButton("-")
val butMul = JButton("x")
val butDiv = JButton("/")
val butEnter = JButton("E")
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
fun main() {
    SwingUtilities.invokeLater {
        val value = Values(0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0)
        fun sideBar() {
            val a = value.getA()
            val b = value.getB()
            val c = value.getC()
            val d = value.getD()
            val e = value.getE()
            SwingUtilities.invokeLater {
                if (numberOfValues >= 1) valueDisplay1.text = a.toString()
                if (numberOfValues >= 2) valueDisplay2.text = b.toString()
                if (numberOfValues >= 3) valueDisplay3.text = c.toString()
                if (numberOfValues >= 4) valueDisplay4.text = d.toString()
                if (numberOfValues >= 5) valueDisplay5.text = e.toString()
            }
        }
        valueLabel.apply {
            setBounds(2, 0, 300, 100)
            font = Font("Arial", Font.PLAIN, 40)
        }
        valueDisplay1.apply {
            setBounds(2, 100, 300, 60)
            font = Font("Arial", Font.PLAIN, 50)
        }
        valueDisplay2.apply {
            setBounds(2, 160, 300, 60)
            font = Font("Arial", Font.PLAIN, 50)
        }
        valueDisplay3.apply {
            setBounds(2, 220, 300, 60)
            font = Font("Arial", Font.PLAIN, 50)
        }
        valueDisplay4.apply {
            setBounds(2, 280, 300, 60)
            font = Font("Arial", Font.PLAIN, 50)
        }
        valueDisplay5.apply {
            setBounds(2, 340, 300, 60)
            font = Font("Arial", Font.PLAIN, 50)
        }
        display.apply {
            background = Color.GRAY
            font = Font("Arial", Font.PLAIN, 50)
            setBounds(300,0,420,100)
        }
        butClear.apply {
            foreground = Color.RED
            font = Font("Arial", Font.BOLD, 37)
            setBounds(660,100,60,100)
            isFocusable = false
        }
        butBack.apply {
            foreground = Color.RED
            font = Font("Arial", Font.BOLD, 26)
            setBounds(660,200,60,100)
            isFocusable = false
        }
        butEnter.apply {
            foreground = Color.BLUE
            font = Font("Arial", Font.BOLD, 37)
            setBounds(660, 300, 60, 100)
            isFocusable = false
        }
        butAdd.apply {
            foreground = Color.GREEN
            font = Font("Arial", Font.BOLD, 60)
            setBounds(570, 100, 90, 60)
            isFocusable = false
        }
        butSub.apply {
            foreground = Color.GREEN
            font = Font("Arial", Font.BOLD, 60)
            setBounds(570, 160, 90, 60)
            isFocusable = false
        }
        butMul.apply {
            foreground = Color.GREEN
            font = Font("Arial", Font.BOLD, 60)
            setBounds(570, 220, 90, 60)
            isFocusable = false
        }
        butDiv.apply {
            foreground = Color.GREEN
            font = Font("Arial", Font.BOLD, 60)
            setBounds(570, 280, 90, 60)
            isFocusable = false
        }
        butSqrt.apply {
            foreground = Color.GREEN
            font = Font("Arial", Font.BOLD,45)
            setBounds(570,340,90,60)
            isFocusable = false
        }
        butExponent.apply {
            foreground = Color.GREEN
            font = Font("Arial", Font.BOLD,60)
            setBounds(480,340,90,60)
            isFocusable = false
        }
        but1.apply {
            font = Font("Arial", Font.BOLD, 60)
            setBounds(300, 100, 90, 60)
            isFocusable = false
        }
        but2.apply {
            font = Font("Arial", Font.BOLD, 60)
            setBounds(390, 100, 90, 60)
            isFocusable = false
        }
        but3.apply {
            font = Font("Arial", Font.BOLD, 60)
            setBounds(480, 100, 90, 60)
            isFocusable = false
        }
        but4.apply {
            font = Font("Arial", Font.BOLD, 60)
            setBounds(300, 160, 90, 60)
            isFocusable = false
        }
        but5.apply {
            font = Font("Arial", Font.BOLD, 60)
            setBounds(390, 160, 90, 60)
            isFocusable = false
        }
        but6.apply {
            font = Font("Arial", Font.BOLD, 60)
            setBounds(480, 160, 90, 60)
            isFocusable = false
        }
        but7.apply {
            font = Font("Arial", Font.BOLD, 60)
            setBounds(300, 220, 90, 60)
            isFocusable = false
        }
        but8.apply {
            font = Font("Arial", Font.BOLD, 60)
            setBounds(390, 220, 90, 60)
            isFocusable = false
        }
        but9.apply {
            font = Font("Arial", Font.BOLD, 60)
            setBounds(480, 220, 90, 60)
            isFocusable = false
        }
        but0.apply {
            font = Font("Arial", Font.BOLD, 60)
            setBounds(390, 280, 90, 60)
            isFocusable = false
        }
        butInt.apply {
            font = Font("Arial", Font.BOLD, 45)
            setBounds(300, 280, 90, 60)
            isFocusable = false
        }
        butDecimal.apply {
            font = Font("Arial", Font.BOLD, 60)
            setBounds(480, 280, 90, 60)
            isFocusable = false
        }
        but1.addActionListener { if (displayLimitCheck()) {errorSound(); return@addActionListener}; checkIfResulted(); currentDisplay += "1"; refresh() }
        but2.addActionListener { if (displayLimitCheck()) {errorSound(); return@addActionListener}; checkIfResulted(); currentDisplay += "2"; refresh() }
        but3.addActionListener { if (displayLimitCheck()) {errorSound(); return@addActionListener}; checkIfResulted(); currentDisplay += "3"; refresh() }
        but4.addActionListener { if (displayLimitCheck()) {errorSound(); return@addActionListener}; checkIfResulted(); currentDisplay += "4"; refresh() }
        but5.addActionListener { if (displayLimitCheck()) {errorSound(); return@addActionListener}; checkIfResulted(); currentDisplay += "5"; refresh() }
        but6.addActionListener { if (displayLimitCheck()) {errorSound(); return@addActionListener}; checkIfResulted(); currentDisplay += "6"; refresh() }
        but7.addActionListener { if (displayLimitCheck()) {errorSound(); return@addActionListener}; checkIfResulted(); currentDisplay += "7"; refresh() }
        but8.addActionListener { if (displayLimitCheck()) {errorSound(); return@addActionListener}; checkIfResulted(); currentDisplay += "8"; refresh() }
        but9.addActionListener { if (displayLimitCheck()) {errorSound(); return@addActionListener}; checkIfResulted(); currentDisplay += "9"; refresh() }
        but0.addActionListener { if (displayLimitCheck()) {errorSound(); return@addActionListener}; checkIfResulted(); currentDisplay += "0"; refresh() }
        butDecimal.addActionListener {
            checkIfResulted()
            if (displayLimitCheck()) {
                errorSound()
                return@addActionListener
            }
            if (isADecimal) {
                errorSound()
                return@addActionListener
            }
            currentDisplay += "."
            refresh()
            isADecimal = true
        }
        butInt.addActionListener {
            checkIfResulted()
            if (displayLimitCheck()) {
                errorSound()
                return@addActionListener
            }
            if (isAnInteger) {
                errorSound()
                return@addActionListener
            }
            if (currentDisplay != "") {
                errorSound()
                return@addActionListener
            }
            currentDisplay += "-"
            refresh()
            isAnInteger
        }
        butClear.addActionListener {
            currentDisplay = ""
            numberOfValues = 0
            value.reset()
            refresh()
            sideBarWipe()
            isADecimal = false
            isAnInteger = false
        }
        butBack.addActionListener {
            if (currentDisplay == "") {
                errorSound()
                return@addActionListener
            }
            currentDisplay = currentDisplay.dropLast(1)
            refresh()
            if (currentDisplay.isEmpty()) {
                isADecimal = false
                isAnInteger = false
            }
        }
        butEnter.addActionListener {
            if (currentDisplay == "") {
                errorSound()
                return@addActionListener
            }
            if (currentDisplay.length > 15) {
                errorSound()
                JOptionPane.showMessageDialog(
                    null,
                    "Maximum of 15 characters per input.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                )
                return@addActionListener
            }
            if (currentDisplay.all{it == '.'} || currentDisplay.all{it=='-'}) {
                errorSound()
                return@addActionListener
            }
            if (numberOfValues == 5) {
                errorSound()
                JOptionPane.showMessageDialog(
                    null,
                    "Maximum of five values only.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                )
                return@addActionListener
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
            value.reset()
            numberOfValues = 0
            resulted = true
            refresh()
        }
        butSub.addActionListener {
            currentDisplay = (value.getA()-value.getB()-value.getC()-value.getD()-value.getE()).toString()
            value.reset()
            numberOfValues = 0
            resulted = true
            refresh()
        }
        butMul.addActionListener {
            when (numberOfValues) {
                2 -> currentDisplay = (value.getA()*value.getB()).toString()
                3 -> currentDisplay = (value.getA()*value.getB()*value.getC()).toString()
                4 -> currentDisplay = (value.getA()*value.getB()*value.getC()*value.getD()).toString()
                5 -> currentDisplay = (value.getA()*value.getB()*value.getC()*value.getD()*value.getE()).toString()
            }
            value.reset()
            numberOfValues = 0
            resulted = true
            refresh()
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
            value.reset()
            numberOfValues = 0
            resulted = true
            refresh()
        }
        butSqrt.addActionListener {
            if (numberOfValues != 1) {
                validValuesNumError(1)
                return@addActionListener
            }
            currentDisplay = sqrt(value.getA()).toString()
            numberOfValues = 0
            resulted = true
            refresh()
        }
        butExponent.addActionListener {
            if (numberOfValues != 2)  validValuesNumError(2)
            else {
                currentDisplay = value.getA().pow(value.getB()).toString()
            }
            resulted = true
            refresh()
        }
        credits.addActionListener {
            val c = JFrame("Credits")
            val text = JLabel("<html>GMCMarshy - The actual code itself<br>Frost - Emotional Support</html>")
            text.setBounds(0,0,350,250)
            text.font = Font("Arial", Font.BOLD, 25)
            c.setSize(350,200)
            c.add(text)
            c.defaultCloseOperation = JFrame.HIDE_ON_CLOSE
            c.isResizable = false
            c.setLocationRelativeTo(null)
            c.isVisible = true
        }
        settings.addActionListener {
            val s = JFrame("Preferences")
            val text = JLabel("still in development")
            s.setSize(350,200)
            s.add(text)
            s.defaultCloseOperation = JFrame.HIDE_ON_CLOSE
            s.isResizable = false
            s.setLocationRelativeTo(null)
            s.isVisible = true
        }
        exit.addActionListener { exitProcess(0) }
        instructions.addActionListener {
            val f = JFrame("Instructions")
            val inst = JLabel("<html>Press <font color='blue'>E</font> to enter a<br>value<br>Press <font color='lime'>(+,-,x,/,^,√)</font> to<br>calculate the values.</html>")
            inst.setBounds(0,0,350,250)
            inst.font = Font("Arial", Font.BOLD, 25)
            f.add(inst)
            f.setSize(350,175)
            f.defaultCloseOperation = JFrame.HIDE_ON_CLOSE
            f.isResizable = false
            f.setLocationRelativeTo(null)
            f.isVisible = true
        }
        github.addActionListener {openGithub()}
        val components = listOf(
            but1, but2, but3, but4, but5, but6, but7, but8, but9, but0,
            butBack, butClear, butAdd, butSub, butMul, butDiv, butSqrt,
            butExponent, butEnter, butInt, butDecimal, display, valueLabel,
            valueDisplay1, valueDisplay2, valueDisplay3, valueDisplay4, valueDisplay5
        )
        fileMenu.add(settings)
        fileMenu.add(exit)
        helpMenu.add(instructions)
        helpMenu.add(aboutMenu)
        aboutMenu.add(credits)
        aboutMenu.add(github)
        menu.add(fileMenu)
        menu.add(helpMenu)
        w.apply {
            components.forEach {add(it)}
            setSize(734,460)
            jMenuBar = menu
            defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            layout = null
            isResizable = false
            setLocationRelativeTo(null)
            isVisible = true
        }
    }
}
fun checkIfResulted() {
    SwingUtilities.invokeLater {
        if (resulted) {
            currentDisplay = ""
            refresh()
            sideBarWipe()
            resulted = false
            isAnInteger = false
            isADecimal = false
        }
        else return@invokeLater
    }
}
fun refresh() {
    SwingUtilities.invokeLater{
        if (resulted) {
            display.text = currentDisplay.take(15)
            return@invokeLater
        }
        if (numberOfValues == 15) {
            errorSound()
            return@invokeLater
        }
        display.text = currentDisplay
    }
}
fun displayLimitCheck(): Boolean {
    return currentDisplay.length >= 15
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
fun validValuesNumError(x: Int) {
    errorSound()
    JOptionPane.showMessageDialog(
        null,
        "Only $x value can be operated.",
        "Error",
        JOptionPane.ERROR_MESSAGE
    )
}
fun sideBarWipe() {
    SwingUtilities.invokeLater {
        valueDisplay1.text = ""
        valueDisplay2.text = ""
        valueDisplay3.text = ""
        valueDisplay4.text = ""
        valueDisplay5.text = ""
    }
}
fun openGithub() {
    if (Desktop.isDesktopSupported()) {
        val desktop = Desktop.getDesktop()
        try {
            val uri = URI("https://github.com/GMCMeowstic/kotlinSwingCalculator")
            desktop.browse(uri)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    } else return
}
