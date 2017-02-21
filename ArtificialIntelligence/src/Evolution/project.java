package Evolution;
import java.util.Random;

import nz.ac.vuw.kol.OptimisationFunction;

public class project {
	
	
	public static double getRandomNumInRange(double min, double max) {
		
		return Math.random() * ((max-min)) + min;
		
	}
	
	
	public static void main(String[] args) {
		
		//array of initial parent values
		double [] parent = {1,2,3,4,5};
		
		
		//time for while loop condition
		long time = System.currentTimeMillis();
		
		
		//run evolution
		while(System.currentTimeMillis() - time < 10000) {
			
			double random = getRandomNumInRange(-1, 1);
			
			
			//generate array of child values with random +- mutation values
			double [] child = {(parent[0]-random), (parent[1]-random), (parent[2]-random), (parent[3]-random), (parent[4]-random)};

			
			//if child is less than parent, then child becomes parent
			if(OptimisationFunction.unknownFunction(child) < OptimisationFunction.unknownFunction(parent)) {
				//this is currently never true
				parent = child;
				System.out.println("Parent: " + OptimisationFunction.unknownFunction(parent));
			}
			
			
			//print parent value
			//System.out.println("Parent: " + OptimisationFunction.unknownFunction(parent));
		}
		
		
		//print result at end (this is the minimum value of the function found by AI)
		System.out.println("Result: " + OptimisationFunction.unknownFunction(parent));
		System.out.println("Final parents: " + parent[0] + " " + parent[1] + " " + parent[2] + " " + parent[3] + " " + parent[4]);
	}
	

}
