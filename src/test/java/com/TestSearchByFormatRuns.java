package com;

import java.util.ArrayList;
import java.util.List;

import com.csys.PlayerCareerDaoImp;
import com.csys.highScore;

public class TestSearchByFormatRuns {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		PlayerCareerDaoImp p = new PlayerCareerDaoImp();
		List<formatruns> task1 = p.searchbyformatruns("test", 7000);
		
		for (formatruns ps : task1) {
			System.out.println(ps);
		}
		
	}

}
