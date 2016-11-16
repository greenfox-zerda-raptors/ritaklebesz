import com.greenfox.bx.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Rita on 2016-11-16.
 */
public class AppWorkshop05 {
    public static void main(String[] args) {
        List<String> tvModels= new ArrayList<String>();

        tvModels.add("Samsung S19E200BW");
        tvModels.add("LG 19MB35D");
        tvModels.add("NEC MultiSync EA193Mi");
        tvModels.add("Asus VE198S");

        Collections.sort(tvModels);

        System.out.println(tvModels);

        Model[] model = new Model[4];
        model[0]= new Model("Samsung S19E200BW", "19", 5);
        model[1]= new Model("LG 19MB35D", "18", 2);
        model[2]= new Model("NEC MultiSync EA193Mi", "18",8);
        model[3]= new Model("Asus VE198S", "17", 6);

        Arrays.sort(model);
        Arrays.sort(model, Model.ModelNameComparator);
        Arrays.sort(model, Model.ModelSizeComparator);

        for( Model i: model) {
            System.out.println(i.toString());
        }
    }
}
