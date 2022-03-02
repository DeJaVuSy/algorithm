package com.demo.algorithm.test;

import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class testAlgorithm {

    private int[] my_list = {1,3,5,7,9};

    @Test
    public void Algorithm(){
        System.out.println(binary_search(my_list,1));
    }

    public int binary_search(int[] list,int item){
        int low = 0;
        int high = list.length - 1;

        while ( low <= high){
            int mid = (low + high);
            int guess = list[mid];
            if(guess == item){
                return mid;
            }else if (guess > item){
                high = item - 1;
            }else {
                low = mid + 1;
            }
        }
        return 0;
    }

    @Test
    public void array(){
        ArrayList<String> arrayList = new ArrayList<String>();
        LinkedList<ArrayList<String>> linkeArrayLists = new LinkedList<ArrayList<String>>();
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("李四");
        linkedList.add(1,"王五");
        linkedList.push("张三");
        for (String s: linkedList) {
            System.out.println(s);
        }
//        int[] array = new int[5];
//        array[0] = 6;
//        for (int i= 0;i < array.length;i++){
//            System.out.println(array[i]);
//        }
    }

    //选择排序
    @Test
    public void sort(){
        int[] arrayint = new int[100000];
        for (int i = 1; i <= 100000; i++){
            arrayint[i-1] = i;
        }
        for (int i = 0; i < arrayint.length; i++){
            for (int j = 1 + i; j < arrayint.length; j++){
                if(arrayint[i] < arrayint[j]){
                    int intsort = arrayint[i];
                    arrayint[i] = arrayint[j];
                    arrayint[j] = intsort;
                }
            }
        }
        for (int intsort:arrayint){
            System.out.println(intsort);
        }

    }

    @Test
    public void recursion(){
        System.out.println(recursionMethod(3));
    }

    public static int recursionMethod(int i){
        if (i == 1){
            return 1;
        }else {
            int j = i * recursionMethod(i - 1);
            return j;
        }

    }

    public static void main(String[] args) {
        System.out.println(recursionMethod(4));
    }

    //分而治之
    @Test
    public void testmaxSquare(){
        maxSquare(1680,600);
    }

    public void maxSquare(int x,int y){

        if (x<y){
            int z = y/x;
            if (y%x != 0 ){
                maxSquare(y-(x*z),x);
                return;
            }else {
                y = x;
                maxSquare(y,x);
            }
        }else if (x>y){
            int z = x/y;
            if (x%y !=0){
                maxSquare(x-(y*z),y);
                return;
            }else {
                x = y;
                maxSquare(x,y);
            }
        }else {
            System.out.println("最大长度X："+x);
            System.out.println("最大长度y："+y);
        }
    }

    //二分查找
    @Test
    public void testrecursiontwo(){
        int srcArray[] = {3,5,11,17,21,23,28,30,32,50,64,78,81,95,101,128};
        System.out.println("已找到，所在位置为："+recursiontwo(srcArray,102,0,srcArray.length));
    }

    public int recursiontwo(int srcArray[],int key,int start, int end){
        if (key < srcArray[0] || key > srcArray[srcArray.length - 1] ){
            return -1;
        }

        int mid = (end - start)/2 + start;
        int mediant = srcArray[mid];
        if(mediant == key){
            return mid;
        }
        if (key < mediant){
            return recursiontwo(srcArray,key,start,mid);
        }else if(key > mediant){
            return recursiontwo(srcArray,key,mid,end);
        }

        return -1;
    }

    //分而治之，选择排序
    @Test
    public void sumTest(){
        int listArray[] = {2,4,0,6};
        System.out.println(sum(listArray));
    }

    public int sum(int list[]){
        if (list.length == 0 || list[0] == 0){
            return 0;
        }
        int getlist = list[0];
        int[] list1 = new int[list.length - 1];
        System.arraycopy(list, 1, list1, 0, list1.length);
        return getlist + sum(list1);
    }

    //快速排序
    @Test
    public void kuaisuSortTest(){
//        int[] i = {5,6,4};
//        int[] j = {9,8,7};
//        int[] k = concat(j,i);
//        System.out.println(k.length);
        kuaisuSort(new int[]{70, 129, 99, 65, 50, 20, 6, 250, 1024, 80, 48, 10, 15, 666, 45});
        int[] k = new int[]{70, 129, 99, 65, 50, 20, 6, 250, 1024, 80, 48, 10, 15, 666, 45};
        //System.out.println(sort(k,0,k.length-1).toString());
    }

    public int[] kuaisuSort(int[] array){
        //基准数
        int base = array[0];
        int i = 1;
        int j = array.length - 1;
        int z = -1;
        int y = -1;
        while (i != j){
            if(array[i] > base){
                z = i;
            }
            if (array[j] < base){
                y = j;
            }
            if (z != -1 && y != -1 && array[i] > base && array[j] < base){
                int s = array[z];
                array[z] = array[y];
                array[y] = s;
            }
            if (array[i] > base && array[j] > base){
                j--;
            }else if (array[i] < base && array[j] < base){
                i++;
            }else {
                i++;
                j--;
            }
            if (i == j){
                array[0] = array[i-1];
                array[i-1] = base;
            }
        }

        return kuaisuSort(array);
    }


    public int[] concat(int[] a, int[] b) {
        int[] c= new int[a.length+b.length];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);
        return c;
    }

    /**
     * 快排核心算法，递归实现
     * @param array
     * @param left
     * @param right
     */
    public int[] sort(int[] array, int left, int right) {
        if(left > right) {
            return array;
        }
        // base中存放基准数
        int base = array[left];
        int i = left, j = right;
        while(i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while(array[j] >= base && i < j) {
                j--;
            }

            // 再从左往右边找，直到找到比base值大的数
            while(array[i] <= base && i < j) {
                i++;
            }

            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if(i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        sort(array, left, i - 1);
        sort(array, i + 1, right);
        return array;
    }


    //散列表
    @Test
    public void hashtable(){
        HashMap<String,Double> hashMap = new HashMap<>();
        hashMap.put("苹果",4.56);
        hashMap.put("草莓",10.0);
        hashMap.put("香蕉",4.0);
        hashMap.put("火龙果",5.0);
        hashMap.put("null",null);
        System.out.println(hashMap.get("null"));
    }



    @Test
    public void one_hundred(){
        List<Integer> Integerlist = new ArrayList<>();
        Integerlist.add(0);
        Integerlist.add(2);
        Integerlist.add(3);
        Integerlist.add(0);
//        int sum = Integerlist.stream().mapToInt(i -> i>0?1:0).sum();
//
//        System.out.println(sum);


//        SysUser sysUser = new SysUser();
//        System.out.println(sysUser.getUserId());
//        int sum = Integerlist.stream().mapToInt(i -> sysUser.getPassword()==null?1:0).sum();;

        Integerlist.forEach(System.out::println);
//        for (int i = 1;i <= 10;i++){
//            sum += sysUser.getPassword()!=null?1:0;
//        }

//        System.out.println(sum);
        //从1加到100
        double variate = 100;
        double sum = (1+variate)*(variate/2);
        System.out.println(sum);

    }





}
