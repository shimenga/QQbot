package cn.shimeng.Listener.Friend;

import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.Listener;
import net.mamoe.mirai.event.events.FriendMessageEvent;

import static cn.shimeng.Basicplugin.DevQQ;

public class GetGroupList {
    Listener GetGroupList_listener = GlobalEventChannel.INSTANCE.subscribeAlways(FriendMessageEvent.class, event -> {
        if (event.getSender().getId() == DevQQ) {
            if (event.getMessage().contentToString().equals("getgroup")) {
                event.getFriend().sendMessage(event.getBot().getGroups().toString());
            }
            if (event.getMessage().contentToString().equals("Getgroup")) {
                event.getFriend().sendMessage(event.getBot().getGroups().toString());
            }
            if (event.getMessage().contentToString().equals("GetGroup")) {
                event.getFriend().sendMessage(event.getBot().getGroups().toString());
            }
        }
    });
}
