package lab2;

public class JoinArraysAlgo {
	public static void main(String[] args) {
		
		//create arrays A and B
		int [] A = {0, 5, 7, 15, 32, 78, 90};
		int [] B = {0, 10, 18, 42, 68};
		//create empty array C with length of arrays A and B
		int [] C = new int [A.length + B.length];
		
		//call joinArrays method to combine arrayA and arrayB
		joinArrays(A, B, C);
		
		//print out combined array using for loops
		for (int i = 0; i < C.length; i++) {
			System.out.print(C[i] + " ");
		}
	}

	
	public static void joinArrays(int[]A, int[]B, int[]C) {
		//create variables to count through arrays each time something relevant happens
		int indexA = 0;
		int indexB = 0;
		int indexC = 0;
		
		//while loop runs as long as indexA and indexB are both less than length of A and B arrays
		while (indexA < A.length && indexB < B.length) {
			//if A is smaller than B, then add A to current position in C array
			if (A[indexA] < B[indexB]) {
				//set the element at indexC to the element at indexA
				C[indexC] = A[indexA];
				//increment by adding 1 to indexA counter and 1 to indexC counter
				indexA++;
				indexC++;
			//if B is smaller than A, then add A to current position in C array
			} else if (A[indexA] > B[indexB]) {
				//set the element at indexC to the element at indexB
				C[indexC] = B[indexB];
				//increment by adding 1 to indexB counter and 1 to indexC counter
				indexB++;
				indexC++;
			//if elementA and elementB are equal, add both to arrayC and increment all counters (arrayC incremented twice)
			} else if (A[indexA] == B[indexB]) {
				//set the element at indexC to the element at indexA
				C[indexC] = A[indexA];
				//set the next element after indexC to the element at indexB
				C[indexC+1] = B[indexB];
				indexA++;
				indexB++;
				indexC = indexC + 2;
			}
		
		
		//handle the tail end of the unfinished array
		//if A array is complete, then go through for loop and add remaining items in B array to C array
		if (indexA == A.length) {
			//for loop starts from current position in array C (index C) and finishes when array C is full
			for (int i = indexC; i < C.length; i++) {
				//set the element at indexC to the element at indexB
				C[i] = B[indexB];
				indexB++;
				indexC++;			
				}
		//if B array is complete, then add remaining items in A array to C array
		} else if (indexB == B.length) {
			for (int i = indexC; i < C.length; i++) {
				//set the element at indexC to the element at indexA
				C[i] = A[indexA];
				indexA++;
				indexC++;
				}
			}
		}
	}

}
