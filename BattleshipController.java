

public class BattleshipController {
	BattleshipView view[]=new BattleshipView[2];
	BattleshipModel model;
	int flag1,flag2;
	int player_num;
	int row,col;
	
	
	public BattleshipController(BattleshipModel m1,BattleshipView v1,BattleshipView v2)
	{
		this.model=m1;
		this.view[0]=v1;
		this.view[1]=v2;
	}
	
	public void createFleet() 
	{	
		for(int i=0; i<view[0].player1.length; i++)
		{
			for(int j=0; j<view[0].player1[i].length; j++)
			{
				view[0].player1[i][j] = '~';
				view[1].player1[i][j] = '~';
			}		
		}
		view[0].show();
		view[1].show();
	}
	
	public void createTheFleet(int t)
	{
		if(t==0)
			player_num=0;
		else 
			player_num=1;
		boolean condition=true;
				
				for(int count=1;count<5;count++)
				{
					condition=true;
				while(condition==true)
				{	
					row=view[0].askRow(count);
					col=view[0].askColumn();
					int position=view[0].askPosition();
					int blocks=count+1;
					int k=blocks;
					
					flag1=model.grid_check(view[player_num].player1,row,col,position,view[0].row,view[0].col);
					
					if(flag1==0)
					{
						if(position==0)
						{
							condition=model.position_action(row,col,k,view[0].col,view[player_num].player1,0);
							k=blocks;
							if(condition==true)
								view[0].exception2();
							else if(condition==false )
							{
								for(int j=col;k>0;--k, ++j)
								{
									view[player_num].player1[row-1][j-1]=(char) (count+'0');
								}
									
							}
						}
						if(position==1)
						{
							condition=model.position_action(col,row,k,view[0].row,view[player_num].player1,1);
							k=blocks;
							if(condition==true)
								view[0].exception2();
							else if(condition==false )
							{
								for(int j=row;k>0;--k, ++j)
								{
									view[player_num].player1[j-1][col-1]=(char) (count+'0');
								}
							}
						}
					}
					else
					{
						System.out.println("Wrong input!!");
						condition=true;
					}	
				    }		
				}
	}
	
	public void TheGame()
	{
		int hit1=model.getHit(0);
		int hit2=model.getHit(1);
		int player_playing=0;
		while(true)
		{
			if(hit1==0 || hit2==0)
                break;
			
			if(player_playing % 2 == 0)
			{
				System.out.println("Player A -");
				playGameWith(1);
				++player_playing;
				hit1=model.getHit(0);
			}
			else
			{
				System.out.println("Player B -");
				playGameWith(0);
				++player_playing;
				hit2=model.getHit(1);
			}
		}
		view[1].win(hit1, hit2);
	}
	
	public void playGameWith(int counter)
	{
		int num;
		
		boolean condition=true;
		while(condition==true)
		{
			row=view[0].askRow1();
			col=view[0].askColumn();
			if(row>0 && row<=view[0].row && col>0 && col<=view[0].col)
			{
				if(view[counter].player1[row-1][col-1]=='~')
				{
					
					view[1].miss_message();
				    view[counter].player1[row-1][col-1]='*';
					condition=false; 
					
				}
				else if(view[counter].player1[row-1][col-1]=='*' || view[counter].player1[row-1][col-1]=='!')
				{
					view[1].shot_message();
					condition=true;
					break;
				}
				else
				{
					condition=true;
					num=view[counter].player1[row-1][col-1];
					view[counter].player1[row-1][col-1]='!';
					view[1].hit_message();
					model.setHit(counter);
					view[1].Hit(num);
					view[counter].show();
			     }
			}
			else
			{
				view[0].exception2();
				condition=true;
			}
		}
			
		}
		
	public void show()
	{
		view[0].show();
		view[1].show();
	}


}
