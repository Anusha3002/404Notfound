package runtime.terror.calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyOperatorButton extends JButton implements ActionListener {


    MyCalculator cl;


    MyOperatorButton(int x, int y, int width, int height, String cap, MyCalculator clc) {


        super(cap);


        setBounds(x, y, width, height);


        this.cl = clc;


        this.cl.add(this);


        addActionListener(this);


    }


///////////////////////


    public void actionPerformed(ActionEvent ev) {


        String opText = ((MyOperatorButton) ev.getSource()).getLabel();


        cl.Clear = true;


        double temp = Double.parseDouble(cl.displayLabel.getText());


        if (opText.equals("1/x")) {


            try {
                double tempd = 1 / (double) temp;


                cl.displayLabel.setText(MyCalculator.getFormattedText(tempd));
            } catch (ArithmeticException excp) {
                cl.displayLabel.setText("Divide by 0.");
            }


            return;


        }


        if (opText.equals("sqrt")) {


            try {
                double tempd = Math.sqrt(temp);


                cl.displayLabel.setText(MyCalculator.getFormattedText(tempd));
            } catch (ArithmeticException excp) {
                cl.displayLabel.setText("Divide by 0.");
            }


            return;


        }


        if (!opText.equals("=")) {


            cl.number = temp;


            cl.op = opText.charAt(0);


            return;


        }


// process = button pressed


        switch (cl.op) {


            case '+':


                temp += cl.number;
                break;


            case '-':


                temp = cl.number - temp;
                break;


            case '*':


                temp *= cl.number;
                break;


            case '%':


                try {
                    temp = cl.number % temp;
                } catch (ArithmeticException excp) {
                    cl.displayLabel.setText("Divide by 0.");
                    return;
                }


                break;


            case '/':


                try {
                    temp = cl.number / temp;
                } catch (ArithmeticException excp) {
                    cl.displayLabel.setText("Divide by 0.");
                    return;
                }


                break;


        }//switch


        cl.displayLabel.setText(MyCalculator.getFormattedText(temp));


//cl.number=temp;


    }//actionPerformed


}//class
