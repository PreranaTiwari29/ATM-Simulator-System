
package atm.simulator.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import javax.swing.*;

public class Deposit extends JFrame implements ActionListener  {
         JTextField t1,t2;
         JButton b1,b2,b3;
         JLabel l1,l2,l3;
         String pin;
         
         Deposit(String pin){
             this.pin=pin;
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm/simulator/system/icons/atm.jpg"));
       Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel ll6= new JLabel(i3);
        ll6.setBounds(0, 0, 960, 1080);
        add(ll6);
             
        l1 = new JLabel("Enter Amount You Want You Want To Deposit");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Raleway",Font.BOLD,16));
        
        
        t1=new JTextField();
        t1.setFont(new Font("Raleway",Font.BOLD,22));
        
         b1= new JButton("DEPOSIT");
         b2= new JButton("BACK");
        
        
        
        
         setLayout(null);
         
         
         
        l1.setBounds(190,350,800,60);
        ll6. add(l1);
        
         
        t1.setBounds(190, 420, 320, 25);
        ll6. add(t1);
         
        b1.setBounds(390,585, 150, 35);
        ll6. add(b1);
         
        b2.setBounds(390,633, 150, 35);
        ll6. add(b2);
         
         
         
         b1.addActionListener(this);
         b2.addActionListener(this);
         
         
             setSize(960,1080);
             setLocation(500,0);
             setUndecorated(true);
             setVisible(true);
             
         }
          public void actionPerformed(ActionEvent ae){
              try{
                if(ae.getSource()==b1){
                String amount = t1.getText();
                Date date = new Date();
                if(t1.getText().equals("")){
       JOptionPane.showMessageDialog(null,"Please enter the Amount to you want to Deposit");
                       }else{
                           Conn c1 = new Conn();
                           
                c1.s.executeUpdate("insert into bank values ('"+pin+"','"+date+"','Deposit','"+amount+"') ");
                 
              JOptionPane.showMessageDialog(null,"Rs.'"+amount+"'Deposited Successfully");
                             setVisible(false);
                            new Transactions(pin).setVisible(true);
                            
                       }
                            
                       }else if(ae.getSource()==b2) {
                           new Transactions(pin).setVisible(true);
                           setVisible(false);
                    }
                    
                    }catch(Exception e){
                        e.printStackTrace();
                       
              }
              
          }
          public static void main(String[]args){
              new Deposit("").setVisible(true);
          }
} 
                  
                     
         
         
         
         
        
        
        
           
    

