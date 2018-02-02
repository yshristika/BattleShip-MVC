import java.util.Scanner;

public class Battleship {
	public static void main(String args[])
	{
		int row,column;
		Scanner input=new Scanner(System.in);
		System.out.println("Enter rows");
		row=input.nextInt();
		System.out.println("Enter column");
		column=input.nextInt();
		
		//BattleshipModel m1=new BattleshipModel(row,column);
		//BattleshipModel m2=new BattleshipModel(row,column);
		
		BattleshipModel model=new BattleshipModel();
        BattleshipView v1=new BattleshipView(row,column);
        BattleshipView v2=new BattleshipView(row,column);
		BattleshipController cont = new BattleshipController(model, v1, v2);
		cont.createFleet();
		cont.createTheFleet(0);
		cont.createTheFleet(1);
		cont.show();
		cont.TheGame();
		
        
		//BattleshipView view=new BattleshipView();
        
        
        //BattleshipController cont = new BattleshipController(v1, v2, view);
	}

}
