import java.io.File;

import org.coinjema.context.CoinjemaContext;
import org.coinjema.context.ContextFactory;
import org.coinjema.context.source.FileContextSource;

/**
 * @author mstover
 * 
 * To change the template for this generated type comment go to Window - Preferences - Java - Code Generation - Code and
 * Comments
 */
public class DiceOdds
{

   /**
    * 
    */
   public DiceOdds()
   {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
    * Example usage (on unix - note classpath separator) would be:
    *  java -cp lib/coinjema-core.jar:lib/aspectjrt.jar:lib/groovy-all-1.0-jsr-01.jar:src 
    *           DiceOdds contexts 5 5 one
    *  
    * @param args
    * @throws Exception
    */
   public static void main(String[] args) throws Exception
   {
	   ContextFactory.createRootContext(new FileContextSource(new File(args[0])));
      Die d = new Die(new CoinjemaContext(args[3]));
      int hits = 0;
      int TO_HIT = Integer.parseInt(args[1]);
      int NUM_ROLLS = Integer.parseInt(args[2]);
      int[] distribution = new int[80];
      int trials = 100000;
      int numHits;
      int result = 0;
      long time = System.nanoTime();
      for (int x = 0; x < trials; x++)
      {
         result = d.roll(6, NUM_ROLLS);
         numHits = (result / TO_HIT);
         hits += numHits; 
         distribution[numHits]++;
      }
      System.out.println("Took: " + ((float)(System.nanoTime() - time)/1000000) + " ms");
      float average = ((float) ((float) hits / trials));
      System.out.println("1000 runs: \n\tTo Hit: " + TO_HIT + "\n\tTotal Hits: " + hits + "\n\tAverage: "
            + average + " hits");
      System.out.println("\n\nDistribution");
      for(int x = 0;x < 80;x++)
      {
    	  if(distribution[x] > 0)
    	  {
    		  System.out.print(x);
    		  System.out.print("\t");
    	  }
      }
      System.out.println("");
      for (int x = 0; x < 80; x++)
      {
    	  if(distribution[x] > 0)
    	         System.out.print(distribution[x] + "\t");    		  
      }
      System.out.println("");
      for (int x = 0; x < 80; x++)
      {
    	  if(distribution[x] > 0)
    		  System.out.print((int) (.5 + (100 * ((float) distribution[x] / trials))) + "%\t");
      }
      System.out.println("\n");
      float ratio = (float)NUM_ROLLS/TO_HIT;
      System.out.println("Ratio = " + ratio);
      System.out.println("Average/ratio = " + average/ratio);
      System.out.println("predicted average = " + ((3*NUM_ROLLS)/TO_HIT));
   }
}
