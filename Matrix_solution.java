import java.util.*;

public class Matrix_solution {

 // function to print any matrix .

     public static void printmatrix(int[][] matrix ){
    
        for(int i = 0  ; i < matrix.length ; i++){
           for (int j = 0 ; j < matrix[i].length ; j++ ){
             System.out.print(matrix[i][j]+" "); 
           }
         System.out.println();
        }
    }

    // Function to find transpose of matrix.

    public static int[][] transpose(int[][] matrix,int row ,int col){
      int[][] ans = new int [col][row];
        for (int i = 0 ; i < col ; i++ ){
         for (int j = 0 ; j < row ; j++){
                ans[i][j] = matrix[j][i];
         }
        }
         return ans;
    }
     
    // Function to check two matrix are equal or not.

    public static int equal(int[][] mat1 , int[][] mat2 ){
      int x = mat1.length;
      int y = mat2.length;
        if  (x != y){
             return 0;
        }
        else {
            for (int i = 0 ; i < x ; i++){
              for (int j = 0 ; j < x;j++){
                if (mat1[i][j] != mat2[i][j]){
                return 0;
                }
              }
            }
        }
          return 1  ;
    } 
    
    //  Function to check semetric matrix.

    public static void check(int [][] x , int row ,int col){
      int [][] t = transpose(x, row, col); 
      int k = equal(x, t);
        if(k==0){
          System.out.println("not symetric matrix ");
        }
        else 
         {System.out.println("symetrix matrix");}
    } 

    // function to check for skew symetric matrix.

    public static void skew(int[][] matrix , int row , int col){
       int [][] t = transpose(matrix, row, col); 
        for(int i = 0 ; i < row ; i++ ){
            for (int j = 0 ; j < col ;j++){
                if (i!=j){
                 matrix[i][j] = -matrix[i][j];
                }
            }
        }
       int k =   equal(matrix, t);
        if(k==0){
         System.out.println("not skew symetric matrix ");
        }
        else{ 
         System.out.println("skew symetrix matrix");
        }
    }

    // function to add two matrixes.

    public static void addmatrix(int[][] mat1 , int[][] mat2 ,int row1 ,int col1 , int row2 , int col2){
        if (row1 != row2 && col1 != col2 ){
         System.out.println("operation not possible because of different order of given matrixes");
        }
        else{
            for (int i = 0 ; i < row1 ; i++ ){
                for(int j = 0 ; j < col1 ; j++){
                 mat1[i][j] += mat2[i][j];
                }
            }
         printmatrix( mat1);
        } 
    }  

    // function to multiply two matrixes.

    public static void multiplymatric(int[][] matrix1 , int[][] matrix2 , int row1 , int col1 ,int row2 , int col2 ){
        if (col1 != row2 ){
            System.out.println("multiply not possible ");
        }
        else{
           int[][] ans = new int[row1][col2] ;
        
            for (int i = 0 ; i < row1 ; i++){
                for(int j = 0 ; j < col2 ; j++){
                    for (int k = 0 ; k < col1 ; k++){
                            ans [i][j] += matrix1[i][k]*matrix2[k][i]; 
                    }
                }
            } System.out.println("multiplication of given matrixes is ->");
         printmatrix(ans);
        }
    }

    //  function to divide any matrix by any constant.
    
    public static void dividematrix(int [][] matrix , int row ,int col , int x){
       System.out.println("Inverse of given matrix is :\n ");
        for (int i = 0 ; i < matrix.length ;i++){
            for (int j = 0 ; j < matrix[i].length ;j++ ){
             int tem = matrix[i][j];
             int temp = x ;
                if(tem < 0 && temp < 0){
                 tem = -1 * tem ;
                 temp = -1 * temp;
                }
                else if(temp < 0 ){
                 temp = -1*temp;
                }
                else if(tem < 0 ){
                 tem = -1 * tem;
                }
             int min = Math.min(tem , temp);
           
             int hcf =1 ;
            
                for (int k = min ; k > 1 ; k-- ){
                    if ( tem % k == 0  && temp % k == 0 ){
                     hcf = k ;
                     break; 
                    }
                } 
             int tem2 = x ;
             tem2 = tem2/hcf;
             matrix[i][j] = matrix[i][j]/hcf ; 
                if(tem2<0 && matrix[i][j] < 0){
                   tem2 = -1 * tem2 ;
                   matrix[i][j] = -1 * matrix[i][j] ;
                }
                else if (tem2 < 0 ){
                    tem2 = -1 * tem2 ;
                    matrix[i][j] = -1*matrix[i][j];
                }
                    if(tem2 != 1 || matrix[i][j]==0){
                     System.out.print(matrix[i][j]+"/"+tem2+"  ");
                    }
                        else{
                          System.out.print(matrix [i][j]+"  ");
                        }
                } 
             System.out.println("\n");
          
            }
   
    }
      
    // function to find determinant of matrix.

    public static int det(int[][] matrix,int row , int col ){
     int det = 101010;
        if (row != col){
            System.out.println("it is not a square matrix so determant can not be found.\n");
        }
        else if(row == 2 ){
              det =(matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
        }
        else if(row == 3){
            det = (matrix[0][0]*(matrix[1][1]*matrix[2][2]-matrix[1][2]*matrix[2][1])) - (matrix[0][1]*(matrix[1][0]*matrix[2][2]-matrix[1][2]*matrix[2][0]))+(matrix[0][2]*(matrix[1][0]*matrix[2][1]-matrix[1][1]*matrix[2][0]));  
        }
     return det ;
    }
    
    // function to find adjoint of matrix.
 
    public static int[][] adj(int[][] matrix , int row , int col ){
     int[][] ans = new int[row][row];
        if( row != col){
            System.out.println( " it is not a square matrix ");
        }
        else if(row == 2){
          ans[0][0] =  matrix[1][1] ;
          ans[0][1] = -matrix[0][1] ;
          ans[1][0] = -matrix[1][0] ;
          ans[1][1] =  matrix[0][0] ; 
        }
        else{
         ans[0][0] =  matrix[1][1]*matrix[2][2]-matrix[1][2]*matrix[2][1];
         ans[0][1] = -(matrix[1][0]*matrix[2][2]-matrix[1][2]*matrix[2][0]);
         ans[0][2] =  matrix[1][0]*matrix[2][1]-matrix[1][1]*matrix[2][0];
         ans[1][0] = -(matrix[0][1]*matrix[2][2]-matrix[0][2]*matrix[2][1]);
         ans[1][1] =  matrix[0][0]*matrix[2][2]-matrix[0][2]*matrix[2][0];
         ans[1][2] = -(matrix[0][0]*matrix[2][1]-matrix[0][1]*matrix[2][0]);
         ans[2][0] =  matrix[0][1]*matrix[1][2]-matrix[0][2]*matrix[1][1];
         ans[2][1] = -(matrix[0][0]*matrix[1][2]-matrix[0][2]*matrix[1][0]);
         ans[2][2] =  matrix[0][0]*matrix[1][1]-matrix[0][1]*matrix[1][0];
         ans = transpose(ans, row, col);
        }
     return ans ;
    }
    
    // MAIN FUNCTION.
    public static void main(String[] args) {
     int r = 0 ;
     System.out.println("\n-> In this programe we deal with matrixes to perform some opeations \n\n -> if you want single matrix operation press -> 1 \n -> if you want double matrix operation press -> 2 \n -> if you want read property of matrix as notes press -> 3  ");
     Scanner sc = new Scanner (System.in);
     int x = sc.nextInt();
        if(x==3){
            System.out.println("\n Matrix properties :- \n\n -> A matrix is defined as the rectangular array  of some Rows and Columns.\n horizontal lines called rows and vertical lines called columns.\n -> order of matrix is defined by number of rows X number of columns \n\n Identity matrix :\n -> A matrix having all diagnol elements value 1 and non diagonal elements are 0.\n\n Null or Zero matrix : A matrix having all elements are zero. \n\n Singular matrices : \n -> If the determinant of a matrix is 0, then it is said to be a singular matrix. \n\n Diagonal matrix : \n -> diagonal matrix is a matrix that is both upper triangular and lower triangular. i.e., all the elements above and below the principal diagonal are zeros and hence the name diagonal matrix \n\n Row or Column matrices : \n -> A matrix having only one row called row matrix \n -> a matrix having only one column called column matrix \n\n");
        }
        else if (x == 1 ){
           do{
             System.out.print("give number of rows of your matrix :");
             int row = sc.nextInt();
             System.out.print("give number of columns of your matrix :");
             int col = sc.nextInt();
             int [][] matrix = new int[row][col];
                for(int i = 0  ; i < row ; i++){
                    for (int j = 0 ; j < col ; j++ ){
                     matrix[i][j] = sc.nextInt();
                    }
                }   
           do{ 
             System.out.println(" : if you want to find transpose of matrix press -> 1 \n : To check for Symetric matrix or not press -> 2 \n To check for skew symetric matrix or not press -> 3 \n To find determinant of matrix press -> 4 \n To find adjoint of matrix press -> 5 \n To find inverse of matrix press 6 \n matrix divide by an constnt press : 7 ");
             int y = sc.nextInt();
                switch (y){
                 case 1 : int [][] ans = transpose(matrix, row, col);
                 System.out.println("transpose of given matrix is :-> ");        
                 printmatrix(ans);
                 break; 
                 case 2 : check(matrix, row, col);
                 break;
                 case 3 : skew(matrix, row, col);
                 break ;
                 case 4 : int  det = det(matrix, row, col);
                 if(det != 101010)
                 System.out.println("determinant of given matrix is : "+det);
                 break;  
                 case 5 :int[][] ad = adj(matrix, row, col);
                 int[][] nullmatrix = new int[row][col];
                 int k = equal(ad, nullmatrix);
                 if(k==0){
                 System.out.println("adjoint of given matrix is:");
                 printmatrix(ad);
                 }
                 break;
                 case 6 : int D = det(matrix, row, col);
                 int[][] add = adj(matrix, row, col);
                 
                 if(D==0){
                    System.out.println("determinant is 0 , so inverse can not be find. ");
                 }
                  else{
                    dividematrix(add, row, col, D);
                  }
                  break;
                 case 7 : System.out.print("give divisor :");
                 int d = sc.nextInt();
                 dividematrix(matrix, row, col, d);
                 break ;
                } 
             System.out.println("\ndo you want yo perform other operation with same input matrix press : 1 \n to take another inputs press : 2" );
             r = sc.nextInt();
            }while(r==1);
            }while(r==2);
        }
      else{
        do{
         System.out.print("give number of rows of your 1st matrix :");
         int row1 = sc.nextInt();
         System.out.print("give number of columns of your 1st matrix :");
         int col1 = sc.nextInt();
         int[][] matrix1 = new int [row1][col1];
         System.out.print("give number of rows of your 2nd matrix :");
         int row2 = sc.nextInt();
         System.out.print("give number of columns of your 2nd matrix :");
         int col2 = sc.nextInt();
         int[][] matrix2 = new int [row2][col2];
         System.out.println("\n give 1st matrix element : \n ");   
          for(int i = 0  ; i < row1 ; i++){
            for (int j = 0 ; j < col1 ; j++ ){
              matrix1[i][j] = sc.nextInt();
            }   
          }
           System.out.println("\n give 2nd matrix element : \n");
          for(int i = 0  ; i < row2 ; i++){
            for (int j = 0 ; j < col2 ; j++ ){
              matrix2[i][j] = sc.nextInt();
            }
          } 
        do{ System.out.println(" if you want to add two matrix press -> 1 \n if you want to subtract 2nd matrix fron 1st matrix press -> 2 \n if you want to multiply two matrix press -> 3 \n if you want to check two matrix are equal press -> 4");
         int d = sc.nextInt();
    switch(d) {
       case 1 : addmatrix(matrix1, matrix2, row1, col1, row2, col2);
       break;
       case 2 : int [][] ans = new int[row2][col2];
             for(int i = 0 ; i < row2 ; i++ ){
             for(int j = 0 ; j < col2 ; j++){
                ans[i][j] = -matrix2[i][j];
                }
               }
               addmatrix(matrix1, ans, row1, col1, row2, col2);
         break;
         case 3 : multiplymatric(matrix1, matrix2, row1, col1, row2, col2);
         break;
         case 4 :
                  int p = 1 ;
                  p = equal(matrix1, matrix2);
          if(p==0 ){
            System.out.println("\nboth matrixes are not equal");
          } 
           else 
           System.out.println("\nboth matrixes are equal");
      }
        System.out.println("\ndo you want yo perform other operation with same input matrix press : 1 \n to take another inputs press : 2" );
       r = sc.nextInt();
      }while(r==1);
      }while(r==2);
   sc.close(); }
  }

}