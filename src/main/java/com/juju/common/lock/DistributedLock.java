package com.juju.common.lock;

public interface DistributedLock {
    boolean requireDistributedLock();
    boolean releaseDistributedLock();
}
