package com.jobkeeper.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


import com.jobkeeper.constants.Constants;
import com.jobkeeper.controller.Controller;
import com.jobkeeper.controller.FormEvent;
import com.jobkeeper.controller.FormListener;
import com.jobkeeper.model.Job;

public class FieldsPanel extends JPanel {

	// buttons
	private JButton addJobBtn;
	private JButton clearBtn;
	// labels
	private JLabel jobNameLabel;
	private JLabel jobPositionLabel;
	private JLabel jobLocationLabel;
	private JLabel jobNotesLabel;
	// fields
	private JTextField jobNameField;
	private JTextField jobPositionField;
	private JTextField jobLocationField;
	private JTextField jobNotesField;
	private FormListener formListener;
	private JobTable jobTable;

	public FieldsPanel(Controller controller) {

		jobNameLabel = new JLabel("Name: ");
		jobNameLabel.setFont(Constants.mvBoli2);

		jobPositionLabel = new JLabel("Position: ");
		jobPositionLabel.setFont(Constants.mvBoli2);

		jobLocationLabel = new JLabel("Location: ");
		jobLocationLabel.setFont(Constants.mvBoli2);

		jobNotesLabel = new JLabel("Notes: ");
		jobNotesLabel.setFont(Constants.mvBoli2);

		jobNameField = new JTextField(10);
		jobPositionField = new JTextField(10);
		jobLocationField = new JTextField(10);
		jobNotesField = new JTextField(10);
			
		jobTable = new JobTable();
		// Add Job Button
		addJobBtn = new JButton("Add");
		addJobBtn.setFont(Constants.mvBoli2);
		addJobBtn.setFocusable(false);
		addJobBtn.addActionListener(e -> {
			String name = jobNameField.getText();
			String position = jobPositionField.getText();
			String location = jobLocationField.getText();
			String notes = jobNotesField.getText()+" ";
			
//			controller.savetoFile(name, position, location, notes);
//			controller.addJob(name, position, location, notes);
//			controller.refresh();
//			
			
			FormEvent ev = new FormEvent(this, name, position, location, notes);
			if (formListener != null) {
				formListener.formEventOccured(ev);
				jobTable.refresh();
				
			}
			
		});

		// Clear Job Button
		clearBtn = new JButton("Clear");
		clearBtn.setFont(Constants.mvBoli2);
		clearBtn.setFocusable(false);
		clearBtn.addActionListener(e -> {
			jobNameField.setText("");
			jobPositionField.setText("");
			jobLocationField.setText("");
		});

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		////// First Row///// Name
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 0.1;
		// Name Label
		gc.gridx = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(jobNameLabel, gc);
		// Name Field
		gc.gridx = 1;
		gc.gridy = 0;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(jobNameField, gc);

		//////////// Next Row///////////////// Position
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.1;
		// Brand Label
		gc.gridx = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.LINE_END;
		// add(occupationLabel , gc);
		add(jobPositionLabel, gc);
		// Brand Field
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(jobPositionField, gc);

		///////////// Next Row//////////////////// Location
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.gridx = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(jobLocationLabel, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(jobLocationField, gc);
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 2.0;// was 1.0

        ///////////// Next Row//////////////////// Notes
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.gridx = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(jobNotesLabel, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(jobNotesField, gc);
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 2.0;// was 1.0

		// Button
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, -30, 0, 5);
		add(addJobBtn, gc);
		// clear button
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(0, 0, 0, -115);
		add(clearBtn, gc);

		Border innerBorder = BorderFactory.createTitledBorder("Place your Job");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setBackground(Constants.maya);
		setPreferredSize(new Dimension(300, 600));
	}
	
	public void setFormListener(FormListener listener) {
		this.formListener = listener;
	}
	
}
