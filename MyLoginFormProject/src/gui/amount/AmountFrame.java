package gui.amount;

import gui.PanelHolderFrame;
import gui.transaction.LastTransactionFrameForbKash;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AmountFrame extends JFrame{
    JPanel comboboxPanel;
    public AmountFrame(){
        setLayout(null);
        setBounds(300,0,600,600);
        setForeground(Color.RED);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setResizable(false);

        comboboxPanel = new JPanel(null);
        comboboxPanel.setBounds(178,190,260,40);
        comboboxPanel.setBackground(Color.white);

        String[] paymentItemComboBox = {"select","bKash","Nagad","Rocket","uKash","sure kash"};
        JComboBox paymentBox = new JComboBox(paymentItemComboBox);
        paymentBox.setBounds(5,5,250,30);



        comboboxPanel.add(paymentBox);

        this.add(comboboxPanel);
        this.add(new TopPanelForAmount());


        paymentBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String item = e.getItem().toString();
                try{
                    switch (item){
                        case "Amount":
                            new LastTransactionFrameForbKash();
                            break;

                        case "Do Transaction":
                            new PanelHolderFrame();
                            break;

                        case "Last Transaction Info":
                            new LastTransactionFrameForbKash();
                            break;

                        default:
                            break;
                    }
                }catch(Exception ee){
                    ee.printStackTrace();
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new AmountFrame();
    }

}
