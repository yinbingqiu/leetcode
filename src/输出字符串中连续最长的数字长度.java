import java.util.Scanner;

public class 输出字符串中连续最长的数字长度 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        if (str==null||str.length()==0){
            System.out.println(0);
        }

        boolean[] list=new boolean[str.length()];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >='0'&&str.charAt(i)<='9'){
                list[i]=true;
            }else {
                list[i]=false;
            }
        }


        int result=0;
        int max=0;
        for (boolean flag : list) {
            if (flag){
                result++;
            }else {
                result=0;
            }

            max=Math.max(max,result);
        }

        System.out.println(max);
    }
}
