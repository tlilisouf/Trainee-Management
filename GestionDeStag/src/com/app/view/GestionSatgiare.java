package com.app.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.zip.DataFormatException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.JXSearchField;
import org.jdesktop.swingx.JXSearchField.LayoutStyle;

import com.app.entity.Stagiaire;
import com.toedter.calendar.JDateChooser;

import listeners.CRUDListner;

public class GestionSatgiare extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3250630574361853259L;

	private JPanel contentPane;
	private JTextField nomStagiaireField;
	private JTextField prenomStagiaireField;
	private JTextField CINField;
	private JTextField universiteField;
	private JTextField specialtyField;
	private JTextField horloge;
	private JButton ajouter;
	private JButton supprimer;
	private JButton modifier;

	private JLabel nomStagiaire;
	private JLabel prenomStagiaire;
	private JLabel CIN;
	private JLabel naissance;
	private JLabel Specialite;
	private JLabel universite;

	private JXSearchField searchField;
	private JScrollPane scrollPane;
	private JTable table;

	private CRUDListner controller;

	private int cinStagiaire = 0;

	private JDateChooser chooser;

	private DefaultTableModel dt;

	private String[] tabContenu;

	public String getCINStagiaire() {
		return CINField.getText();
	}

	public String getNomSatgaire() {
		return nomStagiaireField.getText();
	}

	public String getPreomSatgaire() {
		return prenomStagiaireField.getText();
	}

	public String getNaissSatgaire() throws DataFormatException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		Date inDate = null;
		inDate = chooser.getDate();
		try {
			inDate = dateFormat.parse((dateFormat.format(inDate)).trim());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateFormat.format(inDate);
	}

	public String getSpecSatgaire() {
		return specialtyField.getText();
	}

	public String getUniSatgaire() {
		return universiteField.getText();
	}

	public String getSearchField() {
		return searchField.getText();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				GestionSatgiare gs = new GestionSatgiare();
				gs.setVisible(true);
			}
		});
	}

	public GestionSatgiare() {
		setTitle("Gestion Stagiaire");
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(802, 409);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new Panneau();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.white);
		setContentPane(contentPane);
		getContentPane().setLayout(null);

		ajouter = new ButtonColor("Ajout", Color.BLACK);
		ajouter.setFont(new Font("Tahoma", Font.BOLD, 14));
		ajouter.setBounds(10, 336, 227, 23);
		getContentPane().add(ajouter);
		ajouter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					AddSatgiaire();
					nomStagiaireField.setText("");
					prenomStagiaireField.setText("");
					CINField.setText("");
					universiteField.setText("");
					specialtyField.setText("");
					chooser.setDate(new Date());
				} catch (DataFormatException e1) {
					e1.printStackTrace();
				}
			}
		});

		horloge = new JTextField();
		horloge.setForeground(Color.LIGHT_GRAY);
		horloge.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 34));
		horloge.setEditable(false);
		horloge.setBounds(10, 11, 156, 36);
		getContentPane().add(horloge);
		horloge.setColumns(5);

		nomStagiaire = new JLabel("Nom Stagiaire");
		nomStagiaire.setBounds(10, 90, 99, 23);
		getContentPane().add(nomStagiaire);

		prenomStagiaire = new JLabel("Prenom Stagiaire");
		prenomStagiaire.setBounds(10, 133, 99, 14);
		getContentPane().add(prenomStagiaire);

		CIN = new JLabel("CIN Stagiaire");
		CIN.setBounds(10, 179, 79, 14);
		getContentPane().add(CIN);

		naissance = new JLabel("Date Naissance");
		naissance.setBounds(10, 221, 89, 14);
		getContentPane().add(naissance);

		chooser = new JDateChooser();
		chooser.setLocale(Locale.US);
		chooser.setBounds(109, 218, 128, 20);

		getContentPane().add(chooser);

		universite = new JLabel("Universit\u00E9");
		universite.setBounds(10, 263, 79, 14);
		getContentPane().add(universite);

		Specialite = new JLabel("Specialit\u00E9");
		Specialite.setBounds(11, 301, 78, 14);
		getContentPane().add(Specialite);

		nomStagiaireField = new JTextField();
		nomStagiaireField.setBounds(109, 91, 128, 20);
		getContentPane().add(nomStagiaireField);
		nomStagiaireField.setColumns(10);

		prenomStagiaireField = new JTextField();
		prenomStagiaireField.setBounds(109, 130, 128, 20);
		getContentPane().add(prenomStagiaireField);
		prenomStagiaireField.setColumns(10);

		CINField = new JTextField();
		CINField.setBounds(109, 176, 128, 20);
		getContentPane().add(CINField);
		CINField.setColumns(10);

		universiteField = new JTextField();
		universiteField.setBounds(109, 260, 128, 20);
		getContentPane().add(universiteField);
		universiteField.setColumns(10);

		specialtyField = new JTextField();
		specialtyField.setBounds(109, 298, 128, 20);
		getContentPane().add(specialtyField);
		specialtyField.setColumns(10);

		supprimer = new ButtonColor("Supprimer", Color.BLACK);
		supprimer.setFont(new Font("Tahoma", Font.BOLD, 12));
		supprimer.setBounds(360, 39, 115, 23);
		getContentPane().add(supprimer);
		supprimer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				tabContenu = tableContent();
//				if (tabContenu.length == 6)
//					removeSearch();
				if (getSearchField().length() == 8) {
					removeSearch();
					showOntableSearch();
				}

			}
		});

		modifier = new ButtonColor("Modifier", Color.BLACK);
		modifier.setFont(new Font("Tahoma", Font.BOLD, 12));
		modifier.setBounds(480, 39, 99, 23);
		getContentPane().add(modifier);
		modifier.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tabContenu = tableContent();
//				if (tabContenu.length == 6)
//					modifyStagiaire(tabContenu);
				if (getSearchField().length() == 8)
					modifyStagiaire(tabContenu);
			}
		});

		searchField = new JXSearchField("CIN");
		searchField.setBounds(400, 11, 148, 20);
		searchField.setColumns(10);
		searchField.setLayoutStyle(LayoutStyle.MAC);
		getContentPane().add(searchField);

		searchField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (searchField.getText().length() == 8)
					searchStagiaire();
			}
		});
		scrollPane = new JScrollPane();
		scrollPane.setBounds(247, 90, 539, 57);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setRowHeight(34);
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setForeground(Color.BLACK);
		dt = new DefaultTableModel(new Object[][] {},
				new String[] { "CIN", "Nom", "Prenom", "Date naissance", "Université", "Specialité" });
		table.setModel(dt);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		Dimension d = table.getPreferredSize();
		table.setPreferredScrollableViewportSize(d);
		table.setFillsViewportHeight(true);

		Timer t = new Timer(1000, new ClockListener());
		t.start();

	}

	private void searchStagiaire() {
		if (getSearchField() != null) {
			if (controller != null) {
				cinStagiaire = ConvertCin(searchField.getText());
				if (cinStagiaire != 0)
					controller.SearchPerformed(cinStagiaire);
			}

		}
	}

	private void removeSearch() {
		if (controller != null) {
			cinStagiaire = ConvertCin(getSearchField());
			if (cinStagiaire != 0)
				controller.removePerformed(cinStagiaire);
		}
	}

	private void AddSatgiaire() throws DataFormatException {
		if (getNomSatgaire() != null && getPreomSatgaire() != null && getCINStagiaire() != null
				&& getUniSatgaire() != null) {
			if (controller != null) {
				cinStagiaire = ConvertCin(getCINStagiaire());
				if (cinStagiaire != 0)
					controller.addPerformed(new Stagiaire(cinStagiaire, getNomSatgaire(), getPreomSatgaire(),
							getNaissSatgaire(), getUniSatgaire(), getSpecSatgaire(), "", ""));
			}

		}
	}

	private void modifyStagiaire(String[] tabContenu) {
		if (getSearchField() != null) {
			if (controller != null) {
				cinStagiaire = ConvertCin(getSearchField());
				if (cinStagiaire != 0)
					controller.modifyPerformed(cinStagiaire, tabContenu);
			}

		}
	}

	private int ConvertCin(String cin) {
		try {
			if (!cin.isEmpty() && cin.length() == 8) {
				if (!cin.matches("^\\d+$"))
					JOptionPane.showMessageDialog(this, "CIN doit etre des chiffres");
				cinStagiaire = Integer.parseInt(cin);
			} else
				JOptionPane.showMessageDialog(this, "CIN doit etre 8 chiffres");
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		return cinStagiaire;

	}

	class ClockListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
			horloge.setText(df.format(Calendar.getInstance().getTime()));
		}
	}

	public void setRetieveListner(CRUDListner controllerR) {
		this.controller = controllerR;
	}

	public void addPerformed(CRUDListner controllerA) {
		this.controller = controllerA;
	}

	public void showOntable(Stagiaire stagiaire) {
		Object[] tableau = { stagiaire.getCin(), stagiaire.getNom(), stagiaire.getPrenom(),
				stagiaire.getDatenaissance(), stagiaire.getUniversite(), stagiaire.getSpecialite() };
		dt.addRow(tableau);
	}

	public void showOntableSearch(Object[] stagiaire) {
		if (table.getRowCount() >= 1)
			for (int i = 0; i < dt.getRowCount(); i++)
				dt.removeRow(i);
		dt.addRow(stagiaire);
	}

	private void showOntableSearch() {
		if (table.getRowCount() >= 1)
			for (int i = 0; i < dt.getRowCount(); i++)
				dt.removeRow(i);
	}

	private String[] tableContent() {
		tabContenu = new String[6];
		for (int i = 0; i < table.getColumnCount(); i++) {
			Object valeur = table.getValueAt(0, i);
			if (valeur != null)
				tabContenu[i] = valeur.toString();
		}
		return tabContenu;
	}

}
