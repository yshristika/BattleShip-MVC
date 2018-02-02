import java.util.Scanner;

public class BattleshipView {
	char[][] player1;
	int row,col;
	Scanner input=new Scanner(System.in);
	public BattleshipView(int Row,int Col)
	{
		player1=new char[Row][Col];
		this.row=Row;
		this.col=Col;
	}
	
	public void show()
	{
		//System.out.println("ROW ----------------"+Row);
		//System.out.println("COL ----------------"+Col);
		System.out.print("  ");
		for(int i=1;i<=row;i++)
		{
			System.out.print(i+"  ");
			
		}
		System.out.println();
	    for(int i=0;i<col;i++)
		{
	    	
	    	System.out.print(i+1+" ");
			for(int j=0;j<player1[i].length;j++)
				System.out.print(player1[i][j]+"  ");
			System.out.println();
		}
	}
	
	public int askRow(int count)
	{
		System.out.println("enter the coordinates where you want the ship");
		System.out.println("Enter coordinates of ship "+count);
		System.out.println("Row - ");
		int row=input.nextInt();
		return row;
	}
	public int askColumn()
	{
		System.out.println("Column - ");
		int col=input.nextInt();
		return col;
	}
	public int askPosition()
	{
		System.out.println("How you want to place your ship.");
		System.out.println("enter 0 for horizontal and 1 for vertical");
		int position=input.nextInt();
		return position;
	}
	public void exception1()
	{
		System.out.println("Can't move forward. Choose another coordinates.");
	}
	public void exception2()
	{
		System.out.println("Worng coordinates. choose another.");
	}
	public int askRow1()
	{
		System.out.println("enter row to hit?");
		int row=input.nextInt();
		return row;
	}
	public void Hit(int num)
	{
		if(num==1)
			System.out.println("You have hit Destroyer");
		else if(num==2)
			System.out.println("You have hit Cruiser");
		else if(num==3)
			System.out.println("You have hit BattleShip");
		else if(num==4)
			System.out.println("You have hit Carrier");
	}
	public void shot_message()
	{
		System.out.println("You have already shot here. Take another shot");
	}
	public void hit_message()
	{
		System.out.println("Hit!!!");
	}
	public void miss_message()
	{
		System.out.println("Miss");
	}
	public void win(int hit1,int hit2)
    {
        if(hit1==0)
                System.out.println("Player 1 has won");
        else
        if(hit2==0)
                System.out.println("Player 2 has won");
    }

}
