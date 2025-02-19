package org.example.Ceasar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame implements ActionListener {

  JPanel panel = new JPanel(new GridLayout(5, 1,10,10));

  JLabel title = new JLabel("Sezar Sifreleme");
  JLabel label = new JLabel("Sifrelemek(encrypt) mi yoksa");
  JLabel label2 = new JLabel("Sifresini Cozmek(decrypt) mi yoksa");

  JButton encrypt = new JButton("Encrypt");
  JButton decrypt = new JButton("Decrypt");

  MainScreen() {
    this.setTitle("Ceasar");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(500, 500);

    title.setFont(new Font("Arial", Font.BOLD, 20));
    label.setFont(new Font("Segoe Script", Font.ITALIC, 20));
    label2.setFont(new Font("Segoe Script", Font.ITALIC, 20));

    panel.add(title, BorderLayout.NORTH);
    panel.add(label, BorderLayout.CENTER);
    panel.add(label2, BorderLayout.CENTER);

    encrypt.addActionListener(this);
    decrypt.addActionListener(this);

    panel.add(encrypt, BorderLayout.SOUTH);
    panel.add(decrypt, BorderLayout.SOUTH);


    this.add(panel);
    this.setVisible(true);
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == encrypt) {
      this.dispose();
      Encrypt encrypt = new Encrypt();
    }
    else if (e.getSource() == decrypt) {
      this.dispose();
      Decrypt decrypt = new Decrypt();
    }
  }
}
