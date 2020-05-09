package java_Unit20.java5_09class;

import java.util.Comparator;

public class ComparatorY implements Comparator<java5_09classAndjava20_4PointClass> {

    @Override
    public int compare(java5_09classAndjava20_4PointClass mp1, java5_09classAndjava20_4PointClass mp2) {

        int flag = -2;
        if (mp1.y > mp2.y){
            flag = 1;
        } else if (mp1.y < mp2.y){
            flag = -1;
        } else {
            if (mp1.x > mp2.x) {
                flag = 1;
            } else if (mp1.x < mp2.x) {
                flag = -1;
            } else {
                flag = 0;
            }
        }
        return flag;
    }
}
