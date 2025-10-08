package com.example.stardustchat;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ChatHistoryDao {
    @Insert
    long insert(ChatHistory history);

    @Query("SELECT * FROM chat_history ORDER BY timestamp DESC")
    List<ChatHistory> getAllHistories();

    @Query("SELECT * FROM chat_history WHERE id = :id LIMIT 1")
    ChatHistory getHistoryById(int id);

    @Query("DELETE FROM chat_history WHERE id = :id")
    void deleteHistory(int id);
    @Update
    void update(ChatHistory history);
}