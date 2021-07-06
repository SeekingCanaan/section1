import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// 609.在系统中查找重复文件
public class Solution609 {

    public static void main(String[] args) {
        System.out.println(findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"}));
    }

    public static List<List<String>> findDuplicate(String[] paths) {

        // 定义map，保存结果
        HashMap<String, List<String>> map = new HashMap<>();

        for(String path : paths) {

            String[] values = path.split(" ");
            System.out.println(Arrays.toString(values));
            System.out.println("-----------------------");
            for (int i = 1; i < values.length; i++) {

                // 将文件名和文件内容分开，中间有一个 ( , 那么内容保存在 name_cont[1]中,后面还带了个 )
                String[] name_cont = values[i].split("\\(");
                // 去掉内容后面的 )
                name_cont[1] = name_cont[1].replace(")", "");
                // 将
                List<String > list = map.getOrDefault(name_cont[1], new ArrayList<>());

                // values[0] + "/" + name_cont[0] 将文件路径合并，并添加到list集合中
                list.add(values[0] + "/" + name_cont[0]);

                System.out.println(name_cont[1]);
                System.out.println(list.toString() + "===========");
                map.put(name_cont[1], list);
            }

        }
        return new ArrayList<>(new ArrayList<>());
    }
}
