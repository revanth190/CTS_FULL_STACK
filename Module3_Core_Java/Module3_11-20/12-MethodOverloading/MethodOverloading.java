public class MethodOverloading{
    int add(int a,int b){
        return a+b;
    }
    double add(double a,double b){
        return a+b;
    }
    int add(int a,int b,int c){
        return a + b + c;
    }
    public static void main(String[] args){
        MethodOverloading mo=new MethodOverloading();
        System.out.println("add(int, int): "+mo.add(5,10));
        System.out.println("add(double, double): "+mo.add(5.5,6.6));
        System.out.println("add(int, int, int): "+mo.add(1,2,3));
    }
}
