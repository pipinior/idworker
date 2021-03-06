package org.n3r.idworker;

import org.junit.BeforeClass;
import org.junit.Test;
import org.n3r.idworker.strategy.DefaultWorkerIdStrategy;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class DefaultWorkerIdStrategyTest {
    @BeforeClass
    public static void beforeClass() {
        String pathname = System.getProperty("user.home") + File.separator + ".idworkers";
        File dir = new File(pathname);
        if (dir.exists()) {
            for (File f : dir.listFiles()) {
                f.delete();
            }
        }
        dir.delete();
    }

    @Test
    public void test1() {
        WorkerIdStatrategy instance = DefaultWorkerIdStrategy.instance;
        instance.initialize();
        long wid = instance.availableWorkerId();
        assertTrue(wid >= 0);

        DefaultWorkerIdStrategy d1 = new DefaultWorkerIdStrategy();
        d1.initialize();
        assertTrue(d1.availableWorkerId() != instance.availableWorkerId());
    }
}
