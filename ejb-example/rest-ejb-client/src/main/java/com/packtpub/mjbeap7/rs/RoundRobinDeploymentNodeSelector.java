package com.packtpub.mjbeap7.rs;

import org.jboss.ejb.client.DeploymentNodeSelector;

/**
 * Created by foogaro on 09/02/16.
 */
public class RoundRobinDeploymentNodeSelector implements DeploymentNodeSelector {

    private volatile String previouslySelectedNode;

    @Override
    public String selectNode(String[] eligibleNodes, String clusterName, String moduleName, String distinctName) {
        System.out.println("@previouslySelectedNode: " + previouslySelectedNode);
        System.out.println("@eligibleNodes: " + eligibleNodes.length);
        for (String eligibleNode : eligibleNodes) System.out.println(eligibleNode+",");
        System.out.println("@clusterName: " + clusterName);
        System.out.println("@moduleName: " + moduleName);
        System.out.println("@distinctName: " + distinctName);

        if (eligibleNodes.length == 1) {
            return eligibleNodes[0];
        }
        for (String node : eligibleNodes) {
            if (!node.equals(previouslySelectedNode)) {
                this.previouslySelectedNode = node;
                return node;
            }
        }
        return eligibleNodes[0];
    }

}
