package lab9;

public class SearchingAlgo {
	
	//create array of ints to search
	private int [] array = new int [] {1, 4, 8, 12, 16, 20, 24, 28, 32};

	//int that the user wants to find
	private int elementToFind = 28;
	
	//ints at elements start, middle, end
	private int start = 0;
	private int middle = array.length / 2;
	private int end = array.length-1;
	

	
	public void searchArray() {
		
		System.out.println("start: " + array[start] + " middle: " + array[middle] + " end: " + array[end]);
		
		
		//check if elementToFind falls within array or not
		if (elementToFind < array[start] || elementToFind > array[end]) {
			System.out.println("The element you want to find is not in this array");
		}
		
		
		//check if element is already located at start, middle or end indexes
		if (elementToFind == array[start]) {
			System.out.println("Element " + elementToFind + " is located at index: " + start);
		} else if (elementToFind == array[middle]) {
			System.out.println("Element " + elementToFind + " is located at index: " + middle);
		} else if (elementToFind == array[end]) {
			System.out.println("Element " + elementToFind + " is located at index: " + end);
		}
		
		
		
		if (elementToFind > array[start] && elementToFind < array[middle]) {
			
			end = middle;
			
			middle = (start + middle) / 2;
		
			//call method recursively
			searchArray();
		
		} else if (elementToFind > array[middle] && elementToFind < array[end]) {
		
			start = middle;
			
			middle = (middle + end) / 2;
			
			//call method recursively
			searchArray();
		}

	}
	
	
	public static void main(String[] args) {
		
		SearchingAlgo sa = new SearchingAlgo();
		
		sa.searchArray();

	}

}

