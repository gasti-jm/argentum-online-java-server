package com.aoserver.server;

import java.util.BitSet;

public class ClientIdManager {

    private final BitSet usedIds = new BitSet();

    public synchronized int allocate() {
        int id = usedIds.nextClearBit(0);
        usedIds.set(id);
        return id;
    }

    public synchronized void release(int id) {
        usedIds.clear(id);
    }

}
