package com.moyu.paxos;

/**
 * 节点的状态，使用状态设计模式，不同状态不同执行
 */
public interface PaxosState {

    void process();

}
