package com.github.o0white0o.benchmark;

public class Main {
public static void main(String... args) {
    Benchmark benchmark = new Benchmark();
    benchmark.prepare();

    benchmark.clean();
    System.out.println("Object size: " + benchmark.measure(Object::new));

    benchmark.clean();
    System.out.println(
            "String with pool size: " + benchmark.measure(String::new));

    benchmark.clean();
    System.out.println(
            "String size: " + benchmark.measure(() -> new String(new char[0])));
}
}
