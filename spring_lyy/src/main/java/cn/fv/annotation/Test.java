package cn.fv.annotation;

public class Test {
    int x=1;
    Test(){
        System.out.println("Test");
    }
    static class Sub extends Test{
        Sub(){
            System.out.println("sub");
        }
        int x = 2;
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println("".equals(null));
    }
}
