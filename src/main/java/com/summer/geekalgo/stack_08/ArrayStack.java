package com.summer.geekalgo.stack_08;

/**
 * @Version V1.0
 * @Title: ArrayStack
 * @Package com.summer.geekalgo.stack08
 * @Author: summer
 * @Date: 2019-03-10 15:30
 * @Description: 数组栈(顺序栈)
 * 注意：
 */
public class ArrayStack {

    private String[] items;
    private int count; //栈元素个数
    private int n; //栈大小

    public ArrayStack(int n){
        this.items = new String[n];
        this.count = 0;
        this.n = n;
    }

    public boolean push(String item){
        if (count == n){
            System.out.print("栈已满");
            return false;
        }
        items[count] = item;
        ++count;
        return true;
    }

    public String pop(){
        if (count == 0){
            System.out.println("栈已空");
            return null;
        }
        String tmp = items[count -1];
        --count;
        return tmp;
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        for (int i = 0; i < 10; i++){
            System.out.print("\n第"+i+"次入栈:");
            stack.push(i +"");
        }
        for (int i = 0; i < 10; i++){
            System.out.print("\n第"+i+"次出栈:"+stack.pop());
        }
    }

}
