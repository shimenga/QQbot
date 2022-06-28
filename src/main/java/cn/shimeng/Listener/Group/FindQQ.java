package cn.shimeng.Listener.Group;

import cn.shimeng.Basicplugin;
import cn.shimeng.utils.HttpUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.Listener;
import net.mamoe.mirai.event.events.GroupMessageEvent;

public class FindQQ {
    Listener FindQQ_listener = GlobalEventChannel.INSTANCE.subscribeAlways(GroupMessageEvent.class, event -> {
        if (event.getGroup().getId() == Basicplugin.MyGroup) {
            if (event.getBot().getId() != Basicplugin.TestBot) {
                if (event.getMessage().contentToString().startsWith("查Q ")) {
                    String[] split = event.getMessage().contentToString().split(" ");
                    if (split.length == 2) {
                        new Thread(() -> {
                            String QQ = split[1];
                            if (QQ.equals(Long.toString(Basicplugin.DevQQ))) {
                                event.getSubject().sendMessage("Error");
                            } else if (QQ.equals(Long.toString(event.getBot().getId()))) {
                                event.getSubject().sendMessage("Error");
                            } else {
                                HttpUtils.HttpGetResult result = HttpUtils.getHttps("https://qb-api.ltd/allcha.php?qq=" + QQ);
                                if (result.response == 200) {
                                    JSONObject json = JSON.parseObject(result.result);
                                    String msg = json.getString("msg");
                                    if (msg.equals("无结果")) {
                                        event.getSubject().sendMessage("There is no data");
                                    } else {
                                        JSONObject data = json.getJSONObject("data");
                                        String findQQ = data.getString("qq");
                                        String mobilePhone = data.getString("mobile");
                                        String LOL = data.getString("lol");
                                        String wb = data.getString("wb");
                                        event.getSubject().sendMessage("QQ:" + findQQ + "\n" + "Mobile phone number:" + mobilePhone + "\n" + "LOL:" + LOL + "\n" + "weibo:" + wb + "\n");
                                    }
                                } else {
                                    event.getSubject().sendMessage("Error:The API request failed");
                                }
                            }
                        }).start();
                    }
                }
                if (event.getMessage().contentToString().startsWith("查q ")) {
                    String[] split = event.getMessage().contentToString().split(" ");
                    if (split.length == 2) {
                        new Thread(() -> {
                            String QQ = split[1];
                            if (QQ.equals(Long.toString(Basicplugin.DevQQ))) {
                                event.getSubject().sendMessage("Error");
                            } else if (QQ.equals(Long.toString(event.getBot().getId()))) {
                                event.getSubject().sendMessage("Error");
                            } else {
                                HttpUtils.HttpGetResult result = HttpUtils.getHttps("https://qb-api.ltd/allcha.php?qq=" + QQ);
                                if (result.response == 200) {
                                    JSONObject json = JSON.parseObject(result.result);
                                    String msg = json.getString("msg");
                                    if (msg.equals("无结果")) {
                                        event.getSubject().sendMessage("There is no data");
                                    } else {
                                        JSONObject data = json.getJSONObject("data");
                                        String findQQ = data.getString("qq");
                                        String mobilePhone = data.getString("mobile");
                                        String LOL = data.getString("lol");
                                        String wb = data.getString("wb");
                                        event.getSubject().sendMessage("QQ:" + findQQ + "\n" + "Mobile phone number:" + mobilePhone + "\n" + "LOL:" + LOL + "\n" + "weibo:" + wb + "\n");
                                    }
                                } else {
                                    event.getSubject().sendMessage("Error:The API request failed");
                                }
                            }
                        }).start();
                    }
                }
            } else if (event.getGroup().getId() == Basicplugin.TestGroup) {
                if (event.getMessage().contentToString().startsWith("查Q ")) {
                    String[] split = event.getMessage().contentToString().split(" ");
                    if (split.length == 2) {
                        new Thread(() -> {
                            String QQ = split[1];
                            if (QQ.equals(Long.toString(Basicplugin.DevQQ))) {
                                event.getSubject().sendMessage("Error");
                            } else if (QQ.equals(Long.toString(event.getBot().getId()))) {
                                event.getSubject().sendMessage("Error");
                            } else {
                                HttpUtils.HttpGetResult result = HttpUtils.getHttps("https://qb-api.ltd/allcha.php?qq=" + QQ);
                                if (result.response == 200) {
                                    JSONObject json = JSON.parseObject(result.result);
                                    String msg = json.getString("msg");
                                    if (msg.equals("无结果")) {
                                        event.getSubject().sendMessage("There is no data");
                                    } else {
                                        JSONObject data = json.getJSONObject("data");
                                        String findQQ = data.getString("qq");
                                        String mobilePhone = data.getString("mobile");
                                        String LOL = data.getString("lol");
                                        String wb = data.getString("wb");
                                        event.getSubject().sendMessage("QQ:" + findQQ + "\n" + "Mobile phone number:" + mobilePhone + "\n" + "LOL:" + LOL + "\n" + "weibo:" + wb + "\n");
                                    }
                                } else {
                                    event.getSubject().sendMessage("Error:The API request failed");
                                }
                            }
                        }).start();
                    }
                }
                if (event.getMessage().contentToString().startsWith("查q ")) {
                    String[] split = event.getMessage().contentToString().split(" ");
                    if (split.length == 2) {
                        new Thread(() -> {
                            String QQ = split[1];
                            if (QQ.equals(Long.toString(Basicplugin.DevQQ))) {
                                event.getSubject().sendMessage("Error");
                            } else if (QQ.equals(Long.toString(event.getBot().getId()))) {
                                event.getSubject().sendMessage("Error");
                            } else {
                                HttpUtils.HttpGetResult result = HttpUtils.getHttps("https://qb-api.ltd/allcha.php?qq=" + QQ);
                                if (result.response == 200) {
                                    JSONObject json = JSON.parseObject(result.result);
                                    String msg = json.getString("msg");
                                    if (msg.equals("无结果")) {
                                        event.getSubject().sendMessage("There is no data");
                                    } else {
                                        JSONObject data = json.getJSONObject("data");
                                        String findQQ = data.getString("qq");
                                        String mobilePhone = data.getString("mobile");
                                        String LOL = data.getString("lol");
                                        String wb = data.getString("wb");
                                        event.getSubject().sendMessage("QQ:" + findQQ + "\n" + "Mobile phone number:" + mobilePhone + "\n" + "LOL:" + LOL + "\n" + "weibo:" + wb + "\n");
                                    }
                                } else {
                                    event.getSubject().sendMessage("Error:The API request failed");
                                }
                            }
                        }).start();
                    }
                }
            }
        }
    });
}
