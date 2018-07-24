import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created by Administrator on 2018/7/22.
 */
public class TestFastJson {

    public static void main(String[] args) {
        UserInfo info = new UserInfo();
        info.setName("yangyang");
        info.setAge(20);
        String string = JSON.toJSONString(info);  // 将JavaBean序列化为JSON文本
        System.out.println("JsonString:"+ string);


        String json = "{\"name\":\"yangyang\",\"age\":\"20\"}";
        UserInfo userInfo = JSON.parseObject(json,UserInfo.class); // 把JSON文本parse为JavaBean
        System.out.println("name:"+userInfo.getName());

        JSONObject jsonObject = JSON.parseObject(json); // 把JSON文本parse成JSONObject
        System.out.println("jsonObject:"+jsonObject.toJSONString());

        String json1 = "[{\"name\":\"yangyang\",\"age\":\"20\"},{\"name\":\"yangyang1\",\"age\":\"20\"}]";
        JSONArray jsonArray = JSON.parseArray(json1); // 把JSON文本parse成JSONArray
        System.out.println("jsonArray:"+jsonArray.toJSONString());

        List<UserInfo>  userInfoList = JSON.parseArray(json1,UserInfo.class); //把JSON文本parse成JavaBean集合
        System.out.println("userInfoList[0].name:"+userInfoList.get(0).getName());


        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(info); //将JavaBean转换为JSONObject或者JSONArray（和上面方法的区别是返回值是不一样的）
        System.out.println("JSONObject.name:"+jsonObject1.getString("name"));
        System.out.println("JSONObject.age:"+jsonObject1.getString("age"));
        jsonObject1.put("height","167cm");
        System.out.println("JSONObject.height:"+jsonObject1.getString("height"));
    }


}
