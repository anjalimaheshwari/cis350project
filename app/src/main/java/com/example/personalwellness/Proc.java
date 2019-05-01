package com.example.personalwellness;
import java.util.ArrayList;
import java.util.List;

public class Proc {
    private ResourceDB db;

    public Proc(ResourceDB db){
        this.db = db;
    }

    public int getRecs (CurrentUser user) {
        List<Resource> recs = new ArrayList<Resource>();
        //0 : sc, 1 : mh, 2 : ph, 3 : d, 4 : sl, 5 : st
        int[] scores = new int[6];
        scores[0] = user.getMentalHealth();
        scores[1] = user.getStress();
        scores[2] = user.getPhysicalHealth();
        scores[3] = user.getCommunity();
        scores[4] = user.getSleep();
        //find highest
//        int i = getMax(scores);
//        if (i == 0) { //sc
//            recs.addAll(db.getCategoryResource("sc"));
//        } if (i == 1) { //mh
//            recs.addAll(db.getCategoryResource("mh"));
//        } if (i == 2) { // ph
//            recs.addAll(db.getCategoryResource("ph"));
//        } if (i == 3) { // d
//            recs.addAll(db.getCategoryResource("d"));
//        } if (i == 4) { //sl
//            recs.addAll(db.getCategoryResource("sl"));
//        } else { //st
//            recs.addAll(db.getCategoryResource("st"));
//        }
        //find second highest score != 0
//        scores[i] = 0;
        int j = getMax(scores);
//        if (scores[j] != 0) {
//            //finds the intensity index of the next most pressing wellness problem, if its not that
//            //deep then it only gives one suggestion, if it is deep, it gives 3:)
//            int l = 1;
//            if (scores[j] > 5 || recs.size() < 1) {
//                l = 3;
//            }
//            if (j == 0) { //sc
//                for (int x = 0; x < l; x++){
//                    recs.add(db.getCategoryResource("sc").get(x));
//                }
//            } if (j == 1) { //mh
//                for (int x = 0; x < l; x++) {
//                    recs.add(db.getCategoryResource("mh").get(0));
//                }
//            } if (j == 2) { // ph
//                for (int x = 0; x < l; x++) {
//                    recs.add(db.getCategoryResource("ph").get(0));
//                }
//            } if (j == 3) { // d
//                for (int x = 0; x < l; x++) {
//                    recs.add(db.getCategoryResource("d").get(0));
//                }
//            } if (j == 4) { //sl
//                for (int x = 0; x < l; x++) {
//                    recs.add(db.getCategoryResource("sl").get(0));
//                }
//            } else { //st
//                for (int x = 0; x < l; x++) {
//                    recs.add(db.getCategoryResource("st").get(0));
//                }
//            }
//        }
//        user.updatePersonalRecs(recs);
        return j;
    }

    private int getMax (int[] scores) {
        int maxCategory = 0;
        int maxInt = 0;
        //0 : sc, 1 : mh, 2 : ph, 3 : d, 4 : sl, 5 : st
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > maxInt) {
                maxInt = scores[i];
                maxCategory = i;
            }
        }
        return maxCategory;
    }

}
