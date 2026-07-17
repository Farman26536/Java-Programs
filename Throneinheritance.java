public class ThroneInheritance {

    private HashMap<String, List<String>> family;

    private HashSet<String> dead;

    private String king;

    public ThroneInheritance(String kingName) {
        king = kingName;
        family = new HashMap<>();
        dead = new HashSet<>();

        family.put(kingName, new ArrayList<>());
    }

    public void birth(String parentName, String childName) {

        family.get(parentName).add(childName);

       family.put(childName, new ArrayList<>());
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {

        List<String> order = new ArrayList<>();

        dfs(king, order);

        return order;
    }

    private void dfs(String person, List<String> order) {

      if (!dead.contains(person)) {
            order.add(person);
        }

      List<String> children = family.get(person);

        for (String child : children) {
            dfs(child, order);
        }
    }
}