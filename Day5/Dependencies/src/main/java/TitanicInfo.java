
//import tech.tablesaw.api.Table;
import joinery.DataFrame;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;

import java.util.Arrays;
import java.util.List;

import java.io.IOException;


public class TitanicInfo {
    public static void main(String[] args) throws IOException {

        String path = "D:\\Work\\AI_ITI\\Week6_Java\\Dependencies\\src\\main\\resources\\train.csv";

        Table titanicData = Table.read().csv(path);
        System.out.println(titanicData.columns());
        System.out.println(titanicData.summary());
        
    }
}
