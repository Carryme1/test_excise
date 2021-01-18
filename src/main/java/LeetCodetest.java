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

    public int[] createTargetArray(int[] nums, int[] index) {
//        一起遍历, 小于length-1插入处理。等于最后一位替换。
        int[] target = new int[nums.length];
        int count=0;
        for (int i=0; i < nums.length; i++){
//            原target[i]向后一位后，再插入。
            count=nums.length-index[i];
            while (count>0) {
                target[index[i] + 1] = target[index[i]];
                count--;
            }
            target[index[i]]=nums[i];
        }
        return target;
    }
    public int findNumbers(int[] nums) {
        //找数组中偶数的个数
        int re=0;
        int count=1;
        int b=0;
        int a=0;
        for(int i=0; i<nums.length;i++){
            b=nums[i];
            if(b/10==0)
                continue;
            while(b/10!=0){
                b=b/10;
                count++;
            }
            if(count%2==0){
                re++;
            }
            count=1;
        }
        return re;
    }

    public void deleteNode(ListNode node) {
//        删除链表中的节点
        while(node.next.next!=null){
            if(node.next==node)
                node.next=node.next.next;
        }
    }
    public int minTimeToVisitAllPoints(int[][] points) {
        int x=0;
        int y=0;
        int distances=0;
//        横纵坐标相减之后，取最大值.按列进行遍历
        for(int i=1; i<points.length;i++){
            x=Math.abs(points[i][0]-points[i-1][0]);
            y=Math.abs(points[i][1]-points[i-1][1]);
            if(x>=y)
                distances+=x;
            else
                distances+=y;
        }
        return distances;
    }

    public int getDecimalValue(ListNode head) {
        List<Integer> list=new ArrayList<Integer>();
        int sum=0;
        while(head.next!=null){
            list.add(head.val);
            head=head.next;
        }
        for(int i=0; i<list.size(); i++){
            sum+=list.get(i)*Math.pow(2,(list.size()-i-1));
        }
//        System.out.println(sum);
        return sum;
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        // 遍历找最小，如果最小与上层的index大于2跳过，找次小。
        int sum = triangle.get(0).get(0);
        int min = 0;
//        int init=triangle.get(0).get(0);
        List<Integer> list;
        for (int i=1; i<triangle.size();i++){
            list=triangle.get(i);
            for(int j=0; j<list.size(); j++){
                if(j==0)
                    min=list.get(j);
                if(list.get(j)<=min&&Math.abs(i-j-1)<2)
                    min=list.get(j);
            }
            sum +=min;
        }
        return sum;
    }



    public static void main(String[] args){
        int[] nums={12,345,2,6,7896};
        int[] index={0,1,2,2,1};
        String s="lrloseumgh";
//        int n=234;
        int num=14;
        int[][] points=new int[][]{{1,1},{3,4},{-1,0}};
        LeetCodetest leetCodetest=new LeetCodetest();
//        leetCodetest.shuffle(nums,n);
//        leetCodetest.reverseLeftWords(s,n);
//        leetCodetest.subtractProductAndSum(n);
//        leetCodetest.numberOfSteps(num);
//        leetCodetest.decompressRLElist(nums);
//        leetCodetest.createTargetArray(nums,index);
//        leetCodetest.findNumbers(nums);
//        leetCodetest.minTimeToVisitAllPoints(points);
//        leetCodetest.getDecimalValue();
        ;
    }




}
