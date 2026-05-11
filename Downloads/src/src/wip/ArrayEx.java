package wip;

public class ArrayEx {

    public static void main(String[] args) {

        int num[];
        num = new int[3];

        int num2[] = new int[3];

        num[0] = 10;

        int num3[] = {1,3,4,5,6};

        //System.out.println(num3[3]);

//        for(int i=0; i<num3.length; i++)
//        {
//            System.out.println(num3[i]);
//        }
//        for(int res : num3)
//        {
//        	System.out.println(res);
//        }
        int mat[][]= {{1,2,3},{4,5,6}};
        for(int i=0;i<mat.length;i++) {
        	System.out.println("i:"+mat.length);
        	for(int j=0;j<mat[i].length;j++)
        	{
        		System.out.println("j:"+mat[i].length);
        		System.out.println(mat[i][j]);
        	}
        }
    }
}