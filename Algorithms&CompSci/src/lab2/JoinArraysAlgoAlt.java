package lab2;

public class JoinArraysAlgoAlt {
		
	public static void joinArrays(int[]A, int[]B, int[]C) {
		
		//create variables to count through arrays each time something relevant happens
		int indexA = 0;
		int indexB = 0;
		int indexC = 0;
		
		//go through for loop while C array is not full
		while (indexC < C.length) {
			if (indexA < A.length && indexB < B.length) {
				//if element in A is less than element in B, then add to C array or when arrayB is all added
				if (A[indexA] < B[indexB]) {
					C[indexC] = A[indexA];
					indexA++;
					indexC++;
					System.out.println("A:" + indexA + " B:" + indexB + " C:" + indexC);
				//if element in B is less than element in A, then add to C array or when arrayA is all added
				} else if (A[indexA] > B[indexB]) {	
					C[indexC] = B[indexB];
					indexB++;
					indexC++;
					System.out.println("A:" + indexA + " B:" + indexB + " C:" + indexC);
				//if both are equal, then add both. Increment all counters, indexC twice
				} else if (A[indexA] == B[indexB]) {
					C[indexC] = A[indexA];
					C[indexC+1] = B[indexB];
					indexA++;
					indexB++;
				indexC = indexC + 2;
				System.out.println("A:" + indexA + " B:" + indexB + " C:" + indexC);
				}
			} else if (indexA >= A.length) {
				C[indexC] = B[indexB];
				indexB++;
				indexC++;			
			} else if (indexB >= B.length) {
					C[indexC] = A[indexA];
					indexA++;
					indexC++;
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		//create arrays A and B
		int [] A = {0, 5, 7, 15, 32, 78, 90};
		int [] B = {0, 10, 18, 32, 42, 68};
		
		//create empty array C with length of arrays A and B
		int [] C = new int [A.length + B.length];
		
		//call joinArrays method to combine arrayA and arrayB
		joinArrays(A, B, C);
		
		//print out combined array using for loops
		for (int i = 0; i < C.length; i++) {
			System.out.print(C[i] + " ");
		}
	}
	
}
