package javaAdvanceHomework;

import java.util.Scanner;

public class java4_13Homework_10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String s = input.next();
        double sum = 0;
        //判断是否包含"-"号
        if (s.contains("-")) {
            s = s.replace("-", "+-");
        }
        //排除连"++"号的影响，如5-3++-3
        String[] ss = s.split("\\+");
        for (int k = 0; k < ss.length; k++) {
            if (ss[k].equals("")) {
                ss[k] = "0";
            }
        }
        //剥离符号，进行运算
        for (int i = 0; i < ss.length; i++) {
        //判断是否同时具有"*"和"/"
            if (ss[i].contains("*") && ss[i].contains("/")) {
                double sum1 = 1;
                String[] sss = ss[i].split("\\*");
                for (int l = 0; l < sss.length; l++) {
                    //判断是否有"/",如果有继续剥离
                    if (sss[l].contains("/")) {
                        String[] ssss = sss[l].split("\\/");
                        double sum2 = Integer.parseInt(ssss[0]);
                        for (int h = 1; h < ssss.length; h++) {
                            sum2 = sum2 / Integer.parseInt(ssss[h]);
                        }
                        sum1 = sum1 * sum2;
                    } else {
                        sum1 = sum1 * Integer.parseInt(sss[l]);
                    }
                }
                sum += sum1;
            }
            //判断是否只有"*"
            else if (ss[i].contains("*") && !ss[i].contains("/")) {
                String[] sss = ss[i].split("\\*");
                double sum1 = 1;
                for (int l = 0; l < sss.length; l++) {
                    sum1 = sum1 * Integer.parseInt(sss[l]);
                }
                sum += sum1;
            }
            //判断是否只有"/"
            else if (ss[i].contains("/") && !ss[i].contains("*")) {
                String[] sss = ss[i].split("\\/");
                double sum1 = Integer.parseInt(sss[0]);
                for (int l = 1; l < sss.length; l++) {
                    sum1 = sum1 / Integer.parseInt(sss[l]);
                }
                sum += sum1;

            }
            //只包含数字
            else {
                sum += Integer.parseInt(ss[i]);
            }

        }




        //输出总和
        System.out.println(sum);
    }
}
