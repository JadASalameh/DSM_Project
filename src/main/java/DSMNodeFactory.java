import java.util.*;

public class DSMNodeFactory {
    public static List<DSMNode> createNodesFrom(PartitionConfig config) {
        List<DSMNode> dsmNodes = new ArrayList<>();

        Map<Integer, List<String>> partitionGroups = config.getPartitionGroups();
        int totalAddresses = config.getTotalAddresses();
        int numPartitions = partitionGroups.size();
        if (numPartitions == 0) {
            throw new IllegalStateException("PartitionConfig has no partitions.");
        }


        int partitionSize = totalAddresses / numPartitions;


        for (Map.Entry<Integer, List<String>> entry : partitionGroups.entrySet()) {
            int partitionID = entry.getKey();
            List<String> group = entry.getValue();


            int start = partitionID * partitionSize;

            int end = (partitionID == numPartitions - 1)
                    ? (totalAddresses - 1)
                    : (start + partitionSize - 1);


            for (int i = 0; i < group.size(); i++) {
                String nodeName = group.get(i);
                boolean isPrimary = (i == 0);


                List<String> replicas = new ArrayList<>(group);
                replicas.remove(nodeName);


                DSMNode dsmNode = new DSMNode(nodeName, start, end, isPrimary, replicas);
                dsmNodes.add(dsmNode);
            }
        }

        return dsmNodes;
    }
}

