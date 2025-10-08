一个基于 Android 的 AI 智能聊天应用，提供流畅、智能的对话体验。

## 📱 项目简介

StardustChat 是一款现代化的 Android 聊天应用，集成了先进的 AI 技术，为用户提供智能、个性化的对话体验。应用采用 Material Design 设计语言，拥有直观的用户界面和丰富的功能特性。

## ✨ 主要特性

- 🤖 **AI 智能对话**: 集成先进的 AI 技术，提供自然流畅的对话体验
- 💬 **实时聊天**: 支持即时消息发送和接收
- 📚 **聊天历史**: 完整的聊天记录管理，支持历史对话查看
- 🎨 **现代化 UI**: 采用 Material Design 设计，界面美观易用
- 📱 **响应式设计**: 适配不同屏幕尺寸的 Android 设备
- 🗂️ **侧边栏导航**: 便捷的导航抽屉，快速访问各项功能
- 💾 **本地存储**: 使用 Room 数据库本地存储聊天记录
- 📋 **消息操作**: 支持消息复制等操作功能
- 🕒 **时间分组**: 智能的聊天历史时间分组（今天、昨天、本周、更早）

## 🛠️ 技术栈

- **开发语言**: Java
- **平台**: Android
- **架构**: MVVM 架构模式
- **UI 框架**: Material Design Components
- **数据库**: Room Database
- **网络请求**: OkHttp3
- **数据解析**: JSON
- **版本控制**: Git


基本功能
开始对话

在输入框中输入消息
点击发送按钮或按回车键
AI 将自动回复您的消息
查看历史记录

点击左上角菜单按钮打开侧边栏
浏览按时间分组的聊天历史
点击任意历史记录继续对话
消息操作

长按消息可复制内容
支持文本选择和分享
核心类说明
MainActivity: 应用主界面，处理用户交互和 AI 对话
ChatMessage: 消息数据模型，定义消息类型和属性
ChatAdapter: RecyclerView 适配器，管理聊天消息显示
ChatHistory: 聊天历史数据模型，管理会话记录
HistoryAdapter: 历史记录适配器，展示聊天历史列表
🔧 配置说明
AI 服务配置
应用使用 HTTP API 与 AI 服务通信，您可能需要：

配置 API 端点
设置访问密钥
调整请求超时参数
数据库配置
应用使用 Room 数据库存储聊天数据：

消息表：chat_message
历史表：chat_history
🤝 贡献指南
欢迎贡献代码！请遵循以下步骤：

Fork 本项目
创建您的特性分支 (git checkout -b feature/AmazingFeature)
提交您的更改 (git commit -m 'Add some AmazingFeature')
推送到分支 (git push origin feature/AmazingFeature)
打开一个 Pull Request
代码规范
遵循 Java 编码规范
添加适当的注释
确保代码通过所有测试

📋 版本历史
v1.0 (当前版本)
✅ 基础 AI 聊天功能
✅ 聊天历史管理
✅ Material Design UI
✅ 本地数据存储
✅ 消息复制功能
