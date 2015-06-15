import java.util.*;


public class Combat {
	private int nbDesAttaque;
	private int nbDesDefense;

	public void effectuerCombat()
	{
		Random rnd = new Random();
		int desAt1=rnd.nextInt(6)+1;
		int desAt2=0;
		int desAt3=0;
		int desDef1=rnd.nextInt(6)+1;
		int desDef2=0;
		if(nbDesAttaque>=2){
			desAt2=rnd.nextInt(6)+1;
			if(nbDesAttaque==3)desAt3=rnd.nextInt(6)+1;
		}
		if(nbDesDefense==2){
			this.nbDesDefense=rnd.nextInt(6)+1;
		}
		int[] combat1=new int[2];
		int[] combat2=new int[2];
		if(desAt1>desAt2 && desAt1>desAt3)combat1[1]=desAt1;
		if(desAt2>desAt1 && desAt2>desAt3)combat1[1]=desAt2;
		if(desAt3>desAt1 && desAt3>desAt2)combat1[1]=desAt3;
		
	}
}
