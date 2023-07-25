import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;

public class Password_Generator extends JFrame implements ActionListener
{
   private String[] length_options = {"6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
 
   
   private JButton generate_button = new JButton("Generate Password");
   private JComboBox comboBox = new JComboBox();
   private int length_int;
   private boolean symbols, numbers, lowercase, uppercase, excludeSim, excludeAmb;
   private JCheckBox symbols_checkBox = new JCheckBox();
   private JCheckBox numbers_checkBox = new JCheckBox();
   private JCheckBox lowercase_checkBox = new JCheckBox();
   private JCheckBox uppercase_checkBox = new JCheckBox();
   private JTextField password_text = new JTextField();
  
    
    public Password_Generator(){
      create_frame1();
    }
    
    private void create_frame1(){
      
      comboBox = new JComboBox(length_options);
      comboBox.addActionListener(this);
      
      
      
      
      
     
      
      symbols_checkBox = new JCheckBox();
      symbols_checkBox.setText(" Include Symbols (e.g. @#$%)");
      symbols_checkBox.setFocusable(false);
      symbols_checkBox.addActionListener(this);
      
       
      numbers_checkBox = new JCheckBox();
      numbers_checkBox.setText(" Include Numbers (e.g. 123456)");
      numbers_checkBox.setFocusable(false);
      numbers_checkBox.addActionListener(this);
      
      lowercase_checkBox = new JCheckBox();
      lowercase_checkBox.setText("Include Lowercase Letters (e.g abcdefgh)");
      lowercase_checkBox.setFocusable(false);
      lowercase_checkBox.addActionListener(this);
      
      uppercase_checkBox = new JCheckBox();
      uppercase_checkBox.setText("Include Uppercase Letters (e.g ABCDEFGH)");
      uppercase_checkBox.setFocusable(false);
      uppercase_checkBox.addActionListener(this);
      
    
      generate_button = new JButton();
      generate_button.setText("Generate Password");
      generate_button.setSize(200,200);
      generate_button.addActionListener(this);
      
      password_text = new JTextField();
      password_text.setPreferredSize(new Dimension(300,50));
      
      
      
      
      
      
      JPanel rightPanel = new JPanel();
      rightPanel.setBounds(0,50,10,10);
   
      rightPanel.add(comboBox);
      
      rightPanel.add(symbols_checkBox);
      rightPanel.add(numbers_checkBox);
      rightPanel.add(lowercase_checkBox);
      rightPanel.add(uppercase_checkBox);
     
    
      rightPanel.add(generate_button);
      rightPanel.add(password_text);
    
      
  
     
      
     
      
            
      JFrame frame = new JFrame();
      frame.setTitle("Kadin's Password Generator");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(800,500);

      frame.setResizable(false);
      
      
 
      frame.add(rightPanel);
      frame.setVisible(true);
      
       if(symbols_checkBox.isSelected()) symbols = true;
       if(numbers_checkBox.isSelected()) numbers = true;
       if(lowercase_checkBox.isSelected()) lowercase = true;
       if(uppercase_checkBox.isSelected()) uppercase = true;
      
      
      
      }
      public void actionPerformed(ActionEvent e){
      
      if(e.getSource() == generate_button) 
         {
        
        password_text.setText(create_pass(symbols,numbers,lowercase,uppercase,length_int));
        
         
         }
      if(e.getSource() == comboBox)length_int = Integer.parseInt(length_options[comboBox.getSelectedIndex()]);
      if(e.getSource() == symbols_checkBox) symbols = symbols_checkBox.isSelected();
      if(e.getSource() == numbers_checkBox) numbers = numbers_checkBox.isSelected();
      if(e.getSource() == lowercase_checkBox) lowercase = lowercase_checkBox.isSelected();
      if(e.getSource() == uppercase_checkBox) uppercase = uppercase_checkBox.isSelected();
    
      
      }
      
      
    public static String create_pass(boolean symbols, boolean numbers, boolean lowercase, boolean uppercase, int length_of_string){
    int count = 1;
    
    StringBuilder test = new StringBuilder();
    for(int i = 0; i < length_of_string; i++){
    test.append("-");
    }
    
    Character[] symbol_options = {'!','@','#','$','%','&','*','^'}; //length of 8
    Character[] number_options = {'0','1','2','3','4','5','6','7','8','9'}; // length of 10
    Character[] lowercase_options = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'}; //length of 26
    Character[] uppercase_options = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'}; //length of 26     
    
   if(symbols && numbers && lowercase && uppercase){
      while(count != 0){
         count = 0;
         Random random = new Random();
         test.setCharAt(random.nextInt(test.length()), symbol_options[random.nextInt(8)]); //set random index a symbol
         test.setCharAt(random.nextInt(test.length()), number_options[random.nextInt(10)]); //set random index a number
         test.setCharAt(random.nextInt(test.length()), lowercase_options[random.nextInt(26)]); //set random index lowercase letter
         test.setCharAt(random.nextInt(test.length()), uppercase_options[random.nextInt(26)]); //set random index uppercase letter
         for(int i = 0; i < test.length(); i++) if(test.charAt(i) == '-') count+= 1;
         }
      return test.toString();
      }
      
    else if(symbols && numbers && lowercase && !uppercase){
      while(count != 0){
         count = 0;
         Random random = new Random();
         test.setCharAt(random.nextInt(test.length()), symbol_options[random.nextInt(8)]); 
         test.setCharAt(random.nextInt(test.length()), number_options[random.nextInt(10)]);
         test.setCharAt(random.nextInt(test.length()), lowercase_options[random.nextInt(26)]); 
         for(int i = 0; i < test.length(); i++) if(test.charAt(i) == '-') count+= 1;
         }
      return test.toString();
     }
   
     else if(symbols && numbers && !lowercase && uppercase){
      while(count != 0){
         count = 0;
         Random random = new Random();
         test.setCharAt(random.nextInt(test.length()), symbol_options[random.nextInt(8)]); 
         test.setCharAt(random.nextInt(test.length()), number_options[random.nextInt(10)]); 
         test.setCharAt(random.nextInt(test.length()), uppercase_options[random.nextInt(26)]);
         for(int i = 0; i < test.length(); i++) if(test.charAt(i) == '-') count+= 1;
         }
      return test.toString();
     }
     
     else if(symbols && numbers && !lowercase && !uppercase){
      while(count != 0){
         count = 0;
         Random random = new Random();
         test.setCharAt(random.nextInt(test.length()), symbol_options[random.nextInt(8)]); 
         test.setCharAt(random.nextInt(test.length()), number_options[random.nextInt(10)]); 
         for(int i = 0; i < test.length(); i++) if(test.charAt(i) == '-') count+= 1;
         }
      return test.toString();
     }
     
     else if(symbols && !numbers && lowercase && uppercase){
      while(count != 0){
         count = 0;
         Random random = new Random();
         test.setCharAt(random.nextInt(test.length()), symbol_options[random.nextInt(8)]); 
         test.setCharAt(random.nextInt(test.length()), uppercase_options[random.nextInt(26)]);
         test.setCharAt(random.nextInt(test.length()), lowercase_options[random.nextInt(26)]);
         for(int i = 0; i < test.length(); i++) if(test.charAt(i) == '-') count+= 1;
         }
      return test.toString();
     }
     
     else if(symbols && !numbers && lowercase && !uppercase){
      while(count != 0){
         count = 0;
         Random random = new Random();
         test.setCharAt(random.nextInt(test.length()), symbol_options[random.nextInt(8)]); 
         test.setCharAt(random.nextInt(test.length()), lowercase_options[random.nextInt(26)]);
         for(int i = 0; i < test.length(); i++) if(test.charAt(i) == '-') count+= 1;
         }
      return test.toString();
     }
     else if(symbols && !numbers && !lowercase && uppercase){
      while(count != 0){
         count = 0;
         Random random = new Random();
         test.setCharAt(random.nextInt(test.length()), symbol_options[random.nextInt(8)]); 
         test.setCharAt(random.nextInt(test.length()), uppercase_options[random.nextInt(26)]);
         for(int i = 0; i < test.length(); i++) if(test.charAt(i) == '-') count+= 1;  
         }
      return test.toString();
     }
     else if(symbols && !numbers && !lowercase && !uppercase){
      while(count != 0){
         count = 0;
         Random random = new Random();
         test.setCharAt(random.nextInt(test.length()), symbol_options[random.nextInt(8)]); 
         for(int i = 0; i < test.length(); i++) if(test.charAt(i) == '-') count+= 1;
         }
      return test.toString();
     }
     else if(!symbols && numbers && lowercase && uppercase){
      while(count != 0){
         count = 0;
         Random random = new Random();
         test.setCharAt(random.nextInt(test.length()), number_options[random.nextInt(10)]); 
         test.setCharAt(random.nextInt(test.length()), uppercase_options[random.nextInt(26)]);
         test.setCharAt(random.nextInt(test.length()), lowercase_options[random.nextInt(26)]);
         for(int i = 0; i < test.length(); i++) if(test.charAt(i) == '-') count+= 1;
         }
      return test.toString();
     }
     
     else if(!symbols && numbers && lowercase && !uppercase){
      while(count != 0){
         count = 0;
         Random random = new Random();
         test.setCharAt(random.nextInt(test.length()), number_options[random.nextInt(10)]); 
         test.setCharAt(random.nextInt(test.length()), lowercase_options[random.nextInt(26)]);
         for(int i = 0; i < test.length(); i++) if(test.charAt(i) == '-') count+= 1;
         }
      return test.toString();
     }
     
     else if(!symbols && numbers && !lowercase && uppercase){
      while(count != 0){
         count = 0;
         Random random = new Random();
         test.setCharAt(random.nextInt(test.length()), number_options[random.nextInt(10)]); 
         test.setCharAt(random.nextInt(test.length()), uppercase_options[random.nextInt(26)]);
         for(int i = 0; i < test.length(); i++) if(test.charAt(i) == '-') count+= 1; 
         }
      return test.toString();
     }
     
     else if(!symbols && numbers && !lowercase && !uppercase){
      while(count != 0){
         count = 0;
         Random random = new Random();
         test.setCharAt(random.nextInt(test.length()), number_options[random.nextInt(10)]); 
         for(int i = 0; i < test.length(); i++) if(test.charAt(i) == '-') count+= 1;
         }
      return test.toString();
     }
     
     else if(!symbols && !numbers && lowercase && uppercase){
      while(count != 0){
         count = 0;
         Random random = new Random();
         test.setCharAt(random.nextInt(test.length()), uppercase_options[random.nextInt(26)]);
         test.setCharAt(random.nextInt(test.length()), lowercase_options[random.nextInt(26)]);
         for(int i = 0; i < test.length(); i++) if(test.charAt(i) == '-') count+= 1;
         }
      return test.toString();
     }
     
     else if(!symbols && !numbers && lowercase && !uppercase){
      while(count != 0){
         count = 0;
         Random random = new Random();
         test.setCharAt(random.nextInt(test.length()), lowercase_options[random.nextInt(26)]);
         for(int i = 0; i < test.length(); i++) if(test.charAt(i) == '-') count+= 1;
         }
      return test.toString();
     }
     
     else if(!symbols && !numbers && !lowercase && uppercase){
      while(count != 0){
         count = 0;
         Random random = new Random();
         test.setCharAt(random.nextInt(test.length()), uppercase_options[random.nextInt(26)]);
         for(int i = 0; i < test.length(); i++) if(test.charAt(i) == '-') count+= 1;
         }
        return test.toString();
      }
         
     else if(!symbols && !numbers && !lowercase && !uppercase) return new String("What kind of password do you want then??");
     return new String("Something went wrong. Check code..");
     
   }
      
       public static void main(String[] args)
      {
      new Password_Generator();
      }
      

   
   
    
}