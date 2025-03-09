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
    private var eExponent: Double,
    private var aSquareRoot: Boolean,
    private var bSquareRoot: Boolean,
    private var cSquareRoot: Boolean,
    private var dSquareRoot: Boolean,
    private var eSquareRoot: Boolean
) {
    init {
        reset()
    }
    fun getA() = a.pow(aExponent) fun isASquareRoot() = aSquareRoot
    fun getB() = b.pow(bExponent) fun isBSquareRoot() = bSquareRoot
    fun getC() = c.pow(cExponent) fun isCSquareRoot() = cSquareRoot
    fun getD() = d.pow(dExponent) fun isDSquareRoot() = dSquareRoot
    fun getE() = e.pow(eExponent) fun isESquareRoot() = eSquareRoot
    fun setA(i: Double) {a = i; return} fun setAExponent(i: Double) {aExponent = i; return} fun setASquareRoot(i: Boolean) {aSquareRoot = i; return}
    fun setB(i: Double) {b = i; return} fun setBExponent(i: Double) {bExponent = i; return} fun setBSquareRoot(i: Boolean) {bSquareRoot = i; return}
    fun setC(i: Double) {c = i; return} fun setCExponent(i: Double) {cExponent = i; return} fun setCSquareRoot(i: Boolean) {cSquareRoot = i; return}
    fun setD(i: Double) {d = i; return} fun setDExponent(i: Double) {dExponent = i; return} fun setDSquareRoot(i: Boolean) {dSquareRoot = i; return}
    fun setE(i: Double) {e = i; return} fun setEExponent(i: Double) {eExponent = i; return} fun setESquareRoot(i: Boolean) {eSquareRoot = i; return}
    fun reset() {
        a = 0.0; aExponent = 1.0; aSquareRoot = false
        b = 0.0; bExponent = 1.0; bSquareRoot = false
        c = 0.0; cExponent = 1.0; cSquareRoot = false
        d = 0.0; dExponent = 1.0; dSquareRoot = false
        e = 0.0; eExponent = 1.0; eSquareRoot = false
    }
}
var isADecimal = false
var isAnInteger = false
var isAnExponent = false
var hasSquareRoot = false
var resulted = false
var numberOfValues = 0
val w = JFrame("calcGUI.kt")
val menu = JMenuBar()
val fileMenu = JMenu("File")
val helpMenu = JMenu("Help")
val aboutMenu = JMenu("About this shit")
val exit = JMenuItem("Exit                      Alt+F4")
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
val displayObject = object : JLabel() {
    override fun paintComponent(g: Graphics) {
        g.color = Color.LIGHT_GRAY
        g.fillRect(0, 0, width, height)
        super.paintComponent(g)
    }
}
val value = Values(0.0,0.0,0.0,0.0,0.0,1.0,1.0,1.0,1.0,1.0,
    aSquareRoot = false,
    bSquareRoot = false,
    cSquareRoot = false,
    dSquareRoot = false,
    eSquareRoot = false
)
val display = Display()
class Display {
    fun refresh() {
        SwingUtilities.invokeLater{
            if (resulted) {
                displayObject.text = currentDisplay.take(15)
                return@invokeLater
            }
            if (numberOfValues == 15) {
                errorSound()
                return@invokeLater
            }
            displayObject.text = currentDisplay
        }
    }
    fun type(character: String) {
        if (displayLimitCheck()) {
            errorSound() 
            return
        } 
        checkIfResulted()
        currentDisplay += character
        display.refresh()
    }
    fun clear() {
        currentDisplay = ""
        display.refresh()
    }

}
val sideBar = ValueDisplay()
class ValueDisplay {
    fun wipe() {
        SwingUtilities.invokeLater {
            valueDisplay1.text = ""
            valueDisplay2.text = ""
            valueDisplay3.text = ""
            valueDisplay4.text = ""
            valueDisplay5.text = ""
        }
    }
    fun refresh() {
        SwingUtilities.invokeLater {
            when (numberOfValues) {
                1 -> valueDisplay1.text = currentDisplay
                2 -> valueDisplay2.text = currentDisplay
                3 -> valueDisplay3.text = currentDisplay
                4 -> valueDisplay4.text = currentDisplay
                5 -> valueDisplay5.text = currentDisplay
            }
        }
    }
}
val calculate = Calculation()
class Calculation {
    fun addition() {
        currentDisplay = (preCalculation.squareRoot(1)+preCalculation.squareRoot(2)+preCalculation.squareRoot(3)+preCalculation.squareRoot(4)+preCalculation.squareRoot(5)).toString()
        value.reset()
        numberOfValues = 0
        resulted = true
        display.refresh()
    }
    fun subdivision() {
        currentDisplay = (preCalculation.squareRoot(1)-preCalculation.squareRoot(2)-preCalculation.squareRoot(3)-preCalculation.squareRoot(4)-preCalculation.squareRoot(5)).toString()
        numberOfValues = 0
        resulted = true
        display.refresh()
    }
    fun multiply() {
        when (numberOfValues) {
            2 -> currentDisplay = (preCalculation.squareRoot(1)*preCalculation.squareRoot(2)).toString()
            3 -> currentDisplay = (preCalculation.squareRoot(1)*preCalculation.squareRoot(2)*preCalculation.squareRoot(3)).toString()
            4 -> currentDisplay = (preCalculation.squareRoot(1)*preCalculation.squareRoot(2)*preCalculation.squareRoot(3)*preCalculation.squareRoot(4)).toString()
            5 -> currentDisplay = (preCalculation.squareRoot(1)*preCalculation.squareRoot(2)*preCalculation.squareRoot(3)*preCalculation.squareRoot(4)*preCalculation.squareRoot(5)).toString()
        }
        value.reset()
        numberOfValues = 0
        resulted = true
        display.refresh()
    }
    fun divide() {
        when (numberOfValues) {
            2 -> {
                if (listOf(value.getA(),value.getB()).contains(0.0)) divBy0()
                else currentDisplay = (preCalculation.squareRoot(1)/preCalculation.squareRoot(2)).toString()
            }
            3 -> {
                if (listOf(value.getA(),value.getB(),value.getC()).contains(0.0)) divBy0()
                else currentDisplay = (preCalculation.squareRoot(1)/preCalculation.squareRoot(2)/preCalculation.squareRoot(3)).toString()
            }
            4 -> {
                if (listOf(value.getA(),value.getB(),value.getC(),value.getD()).contains(0.0)) divBy0()
                else currentDisplay = (preCalculation.squareRoot(1)/preCalculation.squareRoot(2)/preCalculation.squareRoot(3)/preCalculation.squareRoot(4)).toString()
            }
            5 -> {
                if (listOf(value.getA(),value.getB(),value.getC(),value.getD(),value.getE()).contains(0.0)) divBy0()
                else currentDisplay = (preCalculation.squareRoot(1)/preCalculation.squareRoot(2)/preCalculation.squareRoot(3)/preCalculation.squareRoot(4)/preCalculation.squareRoot(5)).toString()
            }
        }
        value.reset()
        numberOfValues = 0
        resulted = true
        display.refresh()
    }
}
val preCalculation = PreCalculation()
class PreCalculation {
    fun squareRoot(position: Int): Double {
        return when (position) {
            1 -> if (value.isASquareRoot()) sqrt(value.getA()) else value.getA()
            2 -> if (value.isBSquareRoot()) sqrt(value.getB()) else value.getB()
            3 -> if (value.isCSquareRoot()) sqrt(value.getC()) else value.getC()
            4 -> if (value.isDSquareRoot()) sqrt(value.getD()) else value.getD()
            5 -> if (value.isESquareRoot()) sqrt(value.getE()) else value.getE()
            else -> exitProcess(1)
        }
    }
}
fun main() {
    SwingUtilities.invokeLater {
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
        displayObject.apply {
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
        but1.addActionListener { display.type("1") }
        but2.addActionListener { display.type("2") }
        but3.addActionListener { display.type("3") }
        but4.addActionListener { display.type("4") }
        but5.addActionListener { display.type("5") }
        but6.addActionListener { display.type("6") }
        but7.addActionListener { display.type("7") }
        but8.addActionListener { display.type("8") }
        but9.addActionListener { display.type("9") }
        but0.addActionListener { display.type("0") }
        butDecimal.addActionListener {
            if (isADecimal) {
                errorSound()
                return@addActionListener
            }
            display.type(".")
            isADecimal = true
        }
        butInt.addActionListener {
            if (isAnInteger || currentDisplay != "") {errorSound(); return@addActionListener}
            display.type("-")
            isAnInteger = true
        }
        butExponent.addActionListener {
            if (isAnExponent || currentDisplay.isEmpty()) {errorSound(); return@addActionListener}
            isAnExponent = true
            display.type("^")
        }
        butSqrt.addActionListener {
            checkIfResulted()
            if (hasSquareRoot || currentDisplay.isNotEmpty()) {errorSound(); return@addActionListener}
            hasSquareRoot = true
            display.type("√")
        }
        butClear.addActionListener {
            numberOfValues = 0
            value.reset()
            display.clear()
            isADecimal = false
            isAnInteger = false
            hasSquareRoot = false
        }
        butBack.addActionListener {
            if (currentDisplay == "") {
                errorSound()
                return@addActionListener
            }
            currentDisplay = currentDisplay.dropLast(1)
            display.refresh()
            if (currentDisplay.isEmpty()) {
                isADecimal = false
                isAnInteger = false
            }
        }
        butEnter.addActionListener {
            if (currentDisplay == "" || currentDisplay.all { it == '.' } || currentDisplay.all { it == '-' } || currentDisplay.all { it == '^' } || currentDisplay.all { it == '√' }) {
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
            if (hasSquareRoot) {
                when (numberOfValues) {
                    1 -> value.setASquareRoot(true)
                    2 -> value.setBSquareRoot(true)
                    3 -> value.setCSquareRoot(true)
                    4 -> value.setDSquareRoot(true)
                    5 -> value.setESquareRoot(true)
                }
            }
            val worker = object : SwingWorker<Void, Void>() {
                override fun doInBackground(): Void? {
                    sideBar.refresh()
                    return null
                }
                override fun done() {
                    currentDisplay = currentDisplay.removePrefix("√")
                    when (numberOfValues) {
                        1 -> {
                            if (!isAnExponent) value.setA(currentDisplay.toDouble())
                            else {
                                val exponentSplitter = currentDisplay.split("^")
                                value.setA(exponentSplitter[0].toDouble())
                                value.setAExponent(exponentSplitter[1].toDouble())
                            }
                        }
                        2 -> {
                            if (!isAnExponent) value.setB(currentDisplay.toDouble())
                            else {
                                val exponentSplitter = currentDisplay.split("^")
                                value.setB(exponentSplitter[0].toDouble())
                                value.setBExponent(exponentSplitter[1].toDouble())
                            }
                        }
                        3 -> {
                            if (!isAnExponent) value.setC(currentDisplay.toDouble())
                            else {
                                val exponentSplitter = currentDisplay.split("^")
                                value.setC(exponentSplitter[0].toDouble())
                                value.setCExponent(exponentSplitter[1].toDouble())
                            }
                        }
                        4 -> {
                            if (!isAnExponent) value.setD(currentDisplay.toDouble())
                            else {
                                val exponentSplitter = currentDisplay.split("^")
                                value.setD(exponentSplitter[0].toDouble())
                                value.setDExponent(exponentSplitter[1].toDouble())
                            }
                        }
                        5 -> {
                            if (!isAnExponent) value.setE(currentDisplay.toDouble())
                            else {
                                val exponentSplitter = currentDisplay.split("^")
                                value.setE(exponentSplitter[0].toDouble())
                                value.setEExponent(exponentSplitter[1].toDouble())
                            }
                        }
                    }
                    isADecimal = false
                    isAnInteger = false
                    isAnExponent = false
                    hasSquareRoot = false
                    display.clear()
                }
            }
            worker.execute()
        }
        butAdd.addActionListener {
            calculate.addition()
        }
        butSub.addActionListener {
            calculate.subdivision()
        }
        butMul.addActionListener {
            calculate.multiply()
        }
        butDiv.addActionListener {
            calculate.divide()
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
            butExponent, butEnter, butInt, butDecimal, displayObject, valueLabel,
            valueDisplay1, valueDisplay2, valueDisplay3, valueDisplay4, valueDisplay5
        )
        fileMenu.add(exit)
        helpMenu.add(instructions)
        helpMenu.add(aboutMenu)
        aboutMenu.add(credits)
        aboutMenu.add(github)
        menu.add(fileMenu)
        menu.add(helpMenu)
        w.apply {
            components.forEach{add(it)}
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
            display.clear()
            sideBar.wipe()
            resulted = false
            isAnInteger = false
            isADecimal = false
        }
        else return@invokeLater
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
fun openGithub() {
    if (Desktop.isDesktopSupported()) {
        try {
            Desktop.getDesktop().browse(URI("https://github.com/GMCMeowstic/kotlinSwingCalculator"))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    } else return
}
