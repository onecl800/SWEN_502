package lastAssessment;

import java.util.ArrayList;

public class Machine {
	
	//variables
	private int machId;
	private int totalJobTimes;
	private ArrayList<Job> jobsOnMachine;
	
	
	//getters and setters
	public int getMachId() {
		return machId;
	}
	public void setMachId(int n) {
		machId = n;
	}
	public int getTotalJobTimes() {
		return totalJobTimes;
	}
	public void setTotalJobTimes(int tjt) {
		totalJobTimes = tjt;
	}
	public ArrayList<Job> getJobsOnMachine() {
		return jobsOnMachine;
	}
	public void setJobsOnMachine(ArrayList<Job> jobsOnMachine) {
		this.jobsOnMachine = jobsOnMachine;
	}
	
	
	
	//constructor
	public Machine(int id, int tjt) {
		machId = id;
		totalJobTimes = tjt;
		jobsOnMachine = new ArrayList<Job>();
	}
	
}
