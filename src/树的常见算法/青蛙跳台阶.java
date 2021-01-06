package 树的常见算法;

public class 青蛙跳台阶 {

    public int JumpFloor(int target) {
        if (target==1){
            return 1;
        }


        if (target == 2){
            return  2;
        }

        int a=1;
        int b=2;
        int result=0;
        for (int i =3; i <= target; i++) {
            result=a+b;
            a=b;
            b=result;
        }

        return result;

    }
}
