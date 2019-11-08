

import java.text.NumberFormat;

/* 
 * @HomeWork #5-1: SalesAp.java
 * @Author: WanLing Hsieh
 * @Description: Print the whole Sales Report table, 
 * 		calculate sales by resign, by quarter and all. 	
 */
public class SalesApp {
	public static void main(String[] args) {	        
		// display a welcome message
		System.out.println("Welcome to the Sales Report Application");
		System.out.println();
		
		// store data in a rectangular array
		double[][] sales = { 
			    { 1540.0, 2010.0, 2450.0, 1845.0 }, 
			    { 1130.0, 1168.0, 1847.0, 1491.0 }, 
			    { 1580.0, 2305.0, 2710.0, 1284.0 }, 
			    { 1105.0, 4102.0, 2391.0, 1576.0 }
			};
		
		// get the currency formatters
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		 
		//The first section of the report
		// print table header
		System.out.println("Region\tQ1\t\tQ2\t\tQ3\t\tQ4");
		// Use nested for loops to display the sales table
		int row, col; // Array indices   
		int regionNum;
		double sum = 0;
		// print elements in row i
		for(row = 0; row < sales.length; row++) {
			regionNum = row+1;
			System.out.print(regionNum + "\t" ); 
			// print element j in row i
			for (col = 0; col < sales[row].length; col++) {
				System.out.print(currency.format(sales[row][col]) + "\t");
		    	// calculate total sales
		    	sum += sales[row][col];
		    }
		    System.out.println();
		}
		
		// The second section of the report
		System.out.println();
		System.out.println("Sales by region:");
		// print sales by region
		row_sum(sales);
		
		//The third section of the report
		System.out.println();
		System.out.println("Sales by quarter:");
		// print sales by quarter
		col_sum(sales);
		System.out.println();
		
		//The fourth section of the report
		System.out.print("Total annual sales, all regions: " + currency.format(sum) + "\t");
	} // end main

   	/* Use nested for loops to calculate the sales by region
   	 * by adding up the quarterly sales for each region.*/
   	public static void row_sum(double arr[][]) {
		int i, j, regionNum; 
		double sum = 0.0;
		for (i = 0; i < 4; ++i) {
			for (j = 0; j < 4; ++j) {
				/* add the element 
				 * row0 = [0][0] +[0][1] +[0][2] +[0][3] 
				 * row1 = [1][0] +[1][1] +[1][2] +[1][3]
				 * row2 = [2][0] +[2][1] +[2][2] +[2][3]
				 * row3 = [3][0] +[3][1] +[3][2] +[3][3]
				 */
				sum = sum + arr[i][j];
			}
            // get the currency formatters
            NumberFormat currency = NumberFormat.getCurrencyInstance();
        	regionNum = i+1;
			// print row sum
			System.out.println("Resion " + regionNum + ": " + currency.format(sum));	
			// rest the sum
			sum = 0; 
		}
	} // end row_sum
   	
   	/* Use nested for loops to calculate the sales by quarter
   	 * by adding up the individual region sales for each quarter. */
   	public static void col_sum(double arr[][]) {
		int i, j, q; 
		double sum = 0.0;
		for (i = 0; i < 4; ++i) {
			for (j = 0; j < 4; ++j) {
				/* add the element 
				 * col0 = [0][0] +[1][0] +[2][0] +[3][0] 
				 * col1 = [0][1] +[1][1] +[2][1] +[3][1]
				 * col2 = [0][2] +[1][2] +[2][2] +[3][2]
				 * col3 = [0][3] +[1][3] +[2][3] +[3][3]
				 */
				sum = sum + arr[j][i];
			}
            // get the currency formatters
            NumberFormat currency = NumberFormat.getCurrencyInstance();
        	q = i+1;
			
			// print col sum
			System.out.println("Q" + q + ": " + currency.format(sum));	
			// rest the sum
			sum = 0; 
			}
   	}
}
