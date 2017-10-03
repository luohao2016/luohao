/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelloWorld.SampleClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 *
 * @author luohao
 */
public class App {

    public static void test1() {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
            "Stanislas Wawrinka",
            "David Ferrer", "Roger Federer",
            "Andy Murray", "Tomas Berdych",
            "Juan Martin Del Potro"};
        List<String> players = Arrays.asList(atp);

        System.out.println("```````````````1`````````````````");
        // 以前的循环方式
        for (String player : players) {
            System.out.print(player + "; ");
        }
        System.out.println("``````````````2``````````````````");
        // 使用 lambda 表达式以及函数操作(functional operation)
        players.forEach((player) -> System.out.print(player + "; "));
        System.out.println("``````````````3``````````````````");
        // 在 Java 8 中使用双冒号操作符(double colon operator)
        players.forEach(System.out::println);
    }

    public static void cal1() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 1000000; i++) {
            double d = Math.random() * 1000;
            list.add(d + "");
        }
        long start = System.nanoTime();//获取系统开始排序的时间点
        int count = (int) ((Stream) list.stream().sequential()).sorted().count();
        long end = System.nanoTime();//获取系统结束排序的时间点
        long ms = TimeUnit.NANOSECONDS.toMillis(end - start);//得到串行排序所用的时间
        System.out.println(ms + "ms");
    }

    public static void cal2() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 1000000; i++) {
            double d = Math.random() * 1000;
            list.add(d + "");
        }
        long start = System.nanoTime();//获取系统开始排序的时间点
        int count = (int) ((Stream) list.stream().parallel()).sorted().count();
        long end = System.nanoTime();//获取系统结束排序的时间点
        long ms = TimeUnit.NANOSECONDS.toMillis(end - start);//得到并行排序所用的时间
        System.out.println(ms + "ms");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        test1();
        cal1();
        cal2();
    }

}
