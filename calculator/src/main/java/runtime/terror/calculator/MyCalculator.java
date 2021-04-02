package runtime.terror.calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyCalculator extends JFrame {

    public boolean Clear = true;
    double Value, number;
    char op;
    String digitButtonText[] = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", "+/-", "."};
    String operatorButtonText[] = {"/", "sqrt", "*", "%", "-", "1/X", "+", "="};
    String memoryButtonText[] = {"MC", "MR", "MS", "M+"};
    String specialButtonText[] = {"Backspc", "C", "CE"};

    MyDigitButton digitButton[] = new MyDigitButton[digitButtonText.length];

    MyOperatorButton operatorButton[] = new MyOperatorButton[operatorButtonText.length];

    MyMemoryButton memoryButton[] = new MyMemoryButton[memoryButtonText.length];

    MySpecialButton specialButton[] = new MySpecialButton[specialButtonText.length];

    Label displayLabel = new Label("0", Label.RIGHT);

    Label memLabel = new Label(" ", Label.RIGHT);


    final int FRAME_WIDTH = 450, FRAME_HEIGHT = 450;
    final int HEIGHT = 45, WIDTH = 45, H_SPACE = 15, V_SPACE = 15;
    final int TOPX = 45, TOPY = 60;


    MyCalculator(String frameText){
        super(frameText);
        int tempX = TOPX, y = TOPY;


        displayLabel.setBounds(tempX, y, 355, HEIGHT);
        displayLabel.setBackground(Color.CYAN);
        displayLabel.setForeground(Color.WHITE);

        add(displayLabel);

        memLabel.setBounds(TOPX, TOPY + HEIGHT + V_SPACE, WIDTH, HEIGHT);
        add(memLabel);
// set Co-ordinates for Memory Buttons
        tempX = TOPX;
        y = TOPY + 2 * (HEIGHT + V_SPACE);

        for (int i = 0; i < memoryButton.length; i++) {
            memoryButton[i] = new MyMemoryButton(tempX, y, WIDTH, HEIGHT, memoryButtonText[i], this);
            memoryButton[i].setForeground(Color.RED);


            y += HEIGHT + V_SPACE;

        }

//set Co-ordinates for Special Buttons
        tempX = TOPX + 1 * (WIDTH + H_SPACE);
        y = TOPY + 1 * (HEIGHT + V_SPACE);

        for (int i = 0; i < specialButton.length; i++) {

            specialButton[i] = new MySpecialButton(tempX, y, WIDTH * 2, HEIGHT, specialButtonText[i], this);
            specialButton[i].setForeground(Color.RED);

            tempX = tempX + 2 * WIDTH + H_SPACE;

        }
//set Co-ordinates for Digit Buttons
        int digitX = TOPX + WIDTH + H_SPACE;
        int digitY = TOPY + 2 * (HEIGHT + V_SPACE);

        tempX = digitX;
        y = digitY;

        for (int i = 0; i < digitButton.length; i++) {
            digitButton[i] = new MyDigitButton(tempX, y, WIDTH, HEIGHT, digitButtonText[i], this);
            digitButton[i].setForeground(Color.BLUE);
            tempX += WIDTH + H_SPACE;

            if ((i + 1) % 3 == 0) {
                tempX = digitX;
                y += HEIGHT + V_SPACE;
            }

        }


//set Co-ordinates for Operator Buttons
        int opsX = digitX + 2 * (WIDTH + H_SPACE) + H_SPACE;
        int opsY = digitY;


        tempX = opsX;
        y = opsY;

        for (int i = 0; i < operatorButton.length; i++) {
            tempX += WIDTH + H_SPACE;


            operatorButton[i] = new MyOperatorButton(tempX, y, WIDTH, HEIGHT, operatorButtonText[i], this);
            operatorButton[i].setForeground(Color.RED);


            if ((i + 1) % 2 == 0) {
                tempX = opsX;
                y += HEIGHT + V_SPACE;
            }


        }

        addWindowListener(new WindowAdapter() {


            public void windowClosing(WindowEvent ev) {
                System.exit(0);
            }


        });


        setLayout(null);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setVisible(true);


    }

    static String getFormattedText(double temp) {

        String resText = "" + temp;
        if (resText.lastIndexOf(".0") > 0)
            resText = resText.substring(0, resText.length() - 2);
        return resText;
    }

    public static void main(String[] args) {
        new MyCalculator("404Notfound Calculator");
    }

}


