package com.example.stardustchat;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

//将消息列表（List<ChatMessage>）和每个 item（气泡布局）进行绑定，
//并根据消息类型选择显示左边（AI）还是右边（用户）的气泡。
//在 RecyclerView 的每一个位置加载对应的消息和对应的气泡布局。

// 聊天消息适配器，继承自RecyclerView.Adapter
// 自定义的适配器类，用于将消息数据显示在RecyclerView上，根据不同类型消息（用户/机器人）使用不同布局。
public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ChatMessage> messages;// 用于存储所有聊天消息的列表

    // 构造方法，传入消息列表
    // 初始化时传入消息列表，赋值给成员变量。
    public ChatAdapter(List<ChatMessage> messages) {
        this.messages = messages;
    }

    // 返回指定位置消息的类型（用户消息或机器人消息）
    // 调用ChatMessage的getType方法（TYPE_USER或TYPE_BOT）
    //position 就是“当前要显示或操作的这条消息在消息列表中的序号”。
    // 返回指定位置的消息类型（用户还是机器人），以决定加载哪种布局
    @Override
    public int getItemViewType(int position) {
        return messages.get(position).getType();
    }


    //onCreateViewHolder：加载 item_chat_user.xml 或 item_chat_bot.xml
    // 根据消息类型（viewType），加载不同的布局文件（item_chat_user或item_chat_bot）并返回不同的ViewHolder。
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ChatMessage.TYPE_USER) {// 如果是用户消息
            View view = LayoutInflater.from(parent.getContext())// 加载用户消息item的布局
                    .inflate(R.layout.item_chat_user, parent, false);
            return new UserViewHolder(view);// 返回UserViewHolder
        }else {// 如果是机器人消息
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_chat_bot, parent, false);// 加载机器人消息item的布局
            return new BotViewHolder(view);// 返回BotViewHolder
        }
    }

    //onBindViewHolder：绑定消息内容到 TextView 上
    // 将消息内容设置到对应的ViewHolder中（区分用户和机器人消息）。
    //ViewHolder（直译为“视图持有者”）的作用是缓存 item 布局中的控件对象，
    // 避免在滚动列表时频繁调用 findViewById，从而提升性能、减少卡顿。
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ChatMessage msg = messages.get(position);// 获取当前position的消息
        // position 就是“当前要显示或操作的这条消息在消息列表中的序号”。
        if (holder instanceof UserViewHolder) {// 如果是用户消息的ViewHolder
            UserViewHolder userHolder = (UserViewHolder) holder;
            userHolder.tvMessage.setText(msg.getContent());// 设置用户消息内容到TextView
            //编辑按钮
            userHolder.itemView.findViewById(R.id.btnEdit).setOnClickListener(view -> {
                Context context = view.getContext();
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("编辑消息");
                final EditText input = new EditText(context);
                input.setText(msg.getContent());
                builder.setView(input);
                builder.setPositiveButton("发送", (dialog, which) -> {
                    String editedText = input.getText().toString().trim();
                    if (!editedText.isEmpty()) {
                        // 通知 MainActivity 发送新消息
                        if (context instanceof MainActivity) {
                            ((MainActivity) context).sendEditedUserMessage(editedText);
                        }
                    }
                });

                builder.setNegativeButton("取消", null);

                builder.show();
            });
            //复制按钮
            userHolder.itemView.findViewById(R.id.btnCopy).setOnClickListener(view -> {
                ClipboardManager clipboard = (ClipboardManager) view.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("message", msg.getContent());
                clipboard.setPrimaryClip(clip);
                Toast.makeText(view.getContext(), "已复制", Toast.LENGTH_SHORT).show();
            });
        } else if (holder instanceof BotViewHolder) {// 如果是机器人消息的ViewHolder
            ((BotViewHolder) holder).tvMessage.setText(msg.getContent());// 设置机器人消息内容到TextView
        }

    }

    @Override
    public int getItemCount() {
        return messages.size();
    }// 返回消息总数

    // 分别为用户消息和机器人消息的ViewHolder类，负责持有item布局中的
    // TextView控件引用（tvMessage），用于显示消息内容。

    // 用户消息的ViewHolder，绑定item_chat_user.xml中的控件
    static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView tvMessage;// 显示消息内容的TextView
        UserViewHolder(View itemView) {
            super(itemView);
            tvMessage = itemView.findViewById(R.id.tvMessage);// 绑定布局中的tvMessage控件
        }
    }

    // 机器人消息的ViewHolder，绑定item_chat_bot.xml中的控件
    static class BotViewHolder extends RecyclerView.ViewHolder {
        TextView tvMessage;// 显示消息内容的TextView
        BotViewHolder(View itemView) {
            super(itemView);
            tvMessage = itemView.findViewById(R.id.tvMessage);// 绑定布局中的tvMessage控件
        }
    }

    // 思考消息的ViewHolder 加的
    static class ThinkingViewHolder extends RecyclerView.ViewHolder {
        TextView tvMessage;
        ThinkingViewHolder(View itemView) {
            super(itemView);
            tvMessage = itemView.findViewById(R.id.tvMessage);
        }
    }

}