package com.app.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.app.entity.RH;

import listeners.LoginListner;

public class Authentication extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -109322306736405915L;
	private JPanel contentPane;
	private JLabel authentication;
	private JLabel loginPersonnel;
	private JTextField loginField;
	private JLabel passwordPersonnel;
	private JPasswordField passwordField;
	private JButton loginAuth;
	private LoginListner controller;

	public Authentication() {
		setTitle("Authentication");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(361, 230);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.white);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		authentication = new JLabel("Authentication");
		authentication.setForeground(Color.BLUE);
		authentication.setFont(new Font("Tahoma", Font.BOLD, 24));
		authentication.setBounds(88, 11, 183, 23);
		contentPane.add(authentication);

		loginPersonnel = new JLabel("Login");
		loginPersonnel.setForeground(Color.BLUE);
		loginPersonnel.setFont(new Font("Tahoma", Font.BOLD, 14));
		loginPersonnel.setBounds(27, 78, 52, 17);
		contentPane.add(loginPersonnel);

		passwordPersonnel = new JLabel("Password");
		passwordPersonnel.setForeground(Color.BLUE);
		passwordPersonnel.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordPersonnel.setBounds(27, 118, 75, 14);
		contentPane.add(passwordPersonnel);
		loginField = new JTextField();
		loginField.setBounds(116, 75, 123, 20);
		contentPane.add(loginField);
		loginField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(116, 112, 123, 20);
		contentPane.add(passwordField);

		loginAuth = new ButtonColor("Login", Color.BLACK);
		loginAuth.setFont(new Font("Tahoma", Font.BOLD, 14));
		loginAuth.setBounds(116, 150, 123, 23);

		loginAuth.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				if (controller != null)
					controller
							.loginPerformed(new RH(loginField.getText(), String.valueOf(passwordField.getPassword())));

			}
		});
		contentPane.add(loginAuth);
	}

	public void setLoginListner(LoginListner controller) {
		this.controller = controller;
	}

}
