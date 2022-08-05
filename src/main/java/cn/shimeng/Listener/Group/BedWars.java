package cn.shimeng.Listener.Group;

import cn.shimeng.Basicplugin;
import cn.shimeng.utils.HttpUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.Listener;
import net.mamoe.mirai.event.events.GroupMessageEvent;

public class BedWars {
    Listener BedWars_listener = GlobalEventChannel.INSTANCE.subscribeAlways(GroupMessageEvent.class, event -> {
        if (event.getGroup().getId() == Basicplugin.MyGroup) {
            //if (event.getBot().getId() != Basicplugin.TestBot) {
            if (event.getMessage().contentToString().startsWith("/bw ")) {
                new Thread(() -> {
                    String[] split = event.getMessage().contentToString().split(" ");
                    if (split.length == 2) {
                        String name = split[1];
                        //HttpUtils.sendGet("https://api.mojang.com/users/profiles/minecraft/",)
                        HttpUtils.HttpGetResult result = HttpUtils.getHttps("https://api.mojang.com/users/profiles/minecraft/" + name);
                        if (result.response == 200) {
                            JSONObject json = JSON.parseObject(result.result);
                            HttpUtils.HttpGetResult res = HttpUtils.getHttps("https://api.hypixel.net/player?key=&uuid=" + json.getString("id"));
                            if (res.response == 200) {
                                JSONObject json1 = JSON.parseObject(res.result);
                                JSONObject bw = json1.getJSONObject("player").getJSONObject("stats").getJSONObject("BedWars");
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
                //}
            }
        } else if (event.getGroup().getId() == Basicplugin.TestGroup) {
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
                                JSONObject bw = json1.getJSONObject("player").getJSONObject("stats").getJSONObject("BedWars");
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
        }
    });
}
