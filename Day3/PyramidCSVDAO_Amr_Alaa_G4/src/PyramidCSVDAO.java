import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;


public class PyramidCSVDAO implements PyramidCSVDAO_Interface{
    List<Pyramid> pyramids;

    public PyramidCSVDAO(){
        pyramids = new ArrayList<Pyramid>();
        int n = 0;
        try {

            FileReader fr = new FileReader("D:\\Work\\AI_ITI\\Week6_Java\\archive\\pyramids.csv");
            BufferedReader br = new BufferedReader(fr);
            String line;
            String [] parts;
            Pyramid tempPyramid;
            line = br.readLine();

            do{
                line = br.readLine();
                //System.out.println(line);
                if(line != null) {
                    parts = line.split(",");
                    if(parts[7]=="")
                        parts[7]="0";     //handle missing values
                    tempPyramid = new Pyramid(Double.parseDouble(parts[7]), parts[2], parts[0], parts[4]);
                    pyramids.add(tempPyramid);
                    n++;
                }


            }while (line != null);
            br.close();
            fr.close();
            System.out.println(n);
            /*
            Collections.sort(pyramids, new Comparator<Pyramid>() {
                @Override
                public int compare(Pyramid c1, Pyramid c2) {
                    return Double.compare(c1.getHeight(), c2.getHeight());
                }
            });

            Collections.sort(pyramids);

             */

            //Collections.sort(employees, compareById.reversed());
            //System.out.println(pyramids);
        }
        catch (Exception e){
            System.out.println("IO Error");
            System.out.println(n);
        }
    }


    @Override
    public void siteCounter(){
        Map<String, Integer> countBySit = new LinkedHashMap<>();
        for(Pyramid p:pyramids){
            String site = p.getSite();
            Integer count = countBySit.get(site);
            if(count == null)
                count = 1;
            else
                count++;
            countBySit.put(site,count);

        }
        System.out.println(countBySit);
    }

    @Override
    public List<Pyramid> getAllPyramids(){

        return pyramids;
    }

    @Override
    public Pyramid getPyramid(int index){
        return pyramids.get(index);
    }

}

