package com.ds.day2;

import java.util.Scanner;

/**
 * 用数组实现一个简单的队列
 * 队列：是一个有序列表，可以用数组或者链表来实现，先进先出，有头指针、尾指针
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';//接收用户输入
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = sc.next().charAt(0);//接收一个字符
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case  'a':
                    System.out.printf("请输入一个数");
                    int data = sc.nextInt();
                    queue.addQueue(data);
                    break;
                case 'g':
                    try {
                        int result = queue.getQueue();
                        System.out.printf("取出的数是：%d", result);
                    }catch (Exception e){
                        System.out.printf(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int head = queue.headQueue();
                        System.out.printf("对列头为：%d", head);
                    }catch (Exception e){
                        System.out.printf(e.getMessage());
                    }
                    break;
                case 'e': //退出
                    sc.close();
                    loop = false;
                    break;
                default:
                    break;

            }

        }

    }

}

/**
 * 使用数组模拟队列-编写一个ArrayQueue类
 */
class ArrayQueue{
    private int maxsize;// 表示数组的最大容量
    private int front;// 指向队列头部，分析出front是指向队列头的前一个位置.
    private int raer;// 指向队列尾，指向队列尾的数据(即就是队列最后一个数据)
    private int[] arr;//数组，用于存放数据模拟队列

    //构造函数创建一个大小为多少的队列// 创建队列的构造器
    public ArrayQueue(int maxsize) {
        this.maxsize = maxsize;
        arr = new int[maxsize];
        front = -1;raer = -1;
    }

    //判断队列是否满
    public boolean isFull(){
        if(raer == maxsize-1){
            return true;
        }
        return false;
    }

    //判断队列是否空
    public boolean isEmpty(){
        if (raer == front){
            return true;
        }
        return false;
    }

    //向队列中插入数据(尾指针后移)
    public void addQueue(int data){
        if (isFull()){
            System.out.printf("队列满，无法加入数据！！！！！！！！");
        }else {
            raer++;//尾指针后移
            arr[raer] = data;
        }
    }

    //队列弹出数据，获取数据
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空,无法取出数据");
        }
        front++;
        return arr[front];
    }

    //显示队列中有什么数据
    public void showQueue(){
        if(isEmpty()){
            System.out.printf("队列为空！！！！");
            return ;
        }else {
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("%d\t", arr[i]);
            }
        }
    }

    // 显示队列的头数据， 注意不是取出数据
    public int headQueue(){
        if (isEmpty()){
            System.out.printf("队列为空！！！！！");
        }
        return arr[front+1];

    }



}
