import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Matrix{
    public static void main(String[] args){
        try{
            FileWriter f = new FileWriter("Answer.txt", false);
            PrintWriter p = new PrintWriter(new BufferedWriter(f));
            FileInputStream fi = new FileInputStream("Matrix/input1.txt");
            InputStreamReader is = new InputStreamReader(fi);
            BufferedReader br = new BufferedReader(is);
            String tmp[] = br.readLine().split(" ");
            final int length = tmp.length;
            int[][] ans = ans(length);
            br.close();
            for(int y=0;y<length;y++){
                for(int x=0;x<length;x++){
                    p.print(ans[y][x]+" ");
                }
                p.print("\n");
            }
            p.close();
        }catch(IOException ex){
        }
    }
    public static int[][] ans(int l){
        try{
            FileInputStream fi = new FileInputStream("Matrix/input1.txt");
            InputStreamReader is = new InputStreamReader(fi);
            BufferedReader br = new BufferedReader(is);

            String line;
            int[][] matrix1 = new int[l][l];
            int[][] matrix2 = new int[l][l];
            int[][] ans = new int[l][l];

            for(int y=0;y<l;y++){
                line = br.readLine();
                String[] temp  =line.split(" ");
                for(int x = 0; x<l;x++){
                    matrix1[y][x] = Integer.parseInt(temp[x]);
                }
            }
            br.readLine();
            for(int y=l;y<l*2;y++){
                line = br.readLine();
                String[] temp  =line.split(" ");
                for(int x = 0; x<l;x++){
                    matrix2[y-l][x] = Integer.parseInt(temp[x]);
                }
            }
            br.close();
            ans = matrixProduct(l, matrix1, matrix2);
            return ans;
        }catch(IOException ex){
            ex.printStackTrace();
            return null;
        }
    }
    public static int[][] matrixProduct(int l,int[][] m1,int[][] m2){
        int [][] product = new int[l][l];
        for(int i = 0; i < l; i++){
            for(int j = 0; j < l; j++){
                for(int k = 0; k < l; k++){
                    product[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return product;
    }
}