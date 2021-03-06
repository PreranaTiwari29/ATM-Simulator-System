
package atm.simulator.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Pin extends JFrame implements ActionListener  {
         JPasswordField t1,t2,t3;
         JButton b1,b2,b3;
         JLabel l1,l2,l3,l4;
         String pin;
         
     Pin(String pin){
        
         this.pin=pin;
        
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm/simulator/system/icons/atm.jpg"));
       Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel ll6= new JLabel(i3);
       ll6.setBounds(0, 0, 960, 1080);
       add(ll6);
           
        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System",Font.BOLD,16));
        
        l2 = new JLabel("New Pin:");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System",Font.BOLD,16));
        
        l3 = new JLabel("Re-Enter New Pin");
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("System",Font.BOLD,16));
        
       
        
        
        t1=new JPasswordField();
        t1.setFont(new Font("Raleway",Font.BOLD,25));
        
        t2=new JPasswordField();
        t2.setFont(new Font("Raleway",Font.BOLD,25));
        
        
        
        b1= new JButton("CHANGE");
        b2= new JButton("BACK");
        
         b1.addActionListener(this);
         b2.addActionListener(this);
         
         setLayout(null);
         
         l1.setBounds(280,330,800,60);
         ll6.add(l1);
         
         l2.setBounds(180, 390, 150, 40);
         ll6.add(l2);
         
         l3.setBounds(180,440,150,40);
         ll6.add(l3);
         
         
         
         t1.setBounds(350, 393, 180, 25);
         ll6.add(t1);
         
         t2.setBounds(350,443,180,25);
         ll6.add(t2);
         
         
         
         b1.setBounds(390,588, 150, 35);
         ll6.add(b1);
         
         b2.setBounds(390,633, 150, 35);
        ll6. add(b2);
         
         
         
             setSize(960,1080);
             setLocation(500,90);
             setUndecorated(true);
             setVisible(true);
             
         }
           public void actionPerformed(ActionEvent ae){
              try{
                  String npin = t1.getText();
                  String rpin = t2.getText();
                  
                  
                   if(ae.getSource()==b1){
                       if(npin.equals("")){
                          
                      JOptionPane.showMessageDialog(null,"Please Enter  New PIN");
                      
                       }  
                       
                       if(rpin.equals("")){
                          
                      JOptionPane.showMessageDialog(null," Please Re-Enter  New PIN");
                      
                       }  
                       
                       if(npin.equals(rpin)){
                           Conn c1 = new Conn();
                           String q1 = "update bank set pin = '"+rpin+"' where pin ='"+pin+"' ";
                           String q2 = "update login set pin = '"+rpin+"' where pin ='"+pin+"' ";
                           String q3 = "update signup3 set pin = '"+rpin+"' where pin ='"+pin+"' ";
                           
                           c1.s.executeUpdate(q1);
                           c1.s.executeUpdate(q2);
                           c1.s.executeUpdate(q3);
                           
                           JOptionPane.showMessageDialog(null,"PIN changed successfully");
                           setVisible(false);
                           new Transactions(pin).setVisible(true);
                           
                           
                           
                       }else{
                           JOptionPane.showMessageDialog(null,"PIN entered dosen't match");
                       }
                           
                       }else if(ae.getSource()==b2){
                           setVisible(false);
                          new Transactions(pin).setVisible(true);
                           
                       }
                       
                   }catch(Exception e){
                       e.printStackTrace();
                       
                   }
           }
           public static void main(String[]args){
               new Pin("").setVisible(true);
           }
}
                  
                  
        
           
           
       
    

