import com.alibaba.fastjson.JSONObject;
import com.join.entity.TreeSource;
import com.join.entity.TreeTargetDto;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author chi  2018-06-14 13:24
 **/
public class TreeCovertUtil {


    public static TreeTargetDto getTree(ArrayList<TreeSource> list){
        HashMap<Integer, TreeTargetDto> map = new HashMap<>();
        //新建根节点
        TreeTargetDto rootNode = new TreeTargetDto(0, "根节点", null, new ArrayList<>());
        map.put(0, rootNode);
        for (TreeSource treeSource : list) {
            TreeTargetDto childNode = TreeTargetDto.covert(treeSource);
            map.put(treeSource.getId(), childNode);
            //父节点id
            Integer pId = treeSource.getPId();
            //父节点
            TreeTargetDto parentNode = map.get(pId);
            //给父节点的child属性赋当前节点
            parentNode.getChild().add(childNode);
        }
        return map.get(0);
    }


    public static void main(String[] args) {

        //模拟数据库查询请求.注意要以pio顺序搜索
        ArrayList<TreeSource> list = new ArrayList<>();
        list.add(new TreeSource(1, "树节点1", 0));
        list.add(new TreeSource(2, "树节点2", 1));
        list.add(new TreeSource(3, "树节点3", 1));
        list.add(new TreeSource(4, "树节点4", 2));
        list.add(new TreeSource(5, "树节点5", 2));
        list.add(new TreeSource(6, "树节点6", 4));
        list.add(new TreeSource(7, "树节点7", 5));
        list.add(new TreeSource(8, "树节点8", 5));
        System.out.println("原始数据:");
        list.forEach(treeSource -> {
            System.out.println(JSONObject.toJSONString(treeSource));
        });

        //执行操作
        TreeTargetDto tree = TreeCovertUtil.getTree(list);

        //打印返回值
        System.out.println("转换的树形数据");
        System.out.println(JSONObject.toJSONString(tree));
    }
}
