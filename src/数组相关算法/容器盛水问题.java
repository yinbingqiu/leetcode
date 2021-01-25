package 数组相关算法;

public class 容器盛水问题 {
    public long maxWater (int[] arr) {
        if (arr==null || arr.length<=2){
            return 0;
        }



        int left = 0, right = arr.length-1;
        long res = 0;
        //取低的为边界
        int low = Math.min(arr[left],arr[right]);

        while(left < right){
            if(arr[left] < arr[right]){
                left++;
                //如果当前水位小于边界，则可以装水
                if(arr[left] < low){
                    res += low-arr[left];
                }else{
                    low = Math.min(arr[left],arr[right]);
                }
            }else{
                right--;
                if(arr[right] < low){
                    res += low-arr[right];
                }else{
                    low = Math.min(arr[right],arr[left]);
                }
            }
        }
        return res;
    }
}
