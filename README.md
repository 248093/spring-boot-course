# Spring Boot 学习路线图与资源汇总

> 作者：你的昵称  
> 日期：2025-09-03  
> 版本：v1.0

---

## 1. Spring Boot 是什么？

- **官方定义**：Spring Boot 是基于 Spring Framework 的开源框架，用于快速构建「**生产级别**」的独立、可运行的 Spring 应用。
- **核心目标**：
    - 约定优于配置（Convention over Configuration）
    - 开箱即用（Out-of-the-box）
    - 零 XML（Minimal XML）
- **主要特性**：
    - 内嵌 Web 服务器（Tomcat / Jetty / Undertow）
    - 自动装配（`@EnableAutoConfiguration`）
    - Starter 依赖管理
    - 生产级监控（Actuator）
    - 热部署（DevTools）

---

## 2. 环境准备

| 工具 | 推荐版本 | 说明 |
|---|---|---|
| JDK | 17+ | Spring Boot 3.x 起最低支持 Java 17 |
| Maven | 3.8+ 或 Gradle 7.5+ | 二选一 |
| IDE | IntelliJ IDEA / VS Code / Eclipse | ❗IDEA 社区版即可 |
| 操作系统 | Windows / macOS / Linux | 跨平台 |

### 检验命令
```bash
java -version
mvn -v