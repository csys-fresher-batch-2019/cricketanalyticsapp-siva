package com;

import java.util.Scanner;

import com.csys.MatchDataDaoImp;

public class TestDeleteMatchDetail {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		final String word = "updated";
		MatchDataDaoImp obj = new MatchDataDaoImp();
		obj.deleteMatchDetail(word);
		sc.close();
	}

}
