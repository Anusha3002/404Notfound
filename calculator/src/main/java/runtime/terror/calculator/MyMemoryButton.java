package runtime.terror.calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/****************************************/


class MyMemoryButton extends JButton implements ActionListener {


    MyCalculator cl;


/////////////////////////////////


    MyMemoryButton(int x, int y, int width, int height, String cap, MyCalculator clc) {


        super(cap);


        setBounds(x, y, width, height);


        this.cl = clc;


        this.cl.add(this);


        addActionListener(this);


    }


////////////////////////////////////////////////


    public void actionPerformed(ActionEvent ev) {


        char memop = ((MyMemoryButton) ev.getSource()).getLabel().charAt(1);


        cl.Clear = true;


        double temp = Double.parseDouble(cl.displayLabel.getText());


        switch (memop) {


            case 'C':


                cl.memLabel.setText(" ");
                cl.Value = 0.0;
                break;


            case 'R':


                cl.displayLabel.setText(MyCalculator.getFormattedText(cl.Value));
                break;


            case 'S':


                cl.Value = 0.0;


            case '+':


                cl.Value += Double.parseDouble(cl.displayLabel.getText());


                if (cl.displayLabel.getText().equals("0") || cl.displayLabel.getText().equals("0.0"))


                    cl.memLabel.setText(" ");


                else


                    cl.memLabel.setText("M");


                break;


        }//switch


    }//actionPerformed


}//class
