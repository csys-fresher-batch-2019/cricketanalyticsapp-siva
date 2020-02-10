package com;

import java.util.List;
import java.util.Scanner;
import com.csys.PlayerCareer;
import com.csys.PlayerCareerDaoImp;
import com.csys.errorMessages; 

public class TestGetHighScore {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Choose the following case\n");
		System.out.println("1-HighScore\n2-hundred\n3-fifty\n4-runs");
		Scanner sc = new Scanner(System.in);
		
		PlayerCareerDaoImp wen = new PlayerCareerDaoImp();
		System.out.println("Enter the value of case");
		int r = sc.nextInt();
		
		if(r>4) {
			System.out.println(errorMessages.Invalid_Format_case);
		}
		else {
			System.out.println("Enter the format");
			String format = sc.next();
		List <PlayerCareer> hs = wen.best(format,r);
		if(hs.size()!=0) {
		for (PlayerCareer best : hs) {
			System.out.print(best.getplayerName()+"\t");
			if (r==1) {
				System.out.println(best.getBest());
			}
			else if (r==2) {
				System.out.println(best.getHundred());
			}
			else if (r==3) {
				System.out.println(best.getFifty());
			}
			else if (r==4) {
				System.out.println(best.getRuns());
			}
		}
	}
	else {
		System.out.println(errorMessages.Invalid_Format_case);
	}
		}
}}
