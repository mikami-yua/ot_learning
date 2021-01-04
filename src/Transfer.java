public class Transfer {
    public static void main(String[] args) {
        Util u=new Util();
        Alice a=new Alice();
        Bob b=new Bob();
        a.u=u;
        b.u=u;
        a.g=u.g;
        b.g=u.g;

        //alice向bob发送gs
        b.gs=a.sendGs();
        System.out.println(1);
        //bob向alice发送Li
        a.Li=b.sendLi();
        System.out.println(2);
        //alice生成Ci
        a.generateCi();
        System.out.println(3);
        //alice把Ci发送给Bob
        b.Ci=a.sendCi();
        System.out.println(4);
        //bob解密
        b.deEncrytion();
    }
}
