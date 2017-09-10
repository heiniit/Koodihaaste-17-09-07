import java.util.*;
import java.lang.*;
import java.io.*;

class Goldbach {
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
         
      // The number we are interested for
      final int i_the_number = 100;
     
      // We will need prime numbers up to 100000 so let's use Sieve of Eratosthenes
      // to initialize them to an array (see e.g. Wikipedia)
      Boolean[] ba_primes = new Boolean[i_the_number];
      Arrays.fill(ba_primes, Boolean.TRUE);
      // 0 and 1 are not primes...
      ba_primes[0] = Boolean.FALSE;
      ba_primes[1] = Boolean.FALSE;
      for (int i=2; i<i_the_number; i++)
      {
          if (ba_primes[i] == Boolean.FALSE)
          continue;
         for (int j=2*i; j<i_the_number; j+=i)
           ba_primes[j] = Boolean.FALSE;
      } 
   
      // Now we have needed primes in a table so it's easy to check if i and i_the_number-i are both primes.
      int i_total_pairs=0;
      for (int i=0; i<=i_the_number/2; i++) // We need to stop at i_the_number/2 so that we don't get same pair twice
        if (ba_primes[i] && ba_primes[i_the_number-i])
          i_total_pairs++;
     
      System.out.println(i_total_pairs);
    }
}
