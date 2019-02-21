package ch03;

import java.util.Scanner;

class SeqSearchSen {
    static int SeqSearchSen(int[] a, int n, int key) {
        int i = 0;
        a[n]=key;
        
        while (true) {
            if (a[i]==key) 
                break;
            i++;
        }
        
        return i ==n ? -1 : i;
    }
    
    
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        
        System.out.print("number of elements : ");
        int num = stdIn.nextInt();
        int[] x = new int[num+1];
        
        for (int i=0; i<num;i++){
            System.out.print("x["+i+"]:");
            x[i] = stdIn.nextInt();
        }
        
        System.out.print("key value to search for: ");
        int ky = stdIn.nextInt();
        
        int idx = SeqSearchSen(x, num, ky);
        
        if (idx == -1)
        	System.out.println("�� ���� ��Ұ� �����ϴ�");
        else
        	System.out.println(ky+"��(��) x[" + idx + "]�� �ֽ��ϴ�.");
    }  
}
