package teste;

import java.util.Vector;

import laborator6.Coordonate;

public class TestVector {
	public static void main(String [] args)
	{
		Vector<Coordonate> vec = new Vector<>();
		
		vec.add(new Coordonate(1,2));
		vec.add(new Coordonate(1,3));
		vec.add(new Coordonate(1,4));
		vec.add(new Coordonate(1,5));
		vec.add(new Coordonate(1,6));
		vec.add(new Coordonate(1,7));
		
		System.out.println(vec);
		
		System.out.println(vec.get(0));
		vec.remove(0);
		
		System.out.println(vec);
	}
}
