public class Pyramid {
    private double height;
    private String name;
    private String pharaoh;
    private String site;

    public Pyramid(double h, String n, String p, String s){
        height = h;
        name = n;
        pharaoh = p;
        site = s;
    }

    public double getHeight(){
        return height;
    }
    public void setHeight(double h){
        height = h;
    }
    public String getName(){
        return name;
    }
    public void setName(String n){
        name = n;
    }
    public String getPharaoh(){
        return pharaoh;
    }
    public void setPharaoh(String p){
        pharaoh = p;
    }
    public String getSite(){
        return site;
    }
    public void setSite(String s){
        site = s;
    }
}
