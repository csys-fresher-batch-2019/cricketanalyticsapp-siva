package com;

import java.util.List;

import java.util.Scanner;

import com.csys.PlayerCareerDaoImp;
import com.csys.formatruns;

public class TestSearchByFormatRuns {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		PlayerCareerDaoImp p = new PlayerCareerDaoImp();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the format(odi/test/t20)");
		String format = sc.next();
		System.out.println("Enter the run above which you want to list");
		int runs = sc.nextInt();
		List<formatruns> task1 = p.searchbyformatruns(format, runs);
		
		for (formatruns ps : task1) {
			System.out.println(ps);
		}
		sc.close();
	}

}
