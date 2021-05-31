import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Check {
    public static void main(String[] args){
        String[] array = {"abc","2","10","0"};
        List<String> list = Arrays.asList(array);
        Iterator it = list.iterator();
        list.forEach(System.out::println);
        Collections.sort(list);
        System.out.println(Arrays.toString(array));
    }

}
