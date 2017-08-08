package HUAWEI;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/2 0002.
 */
public class _5PrimeFactor {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        long number = 0;

        while(scanner.hasNextLong())
        {
            number = scanner.nextLong();
            isPrimerFactors(number);
        }

    }

    private static void isPrimerFactors(long num)
    {
       while(num != 1){
           for(long i = 2; i <= num; i++){
               if(num % i == 0){
                   num = num/i;
                   System.out.print(i + " ");
                   break;
               }
           }
       }
    }
}
