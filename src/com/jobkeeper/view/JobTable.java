package com.jobkeeper.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;

import com.jobkeeper.constants.Constants;
import com.jobkeeper.model.Job;
import com.jobkeeper.model.JobTableModel;



public class JobTable extends JPanel {

	private JTable table;
	private JobTableModel jobTableModel;
	
	public JobTable() {
	
		jobTableModel = new JobTableModel();
		table = new JTable(jobTableModel);
		
		
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(new BorderLayout());
		add(new JScrollPane(table) , BorderLayout.CENTER);
		setBackground(Constants.maya);
		setPreferredSize(new Dimension(500,550));
		
	}
	
	
	public void setData(List<Job> db) {
		jobTableModel.setData(db);
	}
	
	public void refresh() {
		jobTableModel.fireTableDataChanged();
	}
}
