package laborator6;

public class Model {
	private int vector[][];
	private int vectorClona[][];
	private int lungime;
	private Coordonate coordFinale,
					   coordActuale;
	
	Model(int nr)
	{
		this.vector = new int[nr+2][nr+2];
		this.lungime=nr+2;
		
		for(int i=0;i<this.lungime;i++)
			for(int j=0; j<this.lungime;j++)
				this.vector[i][j]=0;
		
		this.vector[1][1]=-1; // pozitia de start si actuala
		coordActuale= new Coordonate(1,1);
				
		this.vector[this.lungime-2][this.lungime-2] = -2; // pozitia de final
		coordFinale = new Coordonate(this.lungime-2,this.lungime-2);
		
		
		
		for(int i=0;i<this.lungime;i++)
		{
			this.vector[0][i]=-3; //bordura
			this.vector[i][0]=-3;
			this.vector[i][this.getLength()-1]=-3;
			this.vector[this.getLength()-1][i]=-3;
		}
		
		
		//facem o clona a fectorului, ne va ajuta cand resetam
		vectorClona = new int[this.lungime][this.lungime];
		for(int i=0; i <this.lungime;i++)
		{
			for(int j=0;j<this.lungime;j++)
			{
				this.vectorClona[i][j] = this.vector[i][j];
			}
			
		}
		
	}
	
	int [][] getMatricea()
	{
		return this.vector;
	}
	
	void updateMatrice(int x,int y,int valoare)
	{
		this.vector[x][y] = valoare;
	}
	
	int getLength()
	{
		return this.lungime;
	}
	
	Coordonate getCoordFinale()
	{
		return this.coordFinale;
	}
	
	Coordonate getCoordActuale()
	{
		return this.coordActuale;
	}
	
	void setNewCoordFinale(int x, int y)
	{
		this.getMatricea()[this.getCoordFinale().getX()][this.getCoordFinale().getY()]=0;
		this.getMatricea()[x][y] = -2;
		
		this.coordFinale = new Coordonate(x,y);
	}
	
	void setNewCoordActuale(int x, int y)
	{
		this.getMatricea()[this.getCoordActuale().getX()][this.getCoordActuale().getY()] = 0;
		this.getMatricea()[x][y]=-1;

		this.coordActuale = new Coordonate(x,y);
	}
	
	void changeVector()
	{
		this.vector= new int[this.lungime][this.lungime];
		for(int i=0; i <this.lungime;i++)
		{
			for(int j=0;j<this.lungime;j++)
			{
				this.vector[i][j]=this.vectorClona[i][j];
			}
		}
		
		this.setNewCoordActuale(1, 1);
		this.setNewCoordFinale(this.lungime-2, this.lungime-2);
	}
	
	boolean isWall(Coordonate xy)
	{
		return (this.vector[xy.getX()][xy.getY()]==2);
	}
	
	boolean isBoard(Coordonate xy)
	{
		return (this.vector[xy.getX()][xy.getY()]==-3);
	}
	
	boolean isTrap(Coordonate xy)
	{
		return (this.vector[xy.getX()][xy.getY()]==4);
	}
	
	boolean isGrass(Coordonate xy)
	{
		return (this.vector[xy.getX()][xy.getY()]==3);
	}
	
	boolean isFinal(Coordonate xy)
	{
		return this.vector[xy.getX()][xy.getY()]==-2;
	}
	
	boolean isFree(Coordonate xy)
	{
		return this.vector[xy.getX()][xy.getY()]==0;
	}
	
	boolean isRoot(Coordonate xy)
	{
		return this.vector[xy.getX()][xy.getY()]==5;
	}
	
	void setMatrice (int[][]vect)
	{
		this.vector=vect;
	}
}
