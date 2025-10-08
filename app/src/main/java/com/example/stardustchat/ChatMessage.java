package com.example.stardustchat;

//消息数据结构类
//用于封装每一条聊天消息的数据，包括消息内容（文字）、消息类型（是用户的还是AI的），便于后续统一管理和显示。

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "chat_message")
public class ChatMessage {
    // 常量：用户消息类型
    public static final int TYPE_USER = 1;
    // 常量：AI（机器人）消息类型
    public static final int TYPE_BOT = 2;

    @PrimaryKey(autoGenerate = true)
    public int id;

    // 消息内容
    public String content;
    // 消息类型（用户或AI）
    public int type;
    // 消息的时间戳
    public long timestamp;
    //所属历史记录的id
    public String historyId;


    /**
     * 构造函数：创建新消息（自动生成当前时间戳）
     * content 消息内容
     * type 消息类型（TYPE_USER 或 TYPE_BOT）
     */
    public ChatMessage(String content, int type) {
        this.content = content;
        this.type = type;
        this.timestamp = System.currentTimeMillis();
    }

    @Ignore
    public ChatMessage() {
        // 默认构造函数
    }

    @Ignore
    public ChatMessage(String content, int type, long timestamp,String historyId) {
        this.content = content;
        this.type = type;
        this.timestamp = timestamp;
        this.historyId= historyId;//加的
    }

    // 获取id
    public String getContent() { return content; }
    public int getType() { return type; }
    public long getTimestamp() { return timestamp; }
    public String getHistoryId(){return historyId;}

    // 设置id
    public void setContent(String content) { this.content = content; }
    public void setType(int type) { this.type = type; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
    public void setHistoryId(String historyId){this.historyId=historyId;}


}