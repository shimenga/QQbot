package cn.shimeng.Listens;

import cn.shimeng.utils.HttpUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.Listener;
import net.mamoe.mirai.event.events.FriendMessageEvent;

public class PrivateListener {
    private long DevQQ = 2500689407L;
    Listener listener = GlobalEventChannel.INSTANCE.subscribeAlways(FriendMessageEvent.class, event -> {
        System.out.printf(event.getMessage().toString());
        if (event.getSender().getId() == DevQQ) {
            if (event.getMessage().contentToString().equals("getfriend")) {
                event.getFriend().sendMessage(event.getBot().getFriends().toString());
            }
            if (event.getMessage().contentToString().equals("getgroup")) {
                event.getFriend().sendMessage(event.getBot().getGroups().toString());
            }
            if (event.getMessage().contentToString().equals("getweather")) {
                String result = HttpUtils.doGet("http://t.weather.itboy.net/api/weather/city/101180203");
                //event.getSender().sendMessage(result);
                JSONObject json = JSON.parseObject(result);
                String UpdateTime = json.getString("time");
                JSONObject data = json.getJSONObject("data");
                String shidu = data.getString("shidu");//湿度
                String pm25 = data.getString("pm25");//PM2.5
                String pm10 = data.getString("pm10");//PM1.0
                String quality = data.getString("quality");//空气质量
                String wendu = data.getString("wendu");//温度_可能不准
                String ganmao = data.getString("ganmao");//感冒建议
                JSONArray forecast = data.getJSONArray("forecast");
                JSONObject obj = (JSONObject) forecast.get(0);
                String high = obj.getString("high");//最高气温
                String low = obj.getString("low");//最低气温
                String fx = obj.getString("fx");//刮的什么风
                String fl = obj.getString("fl");//风速
                String type = obj.getString("type");//天气类型
                String notice = obj.getString("notice");//留意
                event.getSender().sendMessage(
                        "天气更新时间:" + UpdateTime + "\n" +
                                "天气湿度:" + shidu + "\n" +
                                "PM2.5含量:" + pm25 + "\n" +
                                "PM10含量:" + pm10 + "\n" +
                                "空气质量:" + quality + "\n" +
                                "当前温度（天气更新时的）:" + wendu + "\n" +
                                "天气建议:" + ganmao + "\n" +
                                "最高气温:" + high + "\n" +
                                "最低气温" + low + "\n" +
                                "风的类型:" + fx + "\n" +
                                "风速:" + fl + "\n" +
                                "天气类型:" + type + "\n" +
                                "notice:" + notice);

            }
            if (event.getMessage().contentToString().equals("天气")) {
                String result = HttpUtils.doGet("http://t.weather.itboy.net/api/weather/city/101180203");
                //event.getSender().sendMessage(result);
                JSONObject json = JSON.parseObject(result);
                String UpdateTime = json.getString("time");
                JSONObject data = json.getJSONObject("data");
                String shidu = data.getString("shidu");//湿度
                String pm25 = data.getString("pm25");//PM2.5
                String pm10 = data.getString("pm10");//PM1.0
                String quality = data.getString("quality");//空气质量
                String wendu = data.getString("wendu");//温度_可能不准
                String ganmao = data.getString("ganmao");//感冒建议
                JSONArray forecast = data.getJSONArray("forecast");
                JSONObject obj = (JSONObject) forecast.get(0);
                String high = obj.getString("high");//最高气温
                String low = obj.getString("low");//最低气温
                String fx = obj.getString("fx");//刮的什么风
                String fl = obj.getString("fl");//风速
                String type = obj.getString("type");//天气类型
                String notice = obj.getString("notice");//留意
                event.getSender().sendMessage(
                        "天气更新时间:" + UpdateTime + "\n" +
                                "天气湿度:" + shidu + "\n" +
                                "PM2.5含量:" + pm25 + "\n" +
                                "PM10含量:" + pm10 + "\n" +
                                "空气质量:" + quality + "\n" +
                                "当前温度（天气更新时的）:" + wendu + "\n" +
                                "天气建议:" + ganmao + "\n" +
                                "最高气温:" + high + "\n" +
                                "最低气温" + low + "\n" +
                                "风的类型:" + fx + "\n" +
                                "风速:" + fl + "\n" +
                                "天气类型:" + type + "\n" +
                                "notice:" + notice);
            }
        }
    });
}
