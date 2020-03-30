package javaclass;

public class ShowInnerClass {
    private int data;

    public void m() {
        InnerClass instance = new InnerClass();
    }

    /**内部类前所有的可见性修饰符(public,private,protected,default)均可用*/
    public class InnerClass {//内部类
        public void mi() {
            data++;//直接使用了外部类的属性
            m();//直接使用了外部类的方法
        }
    }
    //内部类的静态方法(static class InnerClass)只能使用外部类中静态的属性和方法
    //InnerClass 是 javaClass.ShowInnerClass 的内部类
}
//调用 mi() 方法： javaClass.ShowInnerClass.InnerClass.mi()
//之前是用对象来调用，静态的东西都是类名来调用
