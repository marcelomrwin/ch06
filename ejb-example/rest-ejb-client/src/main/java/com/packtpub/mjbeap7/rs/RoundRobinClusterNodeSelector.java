package com.packtpub.mjbeap7.rs;

import org.jboss.ejb.client.ClusterNodeSelector;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by foogaro on 09/02/16.
 */
public class RoundRobinClusterNodeSelector implements ClusterNodeSelector {

    private AtomicInteger clusterNode;

    public RoundRobinClusterNodeSelector() {
        clusterNode = new AtomicInteger(0);
    }

    @Override

    public String selectNode(String clusterName, String[] connectedNodes, String[] availableNodes) {
        System.out.println("#clusterNode: " + clusterNode.get());
        System.out.println("#clusterName: " + clusterName);
        System.out.println("#connectedNodes: " + connectedNodes.length);
        for (String connectedNode : connectedNodes) System.out.println(connectedNode+",");
        System.out.println("#availableNodes: " + availableNodes.length);
        for (String availableNode : availableNodes) System.out.println(availableNode+",");
        if (availableNodes.length < 2) {
            return availableNodes[0];
        }
        return availableNodes[clusterNode.getAndIncrement() % availableNodes.length];
    }

}
