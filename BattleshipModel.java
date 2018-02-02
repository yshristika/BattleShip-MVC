
public class BattleshipModel 
{
	boolean condition;
	int a,b;
	int hit[]={14,14};
	
	public int grid_check(char arrgrid[][],int row,int col,int position,int Row,int Column)
	{
		if(row>0 && row<=Row && col>0 && col<=Column && position>=0 && position<=1 )
			return 0;
		else
			return 1;
	}
	public boolean position_action(int row,int col,int k,int Column,char arrGrid[][],int nullti)
	{
		for(int j=col;k>0;++j ,--k)
		{
			if(j<=Column)
			{
				if(nullti==0)
				{
					a=row;
					b=j;
					if(arrGrid[row-1][j-1]!='~')
					{
						condition= true;
						break;
					}
					else
						condition=false;
				}
				else
				{
					a=j;
					b=col;
					if(arrGrid[row-1][j-1]!='~')
					{
						condition= true;
						break;
					}
					else
						condition=false;
				}		
			}
			else
				condition=true;
		}
		return condition;
	}
	
	public void setHit(int player_num)
	{
		--hit[player_num];
	}
	public int getHit(int player_num)
	{
		return hit[player_num];	
	}
}
