import java.util.stream.IntStream;
public class IsAlpha {
    public static void main(String[] args) {
        String s1 = "AmrAlaa";
        String s2 = "Amr4Alaa";

        if(IsAlpha.is_All_Letters(s1))
            System.out.println(true);
        else
            System.out.println(false);
        if(IsAlpha.is_All_Letters(s2))
            System.out.println(true);
        else
            System.out.println(false);

    }
     static boolean is_All_Letters(String s){
        if(s==null ||  s=="")
            return false;
        else{
            IntStream stream = s.chars();
            boolean match = stream.allMatch(chr -> Character.isLetter(chr));

            if(match)
                return true;
            else
                return false;


        }
    }
}
