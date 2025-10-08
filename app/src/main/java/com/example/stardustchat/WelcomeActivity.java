package com.example.stardustchat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

public class WelcomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    // 导航控件
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private ActionBarDrawerToggle toggle;

    // 输入控件
    private EditText welcomeMessageInput;
    private Button welcomeSendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // 初始化控件
        initViews();
        setupToolbar();//设置导航栏
        setupNavigationDrawer();//设置导航抽屉
        setupInputComponents();//设置发送控件
    }

    private void initViews() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        welcomeMessageInput = findViewById(R.id.welcomeMessageInput);
        welcomeSendButton = findViewById(R.id.welcomeSendButton);
    }

    /**
     * 设置顶部工具栏
     */
    private void setupToolbar() {
        setSupportActionBar(toolbar);// 设置为activity的actionbar
        if (getSupportActionBar() != null) {// 判断actionbar是否可用
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);// 显示返回按钮
            getSupportActionBar().setDisplayShowTitleEnabled(false);// 关闭系统标题显示
        }
    }

    /**
     * 设置抽屉导航菜单
     */
    private void setupNavigationDrawer() {
        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);// 创建抽屉开关
        drawerLayout.addDrawerListener(toggle);// 添加开关监听
        toggle.syncState();// 同步开关状态

        navigationView.setNavigationItemSelectedListener(this);// 设置菜单项点击监听
        navigationView.setCheckedItem(R.id.nav_current_chat);// 默认选中当前聊天
    }

    /**
     * 设置输入和发送消息相关控件
     */
    private void setupInputComponents() {
        // 发送按钮点击事件
        welcomeSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = welcomeMessageInput.getText().toString().trim();// 获取输入内容
                if (!TextUtils.isEmpty(message)) {// 判断输入是否为空
                    startChatWithMessage(message);// 启动聊天页面并传递消息
                } else {
                    Toast.makeText(WelcomeActivity.this, "请输入消息", Toast.LENGTH_SHORT).show();// 提示输入
                }
            }
        });

        // 输入框回车事件（可选）
        welcomeMessageInput.setOnEditorActionListener((v, actionId, event) -> {
            String message = welcomeMessageInput.getText().toString().trim();// 获取输入内容
            if (!TextUtils.isEmpty(message)) {// 判断输入是否为空
                startChatWithMessage(message);// 启动聊天页面
                return true;// 消费事件
            }
            return false;// 不处理事件
        });
    }

    /**
     * 跳转到聊天页面并传递消息
     * @param message 用户输入的消息
     */
    private void startChatWithMessage(String message) {
        Intent intent = new Intent(this, MainActivity.class);// 创建跳转intent
        intent.putExtra("first_message", message);// 添加消息参数
        startActivity(intent);// 启动MainActivity
        // 可选：清空输入框
        welcomeMessageInput.setText("");
    }

    /**
     * 处理导航菜单项点击事件
     * param item 被点击的菜单项
     * return 是否消费事件
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();// 获取菜单项ID

        Intent intent = new Intent(this, MainActivity.class);// 用于跳转聊天页的Intent

        if (id == R.id.nav_current_chat) {// 当前聊天
            startActivity(intent);// 跳转聊天页
        } else if (id == R.id.nav_today) {//今日聊天
            Toast.makeText(this, "跳转到聊天页面", Toast.LENGTH_SHORT).show();
            startActivity(intent);//跳转聊天页面
        } else if (id == R.id.nav_yesterday) {// 昨日聊天
            Toast.makeText(this, "跳转到聊天页面", Toast.LENGTH_SHORT).show();
            startActivity(intent);//跳转聊天页面
        } else if (id == R.id.nav_this_week) {// 本周聊天
            Toast.makeText(this, "跳转到聊天页面", Toast.LENGTH_SHORT).show();
            startActivity(intent);//跳转聊天页面
        } else if (id == R.id.nav_older) {// 更早聊天
            Toast.makeText(this, "跳转到聊天页面", Toast.LENGTH_SHORT).show();
            startActivity(intent);//跳转聊天页面
        } else if (id == R.id.nav_settings) {// 设置
            showSettings();// 显示设置
            drawerLayout.closeDrawer(GravityCompat.START);// 关闭抽屉
            return true;// 事件已消费
        } else if (id == R.id.nav_theme) {// 主题设置
            showThemeSettings();// 显示主题设置
            drawerLayout.closeDrawer(GravityCompat.START);// 关闭抽屉
            return true;
        } else if (id == R.id.nav_about) {// 关于
            showAbout();
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }

        drawerLayout.closeDrawer(GravityCompat.START); // 关闭抽屉
        return true;
    }

    /**
     * 显示设置（暂未实现）
     */
    private void showSettings() {
        Toast.makeText(this, "设置功能开发中...", Toast.LENGTH_SHORT).show();
    }

    /**
     * 显示主题设置（暂未实现）
     */
    private void showThemeSettings() {
        Toast.makeText(this, "主题设置开发中...", Toast.LENGTH_SHORT).show();
    }

    /**
     * 显示关于对话框
     */
    private void showAbout() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("关于 StardustChat");// 设置标题
        builder.setMessage("StardustChat v1.0\n\n一个基于AI的智能聊天应用\n\n开发者：Gemmj");// 设置内容
        builder.setPositiveButton("确定", null);// 设置按钮
        builder.show();// 显示对话框
    }

    /**
     * 返回键逻辑：如果抽屉打开则关闭抽屉，否则执行默认操作
     */
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {// 如果抽屉已打开
            drawerLayout.closeDrawer(GravityCompat.START);// 关闭抽屉
        } else {
            super.onBackPressed();// 否则执行父类的返回逻辑
        }
    }
}