package cn.shimeng.Listens;

import cn.shimeng.utils.HttpUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.Listener;
import net.mamoe.mirai.event.events.GroupMessageEvent;

public class GroupListener {
    private long MyGroup = 921808862;
    private long TestGroup = 740061022;
    private long NoFindQQ = 2500689407L;
    private long TestBot = 3249197780L;
    Listener listener = GlobalEventChannel.INSTANCE.subscribeAlways(GroupMessageEvent.class, event -> {
        System.out.println(event.getGroup().getId());
        if (event.getGroup().getId() == MyGroup) {
            if (event.getBot().getId() != TestBot) {
                if (event.getMessage().contentToString().startsWith("/bw ")) {
                    new Thread(() -> {
                        String[] split = event.getMessage().contentToString().split(" ");
                        if (split.length == 2) {
                            String name = split[1];
                            //HttpUtils.sendGet("https://api.mojang.com/users/profiles/minecraft/",)
                            HttpUtils.HttpGetResult result = HttpUtils.getHttps("https://api.mojang.com/users/profiles/minecraft/" + name);
                            if (result.response == 200) {
                                JSONObject json = JSON.parseObject(result.result);
                                HttpUtils.HttpGetResult res = HttpUtils.getHttps("https://api.hypixel.net/player?key=8219d452-b2a8-4580-8b09-15775eb12579&uuid=" + json.getString("id"));
                                if (res.response == 200) {
                                    JSONObject json1 = JSON.parseObject(res.result);
                                    JSONObject bw = json1.getJSONObject("player").getJSONObject("stats").getJSONObject("Bedwars");
                                    int coins = bw.getIntValue("coins");
                                    int kills = bw.getIntValue("kills_bedwars");
                                    int deaths = bw.getIntValue("deaths_bedwars");
                                    String kd = String.format("%.2f", (double) ((double) kills / (double) deaths));
                                    event.getSubject().sendMessage("UserName:" + name + "\n" + "coins:" + coins + "\n" + "kills:" + kills + "\n" + "deaths:" + deaths + "\n" + "kd:" + kd);
                                }
                            } else if (result.response != -1) {
                                event.getSubject().sendMessage("Error(" + result.response + "): Mojang return:" + result.result);
                            } else {
                                event.getSubject().sendMessage("Error:The player does not exist");
                            }
                        }
                    }).start();
                }
                if (event.getMessage().contentToString().startsWith("查Q ")) {
                    String[] split = event.getMessage().contentToString().split(" ");
                    if (split.length == 2) {
                        new Thread(() -> {
                            String QQ = split[1];
                            if (QQ.equals(Long.toString(NoFindQQ))) {
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
                            if (QQ.equals(Long.toString(NoFindQQ))) {
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
        } else if (event.getGroup().getId() == TestGroup) {
            if (event.getMessage().contentToString().startsWith("/bw ")) {
                new Thread(() -> {
                    String[] split = event.getMessage().contentToString().split(" ");
                    if (split.length == 2) {
                        String name = split[1];
                        //HttpUtils.sendGet("https://api.mojang.com/users/profiles/minecraft/",)
                        HttpUtils.HttpGetResult result = HttpUtils.getHttps("https://api.mojang.com/users/profiles/minecraft/" + name);
                        if (result.response == 200) {
                            JSONObject json = JSON.parseObject(result.result);
                            HttpUtils.HttpGetResult res = HttpUtils.getHttps("https://api.hypixel.net/player?key=8219d452-b2a8-4580-8b09-15775eb12579&uuid=" + json.getString("id"));
                            if (res.response == 200) {
                                JSONObject json1 = JSON.parseObject(res.result);
                                JSONObject bw = json1.getJSONObject("player").getJSONObject("stats").getJSONObject("Bedwars");
                                int coins = bw.getIntValue("coins");
                                int kills = bw.getIntValue("kills_bedwars");
                                int deaths = bw.getIntValue("deaths_bedwars");
                                String kd = String.format("%.2f", (double) ((double) kills / (double) deaths));
                                event.getSubject().sendMessage("UserName:" + name + "\n" + "coins:" + coins + "\n" + "kills:" + kills + "\n" + "deaths:" + deaths + "\n" + "kd:" + kd);
                            }
                        } else if (result.response != -1) {
                            event.getSubject().sendMessage("Error(" + result.response + "): Mojang return:" + result.result);
                        } else {
                            event.getSubject().sendMessage("Error:The player does not exist");
                        }
                    }
                }).start();
            }
            if (event.getMessage().contentToString().startsWith("查Q ")) {
                String[] split = event.getMessage().contentToString().split(" ");
                if (split.length == 2) {
                    new Thread(() -> {
                        String QQ = split[1];
                        if (QQ.equals(Long.toString(NoFindQQ))) {
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
                        if (QQ.equals(Long.toString(NoFindQQ))) {
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
    });
}
