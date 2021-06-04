package test;

public class SingletonTest {

    private volatile static int v = 0;

    private static SingletonTest ourInstance = new SingletonTest();

    public static SingletonTest getInstance() {
        return ourInstance;
    }

    private SingletonTest() {

    }
}
