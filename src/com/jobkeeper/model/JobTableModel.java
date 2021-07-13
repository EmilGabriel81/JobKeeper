package com.jobkeeper.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class JobTableModel extends AbstractTableModel {

	private List<Job> db;
	private String[] colNames = { "ID", "Name", "Position", "Location", "Date", "Notes" };

	public void setData(List<Job> db) {
		this.db = db;
	}

	@Override
	public String getColumnName(int column) {
		return colNames[column];
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return db.size();
	}

	@Override
	public Object getValueAt(int row, int col) {

		Job job = db.get(row);

		switch (col) {
		case 0:
			return job.getId();
		case 1:
			return job.getName();
		case 2:
			return job.getPosition();
		case 3:
			return job.getLocation();
		case 4:
			return job.getDate();
		case 5:
			return job.getNotes();

		}
		return null;

	}
}
