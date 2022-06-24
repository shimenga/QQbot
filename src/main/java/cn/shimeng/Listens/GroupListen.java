package cn.shimeng.Listens;

import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.Listener;
import net.mamoe.mirai.event.events.GroupMessageEvent;

public class GroupListen {
    private long MyGroup = 921808862;
    Listener listener = GlobalEventChannel.INSTANCE.subscribeAlways(GroupMessageEvent.class, event -> {
        if (event.getGroup().getId() == MyGroup) {
            if (event.getMessage().contentToString() == "查Q ") {

            }
        }
    });
}
