package org.example.Ceasar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Encrypt extends JFrame implements ActionListener {

  String SYMBOLS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

  JPanel keyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
  JPanel messagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));


  JLabel title = new JLabel("Sifreleme(encrypt)");
  JLabel keyLabel = new JLabel("key(anahhtar)");
  JLabel messageLabel = new JLabel("message(mesaj)");

  JTextField keyText = new JTextField(5);
  JTextField messageText = new JTextField(10);

  JButton encryptButton = new JButton("Encrypt");


  Encrypt(){
    this.setTitle("Encrypt");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new GridLayout(4,1,10,10));
    this.setSize(500, 500);

    title.setFont(new Font("Serif", Font.BOLD, 20));
    this.add(title);

    keyLabel.setFont(new Font("Serif", Font.BOLD, 20));
    keyLabel.setBorder(BorderFactory.createLineBorder(Color.RED,2));
    messageLabel.setFont(new Font("Serif", Font.BOLD, 20));
    messageLabel.setBorder(BorderFactory.createLineBorder(Color.RED,2));

    keyText.setFont(new Font("Segoe Script", Font.ITALIC, 20));
    messageText.setFont(new Font("Segoe Script", Font.ITALIC, 15));

    keyPanel.add(keyLabel);
    keyPanel.add(keyText);
    messagePanel.add(messageLabel);
    messagePanel.add(messageText);

    encryptButton.setFont(new Font("Serif", Font.BOLD, 20));
    encryptButton.addActionListener(this);

    this.add(keyPanel);
    this.add(messagePanel);
    this.add(encryptButton);
    this.setVisible(true);
  }
  @Override
  public void actionPerformed(ActionEvent e) {

    String result = "";
    String numberSlideStr = keyText.getText();
    int numberSlide;

    try {
      numberSlide = Integer.parseInt(numberSlideStr);
    } catch (NumberFormatException ex) {
      JOptionPane.showMessageDialog(this, "Anahtar sayısal olmalı!", "Hata", JOptionPane.ERROR_MESSAGE);
      return;
    }

    String message = messageText.getText().toUpperCase();

    for (char letter : message.toCharArray()) {
      int index = SYMBOLS.indexOf(letter);
      for (int i = 0; i < numberSlide; i++){
        if (index == SYMBOLS.length()){
          index = 0;
        }
        else {
          index++;
        }

      }
      if (index != -1) {

        result += SYMBOLS.charAt(index);
      } else {
        result += letter;
      }
    }

    System.out.println(result);
    JOptionPane.showMessageDialog(this, result, "Şifrelenmiş Mesaj", JOptionPane.INFORMATION_MESSAGE);
  }


}
