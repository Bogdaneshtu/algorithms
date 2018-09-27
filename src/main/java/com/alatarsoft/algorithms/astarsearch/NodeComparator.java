package com.alatarsoft.algorithms.astarsearch;

import com.alatarsoft.algorithms.model.AStarNode;

import java.util.Comparator;

public class NodeComparator implements Comparator<AStarNode> {

    @Override
    public int compare(AStarNode aStarNode1, AStarNode aStarNode2) {
        if(aStarNode1.getF()<aStarNode2.getF()) return -1;
        if(aStarNode1.getF()>aStarNode2.getF()) return 1;
        return 0;
    }

}
