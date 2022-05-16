package main;

public class Main {
    public static void main(String[] args) {
        Thread test1 = new Thread(new Runnable() {
            @Override
            public void run() {
                org.junit.runner.JUnitCore.main("test.ListaAdyacenciaTest1");
            }
        });

        Thread test2 = new Thread(new Runnable() {
            @Override
            public void run() {
                org.junit.runner.JUnitCore.main("test.ListaAdyacenciaTest2");
            }
        });

        Thread test3 = new Thread(new Runnable() {
            @Override
            public void run() {
                org.junit.runner.JUnitCore.main("test.ListaAdyacenciaTest3");
            }
        });

        test1.start();
        test2.start();
        test3.start();
    }
}
