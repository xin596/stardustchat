package com.example.stardustchat;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

/**
 * 新建数据库类
 */
@Database(
        entities = {ChatMessage.class, ChatHistory.class},
        version = 1,
        exportSchema = false  // 添加这行，禁用schema导出
)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ChatMessageDao chatMessageDao();
    public abstract ChatHistoryDao chatHistoryDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "chat_db")
                            .allowMainThreadQueries() // 为了演示直接用主线程，实际项目建议用异步
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}