package Dsa_Arrays;

public class StockProfit {
	public static void main(String[] args) {
//		 TC = O(n^2)
//		
//		int arr[] = {6,2,9,5,1,4,9};
//		int profit = 0;
//		for(int i=0 ;i<arr.length-1; i++) {
//			for(int j=i+1; j<arr.length; j++) {
//				int temp = arr[j] - arr[i];
//				profit = Math.max(profit, temp);
//			}
//		}
//		System.out.println(profit);
		
		//TC = O(n)
		int prices[] = {6,2,9,5,1,4,9};
		int n = prices.length;
	        int profit=0;
	        int low = prices[0];
	        for(int i=1; i<n; i++){
	            int temp = prices[i] - low;
	            profit = Math.max(profit, temp);
	            if(prices[i] < low){
	                low = prices[i];
	            }
	            // or low =  Math.min(low, prices[i])
	        }
	        System.out.println(profit);
	}
}
