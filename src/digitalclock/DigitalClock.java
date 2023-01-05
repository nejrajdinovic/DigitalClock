
package digitalclock;

/**
 *
 * @author Nejra
 */

import javax.swing.*;  
import java.text.*;  
import java.util.*;

public class DigitalClock implements Runnable{
    JFrame frame;
    Thread thread = null;
    int hours = 0, minutes = 0, seconds = 0;
    String timeScreen = "";
    JButton button;
    
    DigitalClock(){
        frame= new JFrame("Digital Clock");
        thread = new Thread(this);
        thread.start();
        
        button = new JButton();
        button.setBounds(100,100,100,50);
        
        frame.add(button);
        frame.setSize(350,400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
     
    public static void main(String[] args) {
        new DigitalClock();
    }

    @Override
    public void run() {
        try{
            while(true){
                Calendar calendar = Calendar.getInstance();
                hours = calendar.get(Calendar.HOUR);
              //  if ( hours > 12 ) hours -= 12;  
                minutes = calendar.get( Calendar.MINUTE );  
                seconds = calendar.get( Calendar.SECOND );  
                
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
                Date date = calendar.getTime();
                timeScreen = sdf.format(date);
                
                printTime();  

                thread.sleep( 1000 );  
            }
        }catch(Exception e){}
    }
    
    public void printTime(){
        button.setText(timeScreen);
    }
    
}
