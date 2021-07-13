package com.jobkeeper.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.jobkeeper.constants.Constants;
import com.jobkeeper.controller.Controller;
import com.jobkeeper.controller.FormEvent;
import com.jobkeeper.controller.FormListener;

public class MainFrame extends JFrame{
	
	private Controller controller;
	private FieldsPanel fieldsPanel;
	private JobTable jobTable;
	private JPanel mainPanel;
	private Footer footer;

	
	
	public MainFrame() {
		super("Job Keeper");

		controller = new Controller();
		footer = new Footer();
		
		fieldsPanel = new FieldsPanel(controller);
		
		jobTable = new JobTable();
	
		//controller.init();
		controller.loadFromFile();
		jobTable.setData(controller.getJobList());
		
		fieldsPanel.setFormListener(new FormListener() {
			
			@Override
			public void formEventOccured(FormEvent e) {
				controller.savetoFile(e.getName(),e.getPosition(),e.getLocation(),e.getNotes());
				controller.postJob(e);
				jobTable.refresh();
				
			}
		});
		
		getContentPane().add(jobTable, BorderLayout.NORTH);
		getContentPane().add(fieldsPanel, BorderLayout.WEST);
		jobTable.add(fieldsPanel, BorderLayout.WEST);
		getContentPane().add(footer, BorderLayout.WEST);
		
		
		
		
		this.setSize(new Dimension(1024, 768));
		setLocationRelativeTo(null);
		
		this.addWindowListener(new WindowAdapter() {
			 public void windowClosing(WindowEvent we) {
				 int input = JOptionPane.showConfirmDialog(null, 
			                "Do you want save and exit", "Select an Option...",JOptionPane.YES_NO_OPTION);
				 System.out.println(input);
				 if(input == JOptionPane.YES_OPTION) {
					 controller.saveAndExit();
					 System.exit(0);
				 }
			 }
		});
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
		
	}

	

}
