
package com.vaishhh.medicinetracker;

public class Ulatlng 
{
	static String lat;
	static String lng;
	static int mdprice;
	static int mddiscount;
	public static int getMdprice() {
		return mdprice;
	}
	public static void setMdprice(int mdprice) {
		Ulatlng.mdprice = mdprice;
	}
	public static int getMddiscount() {
		return mddiscount;
	}
	public static void setMddiscount(int mddiscount) {
		Ulatlng.mddiscount = mddiscount;
	}
	public static String getLat() {
		return lat;
	}
	public static void setLat(String lat) {
		Ulatlng.lat = lat;
	}
	public static String getLng() {
		return lng;
	}
	public static void setLng(String lng) {
		Ulatlng.lng = lng;
	}
	
}
