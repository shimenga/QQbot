package cn.shimeng.Listener.Group;

import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.Listener;
import net.mamoe.mirai.event.events.GroupMessageEvent;

public class GroupAuth {
    Listener GroupAuth_listener = GlobalEventChannel.INSTANCE.subscribeAlways(GroupMessageEvent.class, event -> {

    });
}
