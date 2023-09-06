package com.vaishhh.medicinetracker;

public class discount 
{


	    // Function to calculate the discounted price
	    public static int  calculateDiscountedPrice(int originalPrice,int discountPercentage) {
	        if (originalPrice < 0 || discountPercentage < 0 || discountPercentage > 100) {
	            throw new IllegalArgumentException("Invalid input: price and discount percentage should be non-negative, and discount percentage should be between 0 and 100.");
	        }

	        int discountAmount = originalPrice * (discountPercentage / 100);
	        int discountedPrice = originalPrice - discountAmount;
	        return discountedPrice;
	    }

	   
	}


