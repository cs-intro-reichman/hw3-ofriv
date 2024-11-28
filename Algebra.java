// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    //  Tests some of the operations
	    //System.out.println(plus(2,3));   // 2 + 3
	    //System.out.println(minus(7,2));  // 7 - 2
   		//System.out.println(minus(0,-4));  // 2 - 7
 		//System.out.println(times(4,-2));  // 3 * 4
   		//System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		//System.out.println(pow(-2,3));      // 5^3
   		//System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(25,7));  // 12 / 3    
   		//System.out.println(div(5,5));    // 5 / 5  
   		//System.out.println(div(25,7));   // 25 / 7
   		//System.out.println(mod(25,7));   // 25 % 7
   		//System.out.println(mod(120,6));  // 120 % 6    
   		//System.out.println(sqrt(36));
		//System.out.println(sqrt(263169));
   		//System.out.println(sqrt(76123));
	}  
	
	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int a1 = x1;
		int a2 = x2;
		if (x1 == 0)
		{
			return x2;
		}
		if (x2== 0){
			return x1;
		}
		if(x2 > 0)
		{
		while(a2 != 0)
		{
			a1++;
			a2--;
		}
		}
		else{
			while(a2 != 0)
		{
			a1--;
			a2++;
		}
		
		}
		return a1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		
		int a1 = x1;
		int a2 = x2;
		
		if (x2== 0){
			return x1;
		}
		if(x2 > 0)
		{
		while(a2 != 0)
		{
			a1--;
			a2--;
		}
		}
		else{
			while(a2 != 0)
			{
				a1++;
				a2++;
			}	

		}
		return a1;
	}
	
	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int a1 = x1;
		
		//case 1: both numbers are positive.
		if(x1 > 0 && x2 > 0){
			for(int i = 2; i<= x2; i++)
			{
				a1 = plus(a1,x1);
			}
		}
		//case 2: both numbers are negative.
		if(x1 < 0 && x2 < 0)
		{
			int j = minus(0,x2);
			for(int i = 2; i <= j; i++)
			{
				a1 = plus(a1,x1);
			}
			a1 = minus(0,a1);
		}
		//case 3: x1 is positive x2 is negative
		if(x1 > 0 && x2 < 0)
		{
			for(int i = 2; i<= minus(0, x2); i++)
			{
				a1 = plus(a1, x1);
			}
			a1 = minus(0,a1);
		}
		//case 4: x1 is negative x2 is positive
		if(x1 < 0 && x2 > 0)
		{
			for(int i = 2; i<= x2; i++)
			{
				a1 = plus(a1,x1);
			}
			
		}
		if(x1 == 0 || x2 ==0){
			a1 = 0;
		}

		return a1;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int a = x;
		if (n == 0)
		{
			return 1;
		}
		for(int i = 1; i < n; i++)
		{
			a = times(a,x);
		}
		
		return a;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int a1 = x1;
		int a2 = x2;
		int count = 1;
		if(x1 == 0)
		{
			return 0;
		}
		//case 1: both are positive.
		if(x1 > 0 && x2 > 0)
		{
			while (a2 < x1)
			{
				a2 = plus(a2,x2);
				count++;
			}
			if(a2 != x1)
			{
				count--;
			}

		}
		//case 2: both are negative.
		if(x1 < 0 && x2 <0)
		{
			while (a2 > x1)
			{
				a2 = plus(a2,x2);
				count++;
			}
			if(minus(a2,x2) == x1)
			{
				count++;
			}	
		}
		//case 3: x1 is positive, x2 is negative.
		if(x1 > 0 && x2 < 0)
		{
			a1 = times(a1,-1);
			while (a2 > times(x1,-1))
			{
				a2 = plus(a2,x2);
				count++;
			}
			if(plus(a2,x2) == times(x1,-1))
			{
				count++;
			}	
			count = times(count,-1);
		}
		//case 4: x1 is negative, x2 is positive.
		if(x1 < 0 && x2 > 0)
		{
			a1 = times(a1,-1);
			while (a2 < a1)
			{
				a2 = plus(a2,x2);
				count++;
			}
			if(plus(a2,x2) == a1)
			{
				count++;
			}	
			count = times(count,-1);
		}
		return count;

	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int a1 = 0;
		int a2 = x2;
		while(a2 <= x1)
		{
			a1 = a2;
			a2 = plus(a2,x2);
		}
		return x1 - a1;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int a = 2;
		if(x ==0 )
		{
			return 0;
		}
		while(pow(a,2) < x)
		{
			a++; 
		}
		if(pow(a,2) == x)
		{
			return a;
		}
		else{
			return a -1;
		}
		
	}	  	  
}