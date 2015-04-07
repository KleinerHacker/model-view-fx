package org.pcsoft.tools.modelview_fx.common.threading;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Christoph on 29.10.2014.
 */
public final class ThreadRunner {

    public static void submit(String name, Runnable runnable) {
        Executors.newCachedThreadPool(new DaemonThreadFactory(name)).submit(runnable);
    }

    public static <T>Future<T> submit(String name, Callable<T> callable) {
        return Executors.newCachedThreadPool(new DaemonThreadFactory(name)).submit(callable);
    }

    public ThreadRunner() {
    }
}
