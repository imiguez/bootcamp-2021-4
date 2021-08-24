package junit.imiguez;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class CSVFileSort {

    /*
    myjinxin2015;raulbc777;smile67;Dentzil;SteffenVogel_79\n
    17945;10091;10088;3907;10132\n
    2;12;13;48;11
     */

    public static void main(String[] args) {
        String input = "myjinxin2015;raulbc777;smile67;Dentzil;SteffenVogel_79\n" +
                "17945;10091;10088;3907;10132\n" +
                "2;12;13;48;11";
        System.out.println(sortFile(input));
    }

    public static String sortFile(String data) {
        String table = "";
        String [] rows = data.split("\n");
        HashMap<Integer,Integer> orderPos = getOrder(rows[0].split(";"));
        for (int i = 0; i < rows.length; i++)
            table += sortLine(rows[i].split(";"), orderPos) + "\n";
        return table;
    }

    private static String sortLine(String [] row, HashMap<Integer,Integer> order) {
        String line = "|";
        for (int i = 0; i < row.length; i++)
            line += row[order.get(i)]+"|";
        return line;
    }

    private static HashMap<Integer,Integer> getOrder(String [] thead) {
        ArrayList<String> columns = new ArrayList();
        HashMap<String, Integer> sorted = new HashMap<>();
        HashMap<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < thead.length; i++)
            columns.add(thead[i].toLowerCase());
        Collections.sort(columns);
        for (int i = 0; i < columns.size(); i++)
            sorted.put(columns.get(i), i);
        for (int i = 0; i < thead.length; i++)
            index.put(sorted.get(thead[i].toLowerCase()), i);
        return index;
    }

}
