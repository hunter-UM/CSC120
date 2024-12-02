class Girls {
    private String name;
    private Diamonds diamond;

    public Girls(String name) {
        this.name = name;
        this.diamond = null;
    }

    public void acceptDiamond(Diamonds newDiamond) {
        if (diamond == null || newDiamond.getValue() > diamond.getValue()) {
            diamond = newDiamond;
            System.out.println("Woohoo, the girl took the diamond");
        } else {
            System.out.println("Aaargh, the diamond was rejected");
        }
    }

    public void displayInfo() {
        if (diamond == null) {
            System.out.println(name + " has no best friend");
        } else {
            System.out.println(name + " has a diamond, " + diamond);
        }
    }

    public String toString(){
        if (diamond == null) {
            return name + " has no best friend";
        } else {
            return name + " has a diamond, " + diamond;
        }

    }

}