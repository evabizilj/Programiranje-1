import java.util.*;

public class Ploscice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		  
		  int n = sc.nextInt();
		  int[][] tabela = new int[n][n];
		  int k = sc.nextInt();
		  int[][] ploscice = new int[k][2];
		  for (int i = 0; i < k; i++) {
			  ploscice[i][0] = sc.nextInt();
			  ploscice[i][1] = sc.nextInt();
		  }
		  
		  sortX(ploscice);
		  System.out.println(polaganje(ploscice, tabela));  
    }
	 
	 public static int polaganje(int[][] p, int[][] t) {
		 int st = 0;
		 int tempX = 0;
		 int tempY = 0;
		 int skupna_visina = p[0][0];
		 int visinaPrejsnje = p[0][0];
		 int n = t.length;
		 int nSirina = n;
		 int nVisina = n;
		 
		 for(int i = 0; i < p.length; i++) {
			 tempX = p[i][0];
			 tempY = p[i][1];
			 
			if (tempX != visinaPrejsnje) {
				nSirina = n;
				nVisina = n - skupna_visina;
			}
			
			if (tempX <= nVisina && tempY <= nSirina) {
				st++;
				nSirina -= tempY;
			}
			
			if (tempX != visinaPrejsnje)
				skupna_visina += tempX;
			
			visinaPrejsnje = tempX; 
		 }
		 return st;	 
	 }
	 
	 public static void sortX(int[][] p) {
		 int tempX = 0;
		 int tempY = 0;
		 for (int i = 1; i <= p.length - 1; i++) {
			 for (int j = 0; j <= p.length - 1 - i; j++) {
				 if (p[j][0] > p[j+1][0]) {
					 tempX = p[j][0];
					 tempY = p[j][1];
				
					 p[j][0] = p[j+1][0];
					 p[j][1] = p[j+1][1];
					 
					 p[j+1][0] = tempX;
					 p[j+1][1] = tempY;	 
				 }
			 } 
		 }
		 sortY(p); 
	 }
	 
	 public static void sortY(int[][] p) {
		 int tempX = 0;
		 int tempY = 0;
		 for (int i = 1; i <= p.length - 1; i++) {
			 for (int j = 0; j <= p.length - 1 - i; j++) {
				 if (p[j][1] > p[j+1][1] && p[j][0] == p[j+1][0]) {
					 tempX = p[j][0];
					 tempY = p[j][1];
					 
					 p[j][0] = p[j+1][0];
					 p[j][1] = p[j+1][1];
		
					 p[j+1][0] = tempX;
					 p[j+1][1] = tempY;				 
				 }				 
			 }	 
		 }		 
	 }
}
