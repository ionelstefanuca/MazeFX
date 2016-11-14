package laborator6;

public class Coordonate {
	private int x,y;
	
	
	Coordonate(){}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Coordonate)) {
			return false;
		}
		Coordonate other = (Coordonate) obj;
		if (x != other.x) {
			return false;
		}
		if (y != other.y) {
			return false;
		}
		return true;
	}

	public Coordonate(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	int getX()
	{
		return this.x;
	}
	
	int getY()
	{
		return this.y;
	}
	
	void updateCoord(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public String toString()
	{
		String str="( "+this.x+" , "+this.y+" )";
		return str;
	}
}
