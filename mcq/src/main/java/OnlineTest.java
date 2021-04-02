import java.awt.*;

import java.awt.event.*;

import javax.swing.*;



class OnlineTest extends JFrame implements ActionListener

{

    JLabel label;

    JRadioButton option[]=new JRadioButton[5];

    JButton button1,button2;

    ButtonGroup bg;

    int count=0,current=0,x=1,y=1,n=0;

    int m[]=new int[10];

    OnlineTest(String str)

    {

        super(str);

        label=new JLabel();

        add(label);

        bg=new ButtonGroup();

        for(int i=0;i<5;i++)

        {

            option[i]=new JRadioButton();

            add(option[i]);

            bg.add(option[i]);

        }

        button1=new JButton("Next");

        button2=new JButton("Bookmark");

        button1.addActionListener(this);

        button2.addActionListener(this);

        add(button1);

        add(button2);

        set();

        label.setBounds(30,40,450,20);

        option[0].setBounds(50,80,100,20);

        option[1].setBounds(50,110,100,20);

        option[2].setBounds(50,140,100,20);

        option[3].setBounds(50,170,100,20);

        button1.setBounds(100,240,100,30);

        button2.setBounds(270,240,100,30);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);

        setLocation(250,100);

        setVisible(true);

        setSize(600,350);

    }

    public void actionPerformed(ActionEvent e)

    {

        if(e.getSource()==button1)

        {

            if(check())

                count=count+1;

            current++;

            set();

            if(current==9)

            {

                button1.setEnabled(false);

                button2.setText("Result");

            }

        }

        if(e.getActionCommand().equals("Bookmark"))

        {

            JButton bookmark=new JButton("Bookmark"+x);

            bookmark.setBounds(480,20+30*x,100,30);

            add(bookmark);

            bookmark.addActionListener(this);

            m[x]=current;

            x++;

            current++;

            set();

            if(current==9)

                button2.setText("Result");

            setVisible(false);

            setVisible(true);

        }

        for(int i=0,y=1;i<x;i++,y++)

        {

            if(e.getActionCommand().equals("Bookmark"+y))

            {

                if(check())

                    count=count+1;

                n=current;

                current=m[y];

                set();

                ((JButton)e.getSource()).setEnabled(false);

                current=n;

            }

        }



        if(e.getActionCommand().equals("Result"))

        {

            if(check())

                count=count+1;

            current++;

            //System.out.println("correct ans="+count);

            JOptionPane.showMessageDialog(this,"correct ans="+count);

            System.exit(0);

        }

    }

    void set()

    {

        option[4].setSelected(true);

        if(current==0)

        {

            label.setText("Question1: In which decade was the American Institute of Electrical Engineers                         (AIEE) founded?");

            option[0].setText("1850s");

            option[1].setText("1880s");

            option[2].setText("1930s");

            option[3].setText("1950s");

        }

        if(current==1)

        {

            label.setText("Question2: In which decade was the SPICE simulator introduced?");

            option[0].setText("1950s");

            option[1].setText("1960s");

            option[2].setText("1972s");

            option[3].setText("1980s");

        }

        if(current==2)

        {

            label.setText("Question3: Which package is directly available to our class without importing it?");

            option[0].setText("swing");

            option[1].setText("applet");

            option[2].setText("net");

            option[3].setText("lang");

        }

        if(current==3)

        {

            label.setText("Question4: Who developed Yahoo?");

            option[0].setText("Dennis Ritchie and Ken Thompson");

            option[1].setText("David Filo and Jerry Yang");

            option[2].setText("Vint Cerg and Robert Kahn");

            option[3].setText("Steve Case and Jeff Bezos");

        }

        if(current==4)

        {

            label.setText("Question5: Which is a type of Electrically-Erasable Programmable Read-Only Memory?");

            option[0].setText("Flash");

            option[1].setText("Flange");

            option[2].setText("Fury");

            option[3].setText("FRAME");

        }

        if(current==5)

        {

            label.setText("Question6: Who is largely responsible for breaking the German Enigma codes, created a test that provided a foundation for artificial intelligence?");

            option[0].setText("Jeff Bezos");

            option[1].setText("George Boole");

            option[2].setText("Charles Babbage");

            option[3].setText("Alan Turing");

        }

        if(current==6)

        {

            label.setText("Question7: Who built the world’s first binary digit computer: Z1? ");

            option[0].setText("Konard Zuse");

            option[1].setText("Alan Turing");

            option[2].setText("Ken Thompson");

            option[3].setText("George Boole");

        }

        if(current==7)

        {

            label.setText("Question8: which one among these is not a function of Object class?");

            option[0].setText("toString");

            option[1].setText("finalize");

            option[2].setText("equals");

            option[3].setText("getDocumentBase");

        }

        if(current==8)

        {

            label.setText("Question9: Who co-created the UNIX operating system in 1969 with Dennis Ritchie?");

            option[0].setText("Bjarne Stroustrup");

            option[1].setText("Niklaus Wirth");

            option[2].setText("Steve Wozniak");

            option[3].setText("Ken Thompson");

        }

        if(current==9)

        {

            label.setText("Question10: Changing computer language of 1’s and 0’s to characters that a person can understand is?");

            option[0].setText("Highlight");

            option[1].setText("Execute");

            option[2].setText("Decode");

            option[3].setText("Clip art");

        }

        label.setBounds(30,40,450,20);

        for(int i=0,j=0;i<=90;i+=30,j++)

            option[j].setBounds(50,80+i,200,20);

    }

    boolean check()

    {

        if(current==0)

            return(option[1].isSelected());

        if(current==1)

            return(option[2].isSelected());

        if(current==2)

            return(option[3].isSelected());

        if(current==3)

            return(option[0].isSelected());

        if(current==4)

            return(option[2].isSelected());

        if(current==5)

            return(option[2].isSelected());

        if(current==6)

            return(option[1].isSelected());

        if(current==7)

            return(option[3].isSelected());

        if(current==8)

            return(option[1].isSelected());

        if(current==9)

            return(option[2].isSelected());

        return false;

    }

    public static void main(String str[])

    {

        new OnlineTest("Online Test Of Java");

    }

}
