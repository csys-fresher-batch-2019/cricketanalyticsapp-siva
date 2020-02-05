package com;



import java.util.Scanner;

import com.csys.PlayerProfileDaoImplementation;

public class TestAddPlayer {

	public static void main(String[] args) throws Exception {
		
		PlayerProfileDaoImplementation add1 = new PlayerProfileDaoImplementation();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter cap number");
		String capNo= sc.nextLine(); 
		System.out.println("Enter Player Name");
		String name= sc.nextLine();
		System.out.println("Enter Nation");
		String nation= sc.nextLine(); 
        System.out.println("Enter Batting Style");
		String style= sc.nextLine(); 
		System.out.println("Enter Debut Year");
		int debutYear= sc.nextInt();
		add1.addPlayer(capNo,name,nation,style,debutYear);
	}
	
}












	/*ArrayList<String>list = new ArrayList<String>();
	list.capNo = "i278";
	list.playerName = "Mr.X";
	list.nation = "India";
	list.battingStyle = "Left Hand Batsman";*/
		// TODO Auto-generated method stub
				//PlayerProfileDaoImplementation add1 = new PlayerProfileDaoImplementation();
				//PlayerProfile novice1 = new PlayerProfile();
				//novice1.capNo = "i278";
				//novice1.name = "Mr.X";
				//novice1.nation = "India";
				//novice1.style = "Left Hand Batsman";
				//System.out.println(novice1.toString());
				//add1.addPlayer('i278','Mr.X','India','Left Hand Batsman');
				 
				// PlayerProfile novice2 = new PlayerProfile();
				   //novice2.capNo = "i200";
					//novice2.name = "Mr.Y";
					//novice2.nation = "India";
					//novice2.style = "Right Hand Batsman";
					//System.out.println(novice2.toString());
		
		
		// PlayerProfile novice3 = new PlayerProfile();
		   // novice3.capNo = "e227";
			//novice3.playerName = "Joe Root";
			//novice3.nation = "England";
			//novice3.battingStyle = "Right Hand Batsman";
			//System.out.println(novice2.toString());
		   // add1.addPlayer('e226','Joe Root','England','Right Hand Batsman');
	
	


