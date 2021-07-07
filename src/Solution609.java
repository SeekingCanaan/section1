import java.util.*;

// 609.在系统中查找重复文件
public class Solution609 {

    public static void main(String[] args) {
        System.out.println(findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"}));
//        System.out.println(findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)"}));
    }

    /**
     * 已知每一个目录信息，包含目录路径和若干个包含内容的文件，中间是以空格分隔开的
     * 包含内容的文件又含有文件名和内容，内容前后又有小括号括起来了
     * 则遍历目录信息，先用split(" ")方法，将目录和若干包含内容的文件以空格分隔开，然后保存在字符串数组中
     * 则字符串数组下标为 0 的第一个值保存的是目录信息，后面的保存的是包含内容的文件
     * 从下标 1 开始遍历，将文件名和内容分隔开，并且去掉内容前后的括号，保存在一个字符串数组中
     * 然后将整理出来的内容为键，一个存有路径+文件名信息的字符串列表为值，保存在一个map中
     * 通过遍历之后可以得到相同内容的文件路径信息保存在同一个字符串列表中
     * 最后通过遍历map,如果值的长度大于1，也就是有2个及以上的路径包含此内容信息，把它添加到最终的结果中
     */
    public static List<List<String>> findDuplicate(String[] paths) {

        // 定义map，将结果保存在值中
        HashMap<String, List<String>> map = new HashMap<>();

        // 保存最终结果
        List<List<String >> result = new ArrayList<>();

        // 遍历 paths 中的每一个目录信息
        for(String path : paths) {
            // 遍历 paths，以空格为标示将内容分隔开，保存在字符串数组values中
            String[] values = path.split(" ");
            for (int i = 1; i < values.length; i++) {

                // 将文件名和文件内容分开，中间有一个 ( , 那么内容保存在 content[1]中,后面还带了个 )
                String[] content = values[i].split("\\(");

                // 去掉内容后面的 )
                content[1] = content[1].replace(")", "");

                // 将整理出来的内容content[1]作为键，如果有值，则将值放到list中，如果没有值，则创建一个空列表
                List<String > list = map.getOrDefault(content[1], new ArrayList<>());

                // values[0] + "/" + name_cont[0] 将文件路径合并，并添加到list集合中
                list.add(values[0] + "/" + content[0]);

                // 以内容为键，路径列表为值，存放到 map 中
                map.put(content[1], list);
            }

        }

        // 此时map中键保存了所有的内容，值保存了所有相同内容的路径列表，通过遍历将结果取出来
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                result.add(entry.getValue());
            }
        }
        return result;
    }
}
