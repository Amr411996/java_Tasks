//import java.util.Str
public class IsBetter {
    public static void main(String[] args){
        String string1 = "Amr";
        String string2 = "Alaa";
        Ex  longer = (s1, s2) -> s1.length() > s2.length();
        if(longer.better(string1,string2))
            System.out.println(string1);
        else
            System.out.println(string2);

        Ex first = (s1, s2) -> true;
        if(first.better(string1,string2))
            System.out.println(string1);
        else
            System.out.println(string2);

        //String longer = StringUtils.betterString(string1, string2, (s1, s2) -> s1.length() > s2.length());
        //String first = StringUtils.betterString(string1, string2, (s1, s2) -> true);
    }
}
