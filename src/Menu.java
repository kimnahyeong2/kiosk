public class Menu {
    private String name;
    private String explain;

    public Menu(String name, String explain){
        this.name = name;
        this.explain = explain;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }
}
