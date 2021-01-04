public class RSABasedOT {
    public static void main(String[] args) {
        Alice alice=new Alice();
        Bob bob=new Bob();

        //1.alice 发送4个参数
        bob.aliceRet=alice.sendRSAMsg();
        for (int i=0;i<4;i++)
            System.out.println(bob.aliceRet[i]);

        //2.bob选择i之后选择ri，将v发送给对方
        alice.v=bob.sendV();
        System.out.println(alice.v);

        //3.alice分别发送mi
        bob.mi=alice.sendMi();
        for (int i=0;i<2;i++){
            System.out.println(bob.mi[i]);
        }

        //4.bob展示自己的mi
        bob.deCodeMsg();
    }
}
