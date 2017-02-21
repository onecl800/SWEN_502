package lastAssessment;

import java.util.ArrayList;

public class Probabilistic {

	private ArrayList<Job> jobs = new ArrayList<Job>();
	private ArrayList<Machine> machines = new ArrayList<Machine>();
	

	
	//method to create number of machines, fill machine arrayList
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
			int random = (int)(Math.random());
			
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
			int random = (int)(Math.random());

			if (random < 0.75) {
				Job j = new Job(5);
				jobs.add(j);
			} else {
				Job j = new Job(10);
				jobs.add(j);
			}
		}
	}
	
	

	//not complete
	public void assignJobs() {
		
		//iterate through jobs and machines to allocate jobs
		for (int i = 0; i < jobs.size(); i++) {		
			
			double randomAction = Math.random();
			
			if (randomAction < 0.5) {
			
				//find machine with the least amount of work assigned to it
				int lowestTotal = 1000000;
				int lowestMachine = 0;

				for (int j = 0; j < machines.size(); j++ ) {

					if (lowestTotal > machines.get(j).getTotalJobTimes()) {

						lowestTotal = machines.get(j).getTotalJobTimes();
						lowestMachine = machines.get(j).getMachId();
					}
					//add job to machine with lowest amount of work
					machines.get(lowestMachine).getJobsOnMachine().add(jobs.get(i));

					//update total time on machine
					int machineTime = machines.get(lowestMachine).getTotalJobTimes() + jobs.get(i).getTime();
					machines.get(lowestMachine).setTotalJobTimes(machineTime);
				}

			} else {
				
				//some other course of action 
				
			}
			
			

		}
	
		
	}
	
	
	//print total job times on each machine
	public void printTotalTimes() {
		
		for (int i = 0; i < machines.size(); i ++) {
			System.out.println("Total job times on machine " + machines.get(i).getMachId() + ": " + machines.get(i).getTotalJobTimes());
			ArrayList<Job>machineJobs = machines.get(i).getJobsOnMachine();
			for (int j = 0; j < machineJobs.size(); j++) {
			//	System.out.print(machineJobs.get(j).toString());
			}
			System.out.println();
		}
	}
	

	
	
	public static void main(String[] args) {
		
		Probabilistic p1 = new Probabilistic();
		Probabilistic p2 = new Probabilistic();
		Probabilistic p3 = new Probabilistic();
		Probabilistic p4 = new Probabilistic();
		Probabilistic p5 = new Probabilistic();
		Probabilistic p6 = new Probabilistic();
		Probabilistic p7 = new Probabilistic();
		Probabilistic p8 = new Probabilistic();
		Probabilistic p9 = new Probabilistic();
		Probabilistic p10 = new Probabilistic();
		Probabilistic p11 = new Probabilistic();
		Probabilistic p12 = new Probabilistic();
		Probabilistic p13 = new Probabilistic();
		Probabilistic p14 = new Probabilistic();
		Probabilistic p15 = new Probabilistic();
		Probabilistic p16 = new Probabilistic();
		Probabilistic p17 = new Probabilistic();
		Probabilistic p18 = new Probabilistic();
		Probabilistic p19 = new Probabilistic();
		Probabilistic p20 = new Probabilistic();
		Probabilistic p21 = new Probabilistic();
		Probabilistic p22 = new Probabilistic();
		Probabilistic p23 = new Probabilistic();
		Probabilistic p24 = new Probabilistic();
		
		
		//test 20 jobs on 5 machines - 50/50 split
		System.out.println("20 Jobs / 5 Machines");
		p1.createJobs(20);
		p1.createMachines(5);
		p1.assignJobs();
		p1.printTotalTimes();	
		
		
		//test 100 jobs on 5 machines - 50/50 split
		System.out.println("100 Jobs / 5 Machines");
		p2.createJobs(100);
		p2.createMachines(5);
		p2.assignJobs();
		p2.printTotalTimes();	
		
		
		//test 1000 jobs on 10 machines - 50/50 split
		System.out.println("1000 Jobs / 10 Machines");
		p3.createJobs(1000);
		p3.createMachines(10);
		p3.assignJobs();
		p3.printTotalTimes();	
		
		
		//test 5000 jobs on 10 machines - 50/50 split
		System.out.println("5000 Jobs / 10 Machines");
		p4.createJobs(5000);
		p4.createMachines(10);
		p4.assignJobs();
		p4.printTotalTimes();	
		
		
		//test 5000 jobs on 50 machines - 50/50 split
		System.out.println("5000 Jobs / 50 Machines");
		p5.createJobs(5000);
		p5.createMachines(50);
		p5.assignJobs();
		p5.printTotalTimes();	
		
		
		//test 5000 jobs on 100 machines - 50/50 split
		System.out.println("5000 Jobs / 100 Machines");
		p6.createJobs(5000);
		p6.createMachines(100);
		p6.assignJobs();
		p6.printTotalTimes();	
		
		
		//test 10000 jobs on 20 machines - 50/50 split
		System.out.println("10000 Jobs / 20 Machines");
		p7.createJobs(10000);
		p7.createMachines(20);
		p7.assignJobs();
		p7.printTotalTimes();	
		
		//test 10000 jobs on 500 machines - 50/50 split
		System.out.println("10000 Jobs / 500 Machines");
		p8.createJobs(10000);
		p8.createMachines(500);
		p8.assignJobs();
		p8.printTotalTimes();


		
		//test 20 jobs on 5 machines - 25/75 split
		System.out.println("20 Jobs / 5 Machines");
		p9.createJobs25(20);
		p9.createMachines(5);
		p9.assignJobs();
		p9.printTotalTimes();	


		//test 100 jobs on 5 machines - 25/75 split
		System.out.println("100 Jobs / 5 Machines");
		p10.createJobs25(100);
		p10.createMachines(5);
		p10.assignJobs();
		p10.printTotalTimes();	


		//test 1000 jobs on 10 machines - 25/75 split
		System.out.println("1000 Jobs / 10 Machines");
		p11.createJobs25(1000);
		p11.createMachines(10);
		p11.assignJobs();
		p11.printTotalTimes();	


		//test 5000 jobs on 10 machines - 25/75 split
		System.out.println("5000 Jobs / 10 Machines");
		p12.createJobs25(5000);
		p12.createMachines(10);
		p12.assignJobs();
		p12.printTotalTimes();	


		//test 5000 jobs on 50 machines - 25/75 split
		System.out.println("5000 Jobs / 50 Machines");
		p13.createJobs25(5000);
		p13.createMachines(50);
		p13.assignJobs();
		p13.printTotalTimes();	


		//test 5000 jobs on 100 machines - 25/75 split
		System.out.println("5000 Jobs / 100 Machines");
		p14.createJobs25(5000);
		p14.createMachines(100);
		p14.assignJobs();
		p14.printTotalTimes();	


		//test 10000 jobs on 20 machines - 25/75 split
		System.out.println("10000 Jobs / 20 Machines");
		p15.createJobs25(10000);
		p15.createMachines(20);
		p15.assignJobs();
		p15.printTotalTimes();	

		//test 10000 jobs on 500 machines - 25/75 split
		System.out.println("10000 Jobs / 500 Machines");
		p16.createJobs25(10000);
		p16.createMachines(500);
		p16.assignJobs();
		p16.printTotalTimes();



		//test 10 jobs on 5 machines - 75/25 split
		System.out.println("10 Jobs / 5 Machines");
		p17.createJobs75(10);
		p17.createMachines(5);
		p17.assignJobs();
		p17.printTotalTimes();	


		//test 100 jobs on 5 machines - 75/25 split
		System.out.println("100 Jobs / 5 Machines");
		p18.createJobs75(100);
		p18.createMachines(5);
		p18.assignJobs();
		p18.printTotalTimes();	


		//test 1000 jobs on 10 machines - 75/25 split
		System.out.println("1000 Jobs / 10 Machines");
		p19.createJobs75(1000);
		p19.createMachines(10);
		p19.assignJobs();
		p19.printTotalTimes();	


		//test 5000 jobs on 10 machines - 75/25 split
		System.out.println("5000 Jobs / 10 Machines");
		p20.createJobs75(5000);
		p20.createMachines(10);
		p20.assignJobs();
		p20.printTotalTimes();	


		//test 5000 jobs on 50 machines - 75/25 split
		System.out.println("5000 Jobs / 50 Machines");
		p21.createJobs75(5000);
		p21.createMachines(50);
		p21.assignJobs();
		p21.printTotalTimes();	


		//test 5000 jobs on 100 machines - 75/25 split
		System.out.println("5000 Jobs / 100 Machines");
		p22.createJobs75(5000);
		p22.createMachines(100);
		p22.assignJobs();
		p22.printTotalTimes();	

		//test 10000 jobs on 20 machines - 75/25 split
		System.out.println("10000 Jobs / 20 Machines");
		p23.createJobs75(10000);
		p23.createMachines(20);
		p23.assignJobs();
		p23.printTotalTimes();	

		//test 10000 jobs on 500 machines - 75/25 split
		System.out.println("10000 Jobs / 500 Machines");
		p24.createJobs75(10000);
		p24.createMachines(500);
		p24.assignJobs();
		p24.printTotalTimes();
		
	}

}
