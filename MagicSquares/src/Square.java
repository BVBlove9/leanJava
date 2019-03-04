import java.io.*;
public class Square {
	public static void main(String[] args){
		Matrix a=new Matrix();
		if(a.isLeagalMagicSquare("D:\\code\\1.txt")) {
			System.out.print("this is magic square\n");
		}else System.out.print("this is not\n");
		if(a.isLeagalMagicSquare("D:\\code\\2.txt")) {
			System.out.print("this is magic square\n");
		}else System.out.print("this is not\n");
		if(a.isLeagalMagicSquare("D:\\code\\3.txt")) {
			System.out.print("this is magic square\n");
		}else System.out.print("this is not\n");
		if(a.isLeagalMagicSquare("D:\\code\\4.txt")) {
			System.out.print("this is magic square\n");
		}else System.out.print("this is not\n");
		if(a.isLeagalMagicSquare("D:\\code\\5.txt")) {
			System.out.print("this is magic square\n");
		}else System.out.print("this is not\n");
	}
}
class Matrix{
	int n;
	int sum[][];
	int a,b;
	public boolean isLeagalMagicSquare(String fileName){
		String line;
		sum=new int[2][1000];
		int i=0;
		int len=0;
		int j;
		try {
			BufferedReader in=new BufferedReader(new FileReader(fileName));
			line=in.readLine();
			while(line!=null) {
				String[] s=line.split("\t");
				if(i==0)len=s.length;
				for(j=0;j<s.length;j++) {
					for(int k=0;k<s[j].length();k++) {
						char c=s[j].charAt(k);
						if(k==0&&c=='-')continue;
						if(!(c<='9'&&c>='0')) {
							
							System.out.printf(s[j]+"\n");
							System.out.printf("Wrong character\n");
							return false;
						}
					}
					int x=Integer.valueOf(s[j]);
					if(i==j) {
						a+=x;
					}
					if(i+j==len-1) {
						b+=x;
					}
					sum[0][i]+=x;
					sum[1][j]+=x;
				}
				if(j!=len) {
					System.out.println("It's not a square!");
					return false;
				}
				i++;
				line=in.readLine();
			}
			if(i!=len) {
				System.out.println("It's not a square!");
				return false;
			}
			in.close();
		}catch(IOException iox){
			System.out.println("Problem Reading"+fileName);
		}
		if(a!=b)return false;
		for(int k=0;k<len;k++) {
			if(sum[0][k]!=a||sum[1][k]!=a)return false;
		}
		return true;
	}
}