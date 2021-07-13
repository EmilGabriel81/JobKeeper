package com.jobkeeper.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.jobkeeper.model.Database;
import com.jobkeeper.model.Job;
import com.jobkeeper.view.JobTable;

public class Controller {

	private Database db;
	private JobTable jobTable;
	private List<Job> cache;

	public Controller() {

		db = new Database();
		jobTable = new JobTable();
		cache = new ArrayList<Job>();

	}

	public void init() {
		Job job = new Job("Coca-Cola", "Engineer", "USA/Texas", this.getlocalTime());
		Job job1 = new Job("Pepsi-Cola", "Mechanic", "USA/California", this.getlocalTime());
		Job job2 = new Job("Frutty-Fresh", "Salesman", "Ro/Bucharest", this.getlocalTime());
		db.addJob(job);
		db.addJob(job1);
		db.addJob(job2);
	}

	public List<Job> getJobList() {
		return db.getJobs();
	}

	public String getlocalTime() {
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);
		System.out.println(" The date is : " + formattedDate);
		return formattedDate;

	}

	public void loadFromFile() {

		String fileName = "resources/Jobs.txt";
		String line = "";
		db.getJobs().clear();

		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while ((line = br.readLine()) != null) {
				fetchData(line);
				// System.out.println(line);
			}

		} catch (Exception e) {
			// System.err.println(e.getStackTrace());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "The system cannot find the specified file", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void fetchData(String line) {
		if (line != "") {
			String[] tokens = line.split(",");
			int id = Integer.parseInt(tokens[0]);
			String name = tokens[1];
			String position = tokens[2];
			String location = tokens[3];
			String date = tokens[4];
			String notes = tokens[5];
			db.addJob(new Job(id, name, position, location, date, notes));
		}

	}

	public void addJob(String name, String position, String location, String notes) {
//		int tempId = 0;
//
//		try {
//
//			tempId = this.getJobList().get(this.getJobList().size() - 1).getId();
//			System.out.println(tempId);
//
//		} catch (IndexOutOfBoundsException e) {
//			System.out.println("List empty, initialising list ...");
//		}
//
//		Job job = new Job(++tempId, name, position, location, this.getlocalTime(), notes);
//		//cacheList.add(job);
//
//		System.out.println(job.toString());
//		System.out.println("size is: " + this.getJobList().size());

	}

	public void saveAndExit() {

//		for (Job job : this.getJobList()) {
//			savetoFile(job);
//		}
	}

	public boolean savetoFile(Job job) {
		int id = job.getId();
		String name = job.getName();
		String position = job.getPosition();
		String location = job.getLocation();
		String date = job.getDate();
		String notes = job.getNotes();
		boolean result = false;

		try {
			FileWriter fw = new FileWriter("resources/Jobs.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.println(id + "," + name + "," + position + "," + location + "," + date + "," + notes);
			result = true;
			pw.flush();
			pw.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Records not saved" + "\n" + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			// System.out.println(e.getMessage());
		}
		return result;
	}

	public void savetoFile(String name, String position, String location, String notes) {
		int tempId = 0;

		try {

			tempId = this.getJobList().get(this.getJobList().size() - 1).getId();
			System.out.println(tempId);

		} catch (IndexOutOfBoundsException e) {
			System.out.println("List empty, initialising list ...");
		}
		
		Job job = new Job(++tempId, name, position, location, this.getlocalTime(), notes);
		savetoFile(job);
	}

	
	public void refresh () {
		this.jobTable.refresh();
	}

	public void postJob(FormEvent e) {
		String name = e.getName();
		String position = e.getPosition();
		String location = e.getLocation();
		String date = e.getDate();
		String notes = e.getNotes();
		//Job job = new Job(id, name, position, location, date, notes);
		
		
	}
}
