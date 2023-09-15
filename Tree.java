import java.util.HashMap;
import java.util.HashSet;

public class Tree {
    protected HashMap<String, String> blobMap;
    protected HashSet<String> treeSet;

    public Tree() {
        blobMap = new HashMap<>();
        treeSet = new HashSet<>();
    }

    public void add(String addString) throws Exception {
        String[] splits = addString.split(" : ");

        if (splits.length == 2) {
            // Adding a tree
            if (splits[0].equals("tree")) {
                if (treeSet.contains(splits[1])) {
                    throw new Exception("Cannot add a duplicate tree");
                }
                treeSet.add(splits[1]);
                return;
            }
        } else if (splits.length == 3) {
            // Adding a blob
            if (splits[0].equals("blob")) {
                if (blobMap.containsKey(splits[2])) {
                    throw new Exception("Cannot add a blob with a duplicate filename");
                }
                blobMap.put(splits[2], splits[1]);
                return;
            }
        }

        throw new Exception("Invalid add format");
    }

    public boolean remove(String key) {
        if (blobMap.containsKey(key)) {
            blobMap.remove(key);
            return true;
        } else if (treeSet.contains(key)) {
            treeSet.remove(key);
            return true;
        }
        return false;
    }

}