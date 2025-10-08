package com.example.stardustchat;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ChatMessageDao {
    @Insert
    void insert(ChatMessage message);

    @Query("SELECT * FROM chat_message WHERE historyId = :historyId ORDER BY timestamp ASC")
    List<ChatMessage> getMessagesForHistory(String historyId);

    @Query("DELETE FROM chat_message WHERE historyId = :historyId")
    void deleteMessagesForHistory(String historyId);

    // 新增：获取某个historyId的消息数量
    @Query("SELECT COUNT(*) FROM chat_message WHERE historyId = :historyId")
    int getMessageCount(String historyId);

    //根据时间范围获取消息
    //startTime 被设置为当天零点，endTime 是当前时间
    @Query("SELECT * FROM chat_message WHERE historyId = :historyId AND timestamp >= :startTime AND timestamp <= :endTime ORDER BY timestamp ASC")
    List<ChatMessage> getMessagesByTime(String historyId, long startTime, long endTime);
}

