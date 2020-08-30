/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.lang.Math;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author hamza
 */
public class FXMLDocumentController implements Initializable {
    
    Double data = 0d;
    int operation = -1;
    boolean check = false;
    boolean deciClick = false;
    
    @FXML
    private Button clearE;
    @FXML
    private Button nine;
    @FXML
    private Button minus;
    @FXML
    private Button six;
    @FXML
    private Button negetive;
    @FXML
    private Button one;
    @FXML
    private TextField display;
    @FXML
    private Button clear;
    @FXML
    private Button seven;
    @FXML
    private Button sqroot;
    @FXML
    private Button percent;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button plus;
    @FXML
    private Button point;
    @FXML
    private Button fraction;
    @FXML
    private Button eight;
    @FXML
    private Button zero;
    @FXML
    private Button sqr;
    @FXML
    private Button four;
    @FXML
    private Button equals;
    @FXML
    private Button divide;
    @FXML
    private Button multiply;
    @FXML
    private Button five;   
    @FXML
    private Button backspace;

    JSONArray hisList = new JSONArray();
    
    public void writeFile(JSONArray h)
    {
        try (FileWriter file = new FileWriter("history.json");) {
            file.write(hisList.toJSONString());
            file.flush();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void handleButtonAction(ActionEvent event) {
        if (event.getSource() == zero)
        {
            if (check == true)
            {
                display.setText("");
            }   
            display.setText(display.getText() + "0");
            check = false;
        } 
        else if (event.getSource() == one)
        {
            if (check == true)
            {
                display.setText("");
            }
            display.setText(display.getText() + "1");
            check = false;
        } 
        else if (event.getSource() == two)
        {
            if (check == true)
            {
                display.setText("");
            }
            display.setText(display.getText() + "2");
            check = false;
        } 
        else if (event.getSource() == three)
        {
            if (check == true)
            {
                display.setText("");
            }
            display.setText(display.getText() + "3");
            check = false;
        } 
        else if (event.getSource() == four)
        {
            if (check == true)
            {
                display.setText("");
            }
            display.setText(display.getText() + "4");
            check = false;
        } 
        else if (event.getSource() == five)
        {
            if (check == true)
            {
                display.setText("");
            }
            display.setText(display.getText() + "5");
            check = false;
        } 
        else if (event.getSource() == six)
        {
            if (check == true)
            {
                display.setText("");
            }
            display.setText(display.getText() + "6");
            check = false;
        } 
        else if (event.getSource() == seven)
        {
            if (check == true)
            {
                display.setText("");
            }
            display.setText(display.getText() + "7");
            check = false;
        } 
        else if (event.getSource() == eight)
        {
            if (check == true)
            {
                display.setText("");
            }
            display.setText(display.getText() + "8");
            check = false;
        } 
        else if (event.getSource() == nine)
        {
            if (check == true)
            {
                display.setText("");
            }
            display.setText(display.getText() + "9");
            check = false;
        } 
        else if (event.getSource() == point) 
        {
            if (check == true)
            {
                display.setText("0");
            }
            if(!display.getText().contains(".")){
                display.setText(display.getText() + ".");
            }
            check = false;
        } 
        else if (event.getSource() == backspace)
        {
            if (display.getText().length()>0)
            {
                StringBuffer sb = new StringBuffer(display.getText());
                sb = sb.deleteCharAt(display.getText().length()-1);
                display.setText(sb.toString());;
            }
        }
        else if (event.getSource() == negetive) 
        {
            Double ng = Double.parseDouble(display.getText());
            ng = ng * -1;
            display.setText(String.valueOf(ng));
            check = true;
        } 
        else if(event.getSource() == plus)
        {
            data = Double.parseDouble(display.getText());
            operation = 1;
            check = true;
        } 
        else if(event.getSource() == minus)
        {
            data = Double.parseDouble(display.getText());
            operation = 2;
            check = true;
        } 
        else if(event.getSource() == multiply)
        {
            data = Double.parseDouble(display.getText());
            operation = 3;
            check = true;
        } 
        else if(event.getSource() == divide)
        {
            data = Double.parseDouble(display.getText());
            operation = 4;
            check = true;
        } 
        else if(event.getSource() == clear)
        {
            display.setText("");
            data = null;
        } 
        else if(event.getSource() == clearE) 
        {
            display.setText("");
        } 
        else if(event.getSource() == sqroot) 
        {
            display.setText(String.valueOf(Math.sqrt(Double.parseDouble(display.getText()))));
            check = true;
        } 
        else if (event.getSource() == percent)
        {
            Double scnOperand = Double.parseDouble(display.getText());
            if (operation == 1 || operation == 2)
            {
                scnOperand =  scnOperand * data / 100;
                display.setText(String.valueOf(scnOperand));
            }
            else if (operation == 3 || operation == 4)
            {
                scnOperand =  scnOperand / 100;
                display.setText(String.valueOf(scnOperand));
            }
            else 
            {
                display.setText("0");
                check = true;
            }
        }
        else if (event.getSource() == sqr) 
        {
            Double square = Double.parseDouble(display.getText());
            square = square * square;
            display.setText(String.valueOf(square));
            check = true;
        } 
        else if (event.getSource() == fraction) 
        {
            Double frac = Double.parseDouble(display.getText());
            frac = 1 / frac;
            display.setText(String.valueOf(frac));
            check = true;
        }
        else if(event.getSource() == equals)
        {
            JSONObject history = new JSONObject();
            Double secondOperand = Double.parseDouble(display.getText());
            Double ans;

            switch (operation)
            {
                case 1:
                    ans = data + secondOperand;
                    display.setText(String.valueOf(ans));
                    history.put("Latest answer", ans);
                    hisList.add(history);
                    writeFile(hisList);
                    break;
                case 2:
                    ans = data - secondOperand;
                    display.setText(String.valueOf(ans));
                    history.put("Latest answer", ans);
                    hisList.add(history);
                    writeFile(hisList);
                    break;
                case 3:
                    ans = data * secondOperand;
                    display.setText(String.valueOf(ans));
                    history.put("Latest answer", ans);
                    hisList.add(history);
                    writeFile(hisList);
                    break;
                case 4:
                    ans = 0d;
                    try {
                        ans = data / secondOperand;
                    }catch(Exception e) {display.setText("Error");}
                    display.setText(String.valueOf(ans));
                    history.put("Latest answer", ans);
                    hisList.add(history);
                    writeFile(hisList);
                    break;
            }
            check = true;
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
