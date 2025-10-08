package com.example.stardustchat;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "chat_history")
public class ChatHistory {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String title;
    public String lastMessage;
    public long timestamp;
    public int messageCount;

    // Room要求无参构造
    public ChatHistory() {}
    /**
     * 构造函数，初始化聊天历史
     * id 聊天记录ID
     * title 聊天标题
     * lastMessage 最后一条消息内容
     * timestamp 最后一条消息时间戳
     * messageCount 消息总数
     */
    public ChatHistory(String id, String title, String lastMessage, long timestamp, int messageCount) {
        this.title = title;
        this.lastMessage = lastMessage;
        this.timestamp = timestamp;
        this.messageCount = messageCount;
    }

    // 获取id
    public String getTitle() { return title; }
    public String getLastMessage() { return lastMessage; }
    public long getTimestamp() { return timestamp; }
    public int getMessageCount() { return messageCount; }

    // 设置id
    public void setTitle(String title) { this.title = title; }
    public void setLastMessage(String lastMessage) { this.lastMessage = lastMessage; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
    public void setMessageCount(int messageCount) { this.messageCount = messageCount; }
}