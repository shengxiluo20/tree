import com.alibaba.fastjson.JSONObject;
import com.join.entity.SourceClass;
import com.join.entity.TargetClass;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author chi  2018-06-14 13:24
 **/
public class Test {
    public static void main(String[] args) {
        ArrayList<SourceClass> list = new ArrayList<>();
        list.add(new SourceClass("1", "1", "0"));
        list.add(new SourceClass("2", "2", "1"));
        list.add(new SourceClass("3", "3", "1"));
        list.add(new SourceClass("4", "4", "2"));
        list.add(new SourceClass("5", "5", "2"));
        list.add(new SourceClass("6", "6", "4"));
        list.add(new SourceClass("7", "7", "5"));
        list.add(new SourceClass("8", "8", "5"));

        HashMap<String, TargetClass> map = new HashMap<>();
        map.put("0", new TargetClass("0", "根", null, new ArrayList<>()));
        for (SourceClass sourceClass : list) {
            map.put(sourceClass.getId(), TargetClass.covert(sourceClass));

            String pId = sourceClass.getPId();
            TargetClass targetClass = map.get(pId);
            targetClass.getChild().add(map.get(sourceClass.getId()));
        }
        System.out.println(JSONObject.toJSONString(map.get("0")));

    }
}
