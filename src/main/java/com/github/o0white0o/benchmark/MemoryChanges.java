package com.github.o0white0o.benchmark;

public class MemoryChanges {

private static final Runtime runtime = Runtime.getRuntime();

static long getMemoryChanges(Runnable create) {
    long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
    create.run();
    long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
    return memoryAfter - memoryBefore;
}

}
