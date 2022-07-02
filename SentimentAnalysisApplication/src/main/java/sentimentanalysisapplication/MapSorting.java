package sentimentanalysisapplication;

import java.util.Comparator;

public class MapSorting implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1>02){
            return 1;
        }
        return -1;
    }
   
}
