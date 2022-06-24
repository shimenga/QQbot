package cn.shimeng.Listens;

import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.Listener;
import net.mamoe.mirai.event.events.GroupMessageEvent;

public class GroupListen {
    private long MyGroup = 921808862;
    private long TestGroup = 740061022;
    Listener listener = GlobalEventChannel.INSTANCE.subscribeAlways(GroupMessageEvent.class, event -> {
        if (event.getGroup().getId() == MyGroup) {
            if (event.getMessage().contentToString().equals("查Q ")) {

            }
            if (event.getMessage().contentToString().equals("查q ")) {

            }
            //8219d452-b2a8-4580-8b09-15775eb12579
            if (event.getMessage().contentToString().equals("/bw ")) {
                new Thread(() -> {
                    String[] split = event.getMessage().contentToString().split(" ");
                    if (split.length == 2) {
                        String name = split[1];

                    }
                });
            }
        } else if (event.getGroup().getId() == TestGroup) {
            if (event.getMessage().contentToString().equals("/bw ")) {
                new Thread(() -> {
                    String[] split = event.getMessage().contentToString().split(" ");
                    if (split.length == 2) {
                        String name = split[1];
                        //HttpUtils.sendGet("https://api.mojang.com/users/profiles/minecraft/",)
                    }
                });
            }
        }
    });
}
