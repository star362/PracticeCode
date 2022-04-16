package com.proxy;


/**
 * @author WANGYU
 * @ProjectName PracticeCode
 * @Class: Main
 * @Description:
 * @date: 2019/10/1 21:12
 * @describe:  动态代理
 */
public class Main {
    public static void main(String[] args) {
//        Persion persion=new PersionImpl();
        ProxyHandler<Animal> persionHandler=new ProxyHandler();
//        Persion bind = persionHandler.bind(persion);
//        bind.eat();
//        bind.say();

        Animal animal=new AnimalImpl();
        Animal bind1 =  persionHandler.bind(animal);
        System.out.println(bind1.zhonglei());

        /*Animal a=new Animal() {
            @Override
            public String zhonglei() {
                System.out.println("aaa");
                return "aaa";
            }

            @Override
            public String sex() {
                System.out.println("bbbb");
                return "bbb";
            }
        };
        a.zhonglei();
        a.sex();*/

        /*Animal b=()->{System.out.println("12345") ; return "aaa";};
        b.zhonglei();

        List list = Arrays.asList("a", "b", "c");

        list.forEach(System.out::println);*/
//        AnimalImpl animal=new AnimalImpl();
//
//        List<AnimalImpl> list = Arrays.asList(new AnimalImpl("a","a"), new AnimalImpl("b","b"),
//                new AnimalImpl("c","c"));
//
//        list.forEach(animal::z);


    }


}
