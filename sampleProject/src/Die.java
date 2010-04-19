import java.util.Random;

import org.coinjema.context.CoinjemaContext;
import org.coinjema.context.CoinjemaDependency;
import org.coinjema.context.CoinjemaObject;

@CoinjemaObject
public class Die {
	Random rand;
	int sides = 6;
	
	public Die()
	{
	}
	
	public Die(CoinjemaContext c){}
	
	public int roll(int sides,int numRolls)
	{
		int sum = 0;
		for(int i = 0;i < numRolls;i++)
		{
			sum += rand.nextInt(sides)+1;
		}
		return sum;
	}
	
	@CoinjemaDependency
	public void setRand(Random r)
	{
		rand = r;
	}

}
