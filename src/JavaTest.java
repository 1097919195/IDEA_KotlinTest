public class JavaTest {
    public static void main(String[] args) {
        System.err.println(eval(new Sum(new Sum(new Num(1), new Num(2)), new Num(4))));


        JavaExpr javaExpr1 = new Num(1);//没实现接口的类是不能等于接口的实例的
        JavaExpr javaExpr2 = new Sum(new Num(1),new Num(2));
        System.err.println(javaExpr1 == javaExpr2);

        String[] str = new String[26];
        for (int i = 0; i < 26; i++) {
            System.err.println(str[i]= String.valueOf((char)(97 + i )));
        }
    }

    public static int eval(JavaExpr e) {
        if (e instanceof Num) {
//            int n = e as Num        // 1 显式的Num类型转换是多余的
            return ((Num) e).getValue();
        }
        if (e instanceof Sum) {
            return eval(((Sum) e).getRight()) + eval(((Sum) e).getLeft());  // 2 变量e是智能类型转换
        }
        throw new IllegalArgumentException("Unknown expression");

    }


    static class Num implements JavaExpr{
        private int value;

        public Num(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    static class Sum implements JavaExpr{
        private JavaExpr left;
        private JavaExpr right;

        public Sum(JavaExpr left, JavaExpr right) {
            this.left = left;
            this.right = right;
        }

        public JavaExpr getLeft() {
            return left;
        }

        public void setLeft(JavaExpr left) {
            this.left = left;
        }

        public JavaExpr getRight() {
            return right;
        }

        public void setRight(JavaExpr right) {
            this.right = right;
        }
    }

    static void testStream() {

    }
}

interface JavaExpr{

}

