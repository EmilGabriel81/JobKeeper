package com.jobkeeper.view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.jobkeeper.constants.Constants;

public class Footer extends JPanel {
	
	/**
	 * 
	 *  Work in progress
	 *  
	 */
	
	private JButton searchBtn;
	private JButton modifyBtn;
	
	public Footer() {
	
		searchBtn = new JButton("Search");
		modifyBtn = new JButton("Modify");
		
		this.setPreferredSize(new Dimension(1024, 200));
		this.setBackground(Constants.maya);
		this.add(searchBtn);
		this.add(modifyBtn);
		
		searchBtn.setFont(Constants.mvBoli2);
		modifyBtn.setFont(Constants.mvBoli2);
		searchBtn.setBounds(100, 100, 150, 30);
		Border innerBorder = BorderFactory.createTitledBorder("Job Options");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		
		
	}

}
