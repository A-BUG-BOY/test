package cn.fv.pojo;

import java.util.concurrent.Executors;

public class Main<Object>{

    public static void main(String[] args) {
        char[] arr = new char[2];
        for (int i = 0; i < 3; i++) {
            System.out.println(arr[i]);
        }
      Executors.newScheduledThreadPool(1);
    }
    public final void  get(int a){

    }
    public final int get(){
        return  1;
    }
}
