
package atm.simulator.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

import javax.swing.*;

public class Withdrawl extends JFrame implements ActionListener  {
         JTextField t1,t2;
         JButton b1,b2,b3;
         JLabel l1,l2,l3,l4;
         String pin;
         
         Withdrawl(String pin){
           this.pin=pin;
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm/simulator/system/icons/atm.jpg"));
       Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel ll6= new JLabel(i3);
        ll6.setBounds(0, 0, 960, 1080);
        add(ll6);
           
        l1 = new JLabel("MAXIUM DAILY WITHDRAWL IS RS.10,000");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Raleway",Font.BOLD,16));
        
        l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Raleway",Font.BOLD,16));
        
        t1=new JTextField();
        t1.setFont(new Font("Raleway",Font.BOLD,22));
        
        t2=new JTextField();
        t2.setFont(new Font("Raleway",Font.BOLD,25));
        
        b1= new JButton("WITHDRAWl");
        b2= new JButton("BACK");
        
         setLayout(null);
        
        l1.setBounds(190,350,800,60);
        ll6. add(l1);
         
        l2.setBounds(190, 400, 800, 60);
        ll6. add(l2);
         
        t1.setBounds(190, 450, 350, 30);
         ll6.add(t1);
         
         b1.setBounds(390,588, 150, 35);
         ll6.add(b1);
         
         b2.setBounds(390,633, 150, 35);
         ll6.add(b2);
         
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
          JOptionPane.showMessageDialog(null,"Please enter the Amount to you want to Withdraw");
             }else{
              Conn c1 = new Conn();
                           
             ResultSet rs = c1.s.executeQuery("select * from bank where pin ='"+pin+"' ");
              int balance = 0;
              while(rs.next()){
              if (rs.getString("mode").equals("Deposit")){
                  balance += Integer.parseInt(rs.getString("amount"));
              }else{
                   balance -= Integer.parseInt(rs.getString("amount"));
                  
              }
              }
              if(balance < Integer.parseInt(amount)){
                  JOptionPane.showMessageDialog(null,"insufficient balance");
                  return;
              }  
              String q1 = "insert into bank values('"+pin+"','"+date+"','Withdrawl','"+amount+"')";
              c1.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Rs.'"+amount+"'Debited Successfully");
                setVisible(false);
                new Transactions(pin).setVisible(true);
                
               }
               }else if(ae.getSource()==b2) {
                    setVisible(false);
                new Transactions(pin).setVisible(true);
                 
                    }
                    }catch(Exception e){
                        e.printStackTrace();
                        
              }
              
          }
          public static void main(String[]args){
              new Withdrawl("").setVisible(true);
          }
} 
        
    
    

