package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CloudElementsAssignment {
	final static private String CE_URL = "https://staging.cloud-elements.com/elements/api-v2/files";
	
    private static Scanner sc= new Scanner(System.in);
	public static void main(String args[]) {
		try {
			
			long starttime = System.currentTimeMillis();
			System.out.println("Enter service: 1- Delete file from DRIVE \n 2- Get file from Drive \n 3- Upload file to Drive");
			int serviceReqId=sc.nextInt();
			System.out.println("I have connected to my drive through Cloud Elements and created a folder \"Cloud Elements\" and accessing files from it:");
			String POST_PARAMS = "path=%2FCloud%20Elements%2";
			switch (serviceReqId) { 
	        case 1: 
	        	deleteFilesUsingCE(POST_PARAMS); 
	            break; 
	        case 2: 
	        	getFilesUsingCE(POST_PARAMS); 
	            break; 
	        case 3: 
	        	uploadFileUsingCE(POST_PARAMS); 
	            break; 		
	        default: 
	           System.out.println("Wrong input");; 
	            break; 
	        } 
			
			System.out.println("time taken in ms  :  " + (System.currentTimeMillis() - starttime));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void getFilesUsingCE(String POST_PARAMS) throws IOException {
		try {
			System.out.println("'f3.jpg' is my file name:");
			URL url = new URL(CE_URL);
			HttpURLConnection conn;
			conn = (HttpURLConnection) url.openConnection();
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);

			conn.setRequestMethod("GET");
			conn.setRequestProperty("accept", "application/json");
			conn.setRequestProperty("Authorization",
					"User JHJJN0lfI6t4IAW/5xSbl9RWPBWewOTaV/9jfCE9Z1c=, Organization a95edd4ccd517fe220763dacbbf3861f, Element PekcF1GbcUs2MgD9pkz4AQrnUfR5KoustRJyskVz9PQ=");
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(POST_PARAMS+"f3.jpg");
			wr.flush();
			int status = 0;
			if (null != conn) {
				status = conn.getResponseCode();
			}
			if (status != 0) {
				System.out.println("status : " + status);
				if (status == 200) {
					BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					String r = reader.readLine();
					System.out.println("Response : " + r);
				}
			}
		} catch (Exception exception) {
			System.out.println("Error in sending the request!.." + exception.getMessage());
		}

	}

	private static void uploadFileUsingCE(String POST_PARAMS) {
		try {
			System.out.println("'f3.jpg' is my file name i wish to save as:");
			URL url = new URL(CE_URL);
			HttpURLConnection conn;
			conn = (HttpURLConnection) url.openConnection();
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);

			conn.setRequestMethod("POST");
			conn.setRequestProperty("accept", "application/json");
			conn.setRequestProperty("Authorization",
					"User JHJJN0lfI6t4IAW/5xSbl9RWPBWewOTaV/9jfCE9Z1c=, Organization a95edd4ccd517fe220763dacbbf3861f, Element PekcF1GbcUs2MgD9pkz4AQrnUfR5KoustRJyskVz9PQ=");
			conn.setRequestProperty("Content-Type","multipart/form-data");
			
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(POST_PARAMS+"f3.jpg");
			wr.flush();
			int status = 0;
			if (null != conn) {
				status = conn.getResponseCode();
			}
			if (status != 0) {
				System.out.println("status : " + status);
				if (status == 200) {
					BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					String r = reader.readLine();
					System.out.println("Response : " + r);
				}
			}
		} catch (Exception exception) {
			System.out.println("Error in sending the request!.." + exception.getMessage());
		}
	}
	
	private static void deleteFilesUsingCE(String POST_PARAMS) throws IOException {
		try {
			System.out.println("'f3.jpg' is my file name:");
			URL url = new URL(CE_URL);
			HttpURLConnection conn;
			conn = (HttpURLConnection) url.openConnection();
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);

			conn.setRequestMethod("DELETE");
			conn.setRequestProperty("Authorization",
					"User JHJJN0lfI6t4IAW/5xSbl9RWPBWewOTaV/9jfCE9Z1c=, Organization a95edd4ccd517fe220763dacbbf3861f, Element PekcF1GbcUs2MgD9pkz4AQrnUfR5KoustRJyskVz9PQ=");
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(POST_PARAMS+"f3.jpg");
			wr.flush();
			int status = 0;
			if (null != conn) {
				status = conn.getResponseCode();
			}
			if (status != 0) {
				System.out.println("status : " + status);
				if (status == 200) {
					BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					String r = reader.readLine();
					System.out.println("Response : " + r);
				}
			}
		} catch (Exception exception) {
			System.out.println("Error in sending the request!.." + exception.getMessage());
		}

	}

}