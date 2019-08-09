package com.juju.common.lock;

public class DistributedLock_Redis implements  DistributedLock {
    @Override
    public boolean requireDistributedLock() {
        return false;
    }

    @Override
    public boolean releaseDistributedLock() {
        return false;
    }
}
