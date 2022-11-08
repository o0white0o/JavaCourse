package com.github.o0white0o.benchmark;

import java.util.function.Supplier;

@SuppressWarnings("MismatchedReadAndWriteOfArray")
class Benchmark {
private Object[] array;
private final int size;

Benchmark() {
    this.size = 1_000_000;
}

void prepare() {
    long memPerArray = MemoryChanges.getMemoryChanges(() ->
                                                              array = new Object[size]);

    System.out.println("Reference size: " + memPerArray / size);
}

long measure(Supplier<Object> supplier) {
    long memChanges = MemoryChanges.getMemoryChanges(() -> {
        for (int i = 0; i < size; i++) {
            array[i] = supplier.get();
        }
    });
    return Math.round((double) memChanges / size);
}

void clean() {
    array = new Object[size];
    System.gc();
    try {
        Thread.sleep(10);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}
}
