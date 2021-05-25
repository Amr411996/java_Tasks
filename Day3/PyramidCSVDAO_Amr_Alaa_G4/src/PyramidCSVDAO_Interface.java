import java.util.List;

public interface PyramidCSVDAO_Interface {
    public List<Pyramid> getAllPyramids();
    public Pyramid getPyramid(int index);
    public void siteCounter();
}
