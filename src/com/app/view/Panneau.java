package com.app.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Panneau extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5875593774079770757L;

	public void paintComponent(Graphics g) {
		try {
			super.paintComponents(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.white);
			g2d.fillRect(0, 0, getWidth(), getHeight());
			Color Snow3 = new Color(205, 201, 201);
			g2d.setColor(Snow3);
			g2d.fillRoundRect(3, 87, 240, 280, 15, 15);

			g2d.setColor(Snow3);
			g2d.fillRoundRect(350, 7, 240, 60, 15, 15);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
