package lastAssessment;

import java.util.ArrayList;

public class Deterministic {

	private ArrayList<Job> jobs = new ArrayList<Job>();
	private ArrayList<Machine> machines = new ArrayList<Machine>();
	

	
	//method create random number of machines, fill machine arrayList
	public void createMachines(int numMachines) {
		
		for (int i = 0; i < numMachines; i++) {
			Machine m = new Machine(i, 0);
			machines.add(m);			
		}
	}
	
	

	//method to create number of jobs with random job times (50/50 split)
	public void createJobs(int numJobs) {
		
		for (int i = 0; i < numJobs; i++) {
			double random = Math.random();
			
			if (random < 0.5) {
				Job j = new Job(5);
				jobs.add(j);
			} else {
				Job j = new Job(10);
				jobs.add(j);
			}
		}
	}
	
	
	//method to create number of jobs with random job times (25/75 split)
	public void createJobs25(int numJobs) {
		
		for (int i = 0; i < numJobs; i++) {
			double random = Math.random();
			
			if (random < 0.25) {
				Job j = new Job(5);
				jobs.add(j);
			} else {
				Job j = new Job(10);
				jobs.add(j);
			}
		}
	}
	
	
	//method to create number of jobs with random job times (75/25 split)
	public void createJobs75(int numJobs) {

		for (int i = 0; i < numJobs; i++) {
			double random = Math.random();

			if (random < 0.75) {
				Job j = new Job(5);
				jobs.add(j);
			} else {
				Job j = new Job(10);
				jobs.add(j);
			}
		}
	}
		


	public void assignJobs() {
		
		//time how long allocation process takes
		long startTime = System.nanoTime();
		
		
		//iterate through jobs
		for (int i = 0; i < jobs.size(); i++) {		
				
			int lowestTotal = 100000000;  //use super high number to ensure totalJobTimes is always less than this
			int lowestMachine = 0;
			
			//iterate through machines to find machine with the least amount of work assigned to it
			for (int j = 0; j < machines.size(); j++ ) {
				
				if (lowestTotal > machines.get(j).getTotalJobTimes()) {
					
					lowestTotal = machines.get(j).getTotalJobTimes();
					lowestMachine = machines.get(j).getMachId();
				}
			}
			
			
			//add job to jobs array list on machine with lowest amount of work
			machines.get(lowestMachine).getJobsOnMachine().add(jobs.get(i));

			//update total time on machine
			int newTotalTime = machines.get(lowestMachine).getTotalJobTimes() + jobs.get(i).getTime();
			machines.get(lowestMachine).setTotalJobTimes(newTotalTime);
		}
		
		
		//record time at end of running of algorithm, subtract from start time to find duration of algorithm
		long endTime = System.nanoTime();
		
		long duration = (endTime - startTime);
		System.out.println(duration / 1000);
	
		
	}
	
	
	//print total job times on each machine
	public void printTotalTimes() {
		
		for (int i = 0; i < machines.size(); i ++) {
			System.out.println("Total job times on machine " + machines.get(i).getMachId() + ": " + machines.get(i).getTotalJobTimes());
			ArrayList<Job>machineJobs = machines.get(i).getJobsOnMachine();
			//for (int j = 0; j < machineJobs.size(); j++) {
			//	System.out.print(machineJobs.get(j).toString());
			//}
		}
		System.out.println();
	}
	

	
	
	public static void main(String[] args) {
		
		Deterministic d1 = new Deterministic();
		Deterministic d2 = new Deterministic();
		Deterministic d3 = new Deterministic();
		Deterministic d4 = new Deterministic();
		Deterministic d5 = new Deterministic();
		Deterministic d6 = new Deterministic();
		Deterministic d7 = new Deterministic();
		Deterministic d8 = new Deterministic();
		Deterministic d9 = new Deterministic();
		Deterministic d10 = new Deterministic();
		Deterministic d11 = new Deterministic();
		Deterministic d12 = new Deterministic();
		Deterministic d13 = new Deterministic();
		Deterministic d14 = new Deterministic();
		Deterministic d15 = new Deterministic();
		Deterministic d16 = new Deterministic();
		Deterministic d17 = new Deterministic();
		Deterministic d18 = new Deterministic();
		Deterministic d19 = new Deterministic();
		Deterministic d20 = new Deterministic();
		Deterministic d21 = new Deterministic();
		Deterministic d22 = new Deterministic();
		Deterministic d23 = new Deterministic();
		Deterministic d24 = new Deterministic();
		Deterministic d25 = new Deterministic();
		
		
		//test 3 jobs on 2 machines - 50/50 split
		System.out.println("3 Jobs / 2 Machines");
		d25.createJobs(100);
		d25.createMachines(5);
		d25.assignJobs();
		d25.printTotalTimes();
		
		
		//test 20 jobs on 5 machines - 50/50 split
		System.out.println("20 Jobs / 5 Machines");
		d1.createJobs(100);
		d1.createMachines(5);
		d1.assignJobs();
		d1.printTotalTimes();	
		
		
		//test 100 jobs on 5 machines - 50/50 split
		System.out.println("100 Jobs / 5 Machines");
		d2.createJobs(100);
		d2.createMachines(5);
		d2.assignJobs();
		d2.printTotalTimes();	
		
		
		//test 1000 jobs on 10 machines - 50/50 split
		System.out.println("1000 Jobs / 10 Machines");
		d3.createJobs(1000);
		d3.createMachines(10);
		d3.assignJobs();
		d3.printTotalTimes();	
		
		
		//test 5000 jobs on 10 machines - 50/50 split
		System.out.println("5000 Jobs / 10 Machines");
		d4.createJobs(5000);
		d4.createMachines(10);
		d4.assignJobs();
		d4.printTotalTimes();	
		
		
		//test 5000 jobs on 50 machines - 50/50 split
		System.out.println("5000 Jobs / 50 Machines");
		d5.createJobs(5000);
		d5.createMachines(50);
		d5.assignJobs();
		d5.printTotalTimes();	
		
		
		//test 5000 jobs on 100 machines - 50/50 split
		System.out.println("5000 Jobs / 100 Machines");
		d6.createJobs(5000);
		d6.createMachines(100);
		d6.assignJobs();
		d6.printTotalTimes();	
		
		
		//test 10000 jobs on 20 machines - 50/50 split
		System.out.println("10000 Jobs / 20 Machines");
		d7.createJobs(10000);
		d7.createMachines(20);
		d7.assignJobs();
		d7.printTotalTimes();	
		
		
		//test 10000 jobs on 500 machines - 50/50 split
		System.out.println("10000 Jobs / 500 Machines");
		d8.createJobs(10000);
		d8.createMachines(500);
		d8.assignJobs();
		d8.printTotalTimes();
		
		
		//test 20 jobs on 5 machines - 25/75 split
		System.out.println("20 Jobs / 5 Machines");
		d9.createJobs25(20);
		d9.createMachines(5);
		d9.assignJobs();
		d9.printTotalTimes();	
		
		
		//test 100 jobs on 5 machines - 25/75 split
		System.out.println("100 Jobs / 5 Machines");
		d10.createJobs25(100);
		d10.createMachines(5);
		d10.assignJobs();
		d10.printTotalTimes();	
		
		
		//test 1000 jobs on 10 machines - 25/75 split
		System.out.println("1000 Jobs / 10 Machines");
		d11.createJobs25(1000);
		d11.createMachines(10);
		d11.assignJobs();
		d11.printTotalTimes();	
		
		
		//test 5000 jobs on 10 machines - 25/75 split
		System.out.println("5000 Jobs / 10 Machines");
		d12.createJobs25(5000);
		d12.createMachines(10);
		d12.assignJobs();
		d12.printTotalTimes();	
		
		
		//test 5000 jobs on 50 machines - 25/75 split
		System.out.println("5000 Jobs / 50 Machines");
		d13.createJobs25(5000);
		d13.createMachines(50);
		d13.assignJobs();
		d13.printTotalTimes();	
		
		
		//test 5000 jobs on 100 machines - 25/75 split
		System.out.println("5000 Jobs / 100 Machines");
		d14.createJobs25(5000);
		d14.createMachines(100);
		d14.assignJobs();
		d14.printTotalTimes();	
		
		
		//test 10000 jobs on 20 machines - 25/75 split
		System.out.println("10000 Jobs / 20 Machines");
		d15.createJobs25(10000);
		d15.createMachines(20);
		d15.assignJobs();
		d15.printTotalTimes();	
		
		
		//test 10000 jobs on 500 machines - 25/75 split
		System.out.println("10000 Jobs / 500 Machines");
		d16.createJobs25(10000);
		d16.createMachines(500);
		d16.assignJobs();
		d16.printTotalTimes();
		
		
		//test 20 jobs on 5 machines - 75/25 split
		System.out.println("20 Jobs / 5 Machines");
		d17.createJobs75(20);
		d17.createMachines(5);
		d17.assignJobs();
		d17.printTotalTimes();	
		
		
		//test 100 jobs on 5 machines - 75/25 split
		System.out.println("100 Jobs / 5 Machines");
		d18.createJobs75(100);
		d18.createMachines(5);
		d18.assignJobs();
		d18.printTotalTimes();	
		
		
		//test 1000 jobs on 10 machines - 75/25 split
		System.out.println("1000 Jobs / 10 Machines");
		d19.createJobs75(1000);
		d19.createMachines(10);
		d19.assignJobs();
		d19.printTotalTimes();	
		
		
		//test 5000 jobs on 10 machines - 75/25 split
		System.out.println("5000 Jobs / 10 Machines");
		d20.createJobs75(5000);
		d20.createMachines(10);
		d20.assignJobs();
		d20.printTotalTimes();	
		
		
		//test 5000 jobs on 50 machines - 75/25 split
		System.out.println("5000 Jobs / 50 Machines");
		d21.createJobs75(5000);
		d21.createMachines(50);
		d21.assignJobs();
		d21.printTotalTimes();	
		
		
		//test 5000 jobs on 100 machines - 75/25 split
		System.out.println("5000 Jobs / 100 Machines");
		d22.createJobs75(5000);
		d22.createMachines(100);
		d22.assignJobs();
		d22.printTotalTimes();	
		
		
		//test 10000 jobs on 20 machines - 75/25 split
		System.out.println("10000 Jobs / 20 Machines");
		d23.createJobs75(10000);
		d23.createMachines(20);
		d23.assignJobs();
		d23.printTotalTimes();	
		
		
		//test 10000 jobs on 500 machines - 75/25 split
		System.out.println("10000 Jobs / 500 Machines");
		d24.createJobs75(10000);
		d24.createMachines(500);
		d24.assignJobs();
		d24.printTotalTimes();
	
	}

}
