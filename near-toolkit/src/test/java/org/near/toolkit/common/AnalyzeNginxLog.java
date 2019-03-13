package org.near.toolkit.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Willard.Hu on 2016/11/17 0017.
 */
public class AnalyzeNginxLog {


    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        String str;
        StringBuilder sb = new StringBuilder();
        int countLine = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("D:/access_log.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("D:/log.txt"))) {
            while ((str = br.readLine()) != null) {
                countLine++;
                if (countLine > 901666) { // countLine < 336140 ||
                    break;
                }

                String[] group = StringUtil.split(str, ' ');
                String url = group[6];
                int idx = url.indexOf("?");
                String suburl;
                if (idx > -1) {
                    suburl = url.substring(0, url.indexOf("?"));
                } else {
                    suburl = url;
                }

                if (suburl.contains("/wechatapp/qrcodeRedirect/")) {
                    suburl = suburl.substring(0, "/wechatapp/qrcodeRedirect/".length());
                }

                int count;
                if (map.get(suburl) == null) {
                    count = 1;
                } else {
                    count = map.get(suburl) + 1;
                }
                map.put(suburl, count);
            }
            System.out.println(map.size());

            for (Map.Entry<String, Integer> item : map.entrySet()) {
                String line = item.getKey() + " " + item.getValue() + "\n";
                bw.write(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        //BufferedWriter bw = new BufferedWriter()
    }
}
