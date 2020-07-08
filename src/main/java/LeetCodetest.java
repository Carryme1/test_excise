import java.util.ArrayList;
import java.util.List;

public class LeetCodetest {



    public int[] shuffle(int[] nums, int n) {
        int[] result=new int[2*n];
// 偶数位放x,奇数位放y
        for(int i=0;i<n; i++){
            result[2*i]=nums[i];
            result[2*i+1]=nums[i+n];
        }
        return result;
    }

    public String reverseLeftWords(String s, int n) {
        // 前n个字符串
        String s1=s.substring(0,n);
        String s2=s.substring(n,s.length());
        return s2+s1;
    }


    public int subtractProductAndSum(int n) {
        // list记录每位数字
        List<Integer> list = new ArrayList<Integer>();
        if(n>=1&&n<10)
            return 0;
        while(n/10>0){
            list.add(n%10);
            n=n/10;
        }
        list.add(n);
        int sum=0;
        int product=1;
        for(int i=list.size()-1;i>=0;i--)
        {
            sum=list.get(i)+sum;
            product=list.get(i)*product;
        }
        return product-sum;
    }

    public int numberOfSteps (int num) {
        int step=0;
        while(num!=0){
            if(num%2==0) {
                num = num / 2;
                step++;
                continue;
            }
            if (num%2==1){
                num= num - 1;
                step++;
            }
        }
        return step;
    }

    public int[] decompressRLElist(int[] nums) {

        List<Integer> list=new ArrayList<Integer>();
        int freq=0;
        for (int i=0;i<nums.length/2;i++){
            freq = nums[2*i];
            while(freq!=0){
                list.add(nums[2*i+1]);
                freq--;
            }
            freq = 0;
        }
        int[] a = new int[list.size()];
        for(int j=0;j<list.size(); j++){
            a[j]=list.get(j);
        }
        return a;
    }





    public static void main(String[] args){
        int[] nums={1,2,3,4};
        String s="lrloseumgh";
//        int n=234;
        int num=14;
        LeetCodetest leetCodetest=new LeetCodetest();
//        leetCodetest.shuffle(nums,n);
//        leetCodetest.reverseLeftWords(s,n);
//        leetCodetest.subtractProductAndSum(n);
//        leetCodetest.numberOfSteps(num);
        leetCodetest.decompressRLElist(nums);
    }


}
