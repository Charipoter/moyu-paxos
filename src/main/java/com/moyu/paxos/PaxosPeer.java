package com.moyu.paxos;

import com.moyu.paxos.elect.Election;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 集群中的一个节点
 */
@Getter
@Setter
@Slf4j
public class PaxosPeer extends Thread {
    // 当前持有的连接管理器
    private volatile PaxosConnectionManager connectionManager;
    // 数据
    private PaxosData paxosData;
    // 选举开始时间
    public long electionStartTime;
    // 选举结束时间
    public long electionEndTime;
    // 当前节点 id
    private long serverId;
    // 当前节点认为的领导者
    private volatile Vote voteForLeader;
    // 正在运行
    private volatile boolean running = true;
    // session 过期时间
    protected int sessionTimeout;
    // 当前 peer 状态
    private volatile ServerState peerState = ServerState.LOOKING;
    // 领导者地址
    private volatile String leaderAddress;
    // 验证器
    private PaxosVerifier paxosVerifier;
    // 选举模块
    Election electionProcessor;
    // 自己的信息
    private PaxosServerInfo serverInfo;
    // 不同状态下的执行者
    public PaxosState stateProcessor;

    /**
     * 设置 peer 状态
     */
    public synchronized void setPeerState(ServerState newState) {
        peerState = newState;

        if (newState == ServerState.LEADING) {
            setLeaderAddress(null);
        } else {
            log.info("Peer 状态改变：{}", newState);
        }
    }

    public synchronized void startLeaderElection() {
        if (getPeerState() == ServerState.LOOKING) {
            voteForLeader = new Vote();
        }
        this.electionProcessor = createElection();
    }

    private Election createElection() {
//        PaxosConnectionManager pcm = createConnectionManager();
        PaxosConnectionManager oldPcm = connectionManager;

        if (oldPcm != null) {

        }
        return null;
    }

    public PaxosPeer() {
        super();
    }

    @Override
    public void run() {

        try {

            while (running) {
                switch (getPeerState()) {
                    case LOOKING -> {

                    }
                    case LEADING -> {

                    }
                    case FOLLOWING -> {

                    }
                    case OBSERVING -> {

                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public enum ServerState {

        LOOKING,
        FOLLOWING,
        LEADING,
        OBSERVING

    }
}
