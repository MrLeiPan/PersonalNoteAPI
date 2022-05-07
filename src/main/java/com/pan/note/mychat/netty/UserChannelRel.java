package com.pan.note.mychat.netty;

import io.netty.channel.Channel;
import io.netty.util.AttributeKey;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 记录该类与channel的联系
 * @auth0r Mao
 * @date 2021/9/13 12:48
 */
public class UserChannelRel {

    //用来存储 用户Id和channel的关系 （方便通过Key(userId)查询到 对应的channel）
    private static Map<Long, Channel> channelMap  = new ConcurrentHashMap<>();

    private static final String CHANNEL_KEY = "userId";

    /**
     * 判断一个用户是否在线
     *
     * @param userId
     * @return
     */
    public static Boolean isOnline(Long userId) {
        return channelMap.containsKey(userId);
    }

    /**
     * 建立 user与channel之间的关系
     * @param userId
     * @param channel
     */
    public static void put(Long userId,Channel channel){

        //存储channel和用户ID的对应关系 方便通过channel寻找到对应的userId
        AttributeKey<String> key = AttributeKey.valueOf(CHANNEL_KEY);
        channel.attr(key).set(String.valueOf(userId));

        //添加到map中将channel
        channelMap .put(userId,channel);
    }

    /**
     * 通过 userId 查找 Channel
     * @param senderId
     * @return
     */
    public static Channel get(Long senderId){
        return channelMap .get(senderId);
    }


    /**
     * 判断一个通道是否有用户在使用
     * 可做信息转发时判断该通道是否合法
     *
     * @param channel
     * @return
     */
    public static boolean hasUser(Channel channel) {
        AttributeKey<String> key = AttributeKey.valueOf(CHANNEL_KEY);
        //netty移除了这个map的remove方法,这里的判断谨慎一点
        return (channel.hasAttr(key) || channel.attr(key).get() != null);
    }

    /**
     * 退出登陆后 断开该channel与 userId的链接
     * @param channel
     */
    public static void remove(Channel channel){
        if(hasUser(channel)){
            AttributeKey<String> key = AttributeKey.valueOf(CHANNEL_KEY);
            channel.attr(key).remove();
            channelMap.remove(channel.attr(key).get());
        }
    }

    /**
     * 遍历打印当前所以对应关系
     */
    public static void manageDetail(){
        for (Map.Entry<Long, Channel> stringChannelEntry : channelMap .entrySet()) {
            System.out.println(stringChannelEntry.getKey() + "--->" + stringChannelEntry.getValue());
        }
    }
}
